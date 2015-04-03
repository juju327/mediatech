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
	private JTextField champ_titre;
	private JTextField champ_dateParution;
	private JTextField champ_numeroISBN;
	private JTextField champ_auteur;
	private Controleur_documents controleur_doc;
	private JTextField champ_nom;
	private JTextField champ_prenom;
	private JTextField champ_adresse;
	private JTextField champ_date;
	public Fenetre_ajouter_abonne(Controleur_documents c) {
		controleur_doc = c;
		setTitle("Ajouter un abonné");
		getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(191, 104, 70, 15);
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
		lblPrenom.setBounds(191, 152, 70, 15);
		getContentPane().add(lblPrenom);
		
		champ_adresse = new JTextField();
		champ_adresse.setColumns(10);
		champ_adresse.setBounds(301, 199, 114, 19);
		getContentPane().add(champ_adresse);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(191, 201, 70, 15);
		getContentPane().add(lblAdresse);
		
		champ_date = new JTextField();
		champ_date.setColumns(10);
		champ_date.setBounds(301, 256, 114, 19);
		getContentPane().add(champ_date);
		
		JLabel lblDate = new JLabel("Prénom");
		lblDate.setBounds(191, 258, 70, 15);
		getContentPane().add(lblDate);
		
		JButton btnCrer = new JButton("Créer");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = champ_nom.getText();
				String prenom = champ_prenom.getText();
				String date = champ_date.getText();
				String adresse = champ_adresse.getText();
				
				// TODO ici ajouter un abonne !!!!!!!
			}
		});
		btnCrer.setBounds(477, 253, 117, 25);
		getContentPane().add(btnCrer);
		
		setBounds(250, 250, 950, 462);
		setVisible(true);
	}
}
