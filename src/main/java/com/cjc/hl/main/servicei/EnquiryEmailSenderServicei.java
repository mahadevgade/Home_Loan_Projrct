package com.cjc.hl.main.servicei;

import javax.mail.MessagingException;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.EnquiryEmailSender;
import com.cjc.hl.main.entity.SancationLetter;

public interface EnquiryEmailSenderServicei {
	
	public void sendEnquiryMail(EnquiryEmailSender e);

	public void sendRejectionDocsmail(EnquiryEmailSender e);

	

	public SancationLetter sendSantionLetterMail(SancationLetter s) throws MessagingException;



}
