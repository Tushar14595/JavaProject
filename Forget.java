import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.regex.*;

public class Forget extends JFrame implements ActionListener
{
 JLabel L1,L2,L3,L4,L5,Lh,L6;
 JTextField T1,T2,T3;
 JPasswordField T4,T5;
 JButton B1,B2,B3;
 
 JComboBox Cb1;
 JTextField t11,t12,t13,t14,t15;
 String answ;
 //ImageIcon img;
 
 public Forget()
{
 setLayout(null);
 
 L1=new JLabel("Contact_no :");
 L2=new JLabel("Security Question :");
 L3=new JLabel("Ans The Question :");
 L4=new JLabel("Enter New Password:");
 L5=new JLabel("Re-Enter Password :");
 Lh=new JLabel("Forget Password");
 L6=new JLabel("Do You Want To Login??");
 
 T1=new JTextField("");
 T2=new JTextField("");
 T3=new JTextField("");
 T4=new JPasswordField("");
 T5=new JPasswordField("");
 
 
 //R1=new Checkbox("Male",cg1,true);  
 //R2=new Checkbox("Female",cg1,false);
 
 B1=new JButton("Search");
 B2=new JButton("Update");
 B3=new JButton("Clear");
 
 Cb1=new JComboBox();
 //Line Code--------------------------------------------- 
/* t11=new JTextField();
 t11.setBounds(0,100,1352,1);  //row 1
 add(t11);
 t11.setBackground(Color.black);
 
 t12=new JTextField();
 t12.setBounds(0,640,1352,1);   //row 2
 add(t12);
 t12.setBackground(Color.black);
 
 t14=new JTextField();
 t14.setBounds(0,100,1,542);    //Column 1
 add(t14);
 t14.setBackground(Color.black);
 
 t13=new JTextField();
 t13.setBounds(750,100,1,542);  //Column 2
 add(t13);
 t13.setBackground(Color.black);
 
 t15=new JTextField();
 t15.setBounds(1350,100,1,542);  //Column 3
 add(t15);
 t15.setBackground(Color.black);
//Line code End-------------------------------------------------------------
*/
 L1.setBounds(440,250,130,30);
 L2.setBounds(440,300,170,30);
 L3.setBounds(440,350,170,30);
 L4.setBounds(440,400,170,30);
 L5.setBounds(440,450,170,30);
 Lh.setBounds(380,80,750,70);
 L6.setBounds(660,480,250,30);
 
 
 T1.setBounds(640,250,150,30);
 T2.setBounds(640,300,220,30);
 T3.setBounds(640,350,220,30);
 
 T4.setBounds(640,400,220,30);
 T5.setBounds(640,450,220,30);
 
 //R1.setBounds(240,525,100,30);
 //R2.setBounds(360,525,100,30);
 
 B1.setBounds(800,250,80,30);
 B2.setBounds(510,520,80,30);
 B3.setBounds(690,520,80,30);
 
 add(L1);
 add(L2);
 add(L3);
 add(L4);
 add(L5);
 add(Lh);
add(L6);
 add(T1);
 add(T2);
 add(T3);
 add(T4);
 add(T5);

 add(B1);
 add(B2);
 add(B3);
 
 Font f=new Font("Arial Black",Font.BOLD,60);
 Lh.setFont(f);
 Lh.setForeground(Color.red);

 B1.addActionListener(this);
 B2.addActionListener(this); 
 B3.addActionListener(this);
 mouseactionlabel();
 
 
 //To Set Font to Label
 Font Fl=new Font("Comic Sans MS",Font.BOLD,16);
 L1.setFont(Fl);
 L2.setFont(Fl);
 L3.setFont(Fl);
 L4.setFont(Fl);
 L5.setFont(Fl);


//To Set Font to text
 Font Ft=new Font("Comic Sans MS",Font.BOLD,14);
 T1.setFont(Ft);
 T2.setFont(Ft);
 T3.setFont(Ft);
 T4.setFont(Ft);
 T5.setFont(Ft);
 
 
Font F6=new Font("Comic Sans MS",Font.BOLD,16);
L6.setFont(F6);
L6.setForeground(Color.blue);

// R1.setFont(Ft);
//R2.setFont(Ft);
 T1.setForeground(Color.blue);
 T2.setForeground(Color.blue);
 T3.setForeground(Color.blue);
 T4.setForeground(Color.blue);
 T5.setForeground(Color.blue);
L6.setVisible(false);
  
  T1.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e1) //KeyReleased
			{
			 char c=e1.getKeyChar();
			 if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))
			 {
			  e1.consume();
			 }
			}
});
//End
 setSize(1440,900);
 setLocationRelativeTo(null);
 setVisible(true);
 //setLocationRelativeTo(null);
 }//Close of Constructor
void mouseactionlabel()
{
L6.addMouseListener(new MouseListener()
{
public void mouseClicked(MouseEvent arg0) {
	//this.setVisible(false);
	new Login();
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
	   if(B==B1)
       {	
        try 
		{
		 String mobno=T1.getText();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 Connection cn=DriverManager.getConnection("Jdbc:Odbc:Stationary");
         Statement st=cn.createStatement();
         String str="Select * from Login where Mobile_no='"+mobno+"'";
         ResultSet rs=st.executeQuery(str);
	     if(rs == null)
	     {
		   JOptionPane.showMessageDialog(null,"Mobile no. not found");
	     }
	     while(rs.next())
	    {
	     String que=rs.getString(5);
	     answ=rs.getString(6);
		 T2.setText(que);
	    }
	    cn.close();
       }
       catch(Exception ex1)
       {  
        JOptionPane.showMessageDialog(null,ex1);
       } 
      }

		 if(B2==B)
		 {
			String t4=T4.getText();
			String t5=T5.getText();
			String mobno1=T1.getText();
			String answ1=T3.getText();
			if(answ1.equals(answ))
			{
			 if(t4.equals(t5))
			 {
			 try
			 {
			   String password=T5.getText();
			  
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
			   String sql="Update Login set Password=? where Mobile_no=?";
			   PreparedStatement ps=cn.prepareStatement(sql);
			   ps.setString(1,password);
			   ps.setString(2,mobno1);
			   int k=ps.executeUpdate();
			   if(k>0)
			   {
				  JOptionPane.showMessageDialog(null,"Password Changed Successfully");
				  T1.setText("");
		          T2.setText("");
		          T3.setText("");
		          T4.setText("");
		          T5.setText("");
				  cn.close();
				  L6.setVisible(true);
			   }
		     }
			catch(Exception ex)
			{
			 JOptionPane.showMessageDialog(null,ex);
			}
			}
			else
			{
			 JOptionPane.showMessageDialog(null,"Password Mismatch");
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong Answer");
				//T4.setBorder(BorderFactory.createLineBorder(Color.red));
			}
		 }//B1 Button Close	   
		 if(B==B3)		 
		 {
		  T1.setText("");
		  T2.setText("");
		  T3.setText("");
		  T4.setText("");
		  T5.setText("");
		 }
  }  
	
 public static void main(String args[])
 {
	    new Forget();
 }
}