
function singin(){
	event.preventDefault();
		var useremail = $('#email').val()
		var userpassword = $('#password').val()
		
$.ajax({
        type: "POST",
        url: "login/userlogin",
        data: JSON.stringify({ email: useremail, password: userpassword }),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            window.location.href = "http://localhost:8080/site";
        },
        error: function (error) {
            alert("Erro: invalid credentials");
        }
    });

	}
	
	
	function validarEmail(){
	var email = document.getElementById('email')
	var errormensage = document.getElementById('textEmail')
	var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
	
	if(regex.test(email.value)){
		errormensage.textContent= ""
	}else{
		errormensage.textContent= "invalid e-mail"
}
}


function validarSenha(){
	var password = document.getElementById('password')
	var errormensage = document.getElementById('textSenha')
	var regex = /^.{6,}$/
	
	if(regex.test(password.value)){
		errormensage.textContent= ""
	}else{
		errormensage.textContent= "password must have up to 6 characters"
	}

}
	
document.getElementById('voltar').addEventListener("click" , function(){
	window.location.href="http://localhost:8080/index"
})
	
	
	
	