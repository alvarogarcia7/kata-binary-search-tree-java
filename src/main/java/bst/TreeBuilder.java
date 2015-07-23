package bst;

import javafx.util.Builder;

public class TreeBuilder implements Builder<Tree> {
	private BigONotation bigONotation;
	private int value;

	public static TreeBuilder aNew () {
		return new TreeBuilder(BigONotation.NONE);
	}

	public TreeBuilder (final BigONotation bigONotation) {
		this.bigONotation = bigONotation;
	}

	public TreeBuilder withStatistics (final BigONotation bigONotation) {
		this.bigONotation = bigONotation;
		return this;
	}

	public TreeBuilder from (final int value) {
		this.value = value;
		return this;
	}

	@Override
	public Tree build () {
		final Tree tree = Tree.from(value);
		tree.setBigONotation(bigONotation);
		return tree;
	}
}
