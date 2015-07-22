import bst.Tree;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TreeShould {

	private Tree sut;

	@Before
	public void setUp () {
		sut = Tree.from(1);
	}

	@Test
	public void store_an_element () {
		assertThat(sut.contains(1), is(true));
	}

	@Test
	public void not_contain_a_previously_added_element () {
		assertThat(sut.contains(randomNumberExcept(1)), is(false));
	}

	private int randomNumberExcept (final int forbiddenValue) {
		int candidate;
		do {
			candidate = (int) (Math.random() * 100);
		} while (candidate == forbiddenValue);
		return candidate;
	}
}
