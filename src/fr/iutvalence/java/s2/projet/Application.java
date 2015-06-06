package fr.iutvalence.java.s2.projet;

import java.io.File;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.Window;

/**
* The main application
* @author MaximeBlo
*/
public class Application{
	
	private TreeView treeView;
	private Generator gen;
	
	private AFile passwordSave;
	
	//TODO J'EN AVAIS JUSTE BESOIN POUR QUE CA COMPIL
	
	private String passphrase="h";

	public Application() {
	    treeView = new TreeView();
	    this.passwordSave = new AFile("password",new Folder("void"));
	}
	
	public void rename(String folder, String newFolder){
		this.treeView.getFolder(folder).rename(newFolder);
		this.saveTreeView();
	}
	
	public void resetPassword(){
		this.passwordSave.delete();
	}
	
	
	public void createFolder(String folder){
		this.treeView.createFolder(folder);
		this.saveTreeView();
	}
	
	public void createFile(String folder, String file){
		this.treeView.createFile(folder,file);
		this.saveTreeView();
	}
	
	public String generatePassword(Attribut attribut){
		gen = new Generator(attribut);
		return gen.generer();
	}
	
	public String getRepresentationOfTreeView(){
		return this.treeView.toString();
	}
	
	public boolean passwordIsVoid(){
		if(this.passwordSave.read(this.passphrase) == ""){
			return true;
		}else
			return false;
	}
	
	public boolean identification(String password){
		if(password.equals(this.passwordSave.read(this.passphrase).substring(47))){
			return true;
		}else
			return false;
	}
	
	public void savePassword(String password){
		this.passwordSave.write(this.generatePassword(new Attribut(47, true, true, true)) + password, this.passphrase);
	}
	
	public void writeInFile(String folder, String file, String text){
		treeView.getFolder(folder).getFile(file).write(text,passphrase);
	}
	
	public String readFile(String folder, String file){
		return treeView.getFolder(folder).getFile(file).read(passphrase); //TODO C'ETAIT LA LE PROBLEME
	}
	
	public void saveTreeView(){
		treeView.saveTreeView();
	}
	
	public void deleteAFile(String folder, String file){
		treeView.getFolder(folder).deleteFile(treeView.getFolder(folder).getFile(file));
	}
	
	public void deleteAFolder(String folder){
		treeView.deleteFolder(treeView.getFolder(folder));
	}
	
	public int getNumberOfFolder(){
		return this.treeView.getNumberOfFolder();	
	}
	
	public ArrayList<Folder> getFolders(){
		return this.treeView.getFolder();
	}
	
	public AFile getPasswordFile(){
		return this.passwordSave;
	}
	
	public TreeView getTreeView(){
		return this.treeView;
	}
}
