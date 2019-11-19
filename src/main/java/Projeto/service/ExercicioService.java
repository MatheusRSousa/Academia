package Projeto.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.models.Exercicio;

import Projeto.repository.ExercicioRepository;

@Service
public class ExercicioService {

	@Autowired
	ExercicioRepository repository;
	
	public List<Exercicio> findByAllExercicios(){
		return repository.findAll();
	}
	
	public Optional<Exercicio> findByExercicios(Long id){
		return repository.findById(id);
	}
	
	public Exercicio createExercicio(Exercicio exercicio) {
		repository.save(exercicio);
		return exercicio;
	}
	
	public Exercicio updateExercicio(Exercicio exercicio) {
		 if(repository.existsById(exercicio.getId())){
			 return repository.save(exercicio);
		 }
		 return null;
	}
	
	public void deleteExercicio(Long id) {
		repository.deleteById(id);
	}
}
