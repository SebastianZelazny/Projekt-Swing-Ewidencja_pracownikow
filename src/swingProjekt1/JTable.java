package swingProjekt1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class JTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private javax.swing.JTable table = null;
	private DefaultTableModel dtm,dtm1;
	private JTextField TFFirsName;
	private JTextField TFLasName;
	private JTextField TFPesel;
	private JTextField TFCountry;
	private JTextField TFPaymant;
	private DBConnect dbcon = new DBConnect();
	private String indeks;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable frame = new JTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void initialize()
	{
		
	}
	
	
	public JTable() throws ClassNotFoundException, SQLException {
		ShowEmployees();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mnMenu.add(mntmRefresh);
		
		JMenuItem MenuItemInsert = new JMenuItem("INSERT");
		mnMenu.add(MenuItemInsert);
		
		JMenuItem MenuItemUpdate = new JMenuItem("UPDATE");
	
		mnMenu.add(MenuItemUpdate);
		
		JMenuItem MenuItemDelete = new JMenuItem("DELETE");
	
		mnMenu.add(MenuItemDelete);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnMenu.add(mntmClose);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem MenuItemInfo = new JMenuItem("Info");
		mnAbout.add(MenuItemInfo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new javax.swing.JTable(dtm);
		table.setBounds(10, 42, 414, 166);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 166);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		TFFirsName = new JTextField();
		TFFirsName.setBounds(127, 248, 105, 20);
		contentPane.add(TFFirsName);
		TFFirsName.setColumns(10);
		
		TFLasName = new JTextField();
		TFLasName.setBounds(127, 279, 105, 20);
		contentPane.add(TFLasName);
		TFLasName.setColumns(10);
		
		TFPesel = new JTextField();
		TFPesel.setBounds(127, 310, 105, 20);
		contentPane.add(TFPesel);
		TFPesel.setColumns(10);
		
		TFCountry = new JTextField();
		TFCountry.setBounds(127, 341, 105, 20);
		contentPane.add(TFCountry);
		TFCountry.setColumns(10);
		
		TFPaymant = new JTextField();
		TFPaymant.setBounds(127, 372, 105, 20);
		contentPane.add(TFPaymant);
		TFPaymant.setColumns(10);
		
		JButton BtnInsert = new JButton("INSERT");
		BtnInsert.setBounds(127, 403, 89, 23);
		contentPane.add(BtnInsert);
		
		JLabel LblFirsName = new JLabel("FirstName");
		LblFirsName.setHorizontalAlignment(SwingConstants.CENTER);
		LblFirsName.setBounds(34, 251, 83, 14);
		contentPane.add(LblFirsName);
		
		JLabel LblLastName = new JLabel("LastName");
		LblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		LblLastName.setBounds(34, 282, 83, 14);
		contentPane.add(LblLastName);
		
		JLabel LBLPesel = new JLabel("Pesel");
		LBLPesel.setHorizontalAlignment(SwingConstants.CENTER);
		LBLPesel.setBounds(34, 313, 83, 14);
		contentPane.add(LBLPesel);
		
		JLabel LblCountry = new JLabel("Country");
		LblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		LblCountry.setBounds(34, 344, 83, 14);
		contentPane.add(LblCountry);
		
		JLabel LBlPaymant = new JLabel("Paymant");
		LBlPaymant.setHorizontalAlignment(SwingConstants.CENTER);
		LBlPaymant.setBounds(34, 375, 83, 14);
		contentPane.add(LBlPaymant);
		
		JButton BtnGetDate = new JButton("GetDate");
		BtnGetDate.setBounds(127, 403, 89, 23);
		contentPane.add(BtnGetDate);
		
		JButton BtnDelete = new JButton("DELETE");
		BtnDelete.setBounds(127, 403, 89, 23);
		contentPane.add(BtnDelete);
		
		JLabel LBLInfo = new JLabel("Copyright \u00A9 Sebastian \u017Belazny. All rights reserved. ");
		LBLInfo.setBounds(10, 425, 414, 14);
		contentPane.add(LBLInfo);
		
		JLabel LblInfoUpgrade = new JLabel("");
		LblInfoUpgrade.setHorizontalAlignment(SwingConstants.CENTER);
		LblInfoUpgrade.setBounds(52, 219, 232, 14);
		contentPane.add(LblInfoUpgrade);
		
		JButton BtnUpgrade = new JButton("UPGRADE");
		BtnUpgrade.setBounds(127, 403, 89, 23);
		contentPane.add(BtnUpgrade);
		
		TFFirsName.setVisible(false);
		TFLasName.setVisible(false);
		TFPesel.setVisible(false);
		TFCountry.setVisible(false);
		TFPaymant.setVisible(false);
		LblInfoUpgrade.setVisible(false);
		
	
		LblFirsName.setVisible(false);
		LblLastName.setVisible(false);
		LBLPesel.setVisible(false);
		LblCountry.setVisible(false);
		LBlPaymant.setVisible(false);
		LBLInfo.setVisible(false);
		
		BtnDelete.setVisible(false);
		BtnInsert.setVisible(false);
		BtnGetDate.setVisible(false);
		BtnUpgrade.setVisible(false);
		
		
		MenuItemInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TFFirsName.setVisible(true);
				TFLasName.setVisible(true);
				TFPesel.setVisible(true);
				TFCountry.setVisible(true);
				TFPaymant.setVisible(true);
				
			
				LblFirsName.setVisible(true);
				LblLastName.setVisible(true);
				LBLPesel.setVisible(true);
				LblCountry.setVisible(true);
				LBlPaymant.setVisible(true);
				LBlPaymant.setText("Paymant");
				
				BtnInsert.setVisible(true);
				BtnDelete.setVisible(false);
				BtnGetDate.setVisible(false);
				TFFirsName.setText("");
				TFLasName.setText("");
				TFPesel.setText("");
				TFCountry.setText("");
				TFPaymant.setText("");
			}
		});
		
		MenuItemUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TFFirsName.setVisible(true);
				TFLasName.setVisible(true);
				TFPesel.setVisible(true);
				TFCountry.setVisible(true);
				TFPaymant.setVisible(true);
				
			
				LblFirsName.setVisible(true);
				LblLastName.setVisible(true);
				LBLPesel.setVisible(true);
				LblCountry.setVisible(true);
				LBlPaymant.setVisible(true);
				LBlPaymant.setText("Paymant");
				
				BtnGetDate.setVisible(true);
				BtnDelete.setVisible(false);
				BtnInsert.setVisible(false);
				TFFirsName.setText("");
				TFLasName.setText("");
				TFPesel.setText("");
				TFCountry.setText("");
				TFPaymant.setText("");
			}
		});
		
		MenuItemDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TFFirsName.setVisible(false);
				TFLasName.setVisible(false);
				TFPesel.setVisible(false);
				TFCountry.setVisible(false);
				TFPaymant.setVisible(true);
				
			
				LblFirsName.setVisible(false);
				LblLastName.setVisible(false);
				LBLPesel.setVisible(false);
				LblCountry.setVisible(false);
				LBlPaymant.setVisible(true);
				LBLInfo.setVisible(false);
				LBlPaymant.setText("Podaj ID");
				
				BtnGetDate.setVisible(false);
				BtnDelete.setVisible(true);
				BtnInsert.setVisible(false);
				TFFirsName.setText("");
				TFLasName.setText("");
				TFPesel.setText("");
				TFCountry.setText("");
				TFPaymant.setText("");
			}
		});
		
		MenuItemInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TFFirsName.setVisible(false);
				TFLasName.setVisible(false);
				TFPesel.setVisible(false);
				TFCountry.setVisible(false);
				TFPaymant.setVisible(false);
				
			
				LblFirsName.setVisible(false);
				LblLastName.setVisible(false);
				LBLPesel.setVisible(false);
				LblCountry.setVisible(false);
				LBlPaymant.setVisible(false);
				
				BtnDelete.setVisible(false);
				BtnInsert.setVisible(false);
				BtnGetDate.setVisible(false);
				LBlPaymant.setText("Paymant");
				LBLInfo.setVisible(true);
				
			}
		});
		
		BtnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement preparedStmt = null;
				
				if(TFFirsName.getText().equals("")||TFLasName.getText().equals("")||TFPesel.getText().equals("")||TFCountry.getText().equals("")||TFPaymant.getText().equals(""))
				{
					LblInfoUpgrade.setVisible(true);
					LblInfoUpgrade.setText("Proszê uzupe³niæ wszystkie pola");
					//System.out.println("Proszê uzupe³niæ wszystkie pola");
				}
				else
				{
						LblInfoUpgrade.setVisible(false);
						String SQLInsert = "insert into employees (FirstName,LastName,PESEL,Country,Payment) value(?,?,?,?,?)";
						try {
							Connection con = dbcon.connection("root", "Seb@stian1.");
							preparedStmt = con.prepareStatement(SQLInsert);
							preparedStmt.setString(1, TFFirsName.getText());
							preparedStmt.setString(2, TFLasName.getText());
							preparedStmt.setString(3, TFPesel.getText());
							preparedStmt.setString(4, TFCountry.getText());
							preparedStmt.setString(5, TFPaymant.getText());
							preparedStmt.execute();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						TFFirsName.setText("");
						TFLasName.setText("");
						TFPesel.setText("");
						TFCountry.setText("");
						TFPaymant.setText("");
				}
			}});
		BtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement preparedStmt = null;
				
				
				if(TFPaymant.getText().equals(""))
				{
					LblInfoUpgrade.setVisible(true);
					LblInfoUpgrade.setText("Prosze wskazaæ ID rekordu do usuniêcia");
				}
				else
				{
					try
					{
						LblInfoUpgrade.setVisible(false);
						Connection con = dbcon.connection("root", "Seb@stian1.");
						String SQLDel = "DELETE from employees where ID_E= "+TFPaymant.getText();
						preparedStmt = con.prepareStatement(SQLDel);
						preparedStmt.executeUpdate();
						TFPaymant.setText("");
					}catch (SQLException e1) {
						// TODO: handle exception
					}catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		BtnGetDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()<0)
				{
					LblInfoUpgrade.setVisible(true);
					LblInfoUpgrade.setText("Prosze wskazaæ rekord do upgradu");
					//System.out.println("Prosze wskazaæ rekord do upgradu");
				}
				else
				{
					int i = 0;
					LblInfoUpgrade.setVisible(false);
					BtnUpgrade.setVisible(true);
					BtnGetDate.setVisible(false);
				
					indeks = (String) table.getValueAt(table.getSelectedRow(), i);
					//System.out.println(indeks);
					i++;
					TFFirsName.setText((String) table.getValueAt(table.getSelectedRow(), i));
					i++;
					TFLasName.setText((String) table.getValueAt(table.getSelectedRow(), i));
					i++;
					TFPesel.setText((String) table.getValueAt(table.getSelectedRow(), i));
					i++;
					TFCountry.setText((String) table.getValueAt(table.getSelectedRow(), i));
					i++;
					TFPaymant.setText((String) table.getValueAt(table.getSelectedRow(), i));
				}
				
				
				
			}
		});
		
		BtnUpgrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement preparedStatement = null;
				
				if(TFFirsName.getText().equals("")||TFLasName.getText().equals("")||TFPesel.getText().equals("")||TFCountry.getText().equals("")||TFPaymant.getText().equals(""))
				{
					LblInfoUpgrade.setVisible(true);
					LblInfoUpgrade.setText("Prosze wskazaæ rekord do upgradu");
					//System.out.println("Proszê uzupe³niæ wszystkie pola");
				}
				try {
					LblInfoUpgrade.setVisible(false);
					Connection con = dbcon.connection("root", "Seb@stian1.");
					String SQLUpdate = "UPDATE employees set FirstName = ?, LastName = ?,PESEL = ?,Country = ?,Payment = ?  where ID_E= "+indeks;
					preparedStatement = con.prepareStatement(SQLUpdate);
					preparedStatement.setString(1, TFFirsName.getText());
					preparedStatement.setString(2, TFLasName.getText());
					preparedStatement.setString(3, TFPesel.getText());
					preparedStatement.setString(4, TFCountry.getText());
					preparedStatement.setString(5, TFPaymant.getText());
					preparedStatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				TFFirsName.setText("");
				TFLasName.setText("");
				TFPesel.setText("");
				TFCountry.setText("");
				TFPaymant.setText("");
				BtnUpgrade.setVisible(false);
				BtnGetDate.setVisible(true);
				
			}
		});
		
		mntmRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					refresh();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mntmClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(1);
			}
		});
	}
	
	public void ShowEmployees() throws SQLException, ClassNotFoundException
	{
		ResultSet rs;
		Connection con = dbcon.connection("root", "Seb@stian1.");
		rs = con.createStatement().executeQuery("Select * from employees");
		
		Vector<Vector<String>> employees = new Vector<>();
		Vector<String> Tablenames = null;
		Vector<String> tmp2;
		while(rs.next())
		{
			
			Tablenames = new Vector<>();
			Tablenames.add(rs.getMetaData().getColumnName(1));
			Tablenames.add(rs.getMetaData().getColumnName(2));
			Tablenames.add(rs.getMetaData().getColumnName(3));
			Tablenames.add(rs.getMetaData().getColumnName(4));
			Tablenames.add(rs.getMetaData().getColumnName(5));
			Tablenames.add(rs.getMetaData().getColumnName(6));
		
			tmp2 = new Vector<>();
			tmp2.add(String.valueOf(rs.getInt(1)));
			tmp2.add(rs.getString(2));
			tmp2.add(rs.getString(3));
			tmp2.add(rs.getString(4));
			tmp2.add(rs.getString(5));
			tmp2.add(rs.getString(6));
			employees.add(tmp2);
		}
		
		dtm = new DefaultTableModel(employees, Tablenames);
		//System.out.println(Tablenames);
		//System.out.println(employees);
	}
	public void refresh() throws SQLException, ClassNotFoundException
	{
		ResultSet rs;
		Connection con = dbcon.connection("root", "Seb@stian1.");
		rs = con.createStatement().executeQuery("Select * from employees");
		
		Vector<Vector<String>> employees = new Vector<>();
		Vector<String> Tablenames = null;
		Vector<String> tmp2;
		while(rs.next())
		{
			
			Tablenames = new Vector<>();
			Tablenames.add(rs.getMetaData().getColumnName(1));
			Tablenames.add(rs.getMetaData().getColumnName(2));
			Tablenames.add(rs.getMetaData().getColumnName(3));
			Tablenames.add(rs.getMetaData().getColumnName(4));
			Tablenames.add(rs.getMetaData().getColumnName(5));
			Tablenames.add(rs.getMetaData().getColumnName(6));
		
			tmp2 = new Vector<>();
			tmp2.add(String.valueOf(rs.getInt(1)));
			tmp2.add(rs.getString(2));
			tmp2.add(rs.getString(3));
			tmp2.add(rs.getString(4));
			tmp2.add(rs.getString(5));
			tmp2.add(rs.getString(6));
			employees.add(tmp2);
		}
		
		dtm1 = new DefaultTableModel(employees, Tablenames);
		table.setModel(dtm1);
		((DefaultTableModel)table.getModel()).fireTableDataChanged();
		//System.out.println(Tablenames);
		//System.out.println(employees);
	}
}
