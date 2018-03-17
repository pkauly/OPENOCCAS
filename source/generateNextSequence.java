//generateNextSequence


public class generateNextSequence
{

private workeventname wen = null;
private workevent twe = null;
private workevent iwe = null;
private workevent owe = null;
private workeventname twen = null;
private openoccasstart iopst = null;
private openoccasstart oopst = null;
private ruleResult rlrst = null;
private wopenoccasinterface owopintf = null;

public generateNextSequence()
{
}

public wopenoccasinterface generateNextSequencedo(wopenoccasinterface iwopintf) 
{
//* service to generate the next process sequence in process chain

	manageWorkevent iwemgr = new manageWorkevent();
	manageWorkevent owemgr = new manageWorkevent();
	owopintf = new wopenoccasinterface();
	owopintf.setworkevent(iwopintf.getworkevent());
	owopintf.setopenoccasstart(iwopintf.getopenoccasstart());
	iopst = iwopintf.getopenoccasstart();
	rlrst = new ruleResult("-1","Error in generateNextSequence");


	if (Long.parseLong(iopst.getworkeventnr()) > 0)
	{
		System.out.println("checkpoint 1");
		iwe = iwemgr.getWorkeventByID(iopst.getworkeventnr());
	}
	else
	{
		System.out.println("checkpoint 2");
		iwe = new workevent();
	}
	System.out.println("checkpoint 3");
	twe = initializeWorkevent(iwe);

	if (Long.parseLong(iopst.getreferencetouse()) > 0)
	{
		twe.setobjectreference(iopst.getreferencetouse());
	}

	if (Long.parseLong(iopst.getworkeventnamenr()) > 0 && Long.parseLong(iopst.getbusinessprocedurenr()) > 0 )
	{
		System.out.println("checkpoint 4");
		wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());	
	}
	else 	
	{
		if (Long.parseLong(iopst.getbusinessprocedurenr()) > 0 )
		{
			System.out.println("checkpoint 5");
			wen = new loadWorkeventName().loadWorkeventNameByBNr(iopst.getbusinessprocedurenr());
		}
		else
		{
			System.out.println("checkpoint 6");
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setworkeventnamenr("-1");
			oopst.setstate("STOP");
			rlrst = new ruleResult("-1","Invalid Business Procedure Number");
		}
	}
	twe.setworkeventnamenr(wen.getworkeventnamenr());

	System.out.println("checkpoint 7");

	if (Long.parseLong(twe.getworkeventnamenr()) < 1) 
	{
		iopst.setstate("STOP");
		rlrst = new ruleResult("-1","Invalid Workevent Name");
		System.out.println("checkpoint 40");
	}
	System.out.print("generatenext workeventnr: " + iopst.getworkeventnr());
	System.out.print(", workeventnamenr " + iopst.getworkeventnamenr());
	System.out.print(", state: " + iopst.getstate());
  	System.out.print(", referencetouse: " + iopst.getreferencetouse());
       System.out.println(", businessprocedurenr: " + iopst.getbusinessprocedurenr());

