package com.cjc.hl.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlRootElement
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryid;
	private String fname;
	private String lname;
	private String dob;
	private String email_id;
	private long mob_no;
	private String panCardNo;
	private long adharCardNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibils;
	
	

}
