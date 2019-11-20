package Projeto.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Projeto.dtos.AdicionarAlunoDTO;
import Projeto.dtos.AtualizarAlunoDTO;
import Projeto.models.Aluno;
import Projeto.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;
	
	@Autowired
	ExercicioService eService;
	

	
	@Autowired
	private BCryptPasswordEncoder cryp;
	
	public List<Aluno> findByAllAlunos(){
		return repository.findAll();
	}
	
	public Optional<Aluno> findByAluno(Long id){
		return repository.findById(id);
	}
	
	public Aluno createAluno(AdicionarAlunoDTO aluno1) {
		Aluno aluno2 = new Aluno();
		aluno2.setCpf(aluno1.getCpf());
		aluno2.setEmail(aluno1.getEmail());
		aluno2.setNome(aluno1.getNome());
		aluno2.setPassword(aluno1.getPassword());
		aluno2 = getAlunoSenhaCript(aluno2);
		repository.save(aluno2);
		return aluno2;
	}
	
	public Aluno updateAluno(AtualizarAlunoDTO aluno1) {
		 if(repository.existsById(aluno1.getMatricula())){
				Aluno aluno2 = repository.findById(aluno1.getMatricula()).get();
				aluno2.setEmail(aluno1.getEmail() == null ? aluno2.getEmail() : aluno1.getEmail());
				aluno2.setNome(aluno1.getNome() == null ? aluno2.getNome() : aluno1.getNome());
				aluno2.getExercicios().addAll(eService.findByAllExercicios(aluno1.getIdsExercicio()));
				repository.save(aluno2);
				return aluno2;
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
