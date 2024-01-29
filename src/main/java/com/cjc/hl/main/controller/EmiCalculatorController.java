package com.cjc.hl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.EmiCalculator;
import com.cjc.hl.main.servicei.EmiCalculatorService;

@CrossOrigin("*")
@RestController
public class EmiCalculatorController
{
	@Autowired
	EmiCalculatorService ecs;
	@PostMapping("/generateEmi")
	public ResponseEntity<EmiCalculator>  generateEmi(@RequestBody EmiCalculator ec)
	{
		EmiCalculator calculator = ecs.generateEmi(ec);
		return new ResponseEntity<>(calculator,HttpStatus.OK);
		
	}
//	@GetMapping("/getcalculatedEmi")
//	public List<EmiCalculator> getcalculatedEmi()
//	{
//		List<EmiCalculator> emi = ecs.getcalculatedEmi();
//		return emi;
//		
//	}
	@GetMapping("/getcalculatedEmi/{emiid}")
	public ResponseEntity<EmiCalculator>  getcalculatedEmi(@PathVariable("emiid")int id)
	{
		EmiCalculator emi = ecs.getcalculatedEmi(id);
		return new ResponseEntity<>(emi,HttpStatus.OK);
		
	}

}

