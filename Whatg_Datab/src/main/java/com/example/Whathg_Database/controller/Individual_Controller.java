package com.example.Whathg_Database.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.Whathg_Database.DTO.CompanyDTO;
import com.example.Whathg_Database.DTO.IndividualDTO;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.model.Individual;
import com.example.Whathg_Database.repository.IndividualsRepository;
import com.example.Whathg_Database.service.IndividualService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Individual_Controller {

	
	@Autowired
	
	IndividualService individualService;
	
	
	@Autowired
	IndividualsRepository IndvRepository;
	
	
	
	@PostMapping(value="/Indsave")
	public ResponseEntity<Individual> save(@RequestBody IndividualDTO individualDTO){
		   System.out.println("Individual save call");
		  return individualService.createIndividualDTO(individualDTO); 
	}
	
	
	@GetMapping("/Indi")
	 public ResponseEntity<List<Individual>> getIndividual() {
		  return individualService.getIndividuals();
		  
	}
	
	
	@RequestMapping("/findIndividual")
	public String find(){
		individualService.getById("1089582538"); 
	return "Done for Company";
	}
	
	
	
	
	

	
	//***************************
	
//	@RequestMapping("/ADDIndividual")
//
//	public String process() {
//
//		individualService.createIndividualDTO(individualDTO);
//
//		return "add";
//
//	}
	
	//******************************************************************************************
	
	
	
//	@PostMapping(value="/Indsave")
//	
//	
//	
//	public IndividualDTO save(@RequestBody IndividualDTO individualDTO){
//		   System.out.println("company save call");
//		  return individualService.individualService(individualDTO); 
//	}
	
	
	
	
	
	
	
	
	
	
	
	

	

}

