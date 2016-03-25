<<<<<<< HEAD
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;

import javax.xml.crypto.Data;

import controller.DataFileController2;
import controller.DataHandler2;
import objects.Product;
import objects.StoreKeeperSession;
import objects.Storekeeper;
import objects.Transaction_Item;
import window.BillWindow;
=======
import controller.DataHandler;
>>>>>>> origin/master
import window.LoginWindow;
import window.MainManageWindow;
import window.MainWindow;
import window.ProductDetailWindow;
import window.ProductsShoppingWindow;

public class ModelStoreApplication {
	
public static void main(String[] args) throws IOException, ParseException {
	DataHandler2.initDataHandler();
		/*ProductsShoppingWindow PSW=new ProductsShoppingWindow();
		Product product=new Product();
		product=PSW.searchproductbyId("STA");
		Transaction_Item transaction_Item=new Transaction_Item();
		transaction_Item.cookie="abcd";
		
		
		PSW.addproducttoTransaction(product,"10");*/
		
	
	
	/*Transaction_Item transaction_Item=new Transaction_Item(12, "F42563743156");
	transaction_Item.setTransactionItemshashmap("CLO/1", 2);
	transaction_Item.setTransactionItemshashmap("CLO/3", 5);
	Storekeeper storekeeper=new Storekeeper("pooja", "abv");
	

	StoreKeeperSession storeKeeperSession=new StoreKeeperSession(storekeeper);
	BillWindow BW=new BillWindow(transaction_Item,storeKeeperSession);*/
	ProductsShoppingWindow PSW=new ProductsShoppingWindow();
	//ProductDetailWindow PSS=new ProductDetailWindow(transaction_Item);
		

<<<<<<< HEAD
=======
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LoginWindow w = new LoginWindow(); 
	    //w.setVisible(true);
		DataHandler.initDataHandler();
		LoginWindow login = new LoginWindow(DataHandler.data);
		login.setVisible(true);
	    System.out.println("Test Print");
>>>>>>> origin/master
	}
	}


