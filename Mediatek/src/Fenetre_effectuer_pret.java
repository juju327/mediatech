import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class Fenetre_effectuer_pret extends JFrame  {
	private JTextField reference;	
	private JTextField numeroAbonne;
	private JTextField referenceDocument;
	
	public Fenetre_effectuer_pret() {
		setTitle("Effectuer un prêt");
		
		setBounds(250, 250, 950, 462);
		getContentPane().setLayout(null);
		
		JLabel lblNumroDabonn = new JLabel("Numéro d'abonné");
		lblNumroDabonn.setBounds(322, 61, 143, 50);
		getContentPane().add(lblNumroDabonn);
		
		numeroAbonne = new JTextField();
		numeroAbonne.setBounds(494, 77, 114, 19);
		getContentPane().add(numeroAbonne);
		numeroAbonne.setColumns(10);
		
		JButton btnValiderAbonn = new JButton("Valider abonné");
		btnValiderAbonn.setBounds(381, 126, 151, 25);
		getContentPane().add(btnValiderAbonn);
		
		JLabel lblDocumentsPrter = new JLabel("Document(s) à prêter");
		lblDocumentsPrter.setBounds(322, 238, 200, 50);
		getContentPane().add(lblDocumentsPrter);
		
		referenceDocument = new JTextField();
		referenceDocument.setBounds(494, 254, 114, 19);
		getContentPane().add(referenceDocument);
		referenceDocument.setColumns(10);
		
		JButton btnPrter = new JButton("Prêter");
		btnPrter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrter.setBounds(396, 300, 151, 25);
		getContentPane().add(btnPrter);

		setVisible(true);
	}
}