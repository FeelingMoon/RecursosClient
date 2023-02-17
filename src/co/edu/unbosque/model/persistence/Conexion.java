package co.edu.unbosque.model.persistence;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Conexion extends Thread {
	private Socket socket;
	private ServerSocket server;
	private Scanner sn;
	private DataOutputStream out;
	private DataInputStream in; // Input stream from server
	private String address;
	private int port;

	// constructor to put ip address and port
	public Conexion(String address, int port) {
		// initialize socket and input output streams
		this.socket = null;
		this.server = null;
		this.sn = new Scanner(System.in);
		this.out = null;
		this.address = address;
		this.port = port;
	}

	@Override
	public void run() {

		// string to read message from input
		String line = "";

		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			// establish a connection
			try {
				this.socket = new Socket(this.address, this.port);
				System.out.println("Connected");

				// sends output to the socket
				this.out = new DataOutputStream(socket.getOutputStream());

				// line = this.input.readLine();
				line = enviarInfo("");
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
				crearCandidato(in.readUTF());
				this.in.close();
				this.server.close();
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		// close the connection
		try {
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}

	}

	public String enviarInfo(String msm) {
		return sn.next();
	}

	public void crearCandidato(String msm) {
		System.out.println(msm);
	}

	public static void main(String args[]) {
		// Servidor server = new Servidor(64000);
		Conexion client = new Conexion("127.0.0.1", 64000);
		client.start();
	}
}
