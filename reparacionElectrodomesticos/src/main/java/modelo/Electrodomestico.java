package modelo;

public class Electrodomestico {
	
	private int id;
	private String nombre, falla;
	private Cliente cliente_id;
	/**
	 * 
	 */
	public Electrodomestico() {
	}
	/**
	 * @param nombre
	 * @param falla
	 * @param cliente_id
	 */
	public Electrodomestico(String nombre, String falla, Cliente cliente_id) {
		this.nombre = nombre;
		this.falla = falla;
		this.cliente_id = cliente_id;
	}
	/**
	 * @param id
	 * @param nombre
	 * @param falla
	 * @param cliente_id
	 */
	public Electrodomestico(int id, String nombre, String falla, Cliente cliente_id) {
		this.id = id;
		this.nombre = nombre;
		this.falla = falla;
		this.cliente_id = cliente_id;
	}
	
	
	/**
	 * @param nombre
	 */
	public Electrodomestico(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param id
	 * @param nombre
	 */
	public Electrodomestico(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	 * @return the falla
	 */
	public String getFalla() {
		return falla;
	}
	/**
	 * @param falla the falla to set
	 */
	public void setFalla(String falla) {
		this.falla = falla;
	}
	/**
	 * @return the cliente_id
	 */
	public Cliente getCliente_id() {
		return cliente_id;
	}
	/**
	 * @param cliente_id the cliente_id to set
	 */
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
	
}
