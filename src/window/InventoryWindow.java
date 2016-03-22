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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DataHandler;
import objects.Product;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

/**
 * 
 * @author agarwal.puja
 *
 */

public class InventoryWindow extends JFrame{
	JLabel label = new JLabel("Inventory List Below Threshold: ");
	ArrayList<Product> current_products_list;
	JButton replenish = new JButton("Replenish");
	Object[] columnNames = {"Product Name","Quantity","Threshold","Order Quantity"};
	Object[][] values = {{"Text1", "Text2","Text3", "Text4"}};

	private JTable table;
	
	
	public InventoryWindow(){
		
		DataHandler.initDataHandler();
		
		
		
		
		table = new JTable(values,columnNames);
		
		JScrollPane sp = new JScrollPane(table);
		
		setLayout(null);
		add(sp);
		label.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		label.setBounds(30, 11, 205, 14);
		add(label);
		replenish.setFont(new Font("Tahoma", Font.BOLD, 11));
		replenish.setBounds(358,119,90, 23);
		add(replenish);
		
		table.setBounds(30, 40, 300, 196);
		add(table);
		replenish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//replenishButton();
			}
			});
		setTitle("Check & Replenish Inventory");
		setSize(500,350);
		setVisible(true);
		}
	
		public void refresh(){
			current_products_list = DataHandler.data.getInventoryList();
			for(int i=0; i<current_products_list.size(); i++){
			}
		}
		
}
