package fr.iutvalence.java.s2.projet;

/**
 * Class used as a file, containing String.
 * @author Tutur
 *
 */
public class File {

	/**
	 * file's name
	 */
	private String name;
	/**
	 * number of character contained in the file
	 */
	private int numberOfChar;
	
	/**
	 * Create a file
	 * @param name : file's name
	 */
	public File(String name){
		this.name = name;
	}
	
	/**
	 * Rename a file 
	 * @param name : new file's name
	 */
	public void rename(String name){
		this.name = name;
	}
	
}
