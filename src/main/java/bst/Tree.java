package bst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Tree {
	private boolean isAlwaysIncreasing;
	private Optional<Integer>[] values;
	private Statistics statistics = Statistics.NONE;
	private boolean isAlwaysDecreasing;

	private Tree (final int value) {
		isAlwaysIncreasing = true;
		isAlwaysDecreasing = true;
		values = new Optional[0];
		add(value);
	}

	public static Tree from (final int value) {
		return new Tree(value);
	}

	public boolean contains (final int value) {
		if(isAlwaysIncreasing || isAlwaysDecreasing) {
			return linearSearch(value);
		}
		return contains(value, 0, values.length-1);
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
			final int middle = (max - min + 1) / 2 + min;
			if(value < values[middle].get()) {
				return contains(value, min, middle);
			} else {
				return contains(value, middle, max);
			}
		}
	}

	public void add (final int value) {
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
		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = Optional.of(value);
		Arrays.sort(values, new Comparator<Optional<Integer>>() {
			@Override
			public int compare (final Optional<Integer> o1, final Optional<Integer> o2) {
				return Integer.compare(o1.get(), o2.get());
			}
		});

	}

	public void setStatistics (final Statistics statistics) {
		this.statistics = statistics;
	}
}
