/**
 * Cñase que pertenece al paquete model
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidatosDTO;
/**
 * Clase encargada de el acceso a datos
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */
public class CandidatosDAO {
	
	private Archivo archivo;
	/**
	 * Metodo Constructor
	 */
	public CandidatosDAO(Archivo archivo) {
		this.archivo = archivo;
	}
	
	/**
	 * Metodo para agregar candidatos a la lista
	 * 
	 */
	public void agregarCandidatos(String nombre, String apellido, String cedula, int edad, String cargo, ArrayList<CandidatosDTO> lista) {
		
		CandidatosDTO agragar = new CandidatosDTO(nombre, apellido, cedula, edad, cargo);
		lista.add(agragar);
		archivo.escribirArchivo(lista);
		JOptionPane.showMessageDialog(null, "Candidato agregado con cedula : "+cedula);
		
	}
	
	/**
	 * Metodo para ver candidatos de la lista
	 * @return texto
	 */
	public String verCandidatos() {
		ArrayList<CandidatosDTO> candidatos = archivo.leerArchivo();
		String texto  ="";
		for (int i = 0; i < candidatos.size(); i++) {
			texto = texto.concat(candidatos.get(i).toString()+"\n");
		}
		return "Candidatos: \n"+texto;
	}
	/**
	 * 
	 * @param cedula
	 * @param lista
	 * @return encontrado
	 */
	public CandidatosDTO buscarCandidatos(String cedula, ArrayList<CandidatosDTO> lista) {
		CandidatosDTO encontrado=null;
		if(!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCedula().equals(cedula)) {
					encontrado = lista.get(i);
					return encontrado;
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay candidatos ");
		}
		return encontrado;
	}
	
	/**
	 * Metodo para eliminar candidatos de la lista
	 * @param cedula
	 * @param lista
	 */
	public void eliminarCandidatos(String cedula, ArrayList<CandidatosDTO> lista) {
		
		if(buscarCandidatos(cedula, lista)!=null) {
			try {
				CandidatosDTO candidato = buscarCandidatos(cedula, lista);
				lista.remove(candidato);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirArchivo(lista);
				JOptionPane.showMessageDialog(null, "Candidato eliminado con cedula : "+cedula);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No exite un candidato con la cedula : "+cedula);
		}
		
	}
	
	/**
	 * Metodo para modificar candidatos
	 * @param cedula1
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param edad
	 * @param cargo
	 * @param lista
	 */
	public void modificarCandidatos(String cedula1, String nombre, String apellido ,String cedula, int edad, String cargo, ArrayList<CandidatosDTO> lista) {
		
	if(buscarCandidatos(cedula, lista)!=null) {
			try {
				CandidatosDTO candidato = buscarCandidatos(cedula1, lista);
				lista.remove(candidato);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirArchivo(lista);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	} else {
		JOptionPane.showMessageDialog(null, "No exite un candidato con la cedula : "+cedula);
	}
		
		CandidatosDTO agragar = new CandidatosDTO(nombre, apellido, cedula, edad, cargo);
		lista.add(agragar);
		archivo.escribirArchivo(lista);
		
		JOptionPane.showMessageDialog(null, "Candidato modificado con cedula : "+cedula);
		
	}
	
	
}
