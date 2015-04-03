 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Fenetre_effectuer_retour extends JFrame  {
	private JTextField referenceDocument;
	private Controleur_emprunt controleur_emprunt;
	
	public Fenetre_effectuer_retour(Controleur_emprunt ce) {
		controleur_emprunt = ce;
		setTitle("Effectuer un retour");
		
		setBounds(250, 250, 950, 462);
		getContentPane().setLayout(null);
		
		JLabel lblDocumentsPrter = new JLabel("Document(s) à retourner");
		lblDocumentsPrter.setBounds(261, 137, 200, 50);
		getContentPane().add(lblDocumentsPrter);
		
		referenceDocument = new JTextField();
		referenceDocument.setBounds(479, 153, 114, 19);
		getContentPane().add(referenceDocument);
		referenceDocument.setColumns(10);
		
		JButton btnPrter = new JButton("Retourner");
		btnPrter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				String ref = referenceDocument.getText();
				
				//Si le document existe et est emprunté par quelqu'un (on peut donc le retourner)
				
				if (controleur_emprunt.verifRetour(ref)) {
					controleur_emprunt.faireRetour(ref);
					JOptionPane.showMessageDialog(null, "Retour effectué !", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				} else if(!controleur_emprunt.referenceDocumentValide(ref)){
					JOptionPane
					.showMessageDialog(null,
							"Le document demandé n'existe pas ! Retour impossible.",
							"Erreur de saisie",
							JOptionPane.WARNING_MESSAGE);
				} else if(controleur_emprunt.isDocumentDisponible(ref)){
					JOptionPane
					.showMessageDialog(null,
							"Le document demandé n'est pas emprunté ! Retour impossible.",
							"Erreur de saisie",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnPrter.setBounds(382, 216, 151, 25);
		getContentPane().add(btnPrter);

		setVisible(true);
	}
}
