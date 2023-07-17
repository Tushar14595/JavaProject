import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BankDateRpt extends JFrame implements ActionListener
{
	JLabel Lh,L1;
	JComboBox C1;
	JButton B1;
	
	public BankDateRpt()
	{
		setLayout(null);
		
		
		L1=new JLabel("Select Month Name");
		C1=new JComboBox();
		B1=new JButton("Report");
		
		L1.setBounds(50,150,200,30);
		C1.setBounds(270,150,100,30);
		B1.setBounds(100,200,100,30);
		
		  Lh=new JLabel("Particular Supplier Report");
		  Lh.setFont(new Font("Times New Roman",Font.BOLD,20));
	      Lh.setBounds(50,50,200,40);
		  add(Lh);
		add(L1);
		add(C1);
		add(B1);
		
	//	 addSupplierName();
		
		setVisible(true);
		setSize(1440,900);
		setLocationRelativeTo(null);
		B1.addActionListener(this);
		
		C1.addItem("January");
		C1.addItem("February");
		C1.addItem("March");
		C1.addItem("April");
		C1.addItem("May");
		C1.addItem("June");
		C1.addItem("July");
		C1.addItem("August");
		C1.addItem("September");
		C1.addItem("October");
		C1.addItem("November");
		C1.addItem("December");
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		JButton B=(JButton)e.getSource();
		if(B==B1)
		{
		String str=(String)C1.getSelectedItem();
		String[][]a=new String[20][8];
		String h[]={"Date","T_id","Bank_Reciept","B_Pay","B_bal","Des"};
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
            Statement  st=cn.createStatement();
            String sql="select * from Bank_Receipt where B_Month='"+str+"'";
            ResultSet rs=st.executeQuery(sql);
			int i=0;
	        while(rs.next())
			{
			  a[i][0]=rs.getString(1);
			  a[i][1]=rs.getString(2);
			  a[i][2]=rs.getString(3);
			  a[i][3]=rs.getString(4);
			  a[i][4]=rs.getString(5);
			  a[i][5]=rs.getString(6);
			  a[i][6]=rs.getString(7);
			  
			 i++;
			}
			  //JLabel L2=new JLabel("");
			  JTable obj=new JTable(a,h);
			  JScrollPane ob=new JScrollPane(obj);
			  ob.setBounds(50,300,600,150);
			 // L2.setBounds(100,100,0,0);
			  
			  add(ob);
			  //add(L2);
			  cn.close();
		   }
		 catch(Exception x)
		 {
		   JOptionPane.showMessageDialog(null,x);
		 }
		 setTitle(" Particular Supplier Report");
		 setVisible(true);
		 //setLocation(150,50);
		 setSize(1440,900);
	    }
	}
	 
	   /*  public void addSupplierName()
	 
	    {
		 try
		 {
			 C1.removeAllItems();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select S_name from SupplierInfo";
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
            }*/
		
	 /* public void addCustomerName()
	 
	    {
		 try
		 {
			 C1.removeAllItems();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select * from Bank_Receipt";
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
            }*/
	   
		
	
	    public static void main(String args[])
		{
			new BankDateRpt();
		}
}		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			 		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			 