package Cadastro.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {
@NotBlank(message = "name cannot be empty") 
 private String name;
@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
@NotBlank(message = "e-mail cannot be empty")
@Column(unique = true) 
 private String email;
@NotBlank(message = "password cannot be empty")
private String password;

	
}
