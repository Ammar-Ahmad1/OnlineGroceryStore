package businessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import DataStoringLayer.DataStoring;

public class Order {

	int order_ID;
	String order_Date;
	String delivery_Date;
	String summary;
	Singleton_Cart C;
	DataStoring DS;
	
	public Order(int cust_ID, Singleton_Cart cart, DataStoring dataStore) {
	
		C = cart;
		DS = dataStore;
		
		System.out.println("new order jo create hua uski details yeh hain");
		System.out.println("summary "+cart.Cart_summary);
		System.out.println("total "+cart.cartTotal);
		System.out.println("details "+cart.payment.getDetails());	

		System.out.println("   order date hai     ");
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		order_Date = df.format(calobj.getTime());
		System.out.println(order_Date);
		
		
		System.out.println("          delivery date hai     ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 5); // Adding 5 days
		
		delivery_Date = sdf.format(c.getTime());
		System.out.println(delivery_Date);
	
		DS.storingOrderInformation(cust_ID, order_Date, delivery_Date, C.Cart_summary, C.cartTotal, C.payment.getDetails());
	}
		
	
	public void display() {
		System.out.println("     order ka display hai     ");	
		System.out.println(order_Date);
		System.out.println(delivery_Date);
		System.out.println(C.Cart_summary);
		System.out.println(C.cartTotal);
		System.out.println(C.payment.getDetails());
	}
	
}
