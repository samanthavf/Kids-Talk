package Cadastro.RepositoryCard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cadastro.ModelCard.CardModel;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
	List<CardModel> findByObject(String object);

	void deleteByObject(CardModel cardModels);

}
