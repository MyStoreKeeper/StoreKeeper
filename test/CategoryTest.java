import objects.Category;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest extends TestCase {

	private Category c1;
	private Category c2;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Category("Clothes","CLO");
		c2 = new Category("Stationary", "STA");
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}
	
	@Test
	public void testFacilityString() {
		assertEquals("Clothes", c1.getName());
		assertEquals("CLO", c1.getCode());
	}

	@Test
	public void testGetName() {
		assertEquals("Clothes", c1.getName());
		assertEquals("Stationary", c2.getName());
	}

	@Test
	public void testGetCode() {
		assertEquals("CLO", c1.getCode());
		assertEquals("STA", c2.getCode());
	}


	@Test
	public void testEquals() {
		assertEquals(c1, new Category("Clothes","CLO"));
		assertFalse(c2.equals(new Category("Clothes","CLO")));
		assertFalse(new Category("Clothes","CLO").equals(c2));
		assertTrue(c2.equals(new Category("Stationary","STA")));
	}
}
