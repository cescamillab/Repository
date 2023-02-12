/**
 * clase que pertenece al paquete model
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.CandidatosDTO;
/**
 * Clase encargada de generar un archivo persistente 
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */
public class Archivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo = new File("data/basedatos.dat");
	
	/**
	 * Metodo Constructor
	 */
	public Archivo() {
		if(archivo.exists()) {
			System.out.println("El archivo ya existe");
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Metodo para escribir el archivo persistente
	 * 
	 */
	public void escribirArchivo(ArrayList<CandidatosDTO> candidatos) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(candidatos);
			salida.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para leer el archivo persistente
	 * 
	 * @return the candidatosDTO
	 */
	public ArrayList<CandidatosDTO> leerArchivo(){
		ArrayList<CandidatosDTO> candidatos = new ArrayList<CandidatosDTO>();
		if(archivo.length()!=0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				candidatos = (ArrayList<CandidatosDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return candidatos;
	}

	/**
	 * @return the entrada
	 */
	public ObjectInputStream getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public ObjectOutputStream getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	/**
	 * @return the archivo
	 */
	public File getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	
}
