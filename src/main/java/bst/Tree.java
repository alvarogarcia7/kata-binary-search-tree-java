package bst;

public class Tree {
	private final int value;

	private Tree (final int value) {

		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		return this.value == value;
	}
}
