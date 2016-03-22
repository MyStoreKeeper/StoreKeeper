package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import objects.Category;
import objects.Discount;
import objects.Member;
import objects.Product;
import objects.Storekeeper;
import objects.Transaction;
import objects.Transaction_Item;
import objects.Vendor;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


   

public class DataHandler2 {

	private HashMap<String, ArrayList<Product>> categoryHashmap;
	private HashMap<String, ArrayList<Product>> transactionItemhashmap;
	private ArrayList<Member> memberList;
	private ArrayList<Discount> discountList;
	private ArrayList<Category> categoryList;
	private ArrayList<Storekeeper> storekeeperList;
	private ArrayList<Transaction> transactionList;
	private HashMap<String, ArrayList<Vendor>> vendorCategoryHashmap;
	
	public static DataHandler2 data;
	
	

	public DataHandler2() {
		// TODO Auto-generated constructor stub
	}

	public static void initDataHandler() throws IOException{
		data = new DataHandler2();
		
	}
	
	public void initData(){
		
	}
	
	public static void main(String[] args) {
		
		
		
		
		
	}
	public void loadcategoryHashmap(){
		try {
			ArrayList<Product> productList;
			data = new DataHandler2();
			productList=new ArrayList<Product>();
			data.categoryHashmap=new HashMap<String, ArrayList<Product>>();
			Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/products.dat"));
			int i=0;
			while(inScanner.hasNextLine()){
				
				
				String text=inScanner.nextLine();
				String[] ar=text.split(",");
				Product product=new Product(ar[0],ar[1],ar[2],ar[3],ar[4],ar[5],ar[6],ar[7]);
				String[] category=ar[0].split("/");
				productList.add(product);
				data.categoryHashmap.put(category[0],productList);
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadtransactionData(){
		try {
			ArrayList<Transaction> transactionList;
			data = new DataHandler2();
			transactionList=new ArrayList<Transaction>();
			
			Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/transaction.dat"));
			int i=0;
			while(inScanner.hasNextLine()){
				
				
				String text=inScanner.nextLine();
				String[] ar=text.split(",");
				Transaction transaction=new Transaction(ar[0],ar[1],ar[2],ar[3],ar[4]);
				String[] category=ar[0].split("/");
				transactionList.add(transaction);
				
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Product searchproductbyProductId(String Id)
	{
		Product product;
		String category[]=Id.split("/");
		System.out.println(category[0]);
		
		product=searchproductbyCategory(category[0],Id);
	
		return product;
		
	}
	
	public Product searchproductbyCategory(String category,String Id){
		Product product = null;
		ArrayList<Product> productList=new ArrayList<Product>();
		productList=data.categoryHashmap.get(category);
		
		for(Product p:productList){
			if(p.productId!=null && p.productId.contains(Id))
			{
				product=p;
				break;
			}
			
		}
	
		return product;
	}

	public void addproducttoTransaction(Product p, String quantity){
		
		
		Transaction transaction=new Transaction();
		transaction=data.transactionList.get(data.transactionList.size()-1);
		int id=Integer.parseInt(transaction.getTransactionId());
		id=id+1;
		String newId=Integer.toString(id);
		transaction.setProductId(p.productId);
		transaction.setMemberId("");
		transaction.setQuantity(quantity);
		transaction.setTransactionId(newId);
		
		
		
		
		
		
		
		
		
	}
	
}
