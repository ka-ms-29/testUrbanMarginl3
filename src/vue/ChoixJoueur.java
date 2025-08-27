package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 * Clic sur la flèche "précédent" pour afficher le personnage précédent
	 */
	private void lblPrecedent_clic() {
		System.out.println("Clic sur precedent");
	}
	
	/**
	 * Clic sur la flèche "suivant" pour afficher le personnage suivant
	 */
	private void lblSuivant_clic() {
		System.out.println("Clic sur suivant");
	}
	
	/**
	 * Clic sur GO pour envoyer les informations
	 */
	private void lblGo_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setResizable(false);
		setTitle("Choix ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblPrecedente = new JLabel("");
		lblPrecedente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
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
			
		});
		lblSuivent.setBounds(291, 148, 45, 44);
		contentPane.add(lblSuivent);
		
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
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
	}

}
