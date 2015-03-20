import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_ajouter_musique extends JFrame  {
	private JTextField champ_titre;
	private JTextField champs_dateParution;
	
	public Fenetre_ajouter_musique() {
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
		lblDateDeParution.setBounds(66, 161, 133, 50);
		getContentPane().add(lblDateDeParution);
		
		champs_dateParution = new JTextField();
		champs_dateParution.setColumns(10);
		champs_dateParution.setBounds(254, 177, 114, 19);
		getContentPane().add(champs_dateParution);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(66, 244, 133, 50);
		getContentPane().add(lblGenre);
		
		JComboBox genreLivre = new JComboBox();
		genreLivre.setModel(new DefaultComboBoxModel(new String[] {"Rock", "Pop", "Jazz", "Classique", "Rap", "Autre"}));
		genreLivre.setBounds(254, 257, 96, 24);
		getContentPane().add(genreLivre);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(447, 257, 117, 25);
		getContentPane().add(btnAjouter);
		
		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
}