package Utils;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;

public class CreateUsers {
	
	public static CadastroModel createUser() {
		CadastroModel model = new CadastroModel();
	return model;
	}

	public static CadastroModel createUserValid() {
		CadastroModel modelValid = new CadastroModel(1L, "teste", "testid@gmail.com", "test");
	return modelValid;
	}
	
	public static userDTO createUserdto(userDTO data) {
		userDTO modeldto = userDTO.builder().name("test").email("test").password("test").build();
	return modeldto;
	}
}
