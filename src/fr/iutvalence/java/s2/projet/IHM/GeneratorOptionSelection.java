package fr.iutvalence.java.s2.projet.IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.java.s2.projet.Application;
import fr.iutvalence.java.s2.projet.Attribut;

/**
 * Generator Option selection.
 * @author Elisa
 *
 */
public class GeneratorOptionSelection extends JFrame implements ActionListener, ItemListener{

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;
		private JSplitPane mainSplitSpan;
		private JLabel description;
		private JCheckBox upperCase;
		private JCheckBox specialChar;
		private JCheckBox number;
		private JSplitPane secondSplitPan;
		private JSplitPane thirdSplitPan;
		private JPanel optionPanel;
		private JButton check;
		private JTextField generatedPassword;
		private Application currentApplication;
		private JTextField length;
		private JSplitPane lengthPassword;
		private boolean upper;
		private boolean special;
		private boolean numb;
		
		/**
		 * Generator option selection's constructor.
		 * @param application
		 */
		public GeneratorOptionSelection(Application application){
			
			this.currentApplication = application;
			
			this.setTitle("Generate a password");
			this.setSize(1300, 700);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			
			this.mainSplitSpan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			this.secondSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			this.thirdSplitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			
			this.generatedPassword = new JTextField();
			
			this.mainSplitSpan.setDividerSize(0);
			this.secondSplitPan.setDividerSize(0);
			this.thirdSplitPan.setDividerSize(0);
			
			this.secondSplitPan.setDividerLocation(500);
			
			this.description = new JLabel("Choose options");
			this.optionPanel = new JPanel();
			this.check = new JButton("Generate");
			
			this.check.addActionListener(this);
			
			this.upperCase = new JCheckBox("UpperCase");
			this.specialChar = new JCheckBox("Special Character (',/,-,(,) ...) ");
			this.number = new JCheckBox("Number");

			
			
			this.length = new JTextField();
			this.lengthPassword = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			
			this.lengthPassword.setBottomComponent(this.length);
			this.lengthPassword.setTopComponent(new JLabel("Length of the password:"));
			this.lengthPassword.setDividerSize(0);
			this.lengthPassword.setDividerLocation(200);
			
			this.upperCase.addItemListener(this);
			this.specialChar.addItemListener(this);
			this.number.addItemListener(this);
			
	
			
			this.mainSplitSpan.setBottomComponent(this.secondSplitPan);
			this.mainSplitSpan.setTopComponent(this.description);
			
			this.secondSplitPan.setTopComponent(this.thirdSplitPan);
			this.secondSplitPan.setBottomComponent(this.check);
			
			
			this.thirdSplitPan.setDividerLocation(400);
			
			this.thirdSplitPan.setTopComponent(this.optionPanel);
			this.thirdSplitPan.setBottomComponent(this.generatedPassword);
			
			
			this.optionPanel.setLayout(new GridLayout(1,3));
			
			this.optionPanel.add(this.upperCase);
			this.optionPanel.add(this.specialChar);
			this.optionPanel.add(this.number);
			this.optionPanel.add(this.lengthPassword);
			
			this.getContentPane().add(this.mainSplitSpan);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source == this.check){
				this.generatedPassword.setText(this.currentApplication.generatePassword(new Attribut(Integer.parseInt(this.length.getText()),this.special,this.upper,this.numb)));
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object source = e.getItemSelectable();
			
			if(source == this.number){
				if(e.getStateChange() == ItemEvent.DESELECTED){
					this.numb = false;
				}else{
					this.numb = true;
				}
			}
			
			if(source == this.upperCase){
				if(e.getStateChange() == ItemEvent.DESELECTED){
					this.upper = false;
				}else{
					this.upper = true;
				}
			}
			
			if(source == this.specialChar){
				if(e.getStateChange() == ItemEvent.DESELECTED){
					this.special = false;
				}else{
					this.special = true;
				}
			}
			
		}
		
}
