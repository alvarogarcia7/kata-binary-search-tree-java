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

	private boolean contains (final int value, final int min, final int max) {
		if(min==max){
			statistics.comparison();
			return values[max].get() == value;
		} else if(max-min==1){
			return contains(value, min, min) || contains(value, max, max);
		} else {
			statistics.comparison();
			final int middle = (max - min + 1) / 2 + min;
			if(value < values[middle].get()) {
				return contains(value, min, middle);
			} else {
				return contains(value, middle, max);
			}
		}
	}

	public void add (final int value) {
		calculateDistribution(value);


		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = Optional.of(value);

		depths = Arrays.copyOf(depths, depths.length + 1);
		depths[depths.length - 1] = -1;


		Arrays.sort(values, new Comparator<Optional<Integer>>() {
			@Override
			public int compare (final Optional<Integer> o1, final Optional<Integer> o2) {
				return Integer.compare(o1.get(), o2.get());
			}
		});

		int newPosition = 0;

		for (int i = 0; i < depths.length; i++) {
			if(depths[i] == -1){
				newPosition = i;
			}
		}

		int depth;
		try {
			depth = depths[newPosition - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			depth =-1;
		}
		int depth2;
		try {
			depth2 = depths[value + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			depth2 =-1;
		}

		depths[newPosition] = Math.max(depth, depth2) + 1;
	}

	public void setStatistics (final Statistics statistics) {
		this.statistics = statistics;
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
