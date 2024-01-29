package com.cjc.hl.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.EmiCalculator;
import com.cjc.hl.main.repository.EmiCalculatorRepository;
import com.cjc.hl.main.servicei.EmiCalculatorService;
@Service
public class EmiCalculatorServiceImpl  implements EmiCalculatorService{
@Autowired
EmiCalculatorRepository ecr;
	@Override
	public EmiCalculator generateEmi(EmiCalculator ec) 
	{
		System.err.println(ec.getLoanamt());
		System.err.println(ec.getTenure());
		System.err.println(ec.getRoi());
		Double loan = ec.getLoanamt();
		
		int tenure= ec.getTenure()*12;
		Double roi =ec.getRoi()/12/100;
		
		Double emi =loan*roi*(Math.pow(1+roi,tenure))/(Math.pow(1+roi,tenure)-1);
	// loan--->principal amount , rate--> rate of interest pm in% , Math.pow(1+rate,tenure)  pow--> power, (1+rate) raised to n , n --->tenure in months 
		ec.setEmi(emi);
		System.out.println(emi);
		return ecr.save(ec);
	}
	@Override
	public List<EmiCalculator> getcalculatedEmi() {
		
		return ecr.findAll();
	}
	@Override
	public EmiCalculator getcalculatedEmi(int id) {
	
		return ecr.findById(id).get();
	}
	
	
}
