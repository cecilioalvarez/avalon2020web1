package es.avalon.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public void insertar() {
		

		String consulta = "insert into Libros (isbn,titulo,autor,precio,categoria) values " + "('" + this.getIsbn()
				+ "','" + this.getTitulo() + "','" + this.getAutor() + "'," + this.getPrecio() + ",'"
				+ this.getCategoria() + "')";

		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

			System.out.println(conexion);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Añadir metodo borrar( pide isbn por pantalla y lo elimina)

	public void eliminar() {

		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		String consulta = "delete from Libros where isbn='" + this.getIsbn() + "'";

		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

			System.out.println(conexion);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Añadir metodo actualizar( pide isbn y los demás datos y los actualizas)

	public void actualizar() {
		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		String consulta = "update Libros set titulo='" + this.getTitulo() + "', autor='" + this.getAutor()
				+ "' ,categoria='" + this.getCategoria() + "', precio=" + this.getPrecio() + " where isbn='"
				+ this.getIsbn() + "'";

		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

			System.out.println(conexion);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Devuelve array list de todos los libros
	
	
	public static ArrayList<Libro> buscarTodos() {

		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		String consulta = "select * from Libros";

		ArrayList<Libro> lista = new ArrayList<Libro>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {

				Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getInt("precio"), rs.getString("categoria"));

				lista.add(libro);

			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	

}
