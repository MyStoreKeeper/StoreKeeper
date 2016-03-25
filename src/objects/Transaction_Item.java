package objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Transaction_Item {
	
	
	public int transactionID;
	
	public String memberID;
	
	
	public HashMap<String,Integer> TransactionItemshashmap;
	
	public int NumberofItemsinCart;
	
	public double totalCost;
	
	



	public HashMap<String, Integer> getTransactionItemshashmap() {
		return TransactionItemshashmap;
	}


	public void setTransactionItemshashmap(String id,int quantity) {
		
		this.TransactionItemshashmap.put(id, quantity);
		}


	public int getNumberofItemsinCart() {
		return NumberofItemsinCart;
	}


	public void setNumberofItemsinCart(int numberofItemsinCart) {
		this.NumberofItemsinCart = numberofItemsinCart;
	}


	public void setTransactionID(int transactionId2) {
		this.transactionID = transactionId2;
	}


	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public Transaction_Item(int transactionId2, String memberID) {
		super();
		setTransactionID(transactionId2);
		setMemberID(memberID);
		this.TransactionItemshashmap=new HashMap<String, Integer>();
		//setNumberofItemsinCart(numberofItemsinCart);
		
		//setTransactionItemshashmap(transactionItemshashmap);
		
		
	}


	
 

	
}


