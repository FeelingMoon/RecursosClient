package co.edu.unbosque.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import co.edu.unbosque.model.CandidatosDAO;
import co.edu.unbosque.view.Busqueda;
import co.edu.unbosque.view.Crear;
import co.edu.unbosque.view.Eliminar;
import co.edu.unbosque.view.Encontrado;
import co.edu.unbosque.view.Lista;
import co.edu.unbosque.view.Modificar;
import co.edu.unbosque.view.PopUp;
import co.edu.unbosque.view.Principal;

/**
 * Class that acts as an intermediary between the model and the view
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class Controller implements MouseListener, MouseMotionListener {
	private Principal principal;
	private Crear crear;
	private Busqueda busqueda, busqueEliminar, busquedaEncotrado;
	private Modificar modificar;
	private Eliminar eliminar;
	private Encontrado encontrado;
	private Lista lista;
	private int xmouse, ymouse;
	private CandidatosDAO candidatos;
//	private KeyListener keyNumeros, keyLetras;

	/**
	 * Constructor method
	 */
	public Controller() {
		candidatos = new CandidatosDAO();
		candidatos.start();
		principal = new Principal(this, this);
		crear = new Crear(this, this);
		busqueda = new Busqueda(this, this);
		modificar = new Modificar(this, this);
		eliminar = new Eliminar(this, this);
		encontrado = new Encontrado(this, this);
		busquedaEncotrado = new Busqueda(this, this);
		busqueEliminar = new Busqueda(this, this);
		lista = new Lista(this, this);
//		principal.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			principal.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(crear.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			crear.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(busqueda.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			busqueda.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(modificar.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			modificar.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(eliminar.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			eliminar.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			busqueEliminar.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			busquedaEncotrado.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(encontrado.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			encontrado.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(lista.obtenerLB(0))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			lista.ubicacion((x - xmouse), (y - ymouse));
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			System.exit(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			principal.setVisible(false);
			crear.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			principal.setVisible(false);
			busqueda.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			principal.setVisible(false);
			busqueEliminar.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			principal.setVisible(false);
//			lista.rellenarInfo(candidatos.listar());
			lista.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			principal.setVisible(false);
			busquedaEncotrado.setVisible(true);
		} else if (e.getSource().equals(crear.obtenerLB(1))) {
			if (!crear.obtenerTextos().equals("0001")) {
//				candidatos.ingresar(crear.getNombre(), crear.getApellido(), crear.getCedula(), crear.getEdad(),
//						crear.getCargo());
//				PopUp.mostrarMensaje("Aspirante ingresado exitosamente.");
				crear.setVisible(false);
				crear.limpiar();
				principal.setVisible(true);
			} else {
				PopUp.mostrarMensaje("Error al ingresar algun valor, por favor revisar e intentar nuevamente.");
			}
		} else if (e.getSource().equals(crear.obtenerLB(2))) {
			crear.setVisible(false);
			crear.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(busqueda.obtenerLB(1))) {
			busqueda.setVisible(false);
			try {
//				CandidatosDTO tmp = candidatos.buscar(Integer.parseInt(busqueda.obtenerTextos()));
//				if (tmp != null) {
//					modificar.darTextos(tmp.getNombre(), tmp.getApellido(), tmp.getCedula() + "", tmp.getEdad(),
//							tmp.getCargos());
//					modificar.setVisible(true);
//					busqueda.limpiar();
//				} else {
//					PopUp.mostrarMensaje("Aspirante no encontrado, intente nuevamente");
//					busqueda.setVisible(true);
//				}
			} catch (Exception e2) {
				PopUp.mostrarMensaje("Error al ingresar algun valor, por favor revisar e intentar nuevamente.");
				busqueda.setVisible(true);
			}
		} else if (e.getSource().equals(busqueda.obtenerLB(2))) {
			busqueda.setVisible(false);
			busqueda.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(modificar.obtenerLB(1))) {
//			if (!modificar.obtenerTextos().equals("0001")) {
//				candidatos.modificar(modificar.getNombre(), modificar.getApellido(), modificar.getCedula(),
//						modificar.getEdad(), modificar.getCargo());
//				PopUp.mostrarMensaje("Aspirante actualizado exitosamente.");
//				modificar.setVisible(false);
//				modificar.limpiar();
//				principal.setVisible(true);
//			} else {
//				PopUp.mostrarMensaje("Error al ingresar algun valor, por favor revisar e intentar nuevamente.");
//			}
		} else if (e.getSource().equals(modificar.obtenerLB(2))) {
			modificar.setVisible(false);
			modificar.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(1))) {
//			busqueEliminar.setVisible(false);
//			try {
//				CandidatosDTO tmp = candidatos.buscar(Integer.parseInt(busqueEliminar.obtenerTextos()));
//				if (tmp != null) {
//					eliminar.rellenarInfo(tmp.getNombre(), tmp.getApellido(), tmp.getCedula() + "", tmp.getEdad(),
//							tmp.getCargos());
//					eliminar.setVisible(true);
//				} else {
//					PopUp.mostrarMensaje("Aspirante no encontrado, intente nuevamente");
//					busqueEliminar.setVisible(true);
//				}
//			} catch (Exception e2) {
//				PopUp.mostrarMensaje("Error al ingresar algun valor, por favor revisar e intentar nuevamente.");
//				busqueEliminar.setVisible(true);
//			}
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(2))) {
			busqueEliminar.setVisible(false);
			busqueEliminar.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(eliminar.obtenerLB(1))) {
//			candidatos.eliminar(Integer.parseInt(busqueEliminar.obtenerTextos()));
//			PopUp.mostrarMensaje("Aspirante eliminado exitosamente.");
//			eliminar.setVisible(false);
//			busqueEliminar.limpiar();
//			eliminar.limpiar();
//			principal.setVisible(true);
		} else if (e.getSource().equals(eliminar.obtenerLB(2))) {
			eliminar.setVisible(false);
			busqueEliminar.limpiar();
			eliminar.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(1))) {
			busquedaEncotrado.setVisible(false);
//			try {
//				CandidatosDTO tmp = candidatos.buscar(Integer.parseInt(busquedaEncotrado.obtenerTextos()));
//				if (tmp != null) {
//					encontrado.rellenarInfo(tmp.getNombre(), tmp.getApellido(), tmp.getCedula() + "", tmp.getEdad(),
//							tmp.getCargos());
//					encontrado.setVisible(true);
//				} else {
//					PopUp.mostrarMensaje("Aspirante no encontrado, intente nuevamente");
//					busquedaEncotrado.setVisible(true);
//				}
//			} catch (Exception e2) {
//				PopUp.mostrarMensaje("Error al ingresar algun valor, por favor revisar e intentar nuevamente.");
//				busquedaEncotrado.setVisible(true);
//			}
			busquedaEncotrado.limpiar();
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(2))) {
			busquedaEncotrado.setVisible(false);
			busquedaEncotrado.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(encontrado.obtenerLB(1))) {
			encontrado.setVisible(false);
			encontrado.limpiar();
			principal.setVisible(true);
		} else if (e.getSource().equals(lista.obtenerLB(1))) {
			lista.setVisible(false);
			lista.limpiar();
			principal.setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(crear.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(busqueda.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(modificar.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(eliminar.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(encontrado.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(lista.obtenerLB(0))) {
			xmouse = e.getX();
			ymouse = e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			principal.interiorColor(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			principal.interiorColor(2);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			principal.interiorColor(3);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			principal.interiorColor(4);
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			principal.interiorColor(5);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			principal.interiorColor(6);
		} else if (e.getSource().equals(crear.obtenerLB(1))) {
			crear.interiorColor(1);
		} else if (e.getSource().equals(crear.obtenerLB(2))) {
			crear.interiorColor(2);
		} else if (e.getSource().equals(busqueda.obtenerLB(1))) {
			busqueda.interiorColor(1);
		} else if (e.getSource().equals(busqueda.obtenerLB(2))) {
			busqueda.interiorColor(2);
		} else if (e.getSource().equals(modificar.obtenerLB(1))) {
			modificar.interiorColor(1);
		} else if (e.getSource().equals(modificar.obtenerLB(2))) {
			modificar.interiorColor(2);
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(1))) {
			busqueEliminar.interiorColor(1);
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(2))) {
			busqueEliminar.interiorColor(2);
		} else if (e.getSource().equals(eliminar.obtenerLB(1))) {
			eliminar.interiorColor(1);
		} else if (e.getSource().equals(eliminar.obtenerLB(2))) {
			eliminar.interiorColor(2);
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(1))) {
			busquedaEncotrado.interiorColor(1);
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(2))) {
			busquedaEncotrado.interiorColor(2);
		} else if (e.getSource().equals(encontrado.obtenerLB(1))) {
			encontrado.interiorColor(1);
		} else if (e.getSource().equals(lista.obtenerLB(1))) {
			lista.interiorColor(1);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			principal.exteriorColor(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			principal.exteriorColor(2);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			principal.exteriorColor(3);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			principal.exteriorColor(4);
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			principal.exteriorColor(5);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			principal.exteriorColor(6);
		} else if (e.getSource().equals(crear.obtenerLB(1))) {
			crear.exteriorColor(1);
		} else if (e.getSource().equals(crear.obtenerLB(2))) {
			crear.exteriorColor(2);
		} else if (e.getSource().equals(busqueda.obtenerLB(1))) {
			busqueda.exteriorColor(1);
		} else if (e.getSource().equals(busqueda.obtenerLB(2))) {
			busqueda.exteriorColor(2);
		} else if (e.getSource().equals(modificar.obtenerLB(1))) {
			modificar.exteriorColor(1);
		} else if (e.getSource().equals(modificar.obtenerLB(2))) {
			modificar.exteriorColor(2);
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(1))) {
			busqueEliminar.exteriorColor(1);
		} else if (e.getSource().equals(busqueEliminar.obtenerLB(2))) {
			busqueEliminar.exteriorColor(2);
		} else if (e.getSource().equals(eliminar.obtenerLB(1))) {
			eliminar.exteriorColor(1);
		} else if (e.getSource().equals(eliminar.obtenerLB(2))) {
			eliminar.exteriorColor(2);
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(1))) {
			busquedaEncotrado.exteriorColor(1);
		} else if (e.getSource().equals(busquedaEncotrado.obtenerLB(2))) {
			busquedaEncotrado.exteriorColor(2);
		} else if (e.getSource().equals(encontrado.obtenerLB(1))) {
			encontrado.exteriorColor(1);
		} else if (e.getSource().equals(lista.obtenerLB(1))) {
			lista.exteriorColor(1);
		}

	}

}
