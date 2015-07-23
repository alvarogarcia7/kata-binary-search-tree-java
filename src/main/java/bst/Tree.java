package bst;

import java.util.Arrays;
import java.util.Optional;

public class Tree {
	private final int value;
	private Optional<Integer>[] others;
	private Statistics statistics = Statistics.NONE;

	private Tree (final int value) {
		others = new Optional[0];
		this.value = value;
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		this.statistics.comparison();
		if (this.value == value) {
			return true;
		}

		for (int i = 0; i < others.length; i++) {
			this.statistics.comparison();
			if (others[i].get() == value) {
				return true;
			}
		}
		return false;
	}

	public void add (final int value) {
		others = Arrays.copyOf(others, others.length + 1);
		others[others.length - 1] = Optional.of(value);
	}

	public void setStatistics (final Statistics statistics) {
		this.statistics = statistics;
	}
}
