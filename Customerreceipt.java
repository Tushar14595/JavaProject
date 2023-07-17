import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customerreceipt extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1;
    JLabel lI;
	ImageIcon img;
	JButton b1,b2,b3;
	
	public Customerreceipt()
	{
		
		
		setLayout(null);
		img=new ImageIcon("Pencils.png");
		lI=new JLabel(img);
		lI.setBounds(0,0,1920,1080);
		 add(lI);
		l1=new JLabel("Date");
		l2=new JLabel("Transcation Id");
		l3=new JLabel("Customer Name");
		l4=new JLabel("Current Balance");
		l5=new JLabel("Recived Cash");
		l6=new JLabel("Balance ");
		l7=new JLabel("Description");
		l8=new JLabel("Customer Ledger");
	
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		c1=new JComboBox();
		b1=new JButton("Receipt");
		b2=new JButton("Add");
		b3=new JButton("Exit");
		
		l1.setBounds(250,250,150,30);
		l2.setBounds(250,300,150,30);
		l3.setBounds(250,350,150,30);
		
		
		l4.setBounds(630,250,150,30);
		l5.setBounds(630,300,150,30);
		l6.setBounds(630,350,150,30);
		
		
		l7.setBounds(480,420,150,30);
		
		
		l8.setBounds(420,100,500,100);//Heading
		
		t1.setBounds(400,250,150,30);
		t2.setBounds(400,300,150,30);
		c1.setBounds(400,350,150,30);
		
		t3.setBounds(800,250,150,30);
		t4.setBounds(800,300,150,30);
		t5.setBounds(800,350,150,30);
		
		t6.setBounds(560,400,190,60);
		
		
		
		
		b2.setBounds(465,480,100,30);//add
		b1.setBounds(580,480,100,30);//Receipt
		b3.setBounds(700,480,100,30);//exit   
		
		
		
		lI.add(l1);
		lI.add(b3);
		lI.add(l2);
		lI.add(l3);
		lI.add(l4);
		lI.add(l5);
		lI.add(l6);
		lI.add(l7);
		lI.add(l8);
		lI.add(t1);
		lI.add(t2);
		lI.add(t3);
		lI.add(t4);
		lI.add(t5);
		lI.add(t6);
		lI.add(c1);
		lI.add(b1);
		lI.add(b2);
		
		setSize(1440,900);
		 setTitle("Customer Receipt");
		 setLocationRelativeTo(null);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		c1.addItemListener(this);
		formload();
		
		Font f=new Font("Times New Roman",Font.BOLD,35);
                                  l8.setFont(f);
                                  l8.setForeground(Color.red);
		
		
	t1.setForeground(Color.black);
 t2.setForeground(Color.blue);
 t3.setForeground(Color.blue);
 t4.setForeground(Color.blue);
 t5.setForeground(Color.blue);
 t6.setForeground(Color.blue);
 
  Font Fl=new Font("Comic Sans MS",Font.BOLD,14);
 l1.setFont(Fl);
 l2.setFont(Fl);
 l3.setFont(Fl);
 l4.setFont(Fl);
 l5.setFont(Fl);
 l6.setFont(Fl);
 l7.setFont(Fl);
 //l8.setFont(Fl);
 t1.setFont(Fl);
 t2.setFont(Fl);
 t3.setFont(Fl);
 t4.setFont(Fl);
 t5.setFont(Fl);
 t6.setFont(Fl);	
		
	}
	public void itemStateChanged(ItemEvent ie)
	{
		  JComboBox c=(JComboBox)ie.getSource();
		  if(c==c1)
		  {
			  getdata();
		  }
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton B=(JButton)e.getSource();
		if(B==b2)
		{
			try
			{
				           addCustomerName();
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										
                    Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                    Statement  st=cn.createStatement();
                                           String sql="select max(T_ID) from Cust_receipt";
                                         ResultSet rs=st.executeQuery(sql);
										 rs.next();
										
                                     int n=rs.getInt(1);
											addbutton();
                                            
                                     n=n+1;
                                    t2.setText(Integer.toString(n));
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
		}
		
		if(B==b1)
		{
			try
			{
			 int cb,rc,bal;
             cb=Integer.parseInt(t3.getText());
             rc=Integer.parseInt(t4.getText());	
             bal=cb-rc;
             t5.setText(Integer.toString(bal));
             int x=0;
            String  str=(String)c1.getSelectedItem();
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										
              Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
              Statement  st=cn.createStatement();	
             String sql="insert into Cust_receipt values ('"+t1.getText()+"',"+t2.getText() + ",'"+str+"',"+ x +","+t4.getText()+","+t5.getText()+",'"+t6.getText()+"')";
             		int k =st.executeUpdate(sql);
                     if(k>0)
					 {
                        JOptionPane.showMessageDialog(null,"Trancation Completed");  
						t1.setText("");
						t2.setText("");
						t3.setText("");
						c1.removeAllItems();
						t4.setText("");
						t5.setText("");
						t6.setText("");
					 }		
						cn.close();
				
		    }
			catch(Exception qw)
			{
				  JOptionPane.showMessageDialog(null,qw);
			}
		
	    }
		
				if(b3==B)
					{
				//getdata();
	
				this.setVisible(false);
				new MDI();
		
		}
	}
	public void addCustomerName()
	  {
		 try
		 {
			 c1.removeAllItems();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select Cust_Name from Customer_Info";
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
	public void getdata()
{
	  try
	  {
		 
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			     Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement();
		   String str=(String)c1.getSelectedItem();
		   String sql="select max(T_ID) from Cust_receipt where C_Name='"+ str + "'";
		  // System.out.println(sql);
		   ResultSet rs=st.executeQuery(sql);
                rs.next();
				int n=rs.getInt(1);
				
				//System.out.println("getData" + tid1);
				String sql1="Select Balance from Cust_receipt where T_ID="+ n;
				 ResultSet rs1=st.executeQuery(sql1);
				rs1.next();
				t3.setText(rs1.getString(1));
				cn.close();
	  }
	  catch(Exception qa)
	  {
		   JOptionPane.showMessageDialog(null,qa);
	  }
	  
}
public void formload()
{
	t1.setEnabled(false);
	b1.setEnabled(false);
	b2.setEnabled(true);
	t2.setEnabled(false);
c1.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);
		t6.setEnabled(false);
}
void addbutton()
{
	    t1.setEnabled(true);
		//t3.setEnabled(true);
		t4.setEnabled(true);
		//t5.setEnabled(true);
		t6.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(false);
		c1.setEnabled(true);
       // B6.setEnabled(true);
}
	public static void main (String[]args)
	{
		new Customerreceipt();
	}
}