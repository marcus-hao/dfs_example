class Vertex {
	private String name;

	Vertex (String name) {
		this.name = name;
	}

	public String getName() { return name; }

	// Override for hashmap vertex comparisons
	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || this.getClass() != o.getClass()) { return false; }
		Vertex other = (Vertex) o;
		return name.equals(other.name);
	}

	@Override
	public int hashCode() { return name.hashCode(); }
}
