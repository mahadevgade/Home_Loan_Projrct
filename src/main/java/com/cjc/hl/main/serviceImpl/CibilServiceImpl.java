package com.cjc.hl.main.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.Cibil;
import com.cjc.hl.main.entity.Enquiry;
import com.cjc.hl.main.repository.CibilRepository;
import com.cjc.hl.main.repository.EnquiryRepository;
import com.cjc.hl.main.servicei.CibilServicei;

@Service
public class CibilServiceImpl implements CibilServicei{
	
	
	@Autowired
	EnquiryRepository er;

//	@Override
//	public int generateCibil() {
//		
//		int cibil_score = ((int)(Math.random() * 100000)) % 1000;
//		
//	
//		return cibil_score;
//		
//
//	}


	@Override
	public Enquiry generateCibil(Enquiry eq, int id)

	{
Random r=new Random();
int cibil_score = r.nextInt(300,900);

//		int cibil_score = ((int) (Math.random() * 100000)) % 1000;
//	 return cibil_score;

//     System.out.println(cibil_score);

		if (cibil_score >= 650) {

			eq.getCibils().setCibil_score(cibil_score);
			eq.getCibils().setStatus("Approved");
			return er.save(eq);
		} else {

			eq.getCibils().setCibil_score(cibil_score);
			eq.getCibils().setStatus("Rejected");
			return er.save(eq);

		}

	}
}






















////Random r=new Random();
////int min=650;
////int max=900;
////int a=r.nextInt((max-min)+max);
////System.out.println(a);
////cibil.setCibilScore(a);	