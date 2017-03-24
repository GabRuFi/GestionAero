package pkgClasse;

// Voir la classe Resource pour l'implantation. Ce n'est qu'un cas particulier.
public class Fuel extends Resource  
{	
	// On crée le Fuel d'index "i"
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
