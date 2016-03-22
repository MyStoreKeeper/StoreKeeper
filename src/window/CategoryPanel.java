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

import objects.Category;
import objects.Member;
import objects.Product;

/**
 * 
 * @author agarwal.puja
 *
 */

public class CategoryPanel extends JPanel{
	
	MainManageWindow win;
	final List list = new List(15,true);
	JLabel label = new JLabel("Category List: ");
	JButton add = new JButton("Add");
	JButton remove = new JButton("Remove");
	JButton modify = new JButton("Modify");
	ArrayList<Category> current_category_list;
	
	public CategoryPanel(MainManageWindow win){
		this.win = win;
		//refresh();
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
		AddCategoryDialog acd = new AddCategoryDialog(win);
	}
	
	public Category getSelectedCategory(){
		int i = list.getSelectedIndex();
		if(i>=0){
			Category c = current_category_list.get(i);
			return c;
		}
		return null;
	}
	
	public void removeButton(){
		Category c = getSelectedCategory();
		if(c!=null){
			confirmDialog cd = new confirmDialog(win,this);
		}
		else{
			JOptionPane.showMessageDialog(this,"Please select a category for removal.");
		}
	}
		
	public void modifyButton(){
		
	}
	public void refresh(){
		if(win.getCategories() != null){
		current_category_list = win.getCategories();
		list.removeAll();
		for(Category category : current_category_list){
			list.add(category.getName() +" - "+category.getCode());
		}
		}
	}

}
