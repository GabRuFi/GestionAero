package pkgClasse;

import java.util.ArrayList;

// Voir la classe Resources pour l'implantation. Ce n'est qu'un cas particulier.
public class Pistes extends Resources 
{
	public Pistes(Integer amount) {
		super("Piste", "Pistes", "Piste", amount);
	}
		
	public static void main(String[] args) 
	{
		Pistes resources = new Pistes(4);	
		
		for (int i = 0; i < resources.getN(); i++)
		{
			resources.getResources().get(i).exec();
		}		
	}

	public ArrayList<String> obtenirNomsRessources(){
		ArrayList<String> listeR = new ArrayList<String>();
		for (int i = 0; i < getN(); i ++){
			listeR.add("Piste " + i);
		}
		return listeR;
	}
}
