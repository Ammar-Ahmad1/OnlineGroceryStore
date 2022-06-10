package businessLogic;

public class E_manager {

	int manager_ID;
	String manager_username;
	String manager_password;
	String manager_mail;
	String manager_address;
	String manager_phNo;
	
	private static E_manager manager_instance = null;
	
	private E_manager() {
		System.out.println("Singleton manager");
	}

	public static E_manager getManagerInstance() {
        if (manager_instance == null) {
        	manager_instance = new E_manager();
        	System.out.println("naya manager object bana dia");
        }
        else
        	System.out.println("naya manager object nahi bana");
        return manager_instance;
    }

	
	public void setManagerID(int id) {
		manager_ID = id;
	}
	public int getManagerID() {
		return manager_ID;
	}
	public void setManagerUsername(String user) {
		manager_username = user;
	}
	public String getManagerUserName() {
		return manager_username;
	}
	public void setManagerEmail(String mail) {
		manager_mail = mail;
	}
	public String getManagerEmail() {
		return manager_mail;
	}
	public void setManagerPhoneNo(String ph) {
		manager_phNo = ph;
	}
	public String getManagerPhNo() {
		return manager_phNo;
	}
	public void setManagerPassword(String pass) {
		manager_password = pass;
	}
	public String getManagerPassword() {
		return manager_password;
	}
	public void setManagerAddress(String add) {
		manager_address = add;
	}
	public String getManagerAddress() {
		return manager_address;
	}
	
	public void AddItemsInInventory(int ID, String name, int qty, int price) {

	}

}
