//manageWorkitem
// 
import java.util.*;
import java.sql.*;

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

public workitem getcurrentworkitem()
{
	return woitm;
}

public workitem createworkitem(String occasionnr, 
			String description, 
			String businessobject, 
			String businessobjectname, 
			String document, 
			String worktocomplete, 
			String worktocompletedate, 
			String reminderdate, 
			String completionreason, 
			String completiondate, 
			String state, 
			String workitemassignedto,
			String processtoken,
			String workeventnamenr, 
			String businessprocedurenr, 	
			String occasioninstance,
			String workitemprocessingtime)
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
	if (reminderdate != null) { woitm.setreminderdate(reminderdate);}
	else { woitm.setreminderdate("-1");}
	if (completionreason != null) { woitm.setcompletionreason(completionreason);}
	else { woitm.setcompletionreason("-1");}
	if (completiondate != null) { woitm.setcompletiondate(completiondate);}
	else { woitm.setcompletiondate("-1");}
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
	java.util.Date dat = new Date();
	DateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
	woitm.setworkitemprocessingtime(formatter.format(dat);

     	String sql;
     	sql = "insert into workitem  (workitemnumber,occasionnr,description,businessobject,businessobjectname," +
					"document,worktocomplete,worktocompletedate,reminderdate," +
					"completionreason,completiondate,state,workitemassignedto," +
					"processtoken,workeventnamenr,businessprocedurenr,occasioninstance," +
					"workitemprocessingtime) " + 
					"values (" + '"' + woitm.getworkitemnumber() + '"' + "," + 
					'"' + woitm.getoccasionnr() + '"' + "," +
					'"' + woitm.getdescription() + '"' + "," +
					'"' + woitm.getbusinessobject() + '"' + "," +
					'"' + woitm.businessobjectname() + '"' + "," +
					'"' + woitm.document() + '"' + "," +
					'"' + woitm.worktocomplete() + '"' + "," +
					'"' + woitm.worktocompletedate() + '"' + "," +
					'"' + woitm.reminderdate() + '"' + "," +
					'"' + woitm.completionreason() + '"' + "," +
					'"' + woitm.completiondate() + '"' + "," +
					'"' + woitm.state() + '"' + "," +
					'"' + woitm.workitemassignedto() + '"' + "," +
					'"' + woitm.processtoken() + '"' + "," +
					'"' + woitm.workeventnamenr() + '"' + "," +
					'"' + woitm.businessprocedurenr() + '"' + "," +
					'"' + woitm.occasioninstance() + '"' + "," +
					'"' + woitm.workitemprocessingtime() + '"' + ");";
	System.out.println("insert workitem " + sql);
	woitm = runsqlinsert(tbunr.getbusinessnumber(),sql);
	return woitm;

}

