package pkgClasse;

public class Pistes extends Resources 
{
	public Pistes(Integer amount) {
		super("Piste", "Pistes", "Piste", amount);
	}
		
	public static void main(String[] args) 
	{
		Pistes resources = new Pistes(4);	
		
		for (int i = 0; i < resources.N; i++)
		{
			resources.resources.get(i).exec();
		}		
	}	
}
