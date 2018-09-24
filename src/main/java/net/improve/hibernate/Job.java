package net.improve.hibernate;

public enum Job {
	STUDENT('S'), WORKER('W'), BOSS('B');
	
	private char code;

	Job(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return code;
	}

	public static Job fromCode(char code) {
		for (Job item: Job.values()) {
			if (item.getCode() == code) {
				return item;
			}
		}
		throw new UnsupportedOperationException("Code are not supported " + code);
	}

}
