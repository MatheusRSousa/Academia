package Projeto.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Projeto.models.Aluno;
import Projeto.models.Funcionario;
import Projeto.models.UserSecurity;

@Service
public class UsuarioDetalhesSecurityService implements UserDetailsService{

	@Autowired
	FuncionarioService funcService;
	
	@Autowired
	AlunoService alService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Funcionario funcionario = funcService.findByEmail(email);
		Aluno aluno = alService.findByEmail(email);
		
		if(aluno == null && funcionario == null) {
			throw new UsernameNotFoundException(email);
		}
		if(aluno != null) {
<<<<<<< HEAD
			return new UserSecurity(aluno.getMatricula(), aluno.getEmail(), aluno.getPassword(),aluno.getTipo());
		}
		return new UserSecurity(funcionario.getMatricula(), funcionario.getEmail(), funcionario.getPassword(),funcionario.getTipo());
=======
			return new UserSecurity(aluno.getMatricula(), aluno.getEmail(), aluno.getPassword(), aluno.getTipo());
		}
		return new UserSecurity(funcionario.getMatricula(), funcionario.getEmail(), funcionario.getPassword(), funcionario.getTipo());
>>>>>>> 0c48123bff91bee93e95fc9d9c9d409cd165f898
	}
}
