package window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVendorDialog extends JDialog{

	JPanel new_panel;
	JButton ok;
	JButton cancel;
	JLabel cat_name;
	ArrayList<JTextField> listOfVendorNames = new ArrayList<JTextField>();
	ArrayList<JTextField> listOfVendorDesc = new ArrayList<JTextField>();

	public AddVendorDialog() {
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){

		setTitle("Add Vendors To Category");
		getContentPane().setLayout(null);
		
		new_panel = new JPanel();
		new_panel.setBounds(10, 123, 450, 242);
		new_panel.setLayout(null);
		getContentPane().add(new_panel);
		
		JLabel l1 = new JLabel("Category Name:");
		l1.setBounds(19, 10, 90, 30);
		getContentPane().add(l1);
		cat_name = new JLabel("Auto-Filled");
		cat_name.setBounds(131, 15, 86, 20);
		getContentPane().add(cat_name);
		JButton addVendor = new JButton("Add More Vendors");
		addVendor.setBounds(10, 68, 190, 20);
		getContentPane().add(addVendor);
		addVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addVendor.setEnabled(false);
				JLabel l_name = new JLabel("Vendor Name");
				l_name.setBounds(15, 11, 80, 14);
				new_panel.add(l_name);
				JLabel l_desc = new JLabel("Description");
				l_desc.setBounds(161, 11, 90, 14);
				new_panel.add(l_desc);
				
				JTextField tf_name = new JTextField(10);
				tf_name.setBounds(9, 32, 86, 20);
				new_panel.add(tf_name);
				listOfVendorNames.add(tf_name);
				JTextField tf_desc = new JTextField(10);
				tf_desc.setBounds(152, 32, 175, 20);
				new_panel.add(tf_desc);
				listOfVendorDesc.add(tf_desc);
				
				JButton btnNewButton = new JButton("+");
				btnNewButton.setBounds(347, 32, 45, 23);
				new_panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addMoreVendors(57);
						btnNewButton.setEnabled(false);
					}
				});
				getContentPane().validate();
				getContentPane().repaint();
			}
			});
		
		ok = new JButton("Ok");
		ok.setBounds(104, 420, 68, 23);
		getContentPane().add(ok);
		cancel = new JButton("Cancel");
		cancel.setBounds(223, 420, 75, 23);
		getContentPane().add(cancel);
		
        setSize(500,500);
        setVisible(true);
}
	public void addMoreVendors(int y){
		JTextField tf_name = new JTextField(10);
		tf_name.setBounds(9, y, 86, 20);
		new_panel.add(tf_name);
		listOfVendorNames.add(tf_name);
		JTextField tf_desc = new JTextField(10);
		tf_desc.setBounds(152, y, 175, 20);
		new_panel.add(tf_desc);
		listOfVendorDesc.add(tf_desc);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(347, y, 45, 23);
		new_panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMoreVendors(y+25);
				btnNewButton.setEnabled(false);
			}
		});
		
		getContentPane().validate();
		getContentPane().repaint();
				
	}
}
