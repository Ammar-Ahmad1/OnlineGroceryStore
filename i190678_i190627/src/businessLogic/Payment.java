package businessLogic;

public interface Payment {
	public int payment_ID = 0;
	public String payment_Date = null;
	public String details = "";
	long amount = 0;
	boolean status = false;
	
	void paymentDetails(String details);

	String[] getDetails();
	
}
