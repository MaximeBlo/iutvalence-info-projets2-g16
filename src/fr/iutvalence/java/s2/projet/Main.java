package fr.iutvalence.java.s2.projet;

import java.util.Currency;
import java.util.Scanner;

import fr.iutvalence.java.s2.projet.IHM.Window;

public class Main {

	public static Application currentApplication;
	
		public static void main(String[] args){
			
			currentApplication = new Application();
			Scanner choiceSwitch;
			
			Window application = new Window(currentApplication);
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
			
			int choix = 0;
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
						currentApplication.createFolder();
						break;
					case 2:
						currentApplication.createFile();
						break;
					case 3:
						System.out.println(currentApplication.generatePassword());
						break;
					case 4:
						System.out.println(currentApplication.getRepresentationOfTreeView());
						break;
					case 5:
						currentApplication.writeInFile();
						break;
					case 6:
						currentApplication.readFile();
						break;
					case 7:
						currentApplication.saveTreeView();
						break;
					case 8:
						currentApplication.deleteAFile();
						break;
					case 9:
						currentApplication.deleteAFolder();
						break;
				}
				
				
			}while(choix != 0);
			
			choiceSwitch.close();
			
		}
}
