 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Fenetre_effectuer_pret extends JFrame  {
	private JTextField reference;	
	private JTextField numeroAbonne;
	private JTextField champ_referenceDoc;
	private Controleur_emprunt controleur_emprunt;
	private Controleur_abonne controleur_abonne;
	private Controleur_document controleur_document;
	
	JLabel lblDocumentsPreter;
	JLabel lblNumroDabonn;
	JLabel lblTrouve;
	JButton btnValiderAbonn;
	JButton btnPreter;
	
	Abonne abonne;
	
	
	public Fenetre_effectuer_pret(Controleur_emprunt ce, Controleur_abonne ca, Controleur_document cd) {
		controleur_emprunt = ce;
		controleur_abonne = ca;
		controleur_document = cd;
		
		lblNumroDabonn = new JLabel("Numéro d'abonné");
		numeroAbonne = new JTextField();
		lblTrouve = new JLabel("Abonné trouvé !");
		lblDocumentsPreter = new JLabel("Document(s) à prêter");
		btnValiderAbonn = new JButton("Valider abonné");
		champ_referenceDoc = new JTextField();
		btnPreter = new JButton("Prêter");
		setTitle("Effectuer un prêt");
		setBounds(250, 250, 950, 462);
		getContentPane().setLayout(null);
		
		lblNumroDabonn.setBounds(322, 61, 143, 50);
		getContentPane().add(lblNumroDabonn);
		
		numeroAbonne.setBounds(494, 77, 114, 19);
		getContentPane().add(numeroAbonne);
		numeroAbonne.setColumns(10);
		
		lblTrouve.setBounds(408, 163, 214, 15);
		lblTrouve.setVisible(false);
		getContentPane().add(lblTrouve);
		
		lblDocumentsPreter.setBounds(322, 238, 200, 50);
		getContentPane().add(lblDocumentsPreter);
		
		disableAll();
		btnValiderAbonn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numAbonne = numeroAbonne.getText();
				abonne = controleur_abonne.getAbonne(numAbonne);
				if (abonne != null) {
					lblTrouve.setText("Abonné : " + abonne.getNom() + " " + abonne.getPrenom());
					lblTrouve.setVisible(true);
					enableAll();
				} else {
					lblTrouve.setText("L'abonné n'existe pas");
					lblTrouve.setVisible(true);					
				}
			}
		});
		btnValiderAbonn.setBounds(381, 126, 151, 25);
		getContentPane().add(btnValiderAbonn);
		
		champ_referenceDoc.setBounds(494, 254, 114, 19);
		getContentPane().add(champ_referenceDoc);
		champ_referenceDoc.setColumns(10);
		
		btnPreter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String refDoc = champ_referenceDoc.getText();
				Document document;
						//le document existe et que le quota de l'abonné n'est pas dépassé
				if (controleur_emprunt.verifEmprunt(refDoc, abonne)) {
					document = controleur_document.getDocument(refDoc); 
					controleur_emprunt.faireEmprunt(document, abonne);
					controleur_emprunt.save();
				}
			}
		});
		btnPreter.setBounds(396, 300, 151, 25);
		getContentPane().add(btnPreter);
		
		
		setVisible(true);
	}
	
	private void disableAll() {
		lblDocumentsPreter.setEnabled(false);
		champ_referenceDoc.setEnabled(false);
		btnPreter.setEnabled(false);
	}
	
	private void enableAll() {
		lblDocumentsPreter.setEnabled(true);
		champ_referenceDoc.setEnabled(true);
		btnPreter.setEnabled(true);
	}
}