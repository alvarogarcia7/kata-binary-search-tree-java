package bst;

import javafx.util.Builder;

public class TreeBuilder implements Builder<Tree> {
	private Statistics statistics;
	private int value;

	public static TreeBuilder aNew () {
		return new TreeBuilder(Statistics.NONE);
	}

	public TreeBuilder (final Statistics statistics) {
		this.statistics = statistics;
	}

	public TreeBuilder withStatistics (final Statistics statistics) {
		this.statistics = statistics;
		return this;
	}

	public TreeBuilder from (final int value) {
		this.value = value;
		return this;
	}

	@Override
	public Tree build () {
		return Tree.from(value);
	}
}
