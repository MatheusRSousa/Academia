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

import Projeto.dtos.AdicionarAlunoDTO;
import Projeto.dtos.AtualizarAlunoDTO;
import Projeto.models.Aluno;
import Projeto.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findByAllAlunos(){
		return new ResponseEntity<List<Aluno>>(service.findByAllAlunos(), HttpStatus.OK);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Aluno>> findByAluno(@PathVariable Long id){
		return new ResponseEntity<Optional<Aluno>>(service.findByAluno(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> createAluno(@RequestBody AdicionarAlunoDTO aluno){
		return new ResponseEntity<Aluno>(service.createAluno(aluno), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> updateAluno(@RequestBody AtualizarAlunoDTO aluno){
		return new ResponseEntity<Aluno>(service.updateAluno(aluno), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAluno(@PathVariable Long id) {
		service.deleteAluno(id);
	}
	

}
