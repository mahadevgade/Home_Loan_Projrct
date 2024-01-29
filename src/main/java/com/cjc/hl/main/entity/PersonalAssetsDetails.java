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
public class PersonalAssetsDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int propertyId;
	private String propertyType;
	private double propertyValuation;
	private double constructionValuation;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyAddressDetails propertyAddress;
	
	

	

}
