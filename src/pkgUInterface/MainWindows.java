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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import pkgClasse.Avion;
import pkgControlleur.CtrlAeroport;

import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class MainWindows {
	
	public JComboBox cmbAvion; 
	public JButton btnAtterir;
	public JButton btnDecoller; 
	public JTable tblAvions;
	public JTable tblRessources;
	
	private FrameAero frmGestionaero;
 
	private Timer timer;
	 
	public ActionListener performRefresh = new ActionListener(){
		public void actionPerformed(ActionEvent evt)
		{
		/*System.out.println("Rafraîchissement...");*/
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
		frmGestionaero.setBounds(100, 100, 517, 256);
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
		
		JPanel panel_1 = new JPanel();
		frmGestionaero.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPlay = new JButton("Play!");
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmGestionaero.getContentPane().add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{86, 39, 0};
		gbl_panel_2.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Nombre d'avions: ");
		lblNewLabel.setMaximumSize(new Dimension(106, 14));
		lblNewLabel.setMinimumSize(new Dimension(106, 14));
		lblNewLabel.setPreferredSize(new Dimension(106, 14));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JSpinner spnAvions = new JSpinner();
		spnAvions.setModel(new SpinnerNumberModel(6, 0, 30, 1));
		GridBagConstraints gbc_spnAvions = new GridBagConstraints();
		gbc_spnAvions.insets = new Insets(0, 0, 5, 0);
		gbc_spnAvions.anchor = GridBagConstraints.NORTHWEST;
		gbc_spnAvions.gridx = 1;
		gbc_spnAvions.gridy = 0;
		panel_2.add(spnAvions, gbc_spnAvions);
		
		JLabel lblNombreDeFuel = new JLabel("Nombre de fuels: ");
		lblNombreDeFuel.setMaximumSize(new Dimension(106, 14));
		lblNombreDeFuel.setMinimumSize(new Dimension(106, 14));
		lblNombreDeFuel.setPreferredSize(new Dimension(106, 14));
		lblNombreDeFuel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreDeFuel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombreDeFuel = new GridBagConstraints();
		gbc_lblNombreDeFuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeFuel.gridx = 0;
		gbc_lblNombreDeFuel.gridy = 1;
		panel_2.add(lblNombreDeFuel, gbc_lblNombreDeFuel);
		
		JSpinner spnFuels = new JSpinner();
		spnFuels.setModel(new SpinnerNumberModel(2, 0, 10, 1));
		GridBagConstraints gbc_spnFuels = new GridBagConstraints();
		gbc_spnFuels.insets = new Insets(0, 0, 5, 0);
		gbc_spnFuels.gridx = 1;
		gbc_spnFuels.gridy = 1;
		panel_2.add(spnFuels, gbc_spnFuels);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de gates: ");
		lblNewLabel_1.setMaximumSize(new Dimension(106, 14));
		lblNewLabel_1.setMinimumSize(new Dimension(106, 14));
		lblNewLabel_1.setPreferredSize(new Dimension(106, 14));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSpinner spnGates = new JSpinner();
		spnGates.setModel(new SpinnerNumberModel(2, 0, 10, 1));
		GridBagConstraints gbc_spnGates = new GridBagConstraints();
		gbc_spnGates.insets = new Insets(0, 0, 5, 0);
		gbc_spnGates.gridx = 1;
		gbc_spnGates.gridy = 2;
		panel_2.add(spnGates, gbc_spnGates);
		
		JLabel lblNombreDeContrle = new JLabel("Nombre de contr\u00F4les: ");
		lblNombreDeContrle.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreDeContrle.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombreDeContrle = new GridBagConstraints();
		gbc_lblNombreDeContrle.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeContrle.gridx = 0;
		gbc_lblNombreDeContrle.gridy = 3;
		panel_2.add(lblNombreDeContrle, gbc_lblNombreDeContrle);
		
		JSpinner spnTechniques = new JSpinner();
		spnTechniques.setModel(new SpinnerNumberModel(2, 0, 10, 1));
		GridBagConstraints gbc_spnTechniques = new GridBagConstraints();
		gbc_spnTechniques.insets = new Insets(0, 0, 5, 0);
		gbc_spnTechniques.gridx = 1;
		gbc_spnTechniques.gridy = 3;
		panel_2.add(spnTechniques, gbc_spnTechniques);
		
		JLabel lblNombreDePistes = new JLabel("Nombre de pistes");
		lblNombreDePistes.setMaximumSize(new Dimension(106, 14));
		lblNombreDePistes.setMinimumSize(new Dimension(106, 14));
		lblNombreDePistes.setPreferredSize(new Dimension(106, 14));
		lblNombreDePistes.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreDePistes.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombreDePistes = new GridBagConstraints();
		gbc_lblNombreDePistes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDePistes.gridx = 0;
		gbc_lblNombreDePistes.gridy = 4;
		panel_2.add(lblNombreDePistes, gbc_lblNombreDePistes);
		
		JSpinner spnPistes = new JSpinner();
		spnPistes.setModel(new SpinnerNumberModel(2, 0, 10, 1));
		GridBagConstraints gbc_spnPistes = new GridBagConstraints();
		gbc_spnPistes.insets = new Insets(0, 0, 5, 0);
		gbc_spnPistes.gridx = 1;
		gbc_spnPistes.gridy = 4;
		panel_2.add(spnPistes, gbc_spnPistes);
		
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
				configurer((int)(spnAvions.getValue()), 
						(int)(spnFuels.getValue()), 
						(int)(spnGates.getValue()), 
						(int)(spnPistes.getValue()), 
						(int)(spnTechniques.getValue()), 30);
				lancerSimulation();
				
			}
		});
		
		btnDecoller.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// startAvion(cmbAvion.getSelectedItem().toString(), 2);
			}
		});
		

		
		btnAtterir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				// startAvion(cmbAvion.getSelectedItem().toString(), 1);
			}
		});
		
		SwingUtilities.invokeLater(frmGestionaero);
		
		timer = new Timer(100, performRefresh);
		timer.setRepeats(true);
		timer.start();
		
		// SET VISIBLE POUR PARTIE NON UTILE  
		cmbAvion.setVisible(false);
		btnAtterir.setVisible(false);
		btnDecoller.setVisible(false);
		
	}
	
	public void lancerSimulation(){
		// SIMULATION PERMETTANT DE LANCER LES OPÉRATIONS POUR TOUS LES AVIONS 
		frmGestionaero.lancerSimulation();
	}
	
	public void configurer(int nAvions, int nFuels, int nGates, int nPistes, int nTechniques, int maxA){
		frmGestionaero.initAeroport(nAvions, nFuels, nGates, nPistes, nTechniques, maxA);
	}
	
	public void rafraichirInterface(){
		// RAFRAICHIR LA LISTE DES AVIONS 
		ArrayList<String> listeA = frmGestionaero.getAvionsInactifs();
		if (cmbAvion.getItemCount() != listeA.size()){
			cmbAvion.removeAllItems();
			for(String item : listeA){
				cmbAvion.addItem(item);
			}
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
		
		// RAFRAICHIR LA LISTE DES RESSOURCES
		ArrayList<String> listeR = frmGestionaero.getRessources();
		
		// OBTENIR LES RESSOURCES
		
		// TROUVER TAILLE TABLEAU RESSOURCES
		
		// RAFRAICHIR TABLEAU RESSOURCES
	}
	
	/*
	public void startAvion(String nom, int action){
		frmGestionaero.startAvion(nom, action);
	}
	*/
	
	
}
