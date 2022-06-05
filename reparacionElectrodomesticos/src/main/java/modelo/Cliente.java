/**
 * 
 */
package modelo;

/**
 * @author Infoseg
 *
 */


public class Cliente {
	// ATRIBUTOS O PROPIEDADES O VARIABLES DE INSTANCIA 
	private int id;
	private String nombre, fono, direccion;
	
	
		
	// CONSTRUCTORES 
	public Cliente() {
	}



	/**
	 * @param nombre
	 * @param fono
	 * @param direccion
	 */
	public Cliente(String nombre, String fono, String direccion) {
		this.nombre = nombre;
		this.fono = fono;
		this.direccion = direccion;
	}



	/**
	 * @param id
	 * @param nombre
	 * @param fono
	 * @param direccion
	 */
	public Cliente(int id, String nombre, String fono, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.fono = fono;
		this.direccion = direccion;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the fono
	 */
	public String getFono() {
		return fono;
	}



	/**
	 * @param fono the fono to set
	 */
	public void setFono(String fono) {
		this.fono = fono;
	}



	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}