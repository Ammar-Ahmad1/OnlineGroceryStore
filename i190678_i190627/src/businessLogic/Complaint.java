package businessLogic;

public class Complaint {

	int Complaint_ID;
	String complaint_description;
	
	public void setcomplaint(String c) {
		complaint_description = c;
	}
	public String getcomplaint() {
		return complaint_description;
	}

}
