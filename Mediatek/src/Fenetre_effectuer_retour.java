
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Fenetre_effectuer_retour extends JFrame  {
	private JTextField reference;	
	private JTextField referenceDocument;
	private Controleur_document controleur_doc;
	
	public Fenetre_effectuer_retour(Controleur_document c) {
		controleur_doc = c;
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
				int result = JOptionPane.showConfirmDialog(frame,"Ref document : " + ref);
			}
		});
		btnPrter.setBounds(382, 216, 151, 25);
		getContentPane().add(btnPrter);

		setVisible(true);
	}
}