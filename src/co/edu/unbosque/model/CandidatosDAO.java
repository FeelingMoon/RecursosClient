package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Conexion;

/**
 * Interface in charge of modeling the class in charge of managing the
 * information of the applicants
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class CandidatosDAO {
	// implements CandidatosDAO
	private Conexion con;

	public CandidatosDAO() {
		con = new Conexion("127.0.0.1", 5003);
		con.start();
	}

	public String obtenerConfirm() {
		while (true) {
			String tmp = con.getResponse();
			System.out.println(tmp);
			if (!tmp.equals("")) {
				if (tmp.equals("wrong")) {
					return "ext";
				} else if (tmp.equals("fail")) {
					return "false";
				} else if (tmp.equals("ok")) {
					return "true";
				} else {
					return tmp;
				}
			}
		}
	}

	public String ingresar(String nombre, String apellido, int cedula, int edad, String cargos) {
		con.setMensaje("crear-" + nombre + "-" + apellido + "-" + cedula + "-" + edad + "-" + cargos);
		return obtenerConfirm();
	}

	public String modificar(String nombre, String apellido, int cedula, int edad, String cargos) {
		con.setMensaje("modificar-" + nombre + "-" + apellido + "-" + cedula + "-" + edad + "-" + cargos);
		return obtenerConfirm();
	}

	public String eliminar(int cedula) {
		con.setMensaje("eliminar-" + cedula);
		return obtenerConfirm();
	}

	public String listar() {
		con.setMensaje("listar");
		return obtenerConfirm();
	}

	public String buscar2(int nombre) {
		con.setMensaje("buscar2-" + nombre);
		return obtenerConfirm();
	}

	public String buscar1(int nombre) {
		con.setMensaje("buscar1-" + nombre);
		return obtenerConfirm();
	}

	public void cerrar() {
		con.setMensaje("Over");
	}

}