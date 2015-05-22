package fr.iutvalence.java.s2.projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	 * The parent folder of the file.
	 */
	private Folder parentFolder;
	
	/**
	 * Create a file
	 * @param name : file's name
	 */
	public AFile(String name, Folder parentFolder){
		this.name = name;
		this.file = new File(name);
		this.parentFolder = parentFolder;
		this.fileInitialization();
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
		return this.name;
	}
	
	/**
	 * get the number of character in the file.
	 * @return the number of character 
	 */
	
	public int getNumberOfChar(){
		return this.numberOfChar;
	}
	
	/**
	 * Read the file.
	 * @return String of the file
	 */
	public String read(){
		String text ="";
		FileReader fileRead = null;
		try {
			fileRead = new FileReader(this.file);
			while(fileRead.ready()){
				text += (char)fileRead.read();
			}
			fileRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;	
	}
	
	/**
	 * To show a file.
	 * @param text
	 */
	public void write(String[] text){
		
		FileWriter fileWrite = null;
		String[] textToWrite = new String[text.length+1];
		for(int lineInText = 0; lineInText < text.length; lineInText++){
			textToWrite[lineInText+1] = text[lineInText];
		}
		textToWrite[0] = this.read();
		try {
			fileWrite = new FileWriter(this.file);
			for(int textIndex = 0; textIndex < text.length;textIndex++){
				fileWrite.write(String.valueOf(textToWrite[textIndex]));
			}
			fileWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileInitialization(){
		FileWriter fileWrite = null;
		try {
			fileWrite = new FileWriter(this.file);
			fileWrite.write(String.valueOf(this.parentFolder.getName()+ "\n"));
			fileWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
