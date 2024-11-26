package com.biblioteca.back_endbiblioteca.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.back_endbiblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	List<Livro> findByAutor(String autor);
	
	List<Livro> findByTitulo(String titulo);
	
	List<Livro> findByAno(int ano);
	
	List<Livro> findByEditora(String editora);
	
	//List<Livro> findByClassificacao(String classificacao);
	
	List<Livro> findByDataCadastroAfter(LocalDate dataCadastro);
	
	Optional<Livro> findByIsbn(String isbn);
}
