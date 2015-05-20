package fr.iutvalence.java.s2.projet;

import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.TreeView;

/**
* The main application
* @author MaximeBlo
*/
public class Application{
	
	/**
	* Main
	*/
	public static void main(String args[]){
		
		Editor editor = new Editor(new Position(20,20),20,20);
		TreeView treeView = new TreeView(new Position(0,0),20,20);
		Generator gen = new Generator(new Attribut(10,true,true,true));
		
		System.out.println(gen.generer());
		
		treeView.addFolder("toto");
		treeView.createFile();
		System.out.println(treeView);
	} 
	
}
