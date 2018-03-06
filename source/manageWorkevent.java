//manageWorkevent
// 
import java.util.*;

public class manageWorkevent
{

private	ArrayList<workevent> wea = new ArrayList<workevent>();
private workevent we;

public manageWorkevent() 
{
	wea.add(new workevent("1","1","0","534923408345","5","5","416483620185","-1","098765432178","1","123456789012","-1"));
	wea.add(new workevent("2","2","1","534923408345","5","5","416483620185","-1","098765432178","1","123456789012","-1"));
	wea.add(new workevent("3","3","2","534923408345","5","5","416483620185","-1","098765432178","1","123456789012","-1"));
	wea.add(new workevent("4","4","3","534923408345","5","5","416483620185","-1","098765432178","1","123456789012","-1"));
	we = new workevent();
}

public workevent getWorkeventByID(String wenr)
{
	int i = Integer.parseInt(wenr);
	we = wea.get(i-1);

	return we;
}

public workevent getcurrentWorkevent()
{
	return we;
}

public workevent createWorkevent(String workeventnamenr,
				String startworkeventnr,
				String objectreference,
				String occasiontype,
				String businessprocedurenr,
				String technicaloccasionnr,
				String technicalsourceoccasionnr, 
				String workitemnumber,
				String corelworkevent,
				String occasioninstance)
{
	int i = wea.size() + 1;
	we = new workevent(Integer.toString(i),
				workeventnamenr,
				startworkeventnr,
				objectreference,
				occasiontype,
				businessprocedurenr,
				technicaloccasionnr,
				technicalsourceoccasionnr, 
				workitemnumber,
				"0",
				corelworkevent,
				occasioninstance);
	wea.add(we);
	return we;
}

public workevent updateWorkeventByID(String id,
				String workeventnamenr,
				String startworkeventnr,
				String objectreference,
				String occasiontype,
				String businessprocedurenr,
				String technicaloccasionnr,
				String technicalsourceoccasionnr, 
				String workitemnumber,
				String corelworkevent,
				String occasioninstance)
{
	int i = Integer.parseInt(id) - 1;
	we = wea.get(i);
	if (workeventnamenr != null) { we.setworkeventnamenr(workeventnamenr); }
	if (startworkeventnr != null) { we.setstartworkeventnr(startworkeventnr); }
	if (objectreference != null) { we.setobjectreference(objectreference); }
	if (occasiontype != null) { we.setoccasiontype(occasiontype);}
	if (businessprocedurenr != null) { we.setbusinessprocedurenr(businessprocedurenr);}
	if (technicaloccasionnr != null) { we.settechnicaloccasionnr(technicaloccasionnr);}
	if (technicalsourceoccasionnr != null) { we.settechnicalsourceoccasionnr(technicalsourceoccasionnr); }
	if (workitemnumber != null) { we.setworkitemnumber(workitemnumber);}
	if (corelworkevent != null) { we.setcorelworkevent(corelworkevent);}
	if (occasioninstance != null) { we.setoccasioninstance(occasioninstance);}
	wea.set(i,we);
	return we;
}

public workevent updateWorkeventRouted(String id, String processingstate)
{
	int i = Integer.parseInt(id) - 1;
	we = wea.get(i);
	if (processingstate == "0" || processingstate == "1") { we.setprocessingstate(processingstate); }
	else { we.setprocessingstate("0"); } 
	wea.set(i,we);
	return we;
}

}
