package fr.iutvalence.java.s2.projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class used as a file, containing String.
 * @author Tutur
 *
 */
public class AFile {

	/**
	 * file's name
	 */
	private String name;
	/**
	 * number of character contained in the file
	 */
	private int numberOfChar;
	
	/**
	 * The file were store the text.
	 */
	private File file;
	
	/**
	 * Create a file
	 * @param name : file's name
	 */
	public AFile(String name){
		this.name = name;
		this.file = new File(name);
	}
	
	/**
	 * Rename a file 
	 * @param name : new file's name
	 */
	public void rename(String name){
		this.name = name;
		this.file.renameTo(new File(name));
	}

	/**
	* Return the name of the file.
	* @return name The name of the file
	*/
	@Override
	public String toString()
	{
		return name;
	}
	
	/**
	 * get the number of character in the file.
	 * @return the number of character 
	 */
	
	public int getNumberOfChar(){
		return this.numberOfChar;
	}
	
	public String read(){
		String text ="";
		FileReader fileRead = null;
		try {
			fileRead = new FileReader(this.file);
			text += fileRead.read();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
		
	}
}
