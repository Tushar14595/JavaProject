import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame implements ActionListener
{
	
    JLabel l1,l2,Lh,lf,ln,li;
    JTextField t1;
	JPasswordField t2;
	ImageIcon img;
    JButton B1,B2;
 
   public Login()
    {
         setLayout(null);
		 img=new ImageIcon("Login.jpg");
		li=new JLabel(img);
		li.setBounds(0,0,1920,1080);
		 add(li);
		
         l1=new JLabel("UserName");
         l2=new JLabel("Password");
		 Lh=new JLabel("Login");
		  lf=new JLabel("Forget Password?");
		 ln=new JLabel("Sign up");
		 
		 
         t1=new JTextField("");
         t2=new JPasswordField("");
		 
		 
		
		 
         B1=new JButton("Login");
         B2=new JButton("Clear");
		
         l1.setBounds(715,300,100,30);
         l2.setBounds(715,350,100,30);
		 
		 Lh.setBounds(800,150,800,90);
		 
         t1.setBounds(820,300,170,30);
         t2.setBounds(820,350,170,30);
		 
         B1.setBounds(530,430,100,25);
         B2.setBounds(660,430,100,25);
		 
		 lf.setBounds(880,390,150,30); // forget password
		 ln.setBounds(740,390,100,30); //signup
		 
         li.add(l1);
         li.add(l2);
         li.add(t1);    
         li.add(t2);
         li.add(B1);
         li.add(B2);
		 li.add(lf);
		 li.add(ln);
		 li.add(Lh);
		 
		 
		 lf.setForeground(Color.BLUE);
		 ln.setForeground(Color.BLUE);
		 //l1.setForeground(Color.blue);
		// l2.setForeground(Color.blue);
		 
	
		 Font f1=new Font("Arial Black",Font.BOLD,60);
			Lh.setFont(f1);
			Lh.setForeground(Color.RED);
			Font Ft=new Font("Times new Roman",Font.BOLD,14);
			t1.setFont(Ft);
			t2.setFont(Ft);
			//t1.setForeground(Color.green);
			//t2.setForeground(Color.green);
		
		 
         setSize(1920,1080);
		 setLocationRelativeTo(null);
		 setVisible(true);
          
		  setTitle("LOGIN");
		  B1.addActionListener(this);
		  //this.setVisible(false);
		 // new MDI();
		  B2.addActionListener(this);
		  mouseactionlabel();
		  
		  

 }
 
 void mouseactionlabel()
{
ln.addMouseListener(new MouseListener()
{
public void mouseClicked(MouseEvent arg0)
{
	//this.setVisible(false);
	new Signup();

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

lf.addMouseListener(new MouseListener()
{
public void mouseClicked(MouseEvent arg1) 
{
	
	new  Forget();

}
public void mouseEntered(MouseEvent arg1) 
{
}
public void mouseExited(MouseEvent arg1)
 {
}
public void mousePressed(MouseEvent arg1)
 {
}
public void mouseReleased(MouseEvent arg1) 
{
}
});
}

public void actionPerformed(ActionEvent e11)
   {
	
		   JButton B=(JButton)e11.getSource();
		   if(B==B1)
		   {
			   int c=0;
			   String user=t1.getText();
			   String pass=t2.getText();
			   
			   try
			   {
 				   
				   Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\Stationary Management System\\SMS.mdb");
				   Statement st=cn.createStatement();
				   String sql="select * from Login where Username='"+ user +"'AND Password='"+ pass +"'";
				   ResultSet rs=st.executeQuery(sql);
				   while(rs.next())
				   {
					   c++;
					   JOptionPane.showMessageDialog(null,"Login Successfully");
					   t1.setText("");
						t2.setText("");	
				   }
			   if(c==0)
			   {
				   JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
			   }
			   else
			   {
               this.setVisible(false);
				   new MDI();
			   }
			 }
			   catch(Exception s)
			   {
				   JOptionPane.showMessageDialog(null,s);
			   }
		   }
		   if(B==B2)
		   {
			t1.setText("");
			t2.setText("");		
		   }
        }
	      
			 public static void main(String args[])
            {
             new Login();
            }
         }