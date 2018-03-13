//MaingenerateNextTest

// import Source.openoccas.*;

public class MaingenerateNextTest

{

private static openoccasstart occstart = null;
private static openoccasstart iccstart = null;

public static void main(String[] args)
	{
		generateNextSequence gnes = new generateNextSequence();
		
		iccstart = new openoccasstart();
		iccstart.setworkeventnr("-1");
		iccstart.setworkeventnamenr("1");
		iccstart.setstate("START");
		iccstart.setreferencetouse("-1");
		iccstart.setbusinessprocedurenr("1");
		
		outopenoccasstart(iccstart,"First generation of occassstart START");
		occstart = gnes.generateNextSequencedo(iccstart);
		outopenoccasstart(occstart,"First generation of occassstart END");
		
		iccstart = occstart;
		iccstart.setstate("END");
		outopenoccasstart(iccstart,"Second generation of occassstart START");
		occstart = gnes.generateNextSequencedo(iccstart);
		outopenoccasstart(occstart,"Second generation of occassstart END");

		iccstart = occstart;
		iccstart.setstate("END");
		outopenoccasstart(iccstart,"Third generation of occassstart START");
		occstart = gnes.generateNextSequencedo(iccstart);
		outopenoccasstart(occstart,"Third generation of occassstart END");
		
		

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


