package pkgClasse;

public class Gate extends Resource 
{
	// On crée la Gate d'index "i"
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
