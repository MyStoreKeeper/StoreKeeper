package window;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import controller.DataHandler;
import controller.DataHandler2;
import objects.Member;
import objects.Product;
import objects.Transaction_Item;
/**
 * 
 * @author vinayakPriya
 *
 */
public class ProductsShoppingWindow extends JFrame {
	
<<<<<<< HEAD
	   DataHandler2 data;
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel quantityLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   
	JLabel label = new JLabel("Add Member-ID");
	JLabel selectLabel = new JLabel("Please Select: ");
	JLabel newlabel = new JLabel("");
	JPanel panel = new JPanel();
    final JRadioButton member = new JRadioButton("Member");
    final JRadioButton nonMember = new JRadioButton("Non-Member");
	JTextField jTextField=new JTextField(10);
	JTextField jTextField2=new JTextField(10);
	JButton btn = new JButton("Member Lookup");
	JButton btn2 = new JButton("Product Lookup");
	JButton btn3 = new JButton("Add to Cart");
	JButton btn4 = new JButton("Proceed to cart");
=======
	/*DataHandler2 data = new DataHandler2();
>>>>>>> origin/master
	
	
public ProductsShoppingWindow() throws IOException {
	data=new DataHandler2();
		GUI();
		showRadioButtonDemo();
		
		}

	public void GUI(){
		
		  mainFrame = new JFrame("UNIVERSITY SHOP");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);
	      quantityLabel = new JLabel("",JLabel.CENTER); 

	      statusLabel.setSize(400,400);

	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      jTextField.setBounds(0, 0, 2, 22);
		  getContentPane().add(jTextField);
		  jTextField.setVisible(false);
			
		  jTextField2.setBounds(0, 0, 2, 22);
		  getContentPane().add(jTextField2);
		  jTextField2.setVisible(false);
			
		  btn.setBounds(0, 0, 2, 22);
		  btn.setVisible(false);
		  
		  btn2.setBounds(0, 0, 2, 22);
		  btn2.setVisible(false);
		  
		  btn3.setBounds(0, 0, 2, 22);
		  btn3.setVisible(false);
			
		  btn4.setBounds(0, 0, 2, 22);
		  btn4.setVisible(false);
		  
	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      
	      mainFrame.setVisible(true); 
	      
	}
	private void showRadioButtonDemo(){
	      headerLabel.setText("Please Select: Member/Non-Member"); 

	      final JRadioButton radApple = new JRadioButton("Member");
	      final JRadioButton radMango = new JRadioButton("Non-Member");
	      

	      radApple.setMnemonic(KeyEvent.VK_C);
	      radMango.setMnemonic(KeyEvent.VK_M);
	      

	      radApple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					statusLabel.setText("Member Selected");
					jTextField.setVisible(true);
					btn.setVisible(true);
					
			}});

	      radMango.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {             
	            statusLabel.setText("Non-Member Selected");
	            jTextField.setVisible(false);
				btn.setVisible(false);
	            dispose();
	            int transactId=lastTransactionIdLookup();
	            transactId=transactId+1;
	            System.out.println(transactId);
	            Transaction_Item transaction_Item=new Transaction_Item(transactId,"PUBLIC");
				showProductWindow(transaction_Item);
	            
	            
	         }           
	      });

	      btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					performSubmit();
					
			}});

	      
	      ButtonGroup group = new ButtonGroup();
	      group.add(radApple);
	      group.add(radMango);
	      

	      controlPanel.add(radApple);
	      controlPanel.add(radMango);
	      
	      controlPanel.add(jTextField);
	      controlPanel.add(btn);
	           

	      mainFrame.setVisible(true);  
	   }
	
		
	public void performSubmit(){
		Member member;
		if(jTextField.getText().length()>0){
			
		member=memberLookup(jTextField.getText());
		if(member.getName()!=null)
        {
			JOptionPane.showMessageDialog(this,member.getName()+"  Found");
			mainFrame.dispose();
			int transactionId=lastTransactionIdLookup();
			
			transactionId++;
			
			
			
			Transaction_Item transaction_Item=new Transaction_Item(transactionId,member.getMemberID());
			showProductWindow(transaction_Item);
        }
		else 
			{
			JOptionPane.showMessageDialog(this,"No member Found");
			jTextField.setText("");
			
			}
		}
		else 
			JOptionPane.showMessageDialog(this,"Please enter Member-Id");
		
			//popup---
	}
	
	
	//DataHandler2 data = new DataHandler2();
	
	public void showProductWindow(Transaction_Item t) {
		GUI();
		
		
		btn2.setVisible(true);
		btn3.setVisible(true);
		jTextField.setVisible(true);
		jTextField2.setVisible(true);
		headerLabel.setText("Enter Product ID");
		quantityLabel.setText("Quantity");
		statusLabel.setText("");
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product;
				String kString;
				kString=jTextField.getText();
				
					
				
				product=searchproductbyId(kString);
				if(product!=null){
				newlabel.setText("Product Name  :  "+product.getProductName()+
				              "\nProduct Description  :  "+product.getBriefDescription());
				}
				
		}});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product;
				String kString,quantity;
				headerLabel.setText("Wish to add more products? Please add product Id");
				
				kString=jTextField.getText();
				quantity=jTextField2.getText();
				product=searchproductbyId(kString);
				addtoCart(t,product,quantity);
				jTextField.setText("");
				jTextField2.setText("");
				newlabel.setText("");
				showProductWindow(t);
				btn4.setVisible(true);
				dispose();
				
				
				
		}});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					mainFrame.dispose();
					ProductDetailWindow productDetailWindow=new ProductDetailWindow(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}});
		
	    controlPanel.add(jTextField);
	    controlPanel.add(btn2);
	    controlPanel.add(newlabel);
	    
	    controlPanel.add(jTextField2);
	    controlPanel.add(quantityLabel);
	    controlPanel.add(btn3);
	    controlPanel.add(btn4);
		
		
		
	}*/

