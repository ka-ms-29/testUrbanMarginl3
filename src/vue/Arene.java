package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.net.URL;

public class Arene extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * panel général
	 */
	private JPanel contentPane;
	/**
	 * zone de saisie chat
	 */
	private JTextField txtChat;

	

	/**
	 * Create the frame.
	 */
	public Arene() {
		setTitle("Arena");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArena = new JLabel("");
		String chemin = "fonds/fondarene.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblArena.setIcon(new ImageIcon(resource));
		lblArena.setBounds(10, 10, 800, 600);
		contentPane.add(lblArena);
		
		JScrollPane jspChat = new JScrollPane();
		jspChat.setBounds(10, 641, 800, 47);
		contentPane.add(jspChat);
		
		txtChat = new JTextField();
		jspChat.setViewportView(txtChat);
		txtChat.setColumns(10);

	}
}
