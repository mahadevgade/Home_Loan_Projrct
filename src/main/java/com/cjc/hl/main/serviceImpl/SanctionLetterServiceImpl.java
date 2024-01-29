package com.cjc.hl.main.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.main.entity.CustomerDetails;
import com.cjc.hl.main.entity.LoanGeneration;
import com.cjc.hl.main.entity.SancationLetter;
import com.cjc.hl.main.repository.CustomerDetailsRepository;
import com.cjc.hl.main.repository.LoanGenerationRepository;
import com.cjc.hl.main.repository.SanctionLetterRepository;
import com.cjc.hl.main.servicei.SanctionLetterservicei;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class SanctionLetterServiceImpl implements SanctionLetterservicei {

	@Autowired 
	SanctionLetterRepository slr;
	
	
	
	
	String title = "Loan Sanction Letter";

	@Override
	public ByteArrayInputStream getSanctionLetter(SancationLetter s) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    //System.out.println(formatter.format(date)); 
	    
		

		

		
		
		
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now(); 
		   
		String to="Date :- "+dtf.format(now);
		  
		  
		  List<SancationLetter> list=new ArrayList<>();
		  list.add(s);
		  
		  
		  
		  String text1 = "\n Dear " +  s.getFname() +" "+ s.getLname() + ","
					+ "\n We hope this letter finds you in good health and high spirits. It is with great pleasure that we extend our formal approval for your loan application regarding the finance project. Congratulations on this significant milestone!";

			String text2 = "\n\tIf you have any queries or require further assistance, do not hesitate to contact our dedicated loan department.\r\n"
					+ "\r\n"
					+ "Once again, congratulations, and we look forward to a successful partnership with you.\r\n"
					+ ""
					
					+ "please do not hesitate to contact us.We wish you all the best and thank you for choosing us."
					+ "nSincerely,\n" + "Vaishali Keswad (Credit manager)";
		  
		  
		  
		  
		  
		  
		  String thanksText="\nThank You \n Regards, Bajaj Finance	..!";
		  
		  
		  
		  
			
			  //------------------->>>>>>>>>>>>> ByteArrayOutputStream --- Document is Stored in ByteArray format
			  
			  ByteArrayOutputStream out= new ByteArrayOutputStream();
			  
			  Document doc=new Document(PageSize.A4);
			  
			  //Data stored into doc needs to be converted into ByteArrayOutputStream
			  
			  PdfWriter.getInstance(doc, out);
			  
			  // This method converts doc data into ByteArrayOutputStream
			  
			  ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter.getInstance(doc, baos);
			  
			  doc.open();
			  
			  
			
				  Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,25);
				  titleFont.setColor(CMYKColor.CYAN);
				  
				  //Paragraph class is used to write data into paragraph
				  
				  Paragraph titlePara=new Paragraph(title,titleFont);
				  titlePara.setAlignment(Element.ALIGN_CENTER);
				  
				  //paragraph data is added into document 
				  doc.add(titlePara);
				  
				  Font toFont=FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,15);
				  Paragraph toPara=new Paragraph(to,toFont); toPara.setSpacingBefore(20);
				  doc.add(toPara);
				  
				  
				  Paragraph textPara=new Paragraph(text1); 
				  textPara.setSpacingBefore(10);
				  doc.add(textPara);
				  
				  Paragraph textPara1=new Paragraph(text2); 
				  textPara.setSpacingBefore(10);
				  doc.add(textPara1);
				  
				  
				  
				 /* -----------------------------------------------------------------------------
				  ----------------------------------- // TABLE //
				  -----------------------------------------------------------------------------
				  -----------------------------------*/
				  
				  
				  
				  PdfPTable table=new PdfPTable(4); 
				  table.setWidths(new int[] {2,3,5,3});
				  table.setWidthPercentage(100F);
				  table.setSpacingBefore(20);
				  
				  //--------Cell-------- 
				  PdfPCell headCell=new PdfPCell();
				  headCell.setPadding(5); 
				  headCell.setPaddingLeft(10);
				  headCell.setBackgroundColor(CMYKColor.YELLOW);
				  Font headCellFont=FontFactory.getFont(FontFactory.COURIER_BOLD);
				  
				  //--------Adding Phrase-------- 
				  headCell.setPhrase(new Phrase("Sanction Amount",headCellFont)); 
				  table.addCell(headCell);
				  headCell.setPhrase(new Phrase("Rate of Interest",headCellFont));
				  table.addCell(headCell); 
				  headCell.setPhrase(new Phrase("Loan Teneure",headCellFont)); 
				  table.addCell(headCell);
				  headCell.setPhrase(new Phrase("Monthly EMI",headCellFont));
				  table.addCell(headCell);
				  
				  
				  PdfPCell dataCell=new PdfPCell(); 
				   dataCell.setPadding(3);
				  
				   
				  list.forEach(s1->
				  {
					  System.out.println(s1);
					  	dataCell.setPhrase(new Phrase(String.valueOf(s.getLoanamtgen())));
						table.addCell(dataCell);
						dataCell.setPhrase(new Phrase(String.valueOf(s.getRoi())));
						table.addCell(dataCell);
						dataCell.setPhrase(new Phrase(String.valueOf(s.getLoantenure())));
						table.addCell(dataCell);
						dataCell.setPhrase(new Phrase(String.valueOf(s.getMonthlyEmi())));
						table.addCell(dataCell);
					  
				  });
				  
				  
						//dataCell.setPhrase(new Phrase(String.valueOf(s.getSanctionid())));
						//table.addCell(dataCell);
						
					
	 
						doc.add(table);
				  
				  Paragraph thanksPara=new Paragraph(thanksText);
				  thanksPara.setAlignment(Element.ALIGN_RIGHT);
				  
				  doc.add(thanksPara);
				  
				  doc.close();
				  
				  ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(baos.toByteArray());
				  byte[] bs = arrayInputStream.readAllBytes();

				  s.setSanctionLetter(bs);
					//reg.getSanctionLetter().setSanctionLetter(bs);
				  
				  
				
				  slr.save(s);
				  
				  
				  //To show data from ByteArrayOutputStream we need to store it inByteArrayInputStream stream 
				  return new ByteArrayInputStream(out.toByteArray());
				 
			 
		 
	}

	@Override
	public List<SancationLetter> getSanLetter() {
	
		return slr.findAll();
	}

}
