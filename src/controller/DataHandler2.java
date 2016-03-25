package controller;
//import org.apache.commons.math3.util.Precision;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;

import org.omg.CORBA.StringHolder;

import objects.Category;
import objects.Discount;
import objects.Discount_Member;
import objects.Member;
import objects.Product;
import objects.StoreKeeperSession;
import objects.Storekeeper;
import objects.Transaction;
import objects.Transaction_Item;
import objects.Vendor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


   

public class DataHandler2 {

	private HashMap<String, ArrayList<Product>> categoryHashmap;
	private HashMap<String, ArrayList<Product>> transactionItemhashmap;
	ArrayList<Member> memberList;
	public HashMap<String, ArrayList<Product>> getCategoryHashmap() {
		return categoryHashmap;
	}

	public void setCategoryHashmap(HashMap<String, ArrayList<Product>> categoryHashmap) {
		this.categoryHashmap = categoryHashmap;
	}

	private ArrayList<Discount_Member> memberdiscountList;
	private ArrayList<Discount> discountList;
	private ArrayList<Category> categoryList;
	private ArrayList<Storekeeper> storekeeperList;
	private ArrayList<Transaction> transactionList;
	private HashMap<String, ArrayList<Vendor>> vendorCategoryHashmap;
	
	public static DataHandler2 data;
	DataFileController2 dataFileController2=new DataFileController2();
	

	public DataHandler2() throws IOException {
		
		
		// TODO Auto-generated constructor stub
	}

	public static void initDataHandler() throws IOException, ParseException{
		
		data=new DataHandler2();
		
		data.loadcategoryHashmap();
		data.loadMemberDiscounts();
		data.loadmemberData();
		
		data.loadGeneralDiscounts();
		data.loadtransactionData();
		//Transaction_Item t=new Transaction_Item(1, "12");
		//double discount=data.calculateDiscount(t);
		
		
	}
	
	public void initData(){
}
	
	public static void main(String[] args) {
}
	
public void loadcategoryHashmap() throws IOException{
		
			
			this.setCategoryHashmap(dataFileController2.loadcategoryHashmap());
		}
	
public void loadMemberDiscounts(){


				
			this.memberdiscountList=dataFileController2.loadMemberDiscount();
			
}
		
public void loadGeneralDiscounts(){
		
		this.discountList=dataFileController2.loadGeneralDiscount();
		
		
		}
public void loadProductData(){
	
	this.categoryHashmap=dataFileController2.loadProductData();
	
	
	}
	
public void loadtransactionData(){
	
	this.transactionList=dataFileController2.loadtransactionData();
	
	
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
			if(p.getProductID().compareTo(Id)==0)
			{
				product=p;
				break;
			}
			
		}
	
