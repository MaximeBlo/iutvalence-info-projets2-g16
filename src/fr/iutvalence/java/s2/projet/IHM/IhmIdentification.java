package fr.iutvalence.java.s2.projet.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;

import fr.iutvalence.java.s2.projet.Application;

/**
 * IHM identification.
 * @author Elisa
 *
 */
public class IhmIdentification extends JPanel implements ActionListener{

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	private JLabel title;
	
	private JSplitPane mainSplit;
	
	private JSplitPane secondSplit;
	
	private JPasswordField password;
	
	private JButton validate;
	
	private Window currentWindow;
	
	private Application currentApplication;
	
	/**
	 * Ihm's constructor.
	 * @param window
	 * @param app
	 */
	public IhmIdentification(Window window, Application app){
		
		this.currentWindow = window;
		this.currentApplication = app;
		
		this.setLayout(new BorderLayout());
		
		this.secondSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.secondSplit.setDividerSize(0);
		this.secondSplit.setEnabled(false);
		
		this.title = new JLabel();
		
		if(this.currentApplication.passwordIsVoid()){
			this.title.setText("Choose your password");
		}else
			this.title.setText("Enter your password");
		
		this.password = new JPasswordField();
		
		this.secondSplit.setBottomComponent(this.password);
		this.secondSplit.setTopComponent(this.title);
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.mainSplit.setDividerSize(0);
		this.mainSplit.setEnabled(false);
		
		this.mainSplit.setBottomComponent(this.validate);
		this.mainSplit.setTopComponent(this.secondSplit);
		
		this.add(this.mainSplit);
		this.setBackground(new Color(0,255,0));
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			
			//System.out.println(this.currentApplication.getPasswordFile().read("h").substring(47));
			
			if(this.currentApplication.passwordIsVoid()){
				this.currentApplication.savePassword(String.copyValueOf(this.password.getPassword()));
				this.currentWindow.changeIhm();
			}else{
				if(this.currentApplication.identification(String.copyValueOf(this.password.getPassword()))){
					this.currentWindow.changeIhm();
				}else
					this.title.setText("Wrong password... Enter the right one:");
			}
		}
		
	}
}
