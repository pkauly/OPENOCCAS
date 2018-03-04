//loadWorkeventNamebyBNr
// 

public class loadWorkeventNamebyBNr
{
private workevent wen = null;

public loadWorkeventNamebyBNr loadOccasiontypebyNr(String oct) 
{
	int i = Integer.parseInt(oct);
	switch (i)
	{
		case 1:	
  			wen = new workeventname("1","0","DUMMYFALL","1");
			break;	
		case 2:	
  			wen = new workeventname("2","1","Partnerfall","2");
			break;
		case 3:	
  			wen= new workeventname("3","2","Vertragsfall","3");
			break;
		case 4:	
  			wen = new workeventname("4","3","CRMfall","4");
			break;
		case 5:	
  			wen = new workeventname("5","4","Schadenfall","5");
			break;

	}
	return wen;

}
}
