package com.cjc.hl.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disbursement 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int disbursementId;
	private String fname;
	private String lname;
	private String email_id;
	private long mob_no;
	private long accountNo;
	private double sanctionAmount;
	private String disbursementDate;
	private int disbursementAmount;
	private String disbursementStatus;

}
