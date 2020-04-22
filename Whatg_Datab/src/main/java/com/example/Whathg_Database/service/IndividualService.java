package com.example.Whathg_Database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Whathg_Database.DTO.IndividualDTO;
import com.example.Whathg_Database.Error.NotFoundException;
import com.example.Whathg_Database.Mapper_Imalmation.IndivdualMappelamp;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.model.Individual;
import com.example.Whathg_Database.repository.CompanyRepository;
import com.example.Whathg_Database.repository.IndividualsRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class IndividualService {

	/*
	 * private IndividualsRepository individualRepository; private
	 * IndivdualMappelamp individualMapper;
	 */


@Autowired
IndividualsRepository individualRepository;
private static final IndivdualMappelamp individualMapper = new IndivdualMappelamp();






public ResponseEntity<Individual> createIndividualDTO(IndividualDTO individualDTO) {
	
	Individual individual = Individual.builder()
			.email(individualDTO.getEmail())
            .phone_number(individualDTO.getPhoneNumber())
            .address(individualDTO.getAddress())
            .password(individualDTO.getPassword())
            
            .nationalID(individualDTO.getNationalID())
            .firstName(individualDTO.getFName())
            .mName(individualDTO.getMName())
            .lastName(individualDTO.getLName())
            .gender(individualDTO.getGender())
            .status(individualDTO.getStatus())
            .skills(individualDTO.getSkills())
            .dOB(individualDTO.getDateOfBirth())
            .attachments(individualDTO.getAttachments())
            
            .build();
	

    
//	Individual saveIndividual = individualRepository.save(individual);
//    return individualMapper.domainToDto(saveIndividual);
  //   return new ResponseEntity<>(saveIndividual, HttpStatus.CREATED);
    
    
    Individual saveIndividual = individualRepository.save(individual);
    individualMapper.domainToDto(saveIndividual);
	 return new ResponseEntity<>(saveIndividual, HttpStatus.CREATED);
    
    
    
}


public ResponseEntity<List<Individual>> getIndividuals(){
	 List<Individual> indi = new ArrayList<Individual>();
	 individualRepository.findAll().forEach(indi::add);
       return new ResponseEntity<>(indi , HttpStatus.OK);

	//return (List<Company>) comRepository.findAll();
}


public Individual getById(String Id) {
		try {
			return individualRepository.findById(Id).get();
		}
		catch (NoSuchElementException ex) {
			throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", Id));
		}
	}







}