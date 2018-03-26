//loadOpenOccasElements


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
}

public wopenoccasinterface loadOpenOccasElementsdo(wopenoccasinterface iwopintf) 
{
//* service to load and verify workevent 
	wemgr = new manageWorkevent();
	owopintf = new wopenoccasinterface();
	if (iwopintf == null) return null;
	manageWorkevent wemgr = new manageWorkevent();
	owopintf = new wopenoccasinterface();
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
			rlrst.setparkingReason("loadOpenOccasElements Invalid workevent");
	}

	owopintf.setruleResult(rlrst);
	return owopintf;	
}

}
