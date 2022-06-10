package application;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import businessLogic.Customer;
import businessLogic.cust;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class sign_up implements Initializable{
	@FXML TextField t1;
	@FXML TextField t2;
	@FXML TextField t3;
	@FXML TextField t4;
	@FXML TextField t5;
	
	@FXML
    Stage stage;
	@FXML
	Scene scene;
	@FXML
	Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub		
	}
	@FXML
	public void to_Login(ActionEvent ae) throws IOException {		
		Parent root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	@FXML
	public void InfoGetter(ActionEvent e) throws IOException
	{

					Properties properties = new Properties();
					properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
					properties.setProperty(Environment.HBM2DDL_AUTO,"update");
					properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
					properties.setProperty(Environment.USER, "root");
					properties.setProperty(Environment.PASS, "");
					properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/onlinegrocery");
					
					Configuration cfg= new Configuration();
					cfg.setProperties(properties);
					cfg.addAnnotatedClass(cust.class);
					SessionFactory factory=cfg.buildSessionFactory();
					Session session= factory.openSession();
					
					try {
						Transaction tr=session.beginTransaction();

						cust s=new cust(0,t1.getText(),t2.getText(),t3.getText(),t5.getText(),t4.getText());
						//System.out.print(s.toString());
						session.persist(s);
						
						System.out.println("saved");
						
						tr.commit();
									
					}catch(Exception e1){
						e1.printStackTrace();
					}finally {

						//showAlert(Alert.AlertType.CONFIRMATION, (((Node) e.getSource()).getScene().getWindow()), "Info!", "Info Saved");
						factory.close();
						session.close();
					}
	}
				
//				else
//				{
//					showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
//					
//					
//				}
//			
//			else
//			{
//				showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
//				
//				
//			}
//		
//		else
//		{
//			showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
//			
//			
//		}
//	
	
//	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//    }

}
