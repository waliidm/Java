package CreateGui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class VoiturePanel {
	public static JPanel voiture = new JPanel();
	private JTable table;
	private JButton refresh;



	

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
			table.setBorder(new LineBorder(new Color(114, 137, 218), 1, true));
			table.setBackground(new Color (66,69,73));
			
			table.getTableHeader().setBackground(new Color (114,137,218));
			table.getTableHeader().setForeground(Color.BLACK);
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
			
			table.setPreferredScrollableViewportSize(new Dimension(900, 400));
			table.setFillsViewportHeight(true);
			table.setForeground(Color.WHITE);
			table.setFont(new Font("Tahoma", Font.BOLD, 10));
			JScrollPane scrollPane = new JScrollPane(table);
		voiture.add(scrollPane);
		voiture.setLayout(new FlowLayout() );
		voiture.setBorder(BorderFactory.createEmptyBorder(70, 10, 10, 10));
		voiture.setBackground(new Color	(40,43,48));
		
		refresh = new JButton("rafraîchir");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.repaint();
			}
		});
		
		refresh.setBounds(424, 376, 233, 25);
		refresh.setBackground(new Color(114,137,218));
		refresh.setFont(refresh.getFont().deriveFont(refresh.getFont().getSize() + 3f));
		refresh.setForeground(Color.WHITE);
		
		voiture.add(refresh);

		
		


	


	}
}
