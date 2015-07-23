package bst;

public class Statistics {
	public static final Statistics NONE = new Statistics();
	private int comparisons = 0;

	public boolean isLog2N (final int n) {
		final double log = Math.log(n) / Math.log(2);
		final int upperLimit = (int) Math.ceil(log);
		return comparisons < upperLimit;
	}

	public void comparison () {
		this.comparisons++;
	}
}
