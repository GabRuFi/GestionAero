package pkgControlleur;

import pkgClasse.Avions;
import pkgClasse.Fuels;
import pkgClasse.Gates;
import pkgClasse.Pistes;
import pkgClasse.Techniques;

public class Aeroport {
			
	String name = "Aeroport";
	
	public Integer nAvions;
	public Integer nFuels;
	public Integer nGates;
	public Integer nPistes;
	public Integer nTechniques;
	
	public Fuels fuels;
	public Gates gates;
	public Pistes pistes;
	public Techniques techniques;
	
	public Avions avions;
	
	public Aeroport(Integer nAvions, Integer nFuels, 
			Integer nGates, Integer nPistes, Integer nTechniques) 
	{										
		this.nAvions = nAvions;
		this.nFuels = nFuels;
		this.nGates = nGates;
		this.nPistes = nPistes;
		this.nTechniques = nTechniques;
				
		avions = new Avions(nAvions, nFuels, nGates, nPistes, nTechniques);					
	}	
	
	public Fuels getFuels()
	{
		return fuels;
	}
	
	public Gates getGates()
	{
		return gates;
	}
	
	public Pistes getPistes()
	{
		return pistes;
	}
	
	public Techniques getTechniques()
	{
		return techniques;
	}
	
	public static void main(String[] args) {
		
		Integer nA = 6;
		Integer nF = 2;
		Integer nG = 2;
		Integer nP = 2;
		Integer nT = 2;
		
		Aeroport aeroport = new Aeroport(nA, nF, nG, nP, nT);
		aeroport.avions.setNomAvion(0, "Led Zeppelin");
		aeroport.avions.setNomAvion(1, "Gyrophare");
		aeroport.avions.setNomAvion(2, "Airbus");
		aeroport.avions.setNomAvion(3, "Jet");
		aeroport.avions.setNomAvion(4, "Commodor");
		aeroport.avions.setNomAvion(5, "Newton");
		
		System.out.println("================");
		System.out.println("     Set-up     ");
		System.out.println("================");
		
		/*aeroport.avions.avions.get(4).getPistes().get(4);
		aeroport.avions.avions.get(2).getFuels().get(2);*/
		
		System.out.println("================");
		System.out.println("Start simulation");
		System.out.println("================");
		
		for (int i = 0; i < aeroport.nAvions; i++)
		{						
			aeroport.avions.startAvion(i);
		}		
	}			
}
