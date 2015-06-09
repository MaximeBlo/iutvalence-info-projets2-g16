package fr.iutvalence.java.s2.projet.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;

public class DeleteFile extends JFrame implements ActionListener{

	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane twoOptionSplitPan;
	
	private JSplitPane nameOfFolderSplitPan;
	
	private JSplitPane nameOfFileSplitPan;
	
	private JLabel nameOfFile;
	
	private JLabel nameOfFolder;
	
	private JTextField file;
	
	private JTextField folder;
	
	private JButton validate;
	
	private Window currentWindow;
	
	public DeleteFile(Application application, Window window){
		this.currentApplication = application;
		
		this.currentWindow = window;
		
		this.setTitle("Delete a file");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.frame.setDividerSize(0);
		this.frame.setEnabled(false);
		
		this.twoOptionSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.twoOptionSplitPan.setDividerSize(0);
		this.twoOptionSplitPan.setEnabled(false);
		
		this.nameOfFileSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.nameOfFileSplitPan.setDividerSize(0);
		this.nameOfFileSplitPan.setEnabled(false);
		
		this.nameOfFolderSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.nameOfFolderSplitPan.setDividerSize(0);
		this.nameOfFolderSplitPan.setEnabled(false);
		
		this.nameOfFile = new JLabel("Name of file:");
		
		this.nameOfFolder = new JLabel("Name of folder:");
		
		this.file = new JTextField();
		
		this.folder = new JTextField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.nameOfFileSplitPan.setTopComponent(this.nameOfFile);
		this.nameOfFileSplitPan.setBottomComponent(this.file);
		
		this.nameOfFolderSplitPan.setTopComponent(this.nameOfFolder);
		this.nameOfFolderSplitPan.setBottomComponent(this.folder);
		
		this.twoOptionSplitPan.setTopComponent(this.nameOfFolderSplitPan);
		this.twoOptionSplitPan.setBottomComponent(this.nameOfFileSplitPan);
		
		this.frame.setTopComponent(this.twoOptionSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			this.nameOfFolder.setText("Name of folder:");
			this.nameOfFile.setText("Name of file:");
			if(this.currentApplication.getTreeView().getFolder(this.folder.getText()) == null){
				this.nameOfFolder.setText("There is no folder with this name, try another name: ");
			}else if(this.currentApplication.getTreeView().getFolder(this.folder.getText()).getFile(this.file.getText()) == null){
				this.nameOfFile.setText("There is no file with this name, try another name : ");
			}else{
				this.currentApplication.deleteAFile(this.folder.getText(), this.file.getText());
				this.currentWindow.getMainIhm().buildJTree();
				this.dispose();
			}
		}
		
	}
	
	

}