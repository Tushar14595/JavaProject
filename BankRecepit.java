import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankRecepit extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,L1,L2;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4;
    JLabel li;
	ImageIcon img;
	int balance;
	  public BankRecepit()
	{
		setLayout(null);
		
        img=new ImageIcon("Bank.png");
		li=new JLabel(img);
		li.setBounds(0,0,1440,900);
		 add(li);
        
        
		l1=new JLabel("Date");
		l2=new JLabel("T_Id");
		l3=new JLabel("Amount");
		l4=new JLabel("Description");
		l5=new JLabel("BankReceipt");
		L1=new JLabel("Do You Want To Check Balance??");
		L2=new JLabel("Balance");
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		b1=new JButton("Receipt");
		b2=new JButton("Exit");
		b3=new JButton("Add");
		
		
		b4=new JButton("Show");
		
		l2.setBounds(550,250,150,30);
		l1.setBounds(550,300,150,30);
		l3.setBounds(550,350,150,30);
		l4.setBounds(550,400,150,30);
		L1.setBounds(680,440,200,30);
		L2.setBounds(950,250,150,30);
		
		
		
		l5.setBounds(580,105,500,100);
		
		t2.setBounds(680,250,200,30);
		t1.setBounds(680,300,200,30);
		t3.setBounds(680,350,200,30);
		t4.setBounds(680,400,200,30);

        b3.setBounds(550,480,80,30);
		b1.setBounds(650,480,80,30);
		b2.setBounds(750,480,80,30);
		b4.setBounds(950,300,80,30);
		
		li.add(l1);
		li.add(l2);
		li.add(l3);
		li.add(L1);
		li.add(L2);
		li.add(b4);
		li.add(l4);
		li.add(l5);
		li.add(t1);
		li.add(t2);
		li.add(t3);
		li.add(t4);
		//add(lb);
		li.add(b1);
		li.add(b2);
		li.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		mouseactionlabel();
		valiform();
		
		setSize(1440,900);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("BankReceipt");
		Font f=new Font("Californian FB",Font.ITALIC,55);
        l5.setFont(f);
        l5.setForeground(Color.red);
	    
		
		Font f1=new Font("Californian FB",Font.ITALIC,19);
		t1.setFont(f1);
		t2.setFont(f1);
		t3.setFont(f1);
		t4.setFont(f1);
		//t5.setFont(f);
		
		t1.setForeground(Color.blue);
		//t2.setForeground(Color.blue);
		t3.setForeground(Color.blue);
		t4.setForeground(Color.blue);
		L1.setForeground(Color.blue);
	}	
		
		void mouseactionlabel()
{
L1.addMouseListener(new MouseListener()
{
public void mouseClicked(MouseEvent arg0) {
	//this.setVisible(false);
	L2.setVisible(true);
	b4.setVisible(true);
//alert.setVisible(true);
}
public void mouseEntered(MouseEvent arg0) {
}
public void mouseExited(MouseEvent arg0) {
}
public void mousePressed(MouseEvent arg0) {
}
public void mouseReleased(MouseEvent arg0) {
}
});
}

		
	
 public void actionPerformed(ActionEvent e)
          {
                                       
                                     JButton B=(JButton)e.getSource();
									if(B==b1)
									 {
										
										 try
										 {
											 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
                                          Statement st=cn.createStatement();
										  balance=balance+Integer.parseInt(t3.getText());
										  int x=0;
                                         String sql3="insert into Bank_Receipt values('" + t1.getText() + "',"  + t2.getText() + "," + t3.getText() +"," + x + "," + balance + ",'" + t4.getText() + "')"; 
                                        										
										int k=st.executeUpdate(sql3);
										if (k>0)
										{
											JOptionPane.showMessageDialog(null,"Transcation Completed");
											t1.setText("");
											t2.setText("");
											t3.setText("");
											t4.setText("");
											L1.setVisible(true);
										}
										 
									 cn.close();
										 }
										 catch(Exception ea)
										 {
											JOptionPane.showMessageDialog(null,ea); 
										 }
									 }
									 if(b3==B)
                                 {
									// t1.setEnabled(true);
		                                  try
                                        {  
										 t1.setEnabled(true);
										 t2.setEnabled(false);
										 b1.setEnabled(true);
										b3.setEnabled(false);
										 t3.setEnabled(true);
										 t4.setEnabled(true);
										Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
                                          Statement  st1=cn1.createStatement();
                                           String sql4="select max(T_ID) from Bank_Receipt";
                                         ResultSet rs3=st1.executeQuery(sql4);
										 rs3.next();
										
                                     int n=rs3.getInt(1);
											 //addbutton();
                                          Statement  st2=cn1.createStatement();
                                           String sql5="select B_Bal1 from Bank_Receipt where T_ID=" + n;
                                         ResultSet rs4=st2.executeQuery(sql5);
										 rs4.next();
										balance=rs4.getInt(1);
                                     n=n+1;
                                    t2.setText(Integer.toString(n));
									
                                      cn1.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
							  
				}
				if(b2==B)
				{
					this.setVisible(false);
					new MDI();
				}
					if(b4==B)
				{
					try
					{
										Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
										Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
                                         Statement  st1=cn1.createStatement();
                                           String sql4="select max(T_ID) from Bank_Receipt";
                                         ResultSet rs3=st1.executeQuery(sql4);
										 rs3.next();
										
                                     int n=rs3.getInt(1);
											 //addbutton();
                                          Statement  st2=cn1.createStatement();
                                           String sql5="select B_Bal1 from Bank_Receipt where T_ID=" + n;
                                         ResultSet rs4=st2.executeQuery(sql5);
										 rs4.next();
										balance=rs4.getInt(1);
										
										L2.setText(Integer.toString(balance));
                                     n=n+1;
                                    //t2.setText(Integer.toString(n));
									
                                      cn1.close();
                                   }
                        catch(Exception ea)
                           {
                                  JOptionPane.showMessageDialog(null,ea);
                              }
			}
		}
									 
		                       

void valiform()
{
	t1.setEnabled(false);
	t2.setEnabled(false);
    t3.setEnabled(false);
	t4.setEnabled(false);
	L1.setVisible(false);
	L2.setVisible(false);
	b4.setVisible(false);
	b1.setEnabled(false);
	b3.setEnabled(true);
}
/*void Bttn()
{
	t2.setEnabled(false);
}*/
	public static void main (String[]args)
	{
		new BankRecepit();
	}
}