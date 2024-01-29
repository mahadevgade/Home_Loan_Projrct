package com.cjc.hl.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.Disbursement;
import com.cjc.hl.main.servicei.CustomerDetailsServicei;
import com.cjc.hl.main.servicei.DisbursementServicei;

@CrossOrigin("*")
@RestController
public class DisbursementController 
{
	@Autowired
	DisbursementServicei dsi;
	
	

	@PostMapping(value = "/saveDisbursement")
	public String saveDisbursement(@RequestBody Disbursement dis)
	{
		System.err.println(dis);
		
		 dsi.saveDisbursement(dis);
		
		return "Saved";
	}
	
	
	@GetMapping(value = "/getDisbursement")
	public List<Disbursement> getDisbursement()
	{

		List<Disbursement> dis=dsi.getDisbursement();
		
		return dis;
	}
	
	
	
	
}
