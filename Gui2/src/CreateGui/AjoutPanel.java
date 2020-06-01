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
		matText.setBounds(410, 182, 154, 25);
		matText.setBackground(new Color (229,229,229));
		
		marqueText = new JTextField();
		marqueText.setBounds(410, 218, 154, 25);
		marqueText.setBackground(new Color (229,229,229));
		
		couleurText = new JTextField();
		couleurText.setBounds(410, 254, 154, 25);
		couleurText.setBackground(new Color (229,229,229));
		
		prixText = new JTextField();
		prixText.setBounds(410, 290, 154, 25);
		prixText.setBackground(new Color (229,229,229));
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(286, 187, 61, 14);
		matLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		matLabel.setForeground(Color.WHITE);
		
		marqueLabel = new JLabel("Marque");
		marqueLabel.setBounds(286, 223, 61, 14);
		marqueLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		marqueLabel.setForeground(Color.WHITE);
		
		couleurLabel = new JLabel("couleur");
		couleurLabel.setBounds(286, 259, 61, 14);
		couleurLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		couleurLabel.setForeground(Color.WHITE);
		
		prixLabel = new JLabel("Prix par jour");
		prixLabel.setBounds(286, 295, 87, 14);
		prixLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		prixLabel.setForeground(Color.WHITE);

		ajoutButton = new JButton("Ajouter");
		ajoutButton.setBounds(341, 333, 223, 23);
		ajoutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ajoutButton.setForeground(Color.WHITE);
		ajoutButton.setBackground(new Color(114,137,218));
		
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
		ajout.setBackground(new Color	(40,43,48));
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
