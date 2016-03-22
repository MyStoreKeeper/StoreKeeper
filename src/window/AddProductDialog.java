package window;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.Category;
import objects.Product;

public class AddProductDialog extends JDialog {
	MainManageWindow win;
	JPanel panel;
	JButton ok;
	JButton cancel;
	JComboBox catList;
	JLabel prodId;
	JTextField tf2_thres,tf3_price,tf4_desc,tf5_name,tf6_quan,tf7_order,tf8_limit;
	ArrayList<Category> cat_list = new ArrayList<Category>();
	String[] cat_list1 = new String[10];
	
	public AddProductDialog(MainManageWindow win) {
		this.win = win;
		
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){
		
		checkCategory();
		panel = new JPanel();
		JLabel l = new JLabel("Select Category");
		l.setBounds(13, 8, 100, 14);
		JLabel l1 = new JLabel("Product ID");
		l1.setBounds(13, 39, 95, 14);
		JLabel l2 = new JLabel("Product Name");
		l2.setBounds(13, 70, 95, 14);
		JLabel l3 = new JLabel("Description");
		l3.setBounds(13, 108, 95, 14);
		JLabel l4 = new JLabel("Quantity");
		l4.setBounds(13, 206, 95, 14);
		JLabel l5 = new JLabel("Price");
		l5.setBounds(13, 170, 95, 14);
		JLabel l6 = new JLabel("Threshold");
		l6.setBounds(13, 139, 95, 14);
        JLabel l7 = new JLabel("Place Order Quantity");
        l7.setBounds(10, 242, 123, 14);
        panel.add(l7);
        JLabel l8 = new JLabel("Limit");
        l8.setBounds(13, 270, 46, 14);
        panel.add(l8);
        
		prodId = new JLabel();
		prodId.setBounds(141, 36, 86, 20);
		
		catList = new JComboBox(cat_list1);
		catList.setBounds(141, 5, 60, 20);
				
		prodId.setText(getProductCode());
		catList.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	        	prodId.setText(getProductCode());
	        }
	      });
		
		tf2_thres = new JTextField(10);
		tf2_thres.setBounds(141, 136, 86, 20);
		tf3_price = new JTextField(10);
		tf3_price.setBounds(141, 167, 86, 20);
		tf4_desc = new JTextField(10);
		tf4_desc.setBounds(141, 105, 86, 20);
		tf5_name = new JTextField(10);
		tf5_name.setBounds(141, 67, 86, 20);
		tf6_quan = new JTextField(10);
		tf6_quan.setBounds(141, 203, 86, 20);
		ok = new JButton("Ok");
		ok.setBounds(96, 315, 60, 23);
		cancel = new JButton("Cancel");
		cancel.setBounds(191, 315, 80, 23);
		panel.setLayout(null);
		panel.add(l);
		panel.add(catList);
		panel.add(l1);
		panel.add(prodId);
		panel.add(l2);
		panel.add(tf2_thres);
		panel.add(l3);
		panel.add(tf3_price);
		panel.add(l4);
		panel.add(tf4_desc);
		panel.add(l5);
		panel.add(tf5_name);
		panel.add(l6);
		panel.add(tf6_quan);
		panel.add(ok);
        panel.add(cancel);
        setTitle("Add New Product");
        getContentPane().add(panel);
        
        tf7_order = new JTextField();
        tf7_order.setBounds(141, 239, 86, 20);
        panel.add(tf7_order);
        tf7_order.setColumns(10);

        
        tf8_limit = new JTextField();
        tf8_limit.setBounds(141, 270, 86, 20);
        panel.add(tf8_limit);
        tf8_limit.setColumns(10);
        
        setSize(400,400);
        setVisible(true);
        
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					performOkAction();
			}
			});
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
	}

	public void checkCategory(){
		cat_list = win.getCategories();
		if(cat_list.size() != 0){
			for(int i=0; i<cat_list.size();i++){
				String str = cat_list.get(i).getCode();
				System.out.println("Print cat code: "+str);
				cat_list1[i] = str;
			}
		}
		else{
			JOptionPane.showMessageDialog(this,"There is no category. Please proceed to add a category first.");
			System.exit(1);
		}
	}
	
	public String getProductCode(){
		String selectedCat = catList.getSelectedItem().toString();
		String prodCode;
		ArrayList<Product> productList = win.getProductsForCategory(selectedCat);
		if(productList == null){
			prodCode = selectedCat+"/1";		
		}
		else{
			int prodSize = productList.size()+1;
			prodCode = selectedCat+"/"+prodSize;
		}
		return prodCode;
	}
	
	public void performOkAction(){
		String cat = catList.getSelectedItem().toString();
		String id = prodId.getText();
		int thres = Integer.parseInt(tf2_thres.getText());
		double price = Double.parseDouble(tf3_price.getText());
		String desc = tf4_desc.getText();
		String name = tf5_name.getText();
		int quan = Integer.parseInt(tf6_quan.getText());
		int placeOrder = Integer.parseInt(tf7_order.getText());
		int limit = Integer.parseInt(tf8_limit.getText());
		win.addProduct(cat,id,name,desc,quan,price,thres,placeOrder,limit);
		AddMoreProducts p = new AddMoreProducts(win);
		dispose();
		}
}

