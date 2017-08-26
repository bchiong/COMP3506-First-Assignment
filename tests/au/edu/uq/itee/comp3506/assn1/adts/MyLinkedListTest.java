package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;
import org.junit.Before;
import org.junit.Test;


/* Implement your additional JUnit tests for LinkedList in this test class. */ 
public class MyLinkedListTest {

	private LinkedList<GameObject> list;

	@Before
	public void createEmptyLinkedList() {
		list = new LinkedList<GameObject>();
	}

	@Test
	public void addTwoItems() {
		GameObject item1ToAdd = new GameObject("Item 1");
		GameObject item2ToAdd = new GameObject("Item 2");
		GameObject item3ToAdd = new GameObject("Item 3");
		list.addToEnd(item1ToAdd);
		list.addToEnd(item2ToAdd);
		list.addToEnd(item3ToAdd);
		assertThat("Adding multiple items to end of list did not result in the last one being the last item.",
				list.isLast(), is(equalTo(true)));
		assertThat("The first item added to the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item1ToAdd)));
		assertThat("The last item added to the list is not the last item in the list.",
				list.getLast(), is(equalTo(item3ToAdd)));
	}
}
