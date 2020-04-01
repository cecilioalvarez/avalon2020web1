package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();

	Libro buscarPorISBN(String isbn);

	Libro buscarPorTitulo(String titulo);

	void insertar(Libro libro);

	void eliminar(Libro libro);

	void actualizar(Libro libro);

}