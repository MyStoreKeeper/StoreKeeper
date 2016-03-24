package window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import controller.DataHandler;

/**
 * 
 * @author Premraj M
 *
 */
public class Test extends JFrame {
	

	DataHandler data;
	JLabel label = new JLabel("Reports ");
	JPanel panel,p1,p2,p3;
	
	Object[][] values = {};
	

	private JTable table = new JTable();
	String[] columnNames = {"Category", "CategoryID"};
	DefaultTableModel dtm = new DefaultTableModel(values,columnNames);
	
	private JTable table1 = new JTable();
	String[] columnNames1 = {"Product", "ID","Quantity","Price"};
	DefaultTableModel dtm1 = new DefaultTableModel(values,columnNames1);
	
	private JTable table2 = new JTable();
	String[] columnNames2 = {"Category", "CategoryID"};
	DefaultTableModel dtm2 = new DefaultTableModel(values,columnNames2);
	
	private JTable table3 = new JTable();
	String[] columnNames3 = {"MemberID", "Member Name"};
	DefaultTableModel dtm3 = new DefaultTableModel(values,columnNames3);
	
	public Test(){
		
		setSize(800,550);
		setVisible(true);
		setTitle("Report Window");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(26, 56, 736, 432);
		getContentPane().add(tabbedPane);
		
		label.setBounds(30, 20, 116, 25);
		label.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		getContentPane().add(label);
		
		//Category Report
		table.setFont(new Font("Georgia", Font.BOLD, 11));
		table.setModel(dtm);
		panel = new JPanel();
		panel.setBounds(28, 75, 731, 410);
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(table);
		
	    tabbedPane.addTab("Categories",add(panel));
	    
	    JButton pCat = new JButton("Print Categories Report");
	    panel.add(pCat,BorderLayout.PAGE_END);
	    
		//Product Report
		table1.setFont(new Font("Georgia", Font.BOLD, 11));
		table1.setModel(dtm1);
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(table1.getTableHeader(), BorderLayout.PAGE_START);
		p1.add(table1, BorderLayout.CENTER);
		JButton pProd = new JButton("Print Products Report");
	    p1.add(pProd,BorderLayout.PAGE_END);
	    tabbedPane.addTab("Products",add(p1));

      //Transaction Report
        	JLabel description, startDate,endDate;
        	JTextField astartDate,aendDate;
        	JButton search;
        	description =new JLabel("Generate Transaction report");
        	startDate=new JLabel("Start Date");
        	endDate=new JLabel("End Date");
        	astartDate= new JTextField();
        	aendDate= new JTextField();
        	search= new JButton("Search");
        	
        	//Specify component properties
        	description.setBounds(120, 20, 300, 30);
        	description.setFont(new Font("Georgia", Font.BOLD, 20));
        	startDate.setBounds(60, 100, 300, 30);
        	
        	startDate.setFont(new Font("Georgia", Font.BOLD, 15));
        	astartDate.setBounds(200, 100, 100, 30);
        	
        	endDate.setBounds(60, 200, 300, 30);
        	endDate.setFont(new Font("Georgia", Font.BOLD, 15));
        	aendDate.setBounds(200, 200, 100, 30);
        	
        	search.setBounds(60, 280, 90, 25);
        	
        	//Register the event handler method
        	search.addActionListener(new searchClickHandler());
        	
//      		table2.setFont(new Font("Georgia", Font.BOLD, 11));
//      		table2.setModel(dtm2);
      		p2 = new JPanel();
      		p2.setLayout(null);
      		p2.add(description);
      		p2.add(astartDate);
      		p2.add(aendDate);
      		p2.add(startDate);
      		p2.add(endDate);
      		p2.add(search);
            tabbedPane.addTab("Transaction",add(p2));
              
            //Members Report
        	table3.setFont(new Font("Georgia", Font.BOLD, 11));
        	table3.setModel(dtm3);
        	p3 = new JPanel();
        	p3.setLayout(new BorderLayout());
        	p3.add(table3.getTableHeader(), BorderLayout.PAGE_START);
        	p3.add(table3, BorderLayout.CENTER);
            JButton pMem = new JButton("Print Members Report");
    	    p3.add(pMem,BorderLayout.PAGE_END);
            tabbedPane.addTab("Members",add(p3));
            
		
	}
	
	public class searchClickHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
  		table2.setFont(new Font("Georgia", Font.BOLD, 11));
  		table2.setModel(dtm2);
  		
  		p2.removeAll();
		p2.setLayout(new BorderLayout());
  		
		p2.add(table2.getTableHeader(), BorderLayout.PAGE_START);
		p2.add(table2, BorderLayout.CENTER);
		JButton pTran = new JButton("Print Transactions Report");
		p2.add(pTran,BorderLayout.PAGE_END);
		repaint();
		revalidate();
			
		}
	}
		
	
		
	

	
	
}