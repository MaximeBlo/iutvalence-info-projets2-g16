package fr.iutvalence.java.s2.projet;

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
	}

	/**
	* Return the representation of the TreeView in the consol
	* @return representation The String of the representation of the treeView
	*/
	@Override
	public String toString()
	{
		String representation = "";
		for(int folderNumber = 0; folderNumber < folderCreated.length; folderNumber++){
			representation+= "- " + folderCreated[folderNumber]+" :\n";
			for(int fileNumber = 0; fileNumber < folderCreated[folderNumber].getNumberOfFile();fileNumber++){
				representation+="--- " + folderCreated[folderNumber].getFile(fileNumber) + "\n";			
			} 
			// TODO Writer the representation in consol of the treeView
		}
		return representation;
	}
	
}
