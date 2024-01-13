package Cadastro.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Repository.CadastroRepository;
import Utils.CreateUsers;
import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
class CadastroServiceTest {
	@InjectMocks // quando se quer testar a classe em si
	private CadastroService cadastroService;
	
	@Mock // para todas as classes que esstao dentro ca classe do injectmocks
	private CadastroRepository cadastroRepository;
	
	@Mock
	private EntityManager entityManager;
	
	@Mock
	private ModelMapper mapper;
	
	
	//1-trocar service por repository
	//2-trocar controller por service
		
	
	@BeforeEach
	private void setup() throws Exception {
		PageImpl<CadastroModel> modelpage =	new PageImpl<>(List.of(CreateUsers.createUser()));
		
		BDDMockito.when(cadastroRepository.findAll(ArgumentMatchers.any(PageRequest.class)))
		.thenReturn(modelpage);
		
		BDDMockito.when(cadastroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CreateUsers.createUserValid()));
		
		BDDMockito.when(cadastroRepository.save(ArgumentMatchers.any(CadastroModel.class)))
	    .thenReturn(CreateUsers.createUserValid());
				
		BDDMockito.doNothing().when(cadastroRepository).delete(ArgumentMatchers.any(CadastroModel.class));
	}
	
	@Test
	@DisplayName("return all users")
	void getAll_List_Page(){		
		String created = CreateUsers.createUser().getName();
		Page<CadastroModel> cadastroPage = cadastroService.getAll(PageRequest.of(1, 2));
		assertThat(cadastroPage).isNotNull();
		assertThat(cadastroPage.toList()).isNotEmpty().hasSize(1);
		assertThat(cadastroPage.toList().get(0).getName()).isEqualTo(created);
	}
	
	
	@Test
	@DisplayName("find user by id")
	void findBy_Id() {
		Long id = CreateUsers.createUserValid().getId();
		CadastroModel model = cadastroService.findById(1L);
		assertThat(model).isNotNull();
		assertThat(model.getId()).isNotNull().isEqualTo(id);
	}
	
	
	@Test
	@DisplayName("create users")
	void create() throws Exception  {
		userDTO dto = userDTO.builder().name("test").email("test").password("test").build();
		cadastroService.save(CreateUsers.createUserdto(dto));
		assertThat(dto).isNotNull().isEqualTo(CreateUsers.createUserdto(dto));	
	}
	
	
	@Test
	@DisplayName("delete users")
	void delete() throws Exception {
	assertThatCode(() -> cadastroService.delete(1L)).doesNotThrowAnyException();
	}
	

	
	
	
}
