import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class CreatePDF {
	

	public static void main(String[] args) {
		Document cards= new Document();
		try {
			PdfWriter.getInstance(cards, new FileOutputStream("pdfcards.pdf"));
			cards.open();
			
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.getDefaultCell().setFixedHeight(100);
			
			Paragraph paragraph = new Paragraph();
			BaseFont baseF = BaseFont.createFont("lib/ARIAL.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
					
					Font black = new Font(baseF, 20, 0, BaseColor.BLACK);
					Font red = new Font(baseF, 20, 0, BaseColor.RED);
			
			//Font red = new Font(Font.FontFamily.TIMES_ROMAN, 20, 0, new BaseColor(255,0,0));
			//Font black = new Font(Font.FontFamily.TIMES_ROMAN, 20, 0, new BaseColor(0,0,0));
			
			String faceCard="";
			String face = "";
			char suit =  ' ';
		for (int i = 1; i < 14; i++) {
			
			if (i==1) {
				face="A";
			}
			else if (i==11) {
				face="D";
			}
			else if (i==12) {
				face="K";
			}
			else if (i==13) {
				face="J";
			}
			else {
				face="" +i;
			}
			for (int j = 0; j <4; j++) {
				
				switch (j) {
				case 0:
					
					 suit ='\u2660';
					
					break;
				case 1:
					 suit ='\u2663';
					
					break;
				case 2:
					 suit ='\u2665';
				
					 //color = red
					break;
				case 3:
					 suit ='\u2666';
					 
				
					 //color=red
					break;
				}
				faceCard = face + suit;
				if (j==0||j==1) {
					PdfPCell cell = new PdfPCell(new Paragraph(faceCard,black));
					cell.setFixedHeight(140f);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					
					

				}
				else {
					PdfPCell cell = new PdfPCell(new Paragraph(faceCard,red));
					cell.setFixedHeight(140f);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					
				}
				
			
				
				
			}
		}
	
		cards.add(table);
		
		cards.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
	

		}}

}
