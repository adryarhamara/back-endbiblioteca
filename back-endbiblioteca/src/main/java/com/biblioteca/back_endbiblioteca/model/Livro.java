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
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false)
    private String classificacao;

    @Column(nullable = false)
    private int numeroPaginas;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String observacao;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, int ano, String editora, String classificacao, int numeroPaginas,
                 String isbn, String observacao, LocalDate dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
        this.classificacao = classificacao;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", editora='" + editora + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", observacao='" + observacao + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
