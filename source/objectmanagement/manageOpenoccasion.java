//manageOpenoccasion
// 
package objectmanagement;

import java.util.*;
import java.sql.*;

public class manageOpenoccasion
{
public static Connection conn = null;
private openoccasion opocc = null;

public manageOpenoccasion() 
{
	conn = dbConnection.getInstance().getConnection();
	opocc = new openoccasion();
}

public openoccasion getOpenoccasionByTNR(String occnr)
{
   	String sql;
     	sql = "SELECT * from openoccasion where technicaloccasionnr = " + occnr + ";";
	System.out.println("openoccasion " + sql);
 	opocc = runsqlquery(sql);

	return opocc;
}

public openoccasion getcurrentOpenoccasion()
{
	return opocc;
}

public openoccasion createOpenoccasion(String businessstate, 
			String displayattribut1, 
			String displayattribut2, 
			String displayattribut3, 
			String displayattribut4, 
			String occasiontype, 
			String organisationrole, 
			String functionrole, 
			String assignedhandlingofficer, 
			String partner, 
			String competencelevel, 
			String temporarycompetencelevel,
			String referencetemporarycompetencelevel, 
			String lastprocessingdate, 	
			String objectreference)
{
	opocc = new openoccasion();
	manageBusinessnumber busnr = new manageBusinessnumber();
	businessnumber bbunr = busnr.createbusinessNumber("1"); 
	businessnumber tbunr = busnr.createbusinessNumber("2"); 

	opocc.setbusinessoccasionnr(bbunr.getbusinessnumber()); 
	opocc.settechnicaloccasionnr(tbunr.getbusinessnumber());

	if (businessstate != null) { opocc.setbusinessstate(businessstate);}
	else { opocc.setbusinessstate("Created"); }
	if (displayattribut1 != null) { opocc.setdisplayattribut1(displayattribut1);}
	else { opocc.setdisplayattribut1("-1");}
	if (displayattribut2 != null) { opocc.setdisplayattribut2(displayattribut2);}
	else { opocc.setdisplayattribut2("-1");}
	if (displayattribut3 != null) { opocc.setdisplayattribut3(displayattribut3);}
	else { opocc.setdisplayattribut3("-1");}
	if (displayattribut4 != null) { opocc.setdisplayattribut4(displayattribut4); }
	else { opocc.setdisplayattribut4("-1");}
	if (occasiontype != null) { opocc.setoccasiontype(occasiontype);}
	else { opocc.setoccasiontype("-1");}
	if (organisationrole != null) { opocc.setorganisationrole(organisationrole);}
	else { opocc.setorganisationrole("-1");}
	if (functionrole != null) { opocc.setfunctionrole(functionrole);}
	else { opocc.setfunctionrole("-1");}
	if (assignedhandlingofficer != null) { opocc.setassignedhandlingofficer(assignedhandlingofficer);}
	else { opocc.setassignedhandlingofficer("-1");}
	if (partner != null) { opocc.setpartner(partner);}
	else { opocc.setpartner("-1");}
	if (competencelevel != null) { opocc.setcompetencelevel(competencelevel);}
	else { opocc.setcompetencelevel("-1");}
	if (temporarycompetencelevel != null) { opocc.settemporarycompetencelevel(temporarycompetencelevel);}
	else { opocc.settemporarycompetencelevel("-1");}
	if (referencetemporarycompetencelevel != null) { opocc.setreferencetemporarycompetencelevel(referencetemporarycompetencelevel);}
	else { opocc.setreferencetemporarycompetencelevel("-1");}
	if (lastprocessingdate != null) { opocc.setlastprocessingdate(lastprocessingdate);}
	else { opocc.setlastprocessingdate("-1");}
	if (objectreference != null) { opocc.setobjectreference(objectreference);}
	else { opocc.setobjectreference("-1");}

     	String sql;
     	sql = "insert into openoccasion  (businessoccasionnr,technicaloccasionnr,businessstate,displayattribut1," +
					"displayattribut2,displayattribut3,displayattribut4," +
					"occasiontype,organisationrole,functionrole,assignedhandlingofficer," +
					"partner,competencelevel,temporarycompetencelevel,referencetemporarycompetencelevel," +
					"lastprocessingdate,objectreference) " + 
					"values (" + '"' + opocc.getbusinessoccasionnr() + '"' + "," + 
					'"' + opocc.gettechnicaloccasionnr() + '"' + "," +
					'"' + opocc.getbusinessstate() + '"' + "," +
					'"' + opocc.getdisplayattribut1() + '"' + "," +
					'"' + opocc.getdisplayattribut2() + '"' + "," +
					'"' + opocc.getdisplayattribut3() + '"' + "," +
					'"' + opocc.getdisplayattribut4() + '"' + "," +
					'"' + opocc.getoccasiontype() + '"' + "," +
					'"' + opocc.getorganisationrole() + '"' + "," +
					'"' + opocc.getfunctionrole() + '"' + "," +
					'"' + opocc.getassignedhandlingofficer() + '"' + "," +
					'"' + opocc.getpartner() + '"' + "," +
					'"' + opocc.getcompetencelevel() + '"' + "," +
					'"' + opocc.gettemporarycompetencelevel() + '"' + "," +
					'"' + opocc.getreferencetemporarycompetencelevel() + '"' + "," +
					'"' + opocc.getlastprocessingdate() + '"' + "," +
					'"' + opocc.getobjectreference() + '"' + ");";
	System.out.println("insert openoccasion " + sql);
	opocc = runsqlinsert(tbunr.getbusinessnumber(),sql);
	return opocc;

}

public openoccasion updateOpenoccasionByTID(String technicaloccasionnr, 
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

	opocc = null;
     	String sql;
     	sql = "SELECT * from openoccasion where technicaloccasionnr = " + technicaloccasionnr + ";";
 	opocc = runsqlquery(sql);
	if (businessstate != null) { opocc.setbusinessstate(businessstate);}
	if (displayattribut1 != null) { opocc.setdisplayattribut1(displayattribut1);}
	if (displayattribut2 != null) { opocc.setdisplayattribut2(displayattribut2);}
	if (displayattribut3 != null) { opocc.setdisplayattribut3(displayattribut3);}
	if (displayattribut4 != null) { opocc.setdisplayattribut4(displayattribut4); }
	if (occasiontype != null) { opocc.setoccasiontype(occasiontype);}
	if (organisationrole != null) { opocc.setorganisationrole(organisationrole);}
	if (functionrole != null) { opocc.setfunctionrole(functionrole); }
	if (assignedhandlingofficer != null) { opocc.setassignedhandlingofficer(assignedhandlingofficer);}
	if (competencelevel != null) { opocc.setcompetencelevel(competencelevel);}
	if (temporarycompetencelevel != null) { opocc.settemporarycompetencelevel(temporarycompetencelevel);}
	if (referencetemporarycompetencelevel != null) { opocc.setreferencetemporarycompetencelevel(referencetemporarycompetencelevel);}
	if (lastprocessingdate != null) { opocc.setlastprocessingdate(lastprocessingdate);}
	if (objectreference != null) { opocc.setobjectreference(objectreference); }

	Statement stmt = null;

     	sql = "update openoccasion  set businessstate = " + '"' + opocc.getbusinessstate() + '"' +
				",displayattribut1 = " + '"' + opocc.getdisplayattribut1() + '"' + 
				",displayattribut2 = " + '"' + opocc.getdisplayattribut2() + '"' + 
				",displayattribut3 = " + '"' + opocc.getdisplayattribut3() + '"' + 
				",displayattribut4 = " + '"' + opocc.getdisplayattribut4() + '"' + 
 				",occasiontype = " + '"' + opocc.getoccasiontype() + '"' + 
				",organisationrole = " + '"' + opocc.getorganisationrole() + '"' + 
				",functionrole = " + '"' + opocc.getfunctionrole() + '"' + 
				",assignedhandlingofficer = " + '"' + opocc.getassignedhandlingofficer() + '"' + 
				",competencelevel = " + '"' + opocc.getcompetencelevel() + '"' + 
				",temporarycompetencelevel = " + '"' + opocc.gettemporarycompetencelevel() + '"' + 
				",referencetemporarycompetencelevel = " + '"' + opocc.getreferencetemporarycompetencelevel() + '"' + 
				",lastprocessingdate = " + '"' + opocc.getlastprocessingdate() + '"' + 
				",objectreference = " + '"' + opocc.getobjectreference() + '"' + ");" +
		 		" where technicaloccasionnr = " + '"' + technicaloccasionnr + '"' + ";";
	System.out.println(sql);
	opocc = runsqlupdate(technicaloccasionnr,sql);
	return opocc;
}

private openoccasion runsqlquery(String sql)
{
	Statement stmt = null;
	System.out.println("runsqlquery " + sql);
	opocc = new openoccasion();
	try{
		stmt = conn.createStatement();
      	ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      		while(rs.next()){
         //Retrieve by column name
         		opocc.setbusinessoccasionnr(rs.getString("businessoccasionnr"));
			opocc.settechnicaloccasionnr(rs.getString("technicaloccasionnr"));
			opocc.setbusinessstate(rs.getString("businessstate"));
			opocc.setdisplayattribut1(rs.getString("displayattribut1"));
			opocc.setdisplayattribut2(rs.getString("displayattribut2"));
			opocc.setdisplayattribut3(rs.getString("displayattribut3"));
			opocc.setdisplayattribut4(rs.getString("displayattribut4")); 
			opocc.setoccasiontype(rs.getString("occasiontype"));
			opocc.setorganisationrole(rs.getString("organisationrole"));
			opocc.setfunctionrole(rs.getString("functionrole"));
			opocc.setassignedhandlingofficer(rs.getString("assignedhandlingofficer"));
			opocc.setpartner(rs.getString("partner"));
			opocc.setcompetencelevel(rs.getString("competencelevel"));
			opocc.settemporarycompetencelevel(rs.getString("temporarycompetencelevel"));
			opocc.setreferencetemporarycompetencelevel(rs.getString("referencetemporarycompetencelevel"));
			opocc.setlastprocessingdate(rs.getString("lastprocessingdate"));
			opocc.setobjectreference(rs.getString("objectreference"));
			opocc.setdatecreated(rs.getString("datecreated"));
 
         //Display values
         		System.out.print("runsqlquery businessoccasionnr: " + opocc.getbusinessoccasionnr());
         		System.out.print(", technicaloccasionnr " + opocc.gettechnicaloccasionnr());
         		System.out.print(", businessstate: " + opocc.getbusinessstate());
         		System.out.print(", displayattribut1: " + opocc.getdisplayattribut1());
         		System.out.print(", displayattribut2: " + opocc.getdisplayattribut2());
         		System.out.print(", displayattribut3: " + opocc.getdisplayattribut3());
         		System.out.print(", displayattribut4: " + opocc.getdisplayattribut4());
         		System.out.print(", occasiontype: " + opocc.getoccasiontype());
         		System.out.print(", organisationrole: " + opocc.getorganisationrole());
         		System.out.print(", functionrole: " + opocc.getfunctionrole());
         		System.out.print(", assignedhandlingofficer: " + opocc.getassignedhandlingofficer());
         		System.out.println(", partner: " + opocc.getpartner());
       		System.out.println(", competencelevel: " + opocc.getcompetencelevel());
         		System.out.println(", temporarycompetencelevel: " + opocc.gettemporarycompetencelevel());
         		System.out.println(", referencetemporarycompetencelevel: " + opocc.getreferencetemporarycompetencelevel());
         		System.out.println(", lastprocessingdate: " + opocc.getlastprocessingdate());
         		System.out.println(", objectreference: " + opocc.getobjectreference());
  
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

	return opocc;
}

private openoccasion runsqlinsert(String technicaloccasionnr,String sql)
{
	Statement stmt = null;
	int id = -1;
	opocc = new openoccasion();
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
	sql = "SELECT * from openoccasion where technicaloccasionnr = " + '"' + technicaloccasionnr +  '"' + ";";
	System.out.println("manageOpenoccasion runsqlinsert " + sql);
 	opocc = runsqlquery(sql);
	return opocc;
}

private openoccasion runsqlupdate(String technicaloccasionnr,String sql)
{
	opocc = null;
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
	sql = "SELECT * from openoccasion where technicaloccasionnr = " + '"' + technicaloccasionnr + '"' + ";";
	System.out.println("manageOpenoccasion runsqlupdate " + sql);
 	opocc = runsqlquery(sql);
	return opocc;
}


}
