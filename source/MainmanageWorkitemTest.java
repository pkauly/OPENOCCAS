//MainmanageWorkitemTest


public class MainmanageWorkitemTest
{
public static void main(String[] args)
{

	manageWorkitem mwoi = new manageWorkitem();
	workitem woit = mwoi.getWorkitemByNR("123456789022");
	outworkitem(woit,"getWorkitemByNR");
	
	mwoi = new manageWorkitem();
	workitem nwoit = mwoi.createWorkitem(woit.getoccasionnr(),
					woit.getdescription(),
					woit.getbusinessobject(),
					woit.getbusinessobjectname(),
					woit.getdocument(),
					woit.getworktocomplete(),
					woit.getworktocompletedate(),
					woit.getremainderdate(),
					woit.getcompletionreason(),
					woit.getcompletiondate(),
					woit.getstate(),
					woit.getworkitemassignedto(),
					woit.getprocesstoken(),
					woit.getworkeventnamenr(),
					woit.getbusinessprocedurenr(),
					woit.getoccasioninstance());	
	outworkitem(nwoit,"createitem 1");

	nwoit = mwoi.updateworkitemByID("180850000128",
			"Check Document", 
			null, 
			null, 
			null, 
			"Please verify bill validity", 
			"2018-04-30", 
			null, 
			null, 
			null, 
			"M", 
			"123456789016",
			"NONE",
			null, 
			"TestToken");
	outworkitem(nwoit,"updateitem 1");
}

public static void outworkitem(workitem nwe, String text)
{
     	System.out.println(text );     	
	System.out.print(" main ID: " + nwe.getid());
	System.out.print(", workitemnumber " + nwe.getworkitemnumber());
	System.out.print(", occasionnr " + nwe.getoccasionnr());
	System.out.print(", description: " + nwe.getdescription());
  	System.out.print(", businessobject: " + nwe.getbusinessobject());
        System.out.print(", businessobjectname: " + nwe.getbusinessobjectname());
        System.out.print(", document: " + nwe.getdocument());
        System.out.println(", worktocomplete: " + nwe.getworktocomplete());
        System.out.print(", worktocompletedate: " + nwe.getworktocompletedate());
        System.out.print(", remainderdate: " + nwe.getremainderdate());
        System.out.print(", completionreason: " + nwe.getcompletionreason());
        System.out.print(", completiondate: " + nwe.getcompletiondate());
        System.out.println(", state: " + nwe.getstate());
        System.out.println(", workitemassignedto: " + nwe.getworkitemassignedto());
        System.out.println(", processtoken: " + nwe.getprocesstoken());
        System.out.println(", workeventnamenr: " + nwe.getworkeventnamenr());
        System.out.println(", businessprocedurenr: " + nwe.getbusinessprocedurenr());
        System.out.println(", occasioninstance: " + nwe.getoccasioninstance());
        System.out.println(", datecreated: " + nwe.getdatecreated());
}

}


