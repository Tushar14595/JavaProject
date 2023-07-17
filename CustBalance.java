import java.io.*;
import javax.swing.*;

public class CustBalance extends JFrame
{
	JLabel l1,l2;
	JButton b1;
	
	public CustBalance()
	{
		setLayout(null);
		
			l1=new JLabel("Label");
			l2=new JLabel("Label");
			b1=new JButton("Balance");
			
			l1.setBounds(150,100,150,30);
			l2.setBounds(150,150,150,30);
			b1.setBounds(130,200,80,30);
			
			add(l1);
			add(l2);
			add(b1);
			
			setSize(1440,900);
			setVisible(true);
			setLocationRelativeTo(null);
	}
		
		public static void main(String[]args)
		{
			new CustBalance();
		}
}