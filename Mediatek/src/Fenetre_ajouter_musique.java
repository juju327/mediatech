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

public class Fenetre_ajouter_musique extends JFrame {
	private JTextField champ_titre;
	private JTextField champ_dateParution;
	private Controleur_document controleur_doc;
	private JTextField champ_auteur;

	public Fenetre_ajouter_musique(Controleur_document c) {
		controleur_doc = c;
		setTitle("Ajouter une musique");
		getContentPane().setLayout(null);

		champ_titre = new JTextField();
		champ_titre.setBounds(255, 96, 114, 19);
		getContentPane().add(champ_titre);
		champ_titre.setColumns(10);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(66, 80, 54, 50);
		getContentPane().add(lblTitre);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(66, 127, 54, 50);
		getContentPane().add(lblAuteur);

		champ_auteur = new JTextField();
		champ_auteur.setColumns(10);
		champ_auteur.setBounds(255, 143, 114, 19);
		getContentPane().add(champ_auteur);

		JLabel lblDateDeParution = new JLabel("Date de sortie");
		lblDateDeParution.setBounds(66, 182, 133, 50);
		getContentPane().add(lblDateDeParution);

		champ_dateParution = new JTextField();
		champ_dateParution.setColumns(10);
		champ_dateParution.setBounds(255, 198, 114, 19);
		getContentPane().add(champ_dateParution);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(66, 244, 133, 50);
		getContentPane().add(lblGenre);

		JComboBox genreMusique = new JComboBox(GenreMusique.values());
		genreMusique.setBounds(254, 257, 96, 24);
		getContentPane().add(genreMusique);

		JButton btnAjouter = new JButton("Ajouter");

		// TODO a supprimer avant de rendre
		champ_dateParution.setText("01/01/2000");
		champ_auteur.setText("monsuperMusicien");
		champ_titre.setText("monsuperAlbum");

		btnAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String titre = champ_titre.getText();
				String aut = champ_auteur.getText();
				String dateString = champ_dateParution.getText();
				GenreMusique genre = (GenreMusique) genreMusique
						.getSelectedItem();

				// TODO faire une boucle pour récupérer les auteurs du champ
				// texte

				JFrame frame = new JFrame();

				boolean dateJuste = controleur_doc.verifDate(dateString);
				// boolean numDispo = !controleur_doc.numISBNExiste(numISBN);
				// contrôle de la saisie
				if (!titre.isEmpty() && !aut.isEmpty() && !dateString.isEmpty()
						&& dateJuste) {

					Auteur auteur = new Auteur(aut);

					if (controleur_doc.musicExiste(titre, auteur)) {
						JOptionPane
								.showMessageDialog(null,
										"La musique demandée existe déjà.",
										"Erreur de saisie",
										JOptionPane.WARNING_MESSAGE);

					} else {

						// l'utilisateur confirme sa saisie
						int result = JOptionPane.showConfirmDialog(frame,
								"Êtes-vous sûr de vouloir ajouter cette musique: Titre:\""
										+ titre + "\" Auteur:\"" + aut
										+ "\" Date de sortie :\"" + dateString
										+ "\" Genre : \"" + genre.toString()
										+ "\"", "Confirmation",
								JOptionPane.OK_CANCEL_OPTION);

						// on crée la musique
						if (result == JOptionPane.OK_OPTION) {
							controleur_doc.creeMusique(titre, dateString,
									genre, auteur);
						}
					}
					// saisie invalide
				} else {

					if (titre.isEmpty())
						champ_titre.setBackground(Color.red);
					else
						champ_titre.setBackground(Color.white);

					if (aut.isEmpty())
						champ_auteur.setBackground(Color.red);
					else
						champ_auteur.setBackground(Color.white);

					if (dateString.isEmpty())
						champ_dateParution.setBackground(Color.red);
					else
						champ_dateParution.setBackground(Color.white);

					if (!dateJuste) {
						JOptionPane
								.showMessageDialog(null,
										"La date saisie n'est pas valide.",
										"Erreur de saisie",
										JOptionPane.WARNING_MESSAGE);
					}

					/*
					 * if (!numDispo) { JOptionPane .showMessageDialog(null,
					 * "Le numéro ISBN demandé existe déjà.",
					 * "Erreur de saisie", JOptionPane.WARNING_MESSAGE); }
					 */

					// TODO vérifier si la musique existe déjà
				}

			}
		});

		btnAjouter.setBounds(447, 257, 117, 25);
		getContentPane().add(btnAjouter);

		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
}