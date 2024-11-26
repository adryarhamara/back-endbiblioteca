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
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@Column(name="funcionario", nullable=false)
	private String funcionario;
	
	@Column(name="email", nullable=false)
	private String emailString;
	
	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Column(name="funcao", nullable=false)
	private String funcao;
	
	@Column(name="datadenascimento")
	private LocalDate dataNascimento;
	
	@Column(name="observaçao")
	private String observacao;
	
	public Funcionario() {
		
	}
	public Funcionario(String funcionario, String emailString, String cpf, String funcao, LocalDate dataNascimento, String observacao) {
		super();
		this.funcionario = funcionario;
		this.emailString = emailString;
		this.cpf = cpf;
		this.funcao = funcao;
		this.dataNascimento = dataNascimento;
		this.observacao = observacao;
	}
	
}
