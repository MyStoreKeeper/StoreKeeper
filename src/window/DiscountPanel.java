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
import objects.Discount;
import objects.Member;

/**
 * 
 * @author agarwal.puja
 *
 */

public class DiscountPanel extends JPanel{
	
	MainManageWindow win;
	final List list = new List(15,true);
	JLabel label = new JLabel("Discounts List: ");
	JButton add = new JButton("Add");
	JButton remove = new JButton("Remove");
	JButton modify = new JButton("Modify");
	ArrayList<Discount> current_discounts_list;
	
	public DiscountPanel(MainManageWindow win){
		this.win = win;
		setLayout(null);
		list.setMultipleMode(false);
		label.setBounds(57, 32, 90, 14);
		this.add(label);
		list.setBounds(33, 52, 257, 250);
		this.add(list);
		add.setBounds(314, 65, 80, 23);
		this.add(add);
		remove.setBounds(314, 120, 80, 23);
		this.add(remove);
		modify.setBounds(314, 167, 80, 23);
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
		AddDiscountDialog adisc = new AddDiscountDialog(win);
	}
	
	public Discount getSelectedDiscount(){
		int i = list.getSelectedIndex();
		if(i>=0){
			Discount d = current_discounts_list.get(i);
			return d;
		}
		return null;
	}
	
	public void removeButton(){
		Discount d = getSelectedDiscount();
		if(d!=null){
			confirmDialog cd = new confirmDialog(win,this);
		}
		else{
			JOptionPane.showMessageDialog(this,"Please select a discount for removal.");
		}
		
	}
	public void modifyButton(){
		
	}
	
	public void refresh(){
		if(win.getDiscounts() != null){
		current_discounts_list = win.getDiscounts();
		list.removeAll();
		for(Discount discount : current_discounts_list){
			list.add(discount.getDescription()+" FOR "+discount.getDiscountType()+" - "+discount.getPercentageDiscount()+"%");
		}
		}
	}

}
