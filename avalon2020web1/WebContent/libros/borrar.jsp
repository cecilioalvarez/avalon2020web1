<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String isbn= request.getParameter("isbn");

Libro milibro= new Libro(isbn);
milibro.borrar();
response.sendRedirect("ListaLibros.jsp");
%>