package com.cjc.hl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.Defaulter;
import com.cjc.hl.main.servicei.DefaulterServicei;

@CrossOrigin("*")
@RestController
public class DefaulterController 
{
	@Autowired
	DefaulterServicei ds;
	
	@PostMapping(value = "/saveDefaulter")
	public String saveDefaulter(Defaulter df)
	{
		ds.saveDefaulter(df);
		return "saved Defaulter";
	}
	
	
	@GetMapping(value = "/getDefaulters")
	public List<Defaulter> getDefaulters()
	{
		List<Defaulter> list=ds.getDefaulters();
		return list;
	}
}
