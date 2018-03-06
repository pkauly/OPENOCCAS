//MainmanageWorkeventTest


public class MainmanageWorkeventTest
{
public static void main(String[] args)
	{

	manageWorkevent mwe = new manageWorkevent();
	System.out.println(mwe.getWorkeventByID("1").getid());
	System.out.println(mwe.getWorkeventByID("2").getid());
	System.out.println(mwe.getWorkeventByID("4").getid());
	System.out.println(mwe.getWorkeventByID("3").getid());
	
	return;
	}

}


