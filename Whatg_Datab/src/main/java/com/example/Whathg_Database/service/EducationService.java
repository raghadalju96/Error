package com.example.Whathg_Database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Whathg_Database.DTO.EducationDTO;
import com.example.Whathg_Database.Mapper_Imalmation.EducationlLMP;
import com.example.Whathg_Database.Mapper_Imalmation.ExperienceLMP;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.model.Education;
import com.example.Whathg_Database.repository.CompanyRepository;
import com.example.Whathg_Database.repository.EducationRepository;
import com.example.Whathg_Database.repository.ExperienceRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EducationService {



@Autowired
EducationRepository educationRepository;
private static final EducationlLMP educationlLMP = new EducationlLMP();


public ResponseEntity<Education> createEducationDTO(EducationDTO educationDTO) {
	
	Education education = Education.builder()
			
			
			.email(educationDTO.getEmail())
            .phone_number(educationDTO.getPhoneNumber())
            .address(educationDTO.getAddress())
            .password(educationDTO.getPassword())
            
            
			  .edu_iD(educationDTO.getEdu_iD())
			.eDU_NAME(educationDTO.getEDU_NAME())
          
            
            .build();
	
//	Education saveEducationl = educationRepository.save(education);
//    return educationlLMP.domainToDto(saveEducationl);
    
	Education saveeducation = educationRepository.save(education);
	educationlLMP.domainToDto(saveeducation);
	 return new ResponseEntity<>(saveeducation, HttpStatus.CREATED);
}




 public ResponseEntity<List<Education>> getEducations(){
	 List<Education> edu = new ArrayList<Education>();
	 educationRepository.findAll().forEach(edu::add);
        return new ResponseEntity<>(edu , HttpStatus.OK);

	//return (List<Company>) comRepository.findAll();
 }


}
