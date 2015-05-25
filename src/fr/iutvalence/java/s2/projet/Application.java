package fr.iutvalence.java.s2.projet;

import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.Window;

/**
* The main application
* @author MaximeBlo
*/
public class Application{
	
	private static Scanner choiceSwitch;

	/**
	* Main
	*/
	public static void main(String args[]){
		
		Editor editor = new Editor();
		TreeView treeView = new TreeView();
		Generator gen = new Generator(new Attribut(25,true,true,true));
		
		Window application = new Window();
		//System.out.println(gen.generer());
		
		//treeView.createFile();
		//System.out.println(treeView);
		
		/*String[] test = new String[2];
		test[0] = "Je suis un abruti\n";
		test[1] = "toto";
		treeView.addFolder("toto");
		treeView.getFolder()[0].addFile(new AFile("titi",treeView.getFolder("toto")));*/
		//treeView.getFolder()[0].getFile()[0].write(test);
		
		//System.out.println(treeView);
		//System.out.println(treeView.getFolder()[0].getFile()[0].read());
		
		/*int choix = 0;
		do{
			System.out.println("What would you do? \n");
			System.out.println("1. Create a folder");
			System.out.println("2. Create a file");
			System.out.println("3. Generate a password");
			System.out.println("4. Display treeView");
			System.out.println("5. Write in file");
			System.out.println("6. Read in file");
			System.out.println("7. Save TreeView");
			System.out.println("8. Delete a file");
			System.out.println("9. Delete a folder");
			System.out.println("0. Quit");
			choiceSwitch = new Scanner(System.in);
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
				case 5:
					System.out.println("What is the name of the folder? \n");
					nameF = new Scanner(System.in);
					String nameFolder = nameF.nextLine();
					System.out.println("What is the name of the file? \n");
					String nameFile = nameF.nextLine();
					System.out.println("What is the text to write? \n");
					String text = new String();
					text = nameF.nextLine();
					
					treeView.getFolder(nameFolder).getFile(nameFile).write(text + "\n");
					break;
				case 6:
					System.out.println("What is the name of the folder? \n");
					nameF = new Scanner(System.in);
					String nameFold = nameF.nextLine();
					System.out.println("What is the name of the file? \n");
					String nameFil = nameF.nextLine();
					
					System.out.println(treeView.getFolder(nameFold).getFile(nameFil).read());
					
					break;
				case 7:
					treeView.saveTreeView();
					break;
				case 8:
					System.out.println("What is the name of the folder? \n");
					nameF = new Scanner(System.in);
					String nameofFolder = nameF.nextLine();
					System.out.println("What is the name of the file? \n");
					String nameofFile = nameF.nextLine();
					treeView.getFolder(nameofFolder).deleteFile(treeView.getFolder(nameofFolder).getFile(nameofFile));
					
					break;
				case 9:
					System.out.println("What is the name of the folder? \n");
					nameF = new Scanner(System.in);
					String nameofFolderToDelete = nameF.nextLine();
					treeView.deleteFolder(treeView.getFolder(nameofFolderToDelete));
					
					break;
			}
			
			
		}while(choix != 0);
		
		choiceSwitch.close();*/
	} 
	
}
