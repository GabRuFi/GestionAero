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
		aeroport.initialiserAeroport(6, 2, 2, 2, 2, 8);
		aeroport.startAeroport();
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
	
	public synchronized void startAvion(String nom){
		boolean notFound = true; 
		int index = 0; 
		while (notFound && index < listeAvions.size()){
			if (listeAvions.get(index).equals(nom)){
				notFound = false; 
			}
		}
		if (notFound){
			// throw ("Avion non trouvé");
		}
		else{
			// aeroport.startAeroportAtIndex(index);
		}
	}

	public synchronized ArrayList<String> getRessources(){
		setListeRessources(this.aeroport.getRessources());
		return this.listeEtatsAvions; 
	}
	
	
	
	
}
