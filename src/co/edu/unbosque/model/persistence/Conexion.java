package co.edu.unbosque.model.persistence;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion extends Thread {
	private Socket socket;
	private ServerSocket server;
	private DataOutputStream out;
	private DataInputStream in; // Input stream from server
	private String address, inf, line, mensaje;
	private int port;
	private boolean confErr;

	// constructor to put ip address and port
	public Conexion(String address, int port) {
		// initialize socket and input output streams
		this.socket = null;
		this.server = null;
		this.out = null;
		this.address = address;
		this.port = port;
		this.inf = "";
		this.line = "";
		this.mensaje = "";
		this.confErr = false;
	}

	@Override
	public void run() {
		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			// establish a connection
			try {
				this.socket = new Socket(this.address, this.port);
				// sends output to the socket
				this.out = new DataOutputStream(socket.getOutputStream());
				if (!confErr) {
					line = this.getMensaje();
				}
				confErr = false;
				this.out.writeUTF(line);
				// close socket and output stream
				this.out.close();
				this.socket.close();
				// Create a serverSocket to wait message from server
				this.server = new ServerSocket(this.port + 1);
				this.socket = server.accept();
				// takes input from the client socket
				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				// Print in server the client message
				setResponse(in.readUTF());
				this.in.close();
				this.server.close();
			} catch (IOException i) {
				if (i.getMessage().equalsIgnoreCase("Connection reset by peer")) {
					confErr = true;
				} else {
					setResponse("wrong");
				}
				System.out.println("SIN SERVER");
			}
		}
		// close the connection
		try {
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i.toString());
			System.exit(0);
		}

	}

	public synchronized String getMensaje() {
		if (mensaje.equalsIgnoreCase("")) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		String tmp = mensaje + "";
		mensaje = "";
		return tmp;
	}

	public synchronized void setMensaje(String msm) {
		mensaje = msm;
		try {
			notify();
		} catch (Exception e) {
		}
	}

	public synchronized String getResponse() {
		String tmp = inf + "";
		inf = "";
		return tmp;
	}

	public void setResponse(String msm) {
		inf = msm;
	}
}
