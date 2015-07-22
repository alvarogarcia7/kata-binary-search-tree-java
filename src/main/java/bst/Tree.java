package bst;

import java.util.Optional;

public class Tree {
	private final int value;
	private Optional<Integer> other;
	private Optional<Integer> other2;

	private Tree (final int value) {
		other = Optional.empty();
		other2 = Optional.empty();
		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		return this.value == value
				|| other.isPresent() && other.get() == value
				|| other2.isPresent() && other2.get() == value;
	}

	public void add (final int value) {
		if (other.isPresent()) {
			other2 = Optional.of(value);
		} else {
			other = Optional.of(value);
		}
	}
}
