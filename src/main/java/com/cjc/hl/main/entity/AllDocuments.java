package com.cjc.hl.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AllDocuments 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;

	@Lob
	private byte[] panCard;
	@Lob
	private byte[] adharCard;
	@Lob
	private byte[] bankPassbook;
	@Lob
	private byte[] offerLetter;
	@Lob
	private byte[] salarySlips;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] blankCheque;
	@Lob
	private byte[] propertyDocuments;
	@Lob
	private byte[] constructionQuotation;
	@Lob
	private byte[] guarantorAdharCard;
	@Lob
	private byte[] guarantorPanCard;
	@Lob
	private byte[] guarentorBankDetails;
	@Lob
	private byte[] guarantorJobDetails;
}
