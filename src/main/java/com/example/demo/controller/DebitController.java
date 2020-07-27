package com.example.demo.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DebitCard;
import com.example.demo.service.CardService;

@RestController
public class DebitController {
	
	@Autowired
	CardService cservice;
	
	@PostMapping(value="/debit/create")
	public ResponseEntity<DebitCard> create(@RequestBody DebitCard dc)
	{
		DebitCard savedcard = cservice.create(dc);
		return new ResponseEntity<DebitCard>(savedcard, HttpStatus.OK);
		
		
		
	}
	
	@GetMapping(value="/debit/findall")
	public ResponseEntity<List<DebitCard>> findall()
	{
		Collection<DebitCard> savedcard = cservice.findAllCards();
		List<DebitCard> debitlist = new LinkedList<>(savedcard);
		
		debitlist.sort((s1,s2)->Integer.parseInt(s1.getCardno()) - Integer.parseInt(s2.getCardno()));
		
		return new ResponseEntity<List<DebitCard>>(debitlist, HttpStatus.OK);
		
		
		
	}
	
	@GetMapping(value="/debit/findallR")
	public ResponseEntity<List<DebitCard>> findallByR()
	{
		Collection<DebitCard> savedcard = cservice.findAllCards();
		List<DebitCard> debitlist = new LinkedList<>(savedcard);
		
		List<DebitCard> debitlistr = debitlist.stream().filter(s->s.getCustomerName().startsWith("R")).collect(Collectors.toList());
		
		return new ResponseEntity<List<DebitCard>>(debitlistr, HttpStatus.OK);
		
		
		
	}
	
	

}
