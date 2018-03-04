//loadWorkItem
// 

public class loadWorkItem
{

private String workitemnumber = "098765432178";
private String occasionnr = "416483620185";
private String description = "Do something";
private String businessobject = "463728194736";
private String businessobjectname = "Schadenfall";
private String document = "-1";
private String worktocomplete = "you must work"; 
private String worktocompletedate = "15.03.2018";
private String reminderdate = "-1";
private String completionreason = "-1";
private String completiondate = "-1";
private String state = "started";
private String workitemassignedto = "637281947436";
private String processtoken = "-1";
private String workeventnamenr = "1";
private String businessprocedurenr = "5";
private String occasioninstance = "-1";
private String workitemprocessingtime = "01.03.2018 15:43";

public workitem loadWorkItem () 
{
	return new workitem(workitemnumber, 
			occasionnr,
			description, 
			businessobject, 
			businessobjectname, 
			document, 
			worktocomplete, 
			worktocompletedate, 
			reminderdate, 
			completionreason, 
			completiondate, 
			state, 
			workitemassignedto,
			workeventnamenr, 
			businessprocedurenr, 	
			occasioninstance,
			workitemprocessingtime);
}

}
