package pkgClasse;

import java.util.ArrayList;

public class Gates extends Resources 
{
	public Gates(Integer amount) 
	{
		super("Gate", "Gates", "Gate", amount);
	}
		
	public static void main(String[] args) 
	{
		Gates resources = new Gates(4);	
		
		for (int i = 0; i < resources.getN(); i++)
		{
			resources.getResources().get(i).exec();
		}		
	}

	public ArrayList<String> obtenirNomsRessources(){
		ArrayList<String> listeR = new ArrayList<String>();
		for (int i = 0; i < getN(); i ++){
			listeR.add("Gate " + i);
		}
		return listeR;
	}
}