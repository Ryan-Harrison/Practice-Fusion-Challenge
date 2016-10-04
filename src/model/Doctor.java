package model;

public class Doctor {
	
	private int id = 0;
	private String specialty = "";
	private String area = "";
	private int score = 0;
	
	public Doctor(int id, String specialty, String area, int score) {
		this.id = id;
		this.specialty = specialty;
		this.area = area;
		this.score = score;
	}
	
	public int getId() { return id; }
	public String getSpecialty() { return specialty; }
	public String getArea() { return area; }
	public int getScore() { return score; }

}