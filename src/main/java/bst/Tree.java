package bst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Tree {
	private int[] depths;
	private boolean isAlwaysIncreasing;
	private Optional<Integer>[] values;
	private Statistics statistics = Statistics.NONE;
	private boolean isAlwaysDecreasing;

	private Tree (final int value) {
		isAlwaysIncreasing = true;
		isAlwaysDecreasing = true;
		values = new Optional[0];
		depths = new int[0];
		add(value);
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {


		final boolean contained = linearSearch(value);
		if(contained){

			int i;
			for (i = 0; i < values.length; i++) {
				if(values[i].get() == value){
					break;
				}
			}

			statistics.set(i);
		}

		return contained;
	}

	private boolean linearSearch (final int value) {
		for (int i = 0; i < values.length; i++) {
			this.statistics.comparison();
			if (values[i].get() == value) {
				return true;
			}
		}
		return false;
	}

	private boolean binarySearch (final int value, final int min, final int max) {
		if(min==max){
			statistics.comparison();
			return values[max].get() == value;
		} else if(max-min==1){
			return binarySearch(value, min, min) || binarySearch(value, max, max);
		} else {
			statistics.comparison();
			final int middle = (max - min + 1) / 2 + min;
			if(value < values[middle].get()) {
				return binarySearch(value, min, middle);
			} else {
				return binarySearch(value, middle, max);
			}
		}
	}

	public void add (final int value) {
		calculateDistribution(value);
		addElement(value);
	}

	private void addElement (final int value) {
		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = Optional.of(value);

		depths = Arrays.copyOf(depths, depths.length + 1);
		depths[depths.length - 1] = -1;

		sortValues();

		updateDepths();
	}

	private void sortValues () {
		Arrays.sort(values, new Comparator<Optional<Integer>>() {
			@Override
			public int compare (final Optional<Integer> o1, final Optional<Integer> o2) {
				return Integer.compare(o1.get(), o2.get());
			}
		});
	}

	private void updateDepths () {
		int newPosition = 0;

		for (int i = 0; i < depths.length; i++) {
			if(depths[i] == -1){
				newPosition = i;
			}
		}

		int previousDepth = depthAt(newPosition, -1);
		int nextDepth = depthAt(newPosition, 1);
		depths[newPosition] = Math.max(previousDepth, nextDepth) + 1;
	}

	public void setStatistics (final Statistics statistics) {
		this.statistics = statistics;
	}

	private int depthAt (final int newPosition, final int delta) {
		int depth;
		try {
			depth = depths[newPosition + delta];
		} catch (ArrayIndexOutOfBoundsException e) {
			depth =-1;
		}
		return depth;
	}

	private void calculateDistribution (final int value) {
		if(values.length > 0) {
			final Integer max = values[values.length - 1].get();
			final Integer min = values[0].get();
			if (!(value > max)) {
				isAlwaysIncreasing = false;
			}
			if(!(value < min)){
				isAlwaysDecreasing = false;
			}
		}
	}

}
