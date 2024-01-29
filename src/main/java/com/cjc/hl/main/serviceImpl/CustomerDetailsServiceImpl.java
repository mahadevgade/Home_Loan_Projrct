package com.cjc.hl.main.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.repository.CustomerDetailsRepository;
import com.cjc.hl.main.servicei.CustomerDetailsServicei;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsServicei
{

	@Autowired
	CustomerDetailsRepository cr;

	@Override
	public void saveAllDocuments(CustomerDetails docs) {
		
		cr.save(docs);
		
	}

	

	@Override
	public List<CustomerDetails> getAllCustomerDetails() 
	{
		
		return cr.findAll();
	}



	@Override
	public CustomerDetails getCustomerDetailsById(int id) {
		
		return cr.findById(id).get();
	}



	









	

	

	

	




	
	
}
