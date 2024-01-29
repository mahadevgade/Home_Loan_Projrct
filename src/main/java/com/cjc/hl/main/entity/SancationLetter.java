package com.cjc.hl.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class SancationLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanctionid;
	private String fname;
	private String lname;
	private String emailId;
	private double loanamtgen;
	private double roi;
	private int loantenure;
	private double	monthlyEmi;
	
	@Lob
	private byte[] sanctionLetter;

}
