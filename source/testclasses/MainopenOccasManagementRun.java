//MainmanageOpenoccasion

// import Source.openoccas.*;

import service.*;
import objectmanagement.*;
import processsimulation.*;

public class MainopenOccasManagementRun

{

private static openoccasstart occstart = null;
private static openOccasManagement process = null;
private ruleResult rlrst = null;
private static workitem wrkitm = null;
private static wopenoccasinterface wopintf = null;

public static void main(String[] args)
	{
		process = new openOccasManagement();
		
		occstart = new openoccasstart();
		occstart.setworkeventnr("7");
		occstart.setworkeventnamenr("5");
		occstart.setstate("START");
		occstart.setreferencetouse("-1");
		occstart.setbusinessprocedurenr("3");
		wopintf = new wopenoccasinterface();
		wrkitm = new workitem("-1",
					"-1",
					"Created Workitem",
					"-1",
					"-1",
					"-1",
					"Please check Document",
					"2018-04-30",
					null,
					"-1",
					null,
					"A",
					"-1",
					"NONE",
					"5",
					"3",
					"blalba",
					null);
		wopintf.setworkitem(wrkitm);			
		wopintf.setopenoccasstart(occstart);

		wopintf = process.openOccasManagementProcess(wopintf);
		outopenoccasstart(wopintf.getopenoccasstart(),"test process simulation");
	
	return;
	}

public static void outopenoccasstart(openoccasstart is, String text)
{
     	System.out.println(text );     	
	System.out.print(" workeventnr: " + is.getworkeventnr());
	System.out.print(", workeventnamenr " + is.getworkeventnamenr());
	System.out.print(", state: " + is.getstate());
  	System.out.print(", referencetouse: " + is.getreferencetouse());
        System.out.println(", businessprocedurenr: " + is.getbusinessprocedurenr());
 
}
}


