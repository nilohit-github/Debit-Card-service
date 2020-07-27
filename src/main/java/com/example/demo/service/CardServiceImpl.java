package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DebitCard;
import com.example.demo.repository.CardRepository;

@Service
@Transactional
public class CardServiceImpl implements CardService {
	
	@Autowired
	CardRepository cardrepo;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Optional<DebitCard> findCard(String cardno) {
		// TODO Auto-generated method stub
		
				Optional<DebitCard> searchedcard = cardrepo.findById(cardno);
			
						return searchedcard;
				

	}

	@Override
	public Collection<DebitCard> findAllCards() {
		// TODO Auto-generated method stub
		
		return cardrepo.findAll();
		
	}
	
	
	
	@Override
	public DebitCard create(DebitCard savecard) {
		// TODO Auto-generated method stub
		
		return cardrepo.save(savecard);
		
	}

	@Override
	public DebitCard updateInfo(String cardno) {
		// TODO Auto-generated method stub
		DebitCard searchedcard = cardrepo.findById(cardno).orElse(null);
		if(searchedcard == null)
		{
			logger.error("This required card to update is not found");
			throw new NoResultException("Requested entity not found");			
		}
	
		searchedcard.setCustomerName("tim cook");
		return cardrepo.save(searchedcard);
			
				
	}

	@Override
	public void deleteCard(String cardno) {
		// TODO Auto-generated method stub
		
		cardrepo.deleteById(cardno);
		
	}
	
	

}
