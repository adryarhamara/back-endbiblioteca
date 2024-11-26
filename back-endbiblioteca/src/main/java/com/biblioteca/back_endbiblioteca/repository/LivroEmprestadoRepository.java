package com.biblioteca.back_endbiblioteca.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.back_endbiblioteca.model.LivroEmprestado;

@Repository
public interface LivroEmprestadoRepository extends JpaRepository<LivroEmprestado, Long> {
	Optional<LivroEmprestado> findByTitulo(String titulo);
	List<LivroEmprestado> findByAutor(String autor);
	List<LivroEmprestado> findByClassificacao(String classificacao);
	List<LivroEmprestado> findByMatricula(String Matricula);
	List<LivroEmprestado> findByNomeAluno(String nomeAluno);
	List<LivroEmprestado> findByCursoAluno(String cursoAluno);
	List<LivroEmprestado> findByDataEmprestimo(LocalDate dataEmprestimo);
	List<LivroEmprestado> findByDataEntrega(LocalDate dataEntrega);
	List<LivroEmprestado> findByObservacao(String observacao);
	
}
