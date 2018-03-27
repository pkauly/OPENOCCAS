//manageWorkitem
// 
package objectmanagement;

import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class manageWorkitem
{
public static Connection conn = null;
private workitem woitm = null;
final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss";

public manageWorkitem () 
{
	conn = dbConnection.getInstance().getConnection();
	woitm = new workitem();
}


public workitem getWorkitemByNR(String witnr)
{
   	String sql;
     	sql = "SELECT * from workitem where workitemnumber = " + witnr + ";";
	System.out.println("workitem " + sql);
 	woitm = runsqlquery(sql);

	return woitm;
}

public ArrayList<workitem> getWorkitemListByTNR(String wittnr)
{
   	String sql;
     	sql = "SELECT * from workitem where occasionnr = " + wittnr + ";";
	System.out.println("workitem " + sql);
 	ArrayList<workitem> workitemlist = runsqlqueryL(sql);

	return workitemlist;
}

public workitem getcurrentworkitem()
{
	return woitm;
}

public workitem createWorkitem(String occasionnr, 
			String description, 
			String businessobject, 
			String businessobjectname, 
			String document, 
			String worktocomplete, 
			String worktocompletedate, 
			String remainderdate, 
			String completionreason, 
			String completiondate, 
			String state, 
			String workitemassignedto,
			String processtoken,
			String workeventnamenr, 
			String businessprocedurenr, 	
			String occasioninstance)
{
	woitm = new workitem();
	manageBusinessnumber busnr = new manageBusinessnumber();
	businessnumber wbunr = busnr.createbusinessNumber("3"); 

	woitm.setworkitemnumber(wbunr.getbusinessnumber()); 

	if (occasionnr != null) { woitm.setoccasionnr(occasionnr);}
	else { woitm.setoccasionnr("000000000000"); }	
	if (description != null) { woitm.setdescription(description);}
	else { woitm.setdescription("Unknown"); }
	if (businessobject != null) { woitm.setbusinessobject(businessobject);}
	else { woitm.setbusinessobject("-1");}
	if (businessobjectname != null) { woitm.setbusinessobjectname(businessobjectname);}
	else { woitm.setbusinessobjectname("-1");}
	if (document != null) { woitm.setdocument(document);}
	else { woitm.setdocument("-1");}
	if (worktocomplete != null) { woitm.setworktocomplete(worktocomplete); }
	else { woitm.setworktocomplete("Not defined");}
	if (worktocompletedate != null) { woitm.setworktocompletedate(worktocompletedate); }
	else { woitm.setworktocompletedate("1900-01-01");}
	if (remainderdate != null) { woitm.setremainderdate(remainderdate);}
	else { woitm.setremainderdate("1900-01-01");}
	if (completionreason != null) { woitm.setcompletionreason(completionreason);}
	else { woitm.setcompletionreason("-1");}
	if (completiondate != null) { woitm.setcompletiondate(completiondate);}
	else { woitm.setcompletiondate("1900-01-01");}
	if (state != null) { woitm.setstate(state);}
	else { woitm.setstate("A");}
	if (workitemassignedto != null) { woitm.setworkitemassignedto(workitemassignedto);}
	else { woitm.setworkitemassignedto("-1");}
	if (processtoken != null) { woitm.setprocesstoken(processtoken);}
	else { woitm.setprocesstoken("NONE");}
	if (workeventnamenr != null) { woitm.setworkeventnamenr(workeventnamenr);}
	else { woitm.setworkeventnamenr("-1");}
	if (businessprocedurenr != null) { woitm.setbusinessprocedurenr(businessprocedurenr);}
	else { woitm.setbusinessprocedurenr("-1");}
	if (occasioninstance != null) { woitm.setoccasioninstance(occasioninstance);}
	else { woitm.setoccasioninstance("-1");}
	java.util.Date dat = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
	woitm.setworkitemprocessingtime(formatter.format(dat));

     	String sql;
     	sql = "insert into workitem  (workitemnumber,occasionnr,description,businessobject,businessobjectname," +
					"document,worktocomplete,worktocompletedate,remainderdate," +
					"completionreason,completiondate,state,workitemassignedto," +
					"processtoken,workeventnamenr,businessprocedurenr,occasioninstance," +
					"workitemprocessingtime) " + 
					"values (" + '"' + woitm.getworkitemnumber() + '"' + "," + 
					'"' + woitm.getoccasionnr() + '"' + "," +
					'"' + woitm.getdescription() + '"' + "," +
					'"' + woitm.getbusinessobject() + '"' + "," +
					'"' + woitm.getbusinessobjectname() + '"' + "," +
					'"' + woitm.getdocument() + '"' + "," +
					'"' + woitm.getworktocomplete() + '"' + "," +
					'"' + woitm.getworktocompletedate() + '"' + "," +
					'"' + woitm.getremainderdate() + '"' + "," +
					'"' + woitm.getcompletionreason() + '"' + "," +
					'"' + woitm.getcompletiondate() + '"' + "," +
					'"' + woitm.getstate() + '"' + "," +
					'"' + woitm.getworkitemassignedto() + '"' + "," +
					'"' + woitm.getprocesstoken() + '"' + "," +
					'"' + woitm.getworkeventnamenr() + '"' + "," +
					'"' + woitm.getbusinessprocedurenr() + '"' + "," +
					'"' + woitm.getoccasioninstance() + '"' + "," +
					'"' + woitm.getworkitemprocessingtime() + '"' + ");";
	System.out.println("insert workitem " + sql);
	woitm = runsqlinsert(wbunr.getbusinessnumber(),sql);
	return woitm;

}

public workitem updateworkitemByID(String workitemnumber,
			String description, 
			String businessobject, 
			String businessobjectname, 
			String document, 
			String worktocomplete, 
			String worktocompletedate, 
			String remainderdate, 
			String completionreason, 
			String completiondate, 
			String state, 
			String workitemassignedto,
			String processtoken,
			String workeventnamenr, 
			String occasioninstance)
{

	woitm = null;
     	String sql;
     	sql = "SELECT * from workitem where workitemnumber = " + workitemnumber + ";";
 	woitm = runsqlquery(sql);

	if (description != null) { woitm.setdescription(description);}
	if (businessobject != null) { woitm.setbusinessobject(businessobject);}
	if (businessobjectname != null) { woitm.setbusinessobjectname(businessobjectname);}
	if (document != null) { woitm.setdocument(document);}
	if (worktocomplete != null) { woitm.setworktocomplete(worktocomplete); }
	if (worktocompletedate != null) { woitm.setworktocompletedate(worktocompletedate); }
	else { woitm.setworktocompletedate("1900-01-01"); }
	if (remainderdate != null) { woitm.setremainderdate(remainderdate);}
	else { woitm.setremainderdate("1900-01-01"); }
	if (completionreason != null) { woitm.setcompletionreason(completionreason);}
	if (completiondate != null) { woitm.setcompletiondate(completiondate);}
	else { woitm.setcompletiondate("1900-01-01"); }
	if (state != null && (state == "A" || state == "E" || state == "W" || state == "M")) { woitm.setstate(state);}
	if (workitemassignedto != null) { woitm.setworkitemassignedto(workitemassignedto);}
	if (processtoken != null) { woitm.setprocesstoken(processtoken);}
	if (workeventnamenr != null) { woitm.setworkeventnamenr(workeventnamenr);}
	if (occasioninstance != null) { woitm.setoccasioninstance(occasioninstance);}
	java.util.Date dat = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
	woitm.setworkitemprocessingtime(formatter.format(dat));

	Statement stmt = null;

     	sql = "update workitem  set occasionnr = " + '"' + woitm.getoccasionnr() + '"' +
				",description = " + '"' + woitm.getdescription() + '"' + 
				",businessobject = " + '"' + woitm.getbusinessobject() + '"' + 
				",businessobjectname = " + '"' + woitm.getbusinessobjectname() + '"' + 
				",document = " + '"' + woitm.getdocument() + '"' + 
 				",worktocomplete = " + '"' + woitm.getworktocomplete() + '"' + 
				",worktocompletedate = " + '"' + woitm.getworktocompletedate() + '"' + 
				",remainderdate = " + '"' + woitm.getremainderdate() + '"' + 
				",completionreason = " + '"' + woitm.getcompletionreason() + '"' + 
				",completiondate = " + '"' + woitm.getcompletiondate() + '"' + 
				",state = " + '"' + woitm.getstate() + '"' + 
				",workitemassignedto = " + '"' + woitm.getworkitemassignedto() + '"' + 
				",processtoken = " + '"' + woitm.getprocesstoken() + '"' + 
				",workeventnamenr = " + '"' + woitm.getworkeventnamenr() + '"' + 
				",occasioninstance = " + '"' + woitm.getoccasioninstance() + '"' + 
				",workitemprocessingtime = " + '"' + woitm.getworkitemprocessingtime() + '"' +
		 		" where workitemnumber = " + '"' + workitemnumber + '"' + ";";
	System.out.println(sql);
	woitm = runsqlupdate(workitemnumber,sql);
	return woitm;
}

private workitem runsqlquery(String sql)
{
	Statement stmt = null;
	System.out.println("runsqlquery " + sql);
	woitm = new workitem();
	try{
		stmt = conn.createStatement();
      	ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      	while(rs.next()){
         //Retrieve by column name
         		woitm.setworkitemnumber(rs.getString("workitemnumber"));
			woitm.setoccasionnr(rs.getString("occasionnr"));
			woitm.setdescription(rs.getString("description"));
			woitm.setbusinessobject(rs.getString("businessobject"));
			woitm.setbusinessobjectname(rs.getString("businessobjectname"));
			woitm.setdocument(rs.getString("document"));
			woitm.setworktocomplete(rs.getString("worktocomplete")); 
			woitm.setworktocompletedate(rs.getString("worktocompletedate"));
			woitm.setremainderdate(rs.getString("remainderdate"));
			woitm.setcompletionreason(rs.getString("completionreason"));
			woitm.setcompletiondate(rs.getString("completiondate"));
			woitm.setstate(rs.getString("state"));
			woitm.setworkitemassignedto(rs.getString("workitemassignedto"));
			woitm.setprocesstoken(rs.getString("processtoken"));
			woitm.setworkeventnamenr(rs.getString("workeventnamenr"));
			woitm.setbusinessprocedurenr(rs.getString("businessprocedurenr"));
			woitm.setoccasioninstance(rs.getString("occasioninstance"));
			woitm.setworkitemprocessingtime(rs.getString("workitemprocessingtime"));
			woitm.setdatecreated(rs.getString("datecreated"));
 
         //Display values
         		System.out.print("runsqlquery workitemnumber: " + woitm.getworkitemnumber());
         		System.out.print(", occasionnr " + woitm.getoccasionnr());
          		System.out.print(", description: " + woitm.getdescription());
         		System.out.print(", businessobject: " + woitm.getbusinessobject());
         		System.out.print(", businessobjectname: " + woitm.getbusinessobjectname());
         		System.out.print(", document: " + woitm.getdocument());
         		System.out.print(", worktocomplete: " + woitm.getworktocomplete());
         		System.out.print(", worktocompletedate: " + woitm.getworktocompletedate());
         		System.out.print(", remainderdate: " + woitm.getremainderdate());
         		System.out.print(", completionreason: " + woitm.getcompletionreason());
         		System.out.println(", completiondate: " + woitm.getcompletiondate());
       		System.out.println(", state: " + woitm.getstate());
         		System.out.println(", workitemassignedto: " + woitm.getworkitemassignedto());
         		System.out.println(", processtoken: " + woitm.getprocesstoken());
         		System.out.println(", workeventnamenr: " + woitm.getworkeventnamenr());
         		System.out.println(", businessprocedurenr: " + woitm.getbusinessprocedurenr());
         		System.out.println(", occasioninstance: " + woitm.getoccasioninstance());
         		System.out.println(", workitemprocessingtime: " + woitm.getworkitemprocessingtime());
         		System.out.println(", datecreated: " + woitm.getdatecreated());
  
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

	return woitm;
}

private ArrayList<workitem> runsqlqueryL(String sql)
{
	Statement stmt = null;
	System.out.println("runsqlquery " + sql);
	woitm = new workitem();
	ArrayList<workitem> workitemlist = new ArrayList<>();
	try{
		stmt = conn.createStatement();
      	ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      	while(rs.next()){
         //Retrieve by column name
         		woitm.setworkitemnumber(rs.getString("workitemnumber"));
			woitm.setoccasionnr(rs.getString("occasionnr"));
			woitm.setdescription(rs.getString("description"));
			woitm.setbusinessobject(rs.getString("businessobject"));
			woitm.setbusinessobjectname(rs.getString("businessobjectname"));
			woitm.setdocument(rs.getString("document"));
			woitm.setworktocomplete(rs.getString("worktocomplete")); 
			woitm.setworktocompletedate(rs.getString("worktocompletedate"));
			woitm.setremainderdate(rs.getString("remainderdate"));
			woitm.setcompletionreason(rs.getString("completionreason"));
			woitm.setcompletiondate(rs.getString("completiondate"));
			woitm.setstate(rs.getString("state"));
			woitm.setworkitemassignedto(rs.getString("workitemassignedto"));
			woitm.setprocesstoken(rs.getString("processtoken"));
			woitm.setworkeventnamenr(rs.getString("workeventnamenr"));
			woitm.setbusinessprocedurenr(rs.getString("businessprocedurenr"));
			woitm.setoccasioninstance(rs.getString("occasioninstance"));
			woitm.setworkitemprocessingtime(rs.getString("workitemprocessingtime"));
			woitm.setdatecreated(rs.getString("datecreated"));
 
         //Display values
         		System.out.print("runsqlquery workitemnumber: " + woitm.getworkitemnumber());
         		System.out.print(", occasionnr " + woitm.getoccasionnr());
          		System.out.print(", description: " + woitm.getdescription());
         		System.out.print(", businessobject: " + woitm.getbusinessobject());
         		System.out.print(", businessobjectname: " + woitm.getbusinessobjectname());
         		System.out.print(", document: " + woitm.getdocument());
         		System.out.print(", worktocomplete: " + woitm.getworktocomplete());
         		System.out.print(", worktocompletedate: " + woitm.getworktocompletedate());
         		System.out.print(", remainderdate: " + woitm.getremainderdate());
         		System.out.print(", completionreason: " + woitm.getcompletionreason());
         		System.out.println(", completiondate: " + woitm.getcompletiondate());
       		System.out.println(", state: " + woitm.getstate());
         		System.out.println(", workitemassignedto: " + woitm.getworkitemassignedto());
         		System.out.println(", processtoken: " + woitm.getprocesstoken());
         		System.out.println(", workeventnamenr: " + woitm.getworkeventnamenr());
         		System.out.println(", businessprocedurenr: " + woitm.getbusinessprocedurenr());
         		System.out.println(", occasioninstance: " + woitm.getoccasioninstance());
         		System.out.println(", workitemprocessingtime: " + woitm.getworkitemprocessingtime());
         		System.out.println(", datecreated: " + woitm.getdatecreated());
  
			workitemlist.add(woitm);
			
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

	return workitemlist;
}

private workitem runsqlinsert(String workitemnumber,String sql)
{
	Statement stmt = null;
	int id = -1;
	woitm = new workitem();
	try{
		stmt = conn.createStatement();
      	int rtv = stmt.executeUpdate(sql);
 
      //STEP 6: Clean-up environment
 //     	rs.close();
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
	sql = "SELECT * from workitem where workitemnumber = " + '"' + workitemnumber +  '"' + ";";
	System.out.println("manageworkitem runsqlinsert " + sql);
 	woitm = runsqlquery(sql);
	return woitm;
}

private workitem runsqlupdate(String workitemnumber,String sql)
{
	woitm = null;
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
	sql = "SELECT * from workitem where workitemnumber = " + '"' + workitemnumber + '"' + ";";
	System.out.println("manageworkitem runsqlupdate " + sql);
 	woitm = runsqlquery(sql);
	return woitm;
}

}
