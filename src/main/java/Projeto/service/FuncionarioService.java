package Projeto.service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Projeto.models.Funcionario;
import Projeto.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder cryp;
	
	public List<Funcionario> findByAllFuncionario(){
		return repository.findAll();
	}
	
	public Optional<Funcionario> findByFuncionario(Long id){
		return repository.findById(id);
	}
	
	public Funcionario createFuncionario(Funcionario funcionario) {
		Funcionario fun = getFuncionarioSenhaCript(funcionario);
		repository.save(fun);
		return fun;
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario) {
		 if(repository.existsById(funcionario.getMatricula())){
			 return repository.save(funcionario);
		 }
		 return null;
	}
	
	public void deleteFuncionario(Long id) {
		repository.deleteById(id);
	}
	
	public Funcionario findByEmail(String email) {
		return repository.findByEmail(email);
	}

	private Funcionario getFuncionarioSenhaCript(Funcionario funcionario) {
		Funcionario aux = new Funcionario(funcionario.getNome(),funcionario.getCpf(),
				cryp.encode(funcionario.getPassword()),funcionario.getEmail(), funcionario.getTipoUsuario());
		return aux;
	}
}
