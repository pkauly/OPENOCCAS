//loadWorkeventNameByNr
// 

public class loadWorkeventNameByNr
{
private workeventname wen = null;

public workeventname loadWorkeventNameByNr(String wenr,String busnr) 
{
	int i = Integer.parseInt(wenr);
	switch (i)
	{
		case 1:	
  			wen = new workeventname("1","1","1","Schadeneriengis aufnehmen","S","2","5");
			break;	
		case 2:	
  			wen = new workeventname("2","1","1","Schadeneriengis aufnehmen","E","3","5");
			break;
		case 3:	
  			wen = new workeventname("3","1","2","Schadendaten aufnehmen","S","4","5");
			break;
		case 4:	
  			wen = new workeventname("4","1","2","Schadendaten aufnehmen","E","0","5");
			break;
		case 5:	
  			wen = new workeventname("5","2","3","Schadenrechnung bearbeiten","S","6","5");
			break;
		case 6:	
  			wen = new workeventname("6","2","3","Schadenrechnung bearbeiten","E","7","5");
			break;
		case 7:	
  			wen = new workeventname("7","2","4","Schadendokument bearbeiten","S","8","5");
			break;
		case 8:	
  			wen = new workeventname("8","2","4","Schadendokument bearbeiten","E","0","5");
			break;

	}
	return wen;

}
}
