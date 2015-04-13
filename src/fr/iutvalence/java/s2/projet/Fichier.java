package fr.iutvalence.java.s2.projet;

public class Fichier {

	private String nom;
	private int nombreCaractere;
	
	public Fichier(String nom){
		this.nom = nom;
	}
	
	public void renommer(String nom){
		this.nom = nom;
	}
	
}
