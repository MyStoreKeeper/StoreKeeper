package objects;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
=======
/**
 * 
 * @author Premraj M
 *
 */
>>>>>>> origin/master

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
<<<<<<< HEAD


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


=======
	
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	
	public String getPurchaseDate() {
		return date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionID;
		return result;
	}
	
	public boolean equals(Object transactionItem) {
    	if (transactionItem instanceof Transaction_Item){
    		Transaction_Item item = (Transaction_Item) transactionItem;
    		if (this.getMemberID().equals(item.getMemberID()))
    			if (this.getProductID().equals(item.getProductID()))
    				if(this.getQuantityPurchased() == item.getQuantityPurchased())
    					if(this.getPurchaseDate().equals(item.getPurchaseDate()))
    						if(this.getTransactionID() == item.getTransactionID())
    							return true;
    		else return false;
    	}
    	return false;
    }
}
>>>>>>> origin/master
