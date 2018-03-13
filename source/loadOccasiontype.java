//loadOccasiontype
// 
import java.util.*;
import java.sql.*;

public class loadOccasiontype
{
private occasiontype oc = null;
public Connection conn = null;


public loadOccasiontype() 
{
 	conn = dbConnection.getInstance().getConnection();
}


public occasiontype getOccasiontypeByNR(String oct)
{
     	String sql;
     	sql = "SELECT * from occasiontype where occasionnr = " + oct + ";";
 	oc = runsql(sql);
	return oc;

}

public occasiontype getOccasiontypeByTNR(String oct)
{
     	String sql;
     	sql = "SELECT * from occasiontype where occasiontype = " + oct + ";";
 	oc = runsql(sql);
	return oc;

}


private occasiontype runsql(String sql)
{
	Statement stmt = null;

	occasiontype oc = new occasiontype();	
	try {
		stmt = conn.createStatement();
      		ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()) {
         //Retrieve by column name
         		oc.setid(rs.getString("id"));
         		oc.setoccasionnr(rs.getString("occasionnr"));
        		oc.setoccasiondescription(rs.getString("occasiondescription"));
        		oc.setoccasiontype(rs.getString("occasiontype"));
 
         //Display values
         		System.out.print("ID: " + oc.getid());
         		System.out.print(", occasionnr " + oc.getoccasionnr());
         		System.out.print(", occasiondescription: " + oc.getoccasiondescription());
         		System.out.println(", occasiontype: " + oc.getoccasiontype());
  
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

	return oc;
}

}
