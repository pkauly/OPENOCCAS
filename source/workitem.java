//workitem
// 
// <workitem>
// 	<id>“id“</id>
//     	<workitemnumber>”businessnumber”</workitemnumber>
//     	<occasionnr>”businessnumber”</occasionnr>
//     	<description>“string“</description>
// 	<businessobject>”businessnumber”</businessobject>
// 	<businessobjectname>“sring</businessobjectname>
// 	<document>”businessnumber”</document>
// 	<worktocomplete>“string“</worktocomplete>
// 	<worktocompletedate>date</worktocompletedate>
// 	<reminderdate>date</reminderdate>
// 	<completionreason>“string“</completionreason>
// 	<completiondate>date</completiondate>
// 	<state>“string“</state>
// 	<workitemassignedto>”businessnumber”</workitemassignedto>
//     	<processtoken>“sring“</processtoken>
// 	<workeventnamenr>“number“</workeventnamenr>
// 	<businessprocedurenr>“number“</businessprocedurenr>
// 	<occasioninstance>“string“</occasioninstance>
// 	<workitemprocessingtime>timestamp</workitemprocessingtime>
// </workitem>

public class workitem
{

private static String id = "-1";
private String workitemnumber;
private String occasionnr;
private String description;
private String businessobject;
private String businessobjectname;
private String document;
private String worktocomplete; 
private String worktocompletedate;
private String reminderdate;
private String completionreason;
private String completiondate;
private String state;
private String workitemassignedto;
private String processtoken;
private String workeventnamenr;
private String businessprocedurenr;
private String occasioninstance;
private String workitemprocessingtime;

public workitem () 
{
	setworkitemnumber("-1");
	setoccasionnr("-1");
	setdescription("-1");
	setbusinessobject("-1");
	setbusinessobjectname("-1");
	setdocument("-1");
	setworktocomplete("-1"); 
	setworktocompletedate("-1");
	setreminderdate("-1");
	setcompletionreason("-1");
	setcompletiondate("-1");
	setstate("-1");
	setworkitemassignedto("-1");
	setprocesstoken("-1");
	setworkeventnamenr("-1");
	setbusinessprocedurenr("-1");
	setoccasioninstance("-1");
	setworkitemprocessingtime("-1");
}


public workitem (String workitemnumber, 
			String occasionnr, 
			String description, 
			String businessobject, 
			String businessobjectname, 
			String document, 
			String worktocomplete, 
			String worktocompletedate, 
			String reminderdate, 
			String completionreason, 
			String completiondate, 
			String state, 
			String workitemassignedto,
			String processtoken,
			String workeventnamenr, 
			String businessprocedurenr, 	
			String occasioninstance,
			String workitemprocessingtime)
{
	setworkitemnumber(occasionnr);
	setoccasionnr(occasionnr);
	setdescription(description);
	setbusinessobject(businessobject);
	setbusinessobjectname(businessobjectname);
	setdocument(document);
	setworktocomplete(worktocomplete); 
	setworktocompletedate(worktocompletedate);
	setreminderdate(reminderdate);
	setcompletionreason(completionreason);
	setcompletiondate(completiondate);
	setstate(state);
	setworkitemassignedto(workitemassignedto);
	setprocesstoken(processtoken);
	setworkeventnamenr(workeventnamenr);
	setbusinessprocedurenr(businessprocedurenr);
	setoccasioninstance(occasioninstance);
	setworkitemprocessingtime(workitemprocessingtime);
}

public String getid()
{
	return id;
}
public void setworkitemnumber(String input)
{
	workitemnumber = input;
}
public String getworkitemnumber()
{
	return workitemnumber;
}
public void setoccasionnr(String input)
{
	occasionnr = input;
}
public String getoccasionnr()
{
	return occasionnr;
}
public void setdescription(String input)
{
	description = input;
}
public String getdescription()
{
	return description;
}
public void setbusinessobject(String input)
{
	businessobject = input;
}
public String getbusinessobject()
{
	return businessobject;
}
public void setbusinessobjectname(String input)
{
	businessobjectname = input;
}
public String getbusinessobjectname()
{
	return businessobjectname;
}
public void setdocument(String input)
{
	document = input;
}
public String getdocument()
{
	return document;
}
public void setworktocomplete(String input)
{
	worktocomplete = input;
}
public String getworktocomplete()
{
	return worktocomplete;
}
public void setworktocompletedate(String input)
{
	worktocompletedate = input;
}
public String getworktocompletedate()
{
	return worktocompletedate;
}	
public void setreminderdate(String input)
{
	reminderdate = input;
}
public String getreminderdate()
{
	return reminderdate;
}
public void setcompletionreason(String input)
{
	completionreason = input;
}
public String getcompletionreason()
{
	return completionreason;
}	
public void setcompletiondate(String input)
{
	completiondate = input;
}
public String getcompletiondate()
{
	return completiondate;
}	
public void setstate(String input)
{
	state = input;
}
public String getstate()
{
	return state;
}	
public void setworkitemassignedto(String input)
{
	workitemassignedto =input;
}
public String getworkitemassignedto()
{
	return workitemassignedto;	
}
public void setprocesstoken(String input)
{
	processtoken = input;
}
public String getprocesstoken()
{
	return processtoken;
}
public void setworkeventnamenr(String input)
{
	workeventnamenr = input;
}
public String getworkeventnamenr()
{
	return workeventnamenr;		
}
public void setbusinessprocedurenr(String input)
{
	businessprocedurenr = input;
}
public String getbusinessprocedurenr()
{
	return businessprocedurenr;
}	
public void setoccasioninstance(String input)
{
	occasioninstance = input;
}
public String getoccasioninstance()
{
	return occasioninstance;					
}
public void setworkitemprocessingtime(String input)
{
	workitemprocessingtime = input;
}
public String getworkitemprocessingtime()
{
	return workitemprocessingtime;					

}
}
