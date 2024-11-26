package com.biblioteca.back_endbiblioteca.controller;
import java.util.List;
import java.util.Optional;
import com.biblioteca.back_endbiblioteca.model.LivroEmprestado;

public interface InterfaceLivroEmprestado {
	LivroEmprestado salvarEmprestimo(LivroEmprestado livroemprestado); //Post
	
	LivroEmprestado alterarEmprestimo(Long id, LivroEmprestado livroemprestado); //Put
	
	void excluirEmprestimo(Long id); //Delete
	
	Optional<LivroEmprestado> buscarEmprestimo(Long id); //Get buscar pelo id
	
	List<LivroEmprestado> listarEmprestimo(); //Get listar todos
}
