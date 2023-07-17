 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Stock extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,lh;
	
	JComboBox C1;
	JButton b1,b2;
    JLabel lI;
	ImageIcon img;
	//ImageIcon img;
	//JLabel l11;
	
	  public Stock()
	{
		setLayout(null);
		
		img=new ImageIcon("stock.jpg");
		lI=new JLabel(img);
		lI.setBounds(0,0,1440,900);
		 add(lI);
		l1=new JLabel("Product Name");
		//l2=new JLabel("Stock");
		l3=new JLabel("Stock");
		lh=new JLabel("Stock Form");
		//img=new ImageIcon("stock.jpg");
		//l11=new JLabel(img);
		//l11.setBounds(0,0,550,350);
		//add(l11);
		C1=new JComboBox();
		
	
		
		b1=new JButton("Stock");
		b2=new JButton("Back");
		
		l1.setBounds(500,400,150,30);
		//l2.setBounds(500,450,150,30);
		
		
		l3.setBounds(600,450,250,50);
		
		
		
		
		lh.setBounds(580,320,150,30);//heading
		
		
		
		C1.setBounds(660,400,150,30);
		
		b1.setBounds(500,520,100,30);
		b2.setBounds(700,520,100,30);
		
		lI.add(l1);
		//lI.add(l2);
		lI.add(l3);
		lI.add(lh);
		
		lI.add(C1);
		
		lI.add(b1);
		lI.add(b2);
		
		setSize(1440,900);
		setLocationRelativeTo(null);
		//setLocation(500,140);
		setVisible(true);
		setTitle("Stock");
		Font f=new Font("Californian FB",Font.ITALIC,35);
        Font f1=new Font("Californian FB",Font.BOLD,40);
        
        lh.setFont(f);
        lh.setForeground(Color.red);
        l1.setForeground(Color.red);
        l3.setFont(f1);
        l3.setForeground(Color.red);
        
		addProductName();
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton B=(JButton)e.getSource();
		if(B==b1)
		{
			String str=(String)C1.getSelectedItem();
		try
		   {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
			Statement  st1=cn1.createStatement();
			String sql2="Select Quantity from Product_Details where P_name='"+str+"'";
			ResultSet rs1=st1.executeQuery(sql2);
			rs1.next();
			l3.setText(rs1.getString(1));
		   }
		   catch(Exception eb)
		   {
			   JOptionPane.showMessageDialog(null,eb);
		   }
	   }
	   if(b2==B)
		{
			//getdata();
	
		this.setVisible(false);
		new MDI();
	  
		}
	}
	
	public void addProductName()
	 {
		 try
		 {
			 C1.removeAllItems();
						C1.addItem("");
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select P_name from Product_Details";
			ResultSet rs=st.executeQuery(sql);
										while(rs.next())
										{
											C1.addItem(rs.getString(1));
										}
                                      cn.close();
                                   }
                        catch(Exception ea1)
                           {
                                  JOptionPane.showMessageDialog(null,ea1);
                              }
	}
		
	public static void main (String[]args)
	{
		new Stock();
	}
}