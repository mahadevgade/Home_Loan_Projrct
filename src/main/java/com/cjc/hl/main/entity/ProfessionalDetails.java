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
public class ProfessionalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professionId;
	private String professionType;
	private double salary;
	private String designation;

}
