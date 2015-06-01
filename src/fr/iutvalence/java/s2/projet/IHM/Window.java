package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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

	/**
	 * The menu of the application.
	 */
	private JMenuBar menu;
	
	/**
	 * The menu file.
	 */
	private JMenu file;
	
	/**
	 * The menu folder.
	 */
	private JMenu folder;
	
	/**
	 * The menu password.
	 */
	private JMenu password;
	
	/**
	 * The menu save.
	 */
	private JMenu save;
	
	/**
	 * The panel who contain the JTree.
	 */
	private JPanel pan;
	
	/**
	 * The scrollpan who contain the JTree and allow it to scroll down.
	 */
	private JScrollPane treeViewScrollPan;
	
	/**
	 * The first separation of the menu and the application.
	 */
	private JSplitPane splitSpanTop;
	
	/**
	 * The second separation of the JTree and the editor.
	 */
	private JSplitPane splitSpanApp;
	
	/**
	 * The create folder item of the menu.
	 */
	private JMenuItem createFolder;
	
	/**
	 * The generate password item of the menu.
	 */
	private JMenuItem generatePassword;
	
	/**
	 * The Jtree of the app.
	 */
	private JTree treeView;
	
	/**
	 * The source of the Jtree.
	 */
	DefaultMutableTreeNode racine;
	/**
	 * Folders to place in the JTree.
	 */
	DefaultMutableTreeNode[] elementFolder;
	/**
	 * Files to place in the JTree.
	 */
	DefaultMutableTreeNode elementFile;
	
	
	/**
	 * The application launch.
	 */
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
	    
	    this.treeView = new JTree();
	    
	    this.pan = new JPanel();
	    
	    
	    this.racine = new DefaultMutableTreeNode("/");
	    
	    this.buildJTree();
	    this.treeView = new JTree(this.racine);	
	    
	    this.treeViewScrollPan = new JScrollPane(this.treeView);
	    
	    this.pan.add(this.treeViewScrollPan);
	    
	    this.splitSpanTop = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    
	    this.splitSpanTop.setDividerLocation(50);
	    this.splitSpanTop.setEnabled(false);
	    this.splitSpanTop.setDividerSize(0);
	    
	    this.splitSpanTop.setTopComponent(this.menu);
	    
	    this.splitSpanApp = new JSplitPane();
	    
	    this.splitSpanApp.setDividerSize(0);
	    this.splitSpanApp.setEnabled(false);
	    this.splitSpanApp.setDividerLocation(200);
	    
	    this.splitSpanApp.setTopComponent(this.pan);
	    
	    this.splitSpanTop.setRightComponent(this.splitSpanApp);
	    
	    this.getContentPane().add(this.splitSpanTop);
	    
	    this.setVisible(true);
	}
	
	
	/**
	 * Build and rebuild JTree.
	 */
	private void buildJTree() {
		
		this.elementFolder = new DefaultMutableTreeNode[this.currentApplication.getNumberOfFolder()];
		this.racine.removeAllChildren();
		
		
		for(int numberOfFolder = 0; numberOfFolder < this.elementFolder.length;numberOfFolder++){
			
			this.elementFolder[numberOfFolder] = new DefaultMutableTreeNode("Folder: " + this.currentApplication.getFolders().get(numberOfFolder).getName());
			this.racine.add(this.elementFolder[numberOfFolder]);
			
			for(int numberOfFile = 0; numberOfFile < this.currentApplication.getFolders().get(numberOfFolder).getNumberOfFile(); numberOfFile++){
				this.elementFile = new DefaultMutableTreeNode(this.currentApplication.getFolders().get(numberOfFolder).getFile().get(numberOfFile));
				this.elementFolder[numberOfFolder].add(this.elementFile);
			}
		}
		
		
	}

	/**
	 * Build the menuItem.
	 */
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
	
	
	/**
	 * Build the save menu.
	 */
	private void buildMenuSave() {
		this.save.add(new JMenuItem("Save all"));
		
	}

	/**
	 * Build the password menu.
	 */
	private void buildMenuPassword() {
		this.generatePassword = new JMenuItem("Generate password");
		this.generatePassword.addActionListener(this);
		this.password.add(this.generatePassword);
	}


	/**
	 * Build the menu.
	 */
	private void buildMenu() {
		
		this.buildMenuItem();
	    
		this.menu.add(this.file);
	    this.menu.add(this.folder);
	    this.menu.add(this.password);
	    this.menu.add(this.save);
	}
	
	
	/**
	 * Build the folder menu.
	 */
	private void buildMenuFolder() {
		this.createFolder = new JMenuItem("Create folder");
		this.createFolder.addActionListener(this);
		this.folder.add(createFolder);
	    this.folder.add(new JMenuItem("Rename folder"));
	    this.folder.add(new JMenuItem("Delete folder"));
	}
	
	/**
	 * Build the file menu.
	 */
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
        	this.buildJTree();
        	this.treeView.updateUI();
        }else if(source == this.generatePassword){
        	GeneratorOptionSelection gen = new GeneratorOptionSelection(this.currentApplication);
        }
	}
	

}
