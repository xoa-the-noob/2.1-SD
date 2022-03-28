
import java.sql.*;


import java.sql.*;


public class databaseAdd {
   private Connection con;
   private Statement st;
   private ResultSet rs;
   
   public databaseAdd()
   {
       try{
          Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/greenline","root","");
           st=con.createStatement();
       }catch(Exception ex)
       {
           System.out.println("Erros: "+ex);
       }
    }
   public void getData(){
       try{
           String query="select * from transport";
           rs=st.executeQuery(query);
           System.out.println("records from Database");
           while(rs.next()){
               String id=rs.getString("id");
               String number=rs.getString("number");
               String seats=rs.getString("seats");
               String fare=rs.getString("fare");
               System.out.println("ID: "+id+"\n"+"Number: "+number+"\n"+"seats: "+seats+"\n"+"fare: "+fare+"\n");
               
           }
       }catch(Exception ex){
           System.out.println(ex);
       }
   }
   public void setData(int $id, String $number, int $seats,int $fare)
    {
        try
        {
            String sql="insert into transport values('"+$id+"','"+$number+"','"+$seats+"','"+$fare+"')";
            st.executeUpdate(sql);
            getData();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

