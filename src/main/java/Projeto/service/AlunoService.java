package Projeto.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Projeto.models.Aluno;
import Projeto.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder cryp;
	
	public List<Aluno> findByAllAlunos(){
		return repository.findAll();
	}
	
	public Optional<Aluno> findByAluno(Long id){
		return repository.findById(id);
	}
	
	public Aluno createAluno(Aluno aluno) {
		Aluno alu = getAlunoSenhaCript(aluno);
		repository.save(alu);
		return aluno;
	}
	
	public Aluno updateAluno(Aluno aluno) {
		 if(repository.existsById(aluno.getMatricula())){
			 return repository.save(aluno);
		 }
		 return null;
	}
	
	
	
	public void deleteAluno(Long id) {
		repository.deleteById(id);
	}

	public Aluno findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	private Aluno getAlunoSenhaCript(Aluno aluno) {
		Aluno aux = new Aluno(aluno.getNome(),aluno.getCpf(),cryp.encode(aluno.getPassword()),aluno.getEmail());
		return aux;
	}
}
