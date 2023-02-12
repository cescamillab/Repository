/**
* Clase pertenece al paquete model el cual se encarga de la representacion de objetos
*/
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase encargada de representar al objeto agenda con sus atributos e implementa Serializable para poder hacer la persistencia para mostrar los contactos guardados
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */

public class CandidatosDTO implements Serializable{

	/**
	 * Atributos tipo int y String
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	private String cargo;
	/**
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param edad
	 * @param cargo
	 */
	public CandidatosDTO(String nombre, String apellido, String cedula, int edad, String cargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargo = cargo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return " nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", edad=" + edad
				+ ", cargo=" + cargo;
	}
	
}
