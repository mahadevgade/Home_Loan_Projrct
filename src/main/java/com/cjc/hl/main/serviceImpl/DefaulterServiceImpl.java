package com.cjc.hl.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.Defaulter;
import com.cjc.hl.main.repository.DefaulterRepository;
import com.cjc.hl.main.servicei.DefaulterServicei;

@Service
public class DefaulterServiceImpl implements DefaulterServicei
{

	@Autowired
	DefaulterRepository dr;

	@Override
	public void saveDefaulter(Defaulter df)
	{
		
		dr.save(df);
	}

	@Override
	public List<Defaulter> getDefaulters() 
	{
		
		return dr.findAll();
	}
}
