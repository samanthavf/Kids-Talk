package Cadastro.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cadastro.DTOs.loginDTO;
import Cadastro.Service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
	private final LoginService loginService;
	
	@PostMapping("/userlogin")
	public ResponseEntity<String> login(@RequestBody @Valid loginDTO user) {
	    boolean isAuthenticated = loginService.authenticateUser(user);

	    if (isAuthenticated) {
	        return new ResponseEntity<>("Login bem-sucedido", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
	    }
	}
}
