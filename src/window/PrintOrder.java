package window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.DataHandler;
import objects.Product;
import objects.Vendor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class PrintOrder extends JFrame{
	
	DataHandler data;
	ArrayList<Product> orderProductList;
	JButton print = new JButton("Print");
	String[] venList;
	String[] columnNames = {"Product Name","Category","Order Quantity","Vendor",};
	Object[][] values = {};

	private JTable table = new JTable();
	DefaultTableModel dtm = new DefaultTableModel(values,columnNames);
	
	public PrintOrder(DataHandler data,ArrayList<Product> orderProductList) {
		
		this.data = data;
		this.orderProductList = orderProductList;
		refresh();
		getContentPane().setLayout(null);
		setSize(500,350);
		setVisible(true);
		
		JLabel lblInventoryOrderForm = new JLabel("Inventory Purchase Order Form");
		lblInventoryOrderForm.setFont(new Font("Stencil", Font.PLAIN, 12));
		lblInventoryOrderForm.setBounds(30, 11, 217, 14);
		getContentPane().add(lblInventoryOrderForm);
		
		
		
		table.setFont(new Font("Georgia", Font.BOLD, 11));
		table.setModel(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(250, 175));
		TableColumn col = table.getColumnModel().getColumn(3);
		col.setCellEditor(new MyComboBoxEditor(venList));
		col.setCellRenderer(new MyComboBoxRenderer(venList));
		System.out.println("show columnsize: "+table.getColumnCount());
		 
		JPanel panel = new JPanel();
		panel.setBounds(30, 36, 376, 214);
		panel.setLayout(new BorderLayout());
		 panel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                 "ORDER DETAILS",TitledBorder.CENTER,TitledBorder.TOP));
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(table, BorderLayout.CENTER);
		panel.add(print,BorderLayout.PAGE_END);
		getContentPane().add(panel);
		
		print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			});
	}
		 
		public void refresh(){
			dtm.setRowCount(0);
			for(int i=0; i<orderProductList.size(); i++){
				String name = orderProductList.get(i).getProductName();
				String order = String.valueOf(orderProductList.get(i).getPlaceOrder());
				String catCode = orderProductList.get(i).getProductID().substring(0,3);
				String catName = data.getCategory(catCode).getName();
				ArrayList<Vendor> venList1 = data.getVendorsFromMap(catCode);
				venList = new String[venList1.size()];
				for(int j=0;j<venList1.size();j++){
					venList[j] = venList1.get(j).getVendorName();
				}
				dtm.addRow(new Object[] {name,catName,order});
			}
		}
}
class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
	  public MyComboBoxRenderer(String[] items) {
	    super(items);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	      boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      super.setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }
	    setSelectedItem(value);
	    return this;
	  }
	}

	class MyComboBoxEditor extends DefaultCellEditor {
	  public MyComboBoxEditor(String[] items) {
	    super(new JComboBox(items));
	  }
	}
