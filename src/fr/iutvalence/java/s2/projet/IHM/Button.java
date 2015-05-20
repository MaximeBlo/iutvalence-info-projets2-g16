package fr.iutvalence.java.s2.projet.IHM;

import fr.iutvalence.java.s2.projet.Position;

/**
 * Simple button, used to start an action
 * @author Tutur
 *
 */
public class Button {
	
	/**
	 * button's position in the window
	 */
	private Position position;
	/**
	 * button's width
	 */
	private int width;
	/**
	 * button's height
	 */
	private int height;
	
	/**
	 * Create a button
	 * @param position : button's position in the window
	 * @param width : button's width 
	 * @param height : button's height
	 */
	public Button(Position position, int width, int height){
		this.position = position;
		this.height = height;
		this.width = width;
	}
	
	

}
