//maintest

// import Source.openoccas.*;
import service;

public class openOccasManagement
{

private static loadOpenOccasElements loopelm;
private static wopenoccasinterface wopintf;
private static openoccasstart occstart = null;
private static ruleResult rlrst = null;

public static void main(String[] args)
	{
	for (int i = 0; i < args.length; i++) {
		if (i == 0) type = args[i];
		if (i == 1) disp1 = args[i];
		if (i == 2) disp2 = args[i];
	}
	System.out.println("Run openOccasManagement");	
	loopelm = new loadOpenOccasElements();
	wopintf = new wopenoccasinterface();
	occstart = new openoccasstart();
	occstart.setworkeventnr("7");
	occstart.setworkeventnamenr("5");
	occstart.setstate("START");
	occstart.setreferencetouse("-1");
	occstart.setbusinessprocedurenr("3");

	wopintf = loopelm.loadOpenOccasWorkeventdo(loopelm);
	String result = wopintf.getruleResult().getruleResut();
	switch result;
	{
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		default:
			System.out.println("openOccasManagement error in workevent loading");
	}
								
	System.out.println(opocc.getbusinessoccasionnr() + " " + opocc.gettechnicaloccasionnr() + " " + 
	" " + opocc.getdisplayattribut1() + " " + opocc.getdatecreated());
	return;
	}

}


