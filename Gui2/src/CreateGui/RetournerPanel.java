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


public class RetournerPanel {
	public static JPanel retourner = new JPanel();

	private JTextField matText;
	private JLabel matLabel;
	private JButton RetournerButton;

	public RetournerPanel() {
				
		matText = new JTextField();
		matText.setBounds(410, 218, 154, 25);
		matText.setBackground(new Color (229,229,229));
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(286, 220, 61, 14);
		matLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		matLabel.setForeground(Color.WHITE);

		RetournerButton = new JButton("Retourner");
		RetournerButton.setBounds(341, 254,  223, 23);
		RetournerButton.setForeground(Color.WHITE);
		RetournerButton.setBackground(new Color(114,137,218));
		
		setupPanel();
		setupListeners();
	}

	private void setupListeners() {

		
		RetournerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = matText.getText();

				if (mat.isEmpty()) {			
					JOptionPane.showMessageDialog(MainFrame.Frame1, "remplissez tous les champs !", "Erreur",JOptionPane.WARNING_MESSAGE);
				}else {
					int test=Voiture.ChangerDisponibilte(mat, 2);
					if (test==0) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Matricule invalide", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else if(test==2) {
						JOptionPane.showMessageDialog(MainFrame.Frame1, "voiture deja disponible", "Erreur",JOptionPane.WARNING_MESSAGE);
					}else 
						JOptionPane.showMessageDialog(MainFrame.Frame1, "Retour avec succées", "Success",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	
	}

	
	
	private void setupPanel() {
		retourner.setBackground(new Color	(40,43,48));
		retourner.setLayout(null);
		retourner.add(matText);
		retourner.add(matLabel);
		retourner.add(RetournerButton);

	


	}

}
