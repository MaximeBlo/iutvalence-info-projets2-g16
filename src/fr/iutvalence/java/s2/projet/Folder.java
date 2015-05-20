package fr.iutvalence.java.s2.projet;

import java.util.Scanner;

/**
 * Class folder used to contain one or many files.
 * @author Tutur
 *
 */
public class Folder {
	
	/**
	 * Folder's name
	 */
	private String name;
	/**
	 * Number of file contained in the folder
	 */
	private int numberOfFile;
	/**
	 * Array containing all the files
	 */
	private File[] file;
	
	/**
	 * Create a folder 
	 * @param name : name of the created folder
	 */
	public Folder(String name){
		this.name = name;
		numberOfFile = 0;
		file = new File[100];
	}
	
	/**
	 * Add a file to the folder
	 * @param fileToAdd : file to add to the folder
	 */
	public void addFile(File fileToAdd){
		file[numberOfFile] = fileToAdd;
		numberOfFile++;
	}
	
	/**
	 * Delete a file from a folder
	 * @param fileToDelete : file to be deleted
	 */
	public void deleteFile(File fileToDelete){
		int fileNumber = 0;
		
		while(!(fileToDelete.equals(file[fileNumber]))){
			fileNumber++;
		}
		
		if(fileNumber != numberOfFile){
			while(fileNumber != numberOfFile){
				file[fileNumber] = file[fileNumber+1];
			}
		}
	}
	
	/**
	 * Rename a folder
	 * @param name : new folder's name
	 */
	public void rename(String name){
		this.name = name;
	}
	
	/**
	* Return the number of file in the folder.
	* @return numberOfFile  the number of file ine the folder
	*/
	public int getNumberOfFile(){
		return numberOfFile;
	}
	
	/**
	* return the file on the number fileNumber.
	* @return file[fileNumber] the file to return
	*/
	public File getFile(int fileNumber){
		return file[fileNumber];
	}

	
	/**
	* Return the name of the folder.
	* @return name The name of the folder
	*/
	public String getName()
	{
		return name;
	}
	
	
}
