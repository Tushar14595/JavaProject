import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Demo extends JFrame implements ActionListener
{
	 int c;
	String d[][]=new String [100][8];
	String h[]={"Bill No","Date","CustomerName","Address","Cotact No","Total Bill","Paid Amount","Balance"};
	JButton B1,B2;
    JLabel lI;
	ImageIcon img;
	public Demo()
	{
        setLayout(null);
        
        img=new ImageIcon("Search.png");
		lI=new JLabel(img);
		lI.setBounds(0,0,1432,912);
		 add(lI);
        
        
	   B1=new JButton("Search");
       B2=new JButton("Exit");
	   B1.setBounds(150,50,100,30);
       B2.setBounds(1130,50,100,30);
	   lI.add(B1);
       lI.add(B2);
	
	setSize(1440,900);
	setLocationRelativeTo(null);
	setVisible(true);
	B1.addActionListener(this);
    B2.addActionListener(this);
    }
	public void actionPerformed(ActionEvent q)
	{
		 JButton B=(JButton)q.getSource();
          if(B2==B)
					  {
                      this.setVisible(false);
						  new MDI();
					  } 
		  if(B==B1)
		  {
			    int n =Integer.parseInt(JOptionPane.showInputDialog("Enter P_ID"));
	try
	{
		 
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection cn1=DriverManager.getConnection("jdbc:odbc:Stationary");
	    Statement st1=cn1.createStatement();
		String sql="select * from Customer_Bill where Bill_no=" + n;
		ResultSet rs=st1.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			  d[i][0]=rs.getString(1);
			  d[i][1]=rs.getString(2);
			  d[i][2]=rs.getString(3);
			  d[i][3]=rs.getString(4);
			  d[i][4]=rs.getString(5);
			  d[i][5]=rs.getString(31);
			  d[i][6]=rs.getString(32);
			  d[i][7]=rs.getString(33);
			 
			  
			i=i+1;
			c=c+1;
			
			
		}
		JTable obj=new JTable(d,h);
		JScrollPane ob=new JScrollPane(obj);
		ob.setBounds(150,150,1000,200);
		lI.add(ob);
		if(c==0)
		{
			JOptionPane.showMessageDialog(null,"Record Not Found");
		}
		
	}
	catch(Exception op)
	{
		JOptionPane.showMessageDialog(null,op);
	}

			  
		  }
		
	}
 public static void main(String args[])
   {
	    new Demo();
   }
}
	 
