package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * File management class
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class FileHandler {

	/**
	 * Method in charge of giving the properties of the texts
	 * 
	 * @return Propiedades
	 */
	public static Properties loadPropities() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("src/co/edu/unbosque/model/persistence/spa.properties")));
		} catch (FileNotFoundException e) {
			System.err.println("No se puede leer el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("No se puede leer el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return p;

	}
}
