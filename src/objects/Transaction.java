package objects;

import java.util.ArrayList;

/**
 * 
 * @author Premraj M
 *
 */

public class Transaction  {
	
	private Transaction_Item aTransaction;
	
	ArrayList<Transaction_Item> generateTxn= new ArrayList<Transaction_Item>();
	
	
	public Transaction_Item getaTransaction() {
		return aTransaction;
	}
	public void setaTransaction(Transaction_Item aTransaction) {
		this.aTransaction = aTransaction;
	}
		

}
