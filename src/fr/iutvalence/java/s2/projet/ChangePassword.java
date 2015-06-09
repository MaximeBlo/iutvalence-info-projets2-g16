package fr.iutvalence.java.s2.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.IHM.Window;

public class ChangePassword extends JFrame implements ActionListener {

	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane changePasswordSplitPan;
	
	private JSplitPane theCurrentPasswordSplitPan;
	
	private JLabel currentPassword;
	
	private JTextField passwordCurrent;
	
	private JSplitPane theNewPassword;
	
	private JLabel newPassword;
	
	private JTextField passwordNew;
	
	private JButton validate;
	
	private Window currentWindow;
	
	public ChangePassword(Application application, Window window){
		this.currentApplication = application;
		
		this.currentWindow = window;
		
		this.setTitle("Delete folder");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.frame.setDividerSize(0);
		this.frame.setEnabled(false);
		
		this.theCurrentPasswordSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.theCurrentPasswordSplitPan.setDividerSize(0);
		this.theCurrentPasswordSplitPan.setEnabled(false);
		
		this.currentPassword = new JLabel("Name of folder:");
		
		this.passwordCurrent = new JTextField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.theCurrentPasswordSplitPan.setTopComponent(this.currentPassword);
		this.theCurrentPasswordSplitPan.setBottomComponent(this.passwordCurrent);
		
		this.frame.setTopComponent(this.theCurrentPasswordSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			
			if(this.currentApplication.getTreeView().getFolder(this.passwordCurrent.getText()) == null){
				this.currentPassword.setText("This folder doesn't exist ... Type a new name of folder:");
			}else{
				this.currentApplication.deleteAFolder(this.passwordCurrent.getText());
				this.currentWindow.getMainIhm().buildJTree();
				this.dispose();
			}
		}
		
	}
	
}
