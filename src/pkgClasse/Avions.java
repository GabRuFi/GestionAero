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
	
	public ArrayList<String> getEtats()
	{
		ArrayList<String> listeEtats = new ArrayList<String>(); 
		synchronized (avions) 
		{
			ArrayList<Avion> tblAvions = avions;
			for (int index = 0; index < tblAvions.size(); index++){
				listeEtats.add(tblAvions.get(index).getEtat());
			}
		}
		return listeEtats;
	}
	
	public void setNomAvion(int index, String newName)
	{	
		this.avions.get(index).setNom(newName);
	}
	
	/*
	public static void main(String[] args) 
	{
		Avions avions = new Avions(25, 2, 2, 2, 2);	
		
		for (int i = 0; i < avions.N; i++)
		{
			avions.avions.get(i).start();
		}	
	}
	*/
	
	public ArrayList<String> getNomsAvions(){
		ArrayList<String> tblNoms = new ArrayList<String>();
		synchronized (avions) 
		{
			ArrayList<Avion> tblAvions = avions;
			for (int index = 0; index < tblAvions.size(); index++){
				tblNoms.add(tblAvions.get(index).getNom());
			}
		}
		return tblNoms;
	}
	
	public void startAvion(int index)
	{	
		/*
		synchronized (avions) 
		{
			this.avions.get(index).setAction(action);
		}
		*/
		this.avions.get(index).start();
	}

	public ArrayList<String> getRessources() {
		ArrayList<String> tblRessources = new ArrayList<String>();
		synchronized (avions) 
		{
			ArrayList<Avion> tblAvions = avions;
			for (int index = 0; index < tblAvions.size(); index++){
				tblRessources.add(tblAvions.get(index).getRessourceAcquise());
			}
		}
		return tblRessources;
	}

	public ArrayList<String> getAvionsInactifs() {
		ArrayList<String> tblAvionsInactifs = new ArrayList<String>();
		synchronized (avions) 
		{
			ArrayList<Avion> tblAvions = avions;
			for (int index = 0; index < tblAvions.size(); index++){
				if (tblAvions.get(index).getEtat().equals("Inactif")){
					tblAvionsInactifs.add(tblAvions.get(index).getNom());
				}
			}
		}
		return tblAvionsInactifs;
	}
}
