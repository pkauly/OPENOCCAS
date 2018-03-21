//manageWorkevent
// 
import java.util.*;
import java.sql.*;

public class manageWorkevent
{

private workevent we;
public static Connection conn = null;

public manageWorkevent() 
{
 	conn = dbConnection.getInstance().getConnection();
	we = new workevent();
}

public workevent getWorkeventByID(String gid)
{
     	String sql;
     	sql = "SELECT * from workevent where id = " + gid + ";";
	System.out.println("manageWorkevent " + sql);
 	we = runsqlquery(sql);

	return we;
}

public workevent getcurrentWorkevent()
{
	return we;
}

public workevent createWorkevent(String workeventnamenr,
				String startworkeventnr,
				String objectreference,
				String occasiontype,
				String businessprocedurenr,
				String technicaloccasionnr,
				String technicalsourceoccasionnr, 
				String workitemnumber,
				String corelworkevent,
				String occasioninstance)
{
	we = new workevent();

	if (workeventnamenr != null) { we.setworkeventnamenr(workeventnamenr); }
	if (startworkeventnr != null) { we.setstartworkeventnr(startworkeventnr); }
	if (objectreference != null) { we.setobjectreference(objectreference); }
	if (occasiontype != null) { we.setoccasiontype(occasiontype);}
	if (businessprocedurenr != null) { we.setbusinessprocedurenr(businessprocedurenr);}
	if (technicaloccasionnr != null) { we.settechnicaloccasionnr(technicaloccasionnr);}
	if (technicalsourceoccasionnr != null) { we.settechnicalsourceoccasionnr(technicalsourceoccasionnr); }
	if (workitemnumber != null) { we.setworkitemnumber(workitemnumber);}
	if (corelworkevent != null) { we.setcorelworkevent(corelworkevent);}
	if (occasioninstance != null) { we.setoccasioninstance(occasioninstance);}

	Statement stmt = null;
     	String sql;
     	sql = "insert into workevent  (workeventnamenr,startworkeventnr,objectreference,occasiontype," +
					"businessprocedurenr,technicaloccasionnr,technicalsourceoccasionnr," +
					"workitemnumber,corelworkevent,occasioninstance) " + 
					"values (" + '"' + we.getworkeventnamenr() + '"' + "," + 
						'"' + we.getstartworkeventnr() + '"' + "," +
						'"' + we.getobjectreference() + '"' + "," +
						'"' + we.getoccasiontype() + '"' + "," +
						'"' + we.getbusinessprocedurenr() + '"' + "," +
						'"' + we.gettechnicaloccasionnr() + '"' + "," +
						'"' + we.gettechnicalsourceoccasionnr() + '"' + "," +
						'"' + we.getworkitemnumber() + '"' + "," +
						'"' + we.getcorelworkevent() + '"' + "," +
						'"' + we.getoccasioninstance() + '"' + ");";
	System.out.println("insert workevent " + sql);
	we = runsqlinsert(sql);
	return we;

}

public workevent updateWorkeventByID(String gid,
				String workeventnamenr,
				String startworkeventnr,
				String objectreference,
				String occasiontype,
				String businessprocedurenr,
				String technicaloccasionnr,
				String technicalsourceoccasionnr, 
				String workitemnumber,
				String corelworkevent,
				String occasioninstance)
{

	we = null;
     	String sql;
     	sql = "SELECT * from workevent where id = " + gid + ";";
 	we = runsqlquery(sql);
	if (workeventnamenr != null) { we.setworkeventnamenr(workeventnamenr); }
	if (startworkeventnr != null) { we.setstartworkeventnr(startworkeventnr); }
	if (objectreference != null) { we.setobjectreference(objectreference); }
	if (occasiontype != null) { we.setoccasiontype(occasiontype);}
	if (businessprocedurenr != null) { we.setbusinessprocedurenr(businessprocedurenr);}
	if (technicaloccasionnr != null) { we.settechnicaloccasionnr(technicaloccasionnr);}
	if (technicalsourceoccasionnr != null) { we.settechnicalsourceoccasionnr(technicalsourceoccasionnr); }
	if (workitemnumber != null) { we.setworkitemnumber(workitemnumber);}
	if (corelworkevent != null) { we.setcorelworkevent(corelworkevent);}
	if (occasioninstance != null) { we.setoccasioninstance(occasioninstance);}

	Statement stmt = null;

     	sql = "update workevent  set workeventnamenr = " + '"' + we.getworkeventnamenr() + '"' + "," +
		"startworkeventnr = " + '"' + we.getstartworkeventnr() + '"' + "," +
		"objectreference = " + '"' + we.getobjectreference() + '"' + "," +
		"occasiontype = " + '"' + we.getoccasiontype() + '"' + "," +
		"businessprocedurenr = " + '"' + we.getbusinessprocedurenr() + '"' + "," +
		"technicaloccasionnr = " + '"' + we.gettechnicaloccasionnr() + '"' + "," +
		"technicalsourceoccasionnr = " + '"' + we.gettechnicalsourceoccasionnr() + '"' + "," +
		"workitemnumber = " + '"' + we.getworkitemnumber() + '"' + "," +
		"corelworkevent = " + '"' + we.getcorelworkevent() + '"' + "," +
		"occasioninstance = " + '"' + we.getoccasioninstance() + '"' + 
		 " where id = " + gid + ";";
	System.out.println(sql);
	we = runsqlupdate(gid,sql);
	return we;
}

public workevent updateWorkeventRouted(String gid)
{
	String processingstate = "1";  
	Statement stmt = null;
     	String sql;
	workevent we = new workevent();
     	sql = "update workevent  set processingstate = " + '"' + processingstate + '"' + " where id = " + gid + ";";
	System.out.println(sql);
	we = runsqlupdate(gid,sql);
	return we;
}

private workevent runsqlquery(String sql)
{
	Statement stmt = null;
	System.out.println("runsqlquery " + sql);
	we = new workevent();
	try{
		stmt = conn.createStatement();
      		ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()){
         //Retrieve by column name
         		we.setid(rs.getString("id"));
         		we.setworkeventnamenr(rs.getString("workeventnamenr"));
        		we.setstartworkeventnr(rs.getString("startworkeventnr"));
        		we.setobjectreference(rs.getString("objectreference"));
        		we.setoccasiontype(rs.getString("occasiontype"));
        		we.setbusinessprocedurenr(rs.getString("businessprocedurenr"));
        		we.settechnicaloccasionnr(rs.getString("technicaloccasionnr"));
        		we.settechnicalsourceoccasionnr(rs.getString("technicalsourceoccasionnr"));
        		we.setworkitemnumber(rs.getString("workitemnumber"));
        		we.setprocessingstate(rs.getString("processingstate"));
        		we.setcorelworkevent(rs.getString("corelworkevent"));
        		we.setoccasioninstance(rs.getString("occasioninstance"));
 
         //Display values
         		System.out.print("runsqlquery ID: " + we.getid());
         		System.out.print(", workeventnamenr " + we.getworkeventnamenr());
         		System.out.print(", startworkeventnr: " + we.getstartworkeventnr());
         		System.out.print(", objectreference: " + we.getobjectreference());
         		System.out.print(", occasiontype: " + we.getoccasiontype());
         		System.out.print(", businessprocedurenr: " + we.getbusinessprocedurenr());
         		System.out.print(", technicaloccasionnr: " + we.gettechnicaloccasionnr());
         		System.out.print(", technicalsourceoccasionnr: " + we.gettechnicalsourceoccasionnr());
         		System.out.print(", workitemnumber: " + we.getworkitemnumber());
         		System.out.print(", processingstate: " + we.getprocessingstate());
         		System.out.print(", corelworkevent: " + we.getcorelworkevent());
         		System.out.println(", occasioninstance: " + we.getoccasioninstance());
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

	return we;
}

private workevent runsqlinsert(String sql)
{
	Statement stmt = null;
	int id = -1;
	we = new workevent();	
	try{
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
      		int rtv = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
	      	ResultSet rs = stmt.getGeneratedKeys();
	      	if (rs.next()) id=rs.getInt(1);
 		conn.commit();
		conn.setAutoCommit(true);
   
         	System.out.println("manageWorkevent insert ID: " + id);
 
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
	finally {
      //finally block used to close resources
      		try {
        		 if(stmt!=null) stmt.close();
      		}
		catch(SQLException se2) {
     		}// nothing we can do

  	 }//end try
	String gid = Integer.toString(id);
	sql = "SELECT * from workevent where id = " + gid + ";";
	System.out.println("manageWorkevent runsqlinsert " + sql);
 	we = runsqlquery(sql);
	return we;
}

private workevent runsqlupdate(String gid,String sql)
{
	we = null;
	Statement stmt = null;
	try {
		stmt = conn.createStatement();
      		int rs = stmt.executeUpdate(sql);

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
		finally {
      //finally block used to close resources
      			try {
         			if(stmt!=null) stmt.close();
      			}
			catch(SQLException se2) {
      			}// nothing we can do

   	}//end try
	sql = "SELECT * from workevent where id = " + gid + ";";
	System.out.println("manageWorkevent runsqlupdate " + sql);
 	we = runsqlquery(sql);
	return we;
}


}
