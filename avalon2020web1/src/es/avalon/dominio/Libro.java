package es.avalon.dominio;

import java.util.*;
import java.sql.*;
// paquete en el proyecto
public class Libro {
 private String isbn;
 private String titulo;
 private String autor;
 private int precio;
 private String categoria;
 
 
 public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
 
public Libro(String isbn, String titulo, String autor, int precio, String categoria) {
	super();
	this.isbn = isbn;
	this.titulo = titulo;
	this.autor = autor;
	this.precio = precio;
	this.categoria = categoria;
}

public Libro(String isbn) {
	super();
	this.isbn = isbn;
}


public void insertar(){
	String consulta= "insert into libros (titulo, autor, precio, categoria, isbn) values ('"+this.getTitulo()+"', '"+this.getAutor()+"', "+this.getPrecio()+", '"+this.getCategoria()+"', '"+this.getIsbn()+"' )";
	System.out.println(consulta); // para aprender que cambia 
	Connection conexion;
	String url="jdbc:mysql://localhost:3306/biblioteca";
	String usuario="root";
	String clave="";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion=DriverManager.getConnection(url, usuario,clave);
		/*
		 * sentencia de sql por lo tanto
		 * a la conecion que nos cree una opcion de ejecutar sentencia
		 */
		
		Statement sentencia =conexion.createStatement();
		sentencia.execute(consulta);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	public void borrar(){
		String consulta= "delete from libros where isbn='"+this.getIsbn()+"' ";
		System.out.println(consulta); // para aprender que cambia 
		Connection conexion;
		String url="jdbc:mysql://localhost:3306/biblioteca";
		String usuario="root";
		String clave="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(url, usuario,clave);
			/*
			 * sentencia de sql por lo tanto
			 * a la conecion que nos cree una opcion de ejecutar sentencia
			 */
			
			Statement sentencia =conexion.createStatement();
			sentencia.execute(consulta);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actualizar () {
		//mete el isbn y cambias todo el resto de datos
		Connection conexion;
		String url="jdbc:mysql://localhost:3306/biblioteca";
		String usuario="root";
		String clave="";
		String consulta2= "update libros set titulo='"+this.getTitulo()+"', autor= '"+this.getAutor()+"', precio= "+this.getPrecio()+", categoria= '"+this.getCategoria()+"' where isbn = '"+this.getIsbn()+"'";
		System.out.println(consulta2);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(url, usuario,clave);
			/*
			 * sentencia de sql por lo tanto
			 * a la conecion que nos cree una opcion de ejecutar sentencia
			 */
			
			Statement sentencia =conexion.createStatement();
			sentencia.execute(consulta2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static List<Libro> buscarTodos(){
	Connection conexion;
	String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	String usuario="root";
	String clave="";
String consulta = "select * from libros";
//genero una lista de libros para trabajar de fomra natural
//con programacion orientada a objetos
ArrayList <Libro> lista= new ArrayList<Libro>();


try {
	Class.forName("com.mysql.jdbc.Driver");
	conexion=DriverManager.getConnection(url, usuario,clave);
				
	Statement sentencia =conexion.createStatement();
	ResultSet rs= sentencia.executeQuery(consulta);
	
	while (rs.next()) {
		/*
		 * gener un nuevo libro
		 * al nuevo libro le asigo nos datos que me vienen en el resutlset
		 * propiedad por propiedad
		 */
	Libro libro = new Libro(
	rs.getString("isbn"),
	rs.getString("titulo"),
	rs.getString("autor"),
	rs.getInt("precio"),
	rs.getString("categoria"));
	//a�ado libro a cada lista
	lista.add(libro);				
	
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return lista;


}

public static Libro buscarPorTitulo(String titulo){
	Connection conexion;
	String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	String usuario="root";
	String clave="";
	String consulta = "select * from libros where titulo='"+titulo+"'";
	Libro libro=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion=DriverManager.getConnection(url, usuario,clave);
					
		Statement sentencia =conexion.createStatement();
		ResultSet rs= sentencia.executeQuery(consulta);
		rs.next();
		libro = new Libro(
		rs.getString("isbn"),
		rs.getString("titulo"),
		rs.getString("autor"),
		rs.getInt("precio"),
		rs.getString("categoria"));
				
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return libro;


	
}
public static List<Libro> ordenarTodos(){
	Connection conexion;
	String url="jdbc:mysql://localhost:3306/biblioteca";
	String usuario="root";
	String clave="";
String consulta = "select * from libros order by titulo";
//genero una lista de libros para trabajar de fomra natural
//con programacion orientada a objetos
ArrayList <Libro> lista= new ArrayList<Libro>();


try {
	Class.forName("com.mysql.jdbc.Driver");
	conexion=DriverManager.getConnection(url, usuario,clave);
				
	Statement sentencia =conexion.createStatement();
	ResultSet rs= sentencia.executeQuery(consulta);
	
	while (rs.next()) {
		/*
		 * gener un nuevo libro
		 * al nuevo libro le asigo nos datos que me vienen en el resutlset
		 * propiedad por propiedad
		 */
	Libro libro = new Libro(
	rs.getString("isbn"),
	rs.getString("titulo"),
	rs.getString("autor"),
	rs.getInt("precio"),
	rs.getString("categoria"));
	//a�ado libro a cada lista
	lista.add(libro);				
	
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return lista;


}
public static Libro buscarPorISBN(String isbn){
	Connection conexion;
	String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	String usuario="root";
	String clave="";
	String consulta = "select * from libros where isbn='"+isbn+"'";
	Libro libro=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion=DriverManager.getConnection(url, usuario,clave);
					
		Statement sentencia =conexion.createStatement();
		ResultSet rs= sentencia.executeQuery(consulta);
		rs.next();
		libro = new Libro(
		rs.getString("isbn"),
		rs.getString("titulo"),
		rs.getString("autor"),
		rs.getInt("precio"),
		rs.getString("categoria"));
				
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return libro;
}
}

