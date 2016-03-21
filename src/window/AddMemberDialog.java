package window;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMemberDialog extends JDialog {
	MainManageWindow win;
	JPanel panel;
	JButton ok;
	JButton cancel;
	JTextField tf1,tf2;
	
	public AddMemberDialog(MainManageWindow win) {
		this.win = win;
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){

		panel = new JPanel();
		panel.setLayout(null);
		JLabel l1 = new JLabel("Member Name");
		l1.setBounds(32, 8, 90, 14);
		panel.add(l1);
		tf1 = new JTextField(10);
		tf1.setBounds(130, 5, 86, 20);
		panel.add(tf1);
		JLabel l2 = new JLabel("Member ID");
		l2.setBounds(32, 43, 90, 14);
		panel.add(l2);
		tf2 = new JTextField(10);
		tf2.setBounds(130, 40, 86, 20);
		panel.add(tf2);
		
		ok = new JButton("Ok");
		ok.setBounds(68, 102, 60, 23);
		panel.add(ok);

		cancel = new JButton("Cancel");
		cancel.setBounds(148, 102, 80, 23);
        panel.add(cancel);

        setTitle("Add New Member");
        getContentPane().add(panel);
        setSize(300,200);
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
		String name = tf1.getText();
		String id = tf2.getText();
		if(!name.isEmpty() && !id.isEmpty()){
			win.addMember(name,id);
			dispose();
		}
	}

}
