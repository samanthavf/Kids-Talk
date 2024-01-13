package Cadastro.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastroMapper {
    @Bean
    ModelMapper modelMapper() {
    	 ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
    
}
