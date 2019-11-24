package Projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.models.Presenca;
import Projeto.repository.PresencaRepository;

@Service
public class PresencaService {

	@Autowired
	PresencaRepository repository;
	
	public void addPresenca(Presenca presenca) {
		repository.save(presenca);
	}
}
