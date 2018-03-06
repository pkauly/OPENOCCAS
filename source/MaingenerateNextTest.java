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
		iccstart.setbusinessprocedurenr("5");

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

}


