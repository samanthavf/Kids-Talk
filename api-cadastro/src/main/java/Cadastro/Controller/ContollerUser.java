package Cadastro.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cadastro.DTOs.userDTO;
import Cadastro.Model.CadastroModel;
import Cadastro.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/registers")
public class ContollerUser {
	 private final UserService userService;
	 
	@PostMapping("/user")
	public ResponseEntity<CadastroModel> create(@RequestBody @Valid userDTO users) throws Exception{
		return new ResponseEntity<>(userService.create(users), HttpStatus.CREATED);	
		
	}
}
