package es.avalon.repositorio;

import java.util.List;

import es.avalon.dominio.Factura;

public interface FacturaRepository {

	List<Factura> buscarTodos();

	void insertar(Factura factura);

	void borrar(Factura factura);

}