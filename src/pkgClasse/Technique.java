package pkgClasse;

public class Technique extends Resource
{
	public Technique(int i)
	{
		super("Technique", i);
	}
		
	public static void main(String[] args)
	{
		Technique item = new Technique(1);
		item.exec();
	}	
	
}
