package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * Class in charge of the popUp of the windows concerning the creation of an
 * applicant.
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class PopUp {
	/**
	 * Method in charge of displaying a message in a popUp.
	 * 
	 * @param mensaje Message to display.
	 */
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "RECURSOS HUMANOS", JOptionPane.INFORMATION_MESSAGE);
	}
}
