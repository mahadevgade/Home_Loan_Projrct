package com.cjc.hl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.LoanGeneration;
import com.cjc.hl.main.servicei.LoanGenerationService;



@CrossOrigin("*")
@RestController
public class LoanGenerationController {
	
	@Autowired
	LoanGenerationService ls;

	
	@PostMapping("/saveLoanAmtLoan")
	public ResponseEntity<LoanGeneration> saveLoanAmtLoan(@RequestBody LoanGeneration ln)
	{
		System.out.println(ln);

		
		LoanGeneration loan=	ls.saveLoanAmtLoan(ln);
	
		
		
		return new ResponseEntity<>(loan,HttpStatus.OK);
		
	}
	
	@GetMapping("/getLoanamt")
	public ResponseEntity<List<LoanGeneration>> getLoanamt()
	{
		List<LoanGeneration> list=ls.getLoanamt();
		return new ResponseEntity<List<LoanGeneration>>(list,HttpStatus.OK);
	}
	
}



//@PostMapping("/product")
//public ResponseEntity<Product> saveProduct(@RequestBody Product p)
//{
//	
//Product product=pi.saveProduct(p);
//
//return new ResponseEntity<>(product,HttpStatus.CREATED);
//
//}