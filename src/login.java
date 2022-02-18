import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField pwd;
	public Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		String url="jdbc:mysql://localhost:3306/projet_java";
		try {
			
		connection = DriverManager.getConnection(url,"root","");
		System.out.println("connect� avec succes au serveur");
		}
		
		catch(Exception exp)
		{
			System.out.println(exp); }
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 25));
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel login = new JLabel("Se Connecter");
		login.setFont(new Font("Segoe UI", Font.BOLD, 25));
		login.setForeground(new Color(0, 0, 139));
		login.setBounds(91, 11, 174, 50);
		frame.getContentPane().add(login);
		
		JLabel label1 = new JLabel("Nom d'Utilisateur :");
		label1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label1.setBounds(10, 88, 141, 29);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Mot de Passe        :");
		label2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label2.setBounds(10, 157, 141, 26);
		frame.getContentPane().add(label2);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 0));
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(146, 89, 141, 29);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(146, 159, 141, 29);
		frame.getContentPane().add(pwd);
		
		JButton btnloginin = new JButton("Connexion");
		btnloginin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String myPass=String.valueOf(pwd.getPassword());
				String myUser=username.getText();
				
				
				if (myPass.contains("admin") && myUser.contains("admin")) {
					
					username.setText(null);
					pwd.setText(null);
					
					accueil ac = new accueil();
					accueil.main(null);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Donn�es Invalides","Erreur de connexion",JOptionPane.ERROR_MESSAGE);
					username.setText(null);
					pwd.setText(null);
				}
				
				
			}
			
		});
		
		btnloginin.setForeground(new Color(0, 0, 139));
		btnloginin.setBackground(new Color(100, 149, 237));
		
		btnloginin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnloginin.setBounds(126, 250, 125, 36);
		frame.getContentPane().add(btnloginin);
		frame.setBounds(100, 100, 377, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
