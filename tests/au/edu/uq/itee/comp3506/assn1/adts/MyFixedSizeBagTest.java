package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;
import org.junit.Before;
import org.junit.Test;


/* Implement your additional JUnit tests for FixedSizeBag in this test class. */
public class MyFixedSizeBagTest {

	private FixedSizeBag<GameObject> bag;

	@Before
	public void setupFixedSizeBag() {
		bag = new FixedSizeBag<GameObject>(3);
	}

	@Test
	public void newBagIsLast() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		assertTrue("A bag's cursor is pointing to the last element.", bag.isLast());
	}

	@Test
	public void firstItemBag() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		GameObject item3ToAdd = new GameObject("Item 3 to be Added");
		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		bag.add(item3ToAdd);
		bag.remove(item1ToAdd);
		assertEquals("Removing the first element would have the next element as first",
				bag.firstItem(), item2ToAdd);
	}

    @Test
    public void firstItemBag2() {
        GameObject item1ToAdd = new GameObject("Item 1 to be Added");
        GameObject item2ToAdd = new GameObject("Item 2 to be Added");
        GameObject item3ToAdd = new GameObject("Item 3 to be Added");
        bag.add(item1ToAdd);
        bag.add(item2ToAdd);
        bag.add(item3ToAdd);
        assertEquals("Removing the first element would have the next element as first",
                bag.firstItem(), item1ToAdd);
    }
}
