import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Custbill extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	JTextField t2,t3,t4,t5,t11,t12,t13,t14,t15,t16;
    JLabel lI;
	ImageIcon img;
	JComboBox C1,C2;
	JButton B1,B2,B3,B6,B7,B8;
	List li1,li2,li3,li4,li5;
	static int k;
	int total,tid1;
	String na[]=new String[5];;
	int qty[]=new int[5];;
	int rate[]=new int[5];;
	int amount[]=new int[5];
	int sno[]=new int[5];
	public Custbill()
	{
		setLayout(null);
		total=0;
        img=new ImageIcon("Stationary3.png");
		lI=new JLabel(img);
		lI.setBounds(0,0,1440,900);
		 add(lI);
        
		l1=new JLabel("Bill no");
		l2=new JLabel("Date");
		l3=new JLabel("Customer Name");
		l4=new JLabel("Address");
		l5=new JLabel("Contact No.");
		l6=new JLabel("Product Name");
		// list Box Label Start
		l7=new JLabel("Sr.no");
		l8=new JLabel("P_Name");
		l9=new JLabel("Qty");
		l10=new JLabel("Rate");
		l11=new JLabel("Amount");
		// End
		l12= new JLabel("Total Amount");
		l13=new JLabel("paid Amount");
		l14=new JLabel("Balance");
		l15= new JLabel("Customer Bill");
		l16=new JLabel("Prev.Balance");
		l17=new JLabel("0");
		
		//t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		//t6=new JTextField();
		//t7=new JTextField();
		//t8=new JTextField();
		//t9=new JTextField();
		//t10=new JTextField();
		t11=new JTextField();
		t12=new JTextField();
		t13= new JTextField();
		//t14= new JTextField();
		//t15= new JTextField();
		//t16= new JTextField();
		C1=new JComboBox();
		C2=new JComboBox();
		B1=new JButton("New");
		B2=new JButton("Save");
		B3=new JButton("Search");
		//B4=new JButton("Update");
		//B5=new JButton("Delete");
		B6=new JButton("Clear");
		B7=new JButton("Exit");
		B8=new JButton("Add");
		li1=new List();
		li2=new List();
		li3=new List();
		li4=new List();
		li5=new List();

		
		l1.setBounds(290,270,150,30);
		l2.setBounds(490,270,150,30);
		l3.setBounds(280,320,150,30);
		l4.setBounds(290,420,150,30);
		l5.setBounds(290,470,150,30);
		
        l6.setBounds(690,280,150,30);
		
		
	    l7.setBounds(650,350,100,30);
        l8.setBounds(750,350,100,30);
        l9.setBounds(850,350,100,30);
        l10.setBounds(950,350,100,30);	
        l11.setBounds(1050,350,100,30);
		
		
        l12.setBounds(525,520,100,30);
		l13.setBounds(635,520,100,30);
		l14.setBounds(745,520,100,30);
		
		
		l15.setBounds(550,100,1000,100);
		l16.setBounds(290,370,100,30);
		l17.setBounds(450,370,150,30);
       		
		t4.setBounds(380,270,100,30);
		t2.setBounds(520,270,100,30);
		C2.setBounds(380,320,240,30);
		t3.setBounds(380,420,240,30);
		t5.setBounds(380,470,240,30);
		//t6.setBounds(30,450,80,100);
		
		
 		li1.setBounds(650,385,80,100);
		li2.setBounds(750,385,80,100);
		li3.setBounds(850,385,80,100);
		li4.setBounds(950,385,80,100);
	    li5.setBounds(1050,385,80,100);
		
		
		t11.setBounds(525,570,100,30);
		t12.setBounds(635,570,100,30);
		t13.setBounds(745,570,100,30);
		
		//t14.setBounds(610,150,100,30);
		//t15.setBounds(610,200,100,30);
		//t16.setBounds(610,250,100,30);
		
		
		C1.setBounds(790,280,240,30);
		
		
		B1.setBounds(450,620,80,30);
		B2.setBounds(550,620,80,30);
		B3.setBounds(650,620,80,30);
		//B4.setBounds(325,600,80,30);
		//B5.setBounds(425,600,80,30);
		B6.setBounds(750,620,80,30);
		B7.setBounds(850,620,80,30);
		
		
		
		B8.setBounds(1050,280,80,30);
                                  
       lI.add(li1);
 		lI.add(li2);
 		lI.add(li3);
 		lI.add(li4);
		 lI.add(li5);

		
		lI.add(l1);
		lI.add(l2);
		lI.add(l3);
		lI.add(l4);
		lI.add(l5);
        lI.add(l6);
		lI.add(l7);
		lI.add(l8);
		lI.add(l9);
		lI.add(l10);
		lI.add(l11);
		lI.add(l12);
		lI.add(l13);
		lI.add(l14);
		lI.add(l15);
	    lI.add(l16);
		lI.add(l17);
		lI.add(C2);
		//add(t1);
		lI.add(t2);
		lI.add(t3);
		lI.add(t4);
		lI.add(t5);
		//add(t6);
		lI.add(B8);
		//add(t7);
		//add(t8);
		//add(t9);
		//add(t10);
		lI.add(t11);
		lI.add(t12);
		lI.add(t13);
		//add(t14);
		//add(t15);
		//add(t16);
		lI.add(C1);
		lI.add(B1);
		lI.add(B2);
		lI.add(B3);
		//add(B4);
		//add(B5);
		lI.add(B6);
        lI.add(B7);
                            /* C1.addItem("@Gmail.com");
                             C1.addItem("@Ymail.com");
                            C1.addItem("@Orkut.com");
                             C1.addItem("@Rediff.com");*/
	  	//t1.setEnabled(false);
		//t2.setEnabled(false);
		//t3.setEnabled(false);
		//t4.setEnabled(false);
		//t5.setEnabled(false);
		
      		

		setSize(1440,900);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Custbill");
                                 Font f=new Font("Times New Roman",Font.ITALIC,55);
								 Font f1=new Font("Arial",Font.ITALIC,20);
                                  l15.setFont(f);
                                  l15.setForeground(Color.red);
								  Font f2=new Font("Arial",Font.BOLD,10);
								  //l16.setFont(f2);
								  
								  //l16.setForeground(Color.black);
								  l17.setFont(f1);
								  l17.setForeground(Color.red);
	
	Font Fl=new Font("Comic Sans MS",Font.BOLD,12);
 /*l1.setFont(Fl);
 l2.setFont(Fl);
 l3.setFont(Fl);
 l4.setFont(Fl);
 l5.setFont(Fl);
 //L6.setFont(Fl);
 l7.setFont(Fl);*/
 t2.setForeground(Color.blue);
 t3.setForeground(Color.blue);
 t4.setForeground(Color.blue);
 t5.setForeground(Color.blue);
 C1.setForeground(Color.blue);
 C2.setForeground(Color.blue);
 
 C1.setFont(Fl);
 t2.setFont(Fl);
 t3.setFont(Fl);
 t4.setFont(Fl);
 t5.setFont(Fl);
 C2.setFont(Fl);
	
	
	
	B1.addActionListener(this);
	B2.addActionListener(this);
	B3.addActionListener(this);
	//B4.addActionListener(this);
	//B5.addActionListener(this);
	B6.addActionListener(this);
	C2.addItemListener(this);
	B7.addActionListener(this);
	B8.addActionListener(this);
	formload();
	for(int i=0;i<5;i++)
	{
		  na[i]="";
	} 
	}
                        public void actionPerformed(ActionEvent e)
                                   {
                                         //Connection cn;
                                          //Statement st;
                                     JButton B=(JButton)e.getSource();
    
                                    if(B1==B)
										
                                 {
									 
                                          try
                                        {
											C2.removeAllItems();
											C1.removeAllItems();
											addbutton();
                                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                                            Statement  st=cn.createStatement();
                                            String sql="select max(Bill_no) from Customer_Bill";
                                            ResultSet rs=st.executeQuery(sql);
										    rs.next();
										    int n=rs.getInt(1);
                                            n=n+1;
                                           t4.setText(Integer.toString(n));
									    addCustomerName();
									addProductName();
									t11.setText("0");
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  //JOptionPane.showMessageDialog(null,ea);
                              }
        }
		if(B2==B)
		{
			try
			{
							//	int no.=Integer.parseInt(t2.getText());
								//String Sname=C2.getSelectedItem().toString();
                                
                                 
                             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                         Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
	                        String sql="Insert into Customer_Bill values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			                PreparedStatement ps=cn1.prepareStatement(sql);
			                ps.setInt(1,Integer.parseInt(t4.getText()));
							ps.setString(2,t2.getText());
							ps.setString(3,(String)C2.getSelectedItem());
							ps.setString(4,t3.getText());
							ps.setString(5,t5.getText());
							int h=0;
							for (int i=6;i<=10;i++)
							{
							ps.setString(i,Integer.toString(sno[h]));
							  h++;
							
							}
							h=0;
							for(int i=11;i<=15;i++)
							{
								ps.setString(i,na[h]);
								h++;
							}
							h=0;
							for(int i=16;i<=20;i++)
							{
			                    
							  ps.setString(i,Integer.toString(qty[h]));
							  h++;
							
		                    }
							h=0;
							for(int i=21;i<=25;i++)
							{
			                    
							  ps.setString(i,Integer.toString(rate[h]));
							  h++;
							
							}
							h=0;
							for(int i=26;i<=30;i++)
							{
			                    
							  ps.setString(i,Integer.toString(amount[h]));
							  h++;
							
							}		
							ps.setString(31,t11.getText());
							ps.setString(32,t12.getText());
							
							int x=Integer.parseInt(t11.getText())-Integer.parseInt(t12.getText());
							t13.setText(Integer.toString(x));
							ps.setString(33,Integer.toString(x));
							//JOptionPane.showMessageDialog(null,sql);
                             int k=ps.executeUpdate();
				             if(k>0)
                               {
                                   JOptionPane.showMessageDialog(null,"Record Saved");
								   addpayment();
								   C1.removeAllItems();
								   C2.removeAllItems();
				                    formload();
		
                                   cn1.close();
								   
				                }
							
							}
						catch(Exception er)
						{
							//JOptionPane.showMessageDialog(null,er);
						}
		}
					  if(B6==B)
					  {
						  formload();
					  }
					  if(B7==B)
{
	//getdata();
	
this.setVisible(false);
	new MDI();
}
					  if(B3==B)
					  {
                      this.setVisible(false);
						  new SearchCustBill();
					  } 
					  if(B==B8)
					  {
						  String str=(String)C1.getSelectedItem();
						 // System.out.println(str);
						   try{
							     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					            Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
							 	Statement st1=cn1.createStatement();
					            String sql="select price from Product_Details where P_name='" + str + "'";
								ResultSet rs=st1.executeQuery(sql);
								rs.next();
								int t=rs.getInt(1);
								sno[k]=k+1;
								
								li1.addItem(Integer.toString(k+1));
								li2.addItem(str);
								na[k]=str;
								int q=Integer.parseInt(JOptionPane.showInputDialog("Enter Qty="));
								qty[k]=q;
								li3.addItem(Integer.toString(q));
								li4.addItem(Integer.toString(t));
								int r=q*t;
								li5.addItem(Integer.toString(r));
								rate[k]=t;
								amount[k]=r;
								total=Integer.parseInt(t11.getText());
							//	System.out.println(total);
								total=total+r;
								t11.setText(""+Integer.toString(total));
								k++;
								//JOptionPane.showMessageDialog(null,t);
								cn1.close();
						      }
							catch(Exception n10)
							{
						        //JOptionPane.showMessageDialog(null,n10);
							}
						  
					  }
					  
		


     }
	 public void itemStateChanged(ItemEvent ei)
	 {
		 JComboBox c=(JComboBox)ei.getSource();
		 
			 if(c==C2)
			 {
				 String str=(String)C2.getSelectedItem();
				// System.out.println(str);
				 try
				 {
					  getdata();
					 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					 Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
					 Statement st1=cn1.createStatement();
					 String sql1="select Cust_Address,Con_No from Customer_Info where Cust_Name='"+ str+"'";
					// System.out.println(sql1);
					 ResultSet rs1=st1.executeQuery(sql1);
					rs1.next();
					t3.setText(rs1.getString(1));
					t5.setText(rs1.getString(2));
					cn1.close();
					 
				 }
					 
				catch(Exception e)
				{
                   // JOptionPane.showMessageDialog(null,e);
				}
			 }
				
	 }
          /*  JComboBox c1=(JComboBox)ei.getSource();
		 
			 if(c1==C1)
			 {
				 String str=(String)C1.getSelectedItem();
				// System.out.println(str);
				 try
				 {
					 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					 Connection cn2=DriverManager.getConnection("jdbc:odbc:Custbill");
					 Statement st2=cn2.createStatement();
					 String sql2="select Supplier_name,P_name,Quantity from  Product_Details where ='"+ str+"'";
					// System.out.println(sql1);
					 ResultSet rs2=st2.executeQuery(sql1);
					rs1.next();
					t3.setText(rs2.getString(1));
					t5.setText(rs2.getString(2));
					cn1.close();
					 
				 }
					 
				catch(Exception e)
				{
                      System.out.println(e);
				}
			 }*/
	 
					 
					 

					 
					 
	 public void addCustomerName()
	 
	 
	 {
		 try
		 {
			 C2.removeAllItems();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
             Statement  st=cn.createStatement();
			String sql="select Cust_Name from Customer_Info";
			ResultSet rs=st.executeQuery(sql);
										while(rs.next())
										{
											C2.addItem(rs.getString(1));
										}
                                      cn.close();
                                   }
                        catch(Exception ea1)
                           {
                                  //JOptionPane.showMessageDialog(null,ea1);
                              }
	}		
	 public void addProductName()
	 {
		 try
		 {
			 C1.removeAllItems();
						//C1.addItem("");
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
                                 // JOptionPane.showMessageDialog(null,ea1);
                              }
	}		
  void formload()
{
	//t1.setEnabled(false);
	t2.setEnabled(false);
	t3.setEnabled(false);
	t4.setEnabled(false);
	t5.setEnabled(false);
	//t6.setEnabled(false);
	//t7.setEnabled(false);
	//t8.setEnabled(false);
	//t9.setEnabled(false);
	//t10.setEnabled(false);
	t11.setEnabled(false);
	//li1.removeAllElements();
	t12.setEnabled(false);
	t13.setEnabled(false);
	//t14.setEnabled(false);
	//t15.setEnabled(true);
//	t16.setEnabled(false);
	C1.setEnabled(false);
	C2.setEnabled(false);
	B2.setEnabled(false);
	//t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	//t6.setText("");
	//t7.setText("");
	//t8.setText("");
	//t9.setText("");
	//t10.setText("");
	t11.setText("");
	t12.setText("");
	t13.setText("");
	//t14.setText("");
	//t15.setText("");
	//t16.setText("");
	
	li1.removeAll();
	li2.removeAll();
	li3.removeAll();
	li4.removeAll();
	li5.removeAll();
	//li2.setText("");
	//li3.setText("");
	//li4.setText("");
	//li5.setText("");
	B1.setEnabled(true);
	B3.setEnabled(true);
	B8.setVisible(false);
	//B4.setEnabled(false);
	//B5.setEnabled(false);
}
void addbutton()
{
	
	    t2.setEnabled(true);
		t3.setEnabled(false);
		//t4.setEnabled(true);
		t5.setEnabled(false);
		//t6.setEnabled(true);
		B1.setEnabled(false);
		B2.setEnabled(true);
		t12.setEnabled(true);
	
		B3.setEnabled(false);
		//B4.setEnabled(true);
		B8.setVisible(true);
		B6.setEnabled(true);
		C1.setEnabled(true);
		C2.setEnabled(true);
}	
		 
