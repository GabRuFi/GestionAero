package pkgUInterface;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import pkgControlleur.CtrlAeroport;

public class FrameAero extends JFrame implements Runnable {
	
	private volatile CtrlAeroport aeroport; 
	private volatile ArrayList<String> listeAvions;
	private volatile ArrayList<String> avionsInactifs;
	private volatile ArrayList<String> listeEtatsAvions;
	private volatile ArrayList<String> listeRessources; 
	private volatile ArrayList<String> listeEtatsRessources;
	private DefaultTableModel tableModel = new DefaultTableModel();
	
	@Override
	public void run(){
		aeroport = new CtrlAeroport();
		initAeroport();
	}

	public void updateGUI(){
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(this);
		}
	}

	public synchronized void initAeroport(){
		aeroport.initialiserAeroport(6, 2, 2, 2, 2, 30);
		// aeroport.startAeroport();
	}
	
	public synchronized void lancerSimulation(){
		aeroport.startAeroport();
	}

	public synchronized void initAeroport(int nAvions, int nFuels, int nGates, int nPistes, int nTechniques, int maxA){
		aeroport = new CtrlAeroport();
		aeroport.initialiserAeroport(nAvions, nFuels, nGates, nPistes, nTechniques, maxA);
		// aeroport.startAeroport();
	}
	
	public synchronized ArrayList<String> getListeNomsAvions(){
		setListeAvions(this.aeroport.getListeNoms());
		return this.listeAvions; 
	}

	public synchronized ArrayList<String> getAvionsInactifs(){
		setAvionsInactifs(this.aeroport.getAvionsInactifs());
		return this.avionsInactifs; 
	}

	public synchronized ArrayList<String> getListeEtatsAvions(){
		setListeEtatsAvions(this.aeroport.getListeEtats());
		return this.listeEtatsAvions; 
	}

	public synchronized ArrayList<String> getListeAvionsRessources(){
		setListeEtatsAvions(this.aeroport.getListeAvionsRessources());
		return this.listeEtatsAvions; 
	}
	
	public synchronized void setListeAvions(ArrayList<String> navions){
		this.listeAvions = navions; 
	}
	
	public synchronized void setAvionsInactifs(ArrayList<String> navions){
		this.avionsInactifs = navions; 
	}
	
	public synchronized void setListeEtatsAvions(ArrayList<String> nEtatsAvions){
		this.listeEtatsAvions = nEtatsAvions; 
	}
	
	
	public synchronized void setListeRessources(ArrayList<String> nressources){
		this.listeRessources = nressources; 
	}
	
	public synchronized void setListeEtatsRessources(ArrayList<String> nEtatsRessources){
		this.listeEtatsRessources = nEtatsRessources; 
	}
	
	public synchronized void startAvion(String nom, int action){
		boolean notFound = true; 
		int index = 0; 
		while (notFound && index < listeAvions.size()){
			if (listeAvions.get(index).equals(nom)){
				notFound = false; 
			}
		}
		if (notFound){
			System.out.println("Avion non trouvé");
		}
		else{
			// aeroport.startAeroportAtIndex(index, action);
		}
	}

	public synchronized ArrayList<String> getRessources(){
		setListeRessources(this.aeroport.getRessources());
		return this.listeEtatsAvions; 
	}
	
	
	
	
}
