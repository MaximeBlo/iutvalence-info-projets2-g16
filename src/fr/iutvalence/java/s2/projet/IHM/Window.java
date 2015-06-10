package fr.iutvalence.java.s2.projet.IHM;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import fr.iutvalence.java.s2.projet.Application;
import fr.iutvalence.java.s2.projet.IhmIdentification;
import fr.iutvalence.java.s2.projet.MainIhm;

/**
* Window's class (graphical aspect).
* @author MaximeBlo
*/
public class Window extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The application launch.
	 */
	private Application currentApplication;
	
	private MainIhm mainIhm;
	
	private IhmIdentification ihmPassword;
	
	private JPanel pan;
	/**
	 * Window's constructor.
	 * @param application 
	 */
	public Window(Application application){
		
		this.currentApplication = application;

		this.setTitle("Password Saver");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.pan = new JPanel();
	    this.pan.setLayout(new BorderLayout());
	    
	    this.mainIhm = new MainIhm(this, this.currentApplication);
	    
	    this.ihmPassword = new IhmIdentification(this, this.currentApplication);
	    
	    this.pan.add(this.ihmPassword);
	    
	    this.getContentPane().add(this.pan);
	    
	    this.setVisible(true);
	}
	
	/**
	 * Get the main gui.
	 * @return the main gui
	 */
	public MainIhm getMainIhm(){
		return this.mainIhm;
	}
	
	/**
	 * Get the gui password.
	 * @return the gui password
	 */
	public IhmIdentification getIdentification(){
		return this.ihmPassword;
	}
	
	/**
	 * Change the gui.
	 */
	public void changeIhm(){
		this.pan.removeAll();
		this.pan.add(this.mainIhm);
		this.pan.updateUI();
	}
	
	
}
