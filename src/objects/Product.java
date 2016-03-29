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
	private int barcode;
	
	public Product(String productID, String productName, String briefDescription, int quantity, double price,int barcode,
			int thresholdLimit, int placeOrder) {
		
		this.productID = productID;
		this.productName = productName;
		this.briefDescription = briefDescription;
		this.quantity = quantity;
		this.price = price;
		this.barcode=barcode;
		this.thresholdLimit = thresholdLimit;
		this.placeOrder = placeOrder;
	}
	
	public int getbarcode() {
		return barcode;
	}


	public void setbarcode(int barcode) {
		this.barcode = barcode;
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

	
	@Override
	/*public int hashCode() {
		final int prime = 31;
		int result = 1;
		int id = Integer.parseInt(getProductID().substring(0, 4));
		result = prime * result + id;
		return result;
	}*/
	
	public boolean equals(Object product) {
    	if (product instanceof Product) {
    		Product p = (Product) product;
    		if (this.getProductID().equals(p.getProductID()))
    			if (this.getBriefDescription().equals(p.getBriefDescription()))
    				if(this.getPlaceOrder() == p.getPlaceOrder())
    					if(this.getPrice() == p.getPrice())
    						if(this.getProductName().equals(p.getProductName()))
    							if(this.getQuantity() == p.getQuantity())
    								if(this.getThresholdLimit() == p.getThresholdLimit())
    									return true;
    		else return false;
    	}
    	return false;
    }
		
	}
