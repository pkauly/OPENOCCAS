
//generateNextSequence


public class generateNextSequence
{

private String wrkevt = null;
private openoccasion iopocc = null;
private workitem iwoit = null;
private workeventname wen = null;
private workevent twe = null;
private workevent iwe = null;

public openoccasstart generateNextSequence (openoccasstart iopst) 

{
//* service to generate the next process sequence in process chain
	wrkevt = iopst.getworkeventnr();
	wemgr = new manageWorkevent();
	twe = wemgr.getcurrentWorkevent();
	iwe = new manageWorkevent.getWorkeventByID(wrkevt);
	workevent owemgr = new manageWorkevent();

	if (wrkevt > "000000000000") 
	{
		iwe = wemgr.getWorkeventByID(wrkevt);
		if (iopst.getworkeventnamenr() > "0") 
		{
		wen = loadWorkeventNameByNr(iopst.getworkeventnamenr());
		}	
		else if (iopst.getbusinessprocedurenr() > "0") 
			{	
			wen = loadWorkeventNamebyBNr(iopst.getbusinessprocedurenr());
			}	
		if (iwe.gettechnicaloccasionnr() > "000000000000") 
		{		
		openoccasion iopocc = loadOpenoccasion(iwe.gettechnicaloccasionnr());
		}		
		if (iwe.getworkitemnumber() > "000000000000")
		{		
		workitem iwoit = loadWorkItem(iwe.getworkitemnumber());
		}	
	}
	else 
	{
		if (iopst.getworkeventnamenr() > "0") 
		{		
		wen = loadWorkeventNameByNr(iopst.getworkeventnamenr());
		}		
		else if (iopst.getbusinessprocedurenr() > "0")
			{		
			wen = loadWorkeventNamebyBNr(iopst.getbusinessprocedurenr());
			}		
		iwe = generatenewWorkevent(twe,wen,iopst); 
	}

	twe = iwe;
	openoccasstart oopst = new openoccasstart();

	if (iopst.getbusinessprocedurenr()  == null || iopst.getbusinessprocedurenr() == iwe.getbusinessprocedurenr())
	{
		if (wen.getnextworkeventnamenr == "0" && iwe.getcorelworkevent() > "000000000000") 	
		{
			twe = wemgr.getWorkeventByID(iwe.getcorelworkevent());
			wen = loadWorkeventNameByNr(twe.getworkeventnamenr());
		}
	}	
	else if (iopst.getbusinessprocedurenr()  != null && iopst.getbusinessprocedurenr() != iwe.getbusinessprocedurenr()) 
		{
			wen = loadWorkeventNameByNr(iwe.getworkeventnamenr());
			occastiontype occt = loadOccastiontypebyNr(wen.getoccasionnr());
			twe.settechnicalsourceoccasionnr(iwe.itechnicaloccasionnr);
			twe.setoccasiontype = occt.getoccastiontype();
			owe = generatenewWorkevent(twe,wen,ioopst);
		}

	switch (iopst.getstatus())
	{
		case "END": 
			if (iopst.getreferencetouse() != null && iopst.getreferencetouse() > "000000000000")
			{
				twe.setobjetreference(iopst.getreferencetouse());
			}
			owe = generatenewWorkevent(twe,wen,iopst);
			break;
		case "REST": 
			owe = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "START": 
			owe = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "CALLPEOC": 	
			owe = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
		case "OUTPUTWAIT": 
		    	break;
		case "OUTPUTTERM":
		    	break;
		default: 
			oopst.setworkeventnamenr("-1");
	}
	return owemgr.updateWorkeventRouted(owe.getid(),"1")
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
