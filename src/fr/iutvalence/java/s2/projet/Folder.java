package fr.iutvalence.java.s2.projet;

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
}
