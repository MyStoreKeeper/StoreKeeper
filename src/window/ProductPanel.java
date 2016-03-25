package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.Member;
import objects.Product;

/**
 * 
 * @author agarwal.puja
 *
 */

public class ProductPanel extends JPanel{
	
	MainManageWindow win;
	final List list = new List(15,true);
	JLabel label = new JLabel("Products List: ");
	JButton add = new JButton("Add");
	JButton remove = new JButton("Remove");
	JButton modify = new JButton("Modify");
	ArrayList<Product> current_products_list;
	
	public ProductPanel(MainManageWindow win){
	this.win = win;
	refresh();
	setLayout(null);
	list.setMultipleMode(false);
	label.setBounds(57, 32, 90, 14);
	this.add(label);
	list.setBounds(33, 52, 200, 250);
	this.add(list);
	add.setBounds(263, 65, 80, 23);
	this.add(add);
	remove.setBounds(263, 116, 80, 23);
	this.add(remove);
	modify.setBounds(263, 165, 80, 23);
	this.add(modify);
	add.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			addButton();
		}
		});
	remove.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			removeButton();
		}
		});
	modify.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			modifyButton();
		}
		});
	}
	
	public void addButton(){
		AddProductDialog apd = new AddProductDialog(win);
	}
	
	public Product getSelectedProduct(){
		int i = list.getSelectedIndex();
		if(i>=0){
			Product p = current_products_list.get(i);
			return p;
		}
		return null;
	}
	
	public void removeButton(){
		Product p = getSelectedProduct();
		if(p!=null){
			confirmDialog cd = new confirmDialog(win,this);
		}
		else{
			JOptionPane.showMessageDialog(this,"Please select a product for removal.");
		}
	}
	
	public void modifyButton(){
		
	}
	public void refresh(){
		current_products_list = win.getProducts();
		list.removeAll();
		for(Product product : current_products_list){
			list.add(product.getProductName()+" - "+product.getBriefDescription());
		}
	}

}
