/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
 import java.sql.Connection;  
 import java.sql.DriverManager;  
import java.sql.ResultSet;
 import java.sql.SQLException;  
import java.sql.Statement;
 public class DBConnect {  
   public static Connection con;  
   
   public static Statement st;
   public static ResultSet rs;
   
   /*
   public static String url = "jdbc:mysql://localhost:3306/bus";  
   public static String user = "root";//Username of database  
   public static String pass = "password";//Password of database  
   */
 
   public static Connection connect() throws SQLException{ 
       
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","");
           st=con.createStatement();
       }catch(Exception ex)
       {
           System.out.println("Erros: "+ex);
       }
       /*
     try{  
       Class.forName("com.mysql.jdbc.Driver").newInstance();  
     }catch(ClassNotFoundException cnfe){  
       System.err.println("Error: "+cnfe.getMessage());  
     }catch(InstantiationException ie){  
       System.err.println("Error: "+ie.getMessage());  
     }catch(IllegalAccessException iae){  
       System.err.println("Error: "+iae.getMessage());  
     }  
      */ 
     return con;  
   }  
   
   
   
   public static Connection getConnection() throws SQLException, ClassNotFoundException{  
     if(con !=null && !con.isClosed())  
       return con;  
     connect();  
     return con;  
   }  
 }  
 