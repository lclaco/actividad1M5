package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.ClienteDAO;
import dao.ClienteDAOImp;


/**
 * Servlet implementation class ClienteController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    
	private ClienteDAO clienteDAO;
	
	

	public ClienteController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.clienteDAO = new ClienteDAOImp();	
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String accion = request.getParameter("accion");
	String vistaJSP = "";
	switch(accion) {
	case "listar":	
		List<Cliente> clientes	= null;
		try {
			clientes 			= clienteDAO.findAllClientes();
		} catch ( Exception e) {
			e.printStackTrace();
			try {
				response.sendError(500);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			return;
		}
		request.setAttribute("cliente", clientes);			
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/vista/cliente/cliente-listado.jsp").forward(request, response);
		} catch (ServletException | IOException e1) {
			
			e1.printStackTrace();
		}
		break;	
		
	
		case "form":
		vistaJSP = "/WEB-INF/jsp/vista/cliente/cliente-form.jsp";
		request
			.getRequestDispatcher(vistaJSP)
			.forward(request, response)
		;
		break;
	
	
	default:
		response.sendError(500);
	}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "agregarCliente":
			
			String nombre 		= request.getParameter("nombre");
			String telefono 	= request.getParameter("telefono");
			String direccion	= request.getParameter("direccion");
			
			//crea el objeto
			Cliente nuevoCliente = new Cliente(nombre,telefono,direccion);
			
			try {				
				clienteDAO.createCliente(nuevoCliente);				
				
				nuevoCliente = clienteDAO.findLastCreatedCliente();				
				
				request.setAttribute("cliente", nuevoCliente);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/cliente/cliente.jsp").forward(request, response);				
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			break;
		
		}
	}
}
