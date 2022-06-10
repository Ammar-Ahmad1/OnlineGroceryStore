package businessLogic;

import javax.persistence.*;
import DataStoringLayer.DataStoring;
public class Customer {
	int customer_ID;
	String customer_username;
	String customer_address;
	String customer_mail;
	String customer_phNo;
	String customer_password;
	Order cust_order;
	Singleton_Cart cart_obj;
	FeedBack f1=new FeedBack();
	Complaint Comp=new Complaint();

	private static Customer customer_instance = null;

	@Override
	public String toString() {
		return "Customer [customer_ID=" + customer_ID + ", customer_username=" + customer_username
				+ ", customer_address=" + customer_address + ", customer_mail=" + customer_mail + ", customer_phNo="
				+ customer_phNo + ", customer_password=" + customer_password + "]";
	}
	private Customer() {
		System.out.println("Singleton customer");
	}

	public static Customer getCustomerInstance() {
        if (customer_instance == null) {
        	customer_instance = new Customer();
        	System.out.println("naya customer object bana dia");
        }
        else
        	System.out.println("naya customer object nahi bana");
        return customer_instance;
    }

	
	public void setCustomerID(int id) {
		customer_ID = id;
	}
	public int getCustomerID() {
		return customer_ID;
	}
	public void setCustomerUsername(String user) {
		customer_username = user;
	}
	public String getCustomerUserName() {
		return customer_username;
	}
	public void setCustomerEmail(String mail) {
		customer_mail = mail;
	}
	public String getCustomerEmail() {
		return customer_mail;
	}
	public void setCustomerPhoneNo(String ph) {
		customer_phNo = ph;
	}
	public String getCustomerPhNo() {
		return customer_phNo;
	}
	public void setCustomerPassword(String pass) {
		customer_password = pass;
	}
	public String getCustomerPassword() {
		return customer_password;
	}
	public void setCustomerAddress(String add) {
		customer_address = add;
	}
	public String getCustomerAddress() {
		return customer_address;
	}

	public void CreateNewCart(SaleLineItems[] SLI) {
		cart_obj = Singleton_Cart.getInstance(SLI);	
	
	}

	public void CreateNewOrder(Singleton_Cart cart_obj, DataStoring DataStore) {
		cust_order = new Order(customer_ID, cart_obj, DataStore);
		System.out.println(cust_order.delivery_Date);
	}
	
	public void RecordFeedback(String fd) {
		System.out.println("customer class record feedback mai hun abb "+fd);
		f1.setFeedback(fd);
		String s= f1.getFeedback();
		System.out.println("set hogya customer class say "+s);
	}
}
