package es.avalon.repositorios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

public class LibroRepositoryJDBC implements LibroRepository {
	
	@Override
	public List<Libro> buscarTodos() {

		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=" + TimeZone.getDefault().getID();
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
	
	@Override
	public Libro buscarPorISBN(String isbn) {

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=" + TimeZone.getDefault().getID();
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where isbn='"+isbn+"'";
		Libro libro = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);
			rs.next();
			
				libro = new Libro(rs.getString("isbn"), rs.getString("titulo"),rs.getString("autor"), rs.getInt("precio"),rs.getString("categoria"));
			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
	@Override
	public Libro buscarPorTitulo(String titulo) {

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Libros where titulo='"+titulo+"'";
		Libro libro = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);
			rs.next();
			
				libro = new Libro(rs.getString("isbn"), rs.getString("titulo"),rs.getString("autor"), rs.getInt("precio"),rs.getString("categoria"));
			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
	
	@Override
	public void insertar(Libro libro) {

		String consulta = "insert into Libros (isbn,titulo,autor,precio,categoria) values " + "('" + libro.getIsbn()
				+ "','" + libro.getTitulo() + "','" + libro.getAutor() + "'," + libro.getPrecio() + ",'"
				+ libro.getCategoria() + "')";

		Connection conexion;

		String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=" + TimeZone.getDefault().getID();
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

		@Override
		public void eliminar(Libro libro) {

			Connection conexion;

			String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=" + TimeZone.getDefault().getID();
			String usuario = "root";
			String clave = "";

			String consulta = "delete from Libros where isbn='" + libro.getIsbn() + "'";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection(url, usuario, clave);
				Statement sentencia = conexion.createStatement();
				sentencia.execute(consulta);

				System.out.println(conexion);

			} catch (SQLException | ClassNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// Añadir metodo actualizar( pide isbn y los demás datos y los actualizas)

		@Override
		public void actualizar(Libro libro) {
			Connection conexion;

			String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=" + TimeZone.getDefault().getID();
			String usuario = "root";
			String clave = "";

			String consulta = "update Libros set titulo='" + libro.getTitulo() + "', autor='" + libro.getAutor()
					+ "' ,categoria='" + libro.getCategoria() + "', precio=" + libro.getPrecio() + " where isbn='"
					+ libro.getIsbn() + "'";

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
		
		


	
	
	

}
