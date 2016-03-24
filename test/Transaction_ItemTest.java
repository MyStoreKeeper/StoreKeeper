import objects.Transaction_Item;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class Transaction_ItemTest extends TestCase {
	
	private Transaction_Item item1;
	private Transaction_Item item2;
	
	@Before
	public void setUp() throws Exception {
		item1 = new Transaction_Item(1,"CLO/1","A00134",1,"23-Mar-2016");
		item2 = new Transaction_Item(2,"CLO/2","A00135",2,"24-Mar-2016");
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		item2 = null;
	}

	@Test
	public void testGetTransactionID() {
		assertEquals(1, item1.getTransactionID());
		assertEquals(2, item2.getTransactionID());
	}

	@Test
	public void testGetProductID() {
		assertEquals("CLO/1", item1.getProductID());
		assertEquals("CLO/2", item2.getProductID());
	}
	
	@Test
	public void testGetMemberID() {
		assertEquals("A00134", item1.getMemberID());
		assertEquals("A00135", item2.getMemberID());
	}
	
	@Test
	public void testGetQuantity() {
		assertEquals(1, item1.getQuantityPurchased());
		assertEquals(2, item2.getQuantityPurchased());
	}
	
	@Test
	public void testGetDate() {
		assertEquals("23-Mar-2016", item1.getPurchaseDate());
		assertEquals("24-Mar-2016", item2.getPurchaseDate());
	}
	
	@Test
	public void testEquals() {
		assertEquals(item1, new Transaction_Item(1,"CLO/1","A00134",1,"23-Mar-2016"));
		assertFalse(item2.equals(new Transaction_Item(1,"CLO/1","A00134",1,"23-Mar-2016")));
		assertFalse(new Transaction_Item(1,"CLO/1","A00134",1,"23-Mar-2016").equals(item2));
		assertTrue(item2.equals(new Transaction_Item(2,"CLO/2","A00135",2,"24-Mar-2016")));
	}

}
