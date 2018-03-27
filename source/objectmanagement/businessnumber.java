//businessnumber
// 

package objectmanagement;

public class businessnumber
{

private String id;
private String businessnumber;
private String businessnumbertype;
private String datecreated;

public businessnumber() 
{
	setid("-1");	
	setbusinessnumber("-1");
	setbusinessnumbertype("-1");
	setdatecreated("-1");
}


public businessnumber(String id,
			String businessnumber, 
			String businessnumbertype, 
			String datecreated)
{
	setid(id);	
	setbusinessnumber(businessnumber);
	setbusinessnumbertype(businessnumbertype);
	setdatecreated(datecreated);
}

public void setid(String input)
{
	id = input;
}
public String getid()
{
	return id;
}
public void setbusinessnumber(String input)
{
	businessnumber = input;
}
public String getbusinessnumber()
{
	return businessnumber;
}
public void setbusinessnumbertype(String input)
{
	businessnumbertype = input;
}
public String getbusinessnumbertype()
{
	return businessnumbertype;
}
public void setdatecreated(String input)
{
	datecreated = input;
}
public String getdatecreated()
{
	return datecreated;
}

}
