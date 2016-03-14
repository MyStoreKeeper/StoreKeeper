package controller;

import java.util.ArrayList;
import java.util.HashMap;

import objects.Category;
import objects.Discount;
import objects.Member;
import objects.Product;
import objects.Storekeeper;
import objects.Transaction;
import objects.Vendor;

public class DataHandler {

	private HashMap<String, ArrayList<Product>> categoryHashmap;
	private ArrayList<Member> memberList;
	private ArrayList<Discount> discountList;
	private ArrayList<Category> categoryList;
	private ArrayList<Storekeeper> storekeeperList;
	private ArrayList<Transaction> transactionList;
	private HashMap<String, ArrayList<Vendor>> vendorCategoryHashmap;
	
	public static DataHandler data;
	
	public DataHandler() {
		// TODO Auto-generated constructor stub
	}

	public static void initDataHandler(){
		data = new DataHandler();
	}
	
	public void initData(){
		
	}
}
