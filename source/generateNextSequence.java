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

public generateNextSequence()
{
}

public openoccasstart generateNextSequencedo(openoccasstart iopst) 
{
//* service to generate the next process sequence in process chain
	wrkevt = iopst.getworkeventnr();
	manageWorkevent iwemgr = new manageWorkevent();
	manageWorkevent owemgr = new manageWorkevent();
	twe = owemgr.getcurrentWorkevent();

	if (wrkevt.compareTo("0") > 0) 
	{
		System.out.println("checkpoint 1");
		iwe = iwemgr.getWorkeventByID(wrkevt);
		twe = iwe;
		if (iopst.getworkeventnamenr().compareTo("0") > 0) 
		{
			wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}	
		else if (iopst.getbusinessprocedurenr().compareTo("0") > 0) 
			{	
				System.out.println("checkpoint 2");
				wen = new loadWorkeventName().loadWorkeventNameByBNr(iopst.getbusinessprocedurenr());
			}	
		if (iwe.gettechnicaloccasionnr().compareTo("000000000000") > 0) 
		{	
			System.out.println("checkpoint 3");	
			openoccasion iopocc = new manageOpenoccasion().getOpenoccasionByNR(iwe.gettechnicaloccasionnr());
		}		
		if (iwe.getworkitemnumber().compareTo("000000000000") > 0)
		{	
			System.out.println("checkpoint 4");	
			workitem iwoit = new manageWorkitem().getWorkitemByNR(iwe.getworkitemnumber());
		}	
	}
	else 
	{
		System.out.println("checkpoint 5");
		if (iopst.getworkeventnamenr().compareTo("0") > 0) 
		{
		System.out.println("checkpoint 6");		
		wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}		
		else if (iopst.getbusinessprocedurenr().compareTo("0") > 0)
			{
			System.out.println("checkpoint 7");		
			wen = new loadWorkeventName().loadWorkeventNameByBNr(iopst.getbusinessprocedurenr());
			}
		System.out.println("checkpoint 8 " );
		owemgr = generatenewWorkevent(twe,wen,iopst); 
		twe = owemgr.getcurrentWorkevent();
		iwe = twe;
	}

	openoccasstart oopst = new openoccasstart();

	if (iopst.getbusinessprocedurenr() == null || iopst.getbusinessprocedurenr().compareTo(iwe.getbusinessprocedurenr()) == 0)
	{
		System.out.println("checkpoint 9");
		if (new loadWorkeventName().loadWorkeventNameByBNr(wen.getworkeventnamenr()).getnextworkeventnamenr().compareTo("0") < 1 && iwe.getcorelworkevent().compareTo("000000000000") > 0) 
		{
			System.out.println("checkpoint 10");
			twe = new manageWorkevent().getWorkeventByID(iwe.getcorelworkevent());
			wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
		}
	}	
	else if (iopst.getbusinessprocedurenr() != null && iopst.getbusinessprocedurenr().compareTo(iwe.getbusinessprocedurenr()) != 0) 
		{
			System.out.println("checkpoint 11 iopst.getbusinessprocedurenr() " + iopst.getbusinessprocedurenr() + " iwe.getbusinessprocedurenr() " + iwe.getbusinessprocedurenr() );
			wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
			loadOccasiontype locct = new loadOccasiontype();
			occasiontype occt = locct.getOccasiontypeByNR(iwe.getoccasiontype());
			String occtype = occt.getoccasiontype();
			twe.settechnicalsourceoccasionnr(iwe.gettechnicaloccasionnr());
			twe.setoccasiontype(occtype);
//			owe = generatenewWorkevent(twe,wen,iopst).getcurrentWorkevent();
		}

	switch (iopst.getstate())
	{
		case "END": 
			System.out.println("checkpoint 12");
			if (iopst.getreferencetouse() != null && iopst.getreferencetouse().compareTo("000000000000") > 0)
			{
				System.out.println("checkpoint 13");
				twe.setobjectreference(iopst.getreferencetouse());
			}
			owemgr = generatenewWorkevent(twe,wen,iopst);
			break;
		case "REST": 
			System.out.println("checkpoint 14");
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "START": 
			System.out.println("checkpoint 15");
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			break;
		case "CALLPEOC": 
			System.out.println("checkpoint 16");	
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
		case "OUTPUTWAIT": 
			System.out.println("checkpoint 17");
		    	break;
		case "OUTPUTTERM":
			System.out.println("checkpoint 18");
		    	break;
		default: 
			System.out.println("checkpoint 19");
			oopst.setworkeventnamenr("-1");
	}
	owe = owemgr.updateWorkeventRouted(owemgr.getcurrentWorkevent().getid());
	return oopst;
}
	
private manageWorkevent generatenewWorkevent(workevent iwe, workeventname wen, openoccasstart opstart) {
	System.out.println("Occasiontype " + wen.getoccasionnr());
	occasiontype occt = new loadOccasiontype().getOccasiontypeByNR(wen.getoccasionnr());
	System.out.println("Occasiontype " + occt.getid() + " " + occt.getoccasionnr() + " " + occt.getoccasiondescription() + " " + occt.getoccasiontype());
	System.out.println("checkpoint 20");
	manageWorkevent wemgr = new manageWorkevent();
	workevent twe = wemgr.createWorkevent(wen.getworkeventnamenr(),
					iwe.getstartworkeventnr(),
					iwe.getobjectreference(),
					occt.getoccasiontype(),
					wen.getbusinessprocedurenr(),
					iwe.gettechnicaloccasionnr(),
					iwe.gettechnicalsourceoccasionnr(), 
					iwe.getworkitemnumber(),
					iwe.getcorelworkevent(),
					iwe.getoccasioninstance());

	return wemgr;
}

private openoccasstart generatenewopenoccasstart(workevent wk) {
	System.out.println("checkpoint 21");
	openoccasstart ost = new openoccasstart(); 
	ost.setworkeventnamenr(wk.getworkeventnamenr());
	ost.setworkeventnr(wk.getid());
	ost.setstate("-1");
	ost.setbusinessprocedurenr(wk.getbusinessprocedurenr());
	ost.setreferencetouse(wk.getobjectreference());
	return ost;
}

}
