/**
 * 
 */
package modelo;

import java.time.LocalDate;

/**
 * @author Infoseg
 *
 */
public class OrdenDeServicio {
	
	private int id;
	private String estado;
	private Electrodomestico id_electrodomestico;
	private LocalDate fechaSolicitud, UltimaActualizacionOrden;
	
	/**
	 * 
	 */
	public OrdenDeServicio() {
	}

	
	/**
	 * @param id
	 * @param estado
	 */
	public OrdenDeServicio(int id, String estado) {
		this.id = id;
		this.estado = estado;
	}


	/**
	 * @param estado
	 * @param id_electrodomestico
	 * @param fechaSolicitud
	 * @param ultimaActualizacionOrden
	 */
	public OrdenDeServicio(String estado, Electrodomestico id_electrodomestico, LocalDate fechaSolicitud,
			LocalDate ultimaActualizacionOrden) {
		this.estado = estado;
		this.id_electrodomestico = id_electrodomestico;
		this.fechaSolicitud = fechaSolicitud;
		UltimaActualizacionOrden = ultimaActualizacionOrden;
	}

	/**
	 * @param id
	 * @param estado
	 * @param id_electrodomestico
	 * @param fechaSolicitud
	 * @param ultimaActualizacionOrden
	 */
	public OrdenDeServicio(int id, String estado, Electrodomestico id_electrodomestico, LocalDate fechaSolicitud,
			LocalDate ultimaActualizacionOrden) {
		this.id = id;
		this.estado = estado;
		this.id_electrodomestico = id_electrodomestico;
		this.fechaSolicitud = fechaSolicitud;
		UltimaActualizacionOrden = ultimaActualizacionOrden;
	}

	/**
	 * @param id
	 * @param estado
	 * @param id_electrodomestico
	 * @param fechaSolicitud
	 * @param ultimaActualizacionOrden
	 */
	public OrdenDeServicio(int id, String estado, LocalDate fechaSolicitud,	LocalDate ultimaActualizacionOrden, Electrodomestico id_electrodomestico) {
		this.id = id;
		this.estado = estado;		
		this.fechaSolicitud = fechaSolicitud;
		UltimaActualizacionOrden = ultimaActualizacionOrden;
		this.id_electrodomestico = id_electrodomestico;
	}	
	


	public OrdenDeServicio(String estado, LocalDate fechaSolicitud, LocalDate ultimaActualizacionOrden, Electrodomestico id_electrodomestico) {
		this.estado = estado;		
		this.fechaSolicitud = fechaSolicitud;
		UltimaActualizacionOrden = ultimaActualizacionOrden;
		this.id_electrodomestico = id_electrodomestico;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * @return the id_electrodomestico
	 */
	public Electrodomestico getId_electrodomestico() {
		return id_electrodomestico;
	}


	/**
	 * @param id_electrodomestico the id_electrodomestico to set
	 */
	public void setId_electrodomestico(Electrodomestico id_electrodomestico) {
		this.id_electrodomestico = id_electrodomestico;
	}


	/**
	 * @return the fechaSolicitud
	 */
	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}


	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	/**
	 * @return the ultimaActualizacionOrden
	 */
	public LocalDate getUltimaActualizacionOrden() {
		return UltimaActualizacionOrden;
	}


	/**
	 * @param ultimaActualizacionOrden the ultimaActualizacionOrden to set
	 */
	public void setUltimaActualizacionOrden(LocalDate ultimaActualizacionOrden) {
		UltimaActualizacionOrden = ultimaActualizacionOrden;
	}
	
	
}
