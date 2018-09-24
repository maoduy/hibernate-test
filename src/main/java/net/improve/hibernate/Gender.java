package net.improve.hibernate;

public enum Gender {
	MALE('M'), FEMALE('F');
	
	private final char gender;

	Gender(char genderCode) {
		this.gender = genderCode;
	}

	public char getGender() {
		return gender;
	}
	
}