		return product;
	}

	public void addproducttoTransaction(Product p, int quantity){
		
		
		Transaction transaction=new Transaction();
		transaction=data.transactionList.get(data.transactionList.size()-1);
		int id=transaction.getTransactionId();
		id=id+1;
		
		transaction.setProductId(p.getProductID());
		transaction.setMemberId("");
		transaction.setQuantity(quantity);
		transaction.setTransactionId(id);
			
		
		
	}
	
	public Member memberLookup(String memberId){
		Member member=new Member();
		System.out.println("entered");
		for(Member m:data.memberList){
			if(m.getMemberID().compareTo(memberId)==0){
				member=m;
				break;
			}
		}
		System.out.println(member);
		return member;
	}

	public int lastTransactionIdLookup() {
		// TODO Auto-generated method stub
		
		Transaction transaction = new Transaction();
		try {
			transaction=data.transactionList.get(data.transactionList.size()-1);
			System.out.println("handler"+transaction.getTransactionId());
			System.out.println(data.transactionList);
			System.out.println(data.transactionList.size()-1);
			System.out.println(transaction);
			System.out.println(transaction.getMemberId()+transaction.getProductId()+"transactId"+transaction.getTransactionId());
			
			
		} catch (NullPointerException e) {
			transaction.setTransactionId(0);
			// TODO: handle exception
		}
		System.out.println(transaction.getTransactionId());
		return transaction.getTransactionId();
	}

	public void checkStockbyId(String productID) {
		
	String category[]=productID.split("/");
	ArrayList<Product> productList1=new ArrayList<Product>();
	productList1=data.categoryHashmap.get(category[0]);
	for(Product p:productList1){
		if(p.getProductID()==productID)
		{
			int Q=p.getQuantity();
			int threshold=p.getThresholdLimit();
			if(Q<=threshold)
			{
				//pop-up order for more inventory
			}
			
		}
	}
	}

	public void addproducttoTransaction(int transactionID, String memberId, Integer quantity, String productId,
			String date) {
		Transaction transaction=new Transaction();
		transaction.setTransactionId(transactionID);
		transaction.setMemberId(memberId);
		transaction.setProductId(productId);
		transaction.setQuantity(quantity);
		transaction.setDate(date);
		
		// TODO Auto-generated method stub
		transactionList.add(transaction);
	}

	public double calculateTotalCost(Transaction_Item t) {
		// TODO Auto-generated method stub
		double cost=0;
		ArrayList<Product> productList2=new ArrayList<Product>();
		for(String id:t.TransactionItemshashmap.keySet()){
			String category[]=id.split("/");
			
			productList2=data.categoryHashmap.get(category[0]);
			for(Product p:productList2){
				
				if(p.getProductID().compareTo(id)==0){
					int k=t.TransactionItemshashmap.get(id);
					while(k>0)
					{
						cost=cost+p.getPrice();
						k--;
					}
					
					
				}
				
			}
			
		}
		return cost;
	}

	public int calculateloyaltypoints(String memberId) {
		// TODO Auto-generated method stub
		
		int points=0;
		for(Member m:data.memberList){
			if(m.getMemberID().compareTo(memberId)==0){
				points=m.getPoint();
			}
		}
		return points;
	}

	
	public String getmemberStorekeeperName(Transaction_Item t,StoreKeeperSession s){
		String memberId=t.memberID;
		//ArrayList<Member> memberList=new ArrayList<Member>();
		
		
		String memberName="";
		for(Member m:memberList){
			if(m.getMemberID()==memberId){
				memberName=m.getName();
			}
		}
	
		Storekeeper s1=s.storekeeper;
		String storekeeperName=s1.getName();
		
		return "Member : "+memberName+"           Storekeeper :"+storekeeperName;
	}
	public void loadmemberData(){
	
			this.memberList=dataFileController2.loadMemberdata();
	
	}

	public double calculateDiscount(Transaction_Item t) throws ParseException {
		// TODO Auto-generated method stub
		double discount=0;
		if(t.memberID.compareTo("PUBLIC")==0)
		{
			discount=data.checkMaxGeneralDiscount(t);
		}
		else 
			discount=data.checkMaxMemberDiscount(t);
		return discount;
		
	}
	
	
	public double checkMaxGeneralDiscount(Transaction_Item t) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Discount> discountList=new ArrayList<Discount>();
		   Date date = new Date();
		    
		    double max=0;
		   Date discountStartdate = null;
		   Date expiryDate=null;
		   Calendar cal = Calendar.getInstance();
		   
			for(Discount d:data.discountList){
				if(d.getPeriodofDiscount().compareTo("ALWAYS")!=0)
				{
					
					discountStartdate = dateFormat.parse(d.getStartDate());
				
				cal.setTime(discountStartdate);
				   cal.add(Calendar.DATE,Integer.parseInt(d.getPeriodofDiscount()));
				   String discountExpirydate = dateFormat.format(cal.getTime());
				    expiryDate=dateFormat.parse(discountExpirydate);
				
				
				if(discountStartdate.compareTo(date)<0 && expiryDate.compareTo(date)>0 || expiryDate.compareTo(date)==0 || discountStartdate.compareTo(date)==0)
				{
					
					discountList.add(d);
				}
		        }
				else {
					
					
					discountList.add(d);
				}
				
			for(Discount k:discountList){
				
				if(k.getPercentageDiscount()>max){
					
					max=k.getPercentageDiscount();
				}
				
				
			}
	            
	}
			return max;
		}
		
		
	public double checkMaxMemberDiscount(Transaction_Item t) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Discount_Member> discountList=new ArrayList<Discount_Member>();
		   Date date = new Date();
		    
		    double max=0;
		   Date discountStartdate = null;
		   Date expiryDate=null;
		   Calendar cal = Calendar.getInstance();
		   
		
		
			for(Discount_Member d:data.memberdiscountList){
				if(d.getPeriodofDiscount().compareTo("ALWAYS")!=0)
				{
					
					discountStartdate = dateFormat.parse(d.getStartDate());
				
				cal.setTime(discountStartdate);
				   cal.add(Calendar.DATE,Integer.parseInt(d.getPeriodofDiscount()));
				   String discountExpirydate = dateFormat.format(cal.getTime());
				    expiryDate=dateFormat.parse(discountExpirydate);
			
				if(discountStartdate.compareTo(date)<0 && expiryDate.compareTo(date)>0 || expiryDate.compareTo(date)==0 || discountStartdate.compareTo(date)==0)
				{
					
					discountList.add(d);
				}
		        }
				else {
					
					
					discountList.add(d);
				}
				
			for(Discount k:discountList){
				
				if(k.getPercentageDiscount()>max){
					
					max=k.getPercentageDiscount();
				}
				
				
			}
	            
	}
			return max;
		}

	public double redeemLoyaltyPoints(String memberId,int points) {
		// TODO Auto-generated method stub
		double redeemedCost;
		//double points=(double)this.calculateloyaltypoints(memberId);
		
		if(points==0){
			
			redeemedCost=0;
		}
		else redeemedCost=points/100.0;
		//precision.round(redeemedCost,2);
		
		return redeemedCost;
	}
}
		
		
	
