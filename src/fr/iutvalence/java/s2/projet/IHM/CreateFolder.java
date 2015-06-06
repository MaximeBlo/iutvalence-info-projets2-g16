package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;

public class CreateFolder extends JFrame implements ActionListener {
	
	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane nameOfFolderSplitPan;
	
	private JLabel nameOfFolder;
	
	private JTextField folder;
	
	private JButton validate;
	
	private Window currentWindow;
	
	public CreateFolder(Application application, Window window){
		this.currentApplication = application;
		
		this.currentWindow = window;
		
		this.setTitle("Create a file");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.frame.setDividerSize(0);
		this.frame.setEnabled(false);
		
		this.nameOfFolderSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.nameOfFolderSplitPan.setDividerSize(0);
		this.nameOfFolderSplitPan.setEnabled(false);
		
		this.nameOfFolder = new JLabel("Name of folder:");
		
		this.folder = new JTextField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.nameOfFolderSplitPan.setTopComponent(this.nameOfFolder);
		this.nameOfFolderSplitPan.setBottomComponent(this.folder);
		
		this.frame.setTopComponent(this.nameOfFolderSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			
			if(this.currentApplication.getTreeView().getFolder(this.folder.getText()) != null){
				this.nameOfFolder.setText("This folder already exist ... Type a new name of folder:");
			}else{
				this.currentApplication.createFolder(this.folder.getText());
				this.currentWindow.getMainIhm().buildJTree();
				this.dispose();
			}
		}
		
	}
	
	

}
