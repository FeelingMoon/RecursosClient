package co.edu.unbosque.model;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.persistence.Conexion;

/**
 * Interface in charge of modeling the class in charge of managing the
 * information of the applicants
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class CandidatosDAO extends Thread {
	// implements CandidatosDAO
	private Conexion con;

	public CandidatosDAO() {
		this.setName("CandidatosDAO");
		con = new Conexion("127.0.0.1", 5000);
		con.start();
	}

	@Override
	public void run() {
		String tmp = "";
		while (!tmp.equals("Over")) {
			tmp = JOptionPane.showInputDialog("HOLA");
			con.setMensaje(tmp);
			System.out.println(con.getResponse());
		}
	}

//		@Override
//		public boolean ingresar(String nombre, String apellido, int cedula, int edad, String cargos) {
//			client.enviarInfo("crear-" + nombre + "-" + apellido + "-" + cedula + "-" + edad + "-" + cargos);
//		}
	//
//		@Override
//		public boolean modificar(String nombre, String apellido, int cedula, int edad, String cargos) {
//			for (int i = 0; i < candidatos.size(); i++) {
//				if (candidatos.get(i).getCedula() == cedula) {
//					candidatos.set(i, new CandidatosDTO(nombre, apellido, cedula, edad, cargos));
//					guardar(candidatos);
//					return true;
//				}
//			}
//			return false;
//		}
	//
//		@Override
//		public void eliminar(int cedula) {
//			for (int i = 0; i < candidatos.size(); i++) {
//				if (candidatos.get(i).getCedula() == cedula) {
//					candidatos.remove(i);
//					guardar(candidatos);
//					return;
//				}
//			}
//		}
	//
//		@Override
//		public CandidatosDTO buscar(int cedula) {
//			for (int i = 0; i < candidatos.size(); i++) {
//				if (candidatos.get(i).getCedula() == cedula) {
//					return candidatos.get(i);
//				}
//			}
//			return null;
//		}
	//
//		@Override
//		public String listar() {
//			String tmp = "";
//			for (int i = 0; i < candidatos.size(); i++) {
//				tmp += candidatos.get(i).toString() + "\n";
//			}
//			return tmp;
//		}

}