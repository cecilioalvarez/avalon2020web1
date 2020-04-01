<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String isbn= request.getParameter("isbn");
String titulo= request.getParameter("titulo");
String autor= request.getParameter("autor");
int precio= Integer.parseInt(request.getParameter("precio"));
String categoria= request.getParameter("categoria");
Libro milibro= new Libro (isbn,titulo,autor,precio,categoria);
milibro.salvar();
response.sendRedirect("ListaLibros.jsp");
%>