<!--Heading-->

   # Requerimiento candidatos recursos humanos: ![unbosque](Logo.png  "https://www.unbosque.edu.co")  

## *Programa escrito en java y creado para generar y manipular una lista de candidatos*
 >software creado por Santiago Giraldo Y cristian Escamilla 
---


![Vista](company.png "vista programa")

Se genera un programa capaz de gestionar una lista de candidatos, dicha lista puede ser utilizada y manipulada por el area de RRHH de una empresa para administrar los datos de los posibles aspirantes a los diversos cargos de la empresa.

<!--List-->
## **Características**
---

* Crear un candidato
    *  >Atributos: Nombre, Apellido, Cédula Edad, Cargo.

* Mostrar lista de candidatos
    * >Permite ver toda la lista de condidatos, o bien, buscar un candidato en concreto por su cédula
*  Actualizar
    * >Actualiza un candidato localizandolo mediante su cédula

* Eliminar
    * >Elimina un candidato localizandolo mediante su cédula


## Persistencia de archivos
---
### *La persistencia genera una organizacion similar a la presentada en el siguiente panel:*
|Nombre     |  Apellido  |  Cédula  |   Edad    |  Cargo    | 
| ----------|:---------: |---------:| --------- |:----------:|  
|    Pedro  |     cortes |  12386457|    39     |  Ingeniero |
|    andrea |  Rodriguez |  16435019|    40     |  Psicologa |
|    juan   |    Perez   | 13652491 |    41     | Coordinador|
---
Todos los datos de los candidatos inscritos en el programa serán guardados exitosamente mediante la persistencia de los archivos.

![Archivo](persistencia.png "archivo")




# Interacción 
La interaccion se realiza mediante un metodo que contiene JOptionPane, los cuales envian la informacion para su posterior procesamiento y respuesta.

![Panel](panel.png "JOption")

# Metodos del programa

*  Metodo utilizado para agregar candidatos a la lista
    ``` java
    public void agregarCandidatos(String nombre, String apellido, String cedula, int edad, String cargo, ArrayList<CandidatosDTO> lista) {
		
		CandidatosDTO agragar = new CandidatosDTO(nombre, apellido, cedula, edad, cargo);
		lista.add(agragar);
		archivo.escribirArchivo(lista);
		JOptionPane.showMessageDialog(null, "Candidato agregado con cedula : "+cedula);	
	}
    ```
* Metodo para eliminar candidatos de la lista
    ``` java
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
    ```
* Metodo para buscar candidatos de la lista

    ``` java
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

    ```
 * Metodo para ver candidatos de la lista
   ``` java
    public String verCandidatos() {
		ArrayList<CandidatosDTO> candidatos = archivo.leerArchivo();
		String texto  ="";
		for (int i = 0; i < candidatos.size(); i++) {
			texto = texto.concat(candidatos.get(i).toString()+"\n");
		}
		return "Candidatos: \n"+texto;
	}
    ```
#  Universidad el Bosque
  > [Universidad el Bosque]( https://www.unbosque.edu.co )

