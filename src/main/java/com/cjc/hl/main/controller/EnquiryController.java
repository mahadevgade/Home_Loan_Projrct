package com.cjc.hl.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.Enquiry;
import com.cjc.hl.main.servicei.EnquiryServiceI;


@CrossOrigin("*")
@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryServiceI es;
	
	
	@PostMapping("/postEnquirydata")
	public String postEnquirydata(@RequestBody Enquiry eq)
	{
		
		es.postEnquirydata(eq);
		
		return "add Data into Enquiry Data base";
		
	}
	
	@GetMapping("/getEnquirydata")
	public List<Enquiry> getEnquirydata()
	{
		return es.getEnquirydata();
		

	}
	
	@GetMapping("/getEnquirybyId/{enquiry_Id}")
	public Enquiry getEnquirybyId(@PathVariable("enquiry_Id") int id)
	{
	
		
		return es.getEnquirybyId(id);
		
		
	}


}
