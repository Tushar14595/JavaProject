import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SearchEmployee extends JFrame implements ItemListener,ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox  C1;
	CheckboxGroup cg;
	Checkbox r1,r2;
    JLabel lI;
	ImageIcon img;
	JButton b1,b2,b3,b4;
  public SearchEmployee()
    {
	     setLayout(null);
         
         img=new ImageIcon("Search.png");
		lI=new JLabel(img);
		lI.setBounds(0,0,1432,912);
		 add(lI);
		cg=new CheckboxGroup();
		l1=new JLabel("Employee Id");
		l2=new JLabel("Employee name");
		l3=new JLabel("Employee Address");
		l4=new JLabel("Contact no.");
		l5=new JLabel("Email Id");
		l6=new JLabel("Employee Search Record");
		l7=new JLabel("Salary");
		cg=new CheckboxGroup();
		r1=new Checkbox("Search By Id",cg,false);
		r2=new Checkbox("Search By Name",cg,false);
		
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		C1=new JComboBox();
		b1=new JButton("Search");
		b2=new JButton("Update");
		b3=new JButton("Delete");
		b4=new JButton("Back");
		/*B4=new JButton("Update");
		B5=new JButton("Delete");
		B6=new JButton("Clear");
		B7=new JButton("Exit");*/
		
		l1.setBounds(50,320,150,30);
		l2.setBounds(50,370,150,30);
		l3.setBounds(50,420,150,30);
		l4.setBounds(630,320,150,30);
		l5.setBounds(630,370,150,30);
		l7.setBounds(630,420,150,30);
		
		
        l6.setBounds(370,40,500,100);
		
		
		
		t1.setBounds(200,320,240,30);
		t2.setBounds(200,370,240,30);
		t3.setBounds(200,420,240,80);
		
		t4.setBounds(780,320,240,30);
		t5.setBounds(780,370,240,30);
		t6.setBounds(780,420,240,30);
		
		
		r1.setBounds(220,220,100,80);
		r2.setBounds(360,220,200,80);
		
		C1.setBounds(520,230,200,30);
		
		
		b1.setBounds(740,230,100,30);
		
		
		b2.setBounds(370,550,100,30);
        b3.setBounds(500,550,100,30);
		b4.setBounds(630,550,100,30);
		//B2.setBounds(50,495,80,30);
		//B3.setBounds(180,495,80,30);
		//B4.setBounds(310,495,80,30);
		//B5.setBounds(50,555,80,30);
		//B6.setBounds(180,555,80,30);
		//B7.setBounds(310,555,80,30);
		
		lI.add(l1);
		lI.add(l2);
		lI.add(l3);
		lI.add(l4);
		lI.add(l5);
        lI.add(l6);
		lI.add(l7);
		lI.add(t1);
		lI.add(t6);
		lI.add(t2);
		lI.add(t3);
		lI.add(t4);
		lI.add(t5);
		lI.add(C1);
		lI.add(r1);
		lI.add(r2);
		lI.add(b1);
		lI.add(b2);
		lI.add(b3);
		lI.add(b4);
		//add(B1);
		//add(B2);
		//add(B3);
		//add(B4);
		//add(B5);
		//add(B6);
        //add(B7);
		
		
		
				
		                          Font f=new Font("Times New Roman",Font.BOLD,30);
                                  l6.setFont(f);
                                  l6.setForeground(Color.red);
                            /* C1.addItem("@Gmail.com");
                             C1.addItem("@Ymail.com");
                            C1.addItem("@Orkut.com");
                             C1.addItem("@Rediff.com");*/
							 setSize(1440,900);
							 setLocationRelativeTo(null);
							 //setLocation(300,70);
							 setVisible(true);
							 b1.addActionListener(this);
							 b2.addActionListener(this);
							 b3.addActionListener(this);
			      			 r1.addItemListener(this);
							 r2.addItemListener(this);
							 b4.addActionListener(this);
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
 //L6.setFont(Fl);
 l7.setFont(Fl);
 t1.setFont(Fl);
 t2.setFont(Fl);
 t3.setFont(Fl);
 t4.setFont(Fl);
 t5.setFont(Fl);
 t6.setFont(Fl);
 C1.setFont(Fl);
 
 t1.setEnabled(false);
	}
	
	
	
	public void itemStateChanged(ItemEvent e)
		{
			Boolean x=r1.getState();
			Boolean y=r2.getState();
			if(x==true) 
			{
				try
				{
					 C1.removeAllItems();
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
					Statement st=cn.createStatement();
					String sql="Select E_ID from Employee_Details";
					ResultSet rs=st.executeQuery(sql);
					  while(rs.next())
					  {
						  C1.addItem(rs.getString(1));
					  }
					   cn.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2);
				}
			}		
				
				if(y==true)
				{
					try
					{
						 C1.removeAllItems();
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
					Statement st1=cn1.createStatement();
					String sql1="Select E_name from Employee_Details";
					ResultSet rs1=st1.executeQuery(sql1);
					  while(rs1.next())
					  {
						  C1.addItem(rs1.getString(1));
					  }
					   cn1.close();
				    }
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null,e3);
				}
				
			 }
			
			}
			
			
			
			
			
		public void actionPerformed(ActionEvent ea)
		    {
				 String str=(String)C1.getSelectedItem();
				 Boolean x=r1.getState();
			     Boolean y=r2.getState();
				 
			  JButton B=(JButton)ea.getSource();	
			  if(B==b1)
			  {
				  if(x==true)
				  {
					  try
					  {
						  int n=Integer.parseInt(str);
						  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						  Connection cn2=DriverManager.getConnection("jdbc:odbc:Stationary");
						  Statement st2=cn2.createStatement();
						  String sql2="Select * from Employee_Details where E_ID="+n;
						 
						  ResultSet rs2=st2.executeQuery(sql2);
						  while(rs2.next())
						  {
							  t1.setText(Integer.toString(rs2.getInt(1)));
							  t2.setText(rs2.getString(2));
							  t3.setText(rs2.getString(3));
							  t4.setText(rs2.getString(4));
							  t5.setText(rs2.getString(5));
							  t6.setText(rs2.getString(6));
						  }
						  cn2.close();
					  }
						  catch(Exception e4)
						  {
							  JOptionPane.showMessageDialog(null,e4);
						  }
						  
					  }
				  
				  if(y==true)
				  {
					 try
					  {
					
						 // int n=Integer.parseInt(str);
						  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						  Connection cn3=DriverManager.getConnection("jdbc:odbc:Stationary");
						  String sql3="Select * from Employee_Details where E_name='"+str+"'";
			              Statement st3=cn3.createStatement();
						  ResultSet rs3=st3.executeQuery(sql3);
						  while(rs3.next())
						  {
							  t1.setText(rs3.getString(1));
							  t2.setText(rs3.getString(2));
							  t3.setText(rs3.getString(3));
							  t4.setText(rs3.getString(4));
							  t5.setText(rs3.getString(5));
							  t6.setText(rs3.getString(6));
						  }
						  cn3.close();
					  }  
						  catch(Exception e5)
						  {
							  JOptionPane.showMessageDialog(null,e5);
						  }
						  
					  } 
			  }  //b1 close
				  
				  
				  
				  
			//public void actionPerformed(ActionEvent eb)
			  //   {
					 
				//  JButton B=(JButton)eb.getSource();
				  
				  if(B==b3)
				  {
					  try
					  {
						  int n=Integer.parseInt(t1.getText());
						  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						  Connection cn4=DriverManager.getConnection("jdbc:odbc:Stationary");
						  String sql4="Delete from Employee_Details where E_ID="+n;
						  Statement st4=cn4.createStatement();
						  
						   
						   //ResultSet rs4=st4.executeQuery(sql4);
                           int k = st4.executeUpdate(sql4);
						   
						  if(k>0)
						  {
							  JOptionPane.showMessageDialog(null,"Record Deleted");
							  t1.setText("");
								t2.setText("");
								t3.setText("");
								t4.setText("");
								t5.setText("");
								t6.setText("");
						  }
						  cn4.close();
					  }
				  
					  catch(Exception e6)
					  {
						JOptionPane.showMessageDialog(null,e6);  
					  }
				  } 
				  
                        if(B==b2)
						{
								 
							try
							{
								  // String address=t3.getText();
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						        Connection cn4=DriverManager.getConnection("jdbc:odbc:Stationary");
						        String sql4="Update Employee_Details set E_name=? ,E_Address=?,contact_No=?,Email_ID=?,Salary=? where E_ID=?";
						        
								PreparedStatement ps=cn4.prepareStatement(sql4);
								//JOptionPane.showMessageDialog(null,address);
								ps.setString(1,t2.getText());
								ps.setString(2,t3.getText());
								ps.setString(3,t4.getText());
							    ps.setString(4,t5.getText());
							   ps.setString(5,t6.getText());
								ps.setInt(6,Integer.parseInt(t1.getText()));
								int k = ps.executeUpdate();
								//JOptionPane.showMessageDialog(null,t3.getText());
								if(k>0)
								{
									JOptionPane.showMessageDialog(null,"Record Updated");
								cn4.close();
								}		
							}
							catch(Exception e7)
							{
							JOptionPane.showMessageDialog(null,e7);	
						}							
				 }  
				 if(B==b4)
				 {
					 this.setVisible(false);
	new Employee();
				 }
			  }
		
public static void main(String args[])
{
	  new SearchEmployee();
}
}
