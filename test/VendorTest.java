import objects.Vendor;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendorTest extends TestCase {

	Vendor v1;
	Vendor v2;
	
	@Before
	public void setUp() throws Exception {
		v1 = new Vendor("Singapore Garments Ltd","High Quality Garments");
		v2 = new Vendor("Fashion Factory","Specializing in quality clothes");
	}

	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
	}

	@Test
	public void testGetName() {
		assertEquals("Singapore Garments Ltd", v1.getVendorName());
		assertEquals("Fashion Factory", v2.getVendorName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("High Quality Garments", v1.getDescription());
		assertEquals("Specializing in quality clothes", v2.getDescription());
	}

	@Test
	public void testEquals() {
		assertEquals(v1, new Vendor("Singapore Garments Ltd","High Quality Garments"));
		assertFalse(v2.equals(new Vendor("Singapore Garments Ltd","High Quality Garments")));
		assertFalse(new Vendor("Singapore Garments Ltd","High Quality Garments").equals(v2));
		assertTrue(v2.equals(new Vendor("Fashion Factory","Specializing in quality clothes")));
	}
}
