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
import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.Category;

public class AddProductDialog extends JDialog {
	JPanel panel;
	JButton ok;
	JButton cancel;
	JComboBox catList;
	JTextField tf1_id,tf2_thres,tf3_price,tf4_desc,tf5_name,tf6_quan,tf7,tf8;
	//ArrayList<Category> cat_list = new ArrayList<Category>();
	String[] cat_list = {"MUG","CLO"};
	
	public AddProductDialog() {
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){

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
		tf1_id = new JTextField(10);
		tf1_id.setBounds(115, 36, 86, 20);
		
		catList = new JComboBox(cat_list);
		catList.setBounds(115, 5, 60, 20);
		tf1_id.setText(catList.getSelectedItem().toString()+"/");
		catList.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	          String str = (String)catList.getSelectedItem();
	          tf1_id.setText(str+"/");
	        }
	      });
		
		tf2_thres = new JTextField(10);
		tf2_thres.setBounds(115, 136, 86, 20);
		tf3_price = new JTextField(10);
		tf3_price.setBounds(115, 167, 86, 20);
		tf4_desc = new JTextField(10);
		tf4_desc.setBounds(115, 105, 86, 20);
		tf5_name = new JTextField(10);
		tf5_name.setBounds(115, 67, 86, 20);
		tf6_quan = new JTextField(10);
		tf6_quan.setBounds(115, 203, 86, 20);
		ok = new JButton("Ok");
		ok.setBounds(98, 247, 60, 23);
		cancel = new JButton("Cancel");
		cancel.setBounds(203, 247, 80, 23);
		panel.setLayout(null);
		panel.add(l);
		panel.add(catList);
		panel.add(l1);
		panel.add(tf1_id);
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
        setSize(400,320);
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


	public void performOkAction(){
		String id = tf1_id.getText();
		int thres = Integer.parseInt(tf2_thres.getText());
		double price = Double.parseDouble(tf3_price.getText());
		String desc = tf4_desc.getText();
		String name = tf5_name.getText();
		int quan = Integer.parseInt(tf6_quan.getText());
		//TO-DO
		dispose();
		}
}

