package pkgClasse;

// Classe générique dont héritent toutes les autres ressources (Fuel, Gate, Piste, Technique)
public class Resource 
{
	// Le nom/type de la ressource (ex. Fuel)
	String name;
	
	// Le numéro de la ressource	
	Integer index;
	
	// Réserver la ressource	
	public void get(Integer avionID)
	{
		System.out.println(index + "." + name + " par " + avionID + ".Avion: get()");		
		return;
	}
	
	// Remettre la ressource
	public void put(Integer avionID)
	{			
		System.out.println(index + "." + name + " par " + avionID + ".Avion: put()");
		return;
	}
	
	// Acquérir et saisir une ressource
	public void exec()
	{
		get(0);
		put(0);		
	}
	
	// Contructeur pour une ressource
	public Resource(String name, int i)
	{
		this.name = name;
		this.index = i;		
	}
}
