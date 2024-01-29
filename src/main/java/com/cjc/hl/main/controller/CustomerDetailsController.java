package com.cjc.hl.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.hl.main.entity.AllDocuments;
import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.servicei.CustomerDetailsServicei;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@CrossOrigin("*")
//@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
public class CustomerDetailsController 
{

	@Autowired
	CustomerDetailsServicei cs;
	
	
	@PostMapping(value = "/saveAllDocuments")
	public String saveAllDocuments(@RequestParam(value = "panCard") MultipartFile panCard,
								@RequestParam(value = "adharCard") MultipartFile adharCard,
								@RequestParam(value = "bankPassbook") MultipartFile bankPassbook,
								@RequestParam(value = "offerLetter") MultipartFile offerLetter,
								@RequestParam(value = "blankCheque") MultipartFile blankCheque	,
								@RequestParam(value = "bankStatement") MultipartFile bankStatement,
								@RequestParam(value = "propertyDocuments") MultipartFile propertyDocuments,
								@RequestParam(value = "salarySlips") MultipartFile salarySlips,
								@RequestParam(value = "constructionQuotation") MultipartFile constructionQuotation,
								@RequestParam(value = "guarantorAdharCard") MultipartFile guarantorAdharCard,
								@RequestParam(value = "guarantorPanCard") MultipartFile guarantorPanCard,
								@RequestParam(value = "guarentorBankDetails") MultipartFile guarentorBankDetails,
								@RequestParam(value = "guarantorJobDetails") MultipartFile guarantorJobDetails,
								@RequestParam("data")String customerData ) throws Exception, JsonProcessingException
	{
		
		ObjectMapper om=new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		om.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	
		//	By default Jackson can access public fields for serialization and deserialization. If there's no public fields available then public getters/setters are used. We can customize this default behavior by the use of @JsonAutoDetect annotation.
        //@JsonAutoDetect annotation can be used to specify access visibility rules for fields and/or methods. Following is its snippet:
		
		// om.fasterxml.jackson.databind.exc.UnrecognizedPropertyException => by using this handle this exception 
		//The @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)  annotation can be used at the class level to override the visibility of the properties of a class during serialization and deserialization
		
		CustomerDetails docs=om.readValue(customerData, CustomerDetails.class);
		

		docs.setAldocs(new AllDocuments());
		
		docs.getAldocs().setPanCard(panCard.getBytes());
		docs.getAldocs().setAdharCard(adharCard.getBytes());
		docs.getAldocs().setBankPassbook(bankPassbook.getBytes());
		docs.getAldocs().setOfferLetter(offerLetter.getBytes());
		docs.getAldocs().setSalarySlips(salarySlips.getBytes());
		docs.getAldocs().setBlankCheque(blankCheque.getBytes());
		docs.getAldocs().setBankStatement(bankStatement.getBytes());
		docs.getAldocs().setPropertyDocuments(propertyDocuments.getBytes());
		docs.getAldocs().setConstructionQuotation(constructionQuotation.getBytes());
		docs.getAldocs().setGuarantorAdharCard(guarantorAdharCard.getBytes());
		docs.getAldocs().setGuarantorPanCard(guarantorPanCard.getBytes());
		docs.getAldocs().setGuarentorBankDetails(guarentorBankDetails.getBytes());
		docs.getAldocs().setGuarantorJobDetails(guarantorJobDetails.getBytes());
		
		
		
		
		
		cs.saveAllDocuments(docs);
		
		System.out.println(docs);
		
		return "All Documents Saved...!!!";
	}
	

	@GetMapping("/getAllCustomerDetails")
	public List<CustomerDetails> getAllCustomerDetails()
	{
		List<CustomerDetails> list= cs.getAllCustomerDetails();
		
		return list;
				
			
				
	}
	
	@GetMapping("/getCustomerDetailsById/{id}")
	public CustomerDetails getCustomerDetailsById(@PathVariable("id") int id)
	{
		
		
		return cs.getCustomerDetailsById(id);
				
			
				
	}
	
	
	

	
	
	
	
	
	
	

}
