package com.cjc.hl.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.LoanGeneration;
import com.cjc.hl.main.repository.LoanGenerationRepository;
import com.cjc.hl.main.servicei.LoanGenerationService;

@Service
public class LoanGenerationServiceiceImpl implements LoanGenerationService {

	@Autowired
	LoanGenerationRepository lr;

	@Override
	public LoanGeneration saveLoanAmtLoan(LoanGeneration ln) {
System.out.println(ln);
		double debitentry = ln.getProfessionalDetails().getSalary() * 40 / 100;

		double x = (ln.getProfessionalDetails().getSalary() - debitentry - ln.getCurrentemi()) * 12;

		double loanamountgen = (x * ln.getLoantenure());

		System.err.println(loanamountgen);

		double y = loanamountgen - loanamountgen * (ln.getRoi() / 100);

		System.err.println(y);

		ln.setLoanamtgen(y);

		return lr.save(ln);

	}

	@Override
	public List<LoanGeneration> getLoanamt() {
		
		return lr.findAll();
	}

}