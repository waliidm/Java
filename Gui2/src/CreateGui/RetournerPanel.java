package CreateGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RetournerPanel {
	public static JPanel retourner = new JPanel();

	private JTextField matText;
	private JLabel matLabel;
	private JButton RetournerButton;

	public RetournerPanel() {
				
		matText = new JTextField();
		matText.setBounds(232, 58, 154, 20);
		
		matLabel = new JLabel("Matricule");
		matLabel.setBounds(113, 61, 61, 14);

		RetournerButton = new JButton("Retourner");
		RetournerButton.setBounds(160, 99, 120, 23);
		
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
		
		retourner.setLayout(null);
		retourner.add(matText);
		retourner.add(matLabel);
		retourner.add(RetournerButton);

	


	}

}
