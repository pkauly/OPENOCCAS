//MainmanageWorkeventTest
import service.*;
import objectmanagement.*;

public class MainmanageWorkeventTest
{
public static void main(String[] args)
	{

	manageWorkevent mwe = new manageWorkevent();
	workevent we = mwe.getWorkeventByID("1");
	outworkevent(we,"getWorkeventByID");
	
	mwe = new manageWorkevent();
	workevent nwe = mwe.createWorkevent(we.getworkeventnamenr(),
				we.getstartworkeventnr(),
				we.getobjectreference(),
				we.getoccasiontype(),
				we.getbusinessprocedurenr(),
				we.gettechnicaloccasionnr(),
				we.gettechnicalsourceoccasionnr(),
				we.getworkitemnumber(),
				we.getid(),
				"myInstance");	
	outworkevent(nwe,"createWorkevent 1");

	mwe.updateWorkeventRouted(nwe.getid());
	outworkevent(nwe,"updateWorkeventRouted");
	we = new workevent();
	nwe = mwe.createWorkevent("5",
				null,
				null,
				"5",
				"3",
				null,
				null,
				null,
				null,
				"newInstance");	
	outworkevent(nwe,"createWorkevent 2");
	we = mwe.updateWorkeventByID(nwe.getid(),
				null,
				null,
				null,
				null,
				null,
				"180860000185",
				null,
				null,
				null,
				null);
	outworkevent(we,"updateWorkeventByID");
	return;
	}

public static void outworkevent(workevent nwe, String text)
{
     	System.out.println(text );     	
	System.out.print(" main ID: " + nwe.getid());
	System.out.print(", workeventnamenr " + nwe.getworkeventnamenr());
	System.out.print(", startworkeventnr: " + nwe.getstartworkeventnr());
  	System.out.print(", objectreference: " + nwe.getobjectreference());
        System.out.print(", occasiontype: " + nwe.getoccasiontype());
        System.out.print(", businessprocedurenr: " + nwe.getbusinessprocedurenr());
        System.out.println(", technicaloccasionnr: " + nwe.gettechnicaloccasionnr());
        System.out.print(", technicalsourceoccasionnr: " + nwe.gettechnicalsourceoccasionnr());
        System.out.print(", workitemnumber: " + nwe.getworkitemnumber());
        System.out.print(", processingstate: " + nwe.getprocessingstate());
        System.out.print(", corelworkevent: " + nwe.getcorelworkevent());
        System.out.println(", occasioninstance: " + nwe.getoccasioninstance());
}

}


