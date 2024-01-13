package Cadastro.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Service.CadastroService;
import Utils.CreateUsers;
import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
class CadastroControllerTest {
	@InjectMocks // quando se quer testar a classe em si
	private CadastroController cadastroController;
	@Mock // para todas as classes que esstao dentro ca classe do injectmocks
	private CadastroService cadastroService;
	@Mock
	private EntityManager entityManager;
	
		
	@BeforeEach
	private void setup() throws Exception {
		PageImpl<CadastroModel> modelpage =	new PageImpl<>(List.of(CreateUsers.createUser()));
		
		BDDMockito.when(cadastroService.getAll( ArgumentMatchers.any()))
		.thenReturn(modelpage);
		
		BDDMockito.when(cadastroService.findById(Mockito.anyLong())).thenReturn(CreateUsers.createUserValid());
		
		BDDMockito.when(cadastroService.save(ArgumentMatchers.any(userDTO.class)))
	    .thenReturn(CreateUsers.createUserValid());
		
		BDDMockito.doNothing().when(cadastroService).delete(ArgumentMatchers.anyLong());
	}
	
	@Test
	@DisplayName("return all users")
	void getAll_List_Page(){		
		String created = CreateUsers.createUser().getName();

		Page<CadastroModel> cadastroPage = cadastroController.getAll(null).getBody();
		assertThat(cadastroPage).isNotNull();
		assertThat(cadastroPage.toList()).isNotEmpty().hasSize(1);
		assertThat(cadastroPage.toList().get(0).getName()).isEqualTo(created);
	}
	
	
	@Test
	@DisplayName("find user by id")
	void getBy_Id() {
		Long id = CreateUsers.createUserValid().getId();
		
		CadastroModel model = cadastroController.findCadastroById(1L).getBody();
		assertThat(model).isNotNull();
		assertThat(model.getId()).isNotNull().isEqualTo(id);

	}
	
	@Test
	@DisplayName("save users")
	void save() throws Exception {
		userDTO dto = userDTO.builder().name("test").email("test").password("test").build();
		CadastroModel model = cadastroController.save(CreateUsers.createUserdto(dto)).getBody();
		assertThat(model).isNotNull().isEqualTo(CreateUsers.createUserValid());
		
	}
	
	
	@Test
	@DisplayName("delete users")
	void delete_By_Id() throws Exception {
		assertThatCode(() -> cadastroController.delete(1L)).doesNotThrowAnyException();
		
		ResponseEntity<Void> model = cadastroController.delete(CreateUsers.createUserValid().getId());
		assertThat(model).isNotNull();
		assertThat(model.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
		
	}
	
	
	
}
