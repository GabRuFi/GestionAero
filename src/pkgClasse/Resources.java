package pkgClasse;

import java.util.ArrayList;

// Mise en parall�le de N ressources
public class Resources {
	
	// Nom de la classe
	private String name;
	
	// Nom de la ressource contenue (au singulier)
	private String nameSingle;
	
	// Nombre de ressources
	private Integer N;
	
	// Bitmap/tableau servant � d�terminer quelles ressources sont disponibles ou non. 
	//   "true" si disponible, "false" si indisponible
	private ArrayList<Boolean> availableBitmap;
	
	// La liste des ressources
	private ArrayList<Resource> resources = new ArrayList<Resource>(); 
	
	public Resources(String type, String name, String nameSingle, Integer amount)
	{
		this.N = amount;
		availableBitmap = new ArrayList<Boolean>();
		this.name = name;
		this.nameSingle = nameSingle;
		
		// G�n�rer les ressources demand�es. Similaire � une Factory
		for (int i = 0; i < N; i++)
		{
			if (type == "Fuel")
			{
				resources.add(new Fuel(i));
			}
			else if (type == "Gate")
			{
				resources.add(new Gate(i));
			}
			else if (type == "Piste")
			{
				resources.add(new Piste(i));
			}
			else if (type == "Technique")
			{
				resources.add(new Technique(i));
			}		
			
			// Indiquer que la ressource est disponible
			availableBitmap.add(true);
		}									
	}
	
	// Retourner le nombre de ressources
	public int getN(){
		return this.N;
	}
	
		public ArrayList<Resource> getResources(){
		return this.resources;
	}
	
	// Prot�g� par mutex dans Avion
	public Integer get(Integer avionID)
	{
		for (int i = 0; i < N; i++)
		{
			// Si la ressource est disponible, on la choisit
			if (availableBitmap.get(i))
			{
				resources.get(i).get(avionID);
				availableBitmap.set(i, false);			
				return i;
			}				
		}
		
		// Si rien n'est disponible, on retourne -1
		return -1;
	}
	
	// Prot�g� par mutex dans Avion
	public void put(Integer avionID, Integer i)
	{			
		// Si la ressource est d�j� remise, alors la protection n'a pas fonctionn� 
		// et on log une erreur (similaire � v�rifier la propri�t� d'int�grit�)
		if (availableBitmap.get(i))
		{
			System.out.println("The following resource is already available! -> " + i + "." 
					+ this.nameSingle + " (" + avionID + ".Avion)");
		}
		// Autrement, on remplace simplement la ressource
		else 
		{
			resources.get(i).put(avionID);
			availableBitmap.set(i, true);
		}		
	}
}
