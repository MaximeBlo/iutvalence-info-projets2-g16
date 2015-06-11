package fr.iutvalence.java.s2.projet;

import java.util.ArrayList;

/**
* The main application.
* @author MaximeBlo
*/
public class Application{
	
	private TreeView treeView;
	private Generator gen;
	
	private AFile passwordSave;
	
	private String passphrase="h";

	/**
	 * Application's constructor .
	 */
	public Application() {
	    this.treeView = new TreeView();
	    this.passwordSave = new AFile("password",new Folder("void"));
	}
	
	/**
	 * Setter passphrase.
	 * @param passphrase
	 */
	public void setPassphrase(String passphrase){
		this.passphrase=passphrase;
	}
	
	/**
	 * A method to rename a folder.
	 * @param folder
	 * @param newFolder
	 */
	public void rename(String folder, String newFolder){
		this.treeView.getFolder(folder).rename(newFolder);
		this.saveTreeView();
	}
	
	/**
	 *A method to delete the password saved.
	 */
	public void resetPassword(){
		this.passwordSave.delete();
	}
	
	
	/**
	 * A method to create a folder.
	 * @param folder
	 */
	public void createFolder(String folder){
		this.treeView.createFolder(folder);
		this.saveTreeView();
	}
	
	/**
	 * A method to create a file in a given folder.
	 * @param folder
	 * @param file
	 */
	public void createFile(String folder, String file){
		this.treeView.createFile(folder,file);
		this.saveTreeView();
	}
	
	/**
	 * A method to create a password.
	 * @param attribut
	 * @return the password
	 */
	public String generatePassword(Attribut attribut){
		this.gen = new Generator(attribut);
		return this.gen.generer();
	}
	
	/**
	 * A method to get a representation of the tree view.
	 * @return a representation of the tree view
	 */
	public String getRepresentationOfTreeView(){
		return this.treeView.toString();
	}
	
	/**
	 * Test if a password is saved or not.
	 * @return false is a password is saved
	 */
	public boolean passwordIsVoid(){
		if(this.passwordSave.read(this.passphrase) == ""){
			return true;
		}else
			return false;
	}
	
	/**
	 * Test if the given password is the same as the saved password.
	 * @param password
	 * @return true if the password match
	 */
	public boolean identification(String password){
		if(password.equals(this.passwordSave.read(this.passphrase).substring(47))){
			return true;
		}else
			return false;
	}
	
	/**
	 * Save a password given in a crypted password.
	 * @param password
	 */
	public void savePassword(String password){
		this.passwordSave.write(this.generatePassword(new Attribut(47, true, true, true)) + password, this.passphrase);
	}
	
	/**
	 * A method to write in a file.
	 * @param folder
	 * @param file
	 * @param text
	 */
	public void writeInFile(String folder, String file, String text){
		this.treeView.getFolder(folder).getFile(file).write(text,this.passphrase);
	}
	
	/**
	 * A method to read a file in a folder.
	 * @param folder
	 * @param file
	 * @return the file to read
	 */
	public String readFile(String folder, String file){
		return this.treeView.getFolder(folder).getFile(file).read(this.passphrase);
	}
	
	/**
	 * A method to save the tree view.
	 */
	public void saveTreeView(){
		this.treeView.saveTreeView();
	}
	
	/**
	 * A method to delete a file in a folder.
	 * @param folder
	 * @param file
	 */
	public void deleteAFile(String folder, String file){
		this.treeView.getFolder(folder).deleteFile(this.treeView.getFolder(folder).getFile(file));
	}
	
	/**
	 * A method to delete a folder.
	 * @param folder
	 */
	public void deleteAFolder(String folder){
		this.treeView.deleteFolder(this.treeView.getFolder(folder));
	}
	
	/**
	 * A method to count the folder.
	 * @return the number of folder
	 */
	public int getNumberOfFolder(){
		return this.treeView.getNumberOfFolder();	
	}
	
	/**
	 * A method to get a folder.
	 * @return a folder
	 */
	public ArrayList<Folder> getFolders(){
		return this.treeView.getFolder();
	}
	
	/**
	 * Give the saved password for a file.
	 * @return a password
	 */
	public AFile getPasswordFile(){
		return this.passwordSave;
	}
	
	/**
	 * Give the tree view.
	 * @return the tree view
	 */
	public TreeView getTreeView(){
		return this.treeView;
	}
}
