package es.avalon.repositorios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.avalon.dominio.Factura;
import es.avalon.dominio.Libro;

public class FacturaRepository {

	public static List<Factura> listarTodas() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Facturas";
		// System.out.println(consulta);
		
		ArrayList <Factura> lista=new ArrayList<Factura>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {
				
				Factura factura = new Factura(rs.getInt("numero"), rs.getString("concepto"), rs.getInt("importe"));
				// añado cada libro a la lista
				lista.add(factura);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// retorno la lista de objetos
		return lista;
	}
	
	public void insertar(Factura factura) {

		String consulta = "insert into Facturas (numero,concepto,importe) values";
		consulta = consulta + " ('" + factura.getNumero() + "','" + factura.getConcepto() + "','" + factura.getImporte() + "')";
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
}
