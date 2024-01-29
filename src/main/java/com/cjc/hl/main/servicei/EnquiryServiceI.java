package com.cjc.hl.main.servicei;

import java.util.List;

import com.cjc.hl.main.entity.Enquiry;

public interface EnquiryServiceI {

	public	void postEnquirydata(Enquiry eq);

	public List<Enquiry> getEnquirydata();

	public Enquiry getEnquirybyId(int id);



}
