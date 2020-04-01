package es.avalon.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Factura;
import es.avalon.repositorio.FacturaRepository;
import es.avalon.repositorio.JDBC.FacturaRepositoryJDBC;


@WebServlet("/ServletFactura")
public class ServletFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		String accion = request.getParameter("accion");
		FacturaRepository repositorio = new FacturaRepositoryJDBC();

		if (accion != null) {

			if (accion.equals("formularioInsertar")) {
				despachador = request.getRequestDispatcher("factura/formularioInsertar.jsp");
			} else if(accion.equals("borrar")) {
				int numero= Integer.parseInt(request.getParameter("numero"));
				
				Factura mifactura= new Factura(numero);
				
				repositorio.borrar(mifactura);
				
				
				List<Factura> listaFacturas = repositorio.buscarTodos();
				request.setAttribute("listaFacturas", listaFacturas);
			
				despachador = request.getRequestDispatcher("factura/listaFacturas.jsp");
			}
			
			else {
			
				int numero = Integer.parseInt(request.getParameter("numero"));
				String concepto = request.getParameter("concepto");
				double importe= Double.parseDouble(request.getParameter("importe"));
				
				
				Factura mifactura = new Factura(numero, concepto, importe);
				
				repositorio.insertar(mifactura);
			
				List<Factura> listaFacturas = repositorio.buscarTodos();
				request.setAttribute("listaFacturas", listaFacturas);
				
				despachador = request.getRequestDispatcher("factura/listaFacturas.jsp");
			}
		}

	
		else {

			List<Factura> listaFacturas = new ArrayList<Factura>();

			
			listaFacturas = repositorio.buscarTodos();

			despachador = request.getRequestDispatcher("factura/listaFacturas.jsp");
			request.setAttribute("listaFacturas", listaFacturas);
		}
	
		despachador.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
