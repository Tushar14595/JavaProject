import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ParticularCustRpt extends JFrame implements ActionListener
{
	JLabel Lh,L1;
	JComboBox C1;
	JButton B1;
	ImageIcon img;
	JLabel l11;
	public ParticularCustRpt()
	{
		setLayout(null);
		
		
		L1=new JLabel("Select customer Name");
		C1=new JComboBox();
		B1=new JButton("Report");
		img=new ImageIcon("Img.jpg");
		l11=new JLabel(img);
		l11.setBounds(0,0,900,500);
		add(l11);
		L1.setBounds(50,150,200,30);
		C1.setBounds(270,150,100,30);
		B1.setBounds(100,200,100,30);
		
		  Lh=new JLabel("Particular Customer Report");
		  Font F=new Font("Times New Roman",Font.BOLD,20);
		  Lh.setFont(F);
		  Lh.setForeground(Color.red);
	      Lh.setBounds(50,50,200,40);
		  add(Lh);
		l11.add(L1);
	    l11.add(C1);
		l11.add(B1);
		
		 addCustomerName();
		setTitle(" Particular Customer Report");
		//setVisible(true);
		setVisible(true);
		setSize(900,500);
		setLocation(200,100);
		B1.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		JButton B=(JButton)e.getSource();
		if(B==B1)
		{
		String str=(String)C1.getSelectedItem();
		String[][]a=new String[1][13];
		String h[]={"ID","Name","Address","con_No","Email ID","Credit_limit"};
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
            Statement  st=cn.createStatement();
            String sql="select * from Customer_Info where Cust_Name='"+str+"'";
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
			  
			  l11.add(ob);
			  //add(L2);
			  cn.close();
		   }
		 catch(Exception x)
		 {
		   JOptionPane.showMessageDialog(null,x);
		 }
		 
		 setLocationRelativeTo(null);
		 setSize(900,500); 
	    }
	}
	 
	     public void addCustomerName()
	 
	    {
		 try
		 {
			 C1.removeAllItems();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select Cust_Name from Customer_Info";
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
			new ParticularCustRpt();
		}
}		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  