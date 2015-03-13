import java.awt.BorderLayout;
import java.awt.EventQueue;

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


public class MyJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1262, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouterUnDocument = new JButton("Ajouter un document");
		btnAjouterUnDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(btnAjouterUnDocument);
				contentPane.revalidate(); 
				contentPane.repaint();
			}
		});
		btnAjouterUnDocument.setBounds(33, 72, 213, 25);
		contentPane.add(btnAjouterUnDocument);
		
		JButton btnSupprimerUnDocument = new JButton("Supprimer un document");
		btnSupprimerUnDocument.setBounds(276, 72, 203, 25);
		contentPane.add(btnSupprimerUnDocument);
		
		JButton btnAjouterAbonn = new JButton("Ajouter abonné");
		btnAjouterAbonn.setBounds(729, 72, 203, 25);
		contentPane.add(btnAjouterAbonn);
		
		JButton btnRechercheParAuteur = new JButton("Recherche par auteur");
		btnRechercheParAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRechercheParAuteur.setBounds(33, 299, 213, 25);
		contentPane.add(btnRechercheParAuteur);
		
		JButton btnRechercheParDocument = new JButton("Recherche par document");
		btnRechercheParDocument.setBounds(276, 299, 218, 25);
		contentPane.add(btnRechercheParDocument);
		
		JButton btnEffectuerPrt = new JButton("Effectuer prêt");
		btnEffectuerPrt.setBounds(729, 299, 203, 25);
		contentPane.add(btnEffectuerPrt);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 39, 513, 94);
		contentPane.add(panel);
		
		JButton btnSupprimerAbonn = new JButton("Supprimer abonné");
		btnSupprimerAbonn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimerAbonn.setBounds(960, 72, 203, 25);
		contentPane.add(btnSupprimerAbonn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(689, 39, 513, 94);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 264, 513, 94);
		contentPane.add(panel_2);
		
		JButton btnEffectuerUnRetour = new JButton("Effectuer un retour");
		btnEffectuerUnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEffectuerUnRetour.setBounds(960, 299, 203, 25);
		contentPane.add(btnEffectuerUnRetour);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(689, 264, 513, 94);
		contentPane.add(panel_3);
		//aaa
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
