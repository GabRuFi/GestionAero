package pkgClasse;

import java.util.ArrayList;

public class Techniques extends Resources
{	
	public Techniques(Integer amount)
	{
		super("Technique", "Techniques", "Technique", amount);
	}
		
	public static void main(String[] args)
	{
		Techniques resources = new Techniques(4);	
		
		for (int i = 0; i < resources.getN(); i++)
		{
			resources.getResources().get(i).exec();
		}		
	}
	
	public ArrayList<String> obtenirNomsRessources(){
		ArrayList<String> listeR = new ArrayList<String>();
		for (int i = 0; i < getN(); i ++){
			listeR.add("Technique " + i);
		}
		return listeR;
	}
}
