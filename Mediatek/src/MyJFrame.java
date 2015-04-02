import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;


public class MyJFrame extends JFrame {

	private JPanel contentPane;
	private static Controleur_mediatek controleur_mediatek;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		controleur_mediatek = new Controleur_mediatek(new Mediatek());
		controleur_mediatek.getMediatek().newDB();
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
				Fenetre_ajouter_livre f = new Fenetre_ajouter_livre(controleur_mediatek.getMediatek());
			}
		});
		mnAjouter.add(mntmLivre);
		
		// DOCUMENT -> AJOUTER -> MUSIQUE
		JMenuItem mntmMusique = new JMenuItem("Musique");
		mntmMusique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre_ajouter_musique f = new Fenetre_ajouter_musique(controleur_mediatek.getMediatek());
			}
		});
		mnAjouter.add(mntmMusique);
		
		// DOCUMENT -> SUPPRIMER
		JMenuItem mntmSupprimer = new JMenuItem("Supprimer");
		mntmSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre_supprimer_document f = new Fenetre_supprimer_document(controleur_mediatek.getMediatek());
			}
		});
		mnDocument.add(mntmSupprimer);
		
		mnDocument.addSeparator();
		
		// DOCUMENT -> PRET
		JMenuItem mntmPret = new JMenuItem("Effectuer un prêt");
		mntmPret.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_effectuer_pret f = new Fenetre_effectuer_pret(controleur_mediatek.getMediatek());
			}
		});
		mnDocument.add(mntmPret);
		
		// DOCUMENT -> RETOUR
		JMenuItem mntmRetour = new JMenuItem("Effectuer un retour");
		mntmRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre_effectuer_retour f = new Fenetre_effectuer_retour(controleur_mediatek.getMediatek());
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
		JMenu mnAbonne = new JMenu("Abonné");
		menuBar.add(mnAbonne);
		
		// ABONNE -> AJOUTER
		JMenuItem mntmAjouterAbonne = new JMenuItem("Ajouter");
		mntmAjouterAbonne.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		JMenuItem mntmRechercheDocument = new JMenuItem("Par document");
		mntmRechercheAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
