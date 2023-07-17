import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Bankbalance extends JFrame implements ActionListener
{
	JLabel l1,l3;
	JButton b1;
	int balance;
	
	public Bankbalance()
	{
		setLayout(null);
		
			l1=new JLabel("Label");
			//l2=new JLabel("Label");
            l3=new JLabel("Bank Balance");
			b1=new JButton("Balance");
			
			l1.setBounds(150,100,150,30);
			//l2.setBounds(150,150,150,30);
            l3.setBounds(100,50,100,30);
			b1.setBounds(130,200,80,30);
			
			add(l1);
			//add(l2);
           add(l3);
			add(b1);
			
			setSize(1440,900);
			setLocationRelativeTo(null);
			setVisible(true);
			b1.addActionListener(this);
			
	}
		 public void actionPerformed(ActionEvent e)
		 {
			 JButton b=(JButton)e.getSource();
			 if(b==b1)
			 {
				try
                                        {  
										 //t1.setEnabled(true);
										 //t2.setEnabled(true);
										// t3.setEnabled(true);
										 //t4.setEnabled(true);
										Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
                                         Statement  st1=cn1.createStatement();
                                           String sql4="select max(T_ID) from Bank_Receipt";
                                         ResultSet rs3=st1.executeQuery(sql4);
										 rs3.next();
										
                                     int n=rs3.getInt(1);
											 //addbutton();
                                          Statement  st2=cn1.createStatement();
                                           String sql5="select B_Bal1 from Bank_Receipt where T_ID=" + n;
                                         ResultSet rs4=st2.executeQuery(sql5);
										 rs4.next();
										balance=rs4.getInt(1);
										
										l1.setText(Integer.toString(balance));
                                     n=n+1;
                                    //t2.setText(Integer.toString(n));
									
                                      cn1.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
							  
        }
				 
		 }
		 
		public static void main(String[]args)
		{
			new Bankbalance();
		}
}