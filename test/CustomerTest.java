import objects.Customer;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
public class CustomerTest extends TestCase {

	// Test Fixtures
		private Customer c1 = null;
		private Customer c2 = null;
		
		@Before
		public void setUp() throws Exception {
			c1 = new Customer ("Puja", "A00134");
			c2 = new Customer ("Priya",null);
		}

		@After
		public void tearDown() throws Exception {
			c1 = null;
			c2 = null;
		}

		@Test
		public void testPerson() {

			assertEquals("Puja", c1.getName());
			assertEquals("A00134", c1.getMemberID());

			
			assertEquals("Priya", c2.getName());
			assertNull(c2.getMemberID());	
		}

		@Test
		public void testGetName() {
			assertEquals ("Puja", c1.getName());
			assertEquals ("Priya", c2.getName());
		}

		@Test
		public void testGetMemeberID() {
			assertEquals("Puja", c1.getName());
			assertNull(c2.getMemberID());	
		}


		@Test
		public void testEquals() {
			assertSame(c1,c1);
			assertSame(c2,c2);
			
			assertEquals(c1, new Customer("Puja","A00134"));
			assertEquals(c2, new Customer("Priya", null));
			
			assertFalse(c1.equals(c2));
			assertFalse(c2.equals(c1));
			
			Customer c3 = new Customer("Harsha",null);
			assertFalse(c1.equals(c3));
			assertFalse(c3.equals(c1));
			Customer c4 = new Customer ("Wu","A00135");
			assertFalse(c2.equals(c4));
			assertFalse(c4.equals(c2));
		}
}
