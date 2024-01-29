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
public class EmiCalculator 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emiid;
	private double emi;
	private int tenure;
	private double roi;
	private Double loanamt;//(principal amount)
	
	

}
