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
import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.Product;

/**
 * 
 * @author agarwal.puja
 *
 */

public class InventoryPanel extends JPanel{
	
	final List list = new List(15,true);
	JLabel label = new JLabel("Inventory List: ");
	ArrayList<Product> current_products_list;
	
	public InventoryPanel(){
	setLayout(null);
	label.setBounds(157, 24, 90, 14);
	this.add(label);
	list.setBounds(109, 44, 185, 214);
	this.add(list);
	}
}
