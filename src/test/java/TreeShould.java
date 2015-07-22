import bst.Tree;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TreeShould {

	private Tree sut;

	@Test
	public void store_an_element () {

		sut = Tree.from(1);

		assertThat(sut.contains(1), is(true));
	}

	@Test
	public void not_contain_a_previously_added_element () {

		sut = Tree.from(1);

		assertThat(sut.contains(2), is(false));
	}
}
