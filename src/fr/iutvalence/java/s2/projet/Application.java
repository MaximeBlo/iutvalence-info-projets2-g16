package fr.iutvalence.java.s2.projet;

import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.TreeView;

/**
* The main application
* @author MaximeBlo
*/
public class Application{
	
	/**
	 * Main.
	 * @param args
	 */
	public static void main(String args[]){
		
		Editor editor = new Editor(new Position(20,20),20,20);
		TreeView treeView = new TreeView(new Position(0,0),20,20);
		Generator gen = new Generator(new Attribut(10,true,true,true));
		
		//System.out.println(gen.generer());
		
		//treeView.addFolder("toto");
		//treeView.createFile();
		
		
		String[] test = new String[1];
		test[0] = "Je suis un abruti";
		treeView.addFolder("toto");
		treeView.getFolder()[0].addFile(new AFile("titi"));
		treeView.getFolder()[0].getFile()[0].write(test);
		
		System.out.println(treeView);
		System.out.println(treeView.getFolder()[0].getFile()[0].read());
		
		int choix = 0;
		do{
			System.out.println("What would you do? \n");
			System.out.println("1. Create a folder");
			System.out.println("2. Create a file");
			System.out.println("3. Generate a password");
			System.out.println("4. Display treeView");
			System.out.println("0. Quit");
			Scanner choiceSwitch = new Scanner(System.in);
			choix = choiceSwitch.nextInt();
			
			switch(choix){
				case 1:
					System.out.println("What is the name of the folder? \n");
					Scanner nameF = new Scanner(System.in);
					String name = nameF.nextLine();
					treeView.addFolder(name);
					break;
				case 2:
					treeView.createFile();
					break;
				case 3:
					System.out.println(gen.generer());
					break;
				case 4:
					System.out.println(treeView);
					break;
			}
		}while(choix != 0);
	} 
	
}
