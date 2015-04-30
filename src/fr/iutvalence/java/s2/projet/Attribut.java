package fr.iutvalence.java.s2.projet;

public class Attribut
{
	public static final int TAILLE_PAR_DEFAUT = 8;
	public static final boolean DESACTIVE = false;
	private int length;
	private boolean caracSpeciaux;
	private boolean majuscule;
	private boolean nombre;
	
	public Attribut(){
		this.length = Attribut.TAILLE_PAR_DEFAUT;
		this.caracSpeciaux = Attribut.DESACTIVE;
		this.majuscule = Attribut.DESACTIVE;
		this.nombre = Attribut.DESACTIVE;
	}
	
	public Attribut(int length,boolean caracSpeciaux, boolean majuscule, boolean nombre){
		this.caracSpeciaux = caracSpeciaux;
		this.majuscule = majuscule;
		this.nombre = nombre;
		this.length = length;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public boolean getCaracSpeciaux(){
		return this.caracSpeciaux;
	}
	
	public boolean getMajuscule(){
		return this.majuscule;
	}
	
	public boolean getNombre(){
		return this.nombre;
	}
}
