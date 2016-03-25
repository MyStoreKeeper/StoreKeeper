package objects;

import java.util.ArrayList;

public class StoreKeeperSession {
	public Storekeeper storekeeper;
	 ArrayList<Transaction_Item> transaction_Items;
 public StoreKeeperSession(Storekeeper storekeeper){
	 
	this.storekeeper=storekeeper;
	
	
	
}
 public void settransactionArraylist(Transaction_Item t){
	 this.transaction_Items.add(t);
	 
 }
}
