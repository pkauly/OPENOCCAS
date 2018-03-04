//workeventname
// 
// <workeventname>
// 	<id>“id“</id> 
// 	<workeventnamenr>“number“</workeventnamenr>
// 	<businessprocedurenr>“number“</businessprocedurenr>	
// 	<processid>“number“</processid>	
// 	<workeventname>“string“</workeventname>
// 	<eventtype>“string“</processname>
//     	<nextworkeventmamenr>“number“</nextworkeventnamenr>
//     	<occasionnr>”occasiontype”</occasiontype>
// </workeventname>

public class workeventname
{

private static String id = "-1";
private String workeventnamenr;
private String businessprocedurenr;
private String processid;
private String workeventname;
private String eventtype;
private String nextworkeventmamenr;
private String occasionnr;

public workeventname() 
{
	setworkeventnamenr("-1");
	setbusinessprocedurenr("-1");
	setprocessid("-1");
	setworkeventname("-1");
	seteventtype("-1");
	setnextworkeventmamenr("-1");
	setoccasionnr("-1"); 
}


public workeventname (String workeventnamenr, 
		String businessprocedurenr,
		String processid, 
		String workeventname, 
		String eventtype, 
		String nextworkeventmamenr, 
		String occasionnr)
{
	setworkeventnamenr(workeventnamenr);
	setbusinessprocedurenr(businessprocedurenr);
	setprocessid(processid);
	setworkeventname(workeventname);
	seteventtype(eventtype);
	setnextworkeventmamenr(nextworkeventmamenr);
	setoccasionnr(occasionnr); 
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
public void setbusinessprocedurenr(String input)
{
	occasionnr = businessprocedurenr;
}
public String getbusinessprocedurenr()
{
	return businessprocedurenr;
}
public void setprocessid(String input)
{
	processid = input;
}
public String getprocessid()
{
	return processid;
}
public void setworkeventname(String input)
{
	workeventname = input;
}
public String getworkeventname()
{
	return workeventname;
}
public void seteventtype(String input)
{
	eventtype = input;
}
public String geteventtype()
{
	return eventtype;
}
public void setnextworkeventmamenr(String input)
{
	nextworkeventmamenr = input;
}
public String getnextworkeventmamenr()
{
	return nextworkeventmamenr;
}
public void setoccasionnr(String input)
{
	occasionnr = input;
}
public String getoccasionnr()
{
	return occasionnr;
}

}
