package es.avalon.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import es.avalon.dominio.Libro;

public class LibroRepository {
	public static List<Libro> buscarTodos() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros";

		// genero una lista de libros para trabajar de una forma natural
		// con programaci�n orientada a objeto
		List<Libro> lista = new LinkedList<Libro>();
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
				// a�ado cada libro a la lista
				lista.add(libro);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// retorno la lista de objetos
		return lista;
	}

	public static Libro buscarPorIsbn(String isbn) {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where isbn='" + isbn + "'";
		Libro libro = null;

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

	public static Libro buscarPorTitulo(String titulo) {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where titulo='" + titulo + "'";
		Libro libro = null;
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

	public void insertar(Libro libro) {

		String consulta = "insert into Libros (isbn,titulo,autor,precio,categoria) values";
		consulta = consulta + " (' " + libro.getIsbn() + " ',' " + libro.getTitulo() + " ',' " + libro.getAutor()
				+ " ', " + libro.getPrecio() + " ,' " + libro.getCategoria() + " ')";
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

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(Libro libro) {

		String consulta = "update Libros set titulo='" + libro.getTitulo() + "' , autor='" + libro.getAutor()
				+ "', precio=" + libro.getPrecio();
		consulta = consulta + " , categoria='" + libro.getCategoria() + "' where isbn='" + libro.getIsbn() + "'";
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

	public void borrar(Libro libro) {

		String consulta = "delete from Libros where isbn='" + libro.getIsbn() + " ' ";

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

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
