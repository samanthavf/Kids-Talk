package Cadastro.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import Cadastro.DTOs.userDTO;
import Cadastro.Service.CadastroService;
import Utils.CreateUsers;
import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class CadastroRepositoryTest {
	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private CadastroService cadastroService;
	@Mock
	private CadastroRepository cadastroRepository;

	
	@Test
	@DisplayName("Find users by e-mail")
	void findByEmail_Found(){
		String email = "testejpa@gmail.com";
		userDTO dto = userDTO.builder().name("test").email(email).password("test").build();
		CreateUsers.createUserdto(dto);
	assertThat(cadastroRepository.findAll()).isNotEqualTo(email);
	assertThat(dto).isNotNull();
	assertThat(dto.getEmail()).isEqualTo(email);
	}
	
	/*@Test
	@DisplayName("save users when successful")
	void create_User(){
		CadastroModel salvar = CreateUsers.createUser();
		salvar.setId(35L);
		salvar.setName("test");
		salvar.setEmail("test@");
		salvar.setPassword("test"); 
	   this.cadastroRepository.save(salvar);
		assertThat(salvar).isNotNull();
		assertThat(salvar.getId()).isNotNull();
		assertThat(salvar.getName()).isEqualTo(salvar.getName());
		
 
	}
	
	@Test
	@DisplayName("delete when successful")
	void delete_User(){
		CadastroModel salvar = CreateUsers.createUser();
		this.cadastroRepository.save(salvar);
		this.cadastroRepository.delete(salvar);
		Optional<CadastroModel> id  =this.cadastroRepository.findById(salvar.getId());	
		assertThat(id).isEmpty();
	}
	
	@Test
	@DisplayName("email can't be equals")
	void create_User_fail() throws Exception {
		String email = "testejpa@gmail.com";
		CadastroModel user = CreateUsers.createUser();
		user.setName("testejpa");
		user.setEmail(email);
		user.setPassword("teste");
		this.cadastroRepository.save(user);
		
		CadastroModel model = CreateUsers.createUser();
		model.setName("test");
		model.setEmail("sam@gmail.com");
		model.setPassword("test");
		this.cadastroRepository.save(model);
		assertThat(model.getEmail()).isNotEqualTo(user.getEmail());
	}*/
}
