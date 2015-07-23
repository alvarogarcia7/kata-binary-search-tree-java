package bst;

public class Statistics {
	private int comparisons = 0;
	public boolean isLog2N (final int n) {
		return comparisons <= log2Ceiled(n) + 1;
	}

	public void comparison () {
		this.comparisons++;
	}

	private int log2Ceiled (final int n) {
		final double log = Math.log(n) / Math.log(2);
		return (int) Math.ceil(log);
	}

	public static final Statistics NONE = new Statistics(){
		@Override
		public void comparison () {}

		@Override
		public boolean isLog2N (final int n) {
			throw new UnsupportedOperationException();
		}
	};
}
