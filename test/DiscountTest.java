import objects.Discount;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest extends TestCase {

	private Discount d1;
	private Discount d2;
	
	@Before
	public void setUp() throws Exception {
		d1 = new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		d2 = new Discount("DIS-2","ALL","Summer Discount","N/A",0,25.0);
	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
	}

	@Test
	public void testGetDiscountCode() {
		assertEquals("DIS-1", d1.getDiscountCode());
		assertEquals("DIS-2", d2.getDiscountCode());
	}

	@Test
	public void testGetDescription() {
		assertEquals("Special Discount", d1.getDescription());
		assertEquals("Summer Discount", d2.getDescription());
	}
	
	@Test
	public void testGetStartDate() {
		assertEquals("2-Apr-2016", d1.getStartDate());
		assertEquals("N/A", d2.getStartDate());
	}
	
	@Test
	public void testGetPeriodOfDiscount() {
		assertEquals(30, d1.getPeriodofDiscount());
		assertEquals(0, d2.getPeriodofDiscount());
	}
	
	@Test
	public void testGetPercentDiscount() {
		assertEquals(20.0, d1.getPercentageDiscount());
		assertEquals(25.0, d2.getPercentageDiscount());
	}


	@Test
	public void testEquals() {
		assertEquals(d1, new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0));
		assertFalse(d2.equals(new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0)));
		assertFalse(new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0).equals(d2));
		assertTrue(d2.equals(new Discount("DIS-2","ALL","Summer Discount","N/A",0,25.0)));
	}
}
