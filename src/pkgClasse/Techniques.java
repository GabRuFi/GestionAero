package pkgClasse;

public class Techniques extends Resources
{	
	public Techniques(Integer amount)
	{
		super("Technique", "Techniques", "Technique", amount);
	}
		
	public static void main(String[] args)
	{
		Techniques resources = new Techniques(4);	
		
		for (int i = 0; i < resources.N; i++)
		{
			resources.resources.get(i).exec();
		}		
	}	
}
