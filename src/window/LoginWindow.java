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

import org.omg.CORBA.PUBLIC_MEMBER;

import controller.DataHandler;

/**
 * 
 * @author Premraj M
 *
 */

public class LoginWindow extends JFrame {
	
	DataHandler data;
	JLabel description, username, password;
	JTextField tusername;
	JPasswordField tpassword;
	JButton login,clear, signup;
	
	
	
	public LoginWindow(DataHandler data) 
	   { 
		super();
	      this.data = data;
	      this.setSize(500, 500); 
	      this.setLocation(600, 300);
	      this.getContentPane().setBackground(Color.LIGHT_GRAY);
	      this.setTitle("LoginWindow"); 
	      this.setLayout(null);

	      description= new JLabel("The Souvenir");
			tusername= new JTextField();
			tpassword= new JPasswordField();
			username= new JLabel("Username");
			password= new JLabel("Password");
			login= new JButton("Login");
			clear= new JButton("Clear");
			signup= new JButton("Signup");
			
			description.setBounds(120,50,300,30);
			description.setFont(new Font("Sherif", Font.BOLD, 30));
			
			tusername.setBounds(200, 200, 100, 30);
			tpassword.setBounds(200, 260, 100, 30);
			
			username.setBounds(20, 170, 100, 100);
			username.setFont(new Font("Sherif", Font.BOLD, 20));
			password.setBounds(20, 225, 100, 100);
			password.setFont(new Font("Sherif", Font.BOLD, 20));
			
			clear.setBounds(100, 350, 90, 25);
			login.setBounds(200, 350, 90, 25);
			clear.setToolTipText("Clears  username and password");
			
			signup.setBounds(380,50, 90, 25);
			signup.setToolTipText("To register new storekeeper");
			
			clear.addActionListener(new ButtonClickHandler());
			login.addActionListener(new ButtonClickHandler());
			signup.addActionListener(new ButtonClickHandler());
			
			 	        
			add(description);
			add(tusername);
			add(tpassword);
			add(username);
			add(password);
			add(clear);
			add(login);
			add(signup);
			
	   }
	
	class ButtonClickHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent e){
			
			if(e.getSource() == clear)
			{
			tusername.setText("");
			tpassword.setText("");
			}
			else if(e.getSource() == login)
			{
				checkUser();
			}
			else if (e.getSource()== signup) {
				
				SignupWindow sw = new SignupWindow(data); 
			    sw.setVisible(true);
			    dispose();
				
			}
						
	}
		public void checkUser(){
			String username= tusername.getText();
			char[] password= tpassword.getPassword();
			String pString = String.valueOf(password);
			System.out.println("password" +pString);
			
			boolean val = DataHandler.data.checkStorekeeper(username,pString);
			if (val == true) {
				MainWindow window = new MainWindow(data);
				setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Username or Password doesnt exist!!"); 
			}
		}
	

  }
}


