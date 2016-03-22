package objects;

<<<<<<< Updated upstream
/**
 * 
 * @author Premraj M
 *
 */

public class Transaction_Item {
	
	
	private int transactionID;
	private String productID;
	private String memberID;
	private int quantityPurchased;
	private String date;
	
	
	public Transaction_Item(int transactionID, String productID, String memberID, int quantityPurchased, String date) {
		
		this.transactionID = transactionID;
		this.productID = productID;
		this.memberID = memberID;
		this.quantityPurchased = quantityPurchased;
		this.date = date;
	}


	public int getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public String getMemberID() {
		return memberID;
	}
=======
import java.util.ArrayList;

public class Transaction_Item {
public String cookie;
public String transactionId;
public ArrayList<Transaction> transactionList;
>>>>>>> Stashed changes


	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public int getQuantityPurchased() {
		return quantityPurchased;
	}


	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
		
	
}

