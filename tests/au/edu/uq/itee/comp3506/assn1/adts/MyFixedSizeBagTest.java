package au.edu.uq.itee.comp3506.assn1.adts;

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
}
