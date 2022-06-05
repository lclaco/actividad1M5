package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.ClienteDAO;
import dao.ElectrodomesticoDAO;
import dao.ElectrodomesticoDAOImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Electrodomestico;


public class ElectrodomesticoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ElectrodomesticoDAO electrodomesticoDAO;
	private ClienteDAO clienteDAO;
	
    public ElectrodomesticoController() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
		super.init();		
		this.electrodomesticoDAO = new ElectrodomesticoDAOImp(this.clienteDAO);
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String vistaJSP = "";
		
		switch (accion) {
			case "eliminar":
				try {
					int electrodomesticoId = Integer.parseInt( request.getParameter("id") );
					electrodomesticoDAO.deleteElectrodomestico(electrodomesticoId);
					response.sendRedirect("/reparacionElectrodomestico/ElectrodomesticoController?accion=listar");
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					response.sendError(500);
				} catch (NamingException ne) {
					ne.printStackTrace();
					response.sendError(500);
				}				
				break;
			case "listar":
				List<Electrodomestico>  electrodomesticos 	= null;
				try {
					electrodomesticos 	= electrodomesticoDAO.findAllElectrodomesticos();
				} catch(Exception e) {
					e.printStackTrace();
					try {
						response.sendError(500);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					return;
				}
				request.setAttribute("electrodomestico", electrodomesticos);
				try {
					request.getRequestDispatcher("/WEB-INF/jsp/vista/electrodomestico/electrodomestico-listar.jsp").forward(request, response);
				} catch (ServletException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "form":
				vistaJSP = "/WEB-INF/jsp/vista/electrodomestico/electrodomestico-form.jsp";
				request
					.getRequestDispatcher(vistaJSP)
					.forward(request, response)
				;
				break;
			
			default:
				response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt( request.getParameter("id") );
		} catch (NumberFormatException e) {
			System.err.println("id se setea a 0 de manera automática.");
		}
		
		String nombre 	= request.getParameter("nombre");
		
		if(id == 0) {
			
			Electrodomestico electrodomesticoNuevo = new Electrodomestico(nombre);
			try {
				electrodomesticoDAO.createElectrodomestico(electrodomesticoNuevo);
				response.sendRedirect("/reparacionElectrodomestico/ElectrodomesticoController?accion=listar");
			} catch (SQLException | NamingException e) {				
				e.printStackTrace();
				response.sendError(500);
			}
		} else {
			
			Electrodomestico electrodomesticoEditar = new Electrodomestico(id, nombre);
			try {
				electrodomesticoDAO.editElectrodomestico(electrodomesticoEditar);
				response.sendRedirect("/reparacionElectrodomestico/ElectrodomesticoController?accion==listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		} 
	}	
}