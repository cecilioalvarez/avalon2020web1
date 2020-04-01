package es.avalon.repositorio.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import es.avalon.dominio.Factura;
import es.avalon.repositorio.FacturaRepository;

public class FacturaRepositoryJDBC implements FacturaRepository {
	@Override
	public List<Factura> buscarTodos() {
		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";
		String consulta = "select * from Facturas";

		
		List<Factura> lista = new LinkedList<Factura>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {

				Factura factura = new Factura(rs.getInt("numero"), rs.getString("concepto"), rs.getDouble("importe"));
				
				lista.add(factura);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void insertar(Factura factura) {

		String consulta = "insert into Facturas (numero, concepto, importe) values";
		consulta = consulta + " (' " + factura.getNumero() + " ',' " + factura.getConcepto() + " ',' " + factura.getImporte()+" ')";
		System.out.println(consulta);

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);

			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(Factura factura) {

		String consulta = "delete from Facturas where numero='" + factura.getNumero() + " ' ";

		Connection conexion;
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, clave);

			Statement sentencia = conexion.createStatement();
			sentencia.execute(consulta);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
