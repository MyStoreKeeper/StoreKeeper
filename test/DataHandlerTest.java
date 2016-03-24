import controller.DataHandler;
import junit.framework.TestCase;
import objects.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataHandlerTest extends TestCase {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetMemberList(){
		DataHandler data = new DataHandler();
		ArrayList<Member> members = data.getMemberList();
		assertTrue(members.size() == 0);
		
		data.addMember("M1", "M1");
		data.addMember("M2", "M2");
		data.addMember("M3", "M3");
		
		members = data.getMemberList();
		assertTrue(members.size() == 3);
	}
	
	public void testGetProductList(){
		DataHandler data = new DataHandler();
		ArrayList<Product> products = data.getProductList();
		assertTrue(products.size() == 0);
		
		data.addProduct("CLO","CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		data.addProduct("CLO","CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		
		products = data.getProductList();
		assertTrue(products.size() == 2);
	}
	
	public void testGetCategoryList(){
		DataHandler data = new DataHandler();
		ArrayList<Category> category = data.getCategoryList();
		assertTrue(category.size() == 0);
		
		data.addCategory("Clothes","CLO");
		data.addCategory("Stationary", "STA");
		
		category = data.getCategoryList();
		assertTrue(category.size() == 2);
	}
	
	public void testGetStorekeeperList(){
		DataHandler data = new DataHandler();
		ArrayList<Storekeeper> storekeepers = data.getStorekeeperList();
		assertTrue(storekeepers.size() == 0);
		
		//data.addStorekeeper("San","san@123");
		//data.addStorekeeper("Ram","Ram@123");
		
		//storekeepers = data.getStorekeeperList();
		//assertTrue(storekeepers.size() == 2);
	}
	
	public void testGetDiscountList(){
		DataHandler data = new DataHandler();
		ArrayList<Discount> discounts = data.getDiscountList();
		assertTrue(discounts.size() == 0);
		
		data.addDiscount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		data.addDiscount("DIS-2","ALL","Summer Discount","N/A",0,25.0);
		
		discounts = data.getDiscountList();
		assertTrue(discounts.size() == 2);
	}
	
	public void testAddMember(){
		DataHandler data = new DataHandler();
		Member m = new Member("Puja", "A00134",0);
		data.addMember("Puja", "A00134");
		assertEquals(m, data.getMemberList().get(0));
	}
	
	public void testAddCategory(){
		DataHandler data = new DataHandler();
		Category c = new Category("Clothes","CLO");
		data.addCategory("Clothes", "CLO");
		assertEquals(c, data.getCategoryList().get(0));
	}
	
	public void testAddDiscount(){
		DataHandler data = new DataHandler();
		Discount d = new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		data.addDiscount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		assertEquals(d, data.getDiscountList().get(0));
	}
	
	public void testAddProduct(){
		DataHandler data = new DataHandler();
		Product p = new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		data.addProduct("CLO","CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		assertEquals(p, data.getProductList().get(0));
	}
	
	public void testGetProductForCategory(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		ArrayList<Product> prodCat = data.getProductsForCategory("CLO");
		assertTrue(prodCat == null);
		data.addProduct("CLO","CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		prodCat = data.getProductsForCategory("CLO");
		assertEquals(prodCat.get(0),data.getProductList().get(0));
	}
	
	public void testCheckExistingCategory(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Category c = new Category("Stationary","STA");
		assertFalse(data.checkExistingCatgory(c.getCode()));
		Category c1 = new Category("Clothing","CLO");
		assertTrue(data.checkExistingCatgory(c1.getCode()));
	}
	
	public void testCheckExistingMember(){
		DataHandler data = new DataHandler();
		data.addMember("Puja", "A00134");
		Member m = new Member("Jane", "A00135",0);
		assertFalse(data.checkExistingMember(m.getMemberID()));
		Member m1 = new Member("Ram","A00134",0);
		assertTrue(data.checkExistingMember(m1.getMemberID()));
	}
	
	public void testGetVendorsFromMap(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Vendor v = new Vendor("Biz Clothes","Provides Formal Wear");
		ArrayList<Vendor> venList = data.getVendorsFromMap(data.getCategoryList().get(0).getCode());
		assertTrue(venList == null);
		
		data.addToCategoryVendorMap("CLO", "Biz Clothes","Provides Formal Wear");
		venList = data.getVendorsFromMap("CLO");
		assertEquals(v,venList.get(0));
	}
	
	public void testAddToCategoryVendorMap(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Vendor v = new Vendor("Biz Clothes","Provides Formal Wear");
		data.addToCategoryVendorMap("CLO", "Biz Clothes","Provides Formal Wear");
		assertEquals(v,data.getVendorsFromMap("CLO").get(0));
		
	}
	public void testAddToCategoryProductMap(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Product p = new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		data.addToCategoryProductMap("CLO", p);
		assertEquals(p,data.getProductsForCategory("CLO").get(0));
		
	}
	
	public void testRemoveMember(){
		DataHandler data = new DataHandler();
		Member m1 = new Member("Puja","A00134",0);
		Member m2 = new Member("Sita","A00135",0);
		data.addMember("Puja","A00134");
		data.addMember("Sita","A00135");
		ArrayList<Member> members = data.getMemberList();
		assertEquals(members.get(0),m1);
		assertEquals(members.get(1),m2);
		data.removeMember(m1);
		assertNotSame(members.get(0),m1);
		assertEquals(members.get(0),m2);
	}
	
	public void testRemoveProduct(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Product p1 = new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		Product p2 = new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		data.addProduct("CLO","CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		data.addProduct("CLO","CLO/2","Skirt","Pleated Skirts",80,35.0,10,50);
		data.addToCategoryProductMap("CLO", p1);
		data.addToCategoryProductMap("CLO", p2);
		
		ArrayList<Product> products = data.getProductList();
		ArrayList<Product> prodCat = data.getProductsForCategory("CLO");
		
		assertEquals(products.get(0),p1);
		assertEquals(products.get(1),p2);
		assertEquals(prodCat.get(0),p1);
		assertEquals(prodCat.get(1),p2);
		
		data.removeProduct(p1,"CLO");
		
		assertNotSame(products.get(0),p1);
		assertNotSame(prodCat.get(0),p1);
		assertEquals(products.get(0),p2);
		assertEquals(prodCat.get(0),p2);
	}
	
	public void testRemoveCategory(){
		DataHandler data = new DataHandler();
		Category c1 = new Category("Clothes", "CLO");
		Category c2 = new Category("Stationary", "STA");
		data.addCategory("Clothes", "CLO");
		data.addCategory("Stationary", "STA");
		Product p = new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		data.addProduct("CLO","CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		Vendor v = new Vendor("Biz Clothes","Provides Formal Wear");
		data.addToCategoryVendorMap("CLO", "Biz Clothes","Provides Formal Wear");
		ArrayList<Category> category = data.getCategoryList();
		ArrayList<Product> prodCat = data.getProductsForCategory("CLO");
		ArrayList<Vendor> venList = data.getVendorsFromMap("CLO");
		assertEquals(category.get(0),c1);
		assertEquals(prodCat.get(0),p);
		assertEquals(venList.get(0),v);
		
		data.removeCategory(c1,"CLO");
		prodCat = data.getProductsForCategory("CLO");
		venList = data.getVendorsFromMap("CLO");
		
		assertNotSame(category.get(0),c1);
		assertEquals(category.get(0),c2);
		assertTrue(prodCat == null);
		assertTrue(venList == null);
	}
	
	public void testRemoveDiscount(){
		DataHandler data = new DataHandler();
		Discount d1 = new Discount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		Discount d2 = new Discount("DIS-2","ALL","Summer Discount","N/A",0,25.0);
		data.addDiscount("DIS-1","MEMBER","Special Discount","2-Apr-2016",30,20.0);
		data.addDiscount("DIS-2","ALL","Summer Discount","N/A",0,25.0);
		ArrayList<Discount> discounts = data.getDiscountList();
		assertEquals(discounts.get(0),d1);
		assertEquals(discounts.get(1),d2);
		data.removeDiscount(d1);
		assertNotSame(discounts.get(0),d1);
		assertEquals(discounts.get(0),d2);
	}
	
	public void testRemoveVendorFromCategory(){
		DataHandler data = new DataHandler();
		data.addCategory("Clothes", "CLO");
		Vendor v1 = new Vendor("Biz Clothes","Provides Formal Wear");
		Vendor v2 = new Vendor("Fashion Factory","Specializing in quality clothes");
		data.addToCategoryVendorMap("CLO", "Biz Clothes","Provides Formal Wear");
		data.addToCategoryVendorMap("CLO", "Fashion Factory","Specializing in quality clothes");
		ArrayList<Vendor> venList = data.getVendorsFromMap("CLO");
		assertEquals(venList.get(0),v1);
		data.removeVendorFromCategory("CLO", v1);
		assertNotSame(venList.get(0),v1);
		assertEquals(venList.get(0),v2);
	}
	
	public void testGetInvetoryList(){
		DataHandler data = new DataHandler();
		Product p1 = new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		Product p2 = new Product("CLO/2","Skirt","Pleated Skirts",80,35.0,90,50);
		data.addProduct("CLO","CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		data.addProduct("CLO","CLO/2","Skirt","Pleated Skirts",80,35.0,90,50);
		ArrayList<Product> inventory = data.getInventoryList();
		assertSame(inventory.size(),1);
		assertEquals(inventory.get(0),p2);
		assertNotSame(inventory.get(0),p1);
	}
	
	public void testOrderProduct(){
		DataHandler data = new DataHandler();
		Product p = new Product("CLO/1","Shirt","Cotton Shirts",100,30.0,20,50);
		assertSame(p.getQuantity(),100);
		data.orderProduct(p);
		assertEquals(p.getQuantity(),150);
	}
	
	
	
}
