package window;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.DataHandler;
import objects.Product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;

/**
 * 
 * @author agarwal.puja
 *
 */

public class InventoryWindow extends JFrame{
	
	DataHandler data;
	JLabel label = new JLabel("Inventory List Below Threshold: ");
	ArrayList<Product> current_products_list;
	JButton replenish = new JButton("Replenish");
	String[] columnNames = {"Name","Quantity","Threshold","Order Value"};
	Object[][] values = {};
	private DefaultListSelectionModel selectionModel;

	private JTable table = new JTable();
	DefaultTableModel dtm = new DefaultTableModel(values,columnNames);
	
	public InventoryWindow(DataHandler data){
		
		this.data = data;
		refresh();
		table.setFont(new Font("Georgia", Font.BOLD, 11));
		table.setModel(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(250, 175));
		selectionModel = (DefaultListSelectionModel) table.getSelectionModel();
		JPanel panel = new JPanel();
		panel.setBounds(30, 56, 318, 233);
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(table, BorderLayout.CENTER);
		
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		
		label.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		label.setBounds(30, 31, 205, 14);
		getContentPane().add(label);
		replenish.setFont(new Font("Tahoma", Font.BOLD, 11));
		replenish.setBounds(358,107,116, 47);
		getContentPane().add(replenish);
		replenish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				replenishButton();
			}
			});
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(InventoryWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		btnHome.setBounds(384, 11, 90, 23);
		getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainWindow main_win = new MainWindow(data);
				dispose();
			}
			});
		
		JButton btnALL = new JButton("Replenish ALL");
		btnALL.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnALL.setBounds(358, 165, 119, 69);
		getContentPane().add(btnALL);
		btnALL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				replenishAll();
			}
			});

		setTitle("Check & Replenish Inventory");
		setSize(500,350);
		setVisible(true);
		}
	
		public void replenishButton(){
			ArrayList<Product> products = getSelectedProduct(); 
			if(products!=null){
				int reply =JOptionPane.showConfirmDialog(this, "Generate a Order for selected products",
						"Generate Order", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							//TO-DO
							for(int i=0;i<products.size();i++){
								data.orderProduct(products.get(i));
							}
							//JOptionPane.showMessageDialog(this, "Orders Generated Successfully");
							refresh();
							PrintOrder printOrder = new PrintOrder(data,products);
							
					        }
			}
			else{
				JOptionPane.showMessageDialog(this,"Please select a product.");
			}
			
		}
		
		public void replenishAll(){
			int reply =JOptionPane.showConfirmDialog(this, "Generate a Order for All Products?",
					"Generate Order For All", JOptionPane.YES_NO_OPTION);
			if(reply == JOptionPane.YES_OPTION){
				System.out.println("Size   ::  "+current_products_list.size());
				for(int i=0; i<current_products_list.size(); i++){
					data.orderProduct(current_products_list.get(i));
				}
				//JOptionPane.showMessageDialog(this, "Orders Generated Successfully");
				refresh();
				PrintOrder printOrder = new PrintOrder(data,current_products_list);
				
				//print();
			}
		}
		
		public ArrayList<Product> getSelectedProduct(){
			int[] items = table.getSelectedRows();
			ArrayList<Product> selectedProducts = new ArrayList<Product>();
			if(items != null){
				for(int i=0;i<items.length;i++){
					Product p = current_products_list.get(items[i]);
					selectedProducts.add(p);
				}
				return selectedProducts;
			}
			return null;
			}
	
		public void refresh(){
			dtm.setRowCount(0);
			current_products_list = data.getInventoryList();
			for(int i=0; i<current_products_list.size(); i++){
				String name = current_products_list.get(i).getProductName();
				String quantity = String.valueOf(current_products_list.get(i).getQuantity());
				String threshold = String.valueOf(current_products_list.get(i).getThresholdLimit());
				String order = String.valueOf(current_products_list.get(i).getPlaceOrder());
				dtm.addRow(new Object[] { name, quantity, threshold,order});
			}
		}
		
}
