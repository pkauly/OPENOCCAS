//manageOpenoccasion
// 

public class manageOpenoccasion
{

private String id = "-1";
private String businessoccasionnr = "416483620184";
private String technicaloccasionnr = "416483620185";
private String businesstatus = "OPEN";
private String displayattribut1 = "Claim";
private String displayattribut2 = "Man in the middle";
private String displayattribut3 = "-1";
private String displayattribut4 = "-1"; 
private String occasiontype = "5";
private String organisationrole =  "416483340184";
private String functionrole = "416483340185";
private String assignedhandlingofficer = "416483340186";
private String partner = "416483340187";
private String competencelevel = "3";
private String temporarycompetencelevel = "-1";
private String referencetemporarycompetencelevel = "-1";
private String lastprocessingdate = "05.03.2018";
private String objectreference = "456483340184";

public manageOpenoccasion() 
{

}

public openoccasion getOpenoccasionByNR(String witnr)
{
	openoccasion opocc =  new openoccasion(businessoccasionnr,
		technicaloccasionnr,
		businesstatus,
		displayattribut1,
		displayattribut2,
		displayattribut3,
		displayattribut4, 
		occasiontype,
		organisationrole,
		functionrole,
		assignedhandlingofficer,
		partner,
		competencelevel,
		temporarycompetencelevel,
		referencetemporarycompetencelevel,
		lastprocessingdate,
		objectreference);
	return opocc;
}

}
