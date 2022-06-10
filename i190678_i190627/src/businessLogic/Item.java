package businessLogic;

public class Item {

	int Item_ID;
	String Item_name;
	int Item_price;
	int quantity;
	
	public void setID(int ID) {
		Item_ID=ID;
	}
	public int getID() {
		return Item_ID;
	}
	public void setname(String n) {
		Item_name=n;
	}
	public String getname() {
		return Item_name;
	}
	public void setqty(int qty) {
		quantity=qty;
	}
	public int getqty() {
		return quantity;
	}
	public void setprice(int p) {
		Item_price=p;
	}
	public int getprice() {
		return Item_price;
	}
}
