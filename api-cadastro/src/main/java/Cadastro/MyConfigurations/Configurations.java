package Cadastro.MyConfigurations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Configurations {

	@GetMapping("/index")
	public String showRegisterPage() {
	    return "index.html";
	}

	@GetMapping("/login")
	public String showLoginPage() {
	    return "Login.html";
	}
	
	@GetMapping("/site")
	public String showSitePage() {
		return "site.html";
	}
	
}
