import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Supplierinfo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,li;
	JTextField t1,t2,t3,t4,t5,t6;
    ImageIcon img;
	//JComboBox C1;
	JButton B1,B2,B3,B4,B5,B6,B7;
	int t_id;
	public Supplierinfo()
	{
		setLayout(null);
        
        img=new ImageIcon("Pencils.png");
		li=new JLabel(img);
		li.setBounds(0,0,1440,900);
		 add(li);
		
		l1=new JLabel("Supplier Id");
		l2=new JLabel("Supplier name");
		l3=new JLabel("Supplier Address");
		l4=new JLabel("Contact no.");
		l5=new JLabel("Email Id");
		l6=new JLabel("SUPPLIER INFORMATION");
		l7=new JLabel("Credit Limit");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		//C1=new JComboBox();
		
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
        l6.setBounds(320,80,500,100);
		l7.setBounds(620,350,150,30);
		//l7.setBounds(50,450,150,30);
		
		t1.setBounds(200,250,150,30);
		t2.setBounds(200,300,240,30);
		t3.setBounds(200,350,240,80);
		t4.setBounds(780,250,240,30);
		t5.setBounds(780,300,240,30);
		t6.setBounds(780,350,240,30);
		//C1.setBounds(300,400,100,30);
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
		li.add(t5);
		li.add(t6);
		//add(C1);
		li.add(B1);
		li.add(B2);
		li.add(B3);
		li.add(B4);
		li.add(B5);
		li.add(B6);
                                   add(B7);
                             /*C1.addItem("@Gmail.com");
                             C1.addItem("@Ymail.com");
                            C1.addItem("@Orkut.com");
                             C1.addItem("@Rediff.com");*/
	  	

		setSize(1440,900);
		setLocationRelativeTo(null);
		//setLocation(300,70);
		setVisible(true);
		setTitle("Supplier Info");
                                  Font f=new Font("Times New Roman",Font.ITALIC,35);
                                  l6.setFont(f);
                                  l6.setForeground(Color.red);
	B1.addActionListener(this);
	B2.addActionListener(this);
	B3.addActionListener(this);
	B4.addActionListener(this);
	B5.addActionListener(this);
	B6.addActionListener(this);
	B7.addActionListener(this);
		formload();
		
		
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
	}
//	   B1.addActionListener(this);
                               	
	//}
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
                                           String sql="select max(S_ID) from SupplierInfo";
                                         ResultSet rs=st.executeQuery(sql);
										 rs.next();
										
                                     int n=rs.getInt(1);
                                     n=n+1;
                                    t1.setText(Integer.toString(n));
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
                                 String name=t2.getText();
                                 String Address=t3.getText();
                                String Contact_no=t4.getText();
                                String Email_ID=t5.getText();
                                String crl=t6.getText();
								
                             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
	        String sql="Insert into SupplierInfo values(?,?,?,?,?,?)";
	          PreparedStatement ps=cn1.prepareStatement(sql);
                              ps.setInt(1,id);
							ps.setString(2,name);
                            ps.setString(3,Address);
                            ps.setString(4,Contact_no);
                           ps.setString(5,Email_ID);
                          ps.setString(6,crl);
            int k=ps.executeUpdate();
             if(k>0)
             {
				  adddata();
                  JOptionPane.showMessageDialog(null,"Record Saved");
				  formload();
                   cn1.close();
     }
                }
                      catch(Exception ea1)
                      {
                          JOptionPane.showMessageDialog(null,ea1);
              }
			  

}//Button B2 Close 
   if(B6==B)
   {
	   formload();
   }
   if(B7==B)
   {
	   this.setVisible(false);
	   new MDI();
   }
	 if(B3==B)
     {
     this.setVisible(false);
		 new SearchSupplier();
	 }	
if(B4==B)
     {
     this.setVisible(false);
		 new SearchSupplier();
	 }		 
if(B5==B)
     {
     this.setVisible(false);
		 new SearchSupplier();
	 }		 	 
				}
				void formload()
{
	t1.setEnabled(false);
	t2.setEnabled(false);
	t3.setEnabled(false);
	t4.setEnabled(false);
	t5.setEnabled(false);
	t6.setEnabled(false);
	//C1.setEnabled(false);
	B2.setEnabled(false);
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	B1.setEnabled(true);
	B6.setEnabled(false);
	B2.setEnabled(false );
	//B4.setEnabled(false);
	//B5.setEnabled(false);
}
void addbutton()
{
	    t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		t5.setEnabled(true);
		t6.setEnabled(true);
		B1.setEnabled(false);
		B2.setEnabled(true);
		B6.setEnabled(true);
		//C1.setEnabled(true);
		//B4.setEnabled(true);
		//B3.setEnabled(true);
        //B5.setEnabled(true);
}
public void getT_id()
{
	  try
            {  
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										
                Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                Statement  st=cn.createStatement();
                String sql="select max(T_ID) from Supplier_Receipt";
                ResultSet rs=st.executeQuery(sql);
                rs.next();
	            t_id=rs.getInt(1)+1;
				//System.out.println("Ok");
                                      cn.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }

}
 public void adddata()
   {
	   try
	   {
		   getT_id();
		  String str="no";
		   int x=0;
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection cn5=DriverManager.getConnection("jdbc:odbc:Stationary");
			  Statement st5=cn5.createStatement();
	        String sql5="insert into Supplier_Receipt values('" + str + "'," + t_id + ",'" + t2.getText() + "'," + x + "," + x + "," + x + ",'" + str +  "')"; 
	         //  System.out.println(sql5);
			 int k=st5.executeUpdate(sql5);
										if (k>0)
										{
											//JOptionPane.showMessageDialog(null,"Transcation Completed");
										}
										 
									 cn5.close();
										 }
										 catch(Exception n)
										 {
											JOptionPane.showMessageDialog(null,n); 
										 }
									 } 
	

		public static void main(String args[])
	
	{
			new Supplierinfo();
		}
}