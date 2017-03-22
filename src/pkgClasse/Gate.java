package pkgClasse;

public class Gate extends Resource 
{
	public Gate(int i) 
	{
		super("Gate", i);
	}
		
	public static void main(String[] args) 
	{
		Gate item = new Gate(1);
		item.exec();
	}	
	
}
