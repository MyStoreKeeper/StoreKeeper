package window;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.function.DoubleToLongFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import org.omg.CORBA.PUBLIC_MEMBER;

import controller.DataHandler2;
import objects.StoreKeeperSession;
import objects.Transaction_Item;

/**
 * 
 * @author vinayakPriya
 *
 */

public class BillWindow extends JFrame {
	DataHandler2 data;
	JPanel home_panel = new JPanel();
	JTextField jTextField=new JTextField(10);
	JTextField moneyEnetered=new JTextField(10);
	JButton btnNewButton = new JButton("ShowValue");
	JButton btnNewButton2 = new JButton("Redeem");
	JButton btnNewButton3 = new JButton("Payment");
	JButton btnNewButton4 = new JButton("PrintBill");
	double M;
	
	public BillWindow(Transaction_Item t, StoreKeeperSession s) throws IOException, ParseException{
		data=new DataHandler2();
		GUI(t,s);
		
		
	}
public void GUI(Transaction_Item t,StoreKeeperSession s) throws ParseException{
	getContentPane().setLayout(null);
	home_panel.setBounds(100, 500, 770, 160);
    home_panel.setLayout(null);
    getContentPane().add(home_panel);
    
    this.setSize(800, 800); 
    JLabel lblNewLabel = new JLabel("Payment Summary");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(330, 35, 190, 70);
		getContentPane().add(lblNewLabel);
		
	JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		lblNewLabel2.setBounds(150, 0, 190, 70);
		//lblNewLabel2.setText(data.getmemberStorekeeperName(t,s));
		
		
		
		
		String cost=Double.toString(this.calculateTotalCost(t));
		JLabel totalCostLabel = new JLabel("Total Cost                         :           "+cost+"$");
		totalCostLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		totalCostLabel.setBounds(220, 80, 290, 70);
		getContentPane().add(totalCostLabel);
		

		String disc=Double.toString(this.calculateDiscount(t));
		JLabel discountLabel = new JLabel("DiscountApplied      :     "+disc+"%");
		discountLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		discountLabel.setBounds(220, 120, 190, 70);
		getContentPane().add(discountLabel);
		
		int Lpoints=this.calculateloyaltypoints(t.memberID);
		JLabel lpoints = new JLabel("LoyaltyPoints      :        "+Lpoints);
		lpoints.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lpoints.setBounds(220, 160, 190, 70);
		if(t.memberID.compareTo("PUBLIC")!=0)
		{
			getContentPane().add(lpoints);
		
		}
		double redeemedcost=this.redeemLoyaltyPoints(t.memberID,Lpoints);
		
	    btnNewButton.setBounds(200, 70, 100, 16);
	    
	    JLabel showValueLabel = new JLabel("Value of Loyalty Points  :   "+redeemedcost+"$");
		showValueLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		showValueLabel.setBounds(220, 200, 220, 70);
		showValueLabel.setVisible(false);
		getContentPane().add(showValueLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				showValueLabel.setVisible(true);
				
				jTextField.setVisible(true);
				//dispose();
			}
		});
		
		jTextField.setBounds(220, 300, 200, 40);
		getContentPane().add(jTextField);
		jTextField.setVisible(false);
		moneyEnetered.setBounds(280, 340, 200, 40);
		getContentPane().add(moneyEnetered);
		moneyEnetered.setVisible(false);
		
		JLabel redeemPointsLabel = new JLabel("RedeemedLPV:");
		redeemPointsLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		redeemPointsLabel.setBounds(220, 230, 220, 70);
		redeemPointsLabel.setVisible(false);
		getContentPane().add(redeemPointsLabel);
		
		JLabel moneytoBePaid = new JLabel("Payment to be made:");
		 moneytoBePaid.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		 moneytoBePaid.setBounds(220, 270, 290, 70);
		moneytoBePaid.setVisible(false);
		getContentPane().add(moneytoBePaid);
		
		JLabel chnageLabel = new JLabel("Change:");
		chnageLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		chnageLabel.setBounds(220, 320, 220, 70);
		chnageLabel.setVisible(false);
		getContentPane().add(chnageLabel);
		
		btnNewButton4.setBounds(0, 0, 100, 16);
		btnNewButton4.setVisible(false);
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		}});
		
		btnNewButton3.setBounds(0, 0, 100, 16);
		btnNewButton3.setVisible(false);
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moneyEnetered.setVisible(false);
				double money = 0;
				
				try{
					money=Integer.parseInt(moneyEnetered.getText());
					System.out.println(money);
				}
				catch(NumberFormatException e){
					
				}
				double change=computeChange(money,M);
				chnageLabel.setText("Change  :"+change);
				chnageLabel.setVisible(true);
				btnNewButton3.setVisible(false);
				btnNewButton4.setVisible(true);
				
			}});
		
		btnNewButton2.setBounds(0, 0, 100, 16);
		btnNewButton2.setVisible(true);
	
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int point = 0;
				
				try{
					point=Integer.parseInt(jTextField.getText());
					System.out.println(point);
				}
				catch(NumberFormatException e){
					
				}
				double redeemedcost;
				redeemedcost=redeemLoyaltyPoints(t.memberID, point);
				System.out.println(redeemedcost);
				jTextField.setVisible(false);
				btnNewButton2.setVisible(false);
				btnNewButton.setVisible(false);
				
				
				try {
					M = moneyToBePaid(t,point);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				redeemPointsLabel.setText("RedeemedLPV:"+redeemedcost+"$");
				
				redeemPointsLabel.setVisible(true);
				
				
				
				moneytoBePaid.setText("Payment to be made   :   "+M);
				
				moneytoBePaid.setVisible(true);
				moneyEnetered.setVisible(true);
				
				btnNewButton3.setVisible(true);
				
				
				
				//dispose();
			}
		});
		
		
			
	    
	     
	      home_panel.add(btnNewButton);
	      home_panel.add(btnNewButton2);
	      home_panel.add(btnNewButton3);
	      home_panel.add(btnNewButton4);
	      
	      
		
		
		
	
	setTitle("UNIVERSITY STORE");
	//setSize(500,400);
	setVisible(true);
}


 
public BillWindow(Transaction_Item t){
	 JLabel lblNewLabel = new JLabel("Auto-Loaded");
	  calculateTotalCost(t);
	  if(t.memberID!="PUBLIC")
	  {
		  calculateloyaltypoints(t.memberID);
	  }
		 
	 
	 
 }
 public BillWindow() {
	// TODO Auto-generated constructor stub
}
public double calculateTotalCost(Transaction_Item t){
	 double cost=0;
	 
	 cost=data.calculateTotalCost(t);
	 
	return cost;
	 
	 
 }
 public int calculateloyaltypoints(String memberId){
	 int points=data.calculateloyaltypoints(memberId);
	 
	return points;
	 
	 
 }
 public double redeemLoyaltyPoints(String memberId,int points){
	 double redeemedCost=0;
	 
		 redeemedCost=data.redeemLoyaltyPoints(memberId,points);
	 
	 
	 
	return redeemedCost;
	 
	 
 }
 public double computeChange(double moneyGiven,double payment){
	 double changeDue=0;
	 changeDue=moneyGiven-payment;
	 
	 return changeDue;
	 
 }
 public String showShopkeeperName(){
	 return "sto";
 }
 public double calculateDiscount(Transaction_Item t) throws ParseException{
	 double discount;
	 discount=data.calculateDiscount(t);
	 return discount;
 }
 public double moneyToBePaid(Transaction_Item t,int points) throws ParseException{
	 
	 double moneyToBePaid = 0.0;
	 double discount;
	 double redeemedCost;
	 double finalCost;
	 discount=calculateDiscount(t);
	 moneyToBePaid=calculateTotalCost(t);
	 double discountedCost=((100.0-discount)*moneyToBePaid)/100.0;
	 
	 if(t.memberID.compareTo("PUBLIC")==0){
		 redeemedCost=0.0;
	 }
	 else
		 {
		 redeemedCost=redeemLoyaltyPoints(t.memberID,points);
		 
	// data.updateLoyaltyPoints(t.points,t.memberID);
		 }
	 if(redeemedCost>=discountedCost){
		 finalCost=0;
	 }
	 else
	 finalCost=discountedCost-redeemedCost;
	 
	 return finalCost;
 }
}
