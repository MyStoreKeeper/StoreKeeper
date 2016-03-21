package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	final List ven_list = new List(15,true);
	JLabel label1 = new JLabel("Category List");
	JLabel label2 = new JLabel("Associated Vendor List");
	JButton addV = new JButton("Add New Vendor To Category");
	JButton removeV = new JButton("Delete Vendor From Category");
	JButton remove = new JButton("Remove Vendor");
	JButton modify = new JButton("Modify Vendor Details");
	ArrayList<Category> current_category_list;
	HashMap<String,ArrayList<Vendor>> vendor_map = new HashMap<String,ArrayList<Vendor>>();
	
	public VendorPanel(MainManageWindow win){
	this.win = win;
	refresh();
	setLayout(null);
	label1.setBounds(28, 26, 80, 14);
	//this.setLayout(new GridLayout(0,4));
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
		public void actionPerformed(ActionEvent e) {
			addButton();
		}
		});
	removeV.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			removeVButton();
		}
		});
	remove.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			//removeAllButton();
		}
		});
	modify.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			modifyButton();
		}
		});
	}
	
	public void addButton(){
		AddVendorDialog avd = new AddVendorDialog();
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
			//TO-DO
			String code = "CLO";
			ArrayList<Vendor> vList = vendor_map.get(code);
			Vendor v = vList.get(i);
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
	}
}
