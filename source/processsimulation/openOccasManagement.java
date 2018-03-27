//maintest

// import Source.openoccas.*;
package processsimulation;

import service.*;
import objectmanagement.*;
import java.util.*;

public class openOccasManagement
{

private static loadOpenOccasElements loopelm;
private wopenoccasinterface oopintf;
private openoccasstart ooccstart = null;

public openOccasManagement()
{
}

public wopenoccasinterface openOccasManagementProcess(wopenoccasinterface iopintf)
{
	System.out.println("Run openOccasManagement Process");	
	loopelm = new loadOpenOccasElements();
	oopintf = new wopenoccasinterface();
	oopintf.setworkevent(iopintf.getworkevent());
	oopintf.setopenoccasion(iopintf.getopenoccasion());
	oopintf.setworkitem(iopintf.getworkitem());
	oopintf.setopenoccasstart(iopintf.getopenoccasstart());


// Activity 1
	oopintf = openOccasManagementact1(oopintf);
outworkitem(oopintf.getworkitem());
	ruleResult rlrst = oopintf.getruleResult();
	ooccstart = iopintf.getopenoccasstart();
//	occstart.setworkeventnr("7");
//	occstart.setworkeventnamenr("5");
//	occstart.setstate("START");
//	occstart.setreferencetouse("-1");
//	occstart.setbusinessprocedurenr("3");
	System.out.println("RuleResult " + rlrst.getResult());
	switch (rlrst.getResult())
	{
		case "1":
// Activity 4
			oopintf = openOccasManagementact4(oopintf);
// Activity 7
			oopintf = openOccasManagementact7(oopintf);
// Activity 8
			oopintf = openOccasManagementact8(oopintf);
			break;
		case "2":
// Activity 3
			oopintf = openOccasManagementact3(oopintf);
// Activity 6
			oopintf = openOccasManagementact6(oopintf);
			if (oopintf.getruleResult().getResult() == "1")
			{
// Activity 7
				oopintf = openOccasManagementact7(oopintf);
// Activity 8
				oopintf = openOccasManagementact8(oopintf);
			}
			else
			{
// Activity 5
				oopintf = openOccasManagementact5(oopintf);
			}
			break;
		case "3":
// Activity 2
			oopintf = openOccasManagementact2(oopintf);
// Activity 5
			oopintf = openOccasManagementact5(oopintf);
			break;
		default:
			System.out.println("openOccasManagement error in workevent loading");
			oopintf = null;
	}
// Activity 9
	oopintf = openOccasManagementact9(oopintf);
								
	System.out.println("openOccasManagement exit");
	return oopintf;
}

public wopenoccasinterface openOccasManagementact1(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 1 load Workevent");

	openoccasstart occstart = oopintf.getopenoccasstart();
	ruleResult rlrst = new ruleResult();
	oopintf = loopelm.loadOpenOccasWorkeventdo(oopintf);
	String result = oopintf.getruleResult().getResult();
	switch (result)
	{
		case "1":
			oopintf.setruleResult(new ruleResult("1","NONE"));
			break;
		case "2":
			oopintf.setruleResult(new ruleResult("2","NONE"));
			break;
		case "3":
			oopintf.setruleResult(new ruleResult("3","NONE"));
			break;
		default:
			System.out.println("openOccasManagement error in workevent loading");
			oopintf.setruleResult(new ruleResult("-1","workevent error"));
	}
								
outworkevent(oopintf.getworkevent());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact2(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 2 create new openoccasion");
	manageOpenoccasion mopocc = new manageOpenoccasion();

	openoccasion opocc = mopocc.createOpenoccasion(oopintf.getopenoccasion().getbusinessstate(), 									oopintf.getopenoccasion().getdisplayattribut1(),
								oopintf.getopenoccasion().getdisplayattribut2(),
								oopintf.getopenoccasion().getdisplayattribut3(),
								oopintf.getopenoccasion().getdisplayattribut4(),
								oopintf.getopenoccasion().getoccasiontype(),
								oopintf.getopenoccasion().getorganisationrole(),
								oopintf.getopenoccasion().getfunctionrole(),
								oopintf.getopenoccasion().getassignedhandlingofficer(),
								oopintf.getopenoccasion().getpartner(),
								oopintf.getopenoccasion().getcompetencelevel(),
								oopintf.getopenoccasion().gettemporarycompetencelevel(),
								oopintf.getopenoccasion().getreferencetemporarycompetencelevel(),
								oopintf.getopenoccasion().getlastprocessingdate(),
								oopintf.getopenoccasion().getobjectreference());
	oopintf.setopenoccasion(opocc);
	oopintf.getworkevent().settechnicaloccasionnr(opocc.gettechnicaloccasionnr());
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outopenoccasion(oopintf.getopenoccasion());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact3(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 3 load open occasion");
	oopintf = loopelm.loadOpenOccasOpenoccasiondo(oopintf);
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outopenoccasion(oopintf.getopenoccasion());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact4(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 4 load open occasion and workitem");
	oopintf = loopelm.loadOpenOccasOpenoccasiondo(oopintf);
	oopintf = loopelm.loadOpenOccasWorkitemdo(oopintf);
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outopenoccasion(oopintf.getopenoccasion());
outworkitem(oopintf.getworkitem());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact5(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 5 create new workitem");
outworkitem(oopintf.getworkitem());
	manageWorkitem mwoi = new manageWorkitem();
	workitem nwoit = mwoi.createWorkitem(oopintf.getopenoccasion().gettechnicaloccasionnr(),
					oopintf.getworkitem().getdescription(),
					oopintf.getworkitem().getbusinessobject(),
					oopintf.getworkitem().getbusinessobjectname(),
					oopintf.getworkitem().getdocument(),
					oopintf.getworkitem().getworktocomplete(),
					oopintf.getworkitem().getworktocompletedate(),
					oopintf.getworkitem().getremainderdate(),
					oopintf.getworkitem().getcompletionreason(),
					oopintf.getworkitem().getcompletiondate(),
					oopintf.getworkitem().getstate(),
					oopintf.getworkitem().getworkitemassignedto(),
					oopintf.getworkitem().getprocesstoken(),
					oopintf.getworkitem().getworkeventnamenr(),
					oopintf.getworkitem().getbusinessprocedurenr(),
					oopintf.getworkitem().getoccasioninstance());	

	oopintf.setworkitem(nwoit);
	oopintf.getworkevent().setworkitemnumber(nwoit.getworkitemnumber());
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outworkitem(oopintf.getworkitem());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact6(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 6 search workitem");
	openoccasion opocc = oopintf.getopenoccasion();
	manageWorkitem mwoi = new manageWorkitem();
	workitem wrki = null;
	ArrayList<workitem> workitemlist = mwoi.getWorkitemListByTNR(opocc.gettechnicaloccasionnr());
	for (int i = 0;i<workitemlist.size();i++){
		wrki = workitemlist.get(i);
		if (oopintf.getworkevent().getbusinessprocedurenr() == wrki.getbusinessprocedurenr()) break;
	}
	oopintf.setworkitem(wrki);
	ruleResult rlrst = new ruleResult("-1","not found");
	oopintf.setruleResult(rlrst);
	return oopintf;
}


public wopenoccasinterface openOccasManagementact7(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 7 update workitem");
	manageWorkitem mwoi = new manageWorkitem();
	workitem nwoit = mwoi.updateworkitemByID(oopintf.getworkitem().getworkitemnumber(),
					oopintf.getworkitem().getdescription(),
					oopintf.getworkitem().getbusinessobject(),
					oopintf.getworkitem().getbusinessobjectname(),
					oopintf.getworkitem().getdocument(),
					oopintf.getworkitem().getworktocomplete(),
					oopintf.getworkitem().getworktocompletedate(),
					oopintf.getworkitem().getremainderdate(),
					oopintf.getworkitem().getcompletionreason(),
					oopintf.getworkitem().getcompletiondate(),
					oopintf.getworkitem().getstate(),
					oopintf.getworkitem().getworkitemassignedto(),
					oopintf.getworkitem().getprocesstoken(),
					oopintf.getworkitem().getworkeventnamenr(),
					oopintf.getworkitem().getoccasioninstance());
	oopintf.setworkitem(nwoit);	
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outworkitem(oopintf.getworkitem());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact8(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 8 update openoccasion");
	manageOpenoccasion mopocc = new manageOpenoccasion();

	openoccasion opocc = mopocc.updateOpenoccasionByTID(oopintf.getopenoccasion().gettechnicaloccasionnr(),
								oopintf.getopenoccasion().getbusinessstate(), 									oopintf.getopenoccasion().getdisplayattribut1(),
								oopintf.getopenoccasion().getdisplayattribut2(),
								oopintf.getopenoccasion().getdisplayattribut3(),
								oopintf.getopenoccasion().getdisplayattribut4(),
								oopintf.getopenoccasion().getoccasiontype(),
								oopintf.getopenoccasion().getorganisationrole(),
								oopintf.getopenoccasion().getfunctionrole(),
								oopintf.getopenoccasion().getassignedhandlingofficer(),
								oopintf.getopenoccasion().getcompetencelevel(),
								oopintf.getopenoccasion().gettemporarycompetencelevel(),
								oopintf.getopenoccasion().getreferencetemporarycompetencelevel(),
								oopintf.getopenoccasion().getlastprocessingdate(),
								oopintf.getopenoccasion().getobjectreference());
	oopintf.setopenoccasion(opocc);
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outopenoccasion(oopintf.getopenoccasion());
	return oopintf;
}

public wopenoccasinterface openOccasManagementact9(wopenoccasinterface oopintf)
{
	System.out.println("Run openOccasManagement 9 update workevent");
	manageWorkevent mwe = new manageWorkevent();
	workevent we = mwe.updateWorkeventByID(oopintf.getworkevent().getid(),
				oopintf.getworkevent().getworkeventnamenr(),
				oopintf.getworkevent().getstartworkeventnr(),
				oopintf.getworkevent().getobjectreference(),
				oopintf.getworkevent().getoccasiontype(),
				oopintf.getworkevent().getbusinessprocedurenr(),
				oopintf.getworkevent().gettechnicaloccasionnr(),
				oopintf.getworkevent().gettechnicalsourceoccasionnr(), 
				oopintf.getworkevent().getworkitemnumber(),
				oopintf.getworkevent().getcorelworkevent(),
				oopintf.getworkevent().getoccasioninstance());
	oopintf.setworkevent(we);
	ruleResult rlrst = new ruleResult("1","NONE");
	oopintf.setruleResult(rlrst);
outworkevent(oopintf.getworkevent());
	return oopintf;
}

private void outopenoccasion(openoccasion opocc)
{
	System.out.println("Openoccasion " + opocc.getbusinessoccasionnr() + " " + opocc.gettechnicaloccasionnr() + " " + 
	" " + opocc.getdisplayattribut1() + " " + opocc.getdatecreated());
}

private void outworkitem(workitem nwe)
{
	System.out.println(" main ID: " + nwe.getid());
	System.out.print(", workitemnumber " + nwe.getworkitemnumber());
	System.out.print(", occasionnr " + nwe.getoccasionnr());
	System.out.print(", description: " + nwe.getdescription());
  	System.out.print(", businessobject: " + nwe.getbusinessobject());
        System.out.print(", businessobjectname: " + nwe.getbusinessobjectname());
        System.out.print(", document: " + nwe.getdocument());
        System.out.println(", worktocomplete: " + nwe.getworktocomplete());
        System.out.print(", worktocompletedate: " + nwe.getworktocompletedate());
        System.out.print(", remainderdate: " + nwe.getremainderdate());
        System.out.print(", completionreason: " + nwe.getcompletionreason());
        System.out.print(", completiondate: " + nwe.getcompletiondate());
        System.out.println(", state: " + nwe.getstate());
        System.out.println(", workitemassignedto: " + nwe.getworkitemassignedto());
        System.out.println(", processtoken: " + nwe.getprocesstoken());
        System.out.println(", workeventnamenr: " + nwe.getworkeventnamenr());
        System.out.println(", businessprocedurenr: " + nwe.getbusinessprocedurenr());
        System.out.println(", occasioninstance: " + nwe.getoccasioninstance());
        System.out.println(", datecreated: " + nwe.getdatecreated());
}

private void outworkevent(workevent nwe)
{
	System.out.println(" main ID: " + nwe.getid());
	System.out.print(", workeventnamenr " + nwe.getworkeventnamenr());
	System.out.print(", startworkeventnr: " + nwe.getstartworkeventnr());
  	System.out.print(", objectreference: " + nwe.getobjectreference());
        System.out.print(", occasiontype: " + nwe.getoccasiontype());
        System.out.print(", businessprocedurenr: " + nwe.getbusinessprocedurenr());
        System.out.println(", technicaloccasionnr: " + nwe.gettechnicaloccasionnr());
        System.out.print(", technicalsourceoccasionnr: " + nwe.gettechnicalsourceoccasionnr());
        System.out.print(", workitemnumber: " + nwe.getworkitemnumber());
        System.out.print(", processingstate: " + nwe.getprocessingstate());
        System.out.print(", corelworkevent: " + nwe.getcorelworkevent());
        System.out.println(", occasioninstance: " + nwe.getoccasioninstance());
}

}
