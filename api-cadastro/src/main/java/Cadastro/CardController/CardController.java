package Cadastro.CardController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cadastro.DTOsCard.dtoCard;
import Cadastro.ModelCard.CardModel;
import Cadastro.ServiceCard.cardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
	private final cardService service;
	
	//localhost:8080/TallkwithCards/cards
	@GetMapping
	public ResponseEntity<List<CardModel>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	//localhost:8080/TallkwithCards/cards/card
	@PostMapping("/card")
	public ResponseEntity<CardModel> create(@RequestBody @Valid dtoCard card) throws Exception{
		return new ResponseEntity<>(service.create(card), HttpStatus.CREATED);
	}
	
	//localhost:8080/TallkwithCards/cards/{object}
	@DeleteMapping
	public ResponseEntity<Void> delete (@PathVariable String object){
		service.delete(object);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//localhost:8080/TallkwithCards/cards/id
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteByd(@PathVariable Long id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
