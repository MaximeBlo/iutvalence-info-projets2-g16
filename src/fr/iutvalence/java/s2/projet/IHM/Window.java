package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import fr.iutvalence.java.s2.projet.Application;
import fr.iutvalence.java.s2.projet.IhmIdentification;
import fr.iutvalence.java.s2.projet.MainIhm;

/**
* Window's class (graphical aspect)
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
	/**
	 * window's contructor
	 * @param name the window's name
	 * @param width the window's width
	 * @param heigth the window's height
	 */
	public Window(Application application){
		
		this.currentApplication = application;

		this.setTitle("Password Saver");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.mainIhm = new MainIhm(this, this.currentApplication);
	    this.mainIhm.setSize(1300, 700);
	    
	    this.ihmPassword = new IhmIdentification(this, this.currentApplication);
	    
	    this.getContentPane().add(this.ihmPassword);
	    
	    this.setVisible(true);
	}
	
	public MainIhm getMainIhm(){
		return this.mainIhm;
	}
	
	public IhmIdentification getIdentification(){
		return this.ihmPassword;
	}
	
}
