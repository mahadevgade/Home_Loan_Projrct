package com.cjc.hl.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Defaulter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int defaulterId;
	private String defaulterName;
	private long defaulterMobileNo;
	private String defaulterEmailId;
	private String status;

}
