import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Purchasebill extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l8,l16,l17;
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1;
	JButton B1,B2,B3,B6,B7;
    JLabel li;
	ImageIcon img;
	int tid1;
	public Purchasebill()
	{
		setLayout(null);
        
        img=new ImageIcon("Customer(1).png");
		li=new JLabel(img);
		li.setBounds(0,0,1440,900);
		 add(li);
        
        
		l1=new JLabel("P Id");
		l2=new JLabel("Bill No");
		l3=new JLabel("Bill Amt");
		l4=new JLabel("Paid Amt");
		l5=new JLabel("Balance");
		l6=new JLabel("Supplier Name");
		//l7=new JLabel("date");
                                    l8=new JLabel("Purchase Bill");
		l16=new JLabel("Prev.Balance");
		l17=new JLabel("0");
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		//t6=new JTextField();
		//t7=new JTextField();
		//t8=new JTextField();
		//t9=new JTextField();
		
		c1= new JComboBox();
		
		B1=new JButton("Add");
		B2=new JButton("Save");
		B3=new JButton("Search");
		//B4=new JButton("Update");
		//B5=new JButton("Delete");
		B6=new JButton ("Clear");
		B7=new JButton("Exit");
	
		l1.setBounds(300,300,150,30);
		l2.setBounds(300,400,150,30);
		
		l3.setBounds(700,300,150,30);
		l4.setBounds(700,350,150,30);
		l5.setBounds(700,400,150,30);
        l6.setBounds(300,350,150,30);
		//l7.setBounds(320,150,100,30);
        l8.setBounds(520,160,500,100);

		t1.setBounds(400,300,220,30);
		//c1.setBounds(800,350,220,30);
		c1.setBounds(400,350,220,30);
	    t2.setBounds(400,400,220,30);
		t3.setBounds(800,300,220,30);
		t4.setBounds(800,350,220,30);
		t5.setBounds(800,400,220,30);
//t6.setBounds(360,150,100,30);
		//t7.setBounds(320,250,100,30);
		//t8.setBounds(320,300,100,30);
		//t9.setBounds(320,350,100,30);
		
		
		
		
		B1.setBounds(460,475,80,30);
		B2.setBounds(560,475,80,30);
		B3.setBounds(660,475,80,30);
		B6.setBounds(760,475,80,30);
		B7.setBounds(860,475,80,30);
		
		
		l16.setBounds(880,180,100,30);
		l17.setBounds(900,220,150,30);
       
		
		li.add(l1);
		li.add(l2);
		li.add(l3);
		li.add(l4);
		li.add(l5);
		li.add(l6);
		//add(l7);
          li.add(l16);
		  li.add(l17);
		  li.add(l8);
		li.add(t1);
		li.add(t2);
		li.add(t3);
		li.add(t4);
		li.add(t5);
		//add(t6);
		//add(t7);
		//add(t8);
		//add(t9);
		li.add(c1);
		li.add(B1);
		li.add(B2);
		li.add(B3);
		//add(B4);
		//add(B5);
		li.add(B6);
		li.add(B7);
		
		
		setTitle("Purchase Bill");
		setSize(1440,900);
		setLocationRelativeTo(null);
		setVisible(true);

                                 Font f=new Font("Times New Roman",Font.BOLD,55);
                                  l8.setFont(f);
                                  l8.setForeground(Color.red);

                                      B1.addActionListener(this);
									  B2.addActionListener(this);
									 B3.addActionListener(this);
									//B4.addActionListener(this);                                   
								 //B5.addActionListener(this);                       
								 B7.addActionListener(this);        
								B6.addActionListener(this);
								c1.addItemListener(this);
								formload();
Font Fl=new Font("Comic Sans MS",Font.BOLD,14);
 l1.setFont(Fl);
 l2.setFont(Fl);
 l3.setFont(Fl);
 l4.setFont(Fl);
 l5.setFont(Fl);
 l6.setFont(Fl);
  //l7.setFont(Fl);
 // l8.setFont(Fl);
  
  
 t1.setForeground(Color.blue);
 t2.setForeground(Color.blue);
 t3.setForeground(Color.blue);
 t4.setForeground(Color.blue);
 t5.setForeground(Color.blue);
 c1.setForeground(Color.blue);
 //C2.setForeground(Color.blue);
 
 
 
 Font fl=new Font("Comic Sans MS",Font.BOLD,12);
 
 c1.setFont(fl);
 t2.setFont(fl);
 t3.setFont(fl);
 t4.setFont(fl);
 t5.setFont(fl);
 t1.setFont(fl);								
								
								
								
	}
                        public void actionPerformed(ActionEvent e)
                                   {
                                         
                                     JButton b=(JButton)e.getSource();
                                    if(B1==b)
                                 {
                                          try
                                        {
											addbutton();
                                              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                                          Statement  st=cn.createStatement();
                                           String sql="select max(P_ID) from Purchase_Bill";
                                         ResultSet rs=st.executeQuery(sql);
										 rs.next();
										
                                     int n=rs.getInt(1);
                                     n=n+1;
						
						
                                    t1.setText(Integer.toString(n));
									addSupplierName();
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  //JOptionPane.showMessageDialog(null,ea);
                              }
        }
		if(b==B2)
                      {
                         try
                          {
                                  int P_ID=Integer.parseInt(t1.getText());
                                  String Bill_No=t2.getText();
								   String Bill_Amount=t3.getText();
								    String Paid_Amountprice=t4.getText();
									 String Balance=t5.getText();
									   String S_name=c1.getSelectedItem().toString();
									//   String P_Date=t7.getText();
									   
                             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
	        String sql="Insert into Purchase_Bill values(?,?,?,?,?,?)";
	          PreparedStatement ps=cn1.prepareStatement(sql);
                              ps.setInt(1,P_ID);
							ps.setString(2,Bill_No);
                            ps.setString(3,Bill_Amount);
                            ps.setString(4,Paid_Amountprice);
                           ps.setString(5,Balance);
                          ps.setString(6,S_name);
						 // ps.setString(7,P_Date);
						 int x=Integer.parseInt(t3.getText())-Integer.parseInt(t4.getText());
							t5.setText(Integer.toString(x));
				 int k=ps.executeUpdate();
				 if(k>0)
                 {  
			        addpayment();
                  JOptionPane.showMessageDialog(null,"Record Saved");
				 formload();
                   cn1.close();
				  }
					}
                      catch(Exception ea1)
                      {
                          JOptionPane.showMessageDialog(null,ea1);
						}
					  }

                    if(b==B3)
							  {
                              this.setVisible(false);
								    new SearchPurchaseBill();
							  }
							  if(b==B6)
							  {
								  formload();
							  }
							  if(B7==b)
{
	//getdata();
	
this.setVisible(false);
	new MDI();
}
     }
	  public void itemStateChanged(ItemEvent ei)
	 {
		 JComboBox c=(JComboBox)ei.getSource();
		 
			 if(c==c1)
			 {
				 String str=(String)c1.getSelectedItem();
				// System.out.println(str);
				 try
				 {
					  getdata();
					/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					 Connection cn1=DriverManager.getConnection("jdbc:odbc:Custbill");
					 Statement st1=cn1.createStatement();
					 String sql1="select Cust_Address,Con_No from Customer_Info where Cust_Name='"+ str+"'";
					// System.out.println(sql1);
					 ResultSet rs1=st1.executeQuery(sql1);
					rs1.next();
					//t3.setText(rs1.getString(1));
					//t5.setText(rs1.getString(2));
					cn1.close();*/
					 
				 }
					 
				catch(Exception e)
				{
                      //JOptionPane.showMessageDialog(null,e);
				}
			 }
				
	 }
    
	 public void addSupplierName()
	 
	 
	 {
		 try
		 {
			 c1.removeAllItems();
						c1.addItem("");
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn2=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn2.createStatement();
			String sql="select S_name from SupplierInfo";
			ResultSet rs=st.executeQuery(sql);
										while(rs.next())
										{
											c1.addItem(rs.getString(1));
										}
                                      cn2.close();
                                   }
                        catch(Exception ea1)
                           {
                                //JOptionPane.showMessageDialog(null,ea1);
                              }
							  
	}
	 void formload()
{
	t1.setEnabled(false);
	t2.setEnabled(false);
	t3.setEnabled(false);
	t4.setEnabled(false);
	t5.setEnabled(false);
	//t6.setEnabled(false);
	//t7.setEnabled(false);
	//t8.setEnabled(false);
	//t9.setEnabled(false);
	c1.removeAllItems();
	//t10.setEnabled(false);
	//t11.setEnabled(false);
	//t12.setEnabled(true);
	//t13.setEnabled(false);
	//t14.setEnabled(false);
//	t15.setEnabled(true);
	//t16.setEnabled(false);
	c1.setEnabled(false);
	//C2.setEnabled(false);
	B2.setEnabled(false);
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	//t6.setText("");
	//t7.setText("");
	//t8.setText("");
	//t9.setText("");
	//t10.setText("");
	//t11.setText("");
	//t12.setText("");
	//t13.setText("");
	//t14.setText("");
	//t15.setText("");
	//t16.setText("");
	
	//li1.setText("");
	//li2.setText("");
	//li3.setText("");
	//li4.setText("");
	//li5.setText("");
	B1.setEnabled(true);
	B3.setEnabled(true);
	//B4.setEnabled(true);
	//B5.setEnabled(true);
}
void addbutton()
{
	
	    t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		//t5.setEnabled(true);
		//t6.setEnabled(true);
		//t7.setEnabled(true);
		//t8.setEnabled(true);
		//t9.setEnabled(true);
		B1.setEnabled(false);
		B2.setEnabled(true);
		//B.setEnabled(true);
		B3.setEnabled(true);
		//B4.setEnabled(true);
		//B5.setEnabled(true);
		B6.setEnabled(true);
		c1.setEnabled(true);
		//C2.setEnabled(true);
}
     
	 public void getdata()
{
	  try
	  {
		 
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			     Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement();
		   String str=(String)c1.getSelectedItem();
		   String sql="select max(T_ID) from Supplier_Receipt where S_name='"+ str + "'";
		  // System.out.println(sql);
		   ResultSet rs=st.executeQuery(sql);
                rs.next();
				int n=rs.getInt(1);
				tid1=n+1;
				//System.out.println("getData" + tid1);
				String sql1="Select Balance from Cust_receipt where T_ID="+ n;
				 ResultSet rs1=st.executeQuery(sql1);
				rs1.next();
				l17.setText(rs1.getString(1));
				cn.close();
	  }
	  catch(Exception ep)
	  {
		  //JOptionPane.showMessageDialog(null,ep);
	  }
}

 public void addpayment()
	 {
		 getdata();
		 int PBAL,TA,PA,CBAL;
		 PBAL=Integer.parseInt(l17.getText());
		 TA=Integer.parseInt(t3.getText());
		 PA=Integer.parseInt(t4.getText());
		 CBAL=(PBAL+TA)-PA;
		 //int T_ID=0;
		 //System.out.println("Addpayment" + tid1);
		 try
		 {
			 String str="Again BIll_No"+t2.getText();
			 String str2=(String)c1.getSelectedItem();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			     Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement(); 
			String sql="insert into Supplier_receipt values('" + t2.getText() + "',"+ tid1 +",'"+ str2 +"',"+ (PBAL + TA) +","+ PA +","+ CBAL +",'"+ str +"')"; 
		    /*  ResultSet rs=st.executeQuery(sql);
				rs.next();
				l17.setText(rs.getString(1));*/
				int k =st.executeUpdate(sql);
				
				cn.close();
		 }
		 catch(Exception et)
		 {
			 //JOptionPane.showMessageDialog(null,et);
		 }
	 }
	


	public static void main(String args[])
	{
		new Purchasebill();
	}
}
		
		
		
		
		
		
		
		
		
	
		
		
	
	