package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Vendor  {
	private String vendorName;
	private String description;
	
	
	
	public Vendor(String vendorName, String description) {
		this.vendorName=vendorName;
		this.description=description;
	
	}



	public String getVendorName() {
		return vendorName;
	}



	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean equals(Object vendor) {
    	if (vendor instanceof Vendor){
    		Vendor v = (Vendor) vendor;
    		if (this.getVendorName().equals(v.getVendorName()))
    			if (this.getDescription().equals(v.getDescription()))
    				return true;
    		else return false;
    	}
    	return false;
    }
}
