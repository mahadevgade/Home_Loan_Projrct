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
public class LoanGeneration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loangenid;	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	public Enquiry enquiry;
	
	@OneToOne(cascade = CascadeType.ALL)
	public ProfessionalDetails professionalDetails;
   
	private double roi;
	private int loantenure;	
	private double currentemi;
	private double loanamtgen;
	private String status;
	


}
