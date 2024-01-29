package com.cjc.hl.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.Enquiry;
import com.cjc.hl.main.servicei.CibilServicei;

@CrossOrigin("*")
@RestController
public class CibilController {

	@Autowired
	CibilServicei cs;

//	@GetMapping("/generateCibil")
//	public int generateCibil( )
//	{
//		
//
//		int cibil_score=cs.generateCibil();
//		return cibil_score;
//	}
//	

	
	@PutMapping("/generateCibil/{enquiry_Id}")
	public Enquiry generateCibil(@RequestBody Enquiry eq, @PathVariable("enquiry_Id") int id) 
	
	{
		
		eq.setEnquiryid(id);

	  eq.getCibils().setCibil_id(id);
		
		System.out.println(id + " " + eq);

		Enquiry cibil_score = cs.generateCibil(eq, id);
		
	
		return cibil_score;

	}
	
	

}
