package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;

public class RenameFolder extends JFrame implements ActionListener{
private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane twoOptionSplitPan;
	
	private JSplitPane renameSplitPan;
	
	private JSplitPane nameOfFolderSplitPan;
	
	private JLabel nameOfFolder;
	
	private JLabel renameFolder;
	
	private JTextField folder;
	
	private JTextField rename;
	
	private JButton validate;
	
	private Window currentWindow;
	
	public RenameFolder(Application application, Window window){
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
		
		this.nameOfFolder = new JLabel("Name of file:");
		
		this.renameFolder = new JLabel("Name of folder:");
		
		this.folder = new JTextField();
		
		this.rename = new JTextField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.nameOfFolderSplitPan.setTopComponent(this.nameOfFolder);
		this.nameOfFolderSplitPan.setBottomComponent(this.folder);
		
		this.renameSplitPan.setTopComponent(this.renameFolder);
		this.renameSplitPan.setBottomComponent(this.rename);
		
		this.twoOptionSplitPan.setTopComponent(this.renameSplitPan);
		this.twoOptionSplitPan.setBottomComponent(this.nameOfFolderSplitPan);
		
		this.frame.setTopComponent(this.twoOptionSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			this.currentApplication.rename(this.folder.getText(), this.rename.getText());
			this.currentWindow.getMainIhm().buildJTree();
			this.dispose();
		}
		
	}
	
	

}

