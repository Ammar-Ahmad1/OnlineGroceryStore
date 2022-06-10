package businessLogic;

public class FeedBack {

	int FeedBack_ID;
	String Feedback_description=null;
	
	public void setFeedback(String f) {
		System.out.println("setting feedback in class");
		Feedback_description = f;	
	}
	public String getFeedback() {
		return Feedback_description;	
	}
}