public workitem updateworkitemByTID(String technicaloccasionnr, 
			String businessstate, 
			String displayattribut1, 
			String displayattribut2, 
			String displayattribut3, 
			String displayattribut4, 
			String occasiontype, 
			String organisationrole, 
			String functionrole, 
			String assignedhandlingofficer, 
			String competencelevel, 
			String temporarycompetencelevel,
			String referencetemporarycompetencelevel, 
			String lastprocessingdate, 	
			String objectreference)
{

	woitm = null;
     	String sql;
     	sql = "SELECT * from workitem where technicaloccasionnr = " + technicaloccasionnr + ";";
 	woitm = runsqlquery(sql);

	if (occasionnr != null) { woitm.setoccasionnr(occasionnr);}
	if (description != null) { woitm.setdescription(description);}
	if (businessobject != null) { woitm.setbusinessobject(businessobject);}
	if (businessobjectname != null) { woitm.setbusinessobjectname(businessobjectname);}
	if (document != null) { woitm.setdocument(document);}
	if (worktocomplete != null) { woitm.setworktocomplete(worktocomplete); }
	if (worktocompletedate != null) { woitm.setworktocompletedate(worktocompletedate); }
	if (reminderdate != null) { woitm.setreminderdate(reminderdate);}
	if (completionreason != null) { woitm.setcompletionreason(completionreason);}
	if (completiondate != null) { woitm.setcompletiondate(completiondate);}
	if (state != null) { woitm.setstate(state);}
	if (workitemassignedto != null) { woitm.setworkitemassignedto(workitemassignedto);}
	if (processtoken != null) { woitm.setprocesstoken(processtoken);}
	if (workeventnamenr != null) { woitm.setworkeventnamenr(workeventnamenr);}
	if (businessprocedurenr != null) { woitm.setbusinessprocedurenr(businessprocedurenr);}
	if (occasioninstance != null) { woitm.setoccasioninstance(occasioninstance);}
	java.util.Date dat = new Date();
	DateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
	woitm.setworkitemprocessingtime(formatter.format(dat);

	Statement stmt = null;

     	sql = "update workitem  set businessstate = " + '"' + woitm.getbusinessstate() + '"' +
				",displayattribut1 = " + '"' + woitm.getdisplayattribut1() + '"' + 
				",displayattribut2 = " + '"' + woitm.getdisplayattribut2() + '"' + 
				",displayattribut3 = " + '"' + woitm.getdisplayattribut3() + '"' + 
				",displayattribut4 = " + '"' + woitm.getdisplayattribut4() + '"' + 
 				",occasiontype = " + '"' + woitm.getoccasiontype() + '"' + 
				",organisationrole = " + '"' + woitm.getorganisationrole() + '"' + 
				",functionrole = " + '"' + woitm.getfunctionrole() + '"' + 
				",assignedhandlingofficer = " + '"' + woitm.getassignedhandlingofficer() + '"' + 
				",competencelevel = " + '"' + woitm.getcompetencelevel() + '"' + 
				",temporarycompetencelevel = " + '"' + woitm.gettemporarycompetencelevel() + '"' + 
				",referencetemporarycompetencelevel = " + '"' + woitm.getreferencetemporarycompetencelevel() + '"' + 
				",lastprocessingdate = " + '"' + woitm.getlastprocessingdate() + '"' + 
				",objectreference = " + '"' + woitm.getobjectreference() + '"' + ");" +
		 		" where technicaloccasionnr = " + '"' + technicaloccasionnr + '"' + ";";
	System.out.println(sql);
	woitm = runsqlupdate(technicaloccasionnr,sql);
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
         		woitm.setbusinessoccasionnr(rs.getString("businessoccasionnr"));
			woitm.settechnicaloccasionnr(rs.getString("technicaloccasionnr"));
			woitm.setbusinessstate(rs.getString("businessstate"));
			woitm.setdisplayattribut1(rs.getString("displayattribut1"));
			woitm.setdisplayattribut2(rs.getString("displayattribut2"));
			woitm.setdisplayattribut3(rs.getString("displayattribut3"));
			woitm.setdisplayattribut4(rs.getString("displayattribut4")); 
			woitm.setoccasiontype(rs.getString("occasiontype"));
			woitm.setorganisationrole(rs.getString("organisationrole"));
			woitm.setfunctionrole(rs.getString("functionrole"));
			woitm.setassignedhandlingofficer(rs.getString("assignedhandlingofficer"));
			woitm.setpartner(rs.getString("partner"));
			woitm.setcompetencelevel(rs.getString("competencelevel"));
			woitm.settemporarycompetencelevel(rs.getString("temporarycompetencelevel"));
			woitm.setreferencetemporarycompetencelevel(rs.getString("referencetemporarycompetencelevel"));
			woitm.setlastprocessingdate(rs.getString("lastprocessingdate"));
			woitm.setobjectreference(rs.getString("objectreference"));
			woitm.setdatecreated(rs.getString("datecreated"));
 
         //Display values
         		System.out.print("runsqlquery businessoccasionnr: " + woitm.getbusinessoccasionnr());
         		System.out.print(", technicaloccasionnr " + woitm.gettechnicaloccasionnr());
         		System.out.print(", businessstate: " + woitm.getbusinessstate());
         		System.out.print(", displayattribut1: " + woitm.getdisplayattribut1());
         		System.out.print(", displayattribut2: " + woitm.getdisplayattribut2());
         		System.out.print(", displayattribut3: " + woitm.getdisplayattribut3());
         		System.out.print(", displayattribut4: " + woitm.getdisplayattribut4());
         		System.out.print(", occasiontype: " + woitm.getoccasiontype());
         		System.out.print(", organisationrole: " + woitm.getorganisationrole());
         		System.out.print(", functionrole: " + woitm.getfunctionrole());
         		System.out.print(", assignedhandlingofficer: " + woitm.getassignedhandlingofficer());
         		System.out.println(", partner: " + woitm.getpartner());
       		System.out.println(", competencelevel: " + woitm.getcompetencelevel());
         		System.out.println(", temporarycompetencelevel: " + woitm.gettemporarycompetencelevel());
         		System.out.println(", referencetemporarycompetencelevel: " + woitm.getreferencetemporarycompetencelevel());
         		System.out.println(", lastprocessingdate: " + woitm.getlastprocessingdate());
         		System.out.println(", objectreference: " + woitm.getobjectreference());
  
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

private workitem runsqlinsert(String technicaloccasionnr,String sql)
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
	sql = "SELECT * from workitem where technicaloccasionnr = " + '"' + technicaloccasionnr +  '"' + ";";
	System.out.println("manageworkitem runsqlinsert " + sql);
 	woitm = runsqlquery(sql);
	return woitm;
}

private workitem runsqlupdate(String technicaloccasionnr,String sql)
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
	sql = "SELECT * from workitem where technicaloccasionnr = " + '"' + technicaloccasionnr + '"' + ";";
	System.out.println("manageworkitem runsqlupdate " + sql);
 	woitm = runsqlquery(sql);
	return woitm;
}

}
