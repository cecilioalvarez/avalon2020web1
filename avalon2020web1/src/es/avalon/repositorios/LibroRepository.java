package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();

	void insertar(Libro libro);

	void borrar(Libro libro);

	void actualizar(Libro libro);

	Libro buscarPorTitulo(String titulo);

	List<Libro> ordenarTodos();

	Libro buscarPorISBN(String isbn);

}