package pkgUInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

import pkgControlleur.CtrlAeroport;

import javax.swing.JTabbedPane;

// Interface principale pour l'utilisateur. Gère les boutons et l'affichage.
public class MainWindows {
	
	public JComboBox cmbAvion; 
	public JButton btnAtterir;
	public JButton btnDecoller; 
	public JTable tblAvions;
	public JTable tblRessources;
	
	private FrameAero frmGestionaero;
	
	private Timer timer;
	
	public ActionListener performRefresh = new ActionListener()
	{
		public void actionPerformed(ActionEvent evt)
		{					
			rafraichirInterface();
		}
	};
 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainWindows window = new MainWindows();
					window.frmGestionaero.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// INITIALISER LE CONTROLEUR 
		// controler.startAeroport();
		
		frmGestionaero = new FrameAero();
		frmGestionaero.setTitle("GestionAero");
		frmGestionaero.setBounds(100, 100, 485, 320);
		frmGestionaero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionaero.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmGestionaero.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cmbAvion = new JComboBox();
		panel.add(cmbAvion);
		cmbAvion.setEnabled(false);
		cmbAvion.setModel(new DefaultComboBoxModel(new String[] {"Commodor", "Jet", "Airbus"}));
		
		
		
		
		btnAtterir = new JButton("Atterir");
		panel.add(btnAtterir);
		
		btnDecoller = new JButton("D\u00E9coller");
		panel.add(btnDecoller);
		
		JButton btnRefrachir = new JButton("Rafra\u00EEchir");
		panel.add(btnRefrachir);
		
		JPanel panel_1 = new JPanel();
		frmGestionaero.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPlay = new JButton("Play!");

		btnPlay.setEnabled(false);
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		frmGestionaero.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmGestionaero.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tblAvions = new JTable();
		tabbedPane.addTab("Avion", null, tblAvions, null);
		tblAvions.setModel(new DefaultTableModel(
			new Object[][] {
				{"Gyrophare", "Arriver", ""},
				{"Newton", "Acqu\u00E9rir Piste", "Piste Bleue"},
				{"Led Zeppelin", "Embarquer", "Gate Blanche"},
			},
			new String[] {
				"Avion", "\u00C9tape", "Ressource"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tblRessources = new JTable();
		tblRessources.setModel(new DefaultTableModel(
			new Object[][] {
				{"Fuel", "2", "0", "Disponible"},
				{"Piste", "2", "1", "Disponible"},
				{"Gate", "2", "1", "Disponible"},
				{"Contr\u00F4le", "2", "0", "Disponible"},
			},
			new String[] {
				"Ressource", "Nombre", "Utilis\u00E9s", "\u00C9tat"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabbedPane.addTab("Ressource", null, tblRessources, null);
		tblAvions.getColumnModel().getColumn(1).setPreferredWidth(93);

		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				// TODO - MAJ LISTE D'AVIONS 
				
				int idSelectionAvion = cmbAvion.getSelectedIndex();
				// LANCER DECOLLAGE OU ATTERISSAGE 
				
				cmbAvion.setEnabled(false);
				btnPlay.setEnabled(false);
			}
		});
		
		btnDecoller.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO - MAJ LISTE D'AVIONS
				decollerAvion(cmbAvion.getSelectedItem().toString());
				
				cmbAvion.setEnabled(true);
				btnPlay.setEnabled(true);
			}
		});
		

		
		btnAtterir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO - MAJ LISTE D'AVIONS 
				
				cmbAvion.setEnabled(true);
				btnPlay.setEnabled(true);
			}
		});
		
		btnRefrachir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rafraichirInterface();
			}
		});
		
		SwingUtilities.invokeLater(frmGestionaero);
		
		timer = new Timer(100, performRefresh);
		timer.setRepeats(true);
		timer.start();
		
	}
	
	
	
	public void rafraichirInterface(){
		// TODO - Rafraîchir Tableau Avions
		// RAFRAICHIR LA LISTE DES AVIONS 
		ArrayList<String> listeA = frmGestionaero.getAvionsInactifs();
		cmbAvion.removeAllItems();
		
		for(String item : listeA){
			cmbAvion.addItem(item);
		}
		cmbAvion.setEnabled(listeA.size() > 0);
		btnDecoller.setEnabled(listeA.size() > 0);
		btnAtterir.setEnabled(listeA.size() > 0);
		
		// OBTENIR AVIONS 
		listeA = frmGestionaero.getListeNomsAvions();
		
		// OBTENIR LA LISTE DES ETATS 
		ArrayList<String> listeEA = frmGestionaero.getListeEtatsAvions();
		
		// OBTENIR LA LISTE DES RESSOURCES ACQUISES PAR AVION
		ArrayList<String> listeRA = frmGestionaero.getListeAvionsRessources();
		
		// TROUVER TAILLE TABLEAU RESSOURCES
		int maxTbl = Math.min(listeA.size(), listeEA.size());
		maxTbl = Math.min(maxTbl, listeRA.size());
		
		// RAFRAICHIR TABLEAU AVIONS
		tblAvions.removeAll();
		
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Avion");
		tableModel.addColumn("Etat");
		tableModel.addColumn("Ressource");
		tblAvions.setModel(tableModel);
		
		for (int id = 0; id < maxTbl; id++){
			// PUSH ROWS
			tableModel.addRow(new Object[]{listeA.get(id), listeEA.get(id), listeRA.get(id)});
		}
		
		// TODO - Rafraîchir Tableau Ressources
		// RAFRAICHIR LA LISTE DES RESSOURCES
		ArrayList<String> listeR = frmGestionaero.getRessources();
		
		// OBTENIR LES RESSOURCES
		
		// TROUVER TAILLE TABLEAU RESSOURCES
		
		// RAFRAICHIR TABLEAU RESSOURCES
	}
	
	public void decollerAvion(String nom){
		frmGestionaero.startAvion(nom);
	}
	
	
}
