package Cadastro.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Service.CadastroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api-configurations")
public class CadastroController {
	private final CadastroService cadastroService;
	
	//localhost:8080/TallkwithCards/api-configrations/api
	@GetMapping("/api")
	@ResponseBody
	public ResponseEntity<Page<CadastroModel>> getAll(Pageable pageable){
		return ResponseEntity.ok(cadastroService.getAll(pageable));
	}
	
	//localhost:8080/TallkwithCards/api-configrations/save
	@PostMapping("/save")
	public ResponseEntity<CadastroModel> save(@RequestBody @Valid userDTO dto) throws Exception{
		return new ResponseEntity<>(cadastroService.save(dto), HttpStatus.CREATED);
	}
	
	//localhost:8080/TallkwithCards/api-configurations/{id}
	@GetMapping(path  = "/{id}")
	public ResponseEntity<CadastroModel> findCadastroById(@PathVariable Long id){
		return ResponseEntity.ok(cadastroService.findById(id));
	}
	
	//localhost:8080/TallkwithCards/api-configurations/delete/{id}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		cadastroService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
