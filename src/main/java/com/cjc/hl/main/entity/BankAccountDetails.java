package com.cjc.hl.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlRootElement
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountID;
	private String accountHolderName;
	private long accountNo;
	private String accountType;
	
}
