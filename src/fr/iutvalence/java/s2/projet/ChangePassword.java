package fr.iutvalence.java.s2.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;

import fr.iutvalence.java.s2.projet.IHM.Window;

/**
 * Change Password.
 * @author Elisa
 *
 */
public class ChangePassword extends JFrame implements ActionListener {

	/**
	 * Serial version  uid.
	 */
	private static final long serialVersionUID = 1L;

	private Application currentApplication;
	
	private JSplitPane frame;
	
	private JSplitPane theCurrentPasswordSplitPan;
	
	private JLabel newPassword;
	
	private JPasswordField passwordNew;
	
	private JButton validate;
	
	private Encryption encrypt;
	
	/**
	 * Change password's constructor.
	 * @param application
	 * @param window
	 */
	public ChangePassword(Application application, Window window){
		this.currentApplication = application;
		
		this.setTitle("Change password");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.frame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.frame.setDividerSize(0);
		this.frame.setEnabled(false);
		
		this.theCurrentPasswordSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.theCurrentPasswordSplitPan.setDividerSize(0);
		this.theCurrentPasswordSplitPan.setEnabled(false);
		
		this.newPassword = new JLabel("New password:");
		
		this.passwordNew = new JPasswordField();
		
		this.validate = new JButton("Validate");
		this.validate.addActionListener(this);
		
		this.theCurrentPasswordSplitPan.setTopComponent(this.newPassword);
		this.theCurrentPasswordSplitPan.setBottomComponent(this.passwordNew);
		
		this.frame.setTopComponent(this.theCurrentPasswordSplitPan);
		this.frame.setBottomComponent(this.validate);
		
		this.getContentPane().add(this.frame);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == this.validate){
			String Ppassword=(String.copyValueOf(this.passwordNew.getPassword()));
			this.currentApplication.resetPassword();
			this.currentApplication.savePassword(this.encrypt.encrypt(Ppassword, Ppassword));
			this.dispose();
			
		}
		
	}
	
}
