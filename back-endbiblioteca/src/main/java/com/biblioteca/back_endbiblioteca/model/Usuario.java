package com.biblioteca.back_endbiblioteca.model;

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
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	public Usuario() {
		
	}
	public Usuario(Long id, String usuario, String senha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}
	
}
