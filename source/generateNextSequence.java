
//generateNextSequence


public class generateNextSequence
{

private String wrkevt = null;
private openoccasion iopocc = null;
private workitem iwoit = null;
private workeventname wen = null;
private workevent twe = null;
private workevent iwe = null;
private workevent owe = null;

public openoccasstart generateNextSequence (openoccasstart iopst) 

{
//* service to generate the next process sequence in process chain
	wrkevt = iopst.getworkeventnr();
	manageWorkevent iwemgr = new manageWorkevent();
	manageWorkevent owemgr = new manageWorkevent();
	twe = owemgr.getcurrentWorkevent();
	iwe = iwemgr.getWorkeventByID(wrkevt);

	if (wrkevt.compareTo("000000000000") > 0) 
	{
		if (iopst.getworkeventnamenr().compareTo("0") > 0) 
		{
		wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}	
		else if (iopst.getbusinessprocedurenr().compareTo("0") > 0) 
			{	
			wen = new loadWorkeventName().loadWorkeventNameByBNr(iopst.getbusinessprocedurenr());
			}	
		if (iwe.gettechnicaloccasionnr().compareTo("000000000000") > 0) 
		{		
		openoccasion iopocc = new manageOpenoccasion().getOpenoccasionByNR(iwe.gettechnicaloccasionnr());
		}		
		if (iwe.getworkitemnumber().compareTo("000000000000") > 0)
		{		
		workitem iwoit = new manageWorkitem().getWorkitemByNR(iwe.getworkitemnumber());
		}	
	}
	else 
	{
		if (iopst.getworkeventnamenr().compareTo("0") > 0) 
		{		
		wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}		
		else if (iopst.getbusinessprocedurenr().compareTo("0") > 0)
			{		
			wen = new loadWorkeventName().loadWorkeventNameByBNr(iopst.getbusinessprocedurenr());
			}		
		owemgr = generatenewWorkevent(twe,wen,iopst); 
	}

	twe = iwe;
	openoccasstart oopst = new openoccasstart();

	if (iopst.getbusinessprocedurenr()  == null || iopst.getbusinessprocedurenr() == iwe.getbusinessprocedurenr())
	{
		if (new loadWorkeventName().getnextWorkeventNameNR(wen.getworkeventnamenr()).compareTo("0") < 1 && iwe.getcorelworkevent().compareTo("000000000000") > 0) 	
		{
			twe = new manageWorkevent().getWorkeventByID(iwe.getcorelworkevent());
			wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}
	}	
	else if (iopst.getbusinessprocedurenr()  != null && iopst.getbusinessprocedurenr() != iwe.getbusinessprocedurenr()) 
		{
			wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
			occasiontype occt = new loadOccasiontypebyNr(wen.getoccasionnr());
			twe.settechnicalsourceoccasionnr(iwe.gettechnicaloccasionnr);
			twe.setoccasiontype(occt.getoccasiontype());
			owe = generatenewWorkevent(twe,wen,iopst).getcurrentWorkevent();
		}

	switch (iopst.getstate())
	{
		case "END": 
			if (iopst.getreferencetouse() != null && iopst.getreferencetouse().compareTo("000000000000") > 0)
			{
				twe.setobjectreference(iopst.getreferencetouse());
			}
			owemgr = generatenewWorkevent(twe,wen,iopst);
			break;
		case "REST": 
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "START": 
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "CALLPEOC": 	
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
		case "OUTPUTWAIT": 
		    	break;
		case "OUTPUTTERM":
		    	break;
		default: 
			oopst.setworkeventnamenr("-1");
	}
	return owemgr.updateWorkeventRouted(owemgr.getcurrentWorkevent().getid(),"1");
}
	
private manageWorkevent generatenewWorkevent(workevent iwe, workeventname wen, openoccasstart opstart) {
	occasiontype occt = new loadOccasiontypebyNr().getoccasiontype(wen.getoccasionnr());
	manageWorkevent wemgr = new manageWorkevent();
	workevent twe = wemgr.createWorkevent(wen.getworkeventnamenr(),
					iwe.getstartworkeventnr(),
					iwe.getobjectreference(),
					occt.getoccastiontype(),
					wen.getbusinessprocedurenr(),
					iwe.gettechnicaloccasionnr(),
					iwe.gettechnicalsourceoccasionnr(), 
					iwe.getworkitemnumber(),
					iwe.getcorelworkevent(),
					iwe.getoccasioninstance());

	return wemgr;
}

private openoccasstart generatenewopenoccasstart(workevent wk) {
	openoccasstart ost = new openoccasstart(); 
	ost.setworkeventnamenr(wk.getworkeventnamenr());
	ost.setworkeventnr(wk.getid());
	ost.setstate("-1");
	ost.setbusinessprocedurenr(wk.getbusinessprocedurenr());
	ost.setreferencetouse(wk.getobjectreference());
	return ost;
}

}
