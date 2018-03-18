//maintest

// import Source.openoccas.*;

public class MainTest
{

private static manageBusinessnumber bus;
public static void main(String[] args)
	{
	bus = new manageBusinessnumber();
	businessnumber bunr = bus.getbusinessNumberByID("123456789014");
	System.out.println(bunr.getid() + " " + bunr.getbusinessnumber() + " " + bunr.getbusinessnumbertype() + " " + bunr.getdatecreated());
	bus.createbusinessNumber("5");
	return;
	}

}


