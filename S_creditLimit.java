import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class S_creditLimit extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JComboBox c1;
    JLabel lI;
	ImageIcon img;
	JButton b1,b2;
	
	public S_creditLimit()
	{
		setLayout(null);
        
        img=new ImageIcon("Customer(1).png");
		lI=new JLabel(img);
		lI.setBounds(0,0,1440,900);
		 add(lI);
        
        
		l1=new JLabel("Supplier Name");
		l2=new JLabel("");
		l4=new JLabel("Total = ");
		c1=new JComboBox();
		b1=new JButton("Submit");
		b2=new JButton("Back");
		l3=new JLabel("Supplier Credit Limit");

		l1.setBounds(420,400,150,30);
		l2.setBounds(630,450,150,30);
		l4.setBounds(420,450,150,30);
		
		b1.setBounds(440,520,100,30);
		b2.setBounds(600,520,100,30);
		
		
		c1.setBounds(590,400,150,30);
		
		
		l3.setBounds(450,250,350,30);//heading
		
		
		
		lI.add(l1);
		lI.add(l2);
		lI.add(c1);
		lI.add(b1);
		lI.add(b2);
		lI.add(l3);
		lI.add(l4);
		
		
		setSize(1440,900);
		setLocationRelativeTo(null);
		setTitle("Supplier CreditLimit");
		setVisible(true);
		addSName();
		b1.addActionListener(this);
		b2.addActionListener(this);
			  Font f=new Font("Californian FB",Font.ITALIC,40);
        l3.setFont(f);
        l3.setForeground(Color.red);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b1==b)
		{
			String str=(String)c1.getSelectedItem();
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
					Statement st1=cn1.createStatement();
					String sql1="select S_Credit_LIMIT from SupplierInfo where S_name='"+str+"'";
					ResultSet rs1=st1.executeQuery(sql1);
					rs1.next();
					l2.setText(rs1.getString(1));
				}
					catch(Exception eb)
					{
						JOptionPane.showMessageDialog(null,eb);
					}
		}
				if(b2==b)
				{
					//getdata();
	
					this.setVisible(false);
					new MDI();
	  
				}
			
	}
		

			
	 public void addSName()
	  {
		 try
		 {
			 c1.removeAllItems();
						c1.addItem("");
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select S_name from SupplierInfo";
			ResultSet rs=st.executeQuery(sql);
										while(rs.next())
										{
											c1.addItem(rs.getString(1));
										}
                                      cn.close();
                                   }
                        catch(Exception ea1)
                           {
                                  JOptionPane.showMessageDialog(null,ea1);
                              }
	}		
	
	public static void main(String[]args)
	{
		new S_creditLimit();
	}
}