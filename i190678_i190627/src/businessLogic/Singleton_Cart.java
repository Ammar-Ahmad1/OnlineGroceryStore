package businessLogic;

public class Singleton_Cart {

	
	
	
	//item type list to store items in cart
	int cartTotal;
	int cartID;
	String Cart_summary;
	PaymentFactory p = new PaymentFactory();
	Payment payment;
	
	
	SaleLineItems[] SLI_obj = new SaleLineItems[18];

	
	
	
	private static Singleton_Cart cart_instance = null;
	
	private Singleton_Cart() {
		System.out.println("Singleton cart");
	}

	public static Singleton_Cart getInstance(SaleLineItems[] SLI) {
        if (cart_instance == null) {
            cart_instance = new Singleton_Cart(SLI);
        	System.out.println("naya object bana");
        }
        else
        	System.out.println("naya object nahi bana");
        return cart_instance;
    }

	
	private Singleton_Cart(SaleLineItems[] SLI) {
		System.out.println("cart bana di mainay");

		cartTotal = 0;
		cartID = 0;

		System.out.println("MAI PAGAL HUN");
		for(int j=0; SLI[j]!=null; j++ ) {
			SLI[j].displaySLI();
		}
		
		for(int j=0; SLI[j]!=null; j++ ) {
//			SLI_obj[j].setid(SLI[j].getid());
//			SLI_obj[j].setName(SLI[j].getName());
//			SLI_obj[j].setprice(SLI[j].getprice());
//			SLI_obj[j].setqty(SLI[j].getqty());

			
			SLI_obj[j] = new SaleLineItems(SLI[j]);
		}

		System.out.println("MAI PAGAL HUN PART TWO");
		for(int j=0; SLI_obj[j]!=null; j++ ) {
			SLI_obj[j].displaySLI();
		}

		System.out.println("cart constructor theek hai");		
	}
	
	public String generateCartSummary() {
		Cart_summary = "";
		String s1;

		System.out.println("generate summary mai agya hun");		
		
		System.out.println("pagal aik aur "+SLI_obj.length);
		
		
		System.out.println("MAI KAM PAGAL ABB");
		for(int j=0; SLI_obj[j]!=null; j++ ) {
			SLI_obj[j].displaySLI();
		}

		
		for(int j=0; SLI_obj[j]!=null; j++ ) {
			s1 = Integer.toString(SLI_obj[j].getid()) + " " + SLI_obj[j].getName() + " " + SLI_obj[j].getqty() + " " + SLI_obj[j].getprice() + '\n';
			Cart_summary = Cart_summary.concat(s1);
		}
		System.out.println("summary hai " + Cart_summary);
		return Cart_summary;
	}
	
	
	public int generateCartTotal() {
		int q, p;
		for(int j=0; SLI_obj[j]!=null; j++ ) {
			cartTotal += SLI_obj[j].getqty() * SLI_obj[j].getprice();
		}				
		System.out.println("total yeh hai"+cartTotal);
		return cartTotal;
	}

	public void CartPaymentMethod(String m) {
		System.out.println("cart method mai hun ");
		System.out.println(" m ki value hai "+m);
		payment = PaymentFactory.getPaymentMethod(m);
		
		System.out.println("method pass kardia ");
	}
	
//	public void printpaymentDetails() {
//		System.out.println("details hain caart mai "+payment.getDetails());
//	}
	
	public void discardCart() {
		
	}

	
	
}
