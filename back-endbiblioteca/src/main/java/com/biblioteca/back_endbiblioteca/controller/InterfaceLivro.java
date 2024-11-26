package com.biblioteca.back_endbiblioteca.controller;
import java.util.List;
import java.util.Optional;
import com.biblioteca.back_endbiblioteca.model.Livro;

public interface InterfaceLivro {
	Livro salvarLivro(Livro livro); //Post
	
	Livro alterarLivro(Long id, Livro livro); //Put
	
	void excluirLivro(Long id); //Delete
	
	Optional<Livro> buscarLivro(Long id); // Get pelo Id
	
	List<Livro> listarTodos(); //Get lista todos os usuarios
}
