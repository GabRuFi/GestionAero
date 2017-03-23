package pkgClasse;

public class Piste extends Resource 
{
	public Piste(int i) 
	{
		super("Piste", i);
	}
		
	public static void main(String[] args) 
	{
		Piste item = new Piste(1);
		item.exec();
	}	
	
}
