import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Fenetre_supprimer_document extends JFrame {
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
				String refDoc = reference.getText();

				// le document existe et n'est pas emprunté
				if (controleur_doc.referenceDocumentValide(refDoc)
						&& controleur_doc.estDispo(refDoc)) {

					int result = JOptionPane
							.showConfirmDialog(
									frame,
									"Êtes-vous sûr de vouloir supprimer ce document ? (Cette action est irréversible)");

					// on supprime le document
					if (result == JOptionPane.OK_OPTION) {
						controleur_doc.supprimerDocument(refDoc);
					}
					// il y a un problème
				} else {
					// le document n'existe pas
					if (!controleur_doc.referenceDocumentValide(refDoc)) {

						JOptionPane
								.showMessageDialog(null,
										"Le document demandé n'existe pas !",
										"Erreur de saisie",
										JOptionPane.WARNING_MESSAGE);
						// le document est emprunté
					} else if (!controleur_doc.estDispo(refDoc)) {
						JOptionPane
								.showMessageDialog(
										null,
										"Le document demandé est actuellement emprunté ! \n Suppression impossible.",
										"Suppression impossible",
										JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnSupprimer.setBounds(413, 229, 117, 25);
		getContentPane().add(btnSupprimer);

		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
}