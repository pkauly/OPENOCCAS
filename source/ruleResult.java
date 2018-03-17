//ruleResult
// 

public class ruleResult
{

private String result;
private String parkingReason;

public ruleResult() 
{
	setResult("-1");
	setparkingReason("-1");
}


public ruleResult(String result,
			String parkingReason) 

{
	setResult(result);
	setparkingReason(parkingReason);
}

public void setResult(String input)
{
	result = input;
}

public String getResult()
{
	return result;
}

public void setparkingReason(String input)
{
	parkingReason = input;
}

public String getparkingReason()
{
	return parkingReason;
}
}
