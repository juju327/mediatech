import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fenetre_visualiser extends JFrame {
	private Controleur_abonne controleur_abonne;
	private Controleur_document controleur_document;
	private Controleur_emprunt controleur_emprunt;
	private JTextField champ_nom;
	private JTextField champ_prenom;
	private JTextField champ_adresse;
	private JTextField champ_date;

	private DefaultTableModel modelDocuments;
	private String[] titreColonnesDocuments;
	private JTable tableDocuments;

	private DefaultTableModel modelAbonnes;
	private String[] titreColonnesAbonnes;
	private JTable tableAbonnes;

	private DefaultTableModel modelEmprunts;
	private String[] titreColonnesEmprunts;
	private JTable tableEmprunts;

	public Fenetre_visualiser(Controleur_document cd, Controleur_abonne ca,
			Controleur_emprunt ce) {
		controleur_abonne = ca;
		controleur_document = cd;
		controleur_emprunt = ce;

		setTitle("Ajouter un abonné");
		getContentPane().setLayout(null);

		// -----------------------------------------------------
		// DOCUMENTS
		JLabel lblDocuments = new JLabel("Documents");
		lblDocuments.setBounds(225, 59, 95, 15);
		getContentPane().add(lblDocuments);

		titreColonnesDocuments = new String[5];
		titreColonnesDocuments[0] = ("Titre");
		titreColonnesDocuments[1] = ("Auteur");
		titreColonnesDocuments[2] = ("Type");
		titreColonnesDocuments[3] = ("Genre");
		titreColonnesDocuments[4] = ("Date de parution");

		modelDocuments = new DefaultTableModel();
		modelDocuments.setColumnIdentifiers(titreColonnesDocuments);
		modelDocuments.addRow(titreColonnesDocuments);

		tableDocuments = new JTable(modelDocuments);
		tableDocuments.setBounds(12, 102, 500, 500);
		getContentPane().add(tableDocuments);

		// -------------------------------------------------------
		// ABONNES
		JLabel lblAbonnes = new JLabel("Abonnés");
		lblAbonnes.setBounds(725, 59, 95, 15);
		getContentPane().add(lblAbonnes);

		titreColonnesAbonnes = new String[3];
		titreColonnesAbonnes[0] = ("Nom");
		titreColonnesAbonnes[1] = ("Prenom");
		titreColonnesAbonnes[2] = ("Numéro d'abonné");

		modelAbonnes = new DefaultTableModel();
		modelAbonnes.setColumnIdentifiers(titreColonnesAbonnes);
		modelAbonnes.addRow(titreColonnesAbonnes);

		tableAbonnes = new JTable(modelAbonnes);
		tableAbonnes.setBounds(532, 102, 500, 500);
		getContentPane().add(tableAbonnes);

		// -------------------------------------------------------

		// EMPRUNTS
		JLabel lblEmprunts = new JLabel("Emprunts");
		lblEmprunts.setBounds(1219, 59, 95, 15);
		getContentPane().add(lblEmprunts);

		titreColonnesEmprunts = new String[2];
		titreColonnesEmprunts[0] = ("Titre");
		titreColonnesEmprunts[1] = ("Abonné");

		modelEmprunts = new DefaultTableModel();
		modelEmprunts.setColumnIdentifiers(titreColonnesEmprunts);
		modelEmprunts.addRow(titreColonnesEmprunts);

		tableEmprunts = new JTable(modelEmprunts);
		tableEmprunts.setBounds(1042, 102, 500, 500);
		getContentPane().add(tableEmprunts);
		// -------------------------------------------------------
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DOCUMENTS
				modelDocuments.setRowCount(1);
				for (Document d : controleur_document.getAllDocuments()) {
					String type = "";
					if (d.getClass() == Livre.class) {
						type = "Livre";
					} else {
						type = "Musique";
					}
					modelDocuments.addRow(new Object[] { d.getTitre(),
							d.getAuteur().getNom(), type,
							d.getGenre().toString(), d.getDateParution() });
				}
				tableDocuments = new JTable(modelDocuments);

				// ABONNES
				modelAbonnes.setRowCount(1);
				for (Abonne a : controleur_abonne.getAllAbonnes()) {
					modelAbonnes.addRow(new Object[] { a.getNom(),
							a.getPrenom(), a.getNumero() });
				}
				tableAbonnes = new JTable(modelAbonnes);

				// EMPRUNT
				modelEmprunts.setRowCount(1);
				for (Emprunt emprunt : controleur_emprunt.getAllEmprunts()) {
					modelEmprunts.addRow(new Object[] {
							emprunt.getPret().getTitre(),
							emprunt.getEmprunteur().getNom() });
				}
				tableEmprunts = new JTable(modelEmprunts);
			}
		});
		btnAfficher.setBounds(700, 630, 117, 25);
		getContentPane().add(btnAfficher);
		setBounds(50, 50, 1600, 800);
		setVisible(true);
	}
}
