//MaingenerateNextTest

// import Source.openoccas.*;

public class MaingenerateNextTest

{

private static openoccasstart occstart = null;
private static openoccasstart iccstart = null;
private ruleResult rlrst = null;
private static wopenoccasinterface wopintf = null;

public static void main(String[] args)
	{
		generateNextSequence gnes = new generateNextSequence();
		checkLoop gclo = new checkLoop();
		iccstart = new openoccasstart();
		iccstart.setworkeventnr("-1");
		iccstart.setworkeventnamenr("1");
		iccstart.setstate("START");
		iccstart.setreferencetouse("-1");
		iccstart.setbusinessprocedurenr("1");
		wopintf = new wopenoccasinterface();
		wopintf.setopenoccasstart(iccstart);

		int count = 1;
		do 
		{
			outopenoccasstart(wopintf.getopenoccasstart(),"##### " + count + " generation of occassstart START");
			wopintf = gclo.checkLoopdo(wopintf);
			if (Long.parseLong(wopintf.getruleResult().getResult()) < 0)
			{
				System.out.println("##### " + count + " error in checkLoop" + wopintf.getruleResult().getparkingReason());	
				break;
			} 
			wopintf = gnes.generateNextSequencedo(wopintf);
			if (Long.parseLong(wopintf.getruleResult().getResult()) < 0)
			{
				System.out.println("##### " + count + " error in generateNextSequence" + wopintf.getruleResult().getparkingReason());	
				break;
			} 	
			outopenoccasstart(wopintf.getopenoccasstart(),"##### " + count + " generation of occassstart END");
			iccstart = wopintf.getopenoccasstart();

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
			wopintf.setopenoccasstart(iccstart);
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


