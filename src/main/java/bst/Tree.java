package bst;

public class Tree {
	private final int value;
	private int other;

	private Tree (final int value) {

		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		return this.value == value|| other ==value;
	}

	public void add (final int value) {

		other = value;
	}
}
