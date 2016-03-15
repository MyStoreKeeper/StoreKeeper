package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Member extends Customer{
	
	private int point;
	
	public Member(String name,String memberID, int point) {
		super(name, memberID);
		this.point=point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
