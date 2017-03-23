package pkgClasse;

// Voir la classe Resource pour l'implantation. Ce n'est qu'un cas particulier.
public class Technique extends Resource
{
	// On crée la Technique d'index "i"
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
