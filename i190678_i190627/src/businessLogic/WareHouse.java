package businessLogic;

import java.io.IOException;

import DataStoringLayer.DataStoring;
import DataStoringLayer.DataStoringFactory;

public class WareHouse {

//	database_Handler dbobj = new database_Handler();
	DataStoringFactory p = new DataStoringFactory();
	DataStoring DataStore = DataStoringFactory.getDataStoringMethod("File Storing");
		
	SaleLineItems[] SLI = new SaleLineItems[18];
	static int i = 0;
	//Cart cart_obj;
//	Singleton_Cart cart_obj;
	Customer cust_obj;
	E_manager mgr_obj;
	
	public WareHouse() {
		System.out.println("default constructor hun mai");	
	}
	
	//PASSES USERNAME AND PASSWORD TO DATABASE LAYER TO VERIFY DETAILS
	public boolean loginVerifier(String user, String pass) throws IOException {
		
		boolean flag = DataStore.login_verifier(user, pass);
		
		if(flag == true) {
			cust_obj = Customer.getCustomerInstance();
		}
		return flag;
		
	}
	
	//WILL ADD THE ITEMS IN SALELINE ITEMS LIST AND EVENTUALLY WILL PASS THE LIST TO CART WHEN CONFIRMED
/*	public void cartItems(String itemname, String itemqty, String itemprice) {

		System.out.println("warehouse mai aagya hun");
		System.out.println(itemname);
		System.out.println(itemqty);
		System.out.println(itemprice);
	}
*/
	public void cartItems(int item_ID, int qty) throws IOException {

		String[] a = DataStore.getItem(item_ID,qty);

		try {
			int id = Integer.parseInt(a[0]);
			int price = Integer.parseInt(a[2]);		
		
			System.out.println("parse hogya hai");
			
			SLI[i] = new SaleLineItems(id, a[1], price,qty);	
			System.out.println("set hogai values sale line item mai");
			i++;
		}catch (NumberFormatException e){
		      System.out.println("An error occurred");	
		}
	}
	
	public void displaySaleLineItems() {

		for(int j=0; SLI[j]!=null; j++ ) {
			SLI[j].displaySLI();
		}
	}

	
	public void createNewCart() {
		//cart_obj = new Cart(SLI);
		cust_obj.CreateNewCart(SLI);
//		cart_obj = Singleton_Cart.getInstance(SLI);
//		Singleton_Cart obj2 = Singleton_Cart.getInstance(SLI);
	}

	public String cartSummary() {

		String s = cust_obj.cart_obj.generateCartSummary();
	//	String s = cart_obj.generateCartSummary();		
		System.out.println("warehouse ka hun "+s);
		
		return s;
		
	}

	public String cartTotal() {
		int t = cust_obj.cart_obj.generateCartTotal();		
		System.out.println("warehouse mai total "+t);
		String s =  Integer.toString(t);
		s = "Rs. ".concat(s);
		return s;		
	}
	
	public void method(String m) {
		System.out.println("warehouse method mai hun ");		
		cust_obj.cart_obj.CartPaymentMethod(m);
	}
	
	
	public String newOrder(String det) {
		cust_obj.cart_obj.payment.paymentDetails(det);
//		System.out.println("mai yahan hun 1 "+	cust_obj.cart_obj.payment.getDetails());

//		System.out.println("mai yahan hun 2 "+	cust_obj.getCustomerID());
	//	System.out.println("mai yahan hun 3 "+	cust_obj.customer_username);
//		System.out.println("mai yahan hun 4 "+	cust_obj.getCustomerPassword());
//		System.out.println("mai yahan hun 5 "+	cust_obj.getCustomerEmail());
//		System.out.println("mai yahan hun 6 "+	cust_obj.getCustomerAddress());
		
		cust_obj.CreateNewOrder(cust_obj.cart_obj, DataStore);

		return cust_obj.cust_order.delivery_Date;
	}

	public boolean recordFeedback(String fb) {
		System.out.println(" warehouse ka record feedback ");
		cust_obj.RecordFeedback(fb);
		System.out.println("cust record feedback hogya ");
	
		boolean flag = DataStore.setFeedback(cust_obj.getCustomerID(), fb);
	
		return flag;
	}

	public boolean recordComplaint(int OrderID, String fb) {
	
		boolean flag = DataStore.fileComplaint(OrderID, fb);
		if(flag==true) {
			cust_obj.Comp.setcomplaint(fb);
		}
		return flag;
	}

	public boolean cancelRequest(int OrderID, String fb) {
		
		boolean flag = DataStore.cancelOrder(OrderID, fb);
		return flag;
	}
	
	public boolean manager_loginVerifier(String user, String pass) {
		boolean flag = DataStore.manager_login_verifier(user, pass);
		
		if(flag == true) {
			mgr_obj = E_manager.getManagerInstance();
		}
		return flag;
	}
	
	public String findFeedBack( int O_ID) {
		String flag = DataStore.getFeedBack(O_ID);
		return flag;	
	}
	
	public String[] CustomerDetails(int C_ID) {
		String[] flag = DataStore.customer_details(C_ID);
//		if(flag==true)
//			cust_obj = Customer.getCustomerInstance();
		return flag;		
	}
	
	public String[] getComplaints() {
		String[] flag = DataStore.complaints();		
		return flag;
	}
	
	public void additems_manager(int ID, String name, int qty, int price) {
		boolean flag=false;
		flag=DataStore.checkItemExistance(ID);
		if(flag==true) {
			DataStore.updateItemQuantity(ID, qty);
		}
		else {
			Item itm=new Item();
			itm.setID(ID);
			itm.setname(name);
			itm.setprice(price);
			itm.setqty(qty);
			DataStore.addNewItem(itm);
		}
	}
	
}
