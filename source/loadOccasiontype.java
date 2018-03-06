//loadOccasiontype
// 
import java.util.*;

public class loadOccasiontype
{
private occasiontype oc = null;
private	ArrayList<occasiontype> occt = new ArrayList<occasiontype>();

public loadOccasiontype() 
{
 	 	occt.add(new occasiontype("1","0","DUMMYFALL","1"));
 	 	occt.add(new occasiontype("2","1","Partnerfall","2"));
 	 	occt.add(new occasiontype("3","2","Vertragsfall","3"));
 	 	occt.add(new occasiontype("4","3","CRMfall","4"));
 	 	occt.add(new occasiontype("5","4","Schadenfall","5"));
}


public occasiontype getOccasiontypeByNR(String oct)
{
	int i = Integer.parseInt(oct) - 1;

	return occt.get(i);
}

}
