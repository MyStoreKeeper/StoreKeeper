package window;

import javax.swing.JFrame;

import controller.DataHandler;

/**
 * 
 * @author Premraj M
 *
 */

public class LoginWindow extends JFrame {
	
	public LoginWindow() 
	   { 
	      super(); 
	      this.setSize(500, 500); 
	      this.setLocation(600, 300);
	      this.getContentPane().setLayout(null);
	      this.setTitle("LoginWindow"); 
	      
	      //init DataHandler , then call data by DataHandler.data
	      DataHandler.initDataHandler();
	      
	      DataHandler.data.set
	   } 
}
