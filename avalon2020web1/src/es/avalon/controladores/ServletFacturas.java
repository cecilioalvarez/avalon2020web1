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
import es.avalon.repositorios.jdbc.FacturaRepository;

/**
 * Servlet implementation class ServletFacturas
 */
@WebServlet("/ServletFacturas")
public class ServletFacturas extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher despachador = null;
		String accion = request.getParameter("accion");

		if (accion != null) {

			if (accion.equals("formularioInsertar")) {
				despachador = request.getRequestDispatcher("facturas/formularioInsertar.jsp");
			}
			else{
				// Recepcionar
				int numero = Integer.parseInt(request.getParameter("numero"));
				String titulo = request.getParameter("concepto");
				int importe = Integer.parseInt(request.getParameter("importe"));
				
				// Insertar
				Factura mifactura = new Factura(numero, titulo, importe);
				FacturaRepository repositorio=new FacturaRepository();
				repositorio.insertar(mifactura);
				
				// Cargar nuevo listado
				List<Factura> listaFacturas = FacturaRepository.buscarTodos();
				request.setAttribute("listaFacturas", listaFacturas);
				// Redirigir
				despachador = request.getRequestDispatcher("facturas/listaFacturas.jsp");
			}
		}
		else {

			List<Factura> listaFacturas = new ArrayList<Factura>();

			listaFacturas = FacturaRepository.buscarTodos();

			despachador = request.getRequestDispatcher("facturas/listaFacturas.jsp");
			request.setAttribute("listaFacturas", listaFacturas);
		}
		// Sean de un interface
		despachador.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
