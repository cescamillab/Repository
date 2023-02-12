/* Clase que pertenece al paquete controller
*/
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidatosDTO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.CandidatosDAO;
import co.edu.unbosque.view.PrincipalWindow;

/**
 * Clase encargada de la funcionalidad logica del programa que implementa ActionListener
 * 
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */
public class Controller implements ActionListener{

	private PrincipalWindow window;
	private ArrayList<CandidatosDTO> candidatosDTO;
	private Archivo archivo;
	private CandidatosDAO candidatosDAO;
	private int option;
	
	/**
	 * Metodo Constructor
	 */
	public Controller() {
		window = new PrincipalWindow();
		assignListeners();
		candidatosDTO = new ArrayList<CandidatosDTO>();
		archivo = new Archivo();
		candidatosDAO = new CandidatosDAO(archivo);
		candidatosDTO = archivo.leerArchivo();
	}

	/**
	 * Metodo para asignar las funciones a cada boton
	 * 
	 */
	public void assignListeners() {
		window.getCreate().addActionListener(this);
		window.getRead().addActionListener(this);
		window.getUpdate().addActionListener(this);
		window.getDelete().addActionListener(this);
	}
	
	/**
	 * Metodo para crear la lista de tipo CandidatosDTO
	 * 
	 * @return the candidatosDTO
	 */
	public ArrayList<CandidatosDTO> getCandidatosDTO() {
		return candidatosDTO;
	}
	/**
	 * Metodo que funciona para realizar la modificación del nombre de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación del nombre.
	 */
	public void updateNombre(String cedula) {

		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if((getCandidatosDTO().get(i).getCedula().equals(cedula))) {
				String nombre = window.captureData("Ingrese el nuevo nombre del candidato: ", "nombre");
				String apellido = getCandidatosDTO().get(i).getApellido();
				int edad = getCandidatosDTO().get(i).getEdad();
				String cargo = getCandidatosDTO().get(i).getCargo();
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedula, edad, cargo, getCandidatosDTO());
			}
		}
		
	}
	/**
	 * Metodo que funciona para realizar la modificación del apellido de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación del apellido.
	 */
	public void updateApellido(String cedula) {
		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if(getCandidatosDTO().get(i).getCedula().equals(cedula)) {
				String apellido = window.captureData("Ingrese el nuevo apellido del candidato: ", "apelllido");
				String nombre = getCandidatosDTO().get(i).getNombre();
				int edad = getCandidatosDTO().get(i).getEdad();
				String cargo = getCandidatosDTO().get(i).getCargo();
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedula, edad, cargo, getCandidatosDTO());
			}
	    }		
	}
	/**
	 * Metodo que funciona para realizar la modificación de la cedula de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación de la nueva cedula.
	 */
	public void updateCedula(String cedula) {
		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if(!(getCandidatosDTO().get(i).getCedula().equals(cedula))) {
				String apellido = getCandidatosDTO().get(i).getApellido();
				String nombre = getCandidatosDTO().get(i).getNombre();
				int edad = getCandidatosDTO().get(i).getEdad();
				String cargo = getCandidatosDTO().get(i).getCargo();
				String cedulaNew = window.captureData("Ingrese la nueva cedula del candidato: ", "cedula");
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedulaNew, edad, cargo, getCandidatosDTO());
			}
	    }		
	}
	/**
	 * Metodo que funciona para realizar la modificación de la edad de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación de la edad.
	 */
	public void updateEdad(String cedula) {

		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if((getCandidatosDTO().get(i).getCedula().equals(cedula))){
				String apellido = getCandidatosDTO().get(i).getApellido();
				String nombre = getCandidatosDTO().get(i).getNombre();
				int edad = Integer.parseInt(window.captureData("Ingrese la nueva edad del candidato: ", "edad"));
				String cargo = getCandidatosDTO().get(i).getCargo();
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedula, edad, cargo, getCandidatosDTO());
			}
	    }		
	
	}
	/**
	 * Metodo que funciona para realizar la modificación del cargo de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación del cargo.
	 */
	public void updateCargo(String cedula) {

		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if((getCandidatosDTO().get(i).getCedula().equals(cedula))) {
				String apellido = getCandidatosDTO().get(i).getApellido();
				String nombre = getCandidatosDTO().get(i).getNombre();
				int edad = getCandidatosDTO().get(i).getEdad();
				String cargo = window.captureData("Ingrese el nuevo cargo del candidato: ", "cargo");
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedula, edad, cargo, getCandidatosDTO());
			}
	    }		
		
	}
	/**
	 * Metodo que funciona para realizar la modificación de toda la informcaaión de un candidato
	 * <b>pre<b> Tener cedula para ver si esta el candidato
	 * <b>post<b> Realizar modificación del contacto si existe
	 * 
	 * @param cedula Cedula para realizar la modificación del candidato.
	 */
	public void updateTodo(String cedula) {

		for (int i = 0; i < getCandidatosDTO().size(); i++) {
			if((getCandidatosDTO().get(i).getCedula().equals(cedula))) {
				String nombre = window.captureData("Ingrese el nuevo nombre del candidato: ", "nombre");
				String apellido = window.captureData("Ingrese el nuevo apellido del candidato: ", "apelllido");
				String cedulaNew = window.captureData("Ingrese la nueva cedula del candidato: ", "cedula");
				int edad = Integer.parseInt(window.captureData("Ingrese la nueva edad del candidato: ", "edad"));
				String cargo = window.captureData("Ingrese el nuevo cargo del candidato: ", "cargo");
				candidatosDAO.modificarCandidatos(cedula, nombre, apellido, cedulaNew, edad, cargo, getCandidatosDTO());
			}
	    }		
	
	}
	
	/**
	 * Metodo que funciona para accionar comandos a los botones 
	 * <b>pre<b> Que el comando este bien escrito 
	 * <b>post<b> Hace lo que tenga el comando
	 * 
	 * @param ActionEvent
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("CREATE")) {
			String nombre = window.captureData("Ingrese el nombre del candidato: ", "nombre");
			String apellido = window.captureData("Ingrese el apellido del candidato: ", "apellido");
			String cedula = window.captureData("Ingrese la cedula del candidato: ", "cedula");
			int edad = Integer.parseInt(window.captureData("Ingrese la edad del candidato", "edad"));
			String cargo = window.captureData("Ingrese el cargo del candidato: ", "cargo");
			candidatosDAO.agregarCandidatos(nombre, apellido, cedula, edad, cargo, getCandidatosDTO());
		}
		
		if (command.equals("READ")) {
			
			String [] botons = {"Ver todos los candidatos","Buscar un candidato"};
			option = JOptionPane.showOptionDialog(null, " ", " ", 0, JOptionPane.QUESTION_MESSAGE, null, botons, botons);
			
			if(option == 1) {
				String cedula = window.captureData("Ingrese la cedula del candidato que busca: ", "cedula");
				if(candidatosDAO.buscarCandidatos(cedula, getCandidatosDTO())!=null) {
					window.mostrarMensaje(""+candidatosDAO.buscarCandidatos(cedula, getCandidatosDTO()), "");
				} else {
					window.mostrarMensaje("No existe un candidato con cedula "+cedula, "");
				}
				
			} else {
				window.mostrarMensaje(candidatosDAO.verCandidatos(), "");
			}
		}
		
		if (command.equals("UPDATE")) {
				
			String cedula = window.captureData("Ingrese la cedula del candidato que desea modificar: ", "cedula");
			int hay=0;
			
			for (int i = 0; i < getCandidatosDTO().size(); i++) {
				if((getCandidatosDTO().get(i).getCedula().equals(cedula))) {
					hay=1;
					
					}else {
						hay=0;
				}
			}
			
			if(hay==1) {
				String [] botons = {"nombre","apellido","cedula","edad","cargo","todo"};
				option = JOptionPane.showOptionDialog(null, "Que desea modificar del candidato: ", " ", 0, JOptionPane.QUESTION_MESSAGE, null, botons, botons);
			}else {
				window.mostrarMensaje("No exite un candidato con la cedula : "+cedula, "");
			}
			
			if(option==0) {
				updateNombre(cedula);	
			} else if(option==1){
				updateApellido(cedula);
			} else if(option==2) {
				updateCedula(cedula);
			} else if(option==3) {
				updateEdad(cedula);
			} else if(option==4) {
				updateCargo(cedula);
			} else {
				updateTodo(cedula);
			}
		}
			
		
		if (command.equals("DELETE")) {
			
			String cedula = window.captureData("Ingrese la cedula del candidato que desea eliminar: ", "cedula");
			candidatosDAO.eliminarCandidatos(cedula, getCandidatosDTO());
		}
	
	}
}
