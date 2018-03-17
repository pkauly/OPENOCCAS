//wopenoccasinterface
// 
//

public class wopenoccasinterface
{

private workevent wrkevt = null;
private openoccasion opocc = null;
private workitem woitm = null;
private openoccasstart opoccst = null;
private ruleResult rlrst = null;

public wopenoccasinterface () 
{
	rlrst = new ruleResult("-1","ERROR setting result");
	wrkevt = new workevent();
	opocc = new openoccasion();
	woitm = new workitem();
	opoccst = new openoccasstart();
}


public workevent setworkevent(workevent iwrkevt)
{
	wrkevt = new workevent(iwrkevt.getid(),	
		iwrkevt.getworkeventnamenr(),
		iwrkevt.getstartworkeventnr(),
		iwrkevt.getobjectreference(),
		iwrkevt.getoccasiontype(),
		iwrkevt.getbusinessprocedurenr(),
		iwrkevt.gettechnicaloccasionnr(),
		iwrkevt.gettechnicalsourceoccasionnr(), 
		iwrkevt.getworkitemnumber(),
		iwrkevt.getprocessingstate(),
		iwrkevt.getcorelworkevent(),
		iwrkevt.getoccasioninstance());
	return wrkevt;
}

public workevent getworkevent()
{
	return wrkevt;
}

public openoccasion setopenoccasion(openoccasion iopocc)
{
	opocc = new openoccasion(iopocc.getbusinessoccasionnr(),
		iopocc.gettechnicaloccasionnr(),
		iopocc.getbusinesstatus(),
		iopocc.getdisplayattribut1(),
		iopocc.getdisplayattribut2(),
		iopocc.getdisplayattribut3(),
		iopocc.getdisplayattribut4(),
		iopocc.getoccasiontype(),
		iopocc.getorganisationrole(),
		iopocc.getfunctionrole(),
		iopocc.getassignedhandlingofficer(),
		iopocc.getpartner(),
		iopocc.getcompetencelevel(),
		iopocc.gettemporarycompetencelevel(),
		iopocc.getreferencetemporarycompetencelevel(),
		iopocc.getlastprocessingdate(),
		iopocc.getobjectreference());
	opocc.setid(iopocc.getid());
	return opocc;
}

public openoccasion getopenoccasion()
{
	return opocc;
}

public workitem setworkitem(workitem iwoitm)
{
	woitm = new workitem(iwoitm.getworkitemnumber(),
		iwoitm.getoccasionnr(),
		iwoitm.getdescription(),
		iwoitm.getbusinessobject(),
		iwoitm.getbusinessobjectname(),
		iwoitm.getdocument(),
		iwoitm.getworktocomplete(),
		iwoitm.getworktocompletedate(),
		iwoitm.getreminderdate(),
		iwoitm.getcompletionreason(),
		iwoitm.getcompletiondate(),
		iwoitm.getstate(),
		iwoitm.getworkitemassignedto(),
		iwoitm.getprocesstoken(),
		iwoitm.getworkeventnamenr(),
		iwoitm.getbusinessprocedurenr(),
		iwoitm.getoccasioninstance(),
		iwoitm.getworkitemprocessingtime());
	return woitm;
}

public workitem getworkitem()
{
	return woitm;
}

public openoccasstart setopenoccasstart(openoccasstart iopoccst)
{
	opoccst = new openoccasstart(iopoccst.getworkeventnr(),
		iopoccst.getworkeventnamenr(),
		iopoccst.getstate(),
		iopoccst.getreferencetouse(),
		iopoccst.getbusinessprocedurenr());
	return opoccst;
}

public openoccasstart getopenoccasstart()
{
	return opoccst;
}

public ruleResult setruleResult(ruleResult irlrst)
{
	rlrst = new ruleResult(irlrst.getResult(),irlrst.getparkingReason());
	return rlrst;
}

public ruleResult getruleResult()
{
	return rlrst;
}
}
