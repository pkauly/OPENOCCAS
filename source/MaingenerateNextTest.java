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

		int count = 1;
		do 
		{
			outopenoccasstart(iccstart,"##### " + count + " generation of occassstart START");
			occstart = gnes.generateNextSequencedo(iccstart);
			outopenoccasstart(occstart,"##### " + count + " generation of occassstart END");
			iccstart = occstart;
			occstart = null;		
			if (count == 2)
			{
				iccstart.setstate("CALLPROC");
				iccstart.setbusinessprocedurenr("4");
				iccstart.setworkeventnamenr("21");
				iccstart.setreferencetouse("123456789009");
			}
			else
			{
				iccstart.setstate("END");
			}
			count++;
	
		} while (Integer.parseInt(iccstart.getworkeventnamenr()) > 0);
		
			

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


