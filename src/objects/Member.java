package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Member extends Customer{
	
	private int point;
	
	public Member(){
		super();
	};
	public Member(String name,String memberID, int point) {
		super(name, memberID);
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + point;
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		super.equals(other);
		if (!getMemberID().equals(other.getMemberID()))
			return false;
		return true;
	}
	
}
