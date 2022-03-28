 import java.io.FileOutputStream;  
 import java.sql.Connection;  
 import java.sql.ResultSet;  
 import java.sql.Statement;  
 import com.itextpdf.text.Document;  
import com.itextpdf.text.Paragraph;
 import com.itextpdf.text.Phrase;  
 import com.itextpdf.text.pdf.PdfPCell;  
 import com.itextpdf.text.pdf.PdfPTable;  
 import com.itextpdf.text.pdf.PdfWriter;  
 
 
 
 public class Pdf_Generating {   
     public static void main(String[] args) throws Exception{ 
         
        
         
         Connection conn = DBConnect.connect();  
         Statement stmt = conn.createStatement();  
         
         ResultSet query = stmt.executeQuery("Select firstName, lastName,email,phon from passenger_details");  
           
         Document PDF_Ticket = new Document();  
         PdfWriter.getInstance(PDF_Ticket, new FileOutputStream("F:\\PDFFORBUSTICKET\\ticket.pdf"
                 + ""
                 + ""));  
         PDF_Ticket.open();        
         
        //table columns 
         PdfPTable Table = new PdfPTable(4);  
         //creating cell  
         PdfPCell table_cell;  
         while (query.next()) { 
                 
                 Table.addCell("    First name   ");
                 Table.addCell("    Last name   ");
                 Table.addCell("    email       ");
                 Table.addCell("    Phone       ");
                
                 String firstName  = query.getString("firstName");  
                 table_cell=new PdfPCell(new Phrase(firstName));  
                 Table.addCell(table_cell); 
                 
                 
                 String lastName=query.getString("lastName");  
                 table_cell=new PdfPCell(new Phrase(lastName));  
                 Table.addCell(table_cell);  
                 
                 
                 String email=query.getString("email");  
                 table_cell=new PdfPCell(new Phrase(email));  
                 Table.addCell(table_cell);
                 
                 
                 /*Space dite chaile lekhar majhe */
                //PDF_Ticket.add(new Paragraph(" "));
                 
                 String phon=query.getString("phon");  
                 table_cell=new PdfPCell(new Phrase(phon));  
                 Table.addCell(table_cell);
                 
                 
                 
                 
                 
                 }  
         /* Attach report table to PDF */  
         PDF_Ticket.add(Table);              
         PDF_Ticket.close();  
         /* Close all DB related objects */  
         query.close();  
         stmt.close();   
         conn.close(); 


         
     }  
 } 