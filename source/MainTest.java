//maintest

// import Source.openoccas.*;

public class MainTest
{

private static manageOpenoccasion mopocc;
private static String type = "-1";
private static String disp1 = "-1";
private static String disp2 = "-1";

public static void main(String[] args)
	{
	for (int i = 0; i < args.length; i++) {
		if (i == 0) type = args[i];
		if (i == 1) disp1 = args[i];
		if (i == 2) disp2 = args[i];
	}
	System.out.println("Run Maintest: type " + type + " disp1 " + disp1 + " disp2 " + disp2);	
	mopocc = new manageOpenoccasion();
	openoccasion opocc = mopocc.createOpenoccasion("Created",disp1,disp2,"-1","-1",
								type,
								"123456789025",	
								"123456789026",
								"101010101010",
								"123456789016",
								"5","-1","-1","2018-03-05","-1");
								
	System.out.println(opocc.getbusinessoccasionnr() + " " + opocc.gettechnicaloccasionnr() + " " + 
	" " + opocc.getdisplayattribut1() + " " + opocc.getdatecreated());
	return;
	}

}


