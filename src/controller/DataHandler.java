package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import objects.Category;
import objects.Discount;
import objects.Member;
import objects.Product;
import objects.Storekeeper;
import objects.Transaction;
import objects.Vendor;

public class DataHandler {

	private HashMap<String, ArrayList<Product>> categoryHashmap = new HashMap<String,ArrayList<Product>>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<Discount> discountList = new ArrayList<Discount>();
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<Storekeeper> storekeeperList = new ArrayList<Storekeeper>();
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private HashMap<String, ArrayList<Vendor>> vendorCategoryHashmap = new HashMap<String, ArrayList<Vendor>>();
	
	private String loggedInUser;
	
	public static DataHandler data;
	
	public DataHandler(){
		
	}
	
	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	
	public Category getCategory(String catCode) {
		for(Category c : categoryList){
			if(c.getCode().equals(catCode)){
				return c;
			}
		}
		return null;
	}
	
	public ArrayList<Product> getProductsForCategory(String cat_code) {
		ArrayList<Product> catProducts = categoryHashmap.get(cat_code);
		return catProducts;
	}

	public void addMember(String name,String id){
		Member m = new Member(name,id,0);
		memberList.add(m);
	}
	
	public void addCategory(String name,String code){
		Category c = new Category(name,code);
		categoryList.add(c);
	}
	
	public void addDiscount(String discountCode,String discountType, String description, 
			String startDate,int periodofDiscount,
			double percentageDiscount){
		Discount d = new Discount(discountCode,discountType,description, startDate,periodofDiscount,percentageDiscount);
		discountList.add(d);
	}
	
	public boolean checkExistingCatgory(String code){
		for(Category cat : categoryList){
			if(cat.getCode().equals(code)){
				return true;
			}
		}
		return false;	
	}
	
	public void addToCategoryVendorMap(String catCode,String vName,String vDesc){
		Vendor v = new Vendor(vName,vDesc);
		ArrayList<Vendor> catVendors = vendorCategoryHashmap.get(catCode);
		if(catVendors == null){
			System.out.println("Adding vendor to category");
			catVendors = new ArrayList<Vendor>();
			catVendors.add(v);
			vendorCategoryHashmap.put(catCode, catVendors);
			System.out.println(vendorCategoryHashmap.get(catCode).get(0).getVendorName());
		}
		else{
			System.out.println("Adding vendor to category in else");
			catVendors.add(v);
		}
	}
	
	public ArrayList<Vendor> getVendorsFromMap(String catCode){
		ArrayList<Vendor> catVendors = vendorCategoryHashmap.get(catCode);
		return catVendors;
	}
	
	public void addProduct(String catCode,String productID, String productName, String briefDescription, int quantity, double price,
			int thresholdLimit, int placeOrder){
		Product p = new Product(productID,productName,briefDescription,quantity,price,thresholdLimit,placeOrder);
		productList.add(p);
		addToCategoryProductMap(catCode,p);
	}
	
	public void addToCategoryProductMap(String catCode,Product p){
		ArrayList<Product> catProducts = categoryHashmap.get(catCode);
		if(catProducts == null){
			catProducts = new ArrayList<Product>();
			catProducts.add(p);
			categoryHashmap.put(catCode, catProducts);
		}
		else{
			catProducts.add(p);
		}
	}
	
	public boolean checkExistingMember(String id){
		for(Member mem : memberList){
			if(mem.getMemberID().equals(id)){
				return true;
			}
		}
		return false;	
	}
	
	public void removeMember(Member m){
		memberList.remove(m);
	}
	
	public void removeDiscount(Discount d){
		discountList.remove(d);
	}
	
	public void removeProduct(Product p,String catCode){
		productList.remove(p);
		ArrayList<Product> catProducts = categoryHashmap.get(catCode);
		catProducts.remove(p);	
	}
	
	public void removeCategory(Category c, String code){
		categoryList.remove(c);
		categoryHashmap.remove(code);
		vendorCategoryHashmap.remove(code);
	}
	
	public void removeVendorFromCategory(String catCode,Vendor v){
		ArrayList<Vendor> vendorCat = vendorCategoryHashmap.get(catCode);
		vendorCat.remove(v);
	}
	
	public ArrayList<Product> getProductList(){
		return productList;
	}
	
	public ArrayList<Product> getInventoryList(){
		ArrayList<Product> inventory = new ArrayList<Product>();
		for(Product p : productList){
			if(p.getQuantity() <= p.getThresholdLimit()){
				inventory.add(p);
			}
		}
		return inventory;
	}
	
	public void orderProduct(Product p){
		int new_quan = p.getPlaceOrder()+p.getQuantity();
		p.setQuantity(new_quan);
	}
	
	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	public ArrayList<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(ArrayList<Discount> discountList) {
		this.discountList = discountList;
	}

	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<Storekeeper> getStorekeeperList() {
		return storekeeperList;
	}

	public void setStorekeeperList(ArrayList<Storekeeper> storekeeperList) {
		this.storekeeperList = storekeeperList;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public static void initDataHandler(){
		data = new DataHandler();
	}
	
	public void initData(){
		
	}
	public void nnnnnn() {
		System.out.println("ggggg");
	}

	//Signup -StoreKeeper

	public void addStorekeeper(String username,String password){
		
		Storekeeper storekeeper = new Storekeeper(username, password);
		storekeeperList.add(storekeeper);
	}

	public String getLoggedInUser(){
		return loggedInUser;
	}
	public void setLoggedInUser(String username){
		this.loggedInUser = username; 
	}
	
	// Login -Check valid Store keeper
	public boolean checkStorekeeper(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (int i=0;i<storekeeperList.size();i++) {
			String un = storekeeperList.get(i).getName();
			String pass = storekeeperList.get(i).getPassword();
			
			System.out.println("ppp" +un);
			System.out.println("ppp"+pass);
			if(username.equals(un) && password.equals(pass)){
				flag++;
			}	
		}
		if (flag != 0) {
			setLoggedInUser(username);
			System.out.println("matched!!");
			return true;
			
		}
		else{
			return false;
		}
		
	}
	
	// Signup - Avoid user duplication
	public boolean checkDuplicateStorekeeper (String username, String password){
		int flag = 0;
		for (int i=0;i<storekeeperList.size();i++) {
			String un = storekeeperList.get(i).getName();
			String pass = storekeeperList.get(i).getPassword();
			
			System.out.println("ppp" +un);
			System.out.println("ppp"+pass);
			if(username.equals(un)){
				flag++;
			}	
		}
		if (flag != 0) {
			System.out.println("New User!!");
			return false;
			
		}
		else{
			return true;
		}
		
	}
	
}
