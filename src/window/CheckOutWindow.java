package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class CheckOutWindow extends JFrame {
	JPanel panel;
	
	public void CheckOutWindow(){
		
		String memberId="23";
		Member member=memberLookup(memberId);
		if(member.getMemberID()!=null)
		{
			memberId=member.getMemberID();
		}
		else
			memberId="PUBLIC";
		int LastTransactionId=Integer.parseInt(lastTransactionIdLookup());
		LastTransactionId++;
		
	   String TransactionId=Integer.toString(LastTransactionId);
		Transaction_Item transaction_Item=new Transaction_Item(TransactionId, memberId);
		ProductsShoppingWindow productsShoppingWindow=new ProductsShoppingWindow(transaction_Item);
		ProductDetailWindow productDetailWindow=new ProductDetailWindow(transaction_Item);
	     /* panel = new JPanel();
			panel.setLayout(null);
		JLabel memberIdLabel = new JLabel("Member Id");
		memberIdLabel.setBounds(32, 8, 90, 14);
			panel.add(memberIdLabel);
			JTextField memberId = new JTextField(10);
			memberId.setBounds(130, 5, 86, 20);
			panel.add(memberId);
			
			setTitle("Enter Member Id");
			setSize(500,300);
			setVisible(true);
	      
	      
	      JButton add = new JButton("Check");
	      add.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent e) {
	  			Member member=memberLookup(memberId.getText());
	  			if(member!=null){
	  				JOptionPane.showInputDialog(this,"Welocme"+member.getName());
	  			}
	  				
	  			else {
					
				}
	  		}
	  		});*/
		
		
		
		
	}
	
	DataHandler2 data = new DataHandler2();
	
	public Product searchproductbyId(String Id){
		data.loadcategoryHashmap();
		Product product=new Product();
		product=data.searchproductbyProductId(Id);
		System.out.println(product.productId);
		
		return product;
		
	}
	
	public void addproducttoTransaction(Product p,String quantity) {
		data.loadtransactionData();
		data.addproducttoTransaction(p,quantity);
		
	
		
	}
	public Member memberLookup(String memberId){
		Member member=data.memberLookup(memberId);
		return member;
		
		
		
	}
	public String lastTransactionIdLookup(){
		String lastTransactionId=data.lastTransactionIdLookup();
		return lastTransactionId;
	}

}
