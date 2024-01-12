package Cadastro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Cadastro.DTOs.loginDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Repository.CadastroRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class LoginService {
	private final CadastroRepository cadastro;//ADCIONA FINAL PARA FAZER INJEÇÃO DE DEPENDENCia
	
	//ESTUDAR
		public boolean authenticateUser(@Valid loginDTO user) {
			String email = user.getEmail();
			String pasword = user.getPassword();
			
			 // Busca o usuário pelo email no banco de dados
			List<CadastroModel> userexist = cadastro.findByEmail(email);
			if (!userexist.isEmpty()) {
				// Obtém o primeiro usuário encontrado (pode ser necessário ajustar a lógica dependendo dos requisitos)
				CadastroModel usuario = userexist.get(0);
				
				// Verifica se a senha fornecida corresponde à senha do usuário encontrado
				if (pasword.equals(usuario.getPassword())) {
					return true;
				}
			}
			
			return false;
		}
}
