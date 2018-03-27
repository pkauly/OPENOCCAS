//manageBusinessnumber
// 

package objectmanagement;

import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.*;

public class manageBusinessnumber
{

private businessnumber busnr;
public Connection conn = null;
private static final int chs1 = 2;
private static final int chs2 = 3;
private static final int chs3 = 4;
private static final int chs4 = 5;
private static final int chs5 = 6;
private static final int chs6 = 7;
private static final int chs7 = 8;
private static final int chs8 = 9;
private static final int chs9 = 2;
private static final int chs10 = 3;
private static final int chs11 = 4;

public manageBusinessnumber() 
{
	conn = dbConnection.getInstance().getConnection();	
	busnr = new businessnumber("-1","-1","-1","-1");
}


public manageBusinessnumber(String id,
			String businessnumber, 
			String businessnumbertype, 
			String datecreated)
{
	conn = dbConnection.getInstance().getConnection();	
	busnr = new businessnumber(id,businessnumber,businessnumbertype,datecreated);
}

public businessnumber getbusinessNumberByID(String ibusinessnumber)
{
     	String sql;
     	sql = "SELECT * from businessnumber where businessnumber = " + ibusinessnumber + ";";
	System.out.println("manageBusinessnumber " + sql);
 	busnr = runsqlquery(sql);

	return busnr;
}

public businessnumber createbusinessNumber(String busnrtype)
{

	String sql;
	String id = "0";
     	sql = "insert into occascounter values (NULL);"; 
	Statement stmt = null;
	ResultSet rs = null;
	System.out.println("runsqlquery " + sql);
	try{
    		conn.setAutoCommit(false);
		stmt = conn.createStatement();
     		int rtv = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
      	rs = stmt.getGeneratedKeys();
      	if (rs.next()) id=rs.getString(1);
 		conn.commit();
		conn.setAutoCommit(true);
   
         	System.out.println("managebusinessnumber insert ID: " + id);
 
		rs.close();
      	stmt.close();
	}
	catch(SQLException se) {
      //Handle errors for JDBC
      		se.printStackTrace();
   	}	
	finally{
      //finally block used to close resources
      		try{
         		if(stmt!=null) stmt.close();
      		}
		catch(SQLException se2){
      		}// nothing we can do

  	}//end try

	
	String busnumber = generateBusNumber(id);
	System.out.println(" Num " + busnumber);
	sql = "insert into businessnumber (businessnumber,businessnumbertype) values (" + '"' + busnumber + '"' + "," + '"' + busnrtype + '"' + ");";
	System.out.println("runsqlquery " + sql);
	try{
 		stmt = conn.createStatement();
     		int rtv = stmt.executeUpdate(sql);
     
         	System.out.println("managebusinessnumber insert ID: " + id);
 
		rs.close();
      	stmt.close();
	}
	catch(SQLException se) {
      //Handle errors for JDBC
      		se.printStackTrace();
   	}	
	finally{
      //finally block used to close resources
      		try{
         		if(stmt!=null) stmt.close();
      		}
		catch(SQLException se2){
      		}// nothing we can do

  	}//end try	
	sql = "select * from businessnumber where businessnumber=" +  '"' + busnumber +  '"' + ";"; 
	businessnumber busnr = runsqlquery(sql);
	return busnr;
}

private String generateBusNumber(String id)  
{  
	Calendar cal = Calendar.getInstance();
	String dayofYear = Integer.toString(cal.get(Calendar.DAY_OF_YEAR));
	String year = Integer.toString(cal.get(Calendar.YEAR)).substring(2);
	System.out.println("manageBusinessnumber " + year + "/" + dayofYear);
	String counter = "000000" + id;
	int ci = counter.length();
	String dd = "00" + dayofYear;
	int cj = dd.length();
	
	String busnumber = year + dd.substring(cj-3) + counter.substring(ci-6);
	int a = Integer.parseInt(busnumber.substring(0,1)) * chs1;
	int b = Integer.parseInt(busnumber.substring(1,2)) * chs2;
	int c = Integer.parseInt(busnumber.substring(2,3)) * chs3;
	int d = Integer.parseInt(busnumber.substring(3,4)) * chs4;
	int e = Integer.parseInt(busnumber.substring(4,5)) * chs5;
	int f = Integer.parseInt(busnumber.substring(5,6)) * chs6;
	int g = Integer.parseInt(busnumber.substring(6,7)) * chs7;
	int h = Integer.parseInt(busnumber.substring(7,8)) * chs8;
	int i = Integer.parseInt(busnumber.substring(8,9)) * chs9;
	int j = Integer.parseInt(busnumber.substring(9,10)) * chs10;
	int k = Integer.parseInt(busnumber.substring(10,11)) * chs11;
	int l = (a + b + c + d + e + f + g + h + i + j + k) % 11;
	if (l > 9) l = 0;	 
	int su = (a + b + c + d + e + f + g + h + i + j + k);
	int rem = su % 11;
	System.out.println("Summe " + su + " rem " + rem);

	System.out.println("a " + a + " b " + b + " c " + c + " d " + d + " e " + e + " f " + f + " g " + g + 
				" h " + h + " i " + i + " j " + j + " k " + k + " l " + l);

	busnumber = busnumber + Integer.toString(l);

  return busnumber;  
}

private businessnumber runsqlquery(String sql)
{
	Statement stmt = null;
	System.out.println("runsqlquery " + sql);
	busnr = new businessnumber();
	try{
		stmt = conn.createStatement();
      	ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()){
         //Retrieve by column name
         		busnr.setid(rs.getString("id"));
         		busnr.setbusinessnumber(rs.getString("businessnumber"));
        		busnr.setbusinessnumbertype(rs.getString("businessnumbertype"));
        		busnr.setdatecreated(rs.getString("datecreated"));
    
         //Display values
         		System.out.print("runsqlquery ID: " + busnr.getid());
         		System.out.print(", businessnumber " + busnr.getbusinessnumber());
         		System.out.print(", businessnumbertype: " + busnr.getbusinessnumbertype());
         		System.out.println(", datecreated: " + busnr.getdatecreated());
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
	catch(Exception e) {
      //Handle errors for Class.forName
      		e.printStackTrace();
   	}	
	finally{
      //finally block used to close resources
      		try{
         		if(stmt!=null) stmt.close();
      		}
		catch(SQLException se2){
      		}// nothing we can do

  	}//end try
	

	return busnr;
}

}
