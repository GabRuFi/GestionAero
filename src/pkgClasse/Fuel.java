package pkgClasse;

public class Fuel extends Resource  
{
	public Fuel(int i) 
	{
		super("Fuel", i);
	}
		
	public static void main(String[] args) 
	{
		Fuel item = new Fuel(1);
		item.exec();
	}	
	
}
