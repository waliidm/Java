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
	private static LouerPanel louer ;
	private static RetournerPanel retourner ;
	private static VoiturePanel voiture ;
	private static JButton ajoutButtton;
	private static JButton louerButton;
	private static JButton retournerButton;
	private static JPanel parentPanel;
	private static JPanel panel;
	private JButton voitureButton;

	public MenuPanel() {
		ajout = new AjoutPanel();
		louer = new LouerPanel();
		retourner = new RetournerPanel();
		voiture = new VoiturePanel();

		ajoutButtton = new JButton(" Ajouter une voiture");
		louerButton = new JButton(" Louer une voiture");
		retournerButton = new JButton("Retourner une voiture");

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
		
		
									}

	private void setupPanel() {

		menu.setBackground(new Color(240, 248, 255));
		menu.setLayout(new BorderLayout(0, 0));

		nav.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menu.add(nav, BorderLayout.NORTH);
		voitureButton = new JButton("Voitures");
		
		nav.add(voitureButton);

		nav.add(ajoutButtton);

		nav.add(louerButton);

		nav.add(retournerButton);

		menu.add(parentPanel, BorderLayout.CENTER);
		parentPanel.add(VoiturePanel.voiture);
		parentPanel.setLayout(new CardLayout(0, 0));

	}


}
