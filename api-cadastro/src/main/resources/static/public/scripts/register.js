/**
 * 
 */
function salvarUsuario(){
var name = $("#name").val()
var email = $("#email").val()
var password = $("#password").val()


$.ajax({
    url: "registers/user",
    type: "POST",
    data: JSON .stringify({name : name, email: email, password: password}),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
        alert("Saved User");
        window.location.href= "http://localhost:8080/login"
    },
    error: function () {
        alert("error") 
    }
}); 

}

function validarEmail(){
	var email = document.getElementById('email')
	var errormensage = document.getElementById('textemail')
	var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
	
	if(regex.test(email.value)){
		errormensage.textContent= ""
	}else{
		errormensage.textContent= "invalid e-mail"
}
}

function validarSenha(){
	var password = document.getElementById('password')
	var errormensage = document.getElementById('senha')
	var regex = /^.{6,}$/
	
	if(regex.test(password.value)){
		errormensage.textContent= ""
	}else{
		errormensage.textContent= "password must have up to 6 characters"
	}

}

function confirmarSenha(){
var password = $("#password").val()
var confirm = $("#confirmPassword").val()
var error = document.getElementById('senhaError')

     if (password !== confirm) {
         error.textContent = "do not match";
          return false;
     } else {
         error.textContent = "";
         return true;
    }	
}

document.getElementById('entrar').addEventListener("click", function(){
	window.location.href= "http://localhost:8080/login"
})


