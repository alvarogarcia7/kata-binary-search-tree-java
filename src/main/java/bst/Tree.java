package bst;

import java.util.Optional;

public class Tree {
	private final int value;
	private Optional<Integer> other;
	private Optional<Integer> other2;
	private Optional<Integer> other3;

	private Tree (final int value) {
		other = Optional.empty();
		other2 = Optional.empty();
		other3 = Optional.empty();
		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		return this.value == value
				|| other.isPresent() && other.get() == value
				|| other2.isPresent() && other2.get() == value
				|| other3.isPresent() && other3.get() == value;
	}

	public void add (final int value) {
		if (other.isPresent()) {
			if (other2.isPresent()) {
				other3 = Optional.of(value);
			} else {
				other2 = Optional.of(value);
			}
		} else {
			other = Optional.of(value);
		}
	}
}
