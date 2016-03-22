package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.DataHandler;
import objects.Category;
import objects.Discount;
import objects.Member;
import objects.Product;
import objects.Vendor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 * 
 * @author agarwal.puja
 *
 */
public class MainManageWindow extends JFrame {
	
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel home_panel = new JPanel();
	MemberPanel memberPanel = new MemberPanel(this);
	ProductPanel productPanel = new ProductPanel(this);
	CategoryPanel categoryPanel = new CategoryPanel(this);
	VendorPanel vendorPanel = new VendorPanel(this);
	DiscountPanel discountPanel = new DiscountPanel(this);
	private final JButton btnNewButton = new JButton("Home");
	
	public MainManageWindow() 
	   { 
	      DataHandler.initDataHandler();
	      
	      getContentPane().setLayout(null);
	      this.setSize(800, 500); 
	      //this.setLocation(500, 230);
	      
	      home_panel.setBounds(10, 11, 770, 16);
	      home_panel.setLayout(null);
	      getContentPane().add(home_panel);
	      btnNewButton.setIcon(new ImageIcon(MainManageWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
	      btnNewButton.setBounds(650, 0, 90, 16);
	      btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainWindow mf = new MainWindow();
					dispose();
				}
			});
	      home_panel.add(btnNewButton);
	      
	      tabbedPane.setBounds(10, 38, 770, 420);
	      getContentPane().add(tabbedPane);
	      tabbedPane.addTab("Members", memberPanel);
	      tabbedPane.addTab("Products", productPanel);
	      tabbedPane.addTab("Category", categoryPanel);
	      tabbedPane.addTab("Vendors", vendorPanel);
	      tabbedPane.addTab("Discounts", discountPanel);
	      //tabbedPane.addTab("Reports", reportPanel);
	      //this.getContentPane().setLayout(null);
	      this.setTitle("Welcome"); 
	      this.setVisible(true);
	   } 
	
	public void addMember(String name,String id){
		DataHandler.data.addMember(name,id);
		memberPanel.refresh();
	}
	
	public void removeSelectedMember(){
		Member m = memberPanel.getSelectedMember();
		DataHandler.data.removeMember(m);
		memberPanel.refresh();
	}
	public ArrayList<Member> getMembers(){
		ArrayList<Member> members = DataHandler.data.getMemberList();
		return members;
	}
	
	public ArrayList<Product> getProducts(){
		ArrayList<Product> products = DataHandler.data.getProductList();
		return products;
	}
	
	public ArrayList<Category> getCategories(){
		ArrayList<Category> categories = DataHandler.data.getCategoryList();
		return categories;
	}
	
	public ArrayList<Product> getProductsForCategory(String cat_code){
		ArrayList<Product> catProducts = DataHandler.data.getProductsForCategory(cat_code);
		return catProducts;
	}
	
	public ArrayList<Discount> getDiscounts(){
		ArrayList<Discount> discounts = DataHandler.data.getDiscountList();
		return discounts;
	}
	
	public void addProduct(String catCode,String productID, String productName, String briefDescription, int quantity, double price,
			int thresholdLimit, int placeOrder, int limit){
		DataHandler.data.addProduct(catCode,productID,productName,briefDescription,quantity,price,thresholdLimit,placeOrder,limit);
		productPanel.refresh();
	}
	
	public void addDiscount(String discountCode,String discountType, String description,String startDate,int periodofDiscount,double percentageDiscount){
		DataHandler.data.addDiscount(discountCode,discountType,description, startDate,periodofDiscount,percentageDiscount);
		discountPanel.refresh();
	}
	
	public void removeSelectedDiscount(){
		Discount d = discountPanel.getSelectedDiscount();
		DataHandler.data.removeDiscount(d);
		discountPanel.refresh();
	}
	
	public void removeSelectedProduct(){
		Product p = productPanel.getSelectedProduct();
		String prodId = p.getProductID();
		String catCode = prodId.substring(0,3);
		DataHandler.data.removeProduct(p,catCode);
		productPanel.refresh();
	}
	
	public boolean checkCategory(String code){
		boolean val = DataHandler.data.checkExistingCatgory(code);
		return val;
	}
	
	public void addCategory(String name,String code){
		DataHandler.data.addCategory(name, code);
		categoryPanel.refresh();
	}
	
	public void addVendorsToCategory(String catCode,String vName,String vDesc){
		DataHandler.data.addToCategoryVendorMap(catCode, vName,vDesc);
		categoryPanel.refresh();
		vendorPanel.refresh();
	}
	
	public ArrayList<Vendor> getVendorsOfCategory(String catCode){
		ArrayList<Vendor> catVendors = DataHandler.data.getVendorsFromMap(catCode);
		return catVendors;
	}
	
	public void removeSelectedCategory(){
		Category c = categoryPanel.getSelectedCategory();
		String catCode = c.getCode();
		DataHandler.data.removeCategory(c,catCode);
		categoryPanel.refresh();
		vendorPanel.refresh();
		vendorPanel.refreshVendors();
	}
	public void removeSelectedVendorFromCategory(){
		Category c = vendorPanel.getSelectedCategory();
		Vendor v = vendorPanel.getSelectedVendor(c);
		String catCode = c.getCode();
		DataHandler.data.removeVendorFromCategory(catCode,v);
		vendorPanel.refreshVendors();
	}
}