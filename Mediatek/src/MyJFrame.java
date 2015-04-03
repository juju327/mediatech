import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class MyJFrame extends JFrame {

	private JPanel contentPane;
	private static Controleur_documents controleur_doc;
	private static Controleur_Recherche controleur_recherche;
	private static Controleur_abonne controleur_abonne;
	private static Controleur_emprunt controleur_emprunt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/**
		 * ici charger les paramètres
		 */
		Parametres p = new Parametres(5, 5, 3, 15, 15);
		controleur_doc = new Controleur_documents(new Mediatek(p));
		controleur_recherche = new Controleur_Recherche(controleur_doc.getMediatek());
		controleur_abonne = new Controleur_abonne(controleur_doc.getMediatek());
		controleur_emprunt = new Controleur_emprunt(controleur_doc.getMediatek());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyJFrame frame = new MyJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyJFrame() {
		setTitle("Mediatek, le meilleur de la tek");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1262, 462);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// DOCUMENT
		JMenu mnDocument = new JMenu("Document");
		menuBar.add(mnDocument);

		// DOCUMENT -> AJOUTER
		JMenu mnAjouter = new JMenu("Ajouter");
		mnDocument.add(mnAjouter);

		// DOCUMENT -> AJOUTER -> LIVRE
		JMenuItem mntmLivre = new JMenuItem("Livre");
		mntmLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre_ajouter_livre f = new Fenetre_ajouter_livre(
						controleur_doc);
			}
		});
		mnAjouter.add(mntmLivre);

		// DOCUMENT -> AJOUTER -> MUSIQUE
		JMenuItem mntmMusique = new JMenuItem("Musique");
		mntmMusique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre_ajouter_musique f = new Fenetre_ajouter_musique(
						controleur_doc);
			}
		});
		mnAjouter.add(mntmMusique);

		// DOCUMENT -> SUPPRIMER
		JMenuItem mntmSupprimer = new JMenuItem("Supprimer");
		mntmSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre_supprimer_document f = new Fenetre_supprimer_document(
						controleur_doc);
			}
		});
		mnDocument.add(mntmSupprimer);

		mnDocument.addSeparator();

		// DOCUMENT -> PRET
		JMenuItem mntmPret = new JMenuItem("Effectuer un prêt");
		mntmPret.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_effectuer_pret f = new Fenetre_effectuer_pret(controleur_emprunt, controleur_abonne,
						controleur_doc);
			}
		});
		mnDocument.add(mntmPret);

		// DOCUMENT -> RETOUR
		JMenuItem mntmRetour = new JMenuItem("Effectuer un retour");
		mntmRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_effectuer_retour f = new Fenetre_effectuer_retour(
						controleur_doc);
			}
		});
		mnDocument.add(mntmRetour);

		mnDocument.addSeparator();

		// DOCUMENT -> QUITTER
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnDocument.add(mntmQuitter);

		// ABONNE
		JMenu mnAbonne = new JMenu("Abonne");
		menuBar.add(mnAbonne);

		// ABONNE -> AJOUTER
		JMenuItem mntmAjouterAbonne = new JMenuItem("Ajouter");
		mntmAjouterAbonne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_ajouter_abonne f = new Fenetre_ajouter_abonne(controleur_abonne);

			}
		});
		mnAbonne.add(mntmAjouterAbonne);

		// ABONNE -> SUPPRIMER
		JMenuItem mntmsupprimerAbonne = new JMenuItem("Supprimer");
		mntmsupprimerAbonne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnAbonne.add(mntmsupprimerAbonne);
		// RECHERCHE
		JMenu mnRecherche = new JMenu("Recherche");
		menuBar.add(mnRecherche);

		// RECHERCHE -> AUTEUR
		JMenuItem mntmRechercheAuteur = new JMenuItem("Par auteur");
		mntmRechercheAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		mnRecherche.add(mntmRechercheAuteur);

		// RECHERCHE -> DOCUMENT
		JMenuItem mntmRechercheDocument = new JMenuItem("Par titre de document");
		mntmRechercheDocument.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_recherche_titre f = new Fenetre_recherche_titre(
						controleur_recherche);
			}
		});
		mnRecherche.add(mntmRechercheDocument);

		// ADMINISTATION
		JMenuItem mntmAdministation = new JMenu("Administration");
		mntmAdministation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		menuBar.add(mntmAdministation);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
