package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.s2.projet.Application;
import fr.iutvalence.java.s2.projet.TreeView;

/**
* Window's class (graphical aspect)
* @author MaximeBlo
*/
public class Window extends JFrame implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar menu;
	
	private JMenu file;
	
	private JMenu folder;
	
	private JMenu password;
	
	private JMenu save;
	
	private JPanel pan;
	
	private JSplitPane splitSpanTop;
	
	private JMenuItem createFolder;
	private JMenuItem generatePassword;
	
	private Application currentApplication;
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
	    
	    this.menu = new JMenuBar();

	    this.buildMenu();
	    
	    
	    
	    this.pan = new JPanel();
	    
	    this.splitSpanTop = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    
	    this.splitSpanTop.setDividerLocation(50);
	    this.splitSpanTop.setEnabled(false);
	    this.splitSpanTop.setDividerSize(0);
	    
	    this.splitSpanTop.setTopComponent(menu);
	    this.splitSpanTop.setRightComponent(pan);
	    
	    this.getContentPane().add(this.splitSpanTop);
	    
	    this.setVisible(true);
	}
	
	
	private void buildMenuItem() {
		this.file = new JMenu("File");
	    this.folder = new JMenu("Folder");
	    this.password = new JMenu("Password");
	    this.save = new JMenu("Save");
	    
	    this.buildMenuFile();
	    this.buildMenuFolder();
	    this.buildMenuPassword();
	    this.buildMenuSave();
	}
	
	
	private void buildMenuSave() {
		this.save.add(new JMenuItem("Save all"));
		
	}


	private void buildMenuPassword() {
		this.generatePassword = new JMenuItem("Generate password");
		this.generatePassword.addActionListener(this);
		this.password.add(this.generatePassword);
	}


	private void buildMenu() {
		
		this.buildMenuItem();
	    
		this.menu.add(this.file);
	    this.menu.add(this.folder);
	    this.menu.add(this.password);
	    this.menu.add(this.save);
	}
	
	
	private void buildMenuFolder() {
		this.createFolder = new JMenuItem("Create folder");
		this.createFolder.addActionListener(this);
		this.folder.add(createFolder);
	    this.folder.add(new JMenuItem("Rename folder"));
	    this.folder.add(new JMenuItem("Delete folder"));
	}
	
	
	private void buildMenuFile() {
		this.file.add(new JMenuItem("Create File"));
	    this.file.add(new JMenuItem("Rename File"));
	    this.file.add(new JMenuItem("Delete File"));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
        
        if  (source== this.createFolder){
        	this.currentApplication.createFolder();
        }else if(source == this.generatePassword){
        	GeneratorOptionSelection gen = new GeneratorOptionSelection(this.currentApplication);
        }
	}
	

}
