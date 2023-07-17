 import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.text.*;  //message format
import java.awt.print.*; //for print

public class EmpReport extends JFrame implements ActionListener
{
JTable obj;
JButton B1;
JButton B2;
public EmpReport()
{
 setLayout(null);
 JLabel L1;
 B2=new JButton("Back");
 B1=new JButton("Print");
 L1=new JLabel("Employee Report");
 L1.setBounds(560,50,300,40);
 B1.setBounds(20,20,80,30);
 B2.setBounds(1330,20,80,30);
 String[][]a=new String[100][6];
 String h[]={"EID","EName","EAddress","E_con_No","Email ID","Sal"};
 obj=new JTable(a,h);
 JTableHeader Theader=obj.getTableHeader();
 Theader.setFont(new Font("Times New Roman",Font.BOLD,15));
 try
 {											
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection cn=DriverManager.getConnection("Jdbc:Odbc:Stationary");
  Statement st=cn.createStatement();
  String str="Select * from Employee_Details";
  ResultSet rs=st.executeQuery(str);
  int i=0;
  while(rs.next())
  {
                a[i][0]=rs.getString(1);
			  a[i][1]=rs.getString(2);
			  a[i][2]=rs.getString(3);
			  a[i][3]=rs.getString(4);
			  a[i][4]=rs.getString(5);
			  a[i][5]=rs.getString(6);
			 // a[i][6]=rs.getString(7); 
			  
   i++;
  }
  cn.close();
  obj.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  obj.getColumnModel().getColumn(0).setPreferredWidth(40);
  obj.getColumnModel().getColumn(1).setPreferredWidth(100);
  obj.getColumnModel().getColumn(2).setPreferredWidth(100);
  obj.getColumnModel().getColumn(3).setPreferredWidth(100);
  obj.getColumnModel().getColumn(4).setPreferredWidth(150);
  obj.getColumnModel().getColumn(5).setPreferredWidth(100);
 // obj.getColumnModel().getColumn(6).setPreferredWidth(100);
  
  L1.setFont(new Font("Times New Roman",Font.BOLD,25));
  JScrollPane ob=new JScrollPane(obj);
  ob.setBounds(350,100,600,700);

  add(L1);
  add(ob);
  add(B1);
  add(B2);
 }
 catch(Exception nb)
 {
  JOptionPane.showMessageDialog(null,nb);
 }
 B2.addActionListener(this);
 B1.addActionListener(this);
 setTitle("Report");
 setVisible(true);
 //setLocation(350,20);
 setSize(1440,900);
 setLocationRelativeTo(null);
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
  new EmpReport();
 }
}