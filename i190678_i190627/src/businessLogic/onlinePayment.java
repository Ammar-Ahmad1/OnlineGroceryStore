package businessLogic;

public class onlinePayment implements Payment{

	String cardNo;
	public String details;
	int CVV_code;
	
	public onlinePayment() {
		System.out.println("online pay ka obj bana dia");	
	}

	@Override
	public void paymentDetails(String det) {
		details = det;
		System.out.println("online pay mai hun" +details);
		
	}

	@Override
	public String[] getDetails() {
		String[] arr = details.split("!");    
		return arr;
	}

}