public void getdata()
{
	  try
	  {
		 
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			     Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement();
		   String str=(String)C2.getSelectedItem();
		   String sql="select max(T_ID) from Cust_receipt where C_Name='"+ str + "'";
		   //System.out.println(sql);
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
		 // JOptionPane.showMessageDialog(null,ep);
	  }
}
				
	 public void addpayment()
	 {
		 getdata();
		 int PBAL,TA,PA,CBAL;
		 //System.out.println(tid1);
		 PBAL=Integer.parseInt(l17.getText());
		 TA=Integer.parseInt(t11.getText());
		 PA=Integer.parseInt(t12.getText());
		 CBAL=(PBAL+TA)-PA;
		 //int T_ID=0;
		 //System.out.println("Addpayment" + tid1);
		 try
		 {
			 String str="Again BIll_No"+t4.getText();
			 String str2=(String)C2.getSelectedItem();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			     Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement(); 
			String sql="insert into Cust_receipt values('" + t2.getText() + "',"+ tid1 +",'"+ str2 +"',"+ (PBAL + TA) +","+ PA +","+ CBAL +",'"+ str +"')"; 
		    /*  ResultSet rs=st.executeQuery(sql);
				rs.next();
				l17.setText(rs.getString(1));*/
				int k =st.executeUpdate(sql);
				
				cn.close();
		 }
		 catch(Exception et)
		 {
			// JOptionPane.showMessageDialog(null,et);
		 }
	 }
		public static void main(String args[])
	
	{
			new Custbill();
		}
}