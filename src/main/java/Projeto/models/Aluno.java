package Projeto.models;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	@Email
	private String email;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Permissao_Aluno")
	private Set<Integer> tipo = new HashSet<Integer>();
	
	@Column(nullable = true)
	@ManyToMany
	private List<Exercicio> exercicios;
	
	@OneToMany
	private List<Presenca> presencas;
	

	
	public Aluno() {
		super();
	}


	public Aluno(String nome, @CPF String cpf, String senha, @Email String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.password = senha;
		this.email = email;
		this.tipo.add(1);
	}

	public Set<TipoUsuario> getTipo() {
		return tipo.stream().map(x -> TipoUsuario.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addTipo(TipoUsuario tipo) {
		this.tipo.add(tipo.getCod());
	}

	public List<Presenca> getPresencas() {
		return presencas;
	}


	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
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
