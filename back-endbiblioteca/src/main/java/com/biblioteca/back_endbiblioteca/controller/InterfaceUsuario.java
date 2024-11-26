package com.biblioteca.back_endbiblioteca.controller;
import com.biblioteca.back_endbiblioteca.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface InterfaceUsuario {
	Usuario salvarUsuario (Usuario usuario); //Post
	
	Usuario alterarUsuario (Long id, Usuario usuario); //Put
	
	void excluirUsuario(Long id); //Delete
	
	Optional<Usuario> buscarUsuario(Long id); //Get pelo id
	
	List<Usuario> listarTodos(); //Get listar todos os usuarios
}
