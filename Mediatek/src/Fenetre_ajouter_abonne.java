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

public class Fenetre_ajouter_abonne extends JFrame {
	private Controleur_abonne controleur_abonne;
	private JTextField champ_nom;
	private JTextField champ_prenom;
	private JTextField champ_adresse;
	private JTextField champ_date;

	public Fenetre_ajouter_abonne(Controleur_abonne c) {
		controleur_abonne = c;
		setTitle("Ajouter un abonné");
		getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(123, 104, 70, 15);
		getContentPane().add(lblNom);

		champ_nom = new JTextField();
		champ_nom.setBounds(301, 102, 114, 19);
		getContentPane().add(champ_nom);
		champ_nom.setColumns(10);

		champ_prenom = new JTextField();
		champ_prenom.setColumns(10);
		champ_prenom.setBounds(301, 150, 114, 19);
		getContentPane().add(champ_prenom);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(123, 152, 70, 15);
		getContentPane().add(lblPrenom);

		champ_adresse = new JTextField();
		champ_adresse.setColumns(10);
		champ_adresse.setBounds(301, 199, 114, 19);
		getContentPane().add(champ_adresse);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(123, 201, 70, 15);
		getContentPane().add(lblAdresse);

		champ_date = new JTextField();
		champ_date.setColumns(10);
		champ_date.setBounds(301, 256, 114, 19);
		getContentPane().add(champ_date);

		JLabel lblDate = new JLabel("Date de naissance");
		lblDate.setBounds(123, 258, 138, 15);
		getContentPane().add(lblDate);

		JButton btnCrer = new JButton("Créer");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = champ_nom.getText();
				String prenom = champ_prenom.getText();
				String date = champ_date.getText();
				String adresse = champ_adresse.getText();

				// TODO ici ajouter un abonne !!!!!!!

				JFrame frame = new JFrame();

				// controler si le nom prenom existent
				Abonne abo = null;
				abo = controleur_abonne.rechercheAboParNomPrenom(nom, prenom);

				// abonne n'existe pas déjà
				if (abo == null) {
					boolean dateJuste = controleur_abonne.verifDate(date);
					// controle de la saisie
					if (!nom.isEmpty() && !prenom.isEmpty()
							&& !adresse.isEmpty() && !date.isEmpty()
							&& dateJuste) {

						// l'utilisateur confirme sa saisie
						int result = JOptionPane.showConfirmDialog(frame,
								"Êtes-vous sûr de vouloir ajouter cet abonné : Nom:\""
										+ nom + "\" Prénom:\"" + prenom
										+ "\" Adresse :\"" + adresse
										+ "\" Date de naissance:\"" + date
										+ "\"", "Confirmation",
								JOptionPane.OK_CANCEL_OPTION);
						
						// on crée l'abonné
						if (result == JOptionPane.OK_OPTION) {
							String nbAbo = controleur_abonne.creerAbonne(nom, prenom, adresse, date);
							controleur_abonne.save();
							JOptionPane
							.showMessageDialog(null,
									"Votre numéro d'abonné est le "+ nbAbo,
									"Création réussie",
									JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					// saisie invalide
					else {
						if (nom.isEmpty())
							champ_nom.setBackground(Color.red);
						else
							champ_nom.setBackground(Color.white);
						
						if (prenom.isEmpty())
							champ_prenom.setBackground(Color.red);
						else
							champ_prenom.setBackground(Color.white);
						
						if (adresse.isEmpty())
							champ_adresse.setBackground(Color.red);
						else
							champ_adresse.setBackground(Color.white);

						if (date.isEmpty())
							champ_date.setBackground(Color.red);
						else
							champ_date.setBackground(Color.white);
						
						if (!dateJuste) {
							JOptionPane
									.showMessageDialog(null,
											"La date saisie n'est pas valide.",
											"Erreur de saisie",
											JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				// abonne existe !
				else {
					JOptionPane.showMessageDialog(null,
							"La personne demandée est déjà abonnée.",
							"Erreur de saisie", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnCrer.setBounds(477, 253, 117, 25);
		getContentPane().add(btnCrer);

		setBounds(250, 250, 950, 462);
		setVisible(true);
	}
}
