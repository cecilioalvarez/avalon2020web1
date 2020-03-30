<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String isbn= request.getParameter("isbn");
Libro l= new Libro(isbn);
l.borrar();
response.sendRedirect("ListaLibros.jsp");
%>

