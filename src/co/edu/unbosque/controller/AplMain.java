package co.edu.unbosque.controller;

/**
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class AplMain {

	/**
	 * Method where the program starts
	 * 
	 * @param args Arguments to start the program
	 */
	public static void main(String[] args) {
		Controller c = new Controller("127.0.0.1", 5000);
		c.start();
	}

}
