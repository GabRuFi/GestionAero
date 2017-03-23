package pkgClasse;

import java.util.ArrayList;

public class Avions 
{
	String name = "Avions";
	Integer N;	
		
	private ArrayList<Avion> avions = new ArrayList<Avion>();
			
	public Avions(Integer amount, Integer nFuels, Integer nGates, 
			Integer nPistes, Integer nTechniques, Integer maxA)
	{
		this.N = amount;							
		
		for (int i = 0; i < N; i++)
		{									
			Avion avion = new Avion(i, nFuels, nGates, nPistes, nTechniques, maxA);										
			
			avions.add(avion);									
		}									
	}	
	
	public Fuels getFuels()
	{
		return this.avions.get(0).getFuels();
	}
	
	public Gates getGates()
	{
		return this.avions.get(0).getGates();
	}
	
	public Pistes getPistes()
	{
		return this.avions.get(0).getPistes();
	}
	
	public Techniques getTechniques()
	{
		return this.avions.get(0).getTechniques();
	}
		
	public ArrayList<Avion> getAvions()
	{
		return this.avions;
	}
	
	public void setNomAvion(int index, String newName)
	{	
		this.avions.get(index).setName(newName);
	}
	
	public static void main(String[] args) 
	{
		Avions avions = new Avions(25, 2, 2, 2, 2, 10);	
		
		for (int i = 0; i < avions.N; i++)
		{
			avions.avions.get(i).start();
		}	
	}
	
	public void startAvion(int index)
	{	
		this.avions.get(index).start();
	}
	
}
