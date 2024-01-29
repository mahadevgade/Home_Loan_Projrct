package com.cjc.hl.main.servicei;

import java.util.List;

import com.cjc.hl.main.entity.LoanGeneration;

public interface LoanGenerationService {

	public	LoanGeneration saveLoanAmtLoan(LoanGeneration ln);

	public List<LoanGeneration> getLoanamt();

	

}
