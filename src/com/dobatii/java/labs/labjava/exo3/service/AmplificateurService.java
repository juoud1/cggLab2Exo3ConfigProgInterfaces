package com.dobatii.java.labs.labjava.exo3.service;

import java.util.Scanner;

public class AmplificateurService {
private Scanner lectureClavier;
	
	// Variables pour recevoir les données entrées au clavier 
	private int r1Saisie;
	private int r2Saisie;
	private float veSaisie;
	
	
	public AmplificateurService() {
		super();
		this.lectureClavier = new Scanner(System.in);
		
	}

	public void saisirValeurs() {
		
		System.out.println("Saisir R1 :");
		r1Saisie = lectureClavier.nextInt();
		
		System.out.println("Saisir R2 :");
		r2Saisie = lectureClavier.nextInt();
        
		System.out.println("Saisir Ve :");
		veSaisie = lectureClavier.nextFloat();
		
	}
	
	private int saisirCodeTypeAmplificateur() {
	
		int codeSaisi= 3;
		
		do {
			System.out.println("Choisir le type d'amplificateur en saisissant \n0 : Amplificateur inverseur \n1 : Amplificateur non inverseur \n2 : quitter ");
			codeSaisi = lectureClavier.nextInt();
			
			if (2 == codeSaisi) {
				System.out.println("L'exécution de l'application est arrêté!");
				System.exit(0);
			} else if (codeSaisi > 2) {
				System.out.println("Choix incorrect, refaire SVP");
			}
			
		} while (0 != codeSaisi && 1 != codeSaisi);
		
        return codeSaisi;
        
	}

	public int choisirTypeAmplificateur() {
		
		int codeAmpli = saisirCodeTypeAmplificateur();
		return codeAmpli;
		
	}
	
	public float calculerGainAmplificateurInverseur () {
		
		float gain = r2Saisie/r1Saisie;
		return gain;
		
	}
	
	public float calculerGainAmplificateurNonInverseur () {
		
		float gain = 1.0f + (r2Saisie/r1Saisie);
		return gain;
		
	}
	
	public float calculerSortieVs (final int typeAmpli, final float gain) {
		
		float valeurVs = 0;
		switch (typeAmpli) {
			case 0:
				valeurVs = -1 * gain * veSaisie;
				break;

			case 1:
				valeurVs = gain * veSaisie;
				break;
			
			default:
				valeurVs = 0;
				break;
		}
		
		return valeurVs;
		
	}
}
