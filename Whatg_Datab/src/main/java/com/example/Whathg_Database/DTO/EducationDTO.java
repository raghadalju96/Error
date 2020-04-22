package com.example.Whathg_Database.DTO;

import java.sql.Timestamp;

import javax.validation.constraints.Email;

import com.example.Whathg_Database.model.Individual;
import com.example.Whathg_Database.model.User_W;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationDTO  extends User_W{
	  
	  private String Edu_iD;
	  
	
	  private String EDU_NAME;

	  
	  
	  
	  
	

	
	public EducationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}








	public EducationDTO(String email, String phone_number, String address, String password, String edu_iD,
			String eDU_NAME) {
		super(email, phone_number, address, password);
		Edu_iD = edu_iD;
		EDU_NAME = eDU_NAME;
	}
	
	
	


	  
}
