package Projeto.dtos;

import java.util.List;

public class AtualizarAlunoDTO {

	private String nome;
	
	private String password;
	
	private String email;
	
	private List<Long> idsExercicio;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getIdsExercicio() {
		return idsExercicio;
	}

	public void setIdsExercicio(List<Long> idsExercicio) {
		this.idsExercicio = idsExercicio;
	}
	
	
}
