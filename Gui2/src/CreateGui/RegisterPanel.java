package CreateGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class RegisterPanel 
{
	static JPanel register = new JPanel();

	private static JButton signup;
	private static JLabel prenomLabel,userLabel,passLabel,repeatpassLabel,sexeLabel,nomLabel;
	private static JTextField prenomText,userText,passText,repeatpassText;
	private static JRadioButton radioHomme,radioFemme;
	private static ButtonGroup group;
	private JTextField nomText;
	public RegisterPanel() 
	{
		
		nomLabel = new JLabel("Nom ");
		nomLabel.setForeground(Color.WHITE);
		nomLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomLabel.setBounds(254, 160, 141, 25);
		
		nomText = new JTextField();
		nomText.setBounds(424, 160, 233, 25);

		prenomLabel = new JLabel("Prénom");
		prenomLabel.setForeground(Color.WHITE);
		prenomLabel.setBounds(254, 196, 141, 25);
		prenomLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		prenomText = new JTextField();
		prenomText.setBounds(424, 196, 233, 25);

		userLabel = new JLabel("Nom d'utilisateur");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(254, 270, 141, 17);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		userText = new JTextField();
		userText.setBounds(424, 268, 233, 25);
		
		sexeLabel = new JLabel("Sexe");
		sexeLabel.setBounds(254, 232, 141, 25);
		sexeLabel.setForeground(Color.WHITE);
		sexeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		radioHomme = new JRadioButton("Homme");
		radioHomme.setBounds(424, 232, 115, 23);
		radioHomme.setBackground(new Color (114,137,218));
		
		radioFemme = new JRadioButton("Femme");
		radioFemme.setBounds(541, 232, 116, 23);
		radioFemme.setBackground(new Color (114,137,218));
		
		group = new ButtonGroup(); 
		group.add(radioHomme); 
		group.add(radioFemme); 
		
		passLabel = new JLabel("Mot de passe");
		passLabel.setForeground(Color.WHITE);
		passLabel.setBounds(254, 309, 93, 14);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passText = new JTextField();
		passText.setBounds(424, 304, 233, 25);
		
		repeatpassLabel = new JLabel("R\u00E9peter le mot de passe");
		repeatpassLabel.setForeground(Color.WHITE);
		repeatpassLabel.setBounds(254, 345, 160, 14);
		repeatpassLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		repeatpassText = new JTextField();
		repeatpassText.setBounds(424, 340, 233, 25);

		signup = new JButton("S'inscrire");
		signup.setBounds(424, 376, 233, 25);
		signup.setBackground(new Color(189,189,189));
		signup.setFont(signup.getFont().deriveFont(signup.getFont().getSize() + 3f));

		setupPanel();
		setupListeners();
	}

	private void setupListeners() 
	{
		
		signup.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Fname=prenomText.getText();		
				String Lname=nomText.getText();	
				String user=userText.getText();		
				String pass=passText.getText();
				String repass=repeatpassText.getText();
			
				radioHomme.setActionCommand("Homme");
				radioFemme.setActionCommand("Femme");
			
				if( !(Fname.isEmpty()) && !(user.isEmpty()) && !(pass.isEmpty()) && !(repass.isEmpty()) && !(group.getSelection().equals(null)) && !(Lname.isEmpty()))
				{
					if (pass.equals(repass))
					{
				try
				{
					FileWriter fw = new FileWriter("datalogin.csv",true);	
					
					fw.append(user);
					fw.append(",");
					fw.append(pass);
					fw.append(",");
					fw.append(Fname);
					fw.append(",");
					fw.append(Lname);
					fw.append(",");
					fw.append(group.getSelection().getActionCommand());
					fw.append("\r\n");
					fw.flush();
					fw.close();
					System.out.println("file done");
					MainFrame.Frame1.remove(register);
					MainFrame.Frame1.getContentPane().add(LoginPanel.login);
					MainFrame.Frame1.revalidate();
					MainFrame.Frame1.repaint();

					
				}
				catch(IOException err)
				{
					System.out.println("file exists");
				}
					}
					else
					{
						JOptionPane.showMessageDialog(MainFrame.Frame1,
							    "les mots de passe ne correspondent pas !",
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
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

	private void setupPanel() 
	{
		register.setBackground(new Color(70,70,70));
		register.setLayout(null);
		register.add(prenomLabel);
		register.add(prenomText);
		register.add(userLabel);
		register.add(userText);
		register.add(passLabel);
		register.add(passText);
		register.add(repeatpassLabel);
		register.add(repeatpassText);
		register.add(signup);
		register.add(sexeLabel);
		register.add(radioHomme);
		register.add(radioFemme);
		register.add(nomText);		
		register.add(nomLabel);

	}
}
