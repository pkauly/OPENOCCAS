//loadWorkeventName
// 
import java.util.*;
import java.sql.*;

public class loadWorkeventName
{
private workeventname wen = null;
public Connection conn = null;

public loadWorkeventName() 
{
 	conn = dbConnection.getInstance().getConnection();
}

public workeventname loadWorkeventNameByNr(String wenr,String busnr)
{
	int i = Integer.parseInt(wenr) - 1;
	Statement stmt = null;
	   try{
       //STEP 4: Execute a query
     		System.out.println("Creating statement...");
     		stmt = conn.createStatement();
     		String sql;
     		sql = "SELECT * from workeventname;";
      		ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()){
         //Retrieve by column name
         		String id  = rs.getString("id");
         		String workeventnamenr = rs.getString("workeventnamenr");
        		String businessprocedurenr = rs.getString("businessprocedurenr");
        		String processid = rs.getString("processid");
        		String workeventname = rs.getString("workeventname");
        		String occasionnr = rs.getString("occasionnr");


         //Display values
         		System.out.print("ID: " + id);
         		System.out.print(", workeventnamenr " + workeventnamenr);
         		System.out.print(", businessprocedurenr: " + businessprocedurenr);
         		System.out.print(", processid: " + processid);
         		System.out.print(", workeventname: " + workeventname);
         		System.out.println(", occasionnr: " + occasionnr);
      	}
      //STEP 6: Clean-up environment
      	rs.close();
      	stmt.close();
      	conn.close();
   	}	catch(SQLException se){
      //Handle errors for JDBC
      		se.printStackTrace();
   	}	catch(Exception e){
      //Handle errors for Class.forName
      		e.printStackTrace();
   	}	finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
	return wen;

}

public workeventname loadWorkeventNameByBNr(String busnr)
{
		return new workeventname("1","1","1","Schadeneriengis aufnehmen","S","2","5");
}

public String getnextWorkeventNameNR(String wenr)
{
	int i = Integer.parseInt(wenr) - 1;

	return wenr;	
}


}
