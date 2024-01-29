package com.cjc.hl.main.servicei;

import java.util.List;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.Disbursement;

public interface DisbursementServicei {

	public void saveDisbursement(Disbursement dis);

	public List<Disbursement> getDisbursement();
	
	public Disbursement saveDisbursementStatus(Disbursement d);

}
