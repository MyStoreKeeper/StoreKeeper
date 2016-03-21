package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCategoryDialog extends JDialog {
	JPanel new_panel;
	JButton ok;
	JButton cancel;
	JButton addVendor;
	JTextField tf1,tf2;
	ArrayList<JTextField> listOfVendorNames = new ArrayList<JTextField>();
	ArrayList<JTextField> listOfVendorDesc = new ArrayList<JTextField>();

	public AddCategoryDialog() {
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){

		setTitle("Add New Category");
		getContentPane().setLayout(null);
		
		new_panel = new JPanel();
		new_panel.setBounds(10, 123, 450, 242);
		new_panel.setLayout(null);
		getContentPane().add(new_panel);
		
		JLabel l1 = new JLabel("Category Name");
		l1.setBounds(5, 8, 90, 30);
		getContentPane().add(l1);
		tf1 = new JTextField(10);
		tf1.setBounds(108, 5, 86, 20);
		getContentPane().add(tf1);
		JLabel l2 = new JLabel("Category Code");
		l2.setBounds(5, 45, 83, 20);
		getContentPane().add(l2);
		tf2 = new JTextField(10);
		tf2.setBounds(108, 36, 86, 20);
		getContentPane().add(tf2);
		
		JLabel l3 = new JLabel("Associate Vendors:");
		l3.setBounds(5, 92, 190, 20);
		getContentPane().add(l3);
		addVendor = new JButton("Add Vendors");	
		addVendor.setBounds(208, 91, 117, 23);
		getContentPane().add(addVendor);

		ok = new JButton("Ok");
		ok.setBounds(104, 420, 68, 23);
		getContentPane().add(ok);
		cancel = new JButton("Cancel");
		cancel.setBounds(223, 420, 75, 23);
		getContentPane().add(cancel);

		
		addVendor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addVendor.setEnabled(false);
				System.out.println("Enter add vendors");				
				
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
				
				System.out.println("Added");
				getContentPane().validate();
				getContentPane().repaint();
				System.out.println("Revalidated");
			}
			});
		
        setSize(500,500);
        setVisible(true);
		
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					//performOkAction();
			}
			});
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
		
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
		
		System.out.println("Added");
		getContentPane().validate();
		getContentPane().repaint();
		System.out.println("Revalidated");
				
	}
}
