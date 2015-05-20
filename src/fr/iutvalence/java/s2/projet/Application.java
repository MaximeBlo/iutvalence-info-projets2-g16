package fr.iutvalence.java.s2.projet;
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
		Generateur gen = new Generateur(new Attribut(10,false,false,false));
		
		System.out.println(gen.generer());
		
	} 
}
