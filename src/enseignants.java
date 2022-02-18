import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class enseignants {

	private JFrame frame;
	private JTable table;
	public Connection connection = null;
	final Object[]row=new Object[6];
	public DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enseignants window = new enseignants();
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
	public enseignants() {
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 617, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_3 = new JLabel("Bienvenue, admin! ");
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setBackground(new Color(0, 0, 139));
		lblNewLabel_3.setBounds(20, 26, 248, 67);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/images-removebg-preview.png")).getImage();
		Image newimg3 = img3.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(newimg3));
		lblNewLabel_4.setBounds(35, 11, 207, 123);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Ajouter Enseignants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajoutEns Ens_aj = new ajoutEns(); 
				ajoutEns.main(null);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton.setBounds(10, 128, 285, 56);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Supprimer Enseignants");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				suppEns Ens_sup = new suppEns(); 
				suppEns.main(null);
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton_3.setBounds(294, 129, 285, 55);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Projet: Centre de Formation");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(25, 548, 378, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Travail fait par : Siwar Ayed 2GT1");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(389, 548, 207, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/formation-logo.png")).getImage();
		//lblNewLabel_2.setIcon(new ImageIcon(img));
		Image newimg = img.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(newimg));
		lblNewLabel_2.setBounds(247, 492, 100, 102);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 263, 569, 218);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Tout Voir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					try {
						String sql="select * from enseignants";
						PreparedStatement pst=connection.prepareStatement(sql);
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{row[0]=rs.getInt("ID_Ens");
						row[1]=rs.getString("Nom_Ens");
						row[2]=rs.getString("Prenom_Ens");
						row[3]=rs.getString("Email_Ens");
						row[4]=rs.getString("Specialite");
						row[5]=rs.getInt("Salaire_par_hr");
						model.addRow(row);
						}
						}
						catch(Exception exp)
						{
						System.out.println(exp);
						}
					
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 139));
		btnNewButton_2.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		btnNewButton_2.setBackground(new Color(250, 250, 210));
		btnNewButton_2.setBounds(10, 181, 569, 56);
		frame.getContentPane().add(btnNewButton_2);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model=new DefaultTableModel();
		Object[]column= {"ID_Ens","Nom_Ens","Prenom_Ens","Email_Ens","Specialite","Salaire/heure"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton btnNewButton_4 = new JButton("Annuler");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accueil ac = new accueil();
				accueil.main(null);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 250, 205));
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(0, 0, 139));
		btnNewButton_4.setBounds(479, 54, 100, 49);
		frame.getContentPane().add(btnNewButton_4);

	}
}
