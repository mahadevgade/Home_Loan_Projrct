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

public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private int custid;

	@OneToOne(cascade = CascadeType.MERGE)
	private Enquiry enquiry;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress addr;

	@OneToOne(cascade = CascadeType.ALL)
	private ProfessionalDetails professionalDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private BankAccountDetails bankAccountDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PersonalAssetsDetails personalAssetDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantor_Details;

	@OneToOne(cascade = CascadeType.ALL)
	private AllDocuments aldocs;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SancationLetter sanctionLetter;
	
	
}
