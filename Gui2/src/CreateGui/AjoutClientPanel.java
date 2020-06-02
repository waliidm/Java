package CreateGui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;


public class AjoutClientPanel {
	public static JPanel ajoutclient = new JPanel();

	private JTextField cinText;
	private JTextField nomText;
	private JTextField prenomText;
	private JLabel cinLabel;
	private JLabel nomLabel;
	private JLabel PrenomLabel;
	private JLabel sexeLabel;
	private JButton ajoutclientButton;
	private static JRadioButton radioHomme,radioFemme;
	private static ButtonGroup group;

	public AjoutClientPanel() {
				
		cinText = new JTextField();
		cinText.setBounds(410, 182, 154, 25);
		cinText.setBackground(new Color (229,229,229));
		
		nomText = new JTextField();
		nomText.setBounds(410, 218, 154, 25);
		nomText.setBackground(new Color (229,229,229));
		
		prenomText = new JTextField();
		prenomText.setBounds(410, 254, 154, 25);
		prenomText.setBackground(new Color (229,229,229));
		
		cinLabel = new JLabel("CIN");
		cinLabel.setBounds(286, 187, 61, 14);
		cinLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cinLabel.setForeground(Color.WHITE);
		
		nomLabel = new JLabel("Nom");
		nomLabel.setBounds(286, 223, 61, 14);
		nomLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomLabel.setForeground(Color.WHITE);
		
		PrenomLabel = new JLabel("Pr\u00E9nom");
		PrenomLabel.setBounds(286, 259, 61, 14);
		PrenomLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		PrenomLabel.setForeground(Color.WHITE);
		
		sexeLabel = new JLabel("Sexe");
		sexeLabel.setBounds(286, 290, 87, 14);
		sexeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sexeLabel.setForeground(Color.WHITE);
		
		radioHomme = new JRadioButton("Homme");
		radioHomme.setBounds(410, 286, 72, 25);
		radioHomme.setBackground(new Color (114,137,218));
		
		radioFemme = new JRadioButton("Femme");
		radioFemme.setBounds(484, 286, 79, 25);
		radioFemme.setBackground(new Color (114,137,218));
		
		group = new ButtonGroup(); 
		group.add(radioHomme); 
		group.add(radioFemme); 

		ajoutclientButton = new JButton("Ajouter");
		ajoutclientButton.setBounds(341, 318, 223, 23);
		ajoutclientButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ajoutclientButton.setForeground(Color.WHITE);
		ajoutclientButton.setBackground(new Color(114,137,218));
		
		setupPanel();
		setupListeners();
	}

	private void setupListeners() {

		
		ajoutclientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cin = cinText.getText();
				String prenom = prenomText.getText();
				String nom = nomText.getText();
				radioHomme.setActionCommand("Homme");
				radioFemme.setActionCommand("Femme");

				if (    (cin.isEmpty()) || (prenom.isEmpty()) || (nom.isEmpty()) ||   !(group.getSelection().equals(null)) ) 			
				{
					int res=Client.AjouterClient(cin, nom, prenom, group.getSelection().getActionCommand());
					if (res==0) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Cin existe déja", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else if(res==2) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Erreur dans le systeme", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Ajout avec succées", "Success",JOptionPane.WARNING_MESSAGE);
					}

				

				}
				else
				{
					JOptionPane.showMessageDialog(MainFrame.Frame1,
						    "remplissez tous les champs !",
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	
	}


	
	
	private void setupPanel() {
		ajoutclient.setBackground(new Color	(40,43,48));
		ajoutclient.setLayout(null);
		ajoutclient.add(cinText);
		ajoutclient.add(nomText);
		ajoutclient.add(prenomText);
		ajoutclient.add(cinLabel);
		ajoutclient.add(nomLabel);
		ajoutclient.add(PrenomLabel);
		ajoutclient.add(sexeLabel);
		ajoutclient.add(ajoutclientButton);
		ajoutclient.add(radioHomme);
		ajoutclient.add(radioFemme);

	


	}

}