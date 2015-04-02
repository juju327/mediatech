
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Fenetre_recherche_titre extends JFrame {
	private Controleur_Recherche controleur_recherche;
	private JTextField affichage;
	private JTextField txtTitre;

	public Fenetre_recherche_titre(Controleur_Recherche c) {
		controleur_recherche = c;
		setTitle("Recherche simple");
		getContentPane().setLayout(null);

		affichage = new JTextField();
		affichage.setEditable(false);
		affichage.setBounds(327, 71, 291, 146);
		getContentPane().add(affichage);
		affichage.setColumns(10);

		txtTitre = new JTextField();
		txtTitre.setText("Titre");
		txtTitre.setBounds(39, 89, 114, 19);
		getContentPane().add(txtTitre);
		txtTitre.setColumns(10);

		JButton btnClickMe = new JButton("CLICK ME");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = txtTitre.getText();
				for (Document d : controleur_recherche.rechercheParTitre(titre)
						.values()) {
					affichage.setText(affichage.getText() + d.getTitre() + " "
							+ d.getDateParution());
				}
			}
		});
		btnClickMe.setBounds(42, 162, 200, 50);
		getContentPane().add(btnClickMe);

		setBounds(250, 250, 950, 462);
		setVisible(true);

	}
}