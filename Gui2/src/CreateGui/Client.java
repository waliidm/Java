package CreateGui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Client {

	protected String username;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected String sexe;
	
	public static ArrayList<String> ListerClient() {
		String[] tempTab= new String[5];
		ArrayList<String> Client=new ArrayList<String>();
		try {
			
	         File file = new File("datalogin.csv");
	   
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         br.readLine();
	        
	         while((line = br.readLine()) != null) {
	            
	           
	            	 tempTab=line.split(",");
	           
	            for (int j=0;j<5;j++) {
	            	
	            	Client.add(tempTab[j]);
	            }
	          
	         }
		 
	         
	       
	         br.close();
	         return Client;}
	          catch(IOException ioe) {
	            ioe.printStackTrace();
	         }

	        return Client;
	        }
}
