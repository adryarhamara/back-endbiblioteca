package com.biblioteca.back_endbiblioteca.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.back_endbiblioteca.model.LivroEmprestado;
import com.biblioteca.back_endbiblioteca.repository.LivroEmprestadoRepository;

@RestController
@RequestMapping("api/v1/livrosemprestados")
public class LivroEmprestadoController implements InterfaceLivroEmprestado{
	@Autowired
	private LivroEmprestadoRepository livroEmprestadoRepository; //injetando a instância do repositorio livroemprestadorepository

	@Override
	@PostMapping
	public LivroEmprestado salvarEmprestimo(@RequestBody LivroEmprestado livroemprestado) {
		return livroEmprestadoRepository.save(livroemprestado);
	}

	@Override
	@PutMapping("/{id}")
	public LivroEmprestado alterarEmprestimo(@PathVariable Long id, @RequestBody LivroEmprestado livroemprestado) {
		if(livroEmprestadoRepository.existsById(id)) {
			livroemprestado.setIdEmprestimo(id);
			return livroEmprestadoRepository.save(livroemprestado);
		}else {
			throw new RuntimeException("Livro emprestado não encontrado");
		} 
	}

	@Override
	@DeleteMapping("/{id}")
	public void excluirEmprestimo(@PathVariable Long id) {
		if(livroEmprestadoRepository.existsById(id)){
			livroEmprestadoRepository.deleteById(id);
		}else {
			throw new RuntimeException("Livro emprestado não encontrado");
		}
	}

	@Override
	@GetMapping("/{id}")
	public Optional<LivroEmprestado> buscarEmprestimo(@PathVariable Long id) {
		return livroEmprestadoRepository.findById(id);
	}

	@Override
	@GetMapping
	public List<LivroEmprestado> listarEmprestimo() {
		return livroEmprestadoRepository.findAll();
	}

}
