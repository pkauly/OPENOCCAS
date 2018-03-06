//loadWorkeventName
// 
import java.util.*;

public class loadWorkeventName
{
private workeventname wen = null;
private	ArrayList<workeventname> wena = new ArrayList<workeventname>();

public loadWorkeventName() 
{
  	wena.add(new workeventname("1","1","1","Schadeneriengis aufnehmen","S","2","5"));
	wena.add(new workeventname("2","1","1","Schadeneriengis aufnehmen","E","3","5"));
	wena.add(new workeventname("3","1","2","Schadendaten aufnehmen","S","4","5"));
	wena.add(new workeventname("4","1","2","Schadendaten aufnehmen","E","0","5"));
	wena.add(new workeventname("5","2","3","Schadenrechnung bearbeiten","S","6","5"));
	wena.add(new workeventname("6","2","3","Schadenrechnung bearbeiten","E","7","5"));
	wena.add(new workeventname("7","2","4","Schadendokument bearbeiten","S","8","5"));
	wena.add(new workeventname("8","2","4","Schadendokument bearbeiten","E","0","5"));
}

public workeventname loadWorkeventNameByNr(String wenr,String busnr)
{
	int i = Integer.parseInt(wenr) - 1;
	wen = wena.get(i);
	return wen;

}

public workeventname loadWorkeventNameByBNr(String busnr)
{
		return new workeventname("1","1","1","Schadeneriengis aufnehmen","S","2","5");
}

public String getnextWorkeventNameNR(String wenr)
{
	int i = Integer.parseInt(wenr) - 1;
	String nwenr = wena.get(i).getnextworkeventnamenr();
	return nwenr;	
}


}
