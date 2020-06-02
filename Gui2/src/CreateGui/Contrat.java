package CreateGui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Contrat {
	protected String cin;
	protected String mat;
	protected int nbJour;
	protected double prix;
	public Contrat(String cin,String mat,int nbJour,double prixJour) {
		 this.cin=cin;
		 this.mat=mat;
		 this.nbJour=nbJour;
		 this.prix=nbJour*prixJour;
	}
	public int AjoutContrat(){
		try {
			if(Client.RechercheClient(cin).compareTo("")==0)
			{
				return 2;
			}
			String voiture=Voiture.RechercheVoiture(mat);			
			String[] detailsVoiture=voiture.split(",");
			FileWriter pw = new FileWriter("contrat.csv",true);
			System.out.print("dkhal2");
			pw.append("\r\n"+this.cin);
			pw.append(',');
			pw.append(this.mat);
			pw.append(',');
			pw.append(""+this.nbJour);
			pw.append(',');
			pw.append(""+this.prix);
			pw.flush();
			pw.close();
			return 1;
		}catch (IOException ioe) {
			return 3;
			
		}
	}
	public static int SupprimerContrat(String mat) {
		String voiture=Voiture.RechercheVoiture(mat);
		String[] detailsVoiture=voiture.split(",");
		if (voiture.compareTo("")==0) {
			return 0;
		}else if(detailsVoiture[4].compareTo("disponible")==0) {
			return 2;
		}
		try {
			 File file = new File("contrat.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String tempString="";
	         int i=0;
	         while((line = br.readLine()) != null) {
	            if((i>0)&&(line.indexOf(mat)==-1))  {   	 
	            	 tempString+=','+line ;
	            }
	            i++;    
	         }
	         br.close();
	         String[] tempArr=tempString.split(",");
	         FileWriter pw = new FileWriter("contrat.csv",true);
	         for (i=0;i<=tempArr.length-4;i+=4) {
				 pw.append("\r\n"+tempArr[i]);
				 pw.append(',');
				 pw.append(tempArr[i+1]);
				 pw.append(',');
				 pw.append(""+tempArr[i+2]);
				 pw.append(',');
				 pw.append(""+tempArr[i+3]);
	         }        
			 pw.flush();
			 pw.close();
			 return 1;
		}catch (IOException ioe) {
			return 3;
			
		}
	}
	
	

}
