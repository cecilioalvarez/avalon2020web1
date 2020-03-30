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

	// Getters y Setters
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

	// Constructores
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

	public static List<Libro> buscarTodos() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros";

		// genero una lista de libros para trabajar de una forma natural
		// con programación orientada a objeto
		ArrayList<Libro> lista = new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {

				// genero un nuevo libro
				// al nuevo libro le asigno los datos que me vienen en el resultset
				// propiedad por propiedad

				Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("precio"), rs.getString("categoria"));
				// añado cada libro a la lista
				lista.add(libro);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// retorno la lista de objetos
		return lista;
	}
	
	public static List<Libro> buscarTodosOrdenado() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros order by titulo";

		// genero una lista de libros para trabajar de una forma natural
		// con programación orientada a objeto
		ArrayList<Libro> listaordenada = new ArrayList<Libro>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {

				// genero un nuevo libro
				// al nuevo libro le asigno los datos que me vienen en el resultset
				// propiedad por propiedad

				Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("precio"), rs.getString("categoria"));
				// añado cada libro a la lista
				listaordenada.add(libro);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// retorno la lista de objetos
		return listaordenada;
	}

	public static Libro buscarPorTitulo(String titulo) {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where titulo='" + titulo + "'";
		Libro libro=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);
			rs.next();

			libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("precio"),
					rs.getString("categoria"));

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// retorno la lista de objetos
		return libro;
	}
	
	public static Libro buscarPorIsbn(String isbn) {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where isbn='" + isbn + "'";
		Libro libro=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);
			rs.next();

			libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("precio"),
					rs.getString("categoria"));

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// retorno la lista de objetos
		return libro;
	}

	public void insertar() {

		String consulta = "insert into Libros (isbn,titulo,autor,precio,categoria) values";
		consulta = consulta + " (' " + this.getIsbn() + " ',' " + this.getTitulo() + " ',' " + this.getAutor() + " ', "
				+ this.getPrecio() + " ,' " + this.getCategoria() + " ')";
		System.out.println(consulta);

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);

			// sentencia SQL por lo tanto
			// a la conexion que nos cree una opcion de ejecutar una sentencia
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void salvar() {

		String consulta= "update Libros set titulo='"+getTitulo()+"' , autor='"+getAutor()+"', precio="+getPrecio();
		consulta=consulta+ " , categoria='"+this.getCategoria()+"' where isbn='" +this.getIsbn()+"'";
		System.out.println(consulta);

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);

			// sentencia SQL por lo tanto
			// a la conexion que nos cree una opcion de ejecutar una sentencia
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void borrar() {

		String consulta = "delete from Libros where isbn='" + getIsbn() + "'";

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		System.out.println(consulta);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);

			// sentencia SQL por lo tanto
			// a la conexion que nos cree una opcion de ejecutar una sentencia
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
