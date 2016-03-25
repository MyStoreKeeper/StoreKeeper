package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.crypto.Data;

import org.omg.CORBA.PUBLIC_MEMBER;
import controller.DataHandler2;
import objects.Discount;
import objects.Discount_Member;
import objects.Member;
import objects.Product;
import objects.Transaction;
import objects.Transaction_Item;
import window.*;

public class DataFileController2 {
	
	public DataFileController2() throws IOException {
		
		
		// TODO Auto-generated constructor stub
	}
	
		
	public HashMap<String, ArrayList<Product>> loadcategoryHashmap(){
		HashMap<String, ArrayList<Product>> categoryHashmap=new HashMap<String, ArrayList<Product>>();
		try {
			 
			
			
			 ArrayList<Product> productList=new ArrayList<Product>();
			 
			Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/products.dat"));
			
			while(inScanner.hasNextLine()){
				
				
				String text=inScanner.nextLine();
				String[] ar=text.split(",");
				Product product=new Product(ar[0],ar[1],ar[2],Integer.parseInt(ar[3]),Double.parseDouble(ar[4]),Integer.parseInt(ar[5]),Integer.parseInt(ar[6]),Integer.parseInt(ar[7]));
				String[] category=ar[0].split("/");
				productList.add(product);
				categoryHashmap.put(category[0],productList);
				
				
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryHashmap;
		
	}
		
	public ArrayList<Discount_Member> loadMemberDiscount(){
		ArrayList<Discount> discountList=new ArrayList<Discount>();
		ArrayList<Discount_Member> memberdiscountList=new ArrayList<Discount_Member>();
		try {
			
			Discount discount;
			Discount_Member discount_Member;
			
			
			Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/Discount.dat"));
			int i=0;
			while(inScanner.hasNextLine()){
				
				
				String text=inScanner.nextLine();
				String[] ar=text.split(",");
				
				
				discount_Member=new Discount_Member(ar[0],ar[1],ar[2],ar[3],Double.parseDouble(ar[4]));
				
				
				memberdiscountList.add(discount_Member);
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberdiscountList;
		
	}
	public ArrayList<Discount> loadGeneralDiscount(){
		ArrayList<Discount> discountList=new ArrayList<Discount>();
		ArrayList<Discount_Member> memberdiscountList=new ArrayList<Discount_Member>();
		try {
			
			Discount discount;
			Discount_Member discount_Member;
			
			
			Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/Discount.dat"));
			int i=0;
			while(inScanner.hasNextLine()){
				
				
				String text=inScanner.nextLine();
				String[] ar=text.split(",");
				if(ar[5].compareTo("M")!=0)
				{
				discount=new Discount(ar[0],ar[1],ar[2],ar[3],Double.parseDouble(ar[4]));
				
				discountList.add(discount);
				}
				
				
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discountList;
		
	}
		
		
		public ArrayList<Transaction> loadtransactionData(){
			ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
			try {
				
				//data = new DataHandler2();
				transactionList=new ArrayList<Transaction>();
				
				Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/transaction.dat"));
				int i=0;
				while(inScanner.hasNextLine()){
					
					
					String text=inScanner.nextLine();
					String[] ar=text.split(",");
					System.out.println("controller"+ar);
					Transaction transaction=new Transaction(Integer.parseInt(ar[0]),ar[1],ar[2],Integer.parseInt(ar[3]),ar[4]);
					
					transactionList.add(transaction);
					
					
					
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return transactionList;
		}
		public ArrayList<Member> loadMemberdata(){
			ArrayList<Member> memberList=new ArrayList<Member>() ;
			try {
				
				
				Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/member.dat"));
				int i=0;
				while(inScanner.hasNextLine()){
					
					
					String text=inScanner.nextLine();
					String[] ar=text.split(",");
					
					Member member=new Member(ar[0],ar[1],Integer.parseInt(ar[2]));
					
					memberList.add(member);
					
					
					
					
				}
				return memberList;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return memberList;
		}


		public HashMap<String, ArrayList<Product>> loadProductData() {
			// TODO Auto-generated method stub
			ArrayList<Product> productList=new ArrayList<Product>();
			HashMap<String, ArrayList<Product>> hashMap=new HashMap<String, ArrayList<Product>>();
        try {
				
				
				Scanner inScanner=new Scanner(new File("/Users/vinayakPriya/Documents/workspace/StoreKeeper/src/Files/products.dat"));
				int i=0;
				while(inScanner.hasNextLine()){
					
					
					String text=inScanner.nextLine();
					String[] ar=text.split(",");
					
					Product product=new Product(ar[0], ar[1], ar[2], Integer.parseInt(ar[3]), Double.parseDouble(ar[4]),
							Integer.parseInt(ar[5]),Integer.parseInt(ar[6]),Integer.parseInt(ar[7]));
					
					productList.add(product);
					
					
					
					
				}
				for(Product p:productList)
				{ ArrayList<Product> RefinedproductList=new ArrayList<Product>();
				
					String productId=p.getProductID();
					String[] category=productId.split("/");
					for(Product q:productList){
						String newCategory[]=q.getProductID().split("/");
						if(newCategory[0].compareTo(category[0])==0){
							RefinedproductList.add(q);
							productList.remove(p);
						}
					}
					hashMap.put(category[0], RefinedproductList);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hashMap;
		}

}
