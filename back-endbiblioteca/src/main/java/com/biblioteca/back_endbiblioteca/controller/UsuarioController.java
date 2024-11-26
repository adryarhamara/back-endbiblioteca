package com.biblioteca.back_endbiblioteca.controller;

import com.biblioteca.back_endbiblioteca.model.Usuario;
import com.biblioteca.back_endbiblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController implements InterfaceUsuario {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*@GetMapping("/login")
	public List<Usuario> Login() {
		return usuarioRepository.findAll();
	}
    */
	@PostMapping("/login")
	public String autenticar(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, Model model) {
		Optional<Usuario> user = usuarioRepository.findByUsuario(usuario);
		if (user.isPresent() && user.get().getSenha().equals(senha)) {
			model.addAttribute("usuario", user.get());
			return "paginainical"; //nome inicial da pagina(figma)
		}
		model.addAttribute("Error: Usuário ou senha inválidos");
		return "Login";
	}

	@PostMapping
	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/{id}")
	@Override
	public Usuario alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
		if(usuarioExistente.isPresent()) {
			Usuario u = usuarioExistente.get();
			u.setUsuario(usuario.getUsuario());
			u.setSenha(usuario.getSenha());
			return usuarioRepository.save(u);
		}else {
			throw new RuntimeException("Usuário não encontrado com ID: " + id);
		}
	}

	@DeleteMapping("/{id}")
	@Override
	public void excluirUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		
	}

	@GetMapping("/{id}")
	@Override
	public Optional<Usuario> buscarUsuario(@PathVariable Long id) {
		return usuarioRepository.findById(id);
	}

	@GetMapping
	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}
	
	}

