package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Electrodomestico;
import modelo.OrdenDeServicio;



public class OrdenDeServicioDAOImp implements OrdenDeServicioDAO{

	Connection conexion;
	
	private ElectrodomesticoDAO electrodomesticoDAO;
	
	
	public OrdenDeServicioDAOImp(ElectrodomesticoDAO electrodomesticoDAO) {
		this.electrodomesticoDAO = electrodomesticoDAO;
	}
	
	@Override
	public List<OrdenDeServicio> findAllOrdenDeServicio() throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			
			String query = "SELECT * FROM ordenDeServicio";				
			ResultSet rs = st.executeQuery(query);
			List<OrdenDeServicio> ordenesDeTrabajo = new ArrayList<>();
			while(rs.next()) {
				int id 						 		 = rs.getInt("idOrdenDeServicio");
				String estado 				 		 = rs.getString("estado");
				LocalDate fechaSolicitud 		 	 = rs.getObject("fechasolicitud", LocalDate.class);
				LocalDate fechaActualizacionOrden 	 = rs.getObject("fechaactualizacionorden", LocalDate.class);
				int id_electrodomestico 			 = rs.getInt("id_electrodomestico");
				
				
				Electrodomestico electrodomestico = electrodomesticoDAO.findElectrodomesticoById(id_electrodomestico);

				OrdenDeServicio ordenDeServicio		 = new OrdenDeServicio(id,estado,fechaSolicitud,fechaActualizacionOrden,electrodomestico);
				ordenesDeTrabajo.add(ordenDeServicio);
			}
			return ordenesDeTrabajo;
		}
	}

	@Override
	public OrdenDeServicio findOrdenDeServicioById(int idOrdenDeServicio) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ordendetrabajo WHERE idOrdenDeServicio = ?");
			) {
			ps.setInt(1, idOrdenDeServicio);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id 						 		 = rs.getInt("idOrdenDeServicio");
				String estado 				 		 = rs.getString("estado");
				LocalDate fechaSolicitud 		 	 = rs.getObject("fechasolicitud", LocalDate.class);
				LocalDate fechaActualizacionOrden 	 = rs.getObject("fechaactualizacionorden", LocalDate.class);
				int id_electrodomestico 			 = rs.getInt("id_electrodomestico");
				
				Electrodomestico electrodomestico = electrodomesticoDAO.findElectrodomesticoById(id_electrodomestico);

				return new OrdenDeServicio(id,estado,fechaSolicitud,fechaActualizacionOrden,electrodomestico);
			}
			
		}
		return null;
	}

	@Override
	public void createOrdenDeServicio(OrdenDeServicio ordenDeServicio) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO ordenDeServicio(estado, fechasolicitud, fechaactualizacionorden, id_electrodomestico) VALUES (?,?,?,?)");

			) {
			ps.setString(1, ordenDeServicio.getEstado());
			ps.setObject(2, ordenDeServicio.getFechaSolicitud());
			ps.setObject(3, ordenDeServicio.getUltimaActualizacionOrden());
			ps.setInt(4, ordenDeServicio.getId_electrodomestico().getId());
			ps.executeUpdate();
		}
	}

	@Override
	public void editOrdenDeServicio(OrdenDeServicio ordenDeServicio) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE ordendetrabajo SET fechaactualizacionorden = ?, estado = ? WHERE id_odt = ?");
			) {

				ps.setObject(1, LocalDate.now());
				ps.setString(2, ordenDeServicio.getEstado());
				ps.setInt(3, ordenDeServicio.getId());
				ps.executeUpdate();
			} 
	}

	@Override
	public void deleteOrdenDeServicio(int idOrdenDeServicio) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM ordendetrabajo WHERE id_odt = ?");
			) {
				ps.setInt(1, idOrdenDeServicio);
				ps.executeUpdate();
			} 
	}

	@Override
	public OrdenDeServicio findLastCreatedOrdenDeServicio() throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
