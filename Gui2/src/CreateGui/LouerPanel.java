package CreateGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
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
		matText.setBounds(232, 58, 154, 20);
		
		dureeText = new JTextField();
		dureeText.setBounds(232, 89, 154, 20);
		
		cinText = new JTextField();
		cinText.setBounds(232, 120, 154, 20);
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(113, 61, 61, 14);
		
		cinLabel = new JLabel("Cin");
		cinLabel.setBounds(113, 123, 61, 14);
		
		dureeLabel = new JLabel("Dur\u00E9e ");
		dureeLabel.setBounds(113, 92, 61, 14);
		
		louerButton = new JButton("Louer");
		louerButton.setBounds(156, 192, 120, 23);
		
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
