import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
	Container c = getContentPane();
	JPanel PFlightTypes = new JPanel(null);
	JPanel PLogin = new JPanel(null);
	JPanel PFlightDetails = new JPanel(null);

	public boolean bCheck=true;

	JLabel LDomesticFlight = new JLabel("Domestic Flights");
	JLabel LInternationalFlight = new JLabel("International Flights");

	JLabel LUserName, LPassword;

	JLabel LDomesticFlight1 = new JLabel("Domestic Flight Booking");
	JLabel LInternationalFlight1 = new JLabel("International Flight Booking");

	JTextField TFUserName;
	JPasswordField TPPassword;

	JButton BLogin;

	final Object[] col1 ={ "From", "To", "Price", "Time" };
	final Object[] col2 = { "From", "To", "Price", "Time" };
	final Object[] col3 = { "From", "To", "Price", "Time" };

	final Object[][] row1 = { { "Mumbai", "Bangalore", "3125", "16:30" }, { "Trivandrum", "Chennai ", "3225", "19:00" }, { "Gujarat", "Delhi", "1425 ", "08:30" }, { "Delhi", "Goa", "1025 ", "09:50" }, { "Jaipur", "Hyderabad", "1525", "11:00" }, { "Trivandrum", "Kolkata", "3825 ", "05:30" }, { "Trivandrum", "Lucknow", "3025 ", "05:30" }, { "Trivandrum", "Mumbai", "1725", "12:00" }, { "Manali", "Vishakapatnam", "3725", "19:00" } };
	final Object[][] row2 = { { "Mumbai", "Bali", "21485", "06:20" }, { "Delhi", "Bangkok", "9000", "20:45" }, { "Trivandrum", "Cairo", "22975", "10:25" }, { "Gujarat", "CapeTown", "42500", "16:45" }, { "Trivandrum", "Chicago", "35000", "06:30" }, { "Keral", "Dubai", "12000", "08:15" }, { "Kolkata", "Frankfurt", "18500", "06:50" }, { "Trivandrum", "HongKong", "20845", "12:00" }, { "Goa", "Istanbul", "22000", "10:45" }, { "Trivandrum", "London", "22600", "14:35" }, { "Trivandrum", "LosAngeles", "35000", "22:00" }, { "Trivandrum", "Melbourne", "27800", "21:15" }, { "Trivandrum", "New York", "32000", "08:50" }, { "Trivandrum", "Paris", "18500", "18:45" }, { "Trivandrum", "Rome", "19900", "20:00"}, { "Trivandrum", "SanFrancisco", "35000", "12:00"}, { "Trivandrum", "shanghai", "24430", "10:15" }, { "Trivandrum", "Singapore", "9000", "21:10" }, { "Trivandrum", "Sydney", "27800", "12:00"}, { "Trivandrum", "Toronto", "35000", "17:00 " } };
	final Object[][] row3 = { { "Trivandrum", "Bangalore", "9375", "16:30" }, { "Trivandrum", "Chennai ", "9675", "19:00" }, { "Trivandrum", "Delhi", "4275", "08:30" }, { "Trivandrum", "Goa", "3075", "09:50" }, { "Trivandrum", "Hyderabad", "4575", "11:00" }, { "Trivandrum", "Kolkata", "11475", "05:30" }, { "Trivandrum", "Lucknow", "9075", "05:30" }, { "Trivandrum", "Mumbai", "5175", "12:00" }, { "Trivandrum", "Vishakapatnam", "11175", "19:00" } };
	final Object[][] row4 = { { "Trivandrum", "Bali", "64455", "06:20" }, { "Trivandrum", "Bangkok", "27000", "20:45" }, { "Trivandrum", "Cairo", "68925", "10:25" }, { "Trivandrum", "CapeTown", "37500", "16:45" }, { "Trivandrum", "Chicago", "105000", "06:30" }, { "Trivandrum", "Dubai", "36000", "08:15" }, { "Trivandrum", "Frankfurt", "55500", "06:50" }, { "Trivandrum", "HongKong", "62535", "12:00" }, { "Trivandrum", "Istanbul", "66000", "10:45" }, { "Trivandrum", "London", "67800", "14:35" }, { "Trivandrum", "LosAngeles", "105000", "22:00" }, { "Trivandrum", "Melbourne", "83400", "21:15" }, { "Trivandrum", "New York", "96000", "08:50" }, { "Trivandrum", "Paris", "55500", "18:45" }, { "Trivandrum", "Rome", "59700", "20:00" }, { "Trivandrum", "SanFrancisco", "105000", "12:00" }, { "Trivandrum", "shanghai", "73290", "10:15" }, { "Trivandrum", "Singapore", "27000", "21:10"}, { "Trivandrum", "Sydney", "83400", "12:00"}, { "Trivandrum", "Toronto", "105000", "17:00" } };

	JTable TDomesticFlight = new JTable(row1, col1);
	JTable TInternationalFlight = new JTable(row2, col2);
	JTable TDomesticFlight1 = new JTable(row3, col3);
	JTable TInternationalFlight1 = new JTable(row4, col2);

	JScrollPane JSP1 = new JScrollPane(TDomesticFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP2 = new JScrollPane(TInternationalFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP3 = new JScrollPane(TDomesticFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP4 = new JScrollPane(TInternationalFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	Icon img1 = new ImageIcon("./img/economic.jpg");
	Icon img2 = new ImageIcon("./img/business.jpg");
	Icon img3 = new ImageIcon("./img/economic1.jpg");
	Icon img4 = new ImageIcon("./img/business1.jpg");

	JLabel LEconomic = new JLabel("Economic", img1, SwingConstants.LEFT);
	JLabel LBusiness = new JLabel("Business", img2, SwingConstants.LEFT);
	JLabel LEconomic1 = new JLabel("Economic", img3, SwingConstants.LEFT);
	JLabel LBusiness1 = new JLabel("Business", img4, SwingConstants.LEFT);

	public LoginPage()
	{
		WindowUtilities.setNativeLookAndFeel();
		setPreferredSize(new Dimension(796,572));

		PFlightTypes.setBackground(Color.white);
		PLogin.setBackground(Color.white);
		PFlightDetails.setBackground(Color.white);

		JSP1.setBounds(0, 340, 790, 200);
		JSP2.setBounds(0, 340, 790, 200);
		JSP3.setBounds(0, 340, 790, 200);
		JSP4.setBounds(0, 340, 790, 200);

		PFlightTypes.setBounds(0,0,500, 340);
		PLogin.setBounds(500,0,350, 340);
		PFlightDetails.setBounds(0,340,790,200);


		LUserName = new JLabel(" User Name ");
		LPassword = new JLabel(" Password ");
		TFUserName = new JTextField(10);
		TPPassword = new JPasswordField(10);
		BLogin = new JButton("Sign In");

		LUserName.setBounds(40, 100, 100, 21);
		LPassword.setBounds(40, 140, 100, 21);
		TFUserName.setBounds(160, 100, 100, 21);
		TPPassword.setBounds(160, 140, 100, 21);
		BLogin.setBounds(160, 200, 100,25);

		LDomesticFlight1.setBounds(60, 60, 138, 20);
		LInternationalFlight1.setBounds(60, 100, 153, 30);

		PLogin.add(LUserName);
		PLogin.add(TFUserName);
		PLogin.add(LPassword);
		PLogin.add(TPPassword);
		PLogin.add(BLogin);

		PFlightDetails.add(JSP1);
		PFlightDetails.add(JSP2);
		PFlightDetails.add(JSP3);
		PFlightDetails.add(JSP4);

		JSP1.setVisible(true);
		JSP2.setVisible(false);
		JSP3.setVisible(false);
		JSP4.setVisible(false);

		LBusiness.setBounds(265, 170, 300, 125);
		LEconomic.setBounds(0, 170, 250, 125);
		LBusiness1.setBounds(280, 200, 135, 60);
		LEconomic1.setBounds(50, 200, 147, 60);

		PFlightTypes.add(LEconomic);
		PFlightTypes.add(LBusiness);
		PFlightTypes.add(LEconomic1);
		PFlightTypes.add(LBusiness1);

		LBusiness.setVisible(false);
		LEconomic1.setVisible(false);
		LBusiness1.setVisible(true);
		LEconomic.setVisible(true);


		LDomesticFlight.setBounds(60, 60, 100, 25);
		LInternationalFlight.setBounds(60, 100, 120, 25);

		c.add(PFlightTypes);
		c.add(PLogin);
		c.add(PFlightDetails);

		PFlightTypes.add(LDomesticFlight);
		PFlightTypes.add(LInternationalFlight);

		pack();
		setVisible(true);

		addWindowListener(new ExitListener());

		LDomesticFlight.addMouseListener(new mouse1(this, true));
		LInternationalFlight.addMouseListener(new mouse1(this, false));

		LDomesticFlight1.addMouseListener(new mouse3(this, true));
		LInternationalFlight1.addMouseListener(new mouse3(this, false));

		LBusiness1.addMouseListener(new mouse2(this, true));
		LEconomic1.addMouseListener(new mouse2(this, false));

		BLogin.addActionListener((ActionListener) this);
	}
    public void actionPerformed(ActionEvent e) 
            {
                String userName = TFUserName.getText();
                String password = TPPassword.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root", "system");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username, password from airlinedb.users where username=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        
                        PLogin.add(LDomesticFlight1);
						PLogin.add(LInternationalFlight1);

						PLogin.remove(LUserName);
						PLogin.remove(TFUserName);
						PLogin.remove(LPassword);
						PLogin.remove(TPPassword);
						PLogin.remove(BLogin);

						c.repaint();
                        JOptionPane.showMessageDialog(BLogin, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(BLogin, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage frame = new LoginPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
class mouse1 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse1(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if(bCheck)
			type.bCheck = true;
		else
			type.bCheck = false;
		type.LEconomic.setVisible(true);
		type.LBusiness1.setVisible(true);
		type.LEconomic1.setVisible(false);
		type.LBusiness.setVisible(false);

		type.JSP1.setVisible(false);
		type.JSP2.setVisible(false);
		type.JSP3.setVisible(false);
		type.JSP4.setVisible(false);
		if(bCheck)
			type.JSP1.setVisible(true);
		else
			type.JSP2.setVisible(true);
	}
}



class mouse3 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse3(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if (bCheck)
			new DomesticFlight(type);
		else
			new InternationalFlight(type);
	}
}


class mouse2 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse2(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LEconomic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LBusiness1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if(type.bCheck)
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(true);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
		}
		else
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(true);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(true);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(false);
			}
		}
	}
}

