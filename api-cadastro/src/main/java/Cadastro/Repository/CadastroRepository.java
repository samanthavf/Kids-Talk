package Cadastro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cadastro.Model.CadastroModel;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Long>{
	List<CadastroModel> findByEmail(String email);	
}
