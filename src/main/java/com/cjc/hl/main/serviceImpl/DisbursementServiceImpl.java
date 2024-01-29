package com.cjc.hl.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.Disbursement;
import com.cjc.hl.main.repository.CustomerDetailsRepository;
import com.cjc.hl.main.repository.DisbursementRepository;
import com.cjc.hl.main.servicei.DisbursementServicei;


@Service
public class DisbursementServiceImpl implements DisbursementServicei
{
	@Autowired
	DisbursementRepository dr;
	
	
	@Override
	public void saveDisbursement(Disbursement dis) 
	{

		 dr.save(dis);
	}


	@Override
	public List<Disbursement> getDisbursement() 
	{
		
		return dr.findAll();
	}


	@Override
	public Disbursement saveDisbursementStatus(Disbursement d) 
	{
		d.setDisbursementStatus("EMI Paid");
		Disbursement dis=dr.save(d);
		return dis;
	}

	

}
