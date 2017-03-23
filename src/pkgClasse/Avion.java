package pkgClasse;

// Avion est un Thread, car plusieurs Avions peuvent agir en m�me temps
public class Avion extends Thread 
{
	String name = "Avion";
	String etat = "Inactif";
	String ressourceAcquise = "Aucune";
	String nom = "Avion";
	// int action = 0; 
	Integer index;
	
	static Fuels fuels;
	static Gates gates;
	static Pistes pistes;
	static Techniques techniques;
	
	static Integer fuelsLock = 0;
	static Integer gatesLock = 0;
	static Integer pistesLock = 0;
	static Integer techniquesLock = 0;
	
	// Comptage du nombre d'avions ayant att�rit ou d�coll�
	public static Integer compteur = 0;
	
	// Le maximum d'avions qu'il est possible d'avoir. Fourni par l'utilisateur
	public static Integer maxAvions;
	
	// Ces 3 bool�ens permettent de bloquer en attendant d'�tre synchronis� sur les actions de "debut", "analyse" et "fin"
	public static Boolean waitForDebut = false;
	public static Boolean waitForAnalyse = false;
	public static Boolean waitForFin = false;
	
	// D�lais pouvant �tre chang�s, pour simuler un temps d'att�rissage, embarquement, etc. 
	Integer delay = 100;
	Integer delayLoop = 300;
		
	// Param�tres fournis par Aeroport
	public Avion(int i, Integer nFuels, Integer nGates, Integer nPistes, 
			Integer nTechniques, Integer maxA) 
	{						
		this.index = i;		
		this.nom = "Avion" + i;
		maxAvions = maxA;
		
		fuels = new Fuels(nFuels); 
		gates = new Gates(nGates);
		pistes = new Pistes(nPistes);
		techniques = new Techniques(nTechniques);			
	}
		
	// Action "arrive" telle que d�crite dans l'�nonc�
	public void arrive() 
	{		
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		etat = "Arrive";
		logStart(method);
		
		logEnd(method);
	}
	
