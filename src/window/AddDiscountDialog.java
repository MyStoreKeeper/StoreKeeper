package window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDiscountDialog extends JDialog{
	
	MainManageWindow win;
	private JLabel tf_code;
	private JTextField tf_desc;
	private JTextField tf_val;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField tf_sd;
	private JTextField tf_dur;
	
	public AddDiscountDialog(MainManageWindow win) {
		this.win = win;
		createFormPanel();
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              dispose();
           }
        });
	}
	
	public void createFormPanel(){
		setTitle("Add New Discount");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Discount Code");
		lblNewLabel.setBounds(21, 11, 86, 14);
		getContentPane().add(lblNewLabel);
		
		String code = "DIS-"+(getDiscountSize()+1);
		tf_code = new JLabel(code);
		tf_code.setBounds(136, 8, 86, 20);
		getContentPane().add(tf_code);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(21, 47, 70, 14);
		getContentPane().add(lblDescription);
		
		tf_desc = new JTextField();
		tf_desc.setBounds(136, 39, 86, 20);
		getContentPane().add(tf_desc);
		tf_desc.setColumns(10);
		
		JLabel lblDiscountPercent = new JLabel("Discount Percent");
		lblDiscountPercent.setBounds(21, 81, 100, 14);
		getContentPane().add(lblDiscountPercent);
		
		tf_val = new JTextField();
		tf_val.setBounds(136, 75, 86, 20);
		getContentPane().add(tf_val);
		tf_val.setColumns(10);
		
		JRadioButton rdbtnMember = new JRadioButton("MEMBER");
		rdbtnMember.setActionCommand("Member");
		buttonGroup.add(rdbtnMember);
		rdbtnMember.setBounds(136, 119, 86, 23);
		getContentPane().add(rdbtnMember);
		
		JRadioButton rdbtnAll = new JRadioButton("ALL");
		rdbtnAll.setActionCommand("All");
		buttonGroup.add(rdbtnAll);
		rdbtnAll.setSelected(true);
		rdbtnAll.setBounds(239, 119, 109, 23);
		getContentPane().add(rdbtnAll);
		
		JLabel lblApplicableFor = new JLabel("Applicable For");
		lblApplicableFor.setBounds(21, 123, 86, 14);
		getContentPane().add(lblApplicableFor);
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 195, 289, 60);
		getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(10, 11, 80, 14);
		panel.add(lblStartDate);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(10, 36, 61, 14);
		panel.add(lblDuration);
		
		tf_sd = new JTextField();
		tf_sd.setBounds(100, 8, 86, 20);
		panel.add(tf_sd);
		tf_sd.setColumns(10);
		
		tf_dur = new JTextField();
		tf_dur.setBounds(100, 33, 86, 20);
		panel.add(tf_dur);
		tf_dur.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(d-MMM-yyyy)");
		lblNewLabel_1.setBounds(196, 11, 83, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(In days)");
		lblNewLabel_2.setBounds(196, 36, 83, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblApplicablePeriod = new JLabel("Applicable Period");
		lblApplicablePeriod.setBounds(21, 162, 100, 14);
		getContentPane().add(lblApplicablePeriod);
		
		JRadioButton rdbtnAlways = new JRadioButton("ALWAYS");
		rdbtnAlways.setActionCommand("Always");
		buttonGroup_1.add(rdbtnAlways);
		rdbtnAlways.setBounds(140, 158, 80, 23);
		rdbtnAlways.setSelected(true);
		getContentPane().add(rdbtnAlways);
		rdbtnAlways.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
			});
		
		JRadioButton rdbtnLimitedPeriod = new JRadioButton("LIMITED PERIOD");
		rdbtnLimitedPeriod.setActionCommand("Limited");
		buttonGroup_1.add(rdbtnLimitedPeriod);
		rdbtnLimitedPeriod.setBounds(239, 158, 140, 23);
		getContentPane().add(rdbtnLimitedPeriod);
		rdbtnLimitedPeriod.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
			});
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					performOkAction();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(123, 277, 56, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(220, 277, 90, 23);
		getContentPane().add(btnCancel);
						
        setSize(500,350);
        setVisible(true);
	}
	
	public void performOkAction() throws ParseException{
		String sd = "N/A";
		int period = 0;
		if(!tf_code.getText().isEmpty() && !tf_desc.getText().isEmpty() && 
				!tf_val.getText().isEmpty()){
			String code = tf_code.getText();
			String desc = tf_desc.getText();
			Double val = Double.parseDouble(tf_val.getText());
			String type = buttonGroup.getSelection().getActionCommand();
			String dur = buttonGroup_1.getSelection().getActionCommand();
			if(dur.equals("Limited")){
				if(!tf_sd.getText().isEmpty() && !tf_dur.getText().isEmpty()){
					sd = tf_sd.getText();
					period = Integer.parseInt(tf_dur.getText());
					SimpleDateFormat ft = new SimpleDateFormat ("d-MMM-yyyy");
					DateFormat ft1 = new SimpleDateFormat ("d-MMM-yyyy");
					Date startDate = ft.parse(sd);
					Date currentDate = new Date();
					currentDate = ft.parse(ft1.format(currentDate));
					Calendar cal  = Calendar.getInstance();
					cal.setTime(startDate);
					cal.add(Calendar.DATE, period);
					Date newDate = cal.getTime();
					if(newDate.before(currentDate)){
						JOptionPane.showMessageDialog(this,"Invalid Discount Period!");
					}
					else{
						win.addDiscount(code,type,desc,sd,period,val);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Please Enter All Details.");
				}
			}
			else{
				win.addDiscount(code,type,desc,sd,period,val);
				dispose();
			}	
		}
		else{
			JOptionPane.showMessageDialog(this,"Please Enter All Details.");
		}
	}
	
	public int getDiscountSize(){
		int size = win.getDiscounts().size();
		return size;
	}
}
