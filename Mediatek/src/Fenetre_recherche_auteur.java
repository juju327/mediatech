import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Fenetre_recherche_auteur extends JFrame {
	private Controleur_recherche controleur_recherche;
	private JTextField champ_titre;
	private JTable tableau;
	private JLabel lblTitre;

	public Fenetre_recherche_auteur(Controleur_recherche c) {
		controleur_recherche = c;

		setTitle("Recherche un document par auteur");
		getContentPane().setLayout(null);
		champ_titre = new JTextField();
		champ_titre.setHorizontalAlignment(SwingConstants.CENTER);
		champ_titre.setBounds(318, 85, 114, 19);
		getContentPane().add(champ_titre);
		champ_titre.setColumns(10);

		DefaultTableModel model;
		String[] titresColonnes = new String[5];
		titresColonnes[0] = ("Titre");
		titresColonnes[1] = ("Auteur");
		titresColonnes[2] = ("Type");
		titresColonnes[3] = ("Genre");
		titresColonnes[4] = ("Date de parution");

		model = new DefaultTableModel();
		model.setColumnIdentifiers(titresColonnes);
		model.addRow(titresColonnes);

		tableau = new JTable(model);
		tableau.setBounds(152, 156, 604, 220);

		getContentPane().add(tableau);

		JButton btnClickMe = new JButton("Rechercher");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auteur = champ_titre.getText();
				ArrayList<Document> documents = controleur_recherche
						.rechercheParNomAuteur(auteur);
				model.setRowCount(1);
				for (Document d : documents) {
					String type = "";
					if (d.getClass() == Livre.class) {
						type = "Livre";
					} else {
						type = "Musique";
					}
					model.addRow(new Object[] { d.getTitre(),
							d.getAuteur().getNom(), type,
							d.getGenre().toString(), d.getDateParution() });
				}
				tableau = new JTable(model);
			}
		});
		btnClickMe.setBounds(513, 81, 114, 27);
		getContentPane().add(btnClickMe);

		lblTitre = new JLabel("Auteur");
		lblTitre.setBounds(261, 87, 54, 15);
		getContentPane().add(lblTitre);
		setBounds(250, 250, 950, 462);
		setVisible(true);
	}
}
