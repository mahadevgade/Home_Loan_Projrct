package com.cjc.hl.main.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.EnquiryEmailSender;
import com.cjc.hl.main.entity.SancationLetter;
import com.cjc.hl.main.repository.CustomerDetailsRepository;
import com.cjc.hl.main.repository.SanctionLetterRepository;
import com.cjc.hl.main.servicei.EnquiryEmailSenderServicei;


@CrossOrigin("*")
@RestController
public class EnquiryEmailSenderController {
	
	@Autowired
	EnquiryEmailSenderServicei es;
	
	@Autowired 
	CustomerDetailsRepository cr;
	
	@Autowired
	SanctionLetterRepository slr;
	
	
	@Value("${spring.mail.username}")
	String fromEmail;
	
	
	@GetMapping(value ="/sendEnquiryMail/{email}")
	public String sendEnquiryMail(@PathVariable String email)
	{
		EnquiryEmailSender e=new EnquiryEmailSender();
		e.setToEmail(email);
		e.setFromEmail(fromEmail);
		e.setSubject("Enquiry Request Processed");
		e.setTextMessage("We have received enquiry request for Home Loan. \nOur team is working on it. \nWe will get back to you soon.");
		
		try 
		{
			es.sendEnquiryMail(e);
		}
		catch (Exception e2) 
		{
			
			e2.printStackTrace();
			
			return "Email Can not be Send";
			
		}
		
		return "Email Sent Successfully";
	}
	
	
	 
	
	@GetMapping(value ="/sendRejectionDocsmail/{email}")
	public String sendRejectionDocsmail(@PathVariable String email)
	{
		EnquiryEmailSender e=new EnquiryEmailSender();
		System.out.println("hii");
		e.setFromEmail(fromEmail);
		e.setToEmail(email);
		e.setSubject("Document Verification purpose.");
		e.setTextMessage("We have received your application, although the application has  been rejected because we did not receive clear copies of your documents Handing in an appeal along with the blur copies will not be accepted. It will be rejected, because the application deadline is a definitive closing date We request you to mail the clear copies of the documents"
				+ "The same principle applies to rejections on grounds of missing documents We request you to mail the clear copies of the documents");
		
		try 
		{
			es.sendRejectionDocsmail(e);
		}
		catch (Exception e2) 
		{ 
			e2.printStackTrace();
			
			return "Email Can not be Send";
			
		}
		
		return "Email Sent Successfully";
	}
	
	
	@GetMapping(value = "/sendSanctionLetter/{sanctionid}")
	public SancationLetter sendSanctionLetter(@PathVariable Integer sanctionid ) throws Exception
	{
		
		Optional<SancationLetter> optional= slr.findById(sanctionid);
		
		SancationLetter s = optional.get();
		System.out.println(s);
		
		if(optional.isPresent())
		{
			es.sendSantionLetterMail(s);
		}
		else{
			throw new Exception();
		}
		
		return null;
	}
	

}
