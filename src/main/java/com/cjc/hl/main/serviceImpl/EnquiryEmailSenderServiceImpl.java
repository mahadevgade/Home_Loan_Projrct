package com.cjc.hl.main.serviceImpl;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.EnquiryEmailSender;
import com.cjc.hl.main.entity.SancationLetter;
import com.cjc.hl.main.servicei.EnquiryEmailSenderServicei;



@Service
public class EnquiryEmailSenderServiceImpl implements EnquiryEmailSenderServicei{
	
	@Autowired
	JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	String fromEmail;
	

	@Override
	public void sendEnquiryMail(EnquiryEmailSender e) 
	{
		
			SimpleMailMessage message= new SimpleMailMessage();
			
			message.setTo(e.getToEmail());
			message.setFrom(e.getFromEmail());
			message.setSubject(e.getSubject());
			message.setText(e.getTextMessage());
			
			sender.send(message);
		
		
	}


	@Override
	public void sendRejectionDocsmail(EnquiryEmailSender e)
	{
		
		SimpleMailMessage message= new SimpleMailMessage();
		
		message.setTo(e.getToEmail());
		message.setFrom(e.getFromEmail());
		message.setSubject(e.getSubject());
		message.setText(e.getTextMessage());
		
		sender.send(message);
	
		
	}


	@Override
	public SancationLetter sendSantionLetterMail(SancationLetter s) throws MessagingException
	{
		MimeMessage mimemessage = sender.createMimeMessage();
		byte[] sanctionLetter = s.getSanctionLetter();
		
		MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mimemessage, true);
		mimemessageHelper.setFrom(fromEmail);
		mimemessageHelper.setTo(s.getEmailId());
		mimemessageHelper.setSubject("Home Loan Sanction Letter");
		String text = "Dear " + s.getFname() + s.getLname()
				+ ",\n" + "\n"
				+ "This letter is to inform you that we have reviewed your request for a credit loan . We are pleased to offer you a credit loan of "
				+ s.getLoanamtgen() + " for "
				+ s.getLoantenure() + ".\n" + "\n"
				+ "We are confident that you will manage your credit loan responsibly, and we look forward to your continued business.\n"
				+ "\n"
				+ "Should you have any questions about your credit loan, please do not hesitate to contact us.\n"
				+ "\n" + "Thank you for your interest in our services.";

		mimemessageHelper.setText(text);

		mimemessageHelper.addAttachment("SanctionLetter.pdf", new ByteArrayResource(sanctionLetter));
		sender.send(mimemessage);
		
		return null;
	}


	


	






}
