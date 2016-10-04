package model;

import java.util.Random;

public class DocListGen {
	
	private final String[] specialties = {"pediatrics", "cardiology", "dentistry", "neurology", "orthopedics"};
	private final String[] areas = {"New York", "Chicago", "San Fransisco", "Las Vegas", "Portland", 
			"Milwaukee", "New Orleans", "Austin", "Nashville", "Indianapolis", "Cleveland", "Washington D.C."};
	
	public Doctor[] generateRandomList(int amount) {
		Doctor[] doctors = new Doctor[amount];
		Random random = new Random();
		
		for (int i = 0; i < amount; i++) {
			String specialty = specialties[random.nextInt(5)];
			String area = areas[random.nextInt(12)];
			int score = (random.nextInt(100))+1;
			
			doctors[i] = new Doctor(i, specialty, area, score);
		}
		
		return doctors;
	}
	
	public Doctor[] generateList(int[] sp, int[] ar, int[] sc) {
		Doctor[] doctors = new Doctor[sp.length];
		
		for (int i = 0; i < sp.length; i++) {
			String specialty = specialties[sp[i]];
			String area = areas[ar[i]];
			int score = sc[i];
			
			doctors[i] = new Doctor(i, specialty, area, score);
		}
		
		return doctors;
	}
	
	public boolean equalLists(Doctor[] doc1, Doctor[] doc2) {
		boolean result = true;
		
		if (doc1.length != doc2.length) {
			result = false;
		}
		
		for (int i = 0; i < doc1.length && result; i++) {
			if (doc1[i].getId() != doc2[i].getId()
					|| doc1[i].getSpecialty() != doc2[i].getSpecialty()
					|| doc1[i].getArea() != doc2[i].getArea()
					|| doc1[i].getScore() != doc2[i].getScore()) {
				result = false;
			}
		}
		
		return result;
	}
}