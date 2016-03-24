import objects.Product;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ProductTest extends TestCase {
	
	private Product p1;
	private Product p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		p2 = new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Test
	public void testGetProductID() {
		assertEquals("CLO/1", p1.getProductID());
		assertEquals("CLO/2", p2.getProductID());
	}

	@Test
	public void testGetProductName() {
		assertEquals("Shirt", p1.getProductName());
		assertEquals("Skirt", p2.getProductName());
	}
	
	@Test
	public void testGetProductDescription() {
		assertEquals("Cotton Shirts", p1.getBriefDescription());
		assertEquals("Pleated Skirts", p2.getBriefDescription());
	}
	
	@Test
	public void testGetQuantity() {
		assertEquals(100, p1.getQuantity());
		assertEquals(80, p2.getQuantity());
	}
	
	@Test
	public void testGetThreshold() {
		assertEquals(20, p1.getThresholdLimit());
		assertEquals(10, p2.getThresholdLimit());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(30.0, p1.getPrice());
		assertEquals(35.0, p2.getPrice());
	}
	
	@Test
	public void testGetPlaceOrder() {
		assertEquals(50, p1.getPlaceOrder());
		assertEquals(50, p2.getPlaceOrder());
	}


	@Test
	public void testEquals() {
		assertEquals(p1, new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50));
		assertFalse(p2.equals(new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50)));
		assertFalse(new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50).equals(p2));
		assertTrue(p2.equals(new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,10,50)));
	}

}
