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
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class MainWindows {

	private JFrame frmGestionaero;
	private JTable table;
	private JTable table_1;

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
		frmGestionaero = new JFrame();
		frmGestionaero.setTitle("GestionAero");
		frmGestionaero.setBounds(100, 100, 485, 320);
		frmGestionaero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionaero.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmGestionaero.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAtterir = new JButton("Atterir");
		panel.add(btnAtterir);
		
		JButton btnDecoller = new JButton("D\u00E9coller");
		panel.add(btnDecoller);
		
		JPanel panel_1 = new JPanel();
		frmGestionaero.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox cmbAvion = new JComboBox();
		cmbAvion.setEnabled(false);
		cmbAvion.setModel(new DefaultComboBoxModel(new String[] {"Commodor", "Jet", "Airbus"}));
		panel_1.add(cmbAvion);
		
		JButton btnPlay = new JButton("Play!");

		btnPlay.setEnabled(false);
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		frmGestionaero.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmGestionaero.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		table = new JTable();
		tabbedPane.addTab("Avion", null, table, null);
		table.setModel(new DefaultTableModel(
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
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
		tabbedPane.addTab("Ressource", null, table_1, null);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		
		btnAtterir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cmbAvion.setEnabled(true);
				btnPlay.setEnabled(true);
			}
		});
		
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int idSelectionAvion = cmbAvion.getSelectedIndex();
				cmbAvion.setEnabled(false);
				btnPlay.setEnabled(false);
			}
		});
		
		btnDecoller.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cmbAvion.setEnabled(true);
				btnPlay.setEnabled(true);
			}
		});
	}
}
