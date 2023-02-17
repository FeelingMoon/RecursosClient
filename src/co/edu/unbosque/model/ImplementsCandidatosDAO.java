package co.edu.unbosque.model;

/**
 * Information management class
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class ImplementsCandidatosDAO implements CandidatosDAO {

	@Override
	public void ingresar(String nombre, String apellido, int cedula, int edad, String cargos) {
		candidatos.add(new CandidatosDTO(nombre, apellido, cedula, edad, cargos));
		guardar(candidatos);
	}

	@Override
	public boolean modificar(String nombre, String apellido, int cedula, int edad, String cargos) {
		for (int i = 0; i < candidatos.size(); i++) {
			if (candidatos.get(i).getCedula() == cedula) {
				candidatos.set(i, new CandidatosDTO(nombre, apellido, cedula, edad, cargos));
				guardar(candidatos);
				return true;
			}
		}
		return false;
	}

	@Override
	public void eliminar(int cedula) {
		for (int i = 0; i < candidatos.size(); i++) {
			if (candidatos.get(i).getCedula() == cedula) {
				candidatos.remove(i);
				guardar(candidatos);
				return;
			}
		}
	}

	@Override
	public CandidatosDTO buscar(int cedula) {
		for (int i = 0; i < candidatos.size(); i++) {
			if (candidatos.get(i).getCedula() == cedula) {
				return candidatos.get(i);
			}
		}
		return null;
	}

	@Override
	public String listar() {
		String tmp = "";
		for (int i = 0; i < candidatos.size(); i++) {
			tmp += candidatos.get(i).toString() + "\n";
		}
		return tmp;
	}

}
