import bst.BigONotation;
import bst.Tree;
import bst.TreeBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TreeShould {

	private Tree sut;
	private BigONotation bigONotation;

	@Before
	public void setUp () {
		bigONotation = new BigONotation();
		sut = TreeBuilder.aNew().withStatistics(bigONotation).from(1).build();
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

		final int upperBound = 7;
		for(int i=2;i< upperBound;i++) {
			sut.add(i);
		}


		for(int i=2;i< upperBound;i++) {
			assertThat(sut.contains(i), is(true));
		}
	}

	@Test
	public void not_store_the_default_value_for_int_without_adding_it_first () {
		assertThat(sut.contains(0), is(false));
	}

	@Test
	public void find_an_element_in_log_n_time () {

		sut.add(4);
		sut.add(3);
		sut.add(5);
		sut.add(2);
		sut.add(6);
		sut.add(7);

		sut.contains(5);

		assertThat(bigONotation.isLog2(7), is(true));
	}

	@Test
	public void find_an_element_in_n_time () {
		sut.add(2);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		sut.add(6);
		sut.add(7);

		sut.contains(7);

		assertThat(bigONotation.isLog2(7), is(false));
	}

	@Test
	public void find_an_element_in_n_time_in_a_decreasingly_ordered_sequence () {
		sut.add(0);
		sut.add(-1);
		sut.add(-2);
		sut.add(-3);
		sut.add(-4);
		sut.add(-5);

		sut.contains(-7);

		assertThat(bigONotation.isLog2(7), is(false));
	}

	@Test
	public void take_On_to_find_the_bigger_in_an_almost_ordered_sequence () {

		sut = TreeBuilder.aNew().withStatistics(bigONotation).from(0).build();

		sut.add(2);
		sut.add(1);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		sut.add(6);
		sut.add(7);


		sut.contains(7);

		assertThat(bigONotation.isLog2(8), is(false));
	}

	@Test
	public void count_the_number_of_comparisons () {

		bigONotation = mock(BigONotation.class);
		sut = TreeBuilder.aNew().withStatistics(bigONotation).from(1).build();

		sut.contains(1);
		verify(bigONotation).comparison();
	}


}
