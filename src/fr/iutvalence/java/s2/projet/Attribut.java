package fr.iutvalence.java.s2.projet;
/**
 * Attribut.
 * @author MaximeBlo
 *
 */
public class Attribut
{
	/**
	 * Default length.
	 */
	public static final int DEFAULT_LENGTH = 8;
	/**
	 * Active/Desactive boolean.
	 */
	public static final boolean DESACTIVE = false;
	private int length;
	private boolean specialChar;
	private boolean uppercase;
	private boolean number;
	
	/**
	 * Constructor without param.
	 */
	public Attribut(){
		this.length = Attribut.DEFAULT_LENGTH;
		this.specialChar = Attribut.DESACTIVE;
		this.uppercase = Attribut.DESACTIVE;
		this.number = Attribut.DESACTIVE;
	}
	/**
	 * Constructor with param.
	 * @param length
	 * @param caracSpeciaux with/without
	 * @param majuscule with/without
	 * @param number with/without
	 */
	public Attribut(int length,boolean caracSpeciaux, boolean majuscule, boolean number){
		this.specialChar = caracSpeciaux;
		this.uppercase = majuscule;
		this.number = number;
		this.length = length;
	}
	
	/**
	 * Method to get the length.
	 * @return length
	 */
	public int getLength(){
		return this.length;
	}
	
	/**
	 * Method to get if special character are activate or not
	 * @return
	 */
	public boolean getSpecialChar(){
		return this.specialChar;
	}
	
	/**
	 * Method to get if uppercase  letter are activate or not
	 * @return
	 */
	public boolean getUppercase(){
		return this.uppercase;
	}
	
	/**
	 * Method to get if number are activate or not
	 * @return
	 */
	public boolean getNumber(){
		return this.number;
	}
}
