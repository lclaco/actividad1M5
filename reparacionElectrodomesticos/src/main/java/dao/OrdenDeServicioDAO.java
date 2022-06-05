package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.OrdenDeServicio;

public interface OrdenDeServicioDAO {
	
	public List<OrdenDeServicio> findAllOrdenDeServicio() 					throws SQLException, NamingException;
	public OrdenDeServicio findOrdenDeServicioById(int idOrdenDeServicio) 	throws SQLException, NamingException;
	public void createOrdenDeServicio(OrdenDeServicio ordenDeServicio)		throws SQLException, NamingException;
	public void editOrdenDeServicio(OrdenDeServicio ordenDeServicio)			throws SQLException, NamingException;
	public void deleteOrdenDeServicio(int idOrdenDeServicio)					throws SQLException, NamingException;
	public OrdenDeServicio findLastCreatedOrdenDeServicio()					throws SQLException, NamingException;
	
}