	public Product searchproductbyId(String Id){
		Product product=null;
		try {
			product=data.searchproductbyProductId(Id);
		} catch (NullPointerException e) {
			
		 JOptionPane.showMessageDialog(this,"Please enter correct Product ID");
		 jTextField.setText("");
		 btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Product product;
					String jString=jTextField.getText();
					product=searchproductbyId(jString);
					newlabel.setText("Product Name  :  "+product.getProductName()+
				              "\nProduct Description  :  "+product.getBriefDescription());
				
					
				}});
		 
			// TODO: handle exception
		}
		 
		//JOptionPane.showMessageDialog(this,""+product.getProductName());
		
		return product;
		
	}
	public void addtoCart(Transaction_Item t,Product p,String quantity){
		int Quantity=Integer.parseInt(quantity);
		addproducttoTransactionItem(t,p.getProductID(),Quantity);
	}
	public void addproducttoTransactionItem(Transaction_Item transaction_Item,String productId,Integer quantity) {
		int productAlreadyinCartflag=0;
		for(String id:transaction_Item.getTransactionItemshashmap().keySet()){
			if(id==productId)
			{
				transaction_Item.setTransactionItemshashmap(productId, quantity++);
				productAlreadyinCartflag=1;
			}
		}
		if(productAlreadyinCartflag!=1)
		{
		transaction_Item.setTransactionItemshashmap(productId,quantity);
		}
		int Q=0;
		for(String id:transaction_Item.getTransactionItemshashmap().keySet()){
			Q=Q+transaction_Item.getTransactionItemshashmap().get(id);
		}
		
		transaction_Item.setNumberofItemsinCart(Q);
		JOptionPane.showMessageDialog(this,"Product added into cart");
		System.out.println("No of items"+transaction_Item.NumberofItemsinCart+"TransactionId"+transaction_Item.transactionID+"HASHMAP"+transaction_Item.getTransactionItemshashmap());
		
	}
	
	public Member memberLookup(String memberId){
		Member member = null;
		//System.out.println(memberId);
		try{
			System.out.println(memberId);
		member=data.memberLookup(memberId);
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(this,"No Member Found");
		
		}
		return member;
		
		
		
	}
	public int lastTransactionIdLookup(){
		int lastTransactionId;
		
			 lastTransactionId=data.lastTransactionIdLookup();
			 System.out.println(lastTransactionId);
		
		
		return lastTransactionId;
	}
   
	public void checkStockbyId(String ID){
		
		data.checkStockbyId(ID);
		
	}
}
