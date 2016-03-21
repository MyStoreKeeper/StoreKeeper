package window;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.Product;

public class ReplenishPanel extends JPanel {
	final List list = new List(15,true);
	JLabel label = new JLabel("Inventory List Below Threshold: ");
	JButton replenish = new JButton("Replenish");
	ArrayList<Product> current_products_list;
	
	public ReplenishPanel(){
	setLayout(null);
	label.setBounds(60, 27, 205, 14);
	this.add(label);
	list.setBounds(60, 47, 245, 214);
	this.add(list);
	replenish.setBounds(355,129,90, 23);
	this.add(replenish);
	replenish.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			replenishButton();
		}
		});
	}
	
	public void replenishButton(){
		
	}

}
