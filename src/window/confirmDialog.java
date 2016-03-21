package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class confirmDialog extends JDialog{
	MainManageWindow win;
	JPanel panel;
	JButton yes;
	JButton no;
	
	public confirmDialog(MainManageWindow win,Object obj){
		this.win = win;
		createFormPanel(obj);
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(Object obj){
		System.out.println("Creating dialog box");
		panel = new JPanel();
		yes = new JButton("Yes");
		no = new JButton("No");
		panel.add(yes);
        panel.add(no);
        add(panel);
        setTitle("Confirm Remove");
        setSize(150,100);
        setVisible(true);
        
		yes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					performOkAction(obj);
			}
			});
		no.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
	}
	
	public void performOkAction(Object obj){
		if(obj instanceof MemberPanel){
			win.removeSelectedMember();
			dispose();
		}

	}
}
