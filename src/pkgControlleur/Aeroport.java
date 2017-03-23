package pkgControlleur;

import java.util.ArrayList;

import pkgClasse.Avions;
import pkgClasse.Fuels;
import pkgClasse.Gates;
import pkgClasse.Pistes;
import pkgClasse.Techniques;
import pkgClasse.Avion;

// Classe de gestion de l'Aeroport
public class Aeroport {
			
	String name = "Aeroport";
	
	// Nombre de chaque ressource
	public Integer nAvions;
	public Integer nFuels;
	public Integer nGates;
	public Integer nPistes;
	public Integer nTechniques;
	
	// Les ressources en soi
	public Fuels fuels;
	public Gates gates;
	public Pistes pistes;
	public Techniques techniques;	
	
	// Les Avions
	public Avions avions;
	
	// Le nombre maximum d'avions ayant att�ri/d�coll� avant de lancer l'analyse
	public Integer maxAvions;
	
	// Contruction d'un Aeroport � l'aide des valeurs fournies par l'utilisateur
	public Aeroport(Integer nAvions, Integer nFuels, 
			Integer nGates, Integer nPistes, Integer nTechniques, Integer maxA) 
	{										
		this.nAvions = nAvions;
		this.nFuels = nFuels;
		this.nGates = nGates;
		this.nPistes = nPistes;
		this.nTechniques = nTechniques;
		this.maxAvions = maxA;
				
		// On met le nAvions Avions en parall�le
		avions = new Avions(nAvions, nFuels, nGates, nPistes, nTechniques, maxAvions);					
	}	
	
	// Proc�dure d'analyse � lancer quand on atteint le nombre maximum d'att�rissages/d�collages
	public void lancerAnalyse()
	{			
		// On prot�ge les 3 variables de synchronisation
		synchronized(Avion.waitForDebut)
		{
			synchronized(Avion.waitForAnalyse)
			{
				synchronized(Avion.waitForFin)
				{
					// Si pas en proc�dure d'analyse, on soul�ve une erreur dans le log (similaire � v�rifier une propri�t�)
					if (Avion.waitForDebut == false)
					{
						System.out.println("Vous devez attendre d'avoir le bon nombre d'avions...");
						return;
					}
					else
					{						
						// On ex�cute les 3 actions demand�es
						Avion.debut();								
						Avion.analyse();
						Avion.fin();
					}
				}
			}						
		}			
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
	
	public Integer getCompteur()
	{
		return Avion.compteur;
	}
		
	public ArrayList<String> getNomsAvions(){
		return this.avions.getNomsAvions();
	}

	
	public ArrayList<String> getEtatsAvions(){
		return this.avions.getEtats();
	}

	public ArrayList<String> getNomsRessources() {
		ArrayList<String> listeR = new ArrayList<String>(); 
	
		return listeR;
	}	
}
