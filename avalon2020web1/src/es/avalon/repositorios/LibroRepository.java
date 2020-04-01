package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();

	Libro buscarIsbn(String isbn);

	Libro buscarPorTitulo(String titulo);

	void insertar(Libro libro);

	void borrar(Libro libro);

	void salvar(Libro libro);

}