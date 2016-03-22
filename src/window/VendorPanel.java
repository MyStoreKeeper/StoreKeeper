package window;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import objects.Category;
import objects.Vendor;

/**
 * 
 * @author agarwal.puja
 *
 */

public class VendorPanel extends JPanel{
	
	MainManageWindow win;
	final List cat_list = new List(15,true);
	final List 
	ven_list = new List(15,true);
	JLabel label1 = new JLabel("Category List");
	JLabel label2 = new JLabel("Associated Vendor List");
	JButton addV = new JButton("Add New Vendor To Category");
	JButton removeV = new JButton("Delete Vendor From Category");
	JButton remove = new JButton("Remove Vendor");
	JButton modify = new JButton("Modify Vendor Details");
	ArrayList<Category> current_category_list;
	ArrayList<Vendor> current_vendor_list;
	HashMap<String,ArrayList<Vendor>> vendor_map = new HashMap<String,ArrayList<Vendor>>();
	
	public VendorPanel(MainManageWindow win){
	this.win = win;
	//refresh();
	setLayout(null);
	cat_list.setMultipleMode(false);
	ven_list.setMultipleMode(false);
	label1.setBounds(28, 26, 80, 14);
	this.add(label1);
	cat_list.setBounds(10, 46, 110, 214);
	this.add(cat_list);
	label2.setBounds(138, 26, 150, 14);
	this.add(label2);
	ven_list.setBounds(143, 46, 110, 214);
	this.add(ven_list);
	addV.setBounds(350, 46, 200, 23);
	this.add(addV);
	removeV.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	});
	removeV.setBounds(350, 91, 200, 23);
	this.add(removeV);
	remove.setBounds(390, 137, 130, 23);
	this.add(remove);
	modify.setBounds(365, 182, 180, 23);
	this.add(modify);
	addV.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			addButton();
		}
		});
	removeV.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			removeVButton();
		}
		});
	remove.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			//removeAllButton();
		}
		});
	modify.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			modifyButton();
		}
		});
	cat_list.addItemListener(new ItemListener(){
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			refreshVendors();
		}	
	});
	}
	
	public void addButton(){
		if(current_category_list.isEmpty()){
			JOptionPane.showMessageDialog(this,"No Category present. Please proceed to add a category first.");
		}
		else{
			if(getSelectedCategory() != null){
				String catCode = getSelectedCategory().getCode();
				AddVendorDialog avd = new AddVendorDialog(win,catCode);
			}
			else{
				JOptionPane.showMessageDialog(this,"Please select a category to add vendors.");
			}
		}
		
			
	}
	
	public Category getSelectedCategory(){
		int i = cat_list.getSelectedIndex();
		if(i>=0){
			Category c = current_category_list.get(i);
			return c;
		}
		return null;
	}
	
	public Vendor getSelectedVendor(Category c){
		int i = ven_list.getSelectedIndex();
		if(i>=0){
			Vendor v = current_vendor_list.get(i);
			return v;
		}
		return null;
	}
	
	public void removeVButton(){
		Category c = getSelectedCategory();
		Vendor v = getSelectedVendor(c);
		if(c!=null && v!=null){
			confirmDialog cd = new confirmDialog(win,this);
		}
		else{
			JOptionPane.showMessageDialog(this,"Please select a category and vendor for removal.");
		}
	}
	
	public void removeAllButton(){
		
	}
	
	public void modifyButton(){
		
	}

	public void refresh(){
		current_category_list = win.getCategories();
		cat_list.removeAll();
		for(Category category : current_category_list){
			cat_list.add(category.getName() +" - "+category.getCode());
		}
	}
	public void refreshVendors(){
		ven_list.removeAll();
		Category c = getSelectedCategory();
		if(c != null){
			System.out.println("Code selected: "+c.getCode());
			current_vendor_list = win.getVendorsOfCategory(c.getCode());
			for(Vendor vendor : current_vendor_list){
				ven_list.add(vendor.getVendorName());
			}
		}
		
	}
}
