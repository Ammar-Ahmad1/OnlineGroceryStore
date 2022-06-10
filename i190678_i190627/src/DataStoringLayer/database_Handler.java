package DataStoringLayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class database_Handler {

	//Code for JDBC Storing Data to the DataBase.
	/*
	public boolean loginCheck(String name, String pass) throws ClassNotFoundException, SQLException {
		boolean temp = false;
		Vector<String> vec = new Vector<String>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Successfull!");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","root","Mazda2001#");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from login_info");
		while(rs.next()) {
			vec.add(rs.getString(1));
			vec.add(rs.getString(2));
		}
		con.close();
		
		for(int i=0;i<vec.size();) {
			if(name.equals(vec.get(i)) && pass.equals(vec.get(i+1))) {
				temp = true;
			}
			i += 2;
		}
		return temp;
	}

	public void insertFeedback(int C_id, String fb) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Successfull!");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","root","Mazda2001#");
		String sql = "INSERT INTO feedback (C_id, fb) VALUES(?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
        st.setInt(1, C_id); 
		st.setString(2, fb);
		int rowsInserted = st.executeUpdate();
		if(rowsInserted>0) {
			System.out.println("-------------------------");
			}
	}
[11:06 pm, 25/12/2021] Zakee Qureshi: public boolean setFeedback(int C_id, String fb) {
	System.out.println("ID: "+C_id + fb);
		database_Handler d = new database_Handler();
		try {
			d.insertFeedback(C_id,fb);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
	}	
	*/	
	
	public boolean login_verifier(String user, String pass) throws IOException {
		Boolean flag = false;
		String line, id, username, password;
		BufferedReader br = new BufferedReader(new FileReader("src/DataStoringLayer/loginInfo.txt"));
		while( (line = br.readLine() )!= null) {
			String[] arr = line.split(" ");    
			if(arr[1].equals(user) && arr[2].equals(pass)) {
				id = arr[0];
				username = arr[1];
				password = arr[2];
				flag = true;
				break;
			}			
		}	
		return flag;
	}

	
	public String[] getItem(int ID, int q) throws IOException {

		String line, id, name, price;
		id = Integer.toString(ID);
		BufferedReader br = new BufferedReader(new FileReader("src/DataStoringLayer/items.txt"));
		while( (line = br.readLine() )!= null) {
			String[] arr = line.split(" ");    
	
			if(arr[0].equals(id)) {
				name = arr[1];
				price = arr[2];
				int qtyInInventory = Integer.parseInt(arr[3]);
				if(q <= qtyInInventory)
					return arr; //TOTAL MAI SAY q MINUS KARDENA
				else {
					
				}
			}			
		}	

		String[] b = null;
		return b;
	}

	

}
