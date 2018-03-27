//loadOpenOccasElements
package service;

import objectmanagement.*;

public class loadOpenOccasElements
{

private workevent we = null;
private businessnumber bus1 = null;
private businessnumber bus2 = null;
private businessnumber bus3 = null;
private manageBusinessnumber mgbus = null;
private ruleResult rlrst = null;
private wopenoccasinterface owopintf = null;
private manageWorkevent wemgr = null;
private manageOpenoccasion opocc = null;
private manageWorkitem woitm = null;
private openoccasstart opoccsta = null;

public loadOpenOccasElements()
{
	owopintf = new wopenoccasinterface();
}

public wopenoccasinterface loadOpenOccasWorkeventdo(wopenoccasinterface iwopintf) 
{
//* service to load and verify workevent 
	wemgr = new manageWorkevent();
	if (iwopintf == null) return null;
	manageWorkevent wemgr = new manageWorkevent();

	owopintf.setworkevent(iwopintf.getworkevent());
	owopintf.setopenoccasstart(iwopintf.getopenoccasstart());
	opoccsta = iwopintf.getopenoccasstart();
	rlrst = new ruleResult("-1","Error in loadOpenOccasElements");

	if (Long.parseLong(iwopintf.getopenoccasstart().getworkeventnr()) > 0)
	{
		System.out.println("checkpoint 1");
		owopintf.setworkevent(wemgr.getWorkeventByID(iwopintf.getopenoccasstart().getworkeventnr()));
	}
	else
	{
		System.out.println("checkpoint 2");
		return null;
	}
	int rulcount = 0;
	mgbus = new manageBusinessnumber();
	String techoccnr = owopintf.getworkevent().gettechnicaloccasionnr();
	String wkitmnr = owopintf.getworkevent().getworkitemnumber();
	String objnr = owopintf.getworkevent().getobjectreference();
	if (Long.parseLong(techoccnr) > 0) 
	{
		bus1 = mgbus.getbusinessNumberByID(techoccnr);
		rulcount = rulcount + 4;
	}

	if (Long.parseLong(wkitmnr) > 0) 
	{
		bus2 = mgbus.getbusinessNumberByID(wkitmnr);
		rulcount = rulcount + 8;
	}

	if (Long.parseLong(objnr) > 0) 
	{
		bus3 = mgbus.getbusinessNumberByID(objnr);
		rulcount = rulcount + 2;
	}
	switch (rulcount)
	{
		case 14: 
			rlrst.setResult("1");
			rlrst.setparkingReason("R1");
			break;
		case 12:
			rlrst.setResult("1");
			rlrst.setparkingReason("R2");
			break;
		case 10:
			rlrst.setResult("1");
			rlrst.setparkingReason("R3");
			break;		  
		case 8: 
			rlrst.setResult("1");
			rlrst.setparkingReason("R4");
			break;
		case 6: 
			rlrst.setResult("2");
			rlrst.setparkingReason("R5");
			break;
		case 4:
			rlrst.setResult("2");
			rlrst.setparkingReason("R6");
			break;
		case 2: 
			rlrst.setResult("3");
			rlrst.setparkingReason("R7"); 
			break;
		default:
			rlrst.setResult("-1");
			rlrst.setparkingReason("loadOpenOccasWorkevent Invalid workevent");
	}

	owopintf.setruleResult(rlrst);
	return owopintf;	
}

public wopenoccasinterface loadOpenOccasOpenoccasiondo(wopenoccasinterface iwopintf) 
{
//* service to load openoccasion 
	opocc = new manageOpenoccasion();

	if (iwopintf == null) return null;

	owopintf.setopenoccasion(iwopintf.getopenoccasion());
	rlrst = new ruleResult("-1","Error in loadOpenOccasOpenoccasion");

	if (Long.parseLong(owopintf.getworkevent().gettechnicaloccasionnr()) > 0)
	{
		System.out.println("checkpoint 20");
		owopintf.setopenoccasion(opocc.getOpenoccasionByTNR(owopintf.getworkevent().gettechnicaloccasionnr()));
		rlrst.setResult("1");
		rlrst.setparkingReason("NONE");
	}
	else
	{
		System.out.println("checkpoint 21");
		return null;
	}

	owopintf.setruleResult(rlrst);
	return owopintf;	
}

public wopenoccasinterface loadOpenOccasWorkitemdo(wopenoccasinterface iwopintf) 
{
//* service to load openoccasion 
	woitm = new manageWorkitem();

	if (iwopintf == null) return null;

	owopintf.setworkitem(iwopintf.getworkitem());
	rlrst = new ruleResult("-1","Error in loadOpenOccasWorkitem");

	if (Long.parseLong(owopintf.getworkevent().getworkitemnumber()) > 0)
	{
		System.out.println("checkpoint 30");
		owopintf.setworkitem(woitm.getWorkitemByNR(owopintf.getworkevent().getworkitemnumber()));
		rlrst.setResult("1");
		rlrst.setparkingReason("NONE");
	}
	else
	{
		System.out.println("checkpoint 31");
		return null;
	}

	owopintf.setruleResult(rlrst);
	return owopintf;	
}

public wopenoccasinterface getcurrentOpenOccasElements() 
{
	return owopintf;	
}

}
