package CreateGui;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;

public class MenuPanel {
	static JPanel menu = new JPanel();
	JPanel nav = new JPanel();
	private static AjoutPanel ajout ;
	private static AjoutClientPanel ajoutclient ;
	private static LouerPanel louer ;
	private static RetournerPanel retourner ;
	private static VoiturePanel voiture ;
	private static JButton ajoutButtton;
	private static JButton louerButton;
	private static JButton retournerButton;
	private static JPanel parentPanel;
	private static JPanel panel;
	private static ClientPannel client;
	private JButton voitureButton;
	private JButton clientButton;
	private JButton ajoutclientButton;

	public MenuPanel() {
		ajout = new AjoutPanel();
		ajoutclient = new AjoutClientPanel();
		louer = new LouerPanel();
		retourner = new RetournerPanel();
		voiture = new VoiturePanel();
		client = new ClientPannel();
		
		ajoutButtton = new JButton(" Ajouter une voiture");
		ajoutButtton.setFont(ajoutButtton.getFont().deriveFont(14f));
		ajoutButtton.setBackground(new Color(40,43,48));
		ajoutButtton.setForeground(new Color (114,137,218));


		louerButton = new JButton(" Louer une voiture");
		louerButton.setFont(louerButton.getFont().deriveFont(14f));
		louerButton.setBackground(new Color(40,43,48));
		louerButton.setForeground(new Color (114,137,218));

		
		retournerButton = new JButton("Retourner une voiture");
		retournerButton.setFont(retournerButton.getFont().deriveFont(14f));
		retournerButton.setBackground(new Color(40,43,48));
		retournerButton.setForeground(new Color (114,137,218));

		
		voitureButton = new JButton("Voitures");
		voitureButton.setFont(voitureButton.getFont().deriveFont(14f));
		voitureButton.setBackground(new Color(40,43,48));
		voitureButton.setForeground(new Color (114,137,218));

		
		clientButton = new JButton("Clients");
		clientButton.setFont(clientButton.getFont().deriveFont(14f));
		clientButton.setBackground(new Color(40,43,48));
		clientButton.setForeground(new Color (114,137,218));
		
		ajoutclientButton = new JButton("Ajouter un client");
		ajoutclientButton.setFont(clientButton.getFont().deriveFont(14f));
		ajoutclientButton.setBackground(new Color(40,43,48));
		ajoutclientButton.setForeground(new Color (114,137,218));


		parentPanel = new JPanel();

		setupPanel();
		setupListeners();
	}

	private void setupListeners() {
		
//--------------------Action_Ajout-----------------
		ajoutButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				parentPanel.removeAll();
				parentPanel.add(AjoutPanel.ajout);
				parentPanel.repaint();
				parentPanel.revalidate();
			}});
//--------------------Action_Louer-----------------
		louerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				parentPanel.removeAll();
				parentPanel.add(LouerPanel.louer);
				parentPanel.repaint();
				parentPanel.revalidate();
			}});
//--------------------Action_Retourner-----------------
		retournerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				parentPanel.removeAll();
				parentPanel.add(RetournerPanel.retourner);
				parentPanel.repaint();
				parentPanel.revalidate();
			}});		
//--------------------Action_Voiture-----------------		
				voitureButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parentPanel.removeAll();
						parentPanel.add(VoiturePanel.voiture);
						parentPanel.repaint();
						parentPanel.revalidate();
					}
				});	
//--------------------Action_Clients-----------------	
				clientButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parentPanel.removeAll();
						parentPanel.add(ClientPannel.client);
						parentPanel.repaint();
						parentPanel.revalidate();
					}
				});
				
//--------------------Action_Ajout_Clients-----------------					
				ajoutclientButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parentPanel.removeAll();
						parentPanel.add(AjoutClientPanel.ajoutclient);
						parentPanel.repaint();
						parentPanel.revalidate();
					}
				});
				
		
									}

	private void setupPanel() {

		menu.setBackground(new Color(240, 248, 255));
		menu.setLayout(new BorderLayout(0, 0));

		nav.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menu.add(nav, BorderLayout.NORTH);
		

		nav.add(clientButton);
				
		nav.add(voitureButton);
		
		nav.add(ajoutclientButton);

		nav.add(ajoutButtton);

		nav.add(louerButton);

		nav.add(retournerButton);
		nav.setBackground(new Color (114,137,218));
		menu.add(parentPanel, BorderLayout.CENTER);
		parentPanel.add(VoiturePanel.voiture);
		parentPanel.setLayout(new CardLayout(0, 0));

	}


}
