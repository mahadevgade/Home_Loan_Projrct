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
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PreviousLoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int previousLoanId;
	private double previousLoanAmount;
	private int previousLoanTenure;
	private double previousLoanPaidAmount;
	private double previousLoanRemainingAmount;
	private int previousLoanDefaulterCount;
	private String previousLoanStatus;
	private String previousLoanRemark;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanBankDetails previousLoanBankDetails;
	

	

}
