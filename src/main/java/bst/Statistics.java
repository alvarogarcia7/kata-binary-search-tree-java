package bst;

public class Statistics {
	public static final Statistics NONE = new Statistics(){
		@Override
		public void comparison () {}

		@Override
		public boolean isLog2N (final int n) {
			throw new UnsupportedOperationException();
		}
	};
	private int comparisons = 0;

	public boolean isLog2N (final int n) {
		final double log = log2(n);
		final int upperLimit = (int) Math.ceil(log);
		return comparisons < upperLimit;
	}

	public void comparison () {
		this.comparisons++;
	}

	private double log2 (final int n) {
		return Math.log(n) / Math.log(2);
	}
}
