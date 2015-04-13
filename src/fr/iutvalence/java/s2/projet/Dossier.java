package fr.iutvalence.java.s2.projet;

public class Dossier {
	
	private String nom;
	private int nombreFichier;
	private Fichier[] fichiers;
	
	public Dossier(String nom){
		this.nom = nom;
		nombreFichier = 0;
		fichiers = new Fichier[100];
	}
	
	public void ajouterFichier(Fichier fichier){
		fichiers[nombreFichier] = fichier;
		nombreFichier++;
	}
	
	public void supprimerFichier(Fichier fichier){
		int numeroFichier = 0;
		
		while(!(fichier.equals(fichiers[numeroFichier]))){
			numeroFichier++;
		}
		
		if(numeroFichier != nombreFichier){
			while(numeroFichier != nombreFichier){
				fichiers[numeroFichier] = fichiers[numeroFichier+1];
			}
		}
	}
	
	public void renommer(String nom){
		this.nom = nom;
	}
}
