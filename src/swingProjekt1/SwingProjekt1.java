package swingProjekt1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class SwingProjekt1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passField;
	private DBConnect dbcon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingProjekt1 window = new SwingProjekt1();
					window.frame.setVisible(true);
				/*	window.frame2.setVisible(false);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingProjekt1() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);*/
		
		textField = new JTextField();
		textField.setBounds(135, 77, 125, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton BtnLogin = new JButton("Zaloguj");
		BtnLogin.setBounds(135, 177, 89, 23);
		frame.getContentPane().add(BtnLogin);
		
		passField = new JPasswordField();
		passField.setBounds(135, 125, 125, 20);
		frame.getContentPane().add(passField);
		
		JLabel lblNewLabel = new JLabel("Podaj Login");
		lblNewLabel.setBounds(58, 80, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Podaj Haslo");
		lblNewLabel_1.setBounds(58, 128, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel LblError = new JLabel("");
		LblError.setBounds(95, 152, 260, 14);
		frame.getContentPane().add(LblError);
		BtnLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs;
				System.out.println("XXX");
				try {
					dbcon = new DBConnect();
					Connection con = dbcon.connection("root", "Seb@stian1.");
					rs = con.createStatement().executeQuery("Select * from logins");
					System.out.println("xxx");
					while(rs.next())
					{
						System.out.println(rs.getString(2));
						if(textField.getText().equals(rs.getString(2))&&(passField.getText().equals(rs.getString(3))))
						{
							System.out.println(rs.getString(2)+" "+rs.getString(3));
							JTable Frame2 = new JTable();
							frame.setVisible(false);
							Frame2.setVisible(true);
						}
						else
						{
							LblError.setVisible(true);
							LblError.setText("Podany Login lub has³o nieprawid³owe !");
							textField.setText("");
							passField.setText("");
						}
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}); 
		
	}
}
