package Cadastro.ServiceCard;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import Cadastro.DTOsCard.dtoCard;
import Cadastro.ModelCard.CardModel;
import Cadastro.RepositoryCard.CardRepository;
import lombok.RequiredArgsConstructor;
import repository.Exception.BadRequestException;

@Service
@RequiredArgsConstructor
public class cardService {
	private final CardRepository cardRepository;
	private final ModelMapper mapper;
	
	public 	List<CardModel> getAll(){
		return cardRepository.findAll();
	}
	
	public List<CardModel> findByObject(String object){
		return cardRepository.findByObject(object);
	}

	public CardModel findById(Long id) {
		return cardRepository.findById(id).orElseThrow(()-> new BadRequestException("NOT FOUND"));
	}
	
	public CardModel create(dtoCard card) throws Exception {
		if (card.getObject() == null || card.getImage() == null) {
			throw new Exception("image and object cannot be null");
		}
		CardModel cardModel = cardRepository.save(mapper.map(card, CardModel.class));
		return cardModel;
	}
	
	public void deleteById(Long id) {
		cardRepository.delete(findById(id));
	}
	
	public void delete(String object) {
		List<CardModel> cardsToDelete = cardRepository.findByObject(object);
		for (CardModel card:cardsToDelete) {
			cardRepository.deleteByObject(card);
		}
	}
}
