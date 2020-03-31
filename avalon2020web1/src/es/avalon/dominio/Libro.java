package es.avalon.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	
	public Libro(String isbn, String titulo, String autor, int precio, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	public void insertar() {
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		
		String consulta = "insert into Libros (isbn,titulo,autor,precio,categoria) values ('"+this.getIsbn()+"','"+this.getTitulo()+"','"+this.getAutor()+"',"+this.getPrecio()+",'"+this.getCategoria()+"')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);
			System.out.println(conexion);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	public void borrar() {
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		
		String consulta = "delete from Libros where isbn='"+this.getIsbn()+"'";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);
			System.out.println(conexion);
		} catch (SQLException |  ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public void actualizar() {
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";

		String consulta =  "update Libros set titulo='"+getTitulo()+"',autor='"+getAutor()+"',precio="+getPrecio()+",categoria='"+getCategoria()+"' where isbn='"+getIsbn()+"'";
		System.out.println(consulta);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);
			System.out.println(conexion);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public  static Libro buscarPorTitulo(String titulo){
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where titulo='"+titulo+"'";
		Libro libro=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs=sentencia.executeQuery(consulta);
				rs.next();		
				libro=new Libro(rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("autor"),
				rs.getInt("precio"),
				rs.getString("categoria"));
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return libro;
	}
	
	public static Libro buscarPorISBN(String isbn){
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where isbn='"+isbn+"'";
		Libro libro=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs=sentencia.executeQuery(consulta);
				rs.next();		
				libro=new Libro(rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("autor"),
				rs.getInt("precio"),
				rs.getString("categoria"));
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return libro;
	}
	
	public static List<Libro> buscarTodos(){
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros";
		ArrayList<Libro> lista=new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs=sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				//genero un nuevo libro
				//al nuevo libro le asigno los datos que me vienen en el resulset
				
				Libro libro=new Libro(rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("autor"),
				rs.getInt("precio"),
				rs.getString("categoria"));
				lista.add(libro);
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	return lista;
	}
	
	public static List<Libro> ordenarPorTitulo(){
		Connection conexion;
		String url ="jdbc:mysql://localhost/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros order by titulo";
		ArrayList<Libro> lista=new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs=sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				//genero un nuevo libro
				//al nuevo libro le asigno los datos que me vienen en el resulset
				
				Libro libro=new Libro(rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("autor"),
				rs.getInt("precio"),
				rs.getString("categoria"));
				lista.add(libro);
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	return lista;
	}
	
}
