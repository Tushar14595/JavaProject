import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.regex.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup extends JFrame implements ActionListener
{
 JLabel L1,L2,L3,L4,L5,L6,L7,Lh,L8;
 JTextField T1,T2,T5,T6;
 JPasswordField T3,T4;
 JButton B1,B2;
 
 //Checkbox R1,R2;
 JComboBox Cb1;
 JTextField t11,t12,t13,t14,t15;
 CheckboxGroup cg1;
 String gender;
 
 
 public Signup()
{
 setLayout(null);
 
 
 cg1=new CheckboxGroup();
 L1=new JLabel("Name");
 L2=new JLabel("Email-ID");
 L3=new JLabel("Password");
 L4=new JLabel("Confirm Password");
 L5=new JLabel("Contact_no");
 L6=new JLabel("Security Question");
 L7=new JLabel("Ans The Question");
 Lh=new JLabel("Sign up");
 L8=new JLabel("Do You want to Login ?");

 T1=new JTextField("");
 T2=new JTextField("");
 T3=new JPasswordField("");
 T4=new JPasswordField("");
 T5=new JTextField("");
 T6=new JTextField("");
 
 //R1=new Checkbox("Male",cg1,true);  
 //R2=new Checkbox("Female",cg1,false);
 
 B1=new JButton("Save");
 B2=new JButton("Clear");
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
 L1.setBounds(460,200,130,30);
 L2.setBounds(460,250,150,30);
 L3.setBounds(460,300,150,30);
 L4.setBounds(460,350,150,30);
 L5.setBounds(460,400,150,30);
 L6.setBounds(460,450,150,30);
 L7.setBounds(460,500,150,30);
 
 Lh.setBounds(550,40,500,100);
 L8.setBounds(620,530,250,30);
 
 T1.setBounds(620,200,260,30);
 T2.setBounds(620,250,260,30);
 T3.setBounds(620,300,260,30);
 T4.setBounds(620,350,260,30);
 T5.setBounds(620,400,260,30);
 Cb1.setBounds(620,450,260,30);
 T6.setBounds(620,500,260,30);
 
 //R1.setBounds(240,525,100,30);
 //R2.setBounds(360,525,100,30);
 
 B1.setBounds(490,580,80,30);
 B2.setBounds(660,580,80,30);
 
 Cb1.addItem("");
 Cb1.addItem("What is Your Pet Name");
 Cb1.addItem("Which Movie you First Watch");
 Cb1.addItem("Which is Your First Mobile No.");
 Cb1.addItem("Which is your Favorite Person");
 
 add(L1);
 add(L2);
 add(L3);
 add(L4);
 add(L5);
 add(L6);
 add(L7);
 add(Lh);
 add(T1);
 add(T2);
add(T3);
 add(T4);
 add(T5);
 add(T6);
 add(Cb1);
add(L8); 
 add(B1);
 add(B2);

 Font f=new Font("Arial Black",Font.BOLD,35);
 Lh.setFont(f);
 Lh.setForeground(Color.red);
 setSize(1440,900);
 setLocationRelativeTo(null);
//setLocation(300,70);
L8.setVisible(false);
 setVisible(true);
 setTitle("Sign up");
 B1.addActionListener(this);
 B2.addActionListener(this); //To Set Font to Label
 mouseactionlabel();
 Font Fl=new Font("Comic Sans MS",Font.BOLD,14);
 L1.setFont(Fl);
 L2.setFont(Fl);
 L3.setFont(Fl);
 L4.setFont(Fl);
 L5.setFont(Fl);
 L6.setFont(Fl);
 L7.setFont(Fl);
 Font F8=new Font("Comic Sans MS",Font.BOLD,16);
L8.setFont(F8);
L8.setForeground(Color.blue);


//To Set Font to text
 Font Ft=new Font("Times new Roman",Font.BOLD,14);
 T1.setFont(Ft);
 T2.setFont(Ft);
 T3.setFont(Ft);
 T4.setFont(Ft);
 T5.setFont(Ft);
 T6.setFont(Ft);
// R1.setFont(Ft);
//R2.setFont(Ft);
 T1.setForeground(Color.blue);
 T2.setForeground(Color.blue);
 T3.setForeground(Color.blue);
 T4.setForeground(Color.blue);
 T5.setForeground(Color.blue);
 T6.setForeground(Color.blue);
  
  T5.addKeyListener(new KeyAdapter(){
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

 }//Close of Constructor
void mouseactionlabel()
{
L8.addMouseListener(new MouseListener()
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
	     Connection cn;
         Statement st;
         JButton B=(JButton)e.getSource();
		 if(B1==B)
		 {
			String t3=T3.getText();
			String t4=T4.getText();
			if(t3.equals(t4))
			{
			try
			{
			  String name=T1.getText();
			  String email=T2.getText();
			  String password=T4.getText();
			  String contno=T5.getText();
			  String secq=Cb1.getSelectedItem().toString();
			  String ans=T6.getText();	
			
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     cn=DriverManager.getConnection("jdbc:odbc:Stationary");
			 st=cn.createStatement();
			 String sql="insert into Login values(?,?,?,?,?,?)";
			  PreparedStatement ps=cn.prepareStatement(sql);
			  ps.setString(1,name);
			  ps.setString(2,email);
			  ps.setString(3,password);
			  ps.setString(4,contno);
			  ps.setString(5,secq);
			  ps.setString(6,ans);
			  
			  int k=ps.executeUpdate();
			   if(k>0)
			  {
				  JOptionPane.showMessageDialog(null,"Record Saved");
				  T1.setText("");
		          T2.setText("");
		          T3.setText("");
		          T4.setText("");
		          T5.setText("");
		          T6.setText("");
				  Cb1.removeAllItems();
				  cn.close();
				  L8.setVisible(true);
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
				T4.setText("");
				//T4.setBorder(BorderFactory.createLineBorder(Color.red));
			}
		 }//B1 Button Close	
		 if(B==B2)		 
		 {
		  T1.setText("");
		  T2.setText("");
		  T3.setText("");
		  T4.setText("");
		  T5.setText("");
		  T6.setText("");
		 }
  }  
	
 public static void main(String args[])
 {
	    new Signup();
 }
}
