package fr.iutvalence.java.s2.projet;

import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.Window;

/**
* The main application
* @author MaximeBlo
*/
public class Application{
	
	private Editor editor;
	private TreeView treeView;
	private Generator gen;

	public Application() {
		editor = new Editor();
	    treeView = new TreeView();
	}
	
	
	public void createFolder(){
		this.treeView.createFolder();
	}
	
	public void createFile(){
		this.treeView.createFile();
	}
	
	public String generatePassword(Attribut attribut){
		gen = new Generator(attribut);
		return gen.generer();
	}
	
	public String getRepresentationOfTreeView(){
		return this.treeView.toString();
	}
	
	public void writeInFile(){
		System.out.println("What is the name of the folder? \n");
		Scanner nameF = new Scanner(System.in);
		String nameFolder = nameF.nextLine();
		System.out.println("What is the name of the file? \n");
		String nameFile = nameF.nextLine();
		System.out.println("What is the text to write? \n");
		String text = new String();
		text = nameF.nextLine();
		
		treeView.getFolder(nameFolder).getFile(nameFile).reWrite(text + "\n");
	}
	
	public String readFile(){
		System.out.println("What is the name of the folder? \n");
		Scanner nameF = new Scanner(System.in);
		String nameFold = nameF.nextLine();
		System.out.println("What is the name of the file? \n");
		String nameFil = nameF.nextLine();
		
		return treeView.getFolder(nameFold).getFile(nameFil).read();
	}
	
	public void saveTreeView(){
		treeView.saveTreeView();
	}
	
	public void deleteAFile(){
		System.out.println("What is the name of the folder? \n");
		Scanner nameF = new Scanner(System.in);
		String nameofFolder = nameF.nextLine();
		System.out.println("What is the name of the file? \n");
		String nameofFile = nameF.nextLine();
		treeView.getFolder(nameofFolder).deleteFile(treeView.getFolder(nameofFolder).getFile(nameofFile));
	}
	
	public void deleteAFolder(){
		System.out.println("What is the name of the folder? \n");
		Scanner nameF = new Scanner(System.in);
		String nameofFolderToDelete = nameF.nextLine();
		treeView.deleteFolder(treeView.getFolder(nameofFolderToDelete));
	}
	
}
