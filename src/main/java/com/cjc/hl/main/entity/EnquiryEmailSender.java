package com.cjc.hl.main.entity;

import javax.xml.bind.annotation.XmlRootElement;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryEmailSender {
	
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textMessage;

}
