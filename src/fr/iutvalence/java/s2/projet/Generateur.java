package fr.iutvalence.java.s2.projet;

import java.net.PasswordAuthentication;

public class Generateur
{
	private Attribut attribut;
	
	public Generateur(){
		this.attribut = new Attribut();	
	}
	
	public Generateur(Attribut attribut){
		this.attribut=attribut;
	}
	
	public String generer(){
		
		String passwordGenerate = "";
		
		for(int numberOfCharacter = 0; numberOfCharacter < attribut.getLength();numberOfCharacter++){
			int random = (int) (Math.random()*400);
		
			if(random < 100 && this.attribut.getCaracSpeciaux()){
				passwordGenerate += generateSpec();
			} else if(random >= 100 && random < 200 && this.attribut.getMajuscule()){
				passwordGenerate += generateMaj();
			} else if(random >= 200 && random < 300 && this.attribut.getNombre()){
				passwordGenerate += generateInt();
			}else{
				passwordGenerate += generateChar();
			}
			
		}
		
		return passwordGenerate;
	}
	
	private static int generateInt(){
		int generateInt;
		
		generateInt = (int) (Math.random()*10);
		
		return generateInt;
	}
	
	private static char generateChar(){
		char generateChar;
		
		generateChar = (char)((int) (Math.random()*25)+97);
		
		return generateChar;
	}
	
	private static char generateMaj(){
		char generateMaj;
		
		generateMaj = (char)((int) (Math.random()*25)+65);
		
		return generateMaj;
	}
	
	private static char generateSpec(){
		char generateSpec;
		
		generateSpec = (char)((int) (Math.random()*14)+33);
		
		return generateSpec;
	}
}
