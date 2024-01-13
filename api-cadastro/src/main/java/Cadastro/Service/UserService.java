package Cadastro.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Repository.CadastroRepository;
import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final CadastroRepository cadastro;//ADCIONA FINAL PARA FAZER INJEÇÃO DE DEPENDENCia
	private final ModelMapper modelMapper;	

	
	@NonNull
	@Transactional
	public CadastroModel create(userDTO user) throws Exception {
		List<CadastroModel> usuarioexiste = cadastro.findByEmail(user.getEmail());
		if (!usuarioexiste.isEmpty()) {
			throw new Exception("usuário já existente com esse email " + user.getEmail());
		}
		CadastroModel cadastroModel = new CadastroModel();
		cadastroModel = cadastro.save(modelMapper.map(user, CadastroModel.class));
		return cadastroModel;
	}
}
