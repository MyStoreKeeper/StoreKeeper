import controller.DataHandler;
import window.LoginWindow;
import window.MainManageWindow;
import window.MainWindow;

public class ModelStoreApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LoginWindow w = new LoginWindow(); 
	    //w.setVisible(true);
		DataHandler.initDataHandler();
		LoginWindow login = new LoginWindow(DataHandler.data);
		login.setVisible(true);
	    System.out.println("Test Print");
	}

}
