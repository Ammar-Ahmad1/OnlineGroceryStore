package businessLogic;

public class PaymentFactory {
	   
	public static Payment getPaymentMethod(String method) {
		System.out.println("method ki value hai "+method);
		if(method == null){
			return null;
		}		
		if(method.equalsIgnoreCase("CashOnDelivery")){
			System.out.println("COD ka obj bana raha hun");
			return new cashOnDelivery();         
		} 
		else if(method.equalsIgnoreCase("onlinePayment")) {
			return new onlinePayment();     
		}
		System.out.println("kuch nahi hai");
		return null;
	}
	
}
