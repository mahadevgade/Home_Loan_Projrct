package com.cjc.hl.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.Enquiry;
import com.cjc.hl.main.repository.EnquiryRepository;
import com.cjc.hl.main.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{
	
	@Autowired
	EnquiryRepository er;

	@Override
	public void postEnquirydata(Enquiry eq) {
		
		er.save(eq);
		
		System.out.println(eq);
		
	}

	@Override
	public List<Enquiry> getEnquirydata() {
		
		return er.findAll();
	}

	@Override
	public Enquiry getEnquirybyId(int id) {
		
		return er.findById(id).get();
	}

}
