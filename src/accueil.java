import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class accueil {

	private JFrame frame;
	public Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String url="jdbc:mysql://localhost:3306/projet_java";
		try {
			
		connection = DriverManager.getConnection(url,"root","");
		System.out.println("connecté avec succes au serveur");
		}
		
		catch(Exception exp)
		{
			System.out.println(exp); }
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 635, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue, admin! ");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(20, 24, 262, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Formations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formations format = new formations();
				formations.main(null);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton.setBounds(10, 205, 591, 77);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Enseignants");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignants ens = new enseignants();
				enseignants.main(null);
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(new Color(250, 250, 210));
		btnNewButton_2.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton_2.setBounds(10, 129, 591, 77);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Etudiants");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiants ens = new etudiants();
				etudiants.main(null);
			}
		});
		btnNewButton_3.setForeground(new Color(25, 25, 112));
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton_3.setBounds(10, 281, 591, 76);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Projet: Centre de Formation");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(24, 432, 378, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Travail fait par : Siwar Ayed 2GT1");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(394, 432, 207, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/formation-logo.png")).getImage();
		//lblNewLabel_2.setIcon(new ImageIcon(img));
		Image newimg = img.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(newimg));
		lblNewLabel_2.setBounds(252, 381, 100, 102);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/images-removebg-preview.png")).getImage();
		Image newimg3 = img3.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(newimg3));
		lblNewLabel_4.setBounds(35, 11, 207, 123);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("D\u00E9connexion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				login.main(null);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 250, 205));
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(0, 0, 139));
		btnNewButton_4.setBounds(463, 54, 138, 49);
		frame.getContentPane().add(btnNewButton_4);
		
		
	}
}
