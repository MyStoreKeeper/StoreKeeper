package objects;

public class Member extends Customer{
	
	private int point;
	
	public Member(String name,String memberID) {
		super(name, memberID);
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
