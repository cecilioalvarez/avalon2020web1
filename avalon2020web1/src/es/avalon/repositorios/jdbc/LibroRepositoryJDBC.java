package es.avalon.repositorios.jdbc;
import es.avalon.repositorios.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.avalon.dominio.Libro;

public class LibroRepositoryJDBC implements LibroRepository {
	
	
	
	
	@Override
	public List<Libro> buscarTodos(){
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
	
	@Override
	public void insertar(Libro libro){
		String consulta= "insert into libros (titulo, autor, precio, categoria, isbn) values ('"+libro.getTitulo()+"', '"+libro.getAutor()+"', "+libro.getPrecio()+", '"+libro.getCategoria()+"', '"+libro.getIsbn()+"' )";
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

	@Override
	public void borrar(Libro libro){
		String consulta= "delete from libros where isbn='"+libro.getIsbn()+"' ";
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
	@Override
	public void actualizar (Libro libro) {
		//mete el isbn y cambias todo el resto de datos
		Connection conexion;
		String url="jdbc:mysql://localhost:3306/biblioteca";
		String usuario="root";
		String clave="";
		String consulta2= "update libros set titulo='"+libro.getTitulo()+"', autor= '"+libro.getAutor()+"', precio= "+libro.getPrecio()+", categoria= '"+libro.getCategoria()+"' where isbn = '"+libro.getIsbn()+"'";
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
	@Override
	public Libro buscarPorTitulo(String titulo){
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
	@Override
	public List<Libro> ordenarTodos(){
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
	@Override
	public Libro buscarPorISBN(String isbn){
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
