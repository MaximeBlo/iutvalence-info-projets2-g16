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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import fr.iutvalence.java.s2.projet.Application;

/**
* Window's class (graphical aspect)
* @author MaximeBlo
*/
public class Window extends JFrame implements ActionListener, MouseListener
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
	private DefaultMutableTreeNode racine;
	/**
	 * Folders to place in the JTree.
	 */
	private DefaultMutableTreeNode[] elementFolder;
	/**
	 * Files to place in the JTree.
	 */
	private DefaultMutableTreeNode elementFile;
	
	private JTextField editor;
	
	private JSplitPane editorSplitPan;
	
	private JButton sauvegarde;
	
	private String currentFolder;
	
	private String currentFile;
	
	
	
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
	    this.treeView.addMouseListener(this);
	    
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
	    
	    this.editor = new JTextField();
	    this.editorSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    this.editorSplitPan.setEnabled(false);
	    this.editorSplitPan.setDividerLocation(500);
	    this.editorSplitPan.setDividerSize(0);
	    
	    this.editorSplitPan.setTopComponent(this.editor);
	    
	    this.sauvegarde = new JButton();
	    
	    this.sauvegarde.setText("Sauvegarde");
	    this.sauvegarde.addActionListener(this);
	    
	    this.editorSplitPan.setBottomComponent(this.sauvegarde);
	    
	    this.splitSpanApp.setBottomComponent(this.editorSplitPan);
	    
	    this.splitSpanTop.setBottomComponent(this.splitSpanApp);
	    
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
				this.elementFile = new DefaultMutableTreeNode(this.currentApplication.getFolders().get(numberOfFolder).getName() + " : " + this.currentApplication.getFolders().get(numberOfFolder).getFile().get(numberOfFile));
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
        }else if(source == this.sauvegarde && this.currentFile != null){
        	this.currentApplication.writeInFile(this.currentFolder, this.currentFile, this.editor.getText());
        	
        }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		TreePath tp = this.treeView.getPathForLocation(e.getX(), e.getY());
	    if (tp != null && tp.getPathCount() > 2){
	    	
	      this.editor.setText(this.currentApplication.readFile(tp.getParentPath().toString().substring(12,15),tp.toString().substring(23).substring(0, tp.toString().substring(23).indexOf(']'))));
	      this.currentFolder = tp.getParentPath().toString().substring(12,15);
	      this.currentFile = tp.toString().substring(23).substring(0, tp.toString().substring(23).indexOf(']'));
	}
	    else
	    	this.editor.setText("");
	  }
		


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
