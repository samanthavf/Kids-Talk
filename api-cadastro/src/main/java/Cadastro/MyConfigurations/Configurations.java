package Cadastro.MyConfigurations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Configurations {

	//http://localhost:8080/project/registers
	@GetMapping("/registers")
	public String showRegisterPage() {
	    return "register.html";
	}

	//http://localhost:8080/project/login
	@GetMapping("/login")
	public String showLoginPage() {
	    return "Login.html";
	}
	
	//http://localhost:8080/project/site
	@GetMapping("/site")
	public String showSitePage() {
		return "site.html";
	}
	
}
