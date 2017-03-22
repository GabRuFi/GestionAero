package pkgClasse;

import java.util.ArrayList;

public class Resources {
	
	String name;
	String nameSingle;
	Integer N;
	
	ArrayList<Boolean> availableBitmap;
	
	ArrayList<Resource> resources = new ArrayList<Resource>(); 
	
	public Resources(String type, String name, String nameSingle, Integer amount)
	{
		this.N = amount;
		availableBitmap = new ArrayList<Boolean>();
		this.name = name;
		this.nameSingle = nameSingle;
		
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
			
			availableBitmap.add(true);
		}									
	}
	
	// Protégé par mutex dans Avion
	public Integer get(Integer avionID)
	{
		for (int i = 0; i < N; i++)
		{
			if (availableBitmap.get(i))
			{
				resources.get(i).get(avionID);
				availableBitmap.set(i, false);			
				return i;
			}				
		}
		
		return -1;
	}
	
	// Protégé par mutex dans Avion
	public void put(Integer avionID, Integer i)
	{			
		if (availableBitmap.get(i))
		{
			System.out.println("The following resource is already available! -> " + i + "." 
					+ this.nameSingle + " (" + avionID + ".Avion)");
		}
		else 
		{
			resources.get(i).put(avionID);
			availableBitmap.set(i, true);
		}		
	}
}
