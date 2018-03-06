//MainloadWorkeventNameTest


public class MainloadWorkeventNameTest
{
public static void main(String[] args)
	{

	loadWorkeventName mwe = new loadWorkeventName();
	System.out.println(mwe.loadWorkeventNameByNr("1","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("1","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("2","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("2","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("3","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("3","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("4","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("4","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("5","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("5","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("6","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("6","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("7","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("7","5").geteventtype());
	System.out.println(mwe.loadWorkeventNameByNr("8","5").getworkeventname() + " " + mwe.loadWorkeventNameByNr("8","5").geteventtype());
	
	String newrken = mwe.getnextWorkeventNameNR("4");
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	newrken = mwe.getnextWorkeventNameNR("5");
	if (newrken == "0") System.out.println(newrken + " no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());
	return;
	}

}


