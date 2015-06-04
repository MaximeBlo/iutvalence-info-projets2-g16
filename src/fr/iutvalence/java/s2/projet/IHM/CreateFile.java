package fr.iutvalence.java.s2.projet.IHM;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;

public class CreateFile extends JFrame{
	
	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane twoOptionSplitPan;
	
	private JSplitPane nameOfFolderSplitPan;
	
	private JSplitPane nameOfFileSplitPan;
	
	private JLabel nameOfFile;
	
	private JLabel nameOfFolder;
	
	private JTextField file;
	
	private JTextField folder;
	
	public CreateFile(Application application){
		this.currentApplication = application;
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		this.twoOptionSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		this.nameOfFileSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		this.nameOfFolderSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		this.nameOfFile = new JLabel("Name of file:");
		
		this.nameOfFolder = new JLabel("Name of folder:");
		
		this.file = new JTextField();
		
		this.folder = new JTextField();
		
		this.nameOfFileSplitPan.setTopComponent(this.nameOfFile);
		this.nameOfFileSplitPan.setBottomComponent(this.file);
		
		
		
	}
	
	

}
