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
 * Servlet implementation class ServletFactura
 */
@WebServlet("/ServletFactura")
public class ServletFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher despachador=null;
		String accion=request.getParameter("accion");
		
		if (accion!=null) {
			
			if (accion.equals("formularioInsertar")) {
				
				despachador= request.getRequestDispatcher("facturas/formularioInsertar.jsp");
			
			}else if (accion.equals("insertar")) {
				
				int numero=Integer.parseInt(request.getParameter("numero"));
				String concepto=request.getParameter("concepto");
				int importe=Integer.parseInt(request.getParameter("importe"));
				
				Factura factura=new Factura(numero,concepto,importe);
				FacturaRepository repositorio=new FacturaRepository();
				repositorio.insertar(factura);
				
				List<Factura> listaFacturas=FacturaRepository.listarTodas();
				request.setAttribute("listaFacturas", listaFacturas);
				
				despachador=request.getRequestDispatcher("facturas/listaFacturas.jsp");

			} else {
				
			}
		} else {
			
			List<Factura> listaFacturas=new ArrayList<Factura>();
			
			listaFacturas=FacturaRepository.listarTodas();
			
			despachador=request.getRequestDispatcher("facturas/listaFacturas.jsp");
			request.setAttribute("listaFacturas", listaFacturas);
		}
		
		despachador.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
