package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.DebitCard;

public interface CardService {

		Optional<DebitCard> findCard(String cardno);
		
		Collection<DebitCard> findAllCards();
		
		DebitCard updateInfo(String cardno);
		
		void deleteCard(String cardno);

		DebitCard create(DebitCard savecard);

}
