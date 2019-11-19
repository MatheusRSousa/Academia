package Projeto.security;



import javax.persistence.Id;
public class AccountCredentials {
	@Id
	private Long id;
	private String email;
	private String senha;
	
	

	public String getCpf() {
		return email;
	}
	public void setCpf(String cpf) {
		this.email = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
