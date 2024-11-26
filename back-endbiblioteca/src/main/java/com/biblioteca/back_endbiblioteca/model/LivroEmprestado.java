package com.biblioteca.back_endbiblioteca.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LivroEmprestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Long idEmprestimo;

    @Column(name = "id_livroemprestado", nullable = false)
    private String idlivroEmprestado;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "classificacao", nullable = false)
    private String classificacao;

    @Column(name = "matricula", nullable = false, unique = true, length = 8)
    private String matricula;

    @Column(name = "nome_aluno", nullable = false)
    private String nomeAluno;

    @Column(name = "email_aluno", nullable = false)
    private String emailAluno;

    @Column(name = "curso_aluno", nullable = false)
    private String cursoAluno;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "data_emprestimo", columnDefinition = "DATE")
    private LocalDate dataEmprestimo;

    @Column(name = "data_entrega", columnDefinition = "DATE")
    private LocalDate dataEntrega;

    public LivroEmprestado() {
    }

    public LivroEmprestado(Long idEmprestimo, String idLivroEmprestado, String titulo, String autor, String classificacao, String matricula, String nomeAluno,
                           String emailAluno, String cursoAluno, String observacao, LocalDate dataEmprestimo, LocalDate dataEntrega) {
        this.idEmprestimo = idEmprestimo;
        this.idlivroEmprestado = idLivroEmprestado;
        this.titulo = titulo;
        this.autor = autor;
        this.classificacao = classificacao;
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
        this.cursoAluno = cursoAluno;
        this.observacao = observacao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataEntrega = dataEntrega;
    }
}

