package com.biblioteca.back_endbiblioteca.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.back_endbiblioteca.model.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	Optional<Funcionario> findByFuncionario(String funcionario);

	Optional<Funcionario> findByCpf(String cpf); //buscar por cpf
	
	Optional<Funcionario> findByEmailString(String emailString); //buscar por email
	
	List<Funcionario> findByFuncao(String funcao); //buscar por função
	
	List<Funcionario> findByFuncionarioContaining(String funcionario); //buscar por nome funcionario
	
	List<Funcionario> findByDataNascimento(LocalDate dataNascimento); //buscar pela data de nascimento
	
	
}
