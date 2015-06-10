package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;

/**
 * Rename file.
 * @author Elisa
 *
 */
public class RenameFile extends JFrame implements ActionListener{
	
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane twoOptionSplitPan;
	
	private JSplitPane renameSplitPan;
	
	private JSplitPane nameOfFolderSplitPan;
	
	private JSplitPane nameOfFileSplitPan;
	
	private JSplitPane newNameOfFileSplitPan;
	
	private JLabel nameOfFile;
	
	private JLabel nameOfCurrentFolder;
	
	private JLabel newNameOfFile;
	
	private JTextField file;
	
	private JTextField folder;
	
	private JTextField newFile;
	
	private JButton validate;
	
	private Window currentWindow;
	
	/**
	 * Rename file's constructor.
	 * @param application
	 * @param window
	 */
	public RenameFile(Application application, Window window){
		this.currentApplication = application;
		
		this.currentWindow = window;
		
		this.setTitle("Rename folder");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.frame.setDividerSize(0);
		this.frame.setEnabled(false);
		
		this.twoOptionSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.twoOptionSplitPan.setDividerSize(0);
		this.twoOptionSplitPan.setEnabled(false);
		
		this.nameOfFolderSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.nameOfFolderSplitPan.setDividerSize(0);
		this.nameOfFolderSplitPan.setEnabled(false);
		
		this.renameSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.renameSplitPan.setDividerSize(0);
		this.renameSplitPan.setEnabled(false);
		
		this.nameOfFileSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.nameOfFileSplitPan.setDividerSize(0);
		this.nameOfFileSplitPan.setEnabled(false);
		
		this.newNameOfFileSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.newNameOfFileSplitPan.setDividerSize(0);
		this.newNameOfFileSplitPan.setEnabled(false);
		
		this.nameOfFile = new JLabel("Name of the file:");
		
		this.nameOfCurrentFolder = new JLabel("Name of the folder:");
		
		this.newNameOfFile = new JLabel("New name for the folder:");
		
		this.file = new JTextField();
		
		this.folder = new JTextField();
		
		this.newFile = new JTextField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.renameSplitPan.setTopComponent(this.nameOfFolderSplitPan);
		this.renameSplitPan.setBottomComponent(this.nameOfFileSplitPan);
		
		this.nameOfFolderSplitPan.setTopComponent(this.nameOfCurrentFolder);
		this.nameOfFolderSplitPan.setBottomComponent(this.folder);
		
		this.nameOfFileSplitPan.setTopComponent(this.nameOfFile);
		this.nameOfFileSplitPan.setBottomComponent(this.file);
		
		this.newNameOfFileSplitPan.setTopComponent(this.newNameOfFile);
		this.newNameOfFileSplitPan.setBottomComponent(this.newFile);
		
		this.twoOptionSplitPan.setTopComponent(this.renameSplitPan);
		this.twoOptionSplitPan.setBottomComponent(this.newNameOfFileSplitPan);
		
		this.frame.setTopComponent(this.twoOptionSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			this.currentApplication.getTreeView().getFolder(this.folder.getText()).getFile(this.file.getText()).rename(this.newFile.getText());
			this.currentWindow.getMainIhm().buildJTree();
			this.dispose();
		}
		
	}
	
	

}

