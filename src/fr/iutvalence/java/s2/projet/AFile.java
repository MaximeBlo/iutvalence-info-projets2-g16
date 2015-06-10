package fr.iutvalence.java.s2.projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used as a file, containing String.
 * @author MaximeBlo
 *
 */
public class AFile {

	/**
	 * File's name.
	 */
	private String name;
	/**
	 * Number of character contained in the file.
	 */
	private int numberOfChar;
	
	/**
	 * The file were store the text.
	 */
	private File file;
	
	private Encryption encryption = new Encryption();
	
	/**
	 * Create a file.
	 * @param name : file's name
	 * @param parentFolder 
	 */
	public AFile(String name, Folder parentFolder){
		this.name = name;
		this.file = new File(name);
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Rename a file. 
	 * @param name : new file's name
	 */
	public void rename(String name){
		this.name = name;
		this.file.renameTo(new File(name));
		//this.parentFolder.addFile(this);
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
	 * Get the number of character in the file.
	 * @return the number of character 
	 */
	
	public int getNumberOfChar(){
		return this.numberOfChar;
	}
	
	
	/**
	 * Read the file.
	 * @param passphrase 
	 * @return String of the file
	 */
	public String read(String passphrase){
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
		
		return this.encryption.decrypt(text, passphrase);	
	}
	
	
	/**
	 * To rewrite in a file.
	 * @param text the text to write
	 * @param passphrase 
	 */
	public void reWrite(String text, String passphrase){
		
		FileWriter fileWrite = null;
		try {
			fileWrite = new FileWriter(this.file,true);
			fileWrite.write(this.encryption.encrypt(text, passphrase));
			fileWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * To write in a file.
	 * @param text the text to write
	 * @param passphrase 
	 */
	public void write(String text, String passphrase){
		
		FileWriter fileWrite = null;
		try {
			fileWrite = new FileWriter(this.file,false);
			fileWrite.write(this.encryption.encrypt(text, passphrase));
			fileWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * To Delete a file.
	 */
	public void delete(){
		this.file.delete();
	}
	
	/**
	 * To get a file.
	 * @return the file
	 */
	public File getFile(){
		return this.file;
	}
}
