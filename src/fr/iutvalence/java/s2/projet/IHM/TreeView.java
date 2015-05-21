package fr.iutvalence.java.s2.projet.IHM;

import java.util.Scanner;

import fr.iutvalence.java.s2.projet.AFile;
import fr.iutvalence.java.s2.projet.Folder;
import fr.iutvalence.java.s2.projet.Position;

/**
 * Class TreeView used to navigate between files and folder thanks to nodes
 * @author Tutur
 *
 */
public class TreeView {
	
	/**
	 * TreeView's position in the window
	 */
	private Position position;
	/**
	 * TreeView's width
	 */
	private int width;
	/**
	 * TreeView's height
	 */
	private int height;
	
	/**
	* Array of file in the TreeView
	*/
	private Folder[] folderCreated;
	
	/**
	 * Number of folder in the TreeView
	 */
	private int numberOfFolders;
	
	/**
	 * Create a TreeView 
	 * @param position : TreeView's position in the window
	 * @param width : TreeView's width
	 * @param height : TreeView's height
	 */
	public TreeView(Position position, int width, int height)
	{
		this.position = position;
		this.width = width;
		this.height = height;
		this.numberOfFolders = 0;
		this.folderCreated = new Folder[100];
	}

	/**
	* Return the representation of the TreeView in the consol
	* @return representation The String of the representation of the treeView
	*/
	@Override
	public String toString()
	{
		String representation = "Arborescence: \n";
		for(int folderNumber = 0; folderNumber < this.numberOfFolders; folderNumber++){
			representation+= "- " + this.folderCreated[folderNumber].getName()+" :\n";
			for(int fileNumber = 0; fileNumber < this.folderCreated[folderNumber].getNumberOfFile();fileNumber++){
				representation+="--- " + this.folderCreated[folderNumber].getFile(fileNumber) + "\n";			
			} 
			// TODO Writer the representation in consol of the treeView
		}
		return representation;
	}
	
	/**
	 * Create a file.
	 * @return true if create done and false if there is no folder with this name
	 */
	public boolean createFile(){
		System.out.println(this + "\n\n\n");
		
		Scanner name = new Scanner(System.in);
		System.out.println("Type the name of the folder");
		String folderName = name.nextLine();
		System.out.println("Type the name of the file");
		String fileName = name.nextLine();
		for(int numberOfFolder = 0; numberOfFolder < this.numberOfFolders; numberOfFolder++){
			if(this.folderCreated[numberOfFolder].getName().equals(folderName)){
				this.folderCreated[numberOfFolder].addFile(new AFile(fileName));
				System.out.println("The file " + fileName + " has been created in the folder: " + folderName);
				return true;
			}
		}
		
		System.out.println("Nothing folder with this name...");
		return false;
	}
	
	
	/**
	 * Add folder.
	 * @param name the name of the folder
	 */
	public void addFolder(String name){
		this.folderCreated[numberOfFolders] = new Folder(name);
		this.numberOfFolders++;
		System.out.println(this + "\n\n\n");
	}
	
}
