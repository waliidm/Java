package CreateGui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame 
{	
	static JFrame Frame1 = new JFrame();
	private static LoginPanel login; 
	
	public MainFrame()
	{
		login = new LoginPanel();

		
		setupFrame();
	}
	
	public void setupFrame()
	{
		Frame1.add(LoginPanel.login);
	}
	
	public void start()
	{
		Frame1.setSize(960, 780);
		Frame1.setLocationRelativeTo(null);
		Frame1.setTitle("Location");
		Frame1.setVisible(true);
	}
	
}
