package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;
import org.junit.Before;
import org.junit.Test;


/* Implement your additional JUnit tests for RectangularGrid in this test class. */
public class MyRectangularGridTest {
    private RectangularGrid<GameObject> grid;

    /**
     * Create a small RectangularGrid to be used for testing.
     * The grid is 6 cells in length and 6 cells in width.
     */
    @Before
    public void setupRectangularGrid() {
        grid = new RectangularGrid<GameObject>(6, 6);
    }

    @Test
    public void switchCoordinates() {
        GameObject itemToInsert = new GameObject("Elixir");
        GameObject secondItemToInsert = new GameObject("Potion");
        GameObject firstItemRetrieved;
        GameObject secondItemRetrieved;
        grid.place(itemToInsert, 3, 5);
        grid.place(secondItemToInsert, 5, 3);
        firstItemRetrieved = grid.get(3, 5);
        secondItemRetrieved = grid.get(5, 3);
        assertThat("Item retrieved does not match item inserted at the same position",
                firstItemRetrieved, not(secondItemRetrieved));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void invalidGridAccess2() {
        GameObject itemToInsert = new GameObject("Elixir");
        grid.place(itemToInsert, 6, 5);
        grid.get(7, 5);
    }

}
