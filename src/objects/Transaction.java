package objects;

import java.util.ArrayList;

/**
 * 
 * @author Premraj M
 *
 */

public class Transaction  {
	
	private Transaction_Item aTransaction;
	private ArrayList<Transaction_Item> generateTxn;
	
	
	public ArrayList<Transaction_Item> getTxn(){
		return generateTxn;
	}
	
	public void setTxn(ArrayList<Transaction_Item> generateTxn){
		this.generateTxn=generateTxn;
	}
	
	
	public Transaction_Item getaTransaction() {
		return aTransaction;
	}
	public void setaTransaction(Transaction_Item aTransaction) {
		this.aTransaction = aTransaction;
	}
		
}
