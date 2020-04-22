package com.example.Whathg_Database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Whathg_Database.DTO.CompanyDTO;
import com.example.Whathg_Database.DTO.EducationDTO;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.model.Education;
import com.example.Whathg_Database.repository.CompanyRepository;
import com.example.Whathg_Database.repository.EducationRepository;
import com.example.Whathg_Database.service.CompanyService;
import com.example.Whathg_Database.service.EducationService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Education_contoller {


	

	 @Autowired
	 EducationService educationService; 

	 @Autowired
		
	EducationRepository educationRepository;


@PostMapping(value="/educationsave")
public ResponseEntity<Education> save(@RequestBody EducationDTO educationDTO){
	   System.out.println("education save call");
	  return educationService.createEducationDTO(educationDTO); 
}
 
@GetMapping("/education")
public ResponseEntity<List<Education>> getEducation() {
	  return educationService.getEducations();
}
 

 



}