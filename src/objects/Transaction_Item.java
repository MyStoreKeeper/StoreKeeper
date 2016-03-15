package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Transaction_Item {
	
	private Transaction aTransaction;
	private int transactionID;
	
	
	public void setTransaction(Transaction aTransaction) {
		this.aTransaction = aTransaction;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	
}

