package CreateGui;
import java.io.*;
import java.util.ArrayList;


public class Voiture {
	protected String mat;
	protected String color;
	protected String marque;
	protected double prixJour;
	
	public Voiture(String mat,String color,String marque,double prixJour) {
		this.mat=mat;
		this.color=color;
		this.marque=marque;
		this.prixJour=prixJour;
	}
	
	
	public static ArrayList<String> ListerVoiture() {
		String[] tempTab= new String[5];
		ArrayList<String> voiture=new ArrayList<String>();
		try {
	         File file = new File("voiture.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         br.readLine();
	         while((line = br.readLine()) != null) {
	            tempTab=line.split(",");
	            for (int j=0;j<5;j++) {
	            	voiture.add(tempTab[j]);
	            }
	         }
	         br.close();
	         return voiture;}
	          catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
	        return voiture;
	        }
	
	

	
	public static int ChangerDisponibilte(String mat,int tache) {
		if (RechercheVoiture(mat).compareTo("")==0) {
			return 0;}
		ArrayList<String> voiture=ListerVoiture();
		for (int i=0;i<voiture.size();i+=5) {
			if(voiture.get(i).compareTo(mat)==0) {
				if((tache==1)&&(voiture.get(i+4).compareTo("disponible")==0)) {
					voiture.set(i+4,"indisponible");
					System.out.println("aaaaaaaaaa");
					System.out.println(tache);
					System.out.println(voiture.get(i+4).compareTo("disponible")==0);
					break;
				}else if((tache==2)&&((voiture.get(i+4).compareTo("indisponible")==0))){				
					System.out.println("bbbbbbbb");
					System.out.println(tache);
					System.out.println(voiture.get(i+4).compareTo("indisponible")==0);
					voiture.set(i+4,"disponible");
					break;
				}else if((tache==2)&&((voiture.get(i+4).compareTo("disponible")==0))) {			
					return 2;			
				}else if((tache==1)&&(voiture.get(i+4).compareTo("indisponible")==0)) {
					return 2;
				}		
			}
		}
		try {
			System.out.println("ahla");
			FileWriter pw = new FileWriter("voiture.csv");
			pw.append("marticule,marque,couleur,prixjour,disponibilite");
			for(int i=0;i<=voiture.size()-4;i+=5) {
				pw.append("\r\n"+(voiture.get(i)));
				pw.append(',');
				pw.append(voiture.get(i+1));
				pw.append(',');
				pw.append(voiture.get(i+2));
				pw.append(',');
				pw.append(voiture.get(i+3));
				pw.append(',');
				pw.append(voiture.get(i+4));					
			}		
			pw.flush();
			pw.close();
		}catch (IOException ioe) {
			return 2;
		}
		return 1;
	}      
	
	
	public static int AjouterVoiture(String mat,String color,String marque,String prixJour) {
		try {
			if (RechercheVoiture(mat).compareTo("")!=0) {
				return 0;
			}
			FileWriter pw = new FileWriter("voiture.csv",true);		
			pw.append("\r\n"+mat);
			pw.append(',');
			pw.append(marque);
			pw.append(',');
			pw.append(color);
			pw.append(',');
			pw.append(prixJour);
			pw.append(',');
			pw.append("disponible");
			pw.flush();
			pw.close();
			return 1;
		}catch (IOException ioe) {
			return 2;			
		}	
	}
	
	
	
	public static String RechercheVoiture(String mat) {
		try {
	         File file = new File("voiture.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] tempArr;
	         int i=0;
	         while((line = br.readLine()) != null) {
	            tempArr = line.split(",");
	            if(i>0) 
	            	if(tempArr[0].compareTo(mat)==0)
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
