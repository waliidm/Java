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

public class ClientPannel{
	public static JPanel client = new JPanel();
	private JTable table;
	private JButton refresh;	
	private String[][] data= new String[100][4];
	public ClientPannel() {
		setupPanel();
		setupListeners();
	}

	private void setupListeners() {
	}

	private void setupPanel() {
		String[] colNames= {"CIN","Pr�nom","Nom ","Sexe"};
		ArrayList<String>clt = Client.ListerClient();    
		for (int i = 0 ; i <(clt.size()/4);i++)
		{
			for( int j = 0 ; j<4;j++)
			{	
				
				data[i][j]= clt.get(j +(i*4)) ;
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
		client.add(scrollPane);
		client.setLayout(new FlowLayout() );
		client.setBorder(BorderFactory.createEmptyBorder(70, 10, 10, 10));
		client.setBackground(new Color	(40,43,48));		
		refresh = new JButton("rafra�chir");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String>clt = Client.ListerClient(); 
				table.tableChanged(null);
				for (int i = 0 ; i <(clt.size()/4);i++)
				{
					for( int j = 0 ; j<4;j++)
					{
						System.out.println(clt.get(j +(i*4)));
						System.out.println("---------------------------------------");
						data[i][j]= clt.get(j +(i*4)) ;
						
					}
				}
			}
		});		
		refresh.setBounds(424, 376, 233, 25);
		refresh.setBackground(new Color(114,137,218));
		refresh.setFont(refresh.getFont().deriveFont(refresh.getFont().getSize() + 3f));
		refresh.setForeground(Color.WHITE);	
	client.add(refresh);
	}
}
