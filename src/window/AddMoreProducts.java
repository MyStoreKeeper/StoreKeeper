package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddMoreProducts extends JDialog{
	MainManageWindow win;
	JPanel panel = new JPanel();
	JButton yes;
	JButton no;
	JLabel label;
	
	public AddMoreProducts(MainManageWindow win){
		this.win = win;
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){
		label = new JLabel("Do you wish to continue adding more products?");
		label.setBounds(24, 26, 280, 14);
		yes = new JButton("Yes");
		yes.setBounds(60, 51, 60, 23);
		no = new JButton("No");
		no.setBounds(130, 51, 60, 23);
		panel.add(label);
		panel.add(yes);
        panel.add(no);
        getContentPane().add(panel);
        setTitle("Add Products");
        setSize(330,150);
        setVisible(true);
        
		yes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					performOkAction();
			}
			});
		no.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
	}
	
	public void performOkAction(){
		AddProductDialog apd = new AddProductDialog(win);
			dispose();
		}

	}
