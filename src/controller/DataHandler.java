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
	
	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void addMember(String name,String id){
		Member m = new Member(name,id);
		memberList.add(m);
	}
	
	public void removeMember(String id){
		for(int i=0; i<memberList.size(); i++){
			if(memberList.get(i).getMemberID().equals(id)){
				memberList.remove(i);
			}
		}
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

	public DataHandler() {
		// TODO Auto-generated constructor stub
	}

	public static void initDataHandler(){
		data = new DataHandler();
	}
	
	public void initData(){
		
	}
	public void nnnnnn() {
		System.out.println("ggggg");
	}

	
	
}
