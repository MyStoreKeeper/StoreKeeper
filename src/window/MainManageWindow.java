package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.DataHandler;
import objects.Member;
/**
 * 
 * @author agarwal.puja
 *
 */
public class MainManageWindow extends JFrame {
	
	JTabbedPane tabbedPane = new JTabbedPane();
	MemberPanel memberPanel = new MemberPanel(this);
	ProductPanel productPanel = new ProductPanel(this);
	CategoryPanel categoryPanel = new CategoryPanel(this);
	VendorPanel vendorPanel = new VendorPanel(this);
	DiscountPanel discountPanel = new DiscountPanel(this);
	InventoryPanel inventoryPanel = new InventoryPanel();
	ReplenishPanel replenishPanel = new ReplenishPanel();
	ReportPanel reportPanel = new ReportPanel();
	
	public MainManageWindow() 
	   { 
		
	      super(); 
	      DataHandler.initDataHandler();
	      this.setSize(800, 500); 
	      this.setLocation(500, 230);
	      getContentPane().add(tabbedPane);
	      tabbedPane.addTab("Members", memberPanel);
	      tabbedPane.addTab("Products", productPanel);
	      tabbedPane.addTab("Category", categoryPanel);
	      tabbedPane.addTab("Vendors", vendorPanel);
	      tabbedPane.addTab("Discounts", discountPanel);
	      tabbedPane.addTab("Check Inventory", inventoryPanel);
	      tabbedPane.addTab("Replenish Inventory", replenishPanel);
	      tabbedPane.addTab("Reports", reportPanel);
	      //this.getContentPane().setLayout(null);
	      this.setTitle("Welcome"); 
	   } 
	
	public void addMember(String name,String id){
		DataHandler.data.addMember(name,id);
		memberPanel.refresh();
	}
	
	public void removeSelectedMember(){
		Member m = memberPanel.getSelectedMember();
		String id = m.getMemberID();
		DataHandler.data.removeMember(id);
		memberPanel.refresh();
	}
}