package Projeto.controllers;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Projeto.models.Funcionario;
import Projeto.service.FuncionarioService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Funcionario>> findByAllFuncionario(){
		return new ResponseEntity<List<Funcionario>>(service.findByAllFuncionario(), HttpStatus.OK);
	} 
	
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Funcionario>> findByFuncionario(@PathVariable Long id){
		return new ResponseEntity<Optional<Funcionario>>(service.findByFuncionario(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.createFuncionario(funcionario), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.updateFuncionario(funcionario), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		service.deleteFuncionario(id);
	}

}
