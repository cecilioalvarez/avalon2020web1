package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();

	Libro buscarPorTitulo(String titulo);

	Libro buscarPorIsbn(String isbn);

	void insertar(Libro libro);

	void salvar(Libro libro);

	void borrar(Libro libro);

}