package CreateGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;


public class LouerPanel {
	public static JPanel louer = new JPanel();

	private JTextField matText;
	private JTextField dureeText;
	private JTextField cinText;
	private JLabel matLabel;
	private JLabel dureeLabel;
	private JLabel cinLabel;
	private JButton louerButton;
	
	public LouerPanel() {
				
		matText = new JTextField();
		matText.setBounds(410, 182, 154, 25);
		matText.setBackground(new Color (229,229,229));
		
		dureeText = new JTextField();
		dureeText.setBounds(410, 218, 154, 25);
		dureeText.setBackground(new Color (229,229,229));
		
		cinText = new JTextField();
		cinText.setBounds(410, 254, 154, 25);
		cinText.setBackground(new Color (229,229,229));
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(286, 187, 61, 14);
		matLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		matLabel.setForeground(Color.WHITE);
		
		cinLabel = new JLabel("Cin");
		cinLabel.setBounds(286, 258, 61, 14);
		cinLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cinLabel.setForeground(Color.WHITE);
		
		dureeLabel = new JLabel("Dur\u00E9e ");
		dureeLabel.setBounds(286, 220, 61, 14);
		dureeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dureeLabel.setForeground(Color.WHITE);
		
		louerButton = new JButton("Louer");
		louerButton.setBounds(341, 290, 223, 23);
		louerButton.setForeground(Color.WHITE);
		louerButton.setBackground(new Color(114,137,218));
		
		setupPanel();
		setupListeners();
	}

	private void setupListeners() {

		
		louerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = matText.getText();
				String duree = dureeText.getText();
				String cin = cinText.getText();
				if ((mat.isEmpty()) || (duree.isEmpty())) {			
					JOptionPane.showMessageDialog(MainFrame.Frame1, "remplissez tous les champs !", "Inane warning",JOptionPane.WARNING_MESSAGE);
				}else {
					int test=Voiture.ChangerDisponibilte(mat, 1);
					if (test==0) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Matricule invalide", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else if(test==2) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "voiture indisponible", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else {
						String voiture=Voiture.RechercheVoiture(mat);
						String[] detail=voiture.split(",");
						int nbjour=Integer.valueOf(duree);
						double prixJour=Double.valueOf(detail[3]);
						Contrat c= new Contrat(mat,cin,nbjour,prixJour);
						int retour=c.AjoutContrat();
						if (retour==1)
							JOptionPane.showMessageDialog(MainFrame.Frame1, "Location avec succées", "Success",JOptionPane.WARNING_MESSAGE);
						else if (retour==0) {
							JOptionPane.showMessageDialog(MainFrame.Frame1, "Matricule invalide", "Erreur",JOptionPane.WARNING_MESSAGE);
						}else
							JOptionPane.showMessageDialog(MainFrame.Frame1, "Essayer plus tard", "Erreur",JOptionPane.WARNING_MESSAGE);
					
					}}
				
				}
		});
	
	}

	
	
	private void setupPanel() {
		louer.setBackground(new Color	(40,43,48));
		louer.setLayout(null);
		louer.add(matText);
		louer.add(dureeText);
		louer.add(cinText);
		louer.add(cinLabel);
		louer.add(matLabel);
		louer.add(dureeLabel);
		louer.add(louerButton);
		

	


	}

}
