package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Product {

	private String productID;
	private String productName;
	private String briefDescription;
	private int quantity;
	private double price;
	private int thresholdLimit;
	private int placeOrder;
	private int limit;
	
	
	public Product(String productID, String productName, String briefDescription, int quantity, double price,
			int thresholdLimit, int placeOrder, int limit) {
		
		this.productID = productID;
		this.productName = productName;
		this.briefDescription = briefDescription;
		this.quantity = quantity;
		this.price = price;
		this.thresholdLimit = thresholdLimit;
		this.placeOrder = placeOrder;
		this.limit = limit;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getBriefDescription() {
		return briefDescription;
	}


	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getThresholdLimit() {
		return thresholdLimit;
	}


	public void setThresholdLimit(int thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
	}


	public int getPlaceOrder() {
		return placeOrder;
	}


	public void setPlaceOrder(int placeOrder) {
		this.placeOrder = placeOrder;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}
		
	}
