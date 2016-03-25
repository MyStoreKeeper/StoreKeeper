package window;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

import controller.DataHandler2;
import objects.Product;
import objects.Transaction_Item;

public class ProductDetailWindow extends JFrame {
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
	JButton deleteButton;
	JButton modifyQuantityButton;
	JButton btn3 = new JButton("Add to Cart");
	JButton btn4 = new JButton("Proceed to cart");
	JTextArea textArea;
	
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
			
		  
		  
		 
		  
		
		  
			
		  btn4.setBounds(0, 0, 2, 22);
		  btn4.setVisible(false);
		  
	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);

	      mainFrame.setVisible(true); 
	      
	}
	public ProductDetailWindow(Transaction_Item transaction_Item) throws IOException{
		System.out.println("new"+transaction_Item.TransactionItemshashmap);
		data=new DataHandler2();
		GUI();
		displayProducts(transaction_Item);
		String id="";
		int quantity=0;
		deleteProduct(transaction_Item,id);
		modifyQuantity(id,quantity,transaction_Item);
	}
	public void displayProducts(Transaction_Item T){
		T.TransactionItemshashmap=T.getTransactionItemshashmap();
		displayProductsGUI(T);
		//display all the products
	}
	public void displayProductsGUI(Transaction_Item t) {
		Product product = null;
		int quantity;
		headerLabel.setText("Products Selected");
		System.out.println(t.TransactionItemshashmap.isEmpty());
		if(t.TransactionItemshashmap.isEmpty()!=true)
		{
			for(String id:t.TransactionItemshashmap.keySet()){
		
			System.out.println("Hashmap PDW"+id);
			
				
			product=data.searchproductbyProductId(id);
			quantity=t.TransactionItemshashmap.get(id);
			displayProductGUI(product, quantity,t);
			}
		}
			else
			{
				textArea=new JTextArea("No products in Cart");
				
			}
		
	
		// TODO Auto-generated method stub
		
	}
	public void displayProductGUI(Product p,int q,Transaction_Item T){
		textArea=new JTextArea("Prodcut Name      "+p.getProductName()+"\n"+"Quantity         "+q);
		deleteButton = new JButton("Delete");
		  deleteButton.setBounds(0, 0, 2, 22);
		  modifyQuantityButton=new JButton("Modify Quantity");
		  modifyQuantityButton.setBounds(0, 0, 2, 22);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		T.TransactionItemshashmap.remove(p.getProductID());
		System.out.println(T.TransactionItemshashmap);
		dispose();
		try {
			new ProductDetailWindow(T);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}});
		jTextField.setVisible(true);
		
		modifyQuantityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		T.setTransactionItemshashmap(p.getProductID(),5);
		
			}});
		
		textArea.setEditable(false);
		
		controlPanel.add(textArea);
		controlPanel.add(deleteButton);
		controlPanel.add(modifyQuantityButton);
		
		
		
	}
	
	public void deleteProduct(Transaction_Item t,String productId){
		t.TransactionItemshashmap.remove(productId);
	}
	public void modifyQuantity(String productId,int newQuantity,Transaction_Item t){
		t.TransactionItemshashmap.put(productId, newQuantity);
		
	}
	public void confirmTransaction(Transaction_Item t){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   //get current date time with Date()
		   Date date = new Date();
		   
		for(String id:t.TransactionItemshashmap.keySet())
		{
			data.addproducttoTransaction(t.transactionID,t.memberID,t.TransactionItemshashmap.get(id),id,dateFormat.format(date));
		}
	}
	
	
	

}
