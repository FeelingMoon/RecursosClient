package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Class in charge of the home of the windows concerning the search of an
 * applicant.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 */
@SuppressWarnings("serial")
public class Principal extends JFrame {
	private JPanel ventanaI;
	private JPanel botones;
	private JLabel salir;
	private JLabel fantasma;
	private JLabel crear;
	private JLabel modificar;
	private JLabel eliminar;
	private JLabel listar;
	private JLabel buscar;
	private JLabel imagen;
	private ArrayList<JLabel> bots;
	private Font fuente;
	private Properties properties;
	private Color pr, sc;

	/**
	 * Method in charge of initializing the parameters of the window, as well as
	 * receiving the parameters related to the mouse..
	 * 
	 * @param mouse  In charge of handling mouse related issues.
	 * @param motion In charge of managing the movement (drag) of the mouse.
	 */
	public Principal(MouseListener mouse, MouseMotionListener motion) {
		properties = FileHandler.loadPropities();
		pr = new Color(255, 0, 56);
		sc = new Color(62, 0, 13);
		//
		fuente = new Font("Tahoma", 0, 20);
		ventanaI = new JPanel();
		crear = new JLabel(properties.getProperty("persistence.boton.crear"), SwingConstants.CENTER);
		modificar = new JLabel((properties.getProperty("persistence.boton.modificar")), SwingConstants.CENTER);
		eliminar = new JLabel((properties.getProperty("persistence.boton.eliminar")), SwingConstants.CENTER);
		listar = new JLabel((properties.getProperty("persistence.boton.listar")), SwingConstants.CENTER);
		buscar = new JLabel((properties.getProperty("persistence.boton.buscar")), SwingConstants.CENTER);
		salir = new JLabel("X", SwingConstants.CENTER);
		fantasma = new JLabel((properties.getProperty("persistence.titulo")), SwingConstants.CENTER);
		botones = new JPanel();
		imagen = new JLabel();
		bots = new ArrayList<JLabel>();
		//
		bots.add(salir);
		bots.add(fantasma);
		bots.add(crear);
		bots.add(modificar);
		bots.add(eliminar);
		bots.add(listar);
		bots.add(buscar);
		//
		salir.setOpaque(true);
		salir.setForeground(Color.WHITE);
		salir.setBackground(sc);
		salir.setFont(fuente.deriveFont(Font.BOLD, 20));
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setBounds(550, 0, 50, 50);
		salir.addMouseListener(mouse);
		fantasma.setOpaque(true);
		fantasma.setBackground(sc);
		fantasma.setBounds(0, 0, 600, 50);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(motion);
		fantasma.setForeground(Color.WHITE);
		fantasma.setFont(fuente);
		//
		botones.setBounds(0, 340, 600, 60);
		botones.setLayout(new GridLayout(1, 5));
		//
		crear.setOpaque(true);
		crear.setBackground(pr);
		crear.setForeground(Color.WHITE);
		crear.setFont(fuente);
		crear.addMouseListener(mouse);
		crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		crear.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(crear);
		modificar.setOpaque(true);
		modificar.setBackground(pr);
		modificar.setForeground(Color.WHITE);
		modificar.setFont(fuente);
		modificar.addMouseListener(mouse);
		modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		modificar.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(modificar);
		eliminar.setOpaque(true);
		eliminar.setBackground(pr);
		eliminar.setForeground(Color.WHITE);
		eliminar.setFont(fuente);
		eliminar.addMouseListener(mouse);
		eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		eliminar.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(eliminar);
		listar.setOpaque(true);
		listar.setBackground(pr);
		listar.setForeground(Color.WHITE);
		listar.setFont(fuente);
		listar.addMouseListener(mouse);
		listar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		listar.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(listar);
		buscar.setOpaque(true);
		buscar.setBackground(pr);
		buscar.setForeground(Color.WHITE);
		buscar.setFont(fuente);
		buscar.addMouseListener(mouse);
		buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buscar.setBorder(new MatteBorder(2, 2, 2, 2, sc));
		botones.add(buscar);
		//
		imagen.setBounds(-50, 50, 650, 400);
		imagen.setIcon(new ImageIcon("src/co/edu/unbosque/util/img.gif"));
		//
		this.setSize(600, 400);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventanaI.setBackground(Color.WHITE);
		ventanaI.setLayout(null);
		ventanaI.setSize(this.getSize());
		ventanaI.add(salir);
		ventanaI.add(fantasma);
		ventanaI.add(botones);
		ventanaI.add(imagen);
		this.add(ventanaI);
		//
	}

	/**
	 * Method in charge of giving the labels (buttons) to give them their use.
	 * 
	 * @param x The label to give.
	 * @return The requested label.
	 */
	public JLabel obtenerLB(int x) {
		return bots.get(x);
	}

	/**
	 * Method that changes the color of the label when the mouse pointer passes over
	 * it.
	 * 
	 * @param x The label to change the color.
	 */
	public void interiorColor(int x) {
		if (x == 0) {
			salir.setBackground(Color.WHITE);
			salir.setForeground(Color.RED);
		} else {
			bots.get(x).setBackground(sc);
		}
	}

	/**
	 * Method that changes the color of the label when the mouse pointer leaves the
	 * label.
	 * 
	 * @param x The label to change the color.
	 */
	public void exteriorColor(int x) {
		if (x == 0) {
			salir.setBackground(sc);
			salir.setForeground(Color.WHITE);
		} else {
			bots.get(x).setBackground(pr);
		}
	}

	/**
	 * Method that takes care of changing the location of the window.
	 * 
	 * @param x Location on the x-axis.
	 * @param y Location on the y-axis.
	 */
	public void ubicacion(int x, int y) {
		this.setLocation(x, y);

	}

}
