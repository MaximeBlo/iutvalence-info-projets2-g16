package fr.iutvalence.java.s2.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class TreeView used to navigate between files and folder thanks to nodes.
 * @author Tutur
 *
 */
public class TreeView {
	
	
	/**
	* Array of file in the TreeView.
	*/
	private ArrayList<Folder> folderCreated;
	
	/**
	 * Number of folder in the TreeView.
	 */
	private int numberOfFolders;
	
	/**
	 * the treeView save in this file.
	 */
	private File treeViewFile;
	
	/**
	 * Create a TreeView .
	 * @param position : TreeView's position in the window
	 * @param width : TreeView's width
	 * @param height : TreeView's height
	 */
	public TreeView()
	{
		this.numberOfFolders = 0;
		this.folderCreated = new ArrayList<Folder>();
		this.treeViewFile = new File("save");
		
		this.reconstructionTreeView();
	}

	/**
	* Return the representation of the TreeView in the console.
	* @return representation The String of the representation of the treeView
	*/
	@Override
	public String toString()
	{
		String representation = "Arborescence: \n";
		for(int folderNumber = 0; folderNumber < this.numberOfFolders; folderNumber++){
			representation+= "- " + this.folderCreated.get(folderNumber).getName()+" :\n";
			for(int fileNumber = 0; fileNumber < this.folderCreated.get(folderNumber).getNumberOfFile();fileNumber++){
				representation+="--- " + this.folderCreated.get(folderNumber).getFile().get(fileNumber) + "\n";			
			} 
		}
		return representation;
	}
	
	/**
	 * Create a file.
	 * @param folder 
	 * @param file 
	 * @return true if create done and false if there is no folder with this name
	 */
	public boolean createFile(String folder, String file){
		for(int numberOfFolder = 0; numberOfFolder < this.numberOfFolders; numberOfFolder++){
			if(this.folderCreated.get(numberOfFolder).getName().equals(folder)){
				this.folderCreated.get(numberOfFolder).addFile(new AFile(file,this.getFolder(folder)));
				return true;
			}
		}
		
		System.out.println("Nothing folder with this name...");
		return false;
	}
	
	
	/**
	 * Create new folder.
	 * @param folder 
	 * @param name the name of the folder
	 */
	public void createFolder(String folder){
		this.folderCreated.add(new Folder(folder));
		this.numberOfFolders++;
	}
	
	
	/**
	 * Add folder.
	 * @param name the name of the folder
	 */
	public void addFolder(String name){
		
		this.folderCreated.add(new Folder(name));
		this.numberOfFolders++;
	}
	
	/**
	 * Delete a folder and all file in this folder.
	 * @param folderToDelete the folder to delete
	 */
	public void deleteFolder(Folder folderToDelete){
		int folderNumber = 0;
		
		while(!(this.folderCreated.get(folderNumber).equals(folderToDelete))){
			folderNumber++;
		}
		
		for(int indexOfAFile = this.folderCreated.get(folderNumber).getNumberOfFile() - 1; indexOfAFile >= 0; indexOfAFile--){
			this.folderCreated.get(folderNumber).deleteFile(this.folderCreated.get(folderNumber).getFile().get(indexOfAFile));
		}
		
		this.folderCreated.remove(folderNumber);
		this.numberOfFolders--;
	}
	/**
	 * Save the TreeView in a textFile.
	 */
	public void saveTreeView(){
		try {
			FileWriter saveFile = new FileWriter(this.treeViewFile);
			
			for(int numberOfFolder = 0; numberOfFolder < this.numberOfFolders;numberOfFolder++){
				saveFile.write(this.folderCreated.get(numberOfFolder).getName() + (char)32 + this.folderCreated.get(numberOfFolder).getNumberOfFile() + "\n");
				for(int numberOfFile = 0; numberOfFile < (this.folderCreated.get(numberOfFolder).getNumberOfFile()); numberOfFile++){
					saveFile.write(this.folderCreated.get(numberOfFolder).getFile().get(numberOfFile).toString() + "\n");
				}
			}
			
			saveFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Get folderCreated.
	 * @return folderCreated
	 */
	public ArrayList<Folder> getFolder(){
		return this.folderCreated;
	}
	
	/**
	 * Get a folder with his name.
	 * @param folderName the name of the folder searched
	 * @return the folder searched.
	 */
	public Folder getFolder(String folderName){
		Folder folderFind = null;
		
		for(int numberOfFolder = 0; numberOfFolder < this.numberOfFolders;numberOfFolder++){
			if(this.folderCreated.get(numberOfFolder).getName().equals(folderName)){
				folderFind = this.folderCreated.get(numberOfFolder);
			}
		}
		
		return folderFind;
	}
	
	/**
	 * Reconstruct the TreeView at the launch of application.
	 */
	public void reconstructionTreeView(){
		
		FileReader recuperationFileSave = null;
		String[] partsOfSave = new String[300];
		String folderName;
		int fileIndex;
		int numberOfFileInFolder;
		
		try {
			recuperationFileSave = new FileReader("save");
			BufferedReader bufferFile = new BufferedReader(recuperationFileSave);
			int indexOfParts = 0;
			fileIndex =0;
			String line = bufferFile.readLine();
			
			while(line != null){ 
				partsOfSave[indexOfParts] = line;
				line = bufferFile.readLine();
				indexOfParts++;
			}
			while(partsOfSave[fileIndex] != null){
				folderName = partsOfSave[fileIndex].substring(0, partsOfSave[fileIndex].indexOf(' '));
				this.addFolder(folderName);
				numberOfFileInFolder = partsOfSave[fileIndex].charAt((partsOfSave[fileIndex].indexOf(' '))+1)-48;
				
				
				int numberOfFile = 0;
				
				while(numberOfFileInFolder > 0){
					this.getFolder(folderName).addFile(new AFile(partsOfSave[numberOfFile+1+fileIndex],this.getFolder(folderName)));
					numberOfFileInFolder--;
					numberOfFile++;
				}
				
				fileIndex += numberOfFile+1;
				
			}
			
			bufferFile.close();
		} catch (FileNotFoundException e) {
			this.numberOfFolders = 0;
			this.folderCreated = new ArrayList<Folder>();
			this.treeViewFile = new File("save");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the number of folder in the TreeView.
	 * @return the number of folder.
	 */
	public int getNumberOfFolder(){
		return this.numberOfFolders;
	}

	
}
