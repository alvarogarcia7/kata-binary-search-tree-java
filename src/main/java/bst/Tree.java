package bst;

import java.util.Optional;

public class Tree {
	private final int value;
	private Optional<Integer> other;

	private Tree (final int value) {
		other = Optional.empty();
		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		return this.value == value|| other.isPresent() && other.get() ==value;
	}

	public void add (final int value) {
		other = Optional.of(value);
	}
}
