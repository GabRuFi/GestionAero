package pkgClasse;

public class Fuels extends Resources 
{			
	public Fuels(Integer amount) {
		super("Fuel", "Fuels", "Fuel", amount);
	}
		
	public static void main(String[] args) 
	{
		Fuels resources = new Fuels(4);	
		
		for (int i = 0; i < resources.N; i++)
		{
			resources.resources.get(i).exec();
		}		
	}	
}
