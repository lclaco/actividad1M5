package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.OrdenDeServicio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.ElectrodomesticoDAO;
import dao.OrdenDeServicioDAO;
import dao.OrdenDeServicioDAOImp;

public class OrdendeServicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private OrdenDeServicioDAO ordenDeServicioDAO;
	private ElectrodomesticoDAO electrodomesticoDAO;
	
	public OrdendeServicioController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();		
		this.ordenDeServicioDAO = new OrdenDeServicioDAOImp(this.electrodomesticoDAO);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String vistaJSP = "";
		
		switch (accion) {
		case "eliminar":
			try {
				int idOrdenDeServicio = Integer.parseInt(request.getParameter("id"));
				ordenDeServicioDAO.deleteOrdenDeServicio(idOrdenDeServicio);
				response.sendRedirect("/reparacionElectrodomestico/OrdenDeServicio?accion=listar");
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				response.sendError(500);
			} catch (NamingException ne) {
				ne.printStackTrace();
				response.sendError(500);
			}
			break;
		case "editar":
			
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				
				OrdenDeServicio ordenDeServicioEdit = ordenDeServicioDAO.findOrdenDeServicioById(id);
				
				request.setAttribute("OrdenDeServicio", ordenDeServicioEdit);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/ordenDeServicio/ordenDeServicio-form.jsp").forward(request, response);
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			break;
		case "form":
			vistaJSP = "/WEB-INF/jsp/vista/ordenDeServicio/ordenDeServicio-form.jsp";
			request
				.getRequestDispatcher(vistaJSP)
				.forward(request, response)
			;
			break;
		case "listar":
			List<OrdenDeServicio> ordenDeServicios = null;
			try {
				ordenDeServicios = ordenDeServicioDAO.findAllOrdenDeServicio();				
			} catch (Exception e) {
				e.printStackTrace();
				try {
					response.sendError(500);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
			request.setAttribute("ordenDeServicio", ordenDeServicios);	
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/vista/ordenDeServicio/ordenDeServicio-listado.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "ver":
			
			id = Integer.parseInt(request.getParameter("id"));
			try {
				
				OrdenDeServicio ordenDeServicioEdit = ordenDeServicioDAO.findOrdenDeServicioById(id);
				
				request.setAttribute("ordenDeServicios", ordenDeServicioEdit);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/ordenDeServicio/ordenDeServicio.jsp").forward(request, response);
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			break;
		}
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}


}
