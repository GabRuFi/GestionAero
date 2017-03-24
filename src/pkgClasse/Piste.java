package pkgClasse;

// Voir la classe Resource pour l'implantation. Ce n'est qu'un cas particulier.
public class Piste extends Resource 
{
	// On crée la Piste d'index "i"
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
