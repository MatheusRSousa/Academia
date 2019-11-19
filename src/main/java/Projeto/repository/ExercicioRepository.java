package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projeto.models.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

}
