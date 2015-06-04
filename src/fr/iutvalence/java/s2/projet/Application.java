package fr.iutvalence.java.s2.projet;

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

	public Application() {
	    treeView = new TreeView();
	}
	
	
	public void createFolder(){
		this.treeView.createFolder();
		this.saveTreeView();
	}
	
	public void createFile(){
		this.treeView.createFile();
		this.saveTreeView();
	}
	
	public String generatePassword(Attribut attribut){
		gen = new Generator(attribut);
		return gen.generer();
	}
	
	public String getRepresentationOfTreeView(){
		return this.treeView.toString();
	}
	
	public void writeInFile(String folder, String file, String text){
		treeView.getFolder(folder).getFile(file).write(text);
	}
	
	public String readFile(String folder, String file){
		return treeView.getFolder(folder).getFile(file).read();
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
}
