package pkgClasse;

import java.util.ArrayList;
import java.util.Collection;


public class Fuels extends Resources 
{			
	public Fuels(Integer amount) {
		super("Fuel", "Fuels", "Fuel", amount);
	}
		
	public static void main(String[] args) 
	{
		Fuels resources = new Fuels(4);	
		
		for (int i = 0; i < resources.getN(); i++)
		{
			resources.getResources().get(i).exec();
		}		
	}
	
	public ArrayList<String> obtenirNomsRessources(){
		ArrayList<String> listeR = new ArrayList<String>();
		for (int i = 0; i < getN(); i ++){
			listeR.add("Fuel " + i);
		}
		return listeR;
	}
}