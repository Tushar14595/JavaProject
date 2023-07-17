import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.text.*;  //message format
import java.awt.print.*; //for print


public class CustReport extends JFrame implements ActionListener
{
JTable obj;
JButton B1;
JButton B2;
	public CustReport()
	{
		setLayout(null);
		JLabel L1;
        B1=new JButton("Print");
        B2=new JButton("Back");
        L1=new JLabel("Customer Report");
        L1.setBounds(490,50,300,40);
        B1.setBounds(20,20,80,30);
        B2.setBounds(1330,20,80,30);
		String[][]a=new String[100][6];
		String h[]={"ID","Name","Address","con_No","Email ID","Crdtlmt"};
        obj=new JTable(a,h);
        JTableHeader Theader=obj.getTableHeader();
        Theader.setFont(new Font("Times New Roman",Font.BOLD,15));
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection cn=DriverManager.getConnection("jdbc:odbc:Stationary");
            Statement  st=cn.createStatement();
            String sql="select * from Customer_Info";
            ResultSet rs=st.executeQuery(sql);
			int i=0;
	        while(rs.next())
			{
			  a[i][0]=rs.getString(1);
			  a[i][1]=rs.getString(2);
              a[i][2]=rs.getString(3);
			  a[i][3]=rs.getString(4);
			  a[i][4]=rs.getString(5);
			  a[i][5]=rs.getString(6);
			  
			  
			  i++;
			}
			cn.close();
            obj.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            obj.getColumnModel().getColumn(0).setPreferredWidth(40);
            obj.getColumnModel().getColumn(1).setPreferredWidth(80);
            obj.getColumnModel().getColumn(2).setPreferredWidth(160);
            obj.getColumnModel().getColumn(3).setPreferredWidth(90);
            obj.getColumnModel().getColumn(4).setPreferredWidth(160);
            obj.getColumnModel().getColumn(5).setPreferredWidth(66);
            
            
			 // L1=new JLabel("Customer Report");
			  L1.setFont(new Font("Times New Roman",Font.BOLD,25));
			  //JLabel L2=new JLabel("");
			  //JTable obj=new JTable(a,h);
			 JScrollPane ob=new JScrollPane(obj);
			 // L1.setBounds(200,50,300,40);
			  ob.setBounds(350,100,615,700);
			//  L2.setBounds(100,100,0,0);
			  add(L1);
			  add(ob);
			 // add(L2);
			  add(B1);
			 add(B2);
		   }
		 catch(Exception x)
		 {
		   JOptionPane.showMessageDialog(null,x);
		 }
         B1.addActionListener(this);
         B2.addActionListener(this);
		 setTitle("Customer Report");
		 setVisible(true);
		 //setLocation(150,50);
		 setLocationRelativeTo(null);
		setSize(1440,900);
	}
     public void actionPerformed(ActionEvent e)
  {
         JButton B=(JButton)e.getSource();
		 if(B1==B)
		 {
			 MessageFormat header=new MessageFormat("Report print");
			 MessageFormat footer=new MessageFormat("page{0,number,integer}");
			 
			 try
			 {
				
			 obj.print(JTable.PrintMode.NORMAL,header,footer);
	         }
			 catch(java.awt.print.PrinterException a12)
			 {
			  JOptionPane.showMessageDialog(null,a12);
			 }
         }
         if(B2==B)
         {
         this.setVisible(false);
         new MDI();
         }
  }
 
	    public static void main(String args[])
		{
			new CustReport();
		}
}		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  