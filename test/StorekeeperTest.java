import objects.Storekeeper;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StorekeeperTest extends TestCase {

	Storekeeper sk1;
	Storekeeper sk2;
	
	@Before
	public void setUp() throws Exception {
		sk1 = new Storekeeper("Puja","Pass@123!");
		sk2 = new Storekeeper("Jane","jane@456");
	}

	@After
	public void tearDown() throws Exception {
		sk1 = null;
		sk2 = null;
	}

	@Test
	public void testGetName() {
		assertEquals("Puja", sk1.getName());
		assertEquals("Jane", sk2.getName());
	}

	@Test
	public void testGetPassword() {
		assertEquals("Pass@123!", sk1.getPassword());
		assertEquals("jane@456", sk2.getPassword());
	}

	@Test
	public void testEquals() {
		assertEquals(sk1, new Storekeeper("Puja","Pass@123!"));
		assertFalse(sk2.equals(new Storekeeper("Puja","Pass@123!")));
		assertFalse(new Storekeeper("Puja","Pass@123!").equals(sk2));
		assertTrue(sk2.equals(new Storekeeper("Jane","jane@456")));
	}
}
