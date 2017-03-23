package pkgControlleur;

import java.util.ArrayList;

// Classe "contrôleur" de gestion de l'Aeroport
public class CtrlAeroport{

	static Aeroport aeroport; 
	
	public static void initialiserAeroport(int nA, int nF, int nG, int nP, int nT, int maxA)
	{
		aeroport = new Aeroport(nA, nF, nG, nP, nT, maxA);
		// aeroport.avions.setNomAvion(0, "Led Zeppelin");
		// aeroport.avions.setNomAvion(1, "Gyrophare");
		// aeroport.avions.setNomAvion(2, "Airbus");
		// aeroport.avions.setNomAvion(3, "Jet");
		// aeroport.avions.setNomAvion(4, "Commodor");
		// aeroport.avions.setNomAvion(5, "Newton");
		

		System.out.println("================");
		System.out.println("     Set-up     ");
		System.out.println("================");
		
	}
	
	
	public ArrayList<String> getListeNoms(){
		return aeroport.avions.getNomsAvions();
	}
	
	public ArrayList<String> getListeEtats(){
		return aeroport.avions.getEtats();
	}
	
	public static void startAeroport(){
		
		System.out.println("================");
		System.out.println("Start simulation");
		System.out.println("================");
		
		for (int i = 0; i < aeroport.nAvions; i++)
		{						
			aeroport.avions.startAvion(i);
		}
		
	}
	
	public static void startAeroportAtIndex(int index, int action){

		System.out.println("================");
		System.out.println("  Start avion  ");
		System.out.println("================");
		
		aeroport.avions.startAvion(index);		
	}
	
	public static String getNomAtIndex(int index){
		return aeroport.avions.getNomsAvions().get(index);
		
	}

	public ArrayList<String> getListeAvionsRessources() {
		return aeroport.avions.getRessources();
	}


	public ArrayList<String> getAvionsInactifs() {
		return aeroport.avions.getAvionsInactifs();
	}


	public ArrayList<String> getRessources() {
		ArrayList<String> listeR = aeroport.getNomsRessources();
		
		return listeR;	
	}
	
}
