package controller;

import model.*;

public class Searcher {
	
	class PrioritizedDoctor {
		
		private int priority = 0;
		private Doctor doctor;
		
		PrioritizedDoctor(Doctor doctor, int priority) {
			this.doctor = doctor;
			this.priority = priority;
		}
		
		Doctor getDoctor() { return doctor; }
		int getPriority() { return priority; }
	}
	
	public Doctor[] search(Doctor doc, Doctor[] doctors) {
		int j = 0;
		PrioritizedDoctor[] pDocs = new PrioritizedDoctor[doctors.length];
		
		for (int i = 0; i < doctors.length; i++) {
			Doctor compare = doctors[i];
			
			if (doc.getId() != compare.getId() 
					&& doc.getSpecialty().equals(compare.getSpecialty()) 
					&& doc.getArea().equals(compare.getArea())
					&& (doc.getScore() >= compare.getScore()-20 && doc.getScore() <= compare.getScore()+20)) {
				pDocs[j] = new PrioritizedDoctor(compare, compare.getScore() - doc.getScore());
				j++;
			}
		}
		
		int notNull = 0;
		for (int i = 0; i < pDocs.length; i++)
			if (pDocs[i] != null)
				notNull++;
		
		PrioritizedDoctor[] nPDocs = new PrioritizedDoctor[notNull];
		for (int i = 0; i < nPDocs.length; i++)
			nPDocs[i] = pDocs[i];
		
		return sort(nPDocs);
	}
	
	private Doctor[] sort(PrioritizedDoctor[] pDocs) {
		Doctor[] retDocs = new Doctor[pDocs.length];
		
		for (int i = 0; i < pDocs.length-1; i++) {
			int max = i;
			
			for (int j = i+1; j < pDocs.length; j++)
				if (pDocs[j].getPriority() > pDocs[max].getPriority())
					max = j;
			
			PrioritizedDoctor temp = pDocs[i];
			pDocs[i] = pDocs[max];
			pDocs[max] = temp;
		}
		
		for (int i = 0; i < pDocs.length; i++)
			retDocs[i] = pDocs[i].getDoctor();
		
		return retDocs;
	}

}