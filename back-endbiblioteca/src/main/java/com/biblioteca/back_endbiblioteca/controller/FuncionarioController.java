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
import com.biblioteca.back_endbiblioteca.model.Funcionario;
import com.biblioteca.back_endbiblioteca.repository.FuncionarioRepository;


@RestController
@RequestMapping("api/v1/funcionarios")
public class FuncionarioController implements InterfaceFuncionario{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository; //Adiciona a injeção do repositório. Para referenciar o repositorio que interage com o banco de dados

	@Override
	@PostMapping
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
	}

	@Override
	@PutMapping("/{id}")
	public Funcionario alterarFuncionario(@PathVariable Long id, Funcionario funcionario) {
		if (funcionarioRepository.existsById(id)) {
			funcionario.setIdFuncionario(id);
			return funcionarioRepository.save(funcionario);
		}
		throw new RuntimeException("Funcionario não encontrado");
	}

	@Override
	@DeleteMapping("/{id}")
	public void excluirFuncionario(@PathVariable Long id) {
		if (funcionarioRepository.existsById(id)) {
			funcionarioRepository.deleteById(id);
		}else {
			throw new RuntimeException("Funcionario não encontrado");
		}
		
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Funcionario> buscarFuncionario(@PathVariable Long id) {
		return funcionarioRepository.findById(id);
	}

	@Override
	@GetMapping
	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

}
