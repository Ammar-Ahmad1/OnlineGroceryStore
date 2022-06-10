package application;

import java.io.IOException;

import businessLogic.WareHouse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagerControl {

	@FXML 
	AnchorPane ap;

	@FXML
    Stage stage;
	@FXML
	Scene scene;
	@FXML
	Parent root;
	@FXML
	private TextField manager_password;
	@FXML
	private TextField manager_username;
	@FXML
	private Label managerloginResult;
	@FXML
	private TextField customerID;
	@FXML
	private Label feedbackResult;
	@FXML
	private Label customer_name;
	@FXML
	private Label customer_ph;
	@FXML
	private Label customer_address;
	@FXML
	private Label complaint;
	@FXML
	private Label itemID;
	@FXML
	private Label itemName;
	@FXML
	private Label quantity;
	@FXML
	private Label itemPrice;

	
	static WareHouse WareHouse_obj = new WareHouse();	
	
	@FXML
	public void to_managerLogin(ActionEvent ae) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ManagerLogin_screen.fxml"));
		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void to_managerDashboard(ActionEvent ae) throws IOException {
		String user = manager_username.getText();
		String pass = manager_password.getText();		
		
		boolean flag = WareHouse_obj.manager_loginVerifier(user, pass);
		
		if(flag) {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("ManagerDashboard_screen.fxml"));
			ap.getChildren().setAll(pane);
		}
		else {
			System.out.println("dsds ");
			managerloginResult.setText("Login failed try again");
		}
		
	}
	
	@FXML
	public void findFeedBack(ActionEvent ae) throws IOException {
	
		String OID = customerID.getText();
	
		int O_ID = Integer.parseInt(OID);
		
		String flag = WareHouse_obj.findFeedBack(O_ID);
		if(flag.equalsIgnoreCase("No feedback")) {
			feedbackResult.setText("No feedback found :(");		
		}
		else {
			feedbackResult.setText(flag);	
		}

		
	}
	
	
	@FXML
	public void to_manageItem_admin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Emanager_additem_screen.fxml"));
		ap.getChildren().setAll(pane);	
	}
	
	@FXML
	public void ConfirmAddItems(ActionEvent ae) throws IOException {
		String ID = itemID.getText();
		String name = itemName.getText();
		String qty = quantity.getText();	
		String price = itemPrice.getText();
		
		int id = Integer.parseInt(ID);
		int q = Integer.parseInt(qty);
		int p = Integer.parseInt(price);
		WareHouse_obj.additems_manager(id, name, q, p);

	}
	
	@FXML
	public void to_ViewCustomers_admin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Manager_viewCustomers_screen.fxml"));
		ap.getChildren().setAll(pane);	
	}

	@FXML
	public void getCustomerDetails(ActionEvent ae) throws IOException {
	
		String CID = customerID.getText();
	
		int C_ID = Integer.parseInt(CID);
		
		String[] flag = WareHouse_obj.CustomerDetails(C_ID);
		if(flag.equals(null)) {
			customer_name.setText("No name found :(");		
			customer_ph.setText("No number found :(");		
			customer_address.setText("No address found :(");		
		}
		else {
			customer_name.setText(flag[1]);
			customer_ph.setText(flag[4]);		
			customer_address.setText(flag[5]);		
		}

		
	}

	
	@FXML
	public void to_manageComplaints_admin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Manager_HandleComplaints_screen.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	@FXML
	public void getComplaints(ActionEvent ae) throws IOException {
	
		String[] flag = WareHouse_obj.getComplaints();
		String s = "";
		
		for(int j=0;j<flag.length;j++) {
			System.out.println(flag[j]);
			s = s.concat(flag[j]);
			s = s.concat("  ");
		}
		
		if(flag.equals(null)) {
			complaint.setText("No complaint!");		
		}
		else {
			complaint.setText(s);		
		}
		
	}
	
	
	@FXML
	public void to_addSupplier_admin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Manager_addSupplier_screen.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	@FXML
	public void to_viewSupplier_admin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Manager_ViewSuppliers_screen.fxml"));
		ap.getChildren().setAll(pane);
	}

	@FXML
	public void to_Login(ActionEvent ae) throws IOException {		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("login_screen.fxml"));
		ap.getChildren().setAll(pane);	}
	@FXML
	public void backToDashBoard(ActionEvent ae) throws IOException {		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("ManagerDashboard_screen.fxml"));
		ap.getChildren().setAll(pane);	
	}
	
}
