package com.example.Whathg_Database.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Whathg_Database.DTO.CompanyDTO;
import com.example.Whathg_Database.Error.NotFoundException;
import com.example.Whathg_Database.Mapper_Imalmation.CompanyLMP;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.repository.CompanyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	private static final CompanyLMP companyLMP = new CompanyLMP();


	// create company 
	public ResponseEntity<Company> createcompanyDTO(CompanyDTO companyDTO) {
		Company company = Company.builder()
				.email(companyDTO.getEmail())
				.phoneNumber(companyDTO.getPhoneNumber())
				.address(companyDTO.getAddress())
				.password(companyDTO.getPassword())
				.CR(companyDTO.getCR())
				.comanyName(companyDTO.getComanyName())
				.StartDate(companyDTO.getStartDate())
				.EndDate(companyDTO.getEndDate())
				.build();

		Company savecompany = companyRepository.save(company);
		companyLMP.domainToDto(savecompany);
		 return new ResponseEntity<>(savecompany, HttpStatus.CREATED);
	}

	
	
	
	 public ResponseEntity<List<Company>> getCompanis(){
		 List<Company> com = new ArrayList<Company>();
		 companyRepository.findAll().forEach(com::add);
	        return new ResponseEntity<>(com , HttpStatus.OK);

		//return (List<Company>) comRepository.findAll();
	 }

	//Find Company
	public Company getById(String cr) {
		try {
			return companyRepository.findById(cr).get();
		}
		catch (NoSuchElementException ex) {
			throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", cr));
		}
	}


	//Deleting company
	public void deleteCompany(String cr) {
	
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();
			companyRepository.deleteById(cr);
			companyLMP.domainToDto(existingCompany); 

	}


	//Update Email Company 

	public CompanyDTO updateEmailcompanyDTO(String cr , String email) {

		companyRepository.updateEmail(cr, email);	
			Company existingCompany = getById(cr); 
			//Company existingCompany = comRepository.findById(cr).get();

			return companyLMP.domainToDto(existingCompany); 


	}

	//Update Phone Number Company
	public CompanyDTO updatePhoneNumbercompanyDTO(String cr , String PhoneNumber) {

		companyRepository.updatePhoneNumber(cr, PhoneNumber);
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();
			return companyLMP.domainToDto(existingCompany); 

	}


	//Update Address for Company

	public CompanyDTO updateAddresscompanyDTO(String cr , String address) {

		companyRepository.updateAddress(cr, address);
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();
			return companyLMP.domainToDto(existingCompany); 


	}


	public CompanyDTO updatePasswordcompanyDTO(String cr , String pass) {

		companyRepository.updatePassword(cr, pass);
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();
			return companyLMP.domainToDto(existingCompany); 


	}




	public CompanyDTO updateStartDatecompanyDTO(String cr , Timestamp startDate) {

		companyRepository.updateStartDate(cr, startDate);
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();
			return companyLMP.domainToDto(existingCompany); 

	}



	public CompanyDTO updateEndDatecompanyDTO(String cr , Timestamp endDate) {
	
		companyRepository.updateEndDate(cr, endDate);
			Company existingCompany = getById(cr);  
			//Company existingCompany = comRepository.findById(cr).get();

			return companyLMP.domainToDto(existingCompany); 
	
	}

}