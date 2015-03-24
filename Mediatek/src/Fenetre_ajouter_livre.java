import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_ajouter_livre extends JFrame  {
	private JTextField champ_titre;
	private JTextField champs_dateParution;
	private JTextField champs_numeroISBN;
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
		
		JLabel lblDateDeParution = new JLabel("Date de parution");
		lblDateDeParution.setBounds(67, 149, 133, 50);
		getContentPane().add(lblDateDeParution);
		
		champs_dateParution = new JTextField();
		champs_dateParution.setColumns(10);
		champs_dateParution.setBounds(255, 165, 114, 19);
		getContentPane().add(champs_dateParution);
		
		JLabel lblNumroIsbn = new JLabel("Numéro ISBN");
		lblNumroIsbn.setBounds(67, 211, 133, 50);
		getContentPane().add(lblNumroIsbn);
		
		champs_numeroISBN = new JTextField();
		champs_numeroISBN.setColumns(10);
		champs_numeroISBN.setBounds(255, 227, 114, 19);
		getContentPane().add(champs_numeroISBN);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(67, 287, 133, 50);
		getContentPane().add(lblGenre);
		
		JComboBox genreLivre = new JComboBox();
		genreLivre.setModel(new DefaultComboBoxModel(new String[] {"Roman", "BD", "Documentaire", "Manga", "Jeunesse", "Autre"}));
		genreLivre.setBounds(255, 300, 96, 24);
		getContentPane().add(genreLivre);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = champ_titre.getText();
				String date = champs_dateParution.getText();
				String numISBN = champs_numeroISBN.getText();
				String genre = lblGenre.getText();
				
				ArrayList<Auteur> auteurs = new ArrayList();
				
				//controleur_doc.creerLivre(titre, date, numISBN, genre, auteurs);
			}			
		});
		btnAjouter.setBounds(448, 300, 117, 25);
		getContentPane().add(btnAjouter);
		
		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
	

}