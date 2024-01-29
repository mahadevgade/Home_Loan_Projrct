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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GuarantorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int guarantorId;
	private String guarantorName;

	private String guarantorDob;
	private long guarantorMobileNo;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorAddressDetails guntorAddDetails;

}
