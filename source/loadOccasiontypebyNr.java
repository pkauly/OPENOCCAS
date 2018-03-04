//loadOccasiontypebyNr
// 

public class loadOccasiontypebyNr
{
private occasiontype oc = null;

public loadOccasiontypebyNr() 
{

}

public occasiontype getoccasiontype(String oct)
{
	int i = Integer.parseInt(oct);
	switch (i)
	{
		case 1:	
  			oc = new occasiontype("1","0","DUMMYFALL","1");
			break;	
		case 2:	
  			oc = new occasiontype("2","1","Partnerfall","2");
			break;
		case 3:	
  			oc = new occasiontype("3","2","Vertragsfall","3");
			break;
		case 4:	
  			oc = new occasiontype("4","3","CRMfall","4");
			break;
		case 5:	
  			oc = new occasiontype("5","4","Schadenfall","5");
			break;

	}
	return oc;
}

}
