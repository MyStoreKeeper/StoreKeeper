package controller;
import javax.xml.crypto.Data;

import objects.Product;
import objects.Transaction_Item;
import window.*;
public class DataFileController {

	public DataFileController() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		ProductsShoppingWindow PSW=new ProductsShoppingWindow();
		Product product=new Product();
		product=PSW.searchproductbyId("STA");
		Transaction_Item transaction_Item=new Transaction_Item();
		transaction_Item.cookie="abcd";
		
		
		PSW.addproducttoTransaction(product,"10");
		
		
		
	}

}
