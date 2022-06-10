package businessLogic;

public class cashOnDelivery implements Payment{

	String delivery_Date;
	String Deliver_address;
	public String details;
	
	public cashOnDelivery() {
		System.out.println("COD ka obj bana dia");	
	}
	
	@Override
	public void paymentDetails(String det) {
		details = det;
		System.out.println("COD pay mai hun " +details);
		
	}
	@Override
	public String[] getDetails() {
		String[] arr = details.split("!");    
		return arr;
	}
}
