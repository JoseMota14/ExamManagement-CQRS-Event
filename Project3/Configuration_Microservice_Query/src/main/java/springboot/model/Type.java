package springboot.model;

public enum Type {
	KEYWORD, APPROACH, TECHNOLOGY;

	public boolean sameValueAs(final Type other) {
		return this.equals(other);
	}
}

