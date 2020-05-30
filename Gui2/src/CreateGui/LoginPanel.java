package CreateGui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class LoginPanel {
	static JPanel login = new JPanel();
	static MenuPanel menu;
	static RegisterPanel register;
	private static JButton signin;
	private static JPasswordField passText;
	private static JLabel passLabel;
	private static JTextField userText;
	private static JLabel userLabel;
	private static JLabel clickme;

	public LoginPanel() {

		menu = new MenuPanel();
		register = new RegisterPanel();

		userLabel = new JLabel("Nom d'utilisateur");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(265, 230, 130, 25);

		userText = new JTextField();
		userText.setBounds(424, 230, 233, 25);

		passLabel = new JLabel("Mot de passe");
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passLabel.setForeground(Color.WHITE);
		passLabel.setBounds(265, 279, 130, 25);

		passText = new JPasswordField();
		passText.setBounds(424, 279, 233, 25);

		signin = new JButton("S'identifier");
		signin.setFont(signin.getFont().deriveFont(signin.getFont().getSize() + 3f));
		signin.setBounds(424,326, 233, 25);
		signin.setBackground(new Color(189,189,189));

		clickme = new JLabel("Vous n'avez pas un compte? Cliquez ici!");
		clickme.setFont(new Font("Tahoma", Font.BOLD, 11));
		clickme.setForeground(new Color (114,137,218));
		clickme.setBounds(356, 374, 233, 14);

		setupPanel();
		setupListeners();
	}

	private void setupListeners() {
//-----------------------Action_Signin------------------
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String csvFile = "datalogin.csv";
				BufferedReader br = null;
				String line = "";
				String user = userText.getText();
				String pass = passText.getText();
				Boolean t = false;

				if (!(user.isEmpty()) && !(pass.isEmpty())) {

					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine();
						while ((line = br.readLine()) != null) {

							String[] data = line.split(",");

							if ((user.equals(data[0])) && (pass.equals(data[1]))) {
								t = true;
							}

						}

						if (t) {
							MainFrame.Frame1.remove(login);
							MainFrame.Frame1.getContentPane().add(MenuPanel.menu);
							MainFrame.Frame1.revalidate();
							MainFrame.Frame1.repaint();
						} else {
							JOptionPane.showMessageDialog(MainFrame.Frame1, "vérifier les informations de connexion !", "Inane warning",JOptionPane.WARNING_MESSAGE);
						}

					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(MainFrame.Frame1, "  remplissez tous les champs !", "Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
//-----------------------Action_inscrire------------------

		clickme.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				MainFrame.Frame1.remove(login);
				MainFrame.Frame1.getContentPane().add(RegisterPanel.register);
				MainFrame.Frame1.revalidate();
				MainFrame.Frame1.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
			}
		});

	}

	private void setupPanel() {
		login.setLayout(null);
		login.setBackground(new Color(70,70,70));
		login.add(userLabel);
		login.add(userText);
		login.add(passLabel);
		login.add(passText);
		login.add(signin);
		login.add(clickme);

	}

}
