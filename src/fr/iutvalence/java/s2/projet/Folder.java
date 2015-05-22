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
	private AFile[] file;
	
	/**
	 * Create a folder 
	 * @param name : name of the created folder
	 */
	public Folder(String name){
		this.name = name;
		this.numberOfFile = 0;
		this.file = new AFile[100];
	}
	
	/**
	 * Add a file to the folder
	 * @param fileToAdd : file to add to the folder
	 */
	public void addFile(AFile fileToAdd){
		this.file[this.numberOfFile] = fileToAdd;
		this.numberOfFile++;
	}
	
	/**
	 * Delete a file from a folder
	 * @param fileToDelete : file to be deleted
	 */
	public void deleteFile(AFile fileToDelete){
		int fileNumber = 0;
		
		while(!(fileToDelete.equals(this.file[fileNumber]))){
			fileNumber++;
		}
		
		if(fileNumber != this.numberOfFile){
			while(fileNumber != this.numberOfFile){
				this.file[fileNumber] = this.file[fileNumber+1];
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
		return this.numberOfFile;
	}
	
	/**
	* return the file on the number fileNumber.
	* @return file[fileNumber] the file to return
	*/
	public AFile[] getFile(){
		return this.file;
	}
	
	public AFile getFile(String fileName){
		AFile fileFound = null;
		
		for(int numberOfFile = 0; numberOfFile < this.numberOfFile;numberOfFile++){
			if(this.file[numberOfFile].toString().equals(fileName)){
				fileFound = this.file[numberOfFile];
			}
		}
		
		return fileFound;
	}

	
	/**
	* Return the name of the folder.
	* @return name The name of the folder
	*/
	public String getName()
	{
		return this.name;
	}
	
	
}
