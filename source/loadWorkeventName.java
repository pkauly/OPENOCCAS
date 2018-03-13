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
     	String sql;
     	sql = "SELECT * from workeventname where workeventnamenr = " + wenr + " and businessprocedurenr = " + busnr + ";";
 	wen = runsql(sql);
	return wen;

}

public workeventname loadWorkeventNameByBNr(String busnr)
{

	System.out.println("loadWorkeventNAme Creating statement...");
      	String sql;
     	sql = "SELECT * from workeventname where businessprocedurenr = " + busnr + ";";
 	wen = runsql(sql);	
	return wen;
}

public String getnextWorkeventNameNR()
{
	return wen.getnextworkeventnamenr();	
}

private workeventname runsql(String sql)
{
	Statement stmt = null;
	System.out.println("loadWorkeventName runsql " + sql);

	workeventname wen = new workeventname();	
	try {
		stmt = conn.createStatement();
      		ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()) {
         //Retrieve by column name
         		String id  = rs.getString("id");
         		wen.setworkeventnamenr(rs.getString("workeventnamenr"));
        		wen.setbusinessprocedurenr(rs.getString("businessprocedurenr"));
        		wen.setprocessid(rs.getString("processid"));
        		wen.setworkeventname(rs.getString("workeventname"));
        		wen.seteventtype(rs.getString("eventtype"));
        		wen.setnextworkeventnamenr(rs.getString("nextworkeventmamenr"));
       			wen.setoccasionnr(rs.getString("occasionnr"));
 
         //Display values
         		System.out.print("ID: " + id);
         		System.out.print(", workeventnamenr " + wen.getworkeventnamenr());
         		System.out.print(", businessprocedurenr: " + wen.getbusinessprocedurenr());
         		System.out.print(", processid: " + wen.getprocessid());
         		System.out.print(", workeventname: " + wen.getworkeventname());
         		System.out.print(", eventtype: " + wen.geteventtype());
         		System.out.print(", nextworkeventmamenr: " + wen.getnextworkeventnamenr());
         		System.out.println(", occasionnr: " + wen.getoccasionnr());
			break;
      		}
      //STEP 6: Clean-up environment
      	rs.close();
      	stmt.close();
   	}	
	catch(SQLException se) {
      //Handle errors for JDBC
      		se.printStackTrace();
   	}	
	catch(Exception e){
      //Handle errors for Class.forName
      		e.printStackTrace();
   	}	
	finally{
      //finally block used to close resources
      	try{
         if(stmt!=null)
            stmt.close();
      	}
	catch(SQLException se2){
      	}// nothing we can do

   }//end try

	return wen;
}

}
