import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ParticularProductRpt extends JFrame implements ActionListener
{
	JLabel Lh,L1;
	JComboBox C1;
	JButton B1;
	
	public ParticularProductRpt()
	{
		setLayout(null);
		
		
		L1=new JLabel("Select Product Name");
		C1=new JComboBox();
		B1=new JButton("Report");
		
		L1.setBounds(50,150,200,30);
		C1.setBounds(270,150,100,30);
		B1.setBounds(100,200,100,30);
		
		  Lh=new JLabel("Particular Product Report");
		  Lh.setFont(new Font("Times New Roman",Font.BOLD,20));
	      Lh.setBounds(50,50,200,40);
		  add(Lh);
		add(L1);
		add(C1);
		add(B1);
		
		 addProductName();
		
		setVisible(true);
		setSize(700,500);
		B1.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		JButton B=(JButton)e.getSource();
		if(B==B1)
		{
		String str=(String)C1.getSelectedItem();
		String[][]a=new String[1][6];
		String h[]={"PID","PType","P_name","Price","Quantity","S_Name"};
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
            Statement  st=cn.createStatement();
            String sql="select * from Product_Details where P_name='"+str+"'";
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
			  
			 // i++;
			}
			  //JLabel L2=new JLabel("");
			  JTable obj=new JTable(a,h);
			  JScrollPane ob=new JScrollPane(obj);
			  ob.setBounds(50,300,600,100);
			 // L2.setBounds(100,100,0,0);
			  
			  add(ob);
			  //add(L2);
			  cn.close();
		   }
		 catch(Exception x)
		 {
		   JOptionPane.showMessageDialog(null,x);
		 }
		 setTitle(" Particular Product Report");
		 setVisible(true);
		 //setLocation(150,50);
		 setLocationRelativeTo(null);
		 setSize(700,500); 
	    }
	}
	 
	     public void addProductName()
	 
	    {
		 try
		 {
			 C1.removeAllItems();
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
	   
	
	    public static void main(String args[])
		{
			new ParticularProductRpt();
		}
}		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			 