package fr.iutvalence.java.s2.projet;

/**
 * Class used to contain a file and change the content of it. Mostly used as a text editor
 * @author Tutur
 *
 */
public class Editor {

	/**
	 * file loaded and displayed in the editor
	 */
	private File fileLoaded;
	/**
	 * editor's position in the window
	 */
	private Position position;
	/**
	 * editor's width
	 */
	private int width;
	/**
	 * editor's height
	 */
	private int height;
	
	/**
	 * Create an editor
	 * @param position : editor's position in the window
	 * @param width : editor's height
	 * @param height : editor's width
	 */
	public Editor(Position position, int width, int height){
		this.position = position;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * Used to open a file
	 * @param file : file you want to open
	 */
	public void openFile(File fileToOpen){
		
	}
	
	/**
	 * Used to save a file
	 * @param file : file you want to save
	 */
	public void saveFile(File fileToSave){
		
	}
	
	
}
