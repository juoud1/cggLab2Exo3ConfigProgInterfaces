package com.dobatii.java.labs.labjava.exo3;

import java.util.Scanner;


import com.dobatii.java.labs.labjava.exo3.service.AmplificateurService;

public class LabJavaExo3Main {

	public static void main(String[] args) {
		
		String response = null;
		
		do {
			AmplificateurService ampliService = new AmplificateurService();
			ampliService.saisirValeurs();
			
			int typeAmpli = ampliService.choisirTypeAmplificateur();
			System.out.println("Type amplificateur = " + typeAmpli);
			System.out.println();
			
			float gain = (0 == typeAmpli) ? ampliService.calculerGainAmplificateurInverseur() : ampliService.calculerGainAmplificateurNonInverseur();
			System.out.println("Gain = " + gain);
			System.out.println();
			
			float sortieVs = ampliService.calculerSortieVs(typeAmpli, gain);
			System.out.println("Sortie Vs = " + sortieVs);
			System.out.println();
			
			Scanner lectureChoixParClavier = new Scanner(System.in);
			System.out.println("Refaire l'exécution du programme ? oui/non :");
			response = lectureChoixParClavier.next();
			
		} while (null != response && response.equalsIgnoreCase("oui"));

	}

}
