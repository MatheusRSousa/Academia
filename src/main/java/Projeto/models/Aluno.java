package Projeto.models;



import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long matricula;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	@CPF
	private String cpf;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	@Email
	private String email;
	
	
	@Column(nullable = true)
	@ManyToMany
	private List<Exercicio> exercicios;
	

	
	public Aluno() {
		super();
	}


	public Aluno(String nome, @CPF String cpf, String senha, @Email String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.password = senha;
		this.email = email;
	}



	public List<Exercicio> getExercicios() {
		return exercicios;
	}


	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}


	public long getMatricula() {
		return matricula;
	}


	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String senha) {
		this.password = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
