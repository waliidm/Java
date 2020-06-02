package CreateGui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Client {

	protected String username;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected String sexe;
	
	public static ArrayList<String> ListerClient() {
		String[] tempTab= new String[1000];
		ArrayList<String> Client=new ArrayList<String>();
		try {
	         File file = new File("client.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         br.readLine(); 
	         while((line = br.readLine()) != null) {
	            tempTab=line.split(",");
	            for (int j=0;j<4;j++) {
	            	
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
	
	public static int AjouterClient(String cin,String firstName,String lastName,String sexe) {
		try {
			if (RechercheClient(cin).compareTo("")!=0) {
				return 0;
			}
			FileWriter pw = new FileWriter("Client.csv",true);
			pw.append("\r\n"+cin);
			pw.append(',');
			pw.append(firstName);
			pw.append(',');
			pw.append(lastName);
			pw.append(',');
			pw.append(sexe);
			pw.flush();
			pw.close();
			return 1;
		}catch (IOException ioe) {
			return 2;		
		}		
	}
	
	public static String RechercheClient(String cin) {
		try {
	         File file = new File("client.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] tempArr;
	         int i=0;
	         while((line = br.readLine()) != null) {
	            tempArr = line.split(",");	            
	            if(i>0) 
	            	System.out.println(tempArr[0]);
	            	System.out.println(cin+"/");
	            	System.out.println(tempArr[0].compareTo(cin));
	            	if(tempArr[0].compareTo(cin)==0)
	            		return line;
	            i++;
	         }
	         br.close();
	         
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
		return "";
	}
}
