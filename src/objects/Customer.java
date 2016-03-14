package objects;

public class Customer {
	
	private String name;
	private String memberID;
	
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
}
