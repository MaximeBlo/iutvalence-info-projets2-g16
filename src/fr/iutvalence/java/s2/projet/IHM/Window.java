package fr.iutvalence.java.s2.projet.IHM;

/**
* Window's class (graphical aspect)
* @author MaximeBlo
*/
public class Window
{
	/**
	* window's name
	*/
	private String name;
	
	/**
	* window's width
	*/
	private int width;
	
	/**
	* window's height
	*/
	private int height;
	
	/**
	* window's contructor
	* @param name: the window's name
	* @param width : the window's width
	* @param height : the window's height
	*/
	public Window(String name, int width, int heigth){
		this.name = name;
		this.width = width;
		this.height = heigth;
	}
	
	/**
	* method to close the window
	*/
	public void fermer(){
		
	}
}
