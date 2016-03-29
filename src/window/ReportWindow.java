package window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import controller.DataHandler;
import objects.Category;
import objects.Member;
import objects.Product;
import objects.Transaction_Item;

/**
 * 
 * @author Premraj M
 *
 */
public class ReportWindow extends JFrame {
	
	DataHandler data;
	
	JLabel label = new JLabel("Reports ");
	JPanel panel,p1,p2,p3;
	
	JButton Print = new JButton("Print");
	
	Object[][] memValues = {};
	Object[][] catValues = {};
	Object[][] prodValues = {};
	Object[][] transValues = {};
	
	JTabbedPane tabbedPane;
	
	private JTable table = new JTable();
	String[] columnNames = {"Category", "CategoryID"};
	DefaultTableModel dtm = new DefaultTableModel(catValues,columnNames);
	
	private JTable table1 = new JTable();
	String[] columnNames1 = {"Product", "ID","Quantity","Price"};
	DefaultTableModel dtm1 = new DefaultTableModel(prodValues,columnNames1);
	
	private JTable table2 = new JTable();
	String[] columnNames2 = {"Product ID", "Product Name","Product Description"};
	DefaultTableModel dtm2 = new DefaultTableModel(transValues,columnNames2);
	TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm2);
	 
	 
	private JTable table3 = new JTable();
	String[] columnNames3 = {"MemberID", "Member Name"};
	DefaultTableModel dtm3 = new DefaultTableModel(memValues,columnNames3);
	
	public ReportWindow(DataHandler data){
		
		this.data = data;
		refresh();
		
		setSize(800,550);
		setVisible(true);
		setTitle("Report Window");
		getContentPane().setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(ReportWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		btnHome.setBounds(670, 11, 90, 23);
		getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainWindow main_win = new MainWindow(data);
				dispose();
			}
			});
		
		tabbedPane = new JTabbedPane();
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
	    
	  //Print
	    ActionListener printCategory = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
                table.print();
              } catch (PrinterException pe) {
                System.err.println("Error printing: " + pe.getMessage());
              }
            }
          };
          pCat.addActionListener(printCategory);
	    
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
	    
	    //Print
	    ActionListener printProduct = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
                table1.print();
              } catch (PrinterException pe) {
                System.err.println("Error printing: " + pe.getMessage());
              }
            }
          };
          pProd.addActionListener(printProduct);
          
          //Transactions Report
          p2 = transactionDesign();
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
            
            //Print
            
    		ActionListener printMembers1 = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  try {
                    table3.print();
                  } catch (PrinterException pe) {
                    System.err.println("Error printing: " + pe.getMessage());
                  }
                }
              };
              pMem.addActionListener(printMembers1);
            
		
	}
	

		public void getTransactionTable(JPanel tPanel){
		
		p2 = tPanel;	
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0,2));
  		table2.setFont(new Font("Georgia", Font.BOLD, 11));
  		table2.setModel(dtm2);
  		table2.setRowSorter(sorter);
  		table2.setAutoCreateRowSorter(true);
  		p2.removeAll();
		p2.setLayout(new BorderLayout());
  		
		p2.add(table2.getTableHeader(), BorderLayout.PAGE_START);
		p2.add(table2, BorderLayout.CENTER);
		JButton pTran = new JButton("Print Transactions Report");
		JButton pNewSearch = new JButton("New Search");
		btnPanel.add(pTran);
		btnPanel.add(pNewSearch);
		
		p2.add(btnPanel,BorderLayout.PAGE_END);
		p2.repaint();
		p2.revalidate();
		
		ActionListener printAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
                table2.print();
              } catch (PrinterException pe) {
                System.err.println("Error printing: " + pe.getMessage());
              }
            }
          };
          pTran.addActionListener(printAction);
          
          pNewSearch.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent e) {
  				p2.removeAll();
  				p2 = transactionDesign();
  				p2.repaint();
  				p2.revalidate();
  			}
  			});
	
		}
	
	public JPanel transactionDesign(){
		
		JPanel tPanel = new JPanel();
		JPanel tPanel1;
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
    	
    	tPanel = new JPanel();
    	tPanel.setLayout(null);
    	tPanel.add(description);
    	tPanel.add(astartDate);
    	tPanel.add(aendDate);
    	tPanel.add(startDate);
    	tPanel.add(endDate);
    	tPanel.add(search);
    	
    	tPanel1 = tPanel;
    	
    	//Register the event handler method
        search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if (astartDate.getText().equals("") || aendDate.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Start Date and End Date field should not be blank"); 
					
				}else {
				
				    getTransactionTable(tPanel1);
				}
			
			}});
//  		table2.setFont(new Font("Georgia", Font.BOLD, 11));
//  		table2.setModel(dtm2);
  		return tPanel;
  		
	}
	
	public void refresh(){
		dtm.setRowCount(0);
		dtm1.setRowCount(0);
		dtm2.setRowCount(0);
		dtm3.setRowCount(0);
		ArrayList<Member> members = data.getMemberList();
		for(int i=0; i<members.size(); i++){
			String memName = members.get(i).getName();
			String memID = members.get(i).getMemberID();
			dtm3.addRow(new Object[] { memName, memID});
		}
		ArrayList<Category> category = data.getCategoryList();
		for(int i=0; i<category.size(); i++){
			String catName = category.get(i).getName();
			String catCode = category.get(i).getCode();
			dtm.addRow(new Object[] { catName, catCode});
		}
		ArrayList<Product> products = data.getProductList();
		for(int i=0; i<products.size(); i++){
			String prodName = products.get(i).getProductName();
			String prodId = products.get(i).getProductID();
			String quantity = String.valueOf(products.get(i).getQuantity());
			String price = String.valueOf(products.get(i).getPrice());
			dtm1.addRow(new Object[] { prodName, prodId,quantity,price});
		}
		/*ArrayList<Transaction_Item> transactions = data.getTransactionList();
		for(int i=0; i<products.size(); i++){
			String prodName = products.get(i).getProductName();
			String prodId = products.get(i).getProductID();
			String quantity = String.valueOf(products.get(i).getQuantity());
			String price = String.valueOf(products.get(i).getPrice());
			dtm1.addRow(new Object[] { prodName, prodId,quantity,price});
		}*/
	}
}


	


