package DataStoringLayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import businessLogic.Customer;
import businessLogic.E_manager;
import businessLogic.Item;
import businessLogic.Singleton_Cart;

public class File_Storing implements DataStoring {

	public boolean login_verifier(String user, String pass) {
		Boolean flag = false;
		String line, id, username, password;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/loginInfo.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while( (line = br.readLine() )!= null) {
				String[] arr = line.split(" ");    
				if(arr[1].equals(user) && arr[2].equals(pass)) {
					//id = arr[0];
					//username = arr[1];
					//password = arr[2];
					flag = true;
					Customer cust_obj = Customer.getCustomerInstance();
					cust_obj.setCustomerID(Integer.parseInt(arr[0]));
					cust_obj.setCustomerUsername(arr[1]);
					cust_obj.setCustomerPassword(arr[2]);
					cust_obj.setCustomerEmail(arr[3]);
					cust_obj.setCustomerPhoneNo(arr[4]);
					cust_obj.setCustomerAddress(arr[5]);
				
					break;
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return flag;
	}

	
	public String[] getItem(int ID, int q) {

		String line, id, name, price;
		id = Integer.toString(ID);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/items.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		String[] b = null;
		return b;
	}


	@Override
	public void storingOrderInformation(int C_ID, String OD, String DD, String S, int T, String[] paymentDetails) {
	/*     try{    
	           FileWriter FW = new FileWriter("src/DataStoringLayer/orderInformation.txt");    
	           FW.write(OD);
	           FW.write(" ");
	           FW.write(DD);
	           FW.write(" ");
	           FW.write(S);
	           FW.write(" ");
	           FW.write(Integer.toString(T));
	           FW.write(" ");
	           for(int g=0; paymentDetails!=null; g++) {
	        	   FW.write(paymentDetails[g]);
	        	   FW.write(" ");
	           }
	           FW.write("\n");
	           FW.close();
	           
	        } catch(Exception e) {
	        	System.out.println(e);
	        	}    
	          System.out.println("Success...");       		
	
	*/
        try {
        	 
            // Again operating same operations by passing
            // file as
            // parameter to read it
            BufferedWriter out = new BufferedWriter(
                new FileWriter("src/DataStoringLayer/orderInformation.txt"));
 
            // Writing on. file
            out.write("Order_ID: "+C_ID+11+"\n");
           
            
	           out.write("Customer ID: "+C_ID);
	           out.write("\n");
	           out.write("Order Date: "+OD);
	           out.write("\n");
	           out.write("Delivery Date: "+DD);
	           out.write("\n");
	           out.write("Summary: "+S);
	           //out.write(" ");
	           out.write("Total: "+Integer.toString(T));
	           out.write("\nPayment details: ");
	           for(int g=0; g<paymentDetails.length; g++) {
	        	   out.write(paymentDetails[g]);
	        	   out.write(" ");
	           }
	           out.write("\n\n");

            // Closing file connections
            out.close();
        }
 
        // Catch block to handle exceptions
        catch (IOException e) {
 
            // Display message when error occurs
            System.out.println("Exception Occurred" + e);
        }
	
	
	
	}


	@Override
	public boolean setFeedback(int C_id, String fb) {

		boolean flag = false;

        BufferedWriter out;
		try {
			out = new BufferedWriter(
			        new FileWriter("src/DataStoringLayer/feedback.txt"));

			out.write("Customer_ID: "+C_id+"\n"+"Feedback: "+fb+"\n");           
	        out.close();
	        flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return flag;
	}


	@Override
	public boolean fileComplaint(int O_ID, String Comp) {

		Boolean flag = false;
		String line;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/orderInformation.txt"));
			while( (line = br.readLine() )!= null) {
				String[] arr = line.split(" ");    
				if(arr[1].equalsIgnoreCase(Integer.toString(O_ID))) {
					
		            BufferedWriter out = new BufferedWriter(
		                    new FileWriter("src/DataStoringLayer/complaints.txt"));
		     			   
		            out.write("Complaint_ID: "+O_ID+23+"\n");
		            out.write("Order_ID: "+O_ID+"\n");
		            out.write("Complaint: "+Comp);
		    	    out.write("\n");
			        out.close();

			        flag = true;
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return flag;
	}


	@Override
	public boolean cancelOrder(int orderID, String reason) {
		Boolean flag = false;
		String line;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/orderInformation.txt"));
			while( (line = br.readLine() )!= null) {
				String[] arr = line.split(" ");    
				if(arr[1].equalsIgnoreCase(Integer.toString(orderID))) {
					
					
					System.out.println("ID mil gai to cancel "+arr[1]);
					///delete line wali implementation karni hai yahan pay
					
					
			        flag = true;
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return flag;

	}


	@Override
	public boolean manager_login_verifier(String user, String pass) {
		Boolean flag = false;
		String line, id, username, password;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/manager_login.txt"));
			while( (line = br.readLine() )!= null) {
				String[] arr = line.split(" ");    
				if(arr[1].equals(user) && arr[2].equals(pass)) {
					
					flag = true;
					E_manager mgr_obj = E_manager.getManagerInstance();
					mgr_obj.setManagerID(Integer.parseInt(arr[0]));
					mgr_obj.setManagerUsername(arr[1]);
					mgr_obj.setManagerPassword(arr[2]);
					mgr_obj.setManagerEmail(arr[3]);
					mgr_obj.setManagerPhoneNo(arr[4]);
					mgr_obj.setManagerAddress(arr[5]);
				
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return flag;
	}


	@Override
	public String getFeedBack(int O_ID) {
		String flag = "No feedback";
		String line;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/feedback.txt"));
			while( (line = br.readLine() )!= null) {
				String[] arr = line.split(" ");    
				if(arr[1].equalsIgnoreCase(Integer.toString(O_ID))) {
					
					line = br.readLine();
					String[] arr2 = line.split(" ");
										
			        flag = arr2[1];
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return flag;

	}


	@Override
	public String[] customer_details(int C_ID) {
		boolean flag = false;
		String line;
		String[] arr = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/loginInfo.txt"));
			while( (line = br.readLine() )!= null) {
				arr = line.split(" ");    
				if(arr[0].equalsIgnoreCase(Integer.toString(C_ID))) {
					
					Customer cust_obj = Customer.getCustomerInstance();
					cust_obj.setCustomerID(Integer.parseInt(arr[0]));
					cust_obj.setCustomerUsername(arr[1]);
					cust_obj.setCustomerPassword(arr[2]);
					cust_obj.setCustomerEmail(arr[3]);
					cust_obj.setCustomerPhoneNo(arr[4]);
					cust_obj.setCustomerAddress(arr[5]);
										
			        flag = true;
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return arr;
	}


	@Override
	public String[] complaints() {
		String line;
		String[] arr = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/complaints.txt"));
			while( (line = br.readLine() )!= null) {
				arr = line.split(" ");    
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return arr;
		
	}


	@Override
	public boolean checkItemExistance(int ID) {
		boolean flag = false;
		String line;
		String[] arr = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/items.txt"));
			while( (line = br.readLine() )!= null) {
				arr = line.split(" ");    
				if(arr[0].equalsIgnoreCase(Integer.toString(ID))) {
					flag = true;
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return flag;
	}


	@Override
	public void addNewItem(Item itm) {

		String line;
		BufferedReader br = null;
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/DataStoringLayer/items.txt"));
			while( (line = br.readLine() )!= null) {
		    }			
            out.write(itm.getID()+" "+itm.getname()+" "+itm.getprice()+" "+itm.getqty()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public void updateItemQuantity(int ID, int qty) {
		String line;
		String[] arr = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/DataStoringLayer/items.txt"));
			while( (line = br.readLine() )!= null) {
				arr = line.split(" ");    
				if(arr[0].equalsIgnoreCase(Integer.toString(ID))) {
					
					//UPDATE QUANTITY
					
					break;
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

	
}









