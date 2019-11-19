package Projeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Projeto.models.Exercicio;
import Projeto.service.ExercicioService;

@Controller
@RequestMapping("/exercicio")
public class ExercicioController {

	@Autowired
	ExercicioService service;
	
	@GetMapping
	public ResponseEntity<List<Exercicio>> findByAllExercicios(){
		return new ResponseEntity<List<Exercicio>>(service.findByAllExercicios(), HttpStatus.OK);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Exercicio>> findByExercicio(@PathVariable Long id){
		return new ResponseEntity<Optional<Exercicio>>(service.findByExercicios(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Exercicio> createExercicio(@RequestBody Exercicio exercicio){
		return new ResponseEntity<Exercicio>(service.createExercicio(exercicio), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Exercicio> updateExercicio(@RequestBody Exercicio exercicio){
		return new ResponseEntity<Exercicio>(service.updateExercicio(exercicio), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExercicio(@PathVariable Long id) {
		service.deleteExercicio(id);
	}
}
