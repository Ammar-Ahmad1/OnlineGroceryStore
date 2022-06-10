package businessLogic;

public class SaleLineItems {

	String name;
	int qty;
	int price;
	int id;


	public SaleLineItems(SaleLineItems s) {
		id = s.id;
		name = s.name;
		price = s.price;
		qty = s.qty;		
	}
	public SaleLineItems(int i, String n, int p, int q) {
		id = i;
		name = n;
		price = p;
		qty = q;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setqty(int q) {
		qty = q;
	}
	public int getqty() {
		return qty;
	}
	public void setprice(int p) {
		price = p;
	}
	public int getprice() {
		return price;
	}
	public void setid(int i) {
		id = i;
	}
	public int getid() {
		return id;
	}
	public void displaySLI() {
		System.out.println("Sale line items hain hum");
		System.out.println(id);
		System.out.println(name);
		System.out.println(qty);
		System.out.println(price);
	}
	
}
