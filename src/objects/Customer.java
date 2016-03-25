package objects;

/**
 * 
 * @author Wu
 *
 */

public class Customer {
	
	
	private String name;
	private String memberID;
	public Customer(){};
	public Customer(String name,String memberID) {
		this.name = name;
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public boolean equals(Object customer){
    	if (customer instanceof Customer){
    		Customer c = (Customer)customer;
    	   	if (this.getName().equals(c.getName()))
    		if (this.getMemberID() == null){
    			if (c.getMemberID() == null)
    				return true;
    			else return false;
    		}else if (c.getMemberID() !=null)
    			if (this.getMemberID().equals(c.getMemberID()))
    				return true;
    	}
    	return false;
    }
}
