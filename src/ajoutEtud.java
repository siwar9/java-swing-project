import java.awt.EventQueue;
import java.util.*;
import java.sql.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ajoutEtud {

	private JFrame frame;
	private JTextField nomEtud;
	private JTextField prenEtud;
	private JTextField emailEtud;
	public Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutEtud window = new ajoutEtud();
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
	public ajoutEtud() {
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
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		frame.getContentPane().setBackground(new Color(255, 218, 185));
		frame.getContentPane().setLayout(null);
		
		JLabel lblAjouterFormation = new JLabel("Ajouter Etudiant");
		lblAjouterFormation.setForeground(new Color(0, 0, 139));
		lblAjouterFormation.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblAjouterFormation.setBackground(new Color(0, 0, 139));
		lblAjouterFormation.setBounds(10, 21, 262, 67);
		frame.getContentPane().add(lblAjouterFormation);
		
		JLabel lblNewLabel = new JLabel("Nom de l'etudiant      :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 99, 162, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom de l'etudiant :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 151, 162, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email                             :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 201, 162, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		nomEtud = new JTextField();
		nomEtud.setBounds(182, 99, 291, 32);
		frame.getContentPane().add(nomEtud);
		nomEtud.setColumns(10);
		
		prenEtud = new JTextField();
		prenEtud.setBounds(182, 151, 134, 29);
		frame.getContentPane().add(prenEtud);
		prenEtud.setColumns(10);
		
		emailEtud = new JTextField();
		emailEtud.setBounds(182, 201, 134, 27);
		frame.getContentPane().add(emailEtud);
		emailEtud.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiants ac = new etudiants();
				etudiants.main(null);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 388, 224, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql2="insert into etudiants(Nom_Etud,Prenom_Etud,Email_Etud) values(?,?,?)";
				try {
				PreparedStatement pst=connection.prepareStatement(sql2);
				pst.setString(1, nomEtud.getText());
				pst.setString(2, prenEtud.getText());
				pst.setString(3, emailEtud.getText());
				
				
				boolean b=pst.execute();
				
				etudiants ens = new etudiants();
				etudiants.main(null);
				
				}
				catch(Exception exp) {
					System.out.println(exp);
					JOptionPane.showMessageDialog(null, "Des champs érronés/vides","Erreur de saisie",JOptionPane.ERROR_MESSAGE);
				}
				nomEtud.setText(null);
				prenEtud.setText(null);
				emailEtud.setText(null);

				
			}
			
		});
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton_1.setBounds(232, 388, 241, 53);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 495, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
