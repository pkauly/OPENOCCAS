//MaingenerateNextTest

// import Source.openoccas.*;

public class MaingenerateNextTest
{
public static void main(String[] args)
	{
		generateNextSequence gnes = new generateNextSequence();
		
		openoccasstart iccstart = new openoccasstart();
		iccstart.setworkeventnr("-1");
		iccstart.setworkeventnamenr("1");
		iccstart.setstate("START");
		iccstart.setreferencetouse("-1");
		iccstart.setbusinessprocedurenr("1");
		outopenoccasstart(iccstart,"First generation of occassstart");

		openoccasstart occstart = gnes.generateNextSequencedo(iccstart);
		openoccasstart oc1 = occstart;
		System.out.println("getworkeventnr " + oc1.getworkeventnr());
		System.out.println("getworkeventnamenr " + oc1.getworkeventnamenr());
		System.out.println("getstate " + oc1.getstate());
		System.out.println("getreferencetouse " + oc1.getreferencetouse());
		System.out.println("getbusinessprocedurenr " + oc1.getbusinessprocedurenr());
		manageWorkevent owemgr = new manageWorkevent();
		

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


