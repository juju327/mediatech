import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Fenetre_supprimer_abonne extends JFrame {
	private JTextField champ_num_abo;
	private Controleur_abonne controleur_abonne;

	public Fenetre_supprimer_abonne(Controleur_abonne c) {
		controleur_abonne = c;

		setTitle("Supprimer un abonné");
		getContentPane().setLayout(null);

		JLabel lblRfrenceDuDocument = new JLabel("Numéro de l'abonné");
		lblRfrenceDuDocument.setBounds(251, 94, 200, 50);
		getContentPane().add(lblRfrenceDuDocument);

		champ_num_abo = new JTextField();
		champ_num_abo.setBounds(508, 110, 114, 19);
		getContentPane().add(champ_num_abo);
		champ_num_abo.setColumns(10);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				String numAbo = champ_num_abo.getText();

				// l'abonné existe
				if (controleur_abonne.numeroAbonneValide(numAbo)) {

					int result = JOptionPane
							.showConfirmDialog(
									frame,
									"Êtes-vous sûr de vouloir supprimer cet abonné ? (Cette action est irréversible)");

					// on supprime le document
					if (result == JOptionPane.OK_OPTION) {
						controleur_abonne.supprimerAbonne(numAbo);
					}
					// il y a un problème
				} else {
					JOptionPane.showMessageDialog(null,
							"L'abonné demandé n'existe pas !",
							"Erreur de saisie", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSupprimer.setBounds(413, 229, 117, 25);
		getContentPane().add(btnSupprimer);

		setBounds(250, 250, 950, 462);

		setVisible(true);
	}
}