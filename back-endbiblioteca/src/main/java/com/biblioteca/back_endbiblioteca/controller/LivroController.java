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

import com.biblioteca.back_endbiblioteca.model.Livro;
import com.biblioteca.back_endbiblioteca.repository.LivroRepository;

@RestController
@RequestMapping("api/v1/livros")
public class LivroController implements InterfaceLivro{
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	@PostMapping
	public Livro salvarLivro(@RequestBody Livro livro) {
		System.out.println("Recebendo dados: " +livro.toString());
		return livroRepository.save(livro);
	}

	@Override
	@PutMapping("/{id}")
	public Livro alterarLivro(@PathVariable Long id, @RequestBody Livro livro) {
		if(livroRepository.existsById(id)) {
		Optional<Livro> livroExistente = livroRepository.findById(id);
		if (livroExistente.isPresent()) {
			Livro atualizarLivro = livroExistente.get();
			atualizarLivro.setTitulo(livro.getTitulo());
			atualizarLivro.setAutor(livro.getAutor());
			atualizarLivro.setAno(livro.getAno());
			atualizarLivro.setEditora(livro.getEditora());
			atualizarLivro.setClassificacao(livro.getClassificacao());
			atualizarLivro.setNumeroPaginas(livro.getNumeroPaginas());
			atualizarLivro.setIsbn(livro.getIsbn());
			atualizarLivro.setObservacao(livro.getObservacao());
			atualizarLivro.setDataCadastro(livro.getDataCadastro());
			return livroRepository.save(atualizarLivro);
		}
	}
		throw new RuntimeException("Livro não encontrado");
	}
	@Override
	@DeleteMapping("/{id}")
	public void excluirLivro(@PathVariable Long id) {
		if(livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
		}else {
	
		throw new RuntimeException("Livro não encontrado");	
		}
}

	@Override
	@GetMapping("/{id}")
	public Optional<Livro> buscarLivro(@PathVariable Long id) {
		return livroRepository.findById(id);
	}

	@Override
	@GetMapping
	public List<Livro> listarTodos() {
		return livroRepository.findAll();
	}

}

