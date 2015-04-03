
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Fenetre_supprimer_document extends JFrame  {
	private JTextField reference;	
	private Controleur_document controleur_doc;
	
	public Fenetre_supprimer_document(Controleur_document c) {
		controleur_doc = c;
		
		setTitle("Supprimer un document");
		getContentPane().setLayout(null);
		
		JLabel lblRfrenceDuDocument = new JLabel("Référence du document");
		lblRfrenceDuDocument.setBounds(251, 94, 200, 50);
		getContentPane().add(lblRfrenceDuDocument);
		
		reference = new JTextField();
		reference.setBounds(508, 110, 114, 19);
		getContentPane().add(reference);
		reference.setColumns(10);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
			    int result = JOptionPane.showConfirmDialog(frame, "Êtes-vous sûr de vouloir supprimer ce document ? (Cette action est irrévocable)");
			    //TODO : confirmer la suppression
			}
		});
		btnSupprimer.setBounds(413, 229, 117, 25);
		getContentPane().add(btnSupprimer);
		
		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
}