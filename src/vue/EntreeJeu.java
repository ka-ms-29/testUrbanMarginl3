package vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * panel général
	 */
	private JPanel contentPane;
	/**
	 * zone de saisie IP
	 */
	private JTextField txtIp;

	/**
	 * clic sur le bouton Start pour lancer le serveur
	 */
	private void btnStart_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}
	/**
	 * clic sur le bouton Exit pour arrêter l'application
	 */
	private void btnExit_clic() {
		System.exit(0);
	}
	
	/**
	 * clic sur le bouton Connect pour se connecter à un serveur
	 */
	private void btnConnect_clic() {
		(new ChoixJoueur()).setVisible(true);
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public EntreeJeu() {
		setTitle("Urban Marginal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnStart_clic();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(220, 13, 96, 30);
		contentPane.add(btnStart);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConnect.setBounds(220, 108, 96, 30);
		contentPane.add(btnConnect);
		
		JButton btnExist = new JButton("Exist");
		btnExist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_clic();
			}
		});
		btnExist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExist.setBounds(220, 156, 96, 30);
		contentPane.add(btnExist);
		
		JLabel lblStartAServer = new JLabel("Start a server :");
		lblStartAServer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartAServer.setBounds(10, 10, 96, 36);
		contentPane.add(lblStartAServer);
		
		JLabel lblConnectAnExistingServer = new JLabel("Connect an exesting server :");
		lblConnectAnExistingServer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConnectAnExistingServer.setBounds(10, 56, 181, 30);
		contentPane.add(lblConnectAnExistingServer);
		
		JLabel lblIpServer = new JLabel("IP server : ");
		lblIpServer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIpServer.setBounds(10, 108, 96, 30);
		contentPane.add(lblIpServer);
		
		txtIp = new JTextField();
		txtIp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(83, 110, 124, 30);
		contentPane.add(txtIp);
		txtIp.setColumns(10);

	}
}
