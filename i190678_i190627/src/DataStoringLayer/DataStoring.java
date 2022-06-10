package DataStoringLayer;

import businessLogic.Item;

public interface DataStoring {

	public boolean login_verifier(String user, String pass);
	public String[] getItem(int ID, int q);
	public void storingOrderInformation(int C_ID, String OD, String DD, String S, int T, String[] paymentDetails);
	public boolean setFeedback(int C_id, String fb);
	public boolean fileComplaint(int O_ID, String Comp);
	public boolean cancelOrder(int orderID, String reason);
	public boolean manager_login_verifier(String user, String pass);
	public String getFeedBack(int O_ID);
	public String[] customer_details(int C_ID);
	public String[] complaints();
	public boolean checkItemExistance(int ID);
	public void addNewItem(Item itm);
	public void updateItemQuantity(int ID, int qty);
	
}
