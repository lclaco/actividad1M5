package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

import modelo.Cliente;
import modelo.Electrodomestico;


public class ElectrodomesticoDAOImp implements ElectrodomesticoDAO {

	Connection conexion;
	
	private ClienteDAO clienteDAO;
	
	public ElectrodomesticoDAOImp(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	@Override
	public List<Electrodomestico> findAllElectrodomesticos() throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM electrodomestico");
			List<Electrodomestico> electrodomesticos = new ArrayList<>();
			while(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clienteDAO.findClienteById(idCliente);
				
				Electrodomestico electrodomestico= new Electrodomestico(id,nombre,falla,cliente);
				electrodomesticos.add(electrodomestico);
			}
			return electrodomesticos;
		}
	}

	@Override
	public Electrodomestico findElectrodomesticoById(int idElectrodomestico) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Electrodomestico WHERE id_electrodomestico = ?");
			) {
			ps.setInt(1, idElectrodomestico);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clienteDAO.findClienteById(idCliente);
				
				return new Electrodomestico(id,nombre,falla,cliente);
			}
			
		}
		return null;
	}

	@Override
	public Electrodomestico findElectrodomesticoByClienteId(int idCliente) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Electrodomestico WHERE id_cliente = ?");
			) {
			ps.setInt(1, idCliente);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int clienteId 		= rs.getInt("id_cliente");
				Cliente cliente 	= clienteDAO.findClienteById(clienteId);
				
				return new Electrodomestico(id,nombre,falla,cliente);
			}
			
		}
		return null;	
	}

	@Override
	public void createElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO electrodomestico(nombre, falla, id_cliente) VALUES (?,?,?)");

			) {
			ps.setString(1, electrodomestico.getNombre());
			ps.setString(2, electrodomestico.getFalla());
			ps.setInt(3, electrodomestico.getCliente_id().getId());
			ps.executeUpdate();
			
		}
	}

	@Override
	public void editElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE electrodomestico SET nombre = ?, falla = ? WHERE id_electrodomestico = ?");
			) {

				ps.setString(1, electrodomestico.getNombre());
				ps.setString(2, electrodomestico.getFalla());
				ps.setInt(3, electrodomestico.getId());
				ps.executeUpdate();
			} 
		
	}

	@Override
	public void deleteElectrodomestico(int idElectrodomestico) throws SQLException, NamingException {
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("DELETE FROM electrodomestico WHERE id_electrodomestico = ?");
			) {
				declaracion.setInt(1, idElectrodomestico);
				int filasEliminadas = declaracion.executeUpdate();
			}
	}

	@Override
	public Electrodomestico findLastCreatedElectrodomestico() throws SQLException, NamingException {
		try(
				Connection conn = DbUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM electrodomestico ORDER BY id_electrodomestico DESC LIMIT 1");
			if(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clienteDAO.findClienteById(idCliente);
				return new Electrodomestico(id,nombre,falla,cliente);
			}
			
		}
		return null;
	}

	
}