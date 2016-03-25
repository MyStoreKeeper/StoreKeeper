import org.junit.Test;

import junit.framework.TestCase;
import objects.Member;

public class MemberTest extends TestCase {

	private Member m1 = new Member("Puja", "A00134", 0);
	private Member m2 = new Member("Puja", "A00134", 0);
	private Member m3 = new Member("Harsha", "A00136", 0);
	@Test
	public void test() {
		
		assertFalse (m1.equals(m3));
		assertEquals(m1,m2);
		assertEquals(m1.getPoint(),0);
		assertEquals(m2.getPoint(),0);
			
		}
	public void checkMemerIDNotNull(){
		assertNotSame(m1.getMemberID(),null);
		assertNotSame(m2.getMemberID(),null);
		assertNotSame(m3.getMemberID(),null);
	}
}
