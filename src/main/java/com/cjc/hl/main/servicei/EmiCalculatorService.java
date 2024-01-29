package com.cjc.hl.main.servicei;

import java.util.List;

import com.cjc.hl.main.entity.EmiCalculator;

public interface EmiCalculatorService
{
	public EmiCalculator generateEmi(EmiCalculator ec);

	public List<EmiCalculator> getcalculatedEmi();

	public EmiCalculator getcalculatedEmi(int id);

}
