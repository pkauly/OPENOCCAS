//MainmanageWorkeventTest


public class MainmanageWorkeventTest
{
public static void main(String[] args)
	{

	manageWorkevent mwe = new manageWorkevent();
	workevent we = mwe.getWorkeventByID("2");
	        	System.out.print(" main ID: " + we.getid());
         		System.out.print(", workeventnamenr " + we.getworkeventnamenr());
         		System.out.print(", startworkeventnr: " + we.getstartworkeventnr());
         		System.out.print(", objectreference: " + we.getobjectreference());
         		System.out.print(", occasiontype: " + we.getoccasiontype());
         		System.out.print(", businessprocedurenr: " + we.getbusinessprocedurenr());
         		System.out.print(", technicaloccasionnr: " + we.gettechnicaloccasionnr());
         		System.out.print(", technicalsourceoccasionnr: " + we.gettechnicalsourceoccasionnr());
         		System.out.print(", workitemnumber: " + we.getworkitemnumber());
         		System.out.print(", processingstate: " + we.getprocessingstate());
         		System.out.print(", corelworkevent: " + we.getcorelworkevent());
         		System.out.println(", occasioninstance: " + we.getoccasioninstance());
	
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
	        	System.out.print(" main ID: " + nwe.getid());
         		System.out.print(", workeventnamenr " + nwe.getworkeventnamenr());
         		System.out.print(", startworkeventnr: " + nwe.getstartworkeventnr());
         		System.out.print(", objectreference: " + nwe.getobjectreference());
         		System.out.print(", occasiontype: " + nwe.getoccasiontype());
         		System.out.print(", businessprocedurenr: " + nwe.getbusinessprocedurenr());
         		System.out.print(", technicaloccasionnr: " + nwe.gettechnicaloccasionnr());
         		System.out.print(", technicalsourceoccasionnr: " + nwe.gettechnicalsourceoccasionnr());
         		System.out.print(", workitemnumber: " + nwe.getworkitemnumber());
         		System.out.print(", processingstate: " + nwe.getprocessingstate());
         		System.out.print(", corelworkevent: " + nwe.getcorelworkevent());
         		System.out.println(", occasioninstance: " + nwe.getoccasioninstance());
	return;
	}

}


