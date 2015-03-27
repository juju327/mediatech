import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_ajouter_livre extends JFrame {
	private JTextField champ_titre;
	private JTextField champ_dateParution;
	private JTextField champ_numeroISBN;
	private JTextField champ_auteur;
	private Controleur_documents controleur_doc;

	public Fenetre_ajouter_livre() {
		setTitle("Ajouter un livre");
		getContentPane().setLayout(null);

		champ_titre = new JTextField();
		champ_titre.setBounds(255, 96, 114, 19);
		getContentPane().add(champ_titre);
		champ_titre.setColumns(10);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(67, 80, 54, 50);
		getContentPane().add(lblTitre);

		champ_auteur = new JTextField();
		champ_auteur.setColumns(10);
		champ_auteur.setBounds(255, 143, 114, 19);
		getContentPane().add(champ_auteur);

		JLabel lblDateDeParution = new JLabel("Date de parution");
		lblDateDeParution.setBounds(67, 179, 133, 50);
		getContentPane().add(lblDateDeParution);

		champ_dateParution = new JTextField();
		champ_dateParution.setColumns(10);
		champ_dateParution.setBounds(255, 195, 114, 19);
		getContentPane().add(champ_dateParution);

		JLabel lblNumroIsbn = new JLabel("Numéro ISBN");
		lblNumroIsbn.setBounds(67, 225, 133, 50);
		getContentPane().add(lblNumroIsbn);

		champ_numeroISBN = new JTextField();
		champ_numeroISBN.setColumns(10);
		champ_numeroISBN.setBounds(255, 241, 114, 19);
		getContentPane().add(champ_numeroISBN);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(67, 287, 133, 50);
		getContentPane().add(lblGenre);
		JComboBox genreLivre = new JComboBox(GenreLivre.values());

		genreLivre.setBounds(255, 300, 96, 24);
		getContentPane().add(genreLivre);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = champ_titre.getText();
				String aut = champ_auteur.getText();
				String date = champ_dateParution.getText();
				String numISBN = champ_numeroISBN.getText();
				GenreLivre genre = (GenreLivre) genreLivre.getSelectedItem();

				ArrayList<Auteur> auteurs = new ArrayList<>();
				// TODO faire une boucle pour récupérer les auteurs du champ
				// texte

				if (!aut.isEmpty()) {
					Auteur auteur = new Auteur(aut);
					auteurs.add(auteur);
				}

				JFrame frame = new JFrame();

				if (!titre.isEmpty() && !numISBN.isEmpty()
						&& !auteurs.isEmpty() && !date.isEmpty()) {
					int result = JOptionPane.showConfirmDialog(frame,
							"Êtes-vous sûr de vouloir ajouter ce document: Titre:\""
									+ titre + "\" Date de parution:\"" + date
									+ "\" Auteur:\"" + aut + "\" Genre : \""
									+ genre.toString() + "\"");
					// TODO gérer l'affichage des auteurs multiples
					if (result == JOptionPane.YES_OPTION) {
						// TODO on est ici exception du creerLivre à traiter !!!!
						controleur_doc.creerLivre(titre, date, numISBN, genre,
								auteurs);
						// champ_titre.setText("hello");
					}

				}
			}
		});
		btnAjouter.setBounds(448, 300, 117, 25);
		getContentPane().add(btnAjouter);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(67, 127, 54, 50);
		getContentPane().add(lblAuteur);

		setBounds(250, 250, 950, 462);

		setVisible(true);
	}

}