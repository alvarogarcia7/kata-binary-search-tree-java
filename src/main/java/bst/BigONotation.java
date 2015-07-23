package bst;

public class BigONotation {
	private int operations = 0;
	public boolean isLog2 (final int n) {
		final int upperBound = log2Ceiled(n) + 1;
		return operations <= upperBound;
	}

	public void operation () {
		this.operations++;
	}

	private int log2Ceiled (final int n) {
		final double log = Math.log(n) / Math.log(2);
		return (int) Math.ceil(log);
	}

	public static final BigONotation NONE = new BigONotation(){
		@Override
		public void operation () {}

		@Override
		public boolean isLog2 (final int n) {
			throw new UnsupportedOperationException();
		}
	};

	public void clear () {
		this.operations = 0;
	}

}
