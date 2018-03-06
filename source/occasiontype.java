//occasiontype
// 
// <occasiontype>
// 	<id>“id“</id>
//  	<occasionnr>“number“</occasionnr>
// 	<occasiondescription>“string“</occasiondescription>
//    	<occastiontype>“number“</occastiontype>
// </occasiontype> 
public class occasiontype
{

private String id = "-1";
private String occasionnr;
private String occasiondescription;
private String occasiontype;

public occasiontype (String id, String occnr, String desc, String type) 
{
	
	setid(id);
	setoccasionnr(occnr);
	setoccasiondescription(desc);
	setoccasiontype(type);
}

public void setid(String input)
{
	id = input;
}
public String getid()
{
	return id;
}
public void setoccasionnr(String input)
{
	occasionnr = input;
}
public String getoccasionnr()
{
	return occasionnr;
}
public void setoccasiondescription(String input)
{
	occasiondescription = input;
}
public String getoccasiondescription()
{
	return occasiondescription;
}
public void setoccasiontype(String input)
{
	occasiontype = input;
}
public String getoccasiontype()
{
	return occasiontype;
}

}
