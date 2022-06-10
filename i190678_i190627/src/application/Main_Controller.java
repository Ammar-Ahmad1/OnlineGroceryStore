package application;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import businessLogic.WareHouse;
import businessLogic.cust;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main_Controller {

	@FXML 
	AnchorPane ap;
	
	@FXML
    private TextField login_page_username;
	@FXML
	private TextField login_page_password;
	@FXML
	private Label loginResult;

	
	@FXML
	private TextField qty1;
	@FXML
	private TextField qty2;
	@FXML
	private TextField qty3;	
	@FXML
	private TextField qty4;
	@FXML
	private TextField qty5;
	@FXML
	private TextField qty6;
	@FXML
	private TextField qty7;
	@FXML
	private TextField qty8;
	@FXML
	private TextField qty9;
	@FXML
	private TextField qty10;
	@FXML
	private TextField qty11;
	@FXML
	private TextField qty12;
	@FXML
	private TextField qty13;
	@FXML
	private TextField qty14;
	@FXML
	private TextField qty15;
	@FXML
	private TextField qty16;
	@FXML
	private TextField qty17;
	@FXML
	private TextField qty18;
	@FXML
	private TextField COD_name;
	@FXML
	private TextField COD_ph;
	@FXML
	private TextField COD_address;
	@FXML
	private TextField onlinepayment_name;
	@FXML
	private TextField onlinepayment_cardNo;
	@FXML
	private TextField onlinepayment_expDate;
	@FXML
	private TextField onlinepayment_CVV;
	@FXML
	private Label orderSummary;
	@FXML
	private Label orderTotal;
	@FXML
	private Label devDate;
	@FXML
	private Label feedbacksuccessfull;
	@FXML
	private TextField complaint_box;
	@FXML
	private TextField complaint_orderID;	
	@FXML
	private Label complaintStatusLabel;
	@FXML
	private TextField cancel_orderID;
	@FXML
	private TextField cancel_reason;	
	@FXML
	private Label cancelStatusLabel;
	
	
	static WareHouse WareHouse_obj = new WareHouse();	
	
    String op ="";
    long number1;
    long number2;
    static String method;
    static String devD;
    
	@FXML
    Stage stage;
	@FXML
	Scene scene;
	@FXML
	Parent root;

	
	@FXML
	public void to_Login(ActionEvent ae) throws IOException {		
		Parent root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@FXML
	public void to_SignUp(ActionEvent ae) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("signup_screen.fxml"));
		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();

		/*
		 * will create account and then will take to home screen
		 */

	}
	
	@FXML
	public void to_homePage(ActionEvent ae) throws IOException {
		
		String user = login_page_username.getText();
		String pass = login_page_password.getText();		
				
		
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/onlinegrocery");
		Configuration con=new Configuration();
		
		con.configure().addAnnotatedClass(cust.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		//System.out.println("before");
		Query query = session.createQuery("select customer_username,customer_password from cust where username = '"+user+"'and pasword ='"+pass+"'");
//		System.out.println("after");
		
		//Query query1=session1.createQuery(" from Department e");
	
		List qryResults = query.getResultList();
		Iterator iter=qryResults.iterator();
		Object[] obj = null;
		while(iter.hasNext())
		{
		     obj=(Object[]) iter.next();
			
		}
		System.out.println(obj[0]);
		System.out.println(obj[1]);
		Object Pass=(Object) pass;
		Object User=(Object) user;
		if(obj[0].equals(User)&&obj[1].equals(Pass)) {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("home_screen.fxml"));
			ap.getChildren().setAll(pane);
		}
		else {
			System.out.println("dsds ");
			loginResult.setText("Login failed try again");
		}
		
	}

	@FXML
	public void backToHome(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("home_screen.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	@FXML
	public void addItemsToCart(ActionEvent e) throws IOException  {

		
		//JO SAB WAREHOUSE MAI JAA RAHE HAIN VO SAB SALELINEITEM KI LIST BANAIN GY MATLAB LIST MAI ADD HOTE JAIN GY JO KY WE WILL MAKE IN CONSTRUCTOR 
		//PHIT JAB CART KA BUTTON PRESS HOGA TO ILLL CREATE A NEW CART AND PASS THAT LIST TO IT
		//PHIR VO LIST SAY ITEM UNKI PRICE QUANTITY SAB DISPLAY HOJAI GA ORDER SUMMARY MAI
		
		
		String btn = ((Button)e.getSource()).getId();
		System.out.println("btn hai " + btn);

		int item_ID = 0;
		String itemqty = "";
		
		switch(btn) {			
		case "toCart1":
			item_ID = 1;
			itemqty = qty1.getText();
			break;
		case "toCart2":
			itemqty = qty2.getText();
			item_ID = 2;
			break;
		case "toCart3":
			itemqty = qty3.getText();
			item_ID = 3;
			break;
		case "toCart4":
			itemqty = qty4.getText();
			item_ID = 4;
			break;
		case "toCart5":
			itemqty = qty5.getText();
			item_ID = 5;
			break;
		case "toCart6":
			itemqty = qty6.getText();
			item_ID = 6;
			break;
		case "toCart7":
			itemqty = qty7.getText();
			item_ID = 7;
			break;
		case "toCart8":	
			itemqty = qty8.getText();
			item_ID = 8;
			break;
		case "toCart9":
			itemqty = qty9.getText();
			item_ID = 9;
			break;
		case "toCart10":
			itemqty = qty10.getText();
			item_ID = 10;
			break;
		case "toCart11":
			itemqty = qty11.getText();
			item_ID = 11;
			break;
		case "toCart12":
			itemqty = qty12.getText();
			item_ID = 12;
			break;
		case "toCart13":
			itemqty = qty13.getText();
			item_ID = 13;
			break;
		case "toCart14":
			itemqty = qty14.getText();
			item_ID = 14;
			break;
		case "toCart15":
			itemqty = qty15.getText();
			item_ID = 15;
			break;
		case "toCart16":
			itemqty = qty16.getText();
			item_ID = 16;
			break;
		case "toCart17":	
			itemqty = qty17.getText();
			item_ID = 17;
			break;
		case "toCart18":
			itemqty = qty18.getText();
			item_ID = 18;
			break;
		}

		int qty = Integer.parseInt(itemqty);
		WareHouse_obj.cartItems(item_ID, qty);		
		
	}
	
	@FXML
	public void to_orderSummary(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("orderSummary_screen.fxml"));
		ap.getChildren().setAll(pane);				
	}

	@FXML
	public void displaySummary(ActionEvent ae) throws IOException {
	
		WareHouse_obj.createNewCart();
//		System.out.println("main wala hun "+summary);
		String summary = WareHouse_obj.cartSummary();
		
		if(summary != null) {
			orderSummary.setText(summary);
		}else {
			orderSummary.setText("No items ordered!");
		}

		System.out.println("pagal ka bacha "+summary);
		//WareHouse_obj.displaySaleLineItems();

		String total = WareHouse_obj.cartTotal();
		if(total != null) {
			orderTotal.setText(total);
		}else {
			orderTotal.setText("Rs. 0");
		}
		orderTotal.setText(total);
		
	}
	@FXML
	public void to_payment(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("payment_screen.fxml"));
		ap.getChildren().setAll(pane);		
	}
	
	@FXML
	public void CashOnDelivery(ActionEvent ae) throws IOException {	
		
		method = ((Button)ae.getSource()).getId();
		System.out.println("btn hai " + method);

		WareHouse_obj.method(method);
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("CashOnDelivery_screen.fxml"));
		ap.getChildren().setAll(pane);				
	}

	@FXML
	public void OnlinePayment(ActionEvent ae) throws IOException {	
		
		method = ((Button)ae.getSource()).getId();
		System.out.println("btn hai " + method);
		
		WareHouse_obj.method(method);
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("OnlinePay_screen.fxml"));
		ap.getChildren().setAll(pane);		
	}

	@FXML
	public void Order_Complete(ActionEvent ae) throws IOException {

		System.out.println("complete order py  " + method);
		String det = "";
		if(method.equalsIgnoreCase("CashOnDelivery")) {

			System.out.println(" if ky andar hunn abb ");			
			
			String name = COD_name.getText();
			String ph = COD_ph.getText();		
			String add = COD_address.getText();

			det = det.concat(name);
			det = det.concat("!");
			det = det.concat(ph);
			det = det.concat("!");
			det = det.concat(add);
			det = det.concat("!");

			System.out.println("det hai: "+det);			

		}
		else if(method.equalsIgnoreCase("OnlinePayment")) {
			String name = onlinepayment_name.getText();
			String card = onlinepayment_cardNo.getText();		
			String cvv = onlinepayment_CVV.getText();
			String exp = onlinepayment_expDate.getText();
			
			det = det.concat(name);
			det = det.concat("!");
			det = det.concat(card);
			det = det.concat("!");
			det = det.concat(cvv);
			det = det.concat("!");
			det = det.concat(exp);
			det = det.concat("!");

			System.out.println("det hai: "+det);			
		}
		
//		WareHouse_obj.paymentInfo(det);
		devD = WareHouse_obj.newOrder(det);	
		System.out.println("devD hai: "+devD);
		
//		devDate.setText(devD);
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("orderComplete.fxml"));
		ap.getChildren().setAll(pane);			
	}
	@FXML
	public void showDeliveryDate(ActionEvent ae) throws IOException {
		if(devD != null) {
			devDate.setText(devD);
		}else {
			devDate.setText("No date assigned yet!");
		}
	}
	
	@FXML
	public void to_manageProfile(ActionEvent ae) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("manageProfile_screen.fxml"));
		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void to_feedback(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("feedback_screen.fxml"));
		ap.getChildren().setAll(pane);			

	}

	@FXML
	public void GetFeedback(ActionEvent ae) throws IOException {
		String btn = ((Button)ae.getSource()).getId();
		
		if(btn.equalsIgnoreCase("Confirm")) {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("home_screen.fxml"));
			ap.getChildren().setAll(pane);					
		} 
		else {
			System.out.println("feedback loo " + btn);
			boolean flag = WareHouse_obj.recordFeedback(btn);
			if(flag==true) {
				feedbacksuccessfull.setText("Feedback recorded successfully!");
			}
			else {
				feedbacksuccessfull.setText("Error occured! Try again later.");	
			}
		}
	
	}	
	
	@FXML
	public void to_fileComplaint(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("fileComplaint_screen.fxml"));
		ap.getChildren().setAll(pane);					
	}

	@FXML
	public void GetComplaint(ActionEvent ae) throws IOException {
//		String btn = ((Button)ae.getSource()).getId();

		String complaint_OID = complaint_orderID.getText();
		String complaint_desc = complaint_box.getText();
	
		int O_ID = Integer.parseInt(complaint_OID);
		
		boolean flag = WareHouse_obj.recordComplaint(O_ID, complaint_desc);
		if(flag==true) {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("home_screen.fxml"));
			ap.getChildren().setAll(pane);					
		}
		else {
			complaintStatusLabel.setText("Order ID not found :(");	
		}
		
	}	

	
	@FXML
	public void to_cancelOrder(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("cancelOrder_screen.fxml"));
		ap.getChildren().setAll(pane);					
	}

	@FXML
	public void confirmCancelOrder(ActionEvent ae) throws IOException {

		String cancel_OID = cancel_orderID.getText();
		String cancel_desc = cancel_reason.getText();
	
		int O_ID = Integer.parseInt(cancel_OID);
		
		boolean flag = WareHouse_obj.cancelRequest(O_ID, cancel_desc);
		if(flag==true) {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("home_screen.fxml"));
			ap.getChildren().setAll(pane);					
		}
		else {
			complaintStatusLabel.setText("Order ID doesnt exist :(");	
			AnchorPane pane=FXMLLoader.load(getClass().getResource("cancelOrder_screen.fxml"));
			ap.getChildren().setAll(pane);					
		}
		
	}	

	@FXML
	public void to_managerLogin(ActionEvent ae) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("ManagerLogin_screen.fxml"));
		ap.getChildren().setAll(pane);					
	}

	
	
}
