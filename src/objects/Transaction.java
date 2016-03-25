package objects;

/*<<<<<<< Updated upstream
import java.util.ArrayList;

/**
 * 
 * @author Premraj M
 *
 

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
		

=======*/
import java.sql.Date;

public class Transaction {

	private int TransactionId;
	private String ProductId;
	private String MemberId;
	private int quantity;
	private String date; 
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(int TransactionId,String ProductId,String MemberId,int quantity,String date) {
		// TODO Auto-generated constructor stub
		this.setTransactionId(TransactionId);
		this.setDate(date);
		this.setMemberId(MemberId);
		this.setProductId(ProductId);
		this.setQuantity(quantity);
		this.setDate(date);
		
	}
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity2) {
		this.quantity = quantity2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
