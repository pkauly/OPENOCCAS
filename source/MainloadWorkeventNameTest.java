//MainloadWorkeventNameTest


public class MainloadWorkeventNameTest
{
public static void main(String[] args)
	{
	String newrken = null;
	workeventname wen = null;
	loadWorkeventName mwe = new loadWorkeventName();

	wen = mwe.loadWorkeventNameByNr("1","1");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("2","1");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("3","1");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("4","1");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("5","2");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("6","2");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("7","2");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());

	wen = mwe.loadWorkeventNameByNr("8","2");
	System.out.println("getworkeventname " + wen.getworkeventname() + " geteventtype " + wen.geteventtype());
	newrken = mwe.getnextWorkeventNameNR();
	if (newrken == "0") System.out.println(newrken + "no more events " );
	else System.out.println(newrken + " " + mwe.loadWorkeventNameByNr(newrken,"5").getworkeventnamenr());
   }

}


