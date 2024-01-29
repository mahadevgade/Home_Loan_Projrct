package com.cjc.hl.main.controller;


import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.SancationLetter;
import com.cjc.hl.main.servicei.SanctionLetterservicei;


@CrossOrigin("*")
@RestController
public class SanctionLetterController
{
	@Autowired
	SanctionLetterservicei sl;

	@PutMapping(value = "/getSanctionLetter")
	public ResponseEntity<InputStreamResource> getSanctionLetter(@RequestBody SancationLetter s)
	{
		
		
		
		System.out.println(sl);
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.add("Content-Disposition", "inline;filename=SanctionLetter.pdf");
		ByteArrayInputStream pdfArray=sl.getSanctionLetter(s);
		
		
		
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdfArray));
		
		
	
	}

	@GetMapping("/getsanLetter")
	public ResponseEntity<List<SancationLetter>> getsanLetter()
	{
		List<SancationLetter> list=sl.getSanLetter();
		return new ResponseEntity<List<SancationLetter>>(list,HttpStatus.OK);
	}
}
