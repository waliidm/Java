package CreateGui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JButton;


public class VoiturePanel {
	public static JPanel voiture = new JPanel();
	private JTable table;



	

	public VoiturePanel() {
	
		
		


		setupPanel();
		setupListeners();
	}

	private void setupListeners() {

		
	
	
	}

	
	
	private void setupPanel() {
		String[] colNames= {"Matricule","Marque","Couleur","Prix par jour","Disposibilite"};
		

		ArrayList<String>voit = Voiture.ListerVoiture();    

		
		
	    
		

		String[][] data= new String[voit.size()/5][5];
		for (int i = 0 ; i <(voit.size()/5);i++)
		{
			for( int j = 0 ; j<5;j++)
			{
				data[i][j]= voit.get(j +(i*5)) ;
			}
		}

		

		
		
		table = new JTable( data,colNames );
			table.setPreferredScrollableViewportSize(new Dimension(700,300));
			table.setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(table);
			voiture.add(scrollPane);
		voiture.setLayout(new FlowLayout() );

		
		


	


	}
}
