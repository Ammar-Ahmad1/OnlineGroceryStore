package businessLogic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust")
public class cust {
	@Id
	@Column(name="id")
	int customer_ID;
	@Column(name="username")
	String customer_username;
	@Column(name="address")
	String customer_address;
	@Column(name="email")
	String customer_mail;
	@Column(name="phoneNo")
	String customer_phNo;
	@Column(name="pasword")
	String customer_password;
	public cust() {
		customer_ID=0;
		customer_username="";
		customer_address="";
		customer_mail="";
		customer_phNo="";
		customer_password="";
	}
	
	public cust(int i,String us,String pas,String em,String add,String phn){
		customer_ID=i;
		customer_username=us;
		customer_address=add;
		customer_mail=em;
		customer_phNo=phn;
		customer_password=pas;
		
		
	}
	@Override
	public String toString() {
		return "Customer [customer_ID=" + customer_ID + ", customer_username=" + customer_username
				+ ", customer_address=" + customer_address + ", customer_mail=" + customer_mail + ", customer_phNo="
				+ customer_phNo + ", customer_password=" + customer_password + "]";
	}
}
