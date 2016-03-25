package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.DataHandler;
import window.LoginWindow.ButtonClickHandler;
/**
 * 
 * @author Premraj M
 *
 */

public class SignupWindow extends JFrame {
	
	JLabel description, firstname, lastname, username,password;
	JTextField tfirstname, tlastname,tusername;
	JButton clear, submit;
	JPasswordField tpassword;
	
	DataHandler data;
	
	
	
	public SignupWindow(DataHandler data){
		 super(); 
		 this.data = data;
	      this.setSize(500, 500); 
	      this.setLocation(600, 300);
	      this.getContentPane().setBackground(Color.LIGHT_GRAY);
	      this.setTitle("New Storekeeper Registration"); 
	      this.setLayout(null);
	      
	      description = new JLabel("Register New User");
	      firstname = new JLabel("Firstname");
	      lastname = new JLabel("Lastname");
	      username = new JLabel("Username");
	      password = new JLabel("Password");
	      
	      tfirstname= new JTextField();
		  tlastname= new JTextField();
	      tusername= new JTextField();
		  tpassword= new JPasswordField();
		  
		  submit= new JButton("Submit");
		  clear= new JButton("Clear");
		  
		  description.setBounds(120,50,300,30);
		  description.setFont(new Font("Sherif", Font.BOLD, 30));
		  
		  firstname.setBounds(20, 90, 100, 100);
		  firstname.setFont(new Font("Sherif", Font.BOLD, 20));
		  
		  lastname.setBounds(20, 130, 100, 100);
		  lastname.setFont(new Font("Sherif", Font.BOLD, 20));
			
			username.setBounds(20, 170, 100, 100);			
			username.setFont(new Font("Sherif", Font.BOLD, 20));
			  
			    password.setBounds(20, 210, 100, 100);
			    password.setFont(new Font("Sherif", Font.BOLD, 20));
			    
			    tfirstname.setBounds(200, 120, 100, 30);
				tlastname.setBounds(200, 160, 100, 30);
				 tusername.setBounds(200, 200, 100, 30);
					tpassword.setBounds(200, 240, 100, 30);
					
			    clear.setBounds(100, 350, 90, 25);
			    submit.setBounds(200, 350, 90, 25);
				clear.setToolTipText("Clears  all fields");
				
				clear.addActionListener(new ButtonClickHandler());
				submit.addActionListener(new ButtonClickHandler());
				
				
				add(description);
				add(tfirstname);
				add(tlastname);
				add(tusername);
				add(tpassword);
				add(firstname);
				add(lastname);
				add(username);
				add(password);
				add(clear);
				add(submit);
				

	}
	
	public class ButtonClickHandler implements ActionListener
	{
		
		public void actionPerformed (ActionEvent e){
			
			if(e.getSource() == clear)
			{
				tfirstname.setText("");
				tlastname.setText("");
				tusername.setText("");
				tpassword.setText("");
			}
			
			
			else if(e.getSource() == submit)
			{
				String username=tusername.getText();
				char[] password=tpassword.getPassword();
				checkDuplicateuser();
				

			}
		}
		
		public void checkDuplicateuser(){
			String username= tusername.getText();
			char[] password= tpassword.getPassword();
			String pString = String.valueOf(password);
			System.out.println("password" +pString);
			
			boolean val = DataHandler.data.checkDuplicateStorekeeper(username,pString);
			if (val == true) {
				addStorekeeper(username, password);
				JOptionPane.showMessageDialog(null, "Storekeeper registered successfully"); 
				LoginWindow w = new LoginWindow(data); 
				
			    w.setVisible(true);
			    dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Username already exist!!"); 
			}
		}
	}
		 
		public void addStorekeeper(String username, char[] Password)
		{
			String pw= String.valueOf(Password);
			DataHandler.data.addStorekeeper(username,pw);
		}

}
