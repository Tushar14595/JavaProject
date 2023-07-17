import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Product extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4;
	JComboBox C1,C2;
    JLabel li;
	ImageIcon img;
	JButton B1,B2,B3,B4,B5,B6,B7;
	
	public Product()
	{
		setLayout(null);
        img=new ImageIcon("Customer(1).png");
		li=new JLabel(img);
		li.setBounds(0,0,1440,900);
		 add(li);
		
		l1=new JLabel("product Id");
		l2=new JLabel("product Type");
		l3=new JLabel("product name");
		l4=new JLabel("product Price");
		l5=new JLabel("product Quantity");
		l6=new JLabel("supplier name");
        l7=new JLabel("PRODUCT DETAILS");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		//t5=new JTextField();
		
		C1=new JComboBox();
		C2=new JComboBox();
		B1=new JButton("Add");
		B2=new JButton("Save");
		B3=new JButton("Search");
		B4=new JButton("Update");
		B5=new JButton("Delete");
		B6=new JButton("Clear");
		B7=new JButton("Exit");
		
		l1.setBounds(50,250,150,30);
		l2.setBounds(50,300,150,30);
		l3.setBounds(50,350,150,30);
		l4.setBounds(620,250,150,30);
		l5.setBounds(620,300,150,30);
        l7.setBounds(320,80,500,100);
		l6.setBounds(620,350,150,30);
		
		t1.setBounds(200,250,240,30);
		C1.setBounds(200,300,240,30);
		t2.setBounds(200,350,240,30);
		
		
		t3.setBounds(780,250,240,30);
		t4.setBounds(780,300,240,30);
		C2.setBounds(780,350,240,30);
		
		
		B1.setBounds(150,480,80,30);
		B2.setBounds(250,480,80,30);
		B3.setBounds(350,480,80,30);
		B4.setBounds(450,480,80,30);
		B5.setBounds(550,480,80,30);
		B6.setBounds(650,480,80,30);
		B7.setBounds(750,480,80,30);
		
		li.add(l1);
		li.add(l2);
		li.add(l3);
		li.add(l4);
		li.add(l5);
        li.add(l6);
		li.add(l7);
		li.add(t1);
		li.add(t2);
		
		li.add(t3);
		li.add(t4);
	//	add(t5);
		li.add(C1);
		li.add(C2);
		li.add(B1);
		li.add(B2);
		li.add(B3);
		li.add(B4);
		li.add(B5);
		li.add(B6);
        li.add(B7);
		
                            C1.addItem("");
							C1.addItem("NOTEBOOK");
                             C1.addItem("PENCILE");
                            C1.addItem("RUBBER");
                             C1.addItem("PEN");
							 C1.addItem("OFFICE EQUIPMENT");
							 C1.addItem("COMPUTER EQUIPMENT ");
							 C1.addItem("FILES");
	  /*t1.setEnabled(false);
		t2.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);*/
		
		

		setSize(1440,900);
		setLocationRelativeTo(null);
		//setLocation(300,70);
		setVisible(true);
		setTitle("Product Details");
                                  Font f=new Font("Californian FB",Font.ITALIC,35);
                                  l7.setFont(f);
                                  l7.setForeground(Color.red);
	B1.addActionListener(this);
		B2.addActionListener(this);
		B3.addActionListener(this);
		B6.addActionListener(this);
		B7.addActionListener(this);
		B4.addActionListener(this);
		B5.addActionListener(this);
		formload();
		
		
		Font Fl=new Font("Comic Sans MS",Font.BOLD,14);
 l1.setFont(Fl);
 l2.setFont(Fl);
 l3.setFont(Fl);
 l4.setFont(Fl);
 l5.setFont(Fl);
 //L6.setFont(Fl);
 l6.setFont(Fl);
 t1.setFont(Fl);
 t2.setFont(Fl);
 t3.setFont(Fl);
 t4.setFont(Fl);
 C1.setFont(Fl);
 C2.setFont(Fl);
 
 t1.setForeground(Color.black);
 t2.setForeground(Color.blue);
 t3.setForeground(Color.blue);
 t4.setForeground(Color.blue);
 C1.setForeground(Color.blue);
 C2.setForeground(Color.blue);
 
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
											addbutton();
                                              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                                          Statement  st=cn.createStatement();
                                           String sql="select max(P_ID) from Product_Details";
                                         ResultSet rs=st.executeQuery(sql);
										 rs.next();
										
                                     int n=rs.getInt(1);
                                     n=n+1;
                                    t1.setText(Integer.toString(n));
									addsupplierName();
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
        }
				if(B==B2)
                      {
                         try
                          {
                                  int id=Integer.parseInt(t1.getText());
                                 String type=C1.getSelectedItem().toString();
                                 String name=t2.getText();
                                String price=t3.getText();
                                String Qty=t4.getText();
                                 String Sname=C2.getSelectedItem().toString();
                             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
	        String sql="Insert into Product_Details values(?,?,?,?,?,?)";
	          PreparedStatement ps=cn1.prepareStatement(sql);
                              ps.setInt(1,id);
							ps.setString(2,type);
                            ps.setString(3,name);
                            ps.setString(4,price);
                           ps.setString(5,Qty);
                          ps.setString(6,Sname);
				 int k=ps.executeUpdate();
				 if(k>0)
                 {
                  JOptionPane.showMessageDialog(null,"Record Saved");
				 formload();
                   cn1.close();
				   C2.removeAllItems();
				   C1.removeAllItems();
				  }
					}
                      catch(Exception ea1)
                      {
                          JOptionPane.showMessageDialog(null,ea1);
						}
					  }
					  if(B==B6)
                              {
                                      formload();
							  }
							  if(B==B7)
							  {
								  this.setVisible(false);
	                               new MDI();
							  }
							  if(B4==B)
							  {
                              this.setVisible(false);
								  new Searchproduct();
							  }
							  if(B5==B)
							  {
                              this.setVisible(false);
								  new Searchproduct();
							  }
							  if(B3==B)
							  {
                              this.setVisible(false);
								  new Searchproduct();
							  }
									
                                 }

					  
								   
  void formload()
{
	t1.setEnabled(false);
	t2.setEnabled(false);
	t3.setEnabled(false);
	t4.setEnabled(false);
	//t5.setEnabled(false);
	//t6.setEnabled(false);
	C1.setEnabled(false);
	C2.setEnabled(false);
	B2.setEnabled(false);
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	//t5.setText("");
	//t6.setText("");
	B1.setEnabled(true);
	B2.setEnabled(false );
	B4.setEnabled(true);
	B5.setEnabled(true);
B6.setEnabled(false);
}
void addbutton()
{
	    t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		//t5.setEnabled(true);
		//t6.setEnabled(true);
		B1.setEnabled(false);
		B2.setEnabled(true);
			//B4.setEnabled(true);
//B5.setEnabled(true);
B6.setEnabled(true);
		C1.setEnabled(true);
        C2.setEnabled(true);
}


								   
								   
	public void addsupplierName()
	{
		    try
                 {
					    C2.removeAllItems();
						C2.addItem("");
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                       Statement  st=cn.createStatement();
                       String sql="select S_name from SupplierInfo";
                                         ResultSet rs=st.executeQuery(sql);
										while(rs.next())
										{
											C2.addItem(rs.getString(1));
										}
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
	}
					  
							  
	

		public static void main(String args[])
	
	{
			new Product();
		}
}