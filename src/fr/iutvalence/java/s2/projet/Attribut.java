package fr.iutvalence.java.s2.projet;

public class Attribut
{
	public static final int TAILLE_PAR_DEFAUT = 8;
	public static final boolean DESACTIVE = false;
	private int length;
	private boolean caracSpeciaux;  //TODO Translate
	private boolean majuscule; 		//TODO Translate
	private boolean number;
	
	public Attribut(){
		this.length = Attribut.TAILLE_PAR_DEFAUT;
		this.caracSpeciaux = Attribut.DESACTIVE;
		this.majuscule = Attribut.DESACTIVE;
		this.number = Attribut.DESACTIVE;
	}
	
	public Attribut(int length,boolean caracSpeciaux, boolean majuscule, boolean number){
		this.caracSpeciaux = caracSpeciaux;
		this.majuscule = majuscule;
		this.number = number;
		this.length = length;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public boolean getCaracSpeciaux(){	//TODO Translate
		return this.caracSpeciaux;
	}
	
	public boolean getMajuscule(){	//TODO Translate
		return this.majuscule;
	}
	
	public boolean getNumber(){
		return this.number;
	}
}
