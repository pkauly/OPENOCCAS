//workevent
// 
// <workevent>
// 	<id>”id”</id>
// 	<workeventnamenr>”workeventnamenumber”</workeventnamenr>
// 	<startworkeventnr>”businessnumber”</startworkeventnr>
// 	<objectreference>”businessnumber”</objectreference>
// 	<occasiontype>”occasiontype”</occasiontype>
// 	<businessprocedurenr>”businesprocedurenumber”</businessprocedurenr>
// 	<technicaloccasionnr>”businessnumber”</technicaloccasionnr>
// 	<technicalsourceoccasionnr>”businessnumber”</technicalsourceoccasionnr>
// 	<workitemnumber>”businessnumber”</workitemnumber>
// 	<processingstate>”0|1”</processingstate>		
// 	<corelworkevent>”businessnumber”</corellid>
// 	<occasioninstance>”processinstancenumber”</occasioninstance>
// </workevent>
public class workevent
{

private String id;
private String workeventnamenr;
private String startworkeventnr;
private String objectreference;
private String occasiontype;
private String businessprocedurenr;
private String technicaloccasionnr;
private String technicalsourceoccasionnr; 
private String workitemnumber;
private String processingstate;
private String corelworkevent;
private String occasioninstance;

public workevent() 
{
	setworkeventnamenr("-1");
	setstartworkeventnr("-1");
	setobjectreference("-1");
	setoccasiontype("-1");
	setbusinessprocedurenr("-1");
	settechnicaloccasionnr("-1");
	settechnicalsourceoccasionnr("-1"); 
	setworkitemnumber("-1");
	setprocessingstate("-1");
	setcorelworkevent("-1");
	setoccasioninstance("-1");
	id = "15";
}


public workevent(String id,
			String workeventnamenr, 
			String startworkeventnr, 
			String objectreference, 
			String occasiontype, 
			String businessprocedurenr, 
			String technicaloccasionnr, 
			String technicalsourceoccasionnr, 
			String workitemnumber, 
			String processingstate, 
			String corelworkevent, 
			String occasioninstance)
{
	setid(id);	
	setworkeventnamenr(workeventnamenr);
	setstartworkeventnr(startworkeventnr);
	setobjectreference(objectreference);
	setoccasiontype(occasiontype);
	setbusinessprocedurenr(businessprocedurenr);
	settechnicaloccasionnr(technicaloccasionnr);
	settechnicalsourceoccasionnr(technicalsourceoccasionnr); 
	setworkitemnumber(workitemnumber);
	setprocessingstate(processingstate);
	setcorelworkevent(corelworkevent);
	setoccasioninstance(occasioninstance);
}

public void setid(String input)
{
	id = input;
}
public String getid()
{
	return id;
}
public void setworkeventnamenr(String input)
{
	workeventnamenr = input;
}
public String getworkeventnamenr()
{
	return workeventnamenr;
}
public void setstartworkeventnr(String input)
{
	startworkeventnr = input;
}
public String getstartworkeventnr()
{
	return startworkeventnr;
}
public void setobjectreference(String input)
{
	objectreference = input;
}
public String getobjectreference()
{
	return objectreference;
}
public void setoccasiontype(String input)
{
	occasiontype = input;
}
public String getoccasiontype()
{
	return occasiontype;
}
public void setbusinessprocedurenr(String input)
{
	businessprocedurenr = input;
}
public String getbusinessprocedurenr()
{
	return businessprocedurenr;
}
public void settechnicaloccasionnr(String input)
{
	technicaloccasionnr = input;
}
public String gettechnicaloccasionnr()
{
	return technicaloccasionnr;
}
public void settechnicalsourceoccasionnr(String input)
{
	technicalsourceoccasionnr = input;
}
public String gettechnicalsourceoccasionnr()
{
	return technicalsourceoccasionnr;
}
public void setworkitemnumber(String input)
{
	workitemnumber = input;
}
public String getworkitemnumber()
{
	return workitemnumber;
}	
public void setprocessingstate(String input)
{
	processingstate = input;
}
public String getprocessingstate()
{
	return processingstate;
}
public void setcorelworkevent(String input)
{
	corelworkevent = input;
}
public String getcorelworkevent()
{
	return corelworkevent;
}	
public void setoccasioninstance(String input)
{
	occasioninstance = input;
}
public String getoccasioninstance()
{
	return occasioninstance;
}	

}
