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
		assertThat(sut.contains(2), is(false));
	}

	@Test
	public void add_another_element_to_an_existing_one () {
		sut.add(2);

		assertThat(sut.contains(2), is(true));
	}

	@Test
	public void store_any_amount_of_elements () {
		assertThat(sut.contains(1), is(true));

		for(int i=2;i<5;i++) {
			sut.add(i);
			assertThat(sut.contains(i), is(true));
		}
	}

	@Test
	public void not_store_the_default_value_for_int_without_adding_it_first () {
		assertThat(sut.contains(0), is(false));
	}


}