	switch (iopst.getstate())
	{
		case "END": 
			System.out.println("checkpoint 12");
			if (Long.parseLong(iopst.getbusinessprocedurenr()) == Long.parseLong(iwe.getbusinessprocedurenr()))
			{
				System.out.println("checkpoint 12a");
				wen = new loadWorkeventName().loadWorkeventNameByNr(iwe.getworkeventnamenr(),iwe.getbusinessprocedurenr());
				twen = new loadWorkeventName().loadWorkeventNameByNr(wen.getnextworkeventnamenr(),iopst.getbusinessprocedurenr());
				long newevt = Long.parseLong(twen.getnextworkeventnamenr());
				if (newevt > 0) 
				{
					wen = new loadWorkeventName().loadWorkeventNameByNr(twen.getnextworkeventnamenr(),iopst.getbusinessprocedurenr());
					twe.setworkeventnamenr(wen.getnextworkeventnamenr());
					twe.setstartworkeventnr(iwe.getid());
					System.out.println("checkpoint 12b " + "twe.getworkeventnamenr() " + twe.getworkeventnamenr() + " twen.getnextworkeventnamenr() " + twen.getnextworkeventnamenr() + " wen.getnextworkeventnamenr() " + wen.getnextworkeventnamenr());
				}
				else 	if (Long.parseLong(iwe.getcorelworkevent()) > 0) 
					{
						System.out.println("checkpoint 12c");
						String iweid = iwe.getid();
						iwe = iwemgr.getWorkeventByID(iwe.getcorelworkevent());
						twe = initializeWorkevent(iwe);
						twe.setstartworkeventnr(iweid);
						wen = new loadWorkeventName().loadWorkeventNameByNr(iwe.getworkeventnamenr(),iwe.getbusinessprocedurenr());
						twen = new loadWorkeventName().loadWorkeventNameByNr(wen.getnextworkeventnamenr(), iwe.getbusinessprocedurenr());
						newevt = Long.parseLong(twen.getnextworkeventnamenr());
						if (newevt > 0) 
						{
							wen = new loadWorkeventName().loadWorkeventNameByNr(twen.getnextworkeventnamenr(),iwe.getbusinessprocedurenr());
							twe.setworkeventnamenr(wen.getnextworkeventnamenr());
							twe.setcorelworkevent(iwe.getcorelworkevent());
							System.out.println("checkpoint 12ca " + "twe.getworkeventnamenr() " + twe.getworkeventnamenr() + " twen.getnextworkeventnamenr() " + twen.getnextworkeventnamenr() + " wen.getnextworkeventnamenr() " + wen.getnextworkeventnamenr());
						}
					}
					else 
					{
						oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
						oopst.setworkeventnamenr("-1");
						oopst.setstate("STOP");	
						rlrst = new ruleResult("-1","End of processing");
						break;					
					} 
			}	
			else 
			{
				System.out.println("checkpoint 12d iopst.getbusinessprocedurenr() " + iopst.getbusinessprocedurenr() + " iwe.getbusinessprocedurenr() " + iwe.getbusinessprocedurenr() );
				oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
				oopst.setworkeventnamenr("-1");
				oopst.setstate("STOP");	
				rlrst = new ruleResult("-1","Invalid request. Use CALLPROC");
				break;			
			}	
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
			break;
		case "REST": 
			System.out.println("checkpoint 14");
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
			break;
		case "START": 
			System.out.println("checkpoint 15");
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
			break;
		case "CALLPROC": 
			System.out.println("checkpoint 16");	
			if (Long.parseLong(iopst.getbusinessprocedurenr()) != Long.parseLong(iwe.getbusinessprocedurenr())) 
			{
				System.out.println("checkpoint 16a iopst.getbusinessprocedurenr() " + iopst.getbusinessprocedurenr() + " iwe.getbusinessprocedurenr() " + iwe.getbusinessprocedurenr() );
				wen = new loadWorkeventName().loadWorkeventNameByNr(iopst.getworkeventnamenr(),iopst.getbusinessprocedurenr());
				loadOccasiontype locct = new loadOccasiontype();
				occasiontype occt = locct.getOccasiontypeByNR(wen.getoccasionnr());
				String occtype = occt.getoccasiontype();
				twe.settechnicalsourceoccasionnr(iwe.gettechnicaloccasionnr());
				twe.setoccasiontype(occtype);
				twe.setworkeventnamenr(wen.getworkeventnamenr());
				twe.setcorelworkevent(iwe.getid());
				if (iopst.getreferencetouse() != null && Long.parseLong(iopst.getreferencetouse()) > 0)
				{
					System.out.println("checkpoint 16aa");
					twe.setobjectreference(iopst.getreferencetouse());
				}
			}
			else
			{
				System.out.println("checkpoint 16b iopst.getbusinessprocedurenr() " + iopst.getbusinessprocedurenr() + " iwe.getbusinessprocedurenr() " + iwe.getbusinessprocedurenr() );
				oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
				oopst.setworkeventnamenr("1");
				oopst.setstate("STOP");
				rlrst = new ruleResult("-1","Invalid Reques, use END");
				break;
			}
			owemgr = generatenewWorkevent(twe,wen,iopst);
			oopst = generatenewopenoccasstart(owemgr.getcurrentWorkevent());
			oopst.setstate("START");
			oopst.setreferencetouse(iwe.getobjectreference());
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
		    	break;
		case "OUTPUTWAIT": 
			System.out.println("checkpoint 17");
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
		    	break;
		case "OUTPUTTERM":
			System.out.println("checkpoint 18");
			rlrst.setResult("1");
			rlrst.setparkingReason("NONE");
		    	break;
		default: 
			System.out.println("checkpoint 19");
			oopst.setworkeventnamenr("-1");
			rlrst = new ruleResult("-1","Terminate processing");
	}

	owopintf.setworkevent(owemgr.getcurrentWorkevent());
	owopintf.setopenoccasstart(oopst);
	owopintf.setruleResult(rlrst);
	return owopintf;
}
	
private manageWorkevent generatenewWorkevent(workevent iwe, workeventname wen, openoccasstart opstart) {
	System.out.println("Occasiontype " + wen.getoccasionnr());
	occasiontype occt = new loadOccasiontype().getOccasiontypeByNR(wen.getoccasionnr());
	System.out.println("Occasionnr " + occt.getid() + " " + occt.getoccasionnr() + " " + occt.getoccasiondescription() + " " + occt.getoccasiontype());
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


private workevent initializeWorkevent(workevent iwe)
{
	twe = new workevent(iwe.getid(),
			iwe.getworkeventnamenr(),
			iwe.getstartworkeventnr(),
			iwe.getobjectreference(),
			iwe.getoccasiontype(),
			iwe.getbusinessprocedurenr(),
			iwe.gettechnicaloccasionnr(),
			iwe.gettechnicalsourceoccasionnr(), 
			iwe.getworkitemnumber(),
			iwe.getprocessingstate(),
			iwe.getcorelworkevent(),
			iwe.getoccasioninstance());
	return twe;
}

}
