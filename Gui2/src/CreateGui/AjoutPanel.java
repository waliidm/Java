package CreateGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AjoutPanel {
	public static JPanel ajout = new JPanel();

	private JTextField matText;
	private JTextField marqueText;
	private JTextField couleurText;
	private JTextField prixText;
	private JLabel matLabel;
	private JLabel marqueLabel;
	private JLabel couleurLabel;
	private JLabel prixLabel;
	private JButton ajoutButton;

	public AjoutPanel() {
				
		matText = new JTextField();
		matText.setBounds(232, 58, 154, 20);
		
		marqueText = new JTextField();
		marqueText.setBounds(232, 89, 154, 20);
		
		couleurText = new JTextField();
		couleurText.setBounds(232, 120, 154, 20);
		
		prixText = new JTextField();
		prixText.setBounds(232, 151, 154, 20);
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(113, 61, 61, 14);
		
		marqueLabel = new JLabel("Marque");
		marqueLabel.setBounds(113, 92, 61, 14);
		
		couleurLabel = new JLabel("couleur");
		couleurLabel.setBounds(113, 123, 61, 14);
		
		prixLabel = new JLabel("Prix par jour");
		prixLabel.setBounds(113, 154, 87, 14);

		ajoutButton = new JButton("Ajouter");
		ajoutButton.setBounds(159, 195, 120, 23);
		
		setupPanel();
		setupListeners();
	}

	private void setupListeners() {

		
		ajoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = matText.getText();
				String couleur = couleurText.getText();
				String marque = marqueText.getText();
				String prix = prixText.getText();


				if (    (mat.isEmpty()) || (couleur.isEmpty()) || (marque.isEmpty()) || (prix.isEmpty())  ) {			
					JOptionPane.showMessageDialog(MainFrame.Frame1, "remplissez tous les champs !", "Inane warning",JOptionPane.WARNING_MESSAGE);
				}else {
					int test=Voiture.AjouterVoiture(mat, couleur, marque, prix);
					if (test==0) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Matricule existe deja", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else if (test==1) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Voiture ajoutée avec succées", "Succée",JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Essayer plus tard", "Erreur",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	
	}


	
	
	private void setupPanel() {
		
		ajout.setLayout(null);
		ajout.add(matText);
		ajout.add(marqueText);
		ajout.add(couleurText);
		ajout.add(prixText);
		ajout.add(matLabel);
		ajout.add(marqueLabel);
		ajout.add(couleurLabel);
		ajout.add(prixLabel);
		ajout.add(ajoutButton);

	


	}

}
