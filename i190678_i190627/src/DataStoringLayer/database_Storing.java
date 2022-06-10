package DataStoringLayer;

import businessLogic.Item;

public class database_Storing implements DataStoring {

	public boolean login_verifier(String user, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getItem(int ID, int q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storingOrderInformation(int C_ID, String OD, String DD, String S, int T, String[] paymentDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setFeedback(int C_id, String fb) {
		return false;
		// TODO Auto-generated method stub
	//JDBC Code for Setting Feedback to MySQL
		/*
		System.out.println("ID: "+C_id + fb);
		database_Handler d = new database_Handler();
		try {
			d.insertFeedback(C_id,fb);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		*/
	}

	@Override
	public boolean fileComplaint(int O_ID, String Comp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelOrder(int orderID, String reason) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean manager_login_verifier(String user, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFeedBack(int O_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] customer_details(int C_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] complaints() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkItemExistance(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addNewItem(Item itm) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateItemQuantity(int ID, int qty) {
		// TODO Auto-generated method stub
		
	}

}