	public void atterit() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);	
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (pistes) 
			{				
				Pistes pistes = this.getPistes();
				i = pistes.get(this.index);
				
				// Si on a trouv� une ressource
				if (i != -1)
				{
					etat = "Atterit sur piste " + i;
					ressourceAcquise = "Piste " + i; 
					pistesLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}			
		
		increaseCompteur();
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}				
		
		synchronized (pistes) 
		{
			pistesLock -= 1;
			Pistes pistes = this.getPistes();
			pistes.put(this.index, i);
			etat = "En attente de porte...";
			ressourceAcquise = "Aucune";
		}						
		
		logEnd(method);
	}

	public void debarque() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (gates) 
			{				
				Gates gates = this.getGates();
				i = gates.get(this.index);
<<<<<<< HEAD
				
				// Si on a trouv� une ressource
=======

>>>>>>> origin/master
				if (i != -1)
				{
					etat = "Debarque par la porte " + i;
					ressourceAcquise = "Poste " + i;
					gatesLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}
		
		synchronized (gates) 
		{
			gatesLock -= 1;
			gates.put(this.index, i);

			etat = "D�barquement complet...";
			ressourceAcquise = "Aucune";
		}
				
		logEnd(method);
	}	
	
	public void gare() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		etat = "Se gare";
		logStart(method);
		
		logEnd(method);
		etat = "Inactif";
	}	
	
	public void sort() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		etat = "Sort";
		logStart(method);
		
		logEnd(method);
	}
	
	public void controle() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (techniques) 
			{				
				Techniques techniques = this.getTechniques();
				i = techniques.get(this.index);
				
				// Si on a trouv� une ressource
				if (i != -1)
				{
					etat = "Passe au contr�le " + i;
					ressourceAcquise = "Technique " + i;
					techniquesLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}
		
		synchronized (techniques) 
		{
			etat = "En attente de porte... ";
			ressourceAcquise = "Aucune";
			techniquesLock -= 1;
			Techniques techniques = this.getTechniques();
			techniques.put(this.index, i);
		}	
		
		logEnd(method);

	}

	public void remplit() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (fuels) 
			{				
				Fuels fuels = this.getFuels();
				i = fuels.get(this.index);
				
				// Si on a trouv� une ressource
				if (i != -1)
				{
					etat = "Remplit avec fuels " + i;
					ressourceAcquise = "Fuel " + i;
					fuelsLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}		
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}
		
		synchronized (fuels) 
		{
			etat = "En attente de contr�le ... ";
			ressourceAcquise = "Aucune";
			fuelsLock -= 1;
			Fuels fuels = this.getFuels();
			fuels.put(this.index, i);
		}
		
		logEnd(method);
	}	
	
	public void embarque() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (gates) 
			{				
				Gates gates = this.getGates();
				i = gates.get(this.index);
				
				// Si on a trouv� une ressource
				if (i != -1)
				{
					etat = "Embarque par la porte " + i;
					ressourceAcquise = "Gate " + i;
					gatesLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}
		
		synchronized (gates) 
		{
			etat = "En attente de piste... ";
			ressourceAcquise = "Aucune";
			gatesLock -= 1;
			gates.put(this.index, i);
		}
		
		logEnd(method);
	}

	public void decolle() 
	{
		// Extraire le nom de l'action (la m�thode)
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		// Tant qu'aucune ressource n'est disponible...
		while(i == -1)
		{		
			synchronized (pistes) 
			{				
				Pistes pistes = this.getPistes();
				i = pistes.get(this.index);
				
				// Si on a trouv� une ressource
				if (i != -1)
				{
					etat = "Decolle sur la piste " + i;
					ressourceAcquise = "Piste " + i;
					pistesLock += 1;
				}
				else
				{
					try
					{
						logSleep();
						Thread.sleep(delayLoop);	
					}
					catch (Throwable e)
					{
						
					}
				}
			}							
		}
		
		increaseCompteur();
		
		try
		{
			Thread.sleep(delay);	
		}
		catch (Throwable e)
		{
			
		}
		
		synchronized (pistes) 
		{
			pistesLock -= 1;
			Pistes pistes = this.getPistes();
			pistes.put(this.index, i);
			ressourceAcquise = "Aucune"; 
			etat = "Inactif";
		}		
		
		logEnd(method);
	}
	
	public void atterir() 
	{
		arrive();
		atterit();
		debarque();
		gare();		
	}
	
	public void decoller() 
	{
		sort();
		controle();
		remplit();
		embarque();
		decolle();			
	}
	
	public void exec() 
	{
		atterir();		
		decoller();		
	}
	
	public void execDecollage() 
	{
		decoller();		
	}	
	
	public void execAtterrissage() 
	{
		atterir();		
	}	
	
	// Log une action faite par l'Avion d'indice "i"
	public void log(String action)
	{
		System.out.println(this.index + "." + this.name + " : " + action);			
	}
	
	// Log le d�but d'une action
	public void logStart(String action)
	{
		log("D�bute - " + action);
	}
	
	// Log la fin d'une action
	public void logEnd(String action)
	{
		log("Termine - " + action);
	}
	
	// Log un temps d'attente
	public void logSleep()
	{
		log("Sleep/wait");
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
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String newNom)
	{
		this.nom = newNom;
	}
	
	public String getEtat()
	{
		return etat;
	}
	
	// Augmenter le nombre d'Avions ayant d�coll� ou att�ri. 
	//   - La variable "compteur" est prot�g�e en lecture et �criture pendant l'incr�mentation
	//   - Losque le compteur d�passe maxAvions, on set les variables de synchronisation � 'true' 
	public static void increaseCompteur()
	{
		synchronized (compteur)
		{
			compteur++;
			
			if (compteur >= maxAvions)
			{
				waitForDebut = true;
				waitForAnalyse = true;
				waitForFin = true;
			}
		}
	}
	
	// Pour remettre le compteur � z�ro
	public static void resetCompteur()
	{
		synchronized (compteur)
		{
			compteur = 0;
		}
	}
	
	// Action de d�but
	public static void debut()
	{
		resetCompteur();
		
		synchronized (waitForDebut) {
			waitForDebut = false;			
		}
	}
		
	// Action d'analyse
	public static void analyse()
	{
		synchronized (waitForAnalyse) {
			waitForAnalyse = false;			
		}
	}
	
	// Action de fin
	public static void fin()
	{
		synchronized (waitForFin) {
			waitForDebut = false;
			waitForAnalyse = false;
			waitForFin = false;			
		}
	}
	
	// Lister des ressources acquises
	public String getRessourceAcquise()
	{
		return ressourceAcquise;
	}
		
	
	// Lance le d�collage et att�rissage de l'Avion (en s�quence) et fait un log en console 
	@Override
	public void run()
	{
		System.out.println("�tat des locks (avant " + this.index + ".Avion) : " 
				+ Avion.fuelsLock + " (F) " + Avion.gatesLock + " (G) " 
				+ Avion.pistesLock + " (P) " + Avion.techniquesLock + " (T)");
		
		this.exec();
		/*
		if (action == 0){
			this.exec();
		}
		else if (action == 1){
			this.execAtterrissage();
		}
		else{
			this.execDecollage();
		}
		*/
		
		System.out.println("�tat des locks (apr�s " + this.index + ".Avion) : " 
				+ Avion.fuelsLock + " (F) " + Avion.gatesLock + " (G) " 
				+ Avion.pistesLock + " (P) " + Avion.techniquesLock + " (T)");			
	}

	/*
	public void setAction(int action) {
		this.action = action;
	}
	*/	
}

