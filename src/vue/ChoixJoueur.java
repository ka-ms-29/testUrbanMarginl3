package vue;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.net.URL;

public class ChoixJoueur extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * panel général
	 */
	private JPanel contentPane;
	/**
	 * zone de saisie pseudo
	 */
	private JTextField txtPseudo;
	
	/**
	 * instance du controleur pour comminiquer avec lui
	 */
	private Controle controle;
	
	/**
	 * label pour affichage des personnage
	 */
	private JLabel lblPersonnage;
	
	/**
	 * numéro du personnage séléctionné 
	 */
	private int numPerso;
	
	/**
	 * constante pour nombre des personnages
	 */
	private static final int NBPERSOS = 3;


	/**
	 * Clic sur la flèche "précédent" pour afficher le personnage précédent
	 */
	private void lblPrecedent_clic() {
		numPerso = (numPerso%NBPERSOS)+1;
		affichePerso();
	}
	
	/**
	 * Clic sur la flèche "suivant" pour afficher le personnage suivant
	 */
	private void lblSuivant_clic() {
		numPerso = (numPerso%NBPERSOS)+1;
		affichePerso();
	}
	
	/**
	 * Clic sur GO pour envoyer les informations
	 */
	private void lblGo_clic() {
		if(this.txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "la saisie du pseudo est obligatoire");
			this.txtPseudo.requestFocus();
		}else {
			this.controle.evenementChoixJoueur(this.txtPseudo.getText(), numPerso);
		}
	}

	/**
	 * affichage du personnage 
	 */
	private void affichePerso() {
		String chemin = "personnages/perso"+this.numPerso+"marche"+1+"d"+1+".gif";
		URL resource = getClass().getClassLoader().getResource(chemin);
		this.lblPersonnage.setIcon(new ImageIcon(resource));
	}
	
	private void sourisNormal() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	private void sourisDoigt() {
	    contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle) {
		setResizable(false);
		setTitle("Choix ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setBounds(155, 115, 112, 122);
		lblPersonnage.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(lblPersonnage);
		
		JLabel lblPrecedente = new JLabel("");
		lblPrecedente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		lblPrecedente.setBounds(58, 148, 45, 54);
		contentPane.add(lblPrecedente);
		
		
		JLabel lblSuivent = new JLabel("");
		lblSuivent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		lblSuivent.setBounds(291, 148, 45, 44);
		contentPane.add(lblSuivent);
		
		
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		
		lblGo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGo.setBounds(307, 202, 69, 60);
		contentPane.add(lblGo);
		
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(144, 247, 134, 28);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);

		
		
		JLabel lblFond = new JLabel("");
		String chemin = "fonds/fondchoix.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblFond.setIcon(new ImageIcon(resource));
		lblFond.setBounds(10, 0, 405, 283);
		contentPane.add(lblFond);
		
		
		
		//recuperation de l'instance de controle
		this.controle = controle;

		//affichage du premier personnage
		this.numPerso = 1;
		this.affichePerso();
		
		//positionnement sur  la zone de saisie
		txtPseudo.requestFocus();
	}

}
