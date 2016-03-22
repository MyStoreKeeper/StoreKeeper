package window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainWindow extends JFrame{
	
	public MainWindow() {
		getContentPane().setBackground(new Color(173, 216, 230));
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Auto-Loaded");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(280, 109, 151, 49);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ring Sales");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductsShoppingWindow shop = new ProductsShoppingWindow();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		btnNewButton.setToolTipText("Click here for Transactions");
		btnNewButton.setBounds(148, 63, 125, 144);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Store");
		btnNewButton_1.setBackground(new Color(240, 230, 140));
		btnNewButton_1.setToolTipText("Click here to manage store entities");
		btnNewButton_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 10));
		btnNewButton_1.setBounds(10, 66, 127, 39);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainManageWindow win = new MainManageWindow();
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reports");
		btnNewButton_2.setBackground(new Color(240, 230, 140));
		btnNewButton_2.setToolTipText("Click here to view reports on store items");
		btnNewButton_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
		btnNewButton_2.setBounds(10, 124, 128, 39);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Reports Window
				//dispose();
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Inventory");
		btnNewButton_3.setBackground(new Color(238, 232, 170));
		btnNewButton_3.setToolTipText("Click here to Check and Replenish Inventry");
		btnNewButton_3.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
		btnNewButton_3.setBounds(10, 172, 128, 35);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InventoryWindow invenWin = new InventoryWindow();
				dispose();
			}
		});
		getContentPane().add(btnNewButton_3);
		
		setTitle("UNIVERSITY STORE");
		setSize(500,300);
		setVisible(true);
	}
}
