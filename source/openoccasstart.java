//openoccasstart

// <openoccasstart>
// 	<workeventnr>”businessnumber”</workeventnr>
// 	<workeventnamenr>”workeventnamenumber”</workeventnamenr>
// 	<state>”string”</state>
// 	<referencetouse>”businessnumber”</corellid>
// 	<businessprocedurenr>”businesprocedurenumber”</businessprocedurenr>
// </openoccasstart>
public class openoccasstart
{

private String workeventnr;
private String workeventnamenr;
private String state;
private String referencetouse;
private String businessprocedurenr;

public void openoccasstart () 
{
	setworkeventnr("-1");
	setworkeventnamenr("-1");
	setstate("-1");
	setreferencetouse("-1");
	setbusinessprocedurenr("-1");
}


public void openoccasstart (String workeventnr, 
			String technicaloccasionnr,
			String workeventnamenr, 
			String state, 
			String referencetouse, 
			String businessprocedurenr)
{
	setworkeventnr(workeventnr);
	setworkeventnamenr(technicaloccasionnr);
	setstate(state);
	setreferencetouse(referencetouse);
	setbusinessprocedurenr(businessprocedurenr);
}

public void setworkeventnr(String input)
{
	workeventnr = input;
}
public String getworkeventnr()
{
	return workeventnr;
}
public void setworkeventnamenr(String input)
{
	workeventnamenr = input;
}
public String getworkeventnamenr()
{
	return workeventnamenr;
}
public void setstate(String input)
{
	state = input;
}
public String getstate()
{
	return state;
}
public void setreferencetouse(String input)
{
	referencetouse = input;
}
public String getreferencetouse()
{
	return referencetouse;
}
public void setbusinessprocedurenr(String input)
{
	businessprocedurenr = input;
}
public String getbusinessprocedurenr()
{
	return businessprocedurenr;
}

}
