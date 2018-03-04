//openoccasion
// 
// <openoccasion>   
//     	<id>“id“</id>
//     	<businessoccasionnr>”businessnumber”</businessoccasionnr>
//     	<technicaloccasionnr>”businessnumber”</technicaloccasionnr>
//     	<businessstate>“string“</businessstate>
// 	<displayattribut1>“string“</displayattribut1>
// 	<displayattribut2>“string“</displayattribut2>
// 	<displayattribut3>“string“</displayattribut3>
// 	<displayattribut4>“string“</displayattribut4>
// 	<occasiontype>“number“</occasiontype>
// 	<organisationrole>”businessnumber”</organisationrole>
// 	<functionrole>”businessnumber”</functionrole>
// 	<assignedhandlingofficer>”businessnumber”</assignedhandlingofficer>
// 	<partner>”businessnumber”</partner>
// 	<competencelevel>“number“</competencelevel>
// 	<temporarycompetencelevel>“number“</temporarycompetencelevel>
// 	<referencetemporarycompetencelevel>”businessnumber”</referencetemporarycompetencelevel>
// 	<lastprocessingdate>“date“</lastprocessingdate>
// 	<objectreference>”businessnumber”</objectreference>
// </openoccasion> 
public class openoccasion
{

private String id = "-1";
private String businessoccasionnr;
private String technicaloccasionnr;
private String businesstatus;
private String displayattribut1;
private String displayattribut2;
private String displayattribut3;
private String displayattribut4; 
private String occasiontype;
private String organisationrole;
private String functionrole;
private String assignedhandlingofficer;
private String partner;
private String competencelevel;
private String temporarycompetencelevel;
private String referencetemporarycompetencelevel;
private String lastprocessingdate;
private String objectreference;

public openoccasion () 
{
	setid("-1");
	setbusinessoccasionnr("-1");
	settechnicaloccasionnr("-1");
	setbusinesstatus("-1");
	setdisplayattribut1("-1");
	setdisplayattribut2("-1");
	setdisplayattribut3("-1");
	setdisplayattribut4("-1"); 
	setoccasiontype("-1");
	setorganisationrole("-1");
	setfunctionrole("-1");
	setassignedhandlingofficer("-1");
	setpartner("-1");
	setcompetencelevel("-1");
	settemporarycompetencelevel("-1");
	setreferencetemporarycompetencelevel("-1");
	setlastprocessingdate("-1");
	setobjectreference("-1");
}


public openoccasion (String businessoccasionnr, 
			String technicaloccasionnr,
			String businesstatus, 
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
	setid("1");	
	setbusinessoccasionnr(businessoccasionnr);
	settechnicaloccasionnr(technicaloccasionnr);
	setbusinesstatus(businesstatus);
	setdisplayattribut1(displayattribut1);
	setdisplayattribut2(displayattribut2);
	setdisplayattribut3(displayattribut3);
	setdisplayattribut4(displayattribut4); 
	setoccasiontype(occasiontype);
	setorganisationrole(organisationrole);
	setfunctionrole(functionrole);
	setassignedhandlingofficer(assignedhandlingofficer);
	setpartner(partner);
	setcompetencelevel(competencelevel);
	settemporarycompetencelevel(temporarycompetencelevel);
	setreferencetemporarycompetencelevel(referencetemporarycompetencelevel);
	setlastprocessingdate(lastprocessingdate);
	setobjectreference(objectreference);
}

private void setid(String input)
{
	id = input;
}
public String getid()
{
	return id;
}
public void setbusinessoccasionnr(String input)
{
	businessoccasionnr = input;
}
public String getbusinessoccasionnr()
{
	return businessoccasionnr;
}
public void settechnicaloccasionnr(String input)
{
	technicaloccasionnr = input;
}
public String gettechnicaloccasionnr()
{
	return technicaloccasionnr;
}
public void setbusinesstatus(String input)
{
	businesstatus = input;
}
public String getbusinesstatus()
{
	return businesstatus;
}
public void setdisplayattribut1(String input)
{
	displayattribut1 = input;
}
public String getdisplayattribut1()
{
	return displayattribut1;
}
public void setdisplayattribut2(String input)
{
	displayattribut2 = input;
}
public String getdisplayattribut2()
{
	return displayattribut2;
}
public void setdisplayattribut3(String input)
{
	displayattribut3 = input;
}
public String getdisplayattribut3()
{
	return displayattribut3;
}
public void setdisplayattribut4(String input)
{
	displayattribut4 = input;
}
public String getdisplayattribut4()
{
	return displayattribut4;
}
public void setoccasiontype(String input)
{
	occasiontype = input;
}
public String getoccasiontype()
{
	return occasiontype;
}	
public void setorganisationrole(String input)
{
	organisationrole = input;
}
public String getorganisationrole()
{
	return organisationrole;
}
public void setassignedhandlingofficer(String input)
{
	assignedhandlingofficer = input;
}
public String getassignedhandlingofficer()
{
	return assignedhandlingofficer;
}	
public void setfunctionrole(String input)
{
	functionrole = input;
}
public String getfunctionrole()
{
	return functionrole;
}	
public void setpartner(String input)
{
	partner = input;
}
public String getpartner()
{
	return partner;
}	
public void setcompetencelevel(String input)
{
	competencelevel =input;
}
public String getcompetencelevel()
{
	return competencelevel;	
}
public void settemporarycompetencelevel(String input)
{
	temporarycompetencelevel = input;
}
public String gettemporarycompetencelevel()
{
	return temporarycompetencelevel;
}
public void setreferencetemporarycompetencelevel(String input)
{
	referencetemporarycompetencelevel = input;
}
public String getreferencetemporarycompetencelevel()
{
	return referencetemporarycompetencelevel;		
}
public void setlastprocessingdate(String input)
{
	lastprocessingdate = input;
}
public String getlastprocessingdate()
{
	return lastprocessingdate;
}	
public void setobjectreference(String input)
{
	objectreference = input;
}
public String getobjectreference()
{
	return objectreference;					
}

}
