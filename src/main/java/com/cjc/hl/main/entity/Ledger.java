package com.cjc.hl.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ledger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ledgerId;
	private String ledgerCreatedDate;
	private double ledgerTotalLoanAmount;
	private double ledgerPayableAmountWithInterest;
	private int ledgerTenure;
	private double ledgerMonthlyEmi;
	private double ledgerAmountPaidTillDate	;	
	private String ledgerNextEmiDate;	
	private String ledgerEmiStatus;	
	private String ledgerCurrentMonthEmiStatus;
	private String ledgerLoanEndDate;
	private String status;
}
