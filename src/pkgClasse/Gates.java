package pkgClasse;

public class Gates extends Resources 
{
	public Gates(Integer amount) 
	{
		super("Gate", "Gates", "Gate", amount);
	}
		
	public static void main(String[] args) 
	{
		Gates resources = new Gates(4);	
		
		for (int i = 0; i < resources.N; i++)
		{
			resources.resources.get(i).exec();
		}		
	}	
}
