package fr.iutvalence.java.s2.projet;

/**
 * Generator of password
 * @author maximeBlo
 *
 */
public class Generator
{
	/**
	 * List of option to create password
	 */
	private Attribut attribut;
	
	/**
	 * Constructor without param.
	 */
	public Generator(){
		this.attribut = new Attribut();	
	}
	/**
	 * Constructor with param.
	 * @param attribut
	 */
	public Generator(Attribut attribut){
		this.attribut=attribut;
	}
	
	/**
	 * Method to generate password
	 * @return the password generated
	 */
	public String generer(){
		
		String passwordGenerate = "";
		
		for(int numberOfCharacter = 0; numberOfCharacter < this.attribut.getLength();numberOfCharacter++){
			int random = (int) (Math.random()*400);
		
			if(random < 100 && this.attribut.getSpecialChar()){
				passwordGenerate += generateSpecialCharacter();
			} else if(random >= 100 && random < 200 && this.attribut.getUppercase()){
				passwordGenerate += generateUppercase();
			} else if(random >= 200 && random < 300 && this.attribut.getNumber()){
				passwordGenerate += generateInt();
			}else{
				passwordGenerate += generateChar();
			}
			
		}
		
		return passwordGenerate;
	}
	
	/**
	 * Method to generate an Int
	 * @return a int 
	 */
	private static int generateInt(){
		int generateInt;
		
		generateInt = (int) (Math.random()*10);
		
		return generateInt;
	}
	
	/**
	 * Method to generate a char
	 * @return a char
	 */
	private static char generateChar(){
		char generateChar;
		
		generateChar = (char)((int) (Math.random()*25)+97);
		
		return generateChar;
	}
	
	/**
	 * Method to generate an Uppercase letter
	 * @return a char in Uppercase
	 */
	private static char generateUppercase(){
		char generateUppercase;
		
		generateUppercase = (char)((int) (Math.random()*25)+65);
		
		return generateUppercase;
	}
	
	/**
	 * Method to generate special character
	 * @return the special character
	 */
	private static char generateSpecialCharacter(){
		char generateSpec;
		
		generateSpec = (char)((int) (Math.random()*14)+33);
		
		return generateSpec;
	}
}
