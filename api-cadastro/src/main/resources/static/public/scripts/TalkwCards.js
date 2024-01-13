function iniciarEstadoInicial() {
    var background = document.querySelector('.background');
    background.style.height = "210vh";
    background.style.position = "relative";
    background.style.left = " 5px";
    background.style.overflowY = "inherit";
    background.style.overflowX = "hidden";

    var container = document.querySelector('.container');
    container.classList.add('changed-container');

    var list = document.querySelector('.nav-list');
    list.classList.add('visible');

    var image = document.querySelector('.bgimage');
    image.classList.add('one-change-image');

    var cloudImage = document.querySelector('.cloud');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c1');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c2');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c3');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c4');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c5');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c6');
    cloudImage.classList.add('visible');

    var cloudImage = document.getElementById('c7');
    cloudImage.classList.add('visible');
    
}


function fet(){
	console.log('entrou')
	        $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/cards",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
			  console.log(data)
	          Initiswiper();
	          renderizarCards(data);
	          	          
	var fetContainer = document.querySelector('.swiper');
        fetContainer.classList.add('visible');
        inEmotion()
        inGame()
        inCard()    
	        },
            error: function (error) {
                alert(error);
            }
        });
        });
}



function make(){
	   var form = document.querySelector('.form');
    form.classList.add('visible');
    
    	var mk = document.getElementById('buttonMK');
    mk.classList.add('visible');
}


function Initiswiper(){
	console.log('entrou em swiper')
	var swiper = document.querySelector('.swiper');
	swiper.classList.add('visible');
	
        var swiper = new Swiper(".swiper", {
            cssMode: true,
            slidesPerView: 1,
            centerSlide: true,
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
            },
            keyboard: true,
        });
}

function renderizarCards(cards) {
  console.log('Entrou na função renderizar');

  var container = $('#cards-container');

 cards.forEach(function (card) {
    // Clone o modelo do formulário para cada cartão
    var novoFormulario = container.find('.modelo').clone();

    // Atualize a imagem e o nome do cartão
    novoFormulario.find('.cI').attr('src', card.image);
    novoFormulario.find('.cN').text(card.object);

    // Adicione o novo formulário ao container   
        container.append(novoFormulario);
    
     // Remova a classe de modelo do novo formulário
    novoFormulario.removeClass('modelo');
  });
}    






function image() {
var input = document.getElementById('img');
    var preview = document.getElementById('imagePreview');

    while (preview.firstChild) {
        preview.removeChild(preview.firstChild);
    }

      var file = input.files[0];
    
    
    if (file) {
       var reader = new FileReader();
        reader.onload = function (e) {
           var img = document.createElement('img');
            img.src = e.target.result;
            img.style.width = '100%';
            img.style.height = 'auto';
            preview.appendChild(img);
        };

        reader.readAsDataURL(file);
    }
}


function emotions(){
   var video = document.querySelector('.emotionV');        
        video.classList.add('visible');
        inFet()
        inGame()
        inCard()

}



function games(){
   var game = document.querySelector('.game');
     game.classList.add('visible');
      
        inFet()
        inEmotion()
        inCard()
	
}



function inGame(){
		var game = document.querySelector('.game');
	game.classList.remove('visible');
}


function inEmotion(){
	var video = document.querySelector('.emotionV');
	video.classList.remove('visible');
}


function inFet(){
	var fetContainer = document.querySelector('.swiper');
fetContainer.classList.remove('visible');

}
