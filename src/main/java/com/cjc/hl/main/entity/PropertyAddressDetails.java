package com.cjc.hl.main.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlRootElement@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PropertyAddressDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paddressId;
	private String areaName;
	private String cityName;
	private String landMark;
	private int pincode;
	private String taluka;
	private String district;
	private String state;
	

}
