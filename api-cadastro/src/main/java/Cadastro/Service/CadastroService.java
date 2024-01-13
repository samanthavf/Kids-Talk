package Cadastro.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Repository.CadastroRepository;
import lombok.RequiredArgsConstructor;
import repository.Exception.BadRequestException;


@Service
@RequiredArgsConstructor
public class CadastroService {
	private final CadastroRepository cadastro;//ADCIONA FINAL PARA FAZER INJEÇÃO DE DEPENDENCia
	private final ModelMapper modelMapper;	
	
	
	public List<CadastroModel> findByEmail(String email){
		return cadastro.findByEmail(email);
	}
	
	public Page<CadastroModel> getAll(Pageable pageable){
		return cadastro.findAll(pageable);
	}

	public CadastroModel save(userDTO user) throws Exception {
		List<CadastroModel> usuarioexiste = cadastro.findByEmail(user.getEmail());
		if (!usuarioexiste.isEmpty()) {
			throw new Exception("usuário já existente com esse email " + user.getEmail());
		}
		CadastroModel cadastroModel = new CadastroModel();
		cadastroModel = cadastro.save(modelMapper.map(user, CadastroModel.class));
		return cadastroModel;
	}
	
	public CadastroModel findById(Long id) {
		return cadastro.findById(id).orElseThrow(() -> new BadRequestException("NOT FOUND"));
	}
	
	public void delete(Long id) {
		cadastro.delete(findById(id));
	}
	
}
