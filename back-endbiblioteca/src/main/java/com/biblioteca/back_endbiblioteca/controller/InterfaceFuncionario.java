package com.biblioteca.back_endbiblioteca.controller;
import java.util.List;
import java.util.Optional;

import  com.biblioteca.back_endbiblioteca.model.Funcionario;

public interface InterfaceFuncionario {
	Funcionario salvarFuncionario (Funcionario funcionario); //post
	
	Funcionario alterarFuncionario ( Long id, Funcionario funcionario); //put
	
	void excluirFuncionario (Long id); //delete
	
	Optional<Funcionario> buscarFuncionario(Long id); //get pelo id
	
	List<Funcionario> listarTodos();
	
	
}
