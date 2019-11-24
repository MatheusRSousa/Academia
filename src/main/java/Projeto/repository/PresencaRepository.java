package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projeto.models.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long>{

}
