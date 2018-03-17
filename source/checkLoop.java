//checkLoop


public class checkLoop
{

private workevent iwe = null;
private openoccasstart iopst = null;
private ruleResult rlrst = null;

public checkLoop()
{
}

public wopenoccasinterface checkLoopdo(wopenoccasinterface iwopintf) 
{
	manageWorkevent iwemgr = new manageWorkevent();
	iopst = iwopintf.getopenoccasstart();

	if (Long.parseLong(iopst.getworkeventnr()) > 0)
	{
		System.out.println("checkloop checkpoint 1");
		iwe = iwopintf.setworkevent(iwemgr.getWorkeventByID(iopst.getworkeventnr()));
	}
	else
	{
		System.out.println("checkloop checkpoint 2");
		rlrst = iwopintf.setruleResult(new ruleResult("0","NONE"));
		return iwopintf;
	}

	if (iopst.getstate() == "START" && iwe.getprocessingstate() == "1")
	{
		System.out.println("checkloop checkpoint 3");
		rlrst = iwopintf.setruleResult(new ruleResult("-1","Checkloop loop detected"));
		return iwopintf;		
	}

	if (Long.parseLong(iopst.getworkeventnamenr()) > 0)
	{
		System.out.println("checkloop checkpoint 4");
		iwe = iwopintf.setworkevent(iwemgr.updateWorkeventRouted(iwe.getid()));
	}
		System.out.println("checkloop checkpoint 3");
		rlrst = iwopintf.setruleResult(new ruleResult("1","NONE"));
		iwopintf.setruleResult(rlrst);
		iwopintf.setworkevent(iwe);
		return iwopintf;	
}

}
