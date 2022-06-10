package DataStoringLayer;

public class DataStoringFactory {

	
	
	private static DataStoringFactory data_instance = null;
	
	public DataStoringFactory() {
		System.out.println("Singleton cart");
	}

 	public static DataStoringFactory getDataStoringInstance() {
        if (data_instance == null) {
            data_instance = new DataStoringFactory();
        	System.out.println("naya object bana dia data storing ka");
        }
        else
        	System.out.println("naya object nahi bana");
        return data_instance;
    }
	
	
	public static DataStoring getDataStoringMethod(String meth) {
		System.out.println("data method ki value hai "+meth);
		if(meth == null){
			return null;
		}		
		if(meth.equalsIgnoreCase("File Storing")){
			System.out.println("files ka object bana do");
			return new File_Storing();         
		} 
		else if(meth.equalsIgnoreCase("DataBase Storing")) {
			return new database_Storing();     
		}
		System.out.println("kuch nahi hai storing mai");
		return null;
	}

	
}
