import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MDI extends JFrame implements ActionListener
{
	MenuBar mb;
	Menu me,cb,pb,ba,cl,sl,s,cr,re,ex;
    MenuItem cd,sd,ed,pd,br,bp,rc,sr,ccl,scl,ci,pi,sk,ext,Acustrpt,Asupprpt,Aemprpt,Aprpt,Acustbillrpt,ABS,AcustLeg,AsuppLeg;
        ImageIcon img;
		JLabel l11;
		Font f=new Font("Comic Sans MS",Font.BOLD,15);
               public MDI()
                  {
                         setLayout(null);
						 
						 
						//this.setVisible(false);
						//new Login();
						img=new ImageIcon("MDI.jpg");
						l11=new JLabel(img);
						l11.setBounds(0,0,1920,1080);
						add(l11);
                          mb=new MenuBar();
						  mb.setFont(f);
						  // mb.setForeground(Color.blue);
                          me=new Menu("Master Entry");
                          cb=new Menu("Customer Bill");
                          pb=new Menu("Purchase Bill");
                          ba=new Menu("Bank Account");
                          cl=new Menu("Customer Ledger");
                          sl=new Menu("Supplier Ledger");
                          s=new Menu("Stock");
                          cr=new Menu("Credit Limit");
                          re=new Menu("Report");
                          ex=new Menu("Exit");
                          
                          
                           cd=new MenuItem("Customer Details");
                           sd=new MenuItem("Supplier Details");
                           ed=new MenuItem("Employee Details");
                           pd=new MenuItem("Product Details");
                           br=new MenuItem("Bank Receipt");
                           bp=new MenuItem("Bank Payment");
                           //bb=new MenuItem("Bank Balance");
                           rc=new MenuItem("Customer receipt");
                          // cp=new MenuItem("Customer payment");
                           //bl=new MenuItem("Customer Balance");
                           sr=new MenuItem("Supplier Receipt");
                          // sp=new MenuItem("Supplier Payment");
                           //sb=new MenuItem("Supplier Balance");
	                       sk=new MenuItem("Stock");
	                       //rp=new MenuItem("Report");
	                       ext=new MenuItem("Exit");
                           ccl=new MenuItem("Customer Credit Limit");
                           scl=new MenuItem("Supplier Credit Limit");
                           ci=new MenuItem("Customer bill");
                           pi=new MenuItem("Purchase bill");
						   Acustrpt=new MenuItem("All Customer Report");
						   Asupprpt=new MenuItem("All Supplier Report");
						   Aemprpt=new MenuItem("All Employee Report");
						   Aprpt=new MenuItem("All Product Report");
						   Acustbillrpt=new MenuItem("All Customer Bill");
						   ABS=new MenuItem("All Bank Statement");
						   AcustLeg=new MenuItem("All customer Ledger");
					       AsuppLeg=new MenuItem("All Supplier Ledger");
						   
						   //Pcustrpt=new MenuItem("Particular Customer Report");
                           //Psupprpt=new MenuItem("Particular Supplier Report");
                          // Pemprpt=new MenuItem("Particular Employee Report");
						  // Pprpt=new MenuItem("Particular Product Report");

                          me.add(cd);
                          mb.add(me);
                          mb.add(cb);
                          mb.add(pb);
                          mb.add(ba);
                          mb.add(cl);
                          mb.add(sl);
                          mb.add(s);
                          mb.add(cr);
                          mb.add(re);
                          mb.add(ex);
                          me.add(sd);
                          me.add(ed);
                          me.add(pd);
                          ba.add(br);
                          ba.add(bp);
                         // ba.add(bb);
                          cl.add(rc);
                          //cl.add(cp);
                          //cl.add(bl);
                          sl.add(sr);
                         // sl.add(sp);
                         // sl.add(sb);
                          cr.add(ccl);
                          cr.add(scl);
                          cb.add(ci);
                          pb.add(pi);
	                      s.add(sk);
                          ex.add(ext);
	                      //re.add(rp);
						  re.add(Acustrpt);
						  //re.add(Pcustrpt);
						  
						  re.add(Asupprpt);
						  //re.add(Psupprpt);
						  
						  re.add(Aemprpt);
						  //re.add(Pemprpt);
						  
						  re.add(Aprpt);
						  //re.add(Pprpt);
						  
						  re.add(Acustbillrpt);
						  re.add(ABS);
						  re.add(AcustLeg);
						  re.add(AsuppLeg);
						 // re.add(Aprpt);
						  
						 // re.add();
						 // re.add();
						  
                          setMenuBar(mb);
						  cd.addActionListener(this);
						  sd.addActionListener(this);
						  ed.addActionListener(this);
						  pd.addActionListener(this);
						  br.addActionListener(this);
						  bp.addActionListener(this);
						 // bb.addActionListener(this);
						  rc.addActionListener(this);
						  //cp.addActionListener(this);
						  //bl.addActionListener(this);
						  sr.addActionListener(this);
						  //sb.addActionListener(this);
						  ccl.addActionListener(this);
						  scl.addActionListener(this);
						  ci.addActionListener(this);
						  pi.addActionListener(this);
						  sk.addActionListener(this);
						  ext.addActionListener(this);
						  //rp.addActionListener(this);
						  Acustrpt.addActionListener(this);
						  Asupprpt.addActionListener(this);
						  Aemprpt.addActionListener(this);
                          Aprpt.addActionListener(this);
						  Acustbillrpt.addActionListener(this);
						  ABS.addActionListener(this);
						  AcustLeg.addActionListener(this);
						  AsuppLeg.addActionListener(this);
						 // Pcustrpt.addActionListener(this);
						 // Psupprpt.addActionListener(this);
						//  Pemprpt.addActionListener(this);
						 // Pprpt.addActionListener(this);
                          setSize(1920,1080);
						  setLocationRelativeTo(null);
						   setTitle("MDI");
                            setVisible(true);
                          //setLocation(200,100);
						 

                   }  
				   public void actionPerformed(ActionEvent e)
				   {
					   String str=(String)e.getActionCommand();
					   boolean b;
					   b=str.equals("Customer Details");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new CustomerInfo();
					   }
					   b=str.equals("Supplier Details");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Supplierinfo();
					   }
					   b=str.equals("Employee Details");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Employee();
					   }
					   b=str.equals("Product Details");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Product();
					   }
					   b=str.equals("Bank Receipt");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new BankRecepit();
					   }
					   b=str.equals("Bank Payment");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Bankpayment();
					   }
					    /*b=str.equals("Bank Balance");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Bankbalance();
					   }*/
					   b=str.equals("Supplier Receipt");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new SupplierReceipt();
					   }
					   b=str.equals("Customer receipt");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new Customerreceipt();
					   }
					   
					   b=str.equals("Stock");
					   if (b==true)
					   {
						   this.setVisible(false);
						  new Stock();
					   }
					   b=str.equals("Customer Credit Limit");
					   if (b==true)
					   {
						   this.setVisible(false);
						   new C_creditLimit();
					   }
					   b=str.equals("Supplier Credit Limit");
					   if (b==true)
					   {
						   this.setVisible(false);
						   	new S_creditLimit();
					   }
					   b=str.equals("Customer bill");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new Custbill();
					   }
					   b=str.equals("Purchase bill");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new Purchasebill();
					   }
					   b=str.equals("All Customer Report");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new CustReport();
					   }
					   b=str.equals("All Supplier Report");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new SupplierReport();
					   }
					    b=str.equals("All Employee Report");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new EmpReport();
				     }
					 b=str.equals("All Product Report");
					   if (b==true)
					   {
						   this.setVisible(false);
                           new ProductReport();
					   }
					   b=str.equals("All Bank Statement");
					   if (b==true)
					   {
						  this.setVisible(false);
					       new BankStatementReport();
					   }
					   b=str.equals("All Customer Bill");
					   if (b==true)
					   {
						   this.setVisible(false);
					       new CustbillReport();
					   }
					   b=str.equals("All customer Ledger");
					   if (b==true)
					   {
						   this.setVisible(false);
					       new CustLegRpt();
					   }
					   
					   b=str.equals("All Supplier Ledger");
					   if (b==true)
					   {
						   this.setVisible(false);
					        new SupplierLegRpt();
					   }
					   /*b=str.equals("Particular Customer Report");
					   if (b==true)
					   {
					   // this.setVisible(false);
					       new ParticularCustRpt();
					   }
					   b=str.equals("Particular Supplier Report");
					   if (b==true)
					   {
						 //  this.setVisible(false);
					       new ParticularSupplierRpt();
					   }
					   b=str.equals("Particular Employee Report");
					   if (b==true)
					   {
						   //this.setVisible(false);
					       new ParticularEmpRpt();
					   }
					   b=str.equals("Particular Product Report");
					   if (b==true)
					   {
						   //this.setVisible(false);
					       new ParticularProductRpt();
					   }*/
					   b=str.equals("Exit");
					if(b==true)
					{
						this.setVisible(false);
						new Login();
					}
				   }
				   
				   
				   
                 public static void main(String args[])
                   {
                            new MDI();
                     }
}
          
            
                
             