package es.avalon.repositorios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.avalon.dominio.Factura;

public class FacturaRepository {
	
	public static List<Factura> buscarTodos() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Facturas";

		// genero una lista de libros para trabajar de una forma natural
		// con programación orientada a objeto
		ArrayList<Factura> lista = new ArrayList<Factura>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {

				// genero una nueva factura
				// a la nueva factura le asigno los datos que me vienen en el resultset
				// propiedad por propiedad

				Factura f = new Factura(rs.getInt("numero"), rs.getString("concepto"), rs.getInt("importe"));
				// añado cada factura a la lista
				lista.add(f);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// retorno la lista de objetos
		return lista;
	}
	
	
	public void insertar(Factura factura) {

		String consulta = "insert into Facturas (numero,concepto,importe) values";
		consulta = consulta + " (' " + factura.getNumero() + " ',' " + factura.getConcepto() + " ',' " + factura.getImporte() + " ')";
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

}
