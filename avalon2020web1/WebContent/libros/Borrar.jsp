<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String isbn = request.getParameter("isbn");	
Libro milibro = new Libro(isbn);
milibro.eliminar();
response.sendRedirect("ListaLibros.jsp");
%>