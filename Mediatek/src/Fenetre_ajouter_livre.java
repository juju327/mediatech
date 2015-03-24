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
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_ajouter_livre extends JFrame  {
	private JTextField champ_titre;
	private JTextField champ_dateParution;
	private JTextField champ_numeroISBN;
	private JTextField champ_auteur;
	
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
		
		JComboBox genreLivre = new JComboBox();
		GenreLivre[] genres = GenreLivre.values();
		
		//TODO
		genreLivre.setModel(new DefaultComboBoxModel(genres));
		genreLivre.setBounds(255, 300, 96, 24);
		getContentPane().add(genreLivre);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = champ_titre.getText();
				String auteur = champ_auteur.getText();
				String date = champ_dateParution.getText();
				String numISBN = champ_numeroISBN.getText();
				String genre_temp = lblGenre.getText();
				//GenreLivre genre = GenreLivre.valueOf(genre_temp);
				
				JFrame frame = new JFrame();
			    int result = JOptionPane.showConfirmDialog(frame, "Êtes-vous sûr de vouloir supprimer ce document: Titre:\""+titre+"\" Date de parution:\""+date+"\" Auteur:\""+auteur+"\"");
				//creerLivre(titre, date, numISBN, genre, auteur);
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
	
	private void creerLivre(String titre, String date, String numISBN, GenreLivre genre, String auteur) {
		// TODO Auto-generated method stub
		
	}
	//Aaaa
}