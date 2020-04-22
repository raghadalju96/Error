package com.example.Whathg_Database.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Whathg_Database.DTO.CompanyDTO;
import com.example.Whathg_Database.Error.ResourceNotFoundException;
import com.example.Whathg_Database.model.Company;
import com.example.Whathg_Database.repository.CompanyRepository;
import com.example.Whathg_Database.service.CompanyService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
  public class Company_Contoller {
  
	 @Autowired
	 CompanyService companyService; 

@Autowired
CompanyRepository comRepository;

@PostMapping(value="/companysave")
public ResponseEntity<Company> save(@RequestBody CompanyDTO companyDTO){
	   System.out.println("company save call");
	  return companyService.createcompanyDTO(companyDTO); 
}
	
@GetMapping("/company")
public ResponseEntity<List<Company>> getCompanes() {
	  return companyService.getCompanis();
}


@RequestMapping("/findCompany")
public String find(){
	 companyService.getById("47446337634254"); 
return "Done for Company";
}








//@RequestMapping("/updateEmailCompany")
//public CompanyDTO updateEmail(){
//	 return  companyService.updateEmailcompanyDTO("47446337634254", "Ellm77@elm.sa");
//	 
////return companyDTO;
//}
// ebthaal code


//################
@DeleteMapping("/employees/{CRR}")
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "CRR") String CRR)
   throws ResourceNotFoundException {
	Company company = comRepository.findById(CRR)
 .orElseThrow(() -> new ResourceNotFoundException("Comany not found for this CRR :: " + CRR));

  comRepository.delete(company);
  Map<String, Boolean> response = new HashMap<>();
  response.put("deleted", Boolean.TRUE);
  return response;
}






@DeleteMapping("/employeesall/")
public String deleteallEmployee()
   {
	
 

  comRepository.deleteAll();
 
  
  return "done ";
}



//@RequestMapping("/UpdateEmail/{CR}")
//public String UEmail1(@PathVariable(value = "CR") String CR,String email) {
//	
//	 comRepository.updateEmail(CR, email);
//	//comRepository.updateEmail(getCR(),getEmail());
//	
//	
//	
//	return "Done";
//}
}







//@RequestMapping("/deleteCompany")
//public String  deleteCompany(){
//	   companyService.deleteCompany("47446337634254"); 
//	   
//return "Done for Company";
//}



  
  