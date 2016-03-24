package objects;

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