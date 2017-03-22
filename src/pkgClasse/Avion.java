package pkgClasse;

public class Avion extends Thread 
{
	String name = "Avion";
	String nom = "Avion";
	Integer index;
	
	static Fuels fuels;
	static Gates gates;
	static Pistes pistes;
	static Techniques techniques;
	
	static Integer fuelsLock = 0;
	static Integer gatesLock = 0;
	static Integer pistesLock = 0;
	static Integer techniquesLock = 0;
	
	Integer delay = 100;
	Integer delayLoop = 300;
		
	public Avion(int i, Integer nFuels, Integer nGates, Integer nPistes, Integer nTechniques) 
	{						
		this.index = i;			
		
		fuels = new Fuels(nFuels); 
		gates = new Gates(nGates);
		pistes = new Pistes(nPistes);
		techniques = new Techniques(nTechniques);			
	}
		
	public void arrive() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		logEnd(method);
	}
	
	public void atterit() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);	
		
		Integer i = -1;
						
		while(i == -1)
		{		
			synchronized (pistes) 
			{				
				Pistes pistes = this.getPistes();
				i = pistes.get(this.index);
				
				if (i != -1)
				{
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
		}						
		
		logEnd(method);
	}

	public void debarque() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		while(i == -1)
		{		
			synchronized (gates) 
			{				
				Gates gates = this.getGates();
				i = gates.get(this.index);
				
				if (i != -1)
				{
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
		}
				
		logEnd(method);
	}	
	
	public void gare() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		logEnd(method);
	}	
	
	public void sort() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		logEnd(method);
	}
	
	public void controle() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		while(i == -1)
		{		
			synchronized (techniques) 
			{				
				Techniques techniques = this.getTechniques();
				i = techniques.get(this.index);
				
				if (i != -1)
				{
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
			techniquesLock -= 1;
			Techniques techniques = this.getTechniques();
			techniques.put(this.index, i);
		}	
		
		logEnd(method);
	}

	public void remplit() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		while(i == -1)
		{		
			synchronized (fuels) 
			{				
				Fuels fuels = this.getFuels();
				i = fuels.get(this.index);
				
				if (i != -1)
				{
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
			fuelsLock -= 1;
			Fuels fuels = this.getFuels();
			fuels.put(this.index, i);
		}
		
		logEnd(method);
	}	
	
	public void embarque() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		while(i == -1)
		{		
			synchronized (gates) 
			{				
				Gates gates = this.getGates();
				i = gates.get(this.index);
				
				if (i != -1)
				{
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
		}
		
		logEnd(method);
	}

	public void decolle() 
	{
		String method = new Object(){}.getClass().getEnclosingMethod().getName();		
		logStart(method);
		
		Integer i = -1;
		
		while(i == -1)
		{		
			synchronized (pistes) 
			{				
				Pistes pistes = this.getPistes();
				i = pistes.get(this.index);
				
				if (i != -1)
				{
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
	
	public void log(String action)
	{
		System.out.println(this.index + "." + this.name + " : " + action);			
	}
	
	public void logStart(String action)
	{
		log("D�bute - " + action);
	}
	
	public void logEnd(String action)
	{
		log("Termine - " + action);
	}
	
	public void logSleep()
	{
		log("Sleep/wait");
	}
	
	public static void main(String[] args) {
		Avion avion = new Avion(0, 2 ,2, 2, 2);			
		avion.exec();
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
	
	@Override
	public void run()
	{
		System.out.println("�tat des locks (avant " + this.index + ".Avion) : " 
				+ Avion.fuelsLock + " (F) " + Avion.gatesLock + " (G) " 
				+ Avion.pistesLock + " (P) " + Avion.techniquesLock + " (T)");
		
		this.exec();
		
		System.out.println("�tat des locks (apr�s " + this.index + ".Avion) : " 
				+ Avion.fuelsLock + " (F) " + Avion.gatesLock + " (G) " 
				+ Avion.pistesLock + " (P) " + Avion.techniquesLock + " (T)");			
	}	
}
