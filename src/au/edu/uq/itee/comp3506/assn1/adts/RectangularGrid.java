package au.edu.uq.itee.comp3506.assn1.adts;


public class RectangularGrid<T> implements Grid<T> {

    T[][] data;
    private T returnValue;
    private int rowSize;
    private int columnSize;

    /**
     *
     * @param a Size of row
     * @param b Size of column
     */
    public RectangularGrid(int a, int b) {
        rowSize = b;
        columnSize = a;
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Pick a number greater than 0");
        } else {
            data = (T[][]) new Object[a][b];
        }
    }

    /**
     * @param item Item to be placed in the grid.
     * @param x X Coordinate of the position of the item.
     * @param y Y Coordinate of the position of the item.
     *          Loop through the grid with a nested loop
     *          Run-time efficiency: O(n^2) quadratic
     */
    public void place(T item, int x, int y) {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                data[y][x] = item;
            }
        }
    }

    /**
     * @param x X Coordinate of the position of the item.
     * @param y Y Coordinate of the position of the item.
     * @return T Generic Element.
     *           Loop through grid with a nested loop and index the array
     *           Run-time efficiency: O(n^2) or (length ^ 2) in this case.
     */
    public T get(int x, int y) {
        if ((x == 0 && y == 0) || (y <= rowSize && x <= columnSize)) {
            for (int i = 0; i <= x; i++) {
                for (int j = 0; j <= y; j++) {
                    returnValue = data[y][x];
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Coordinates cannot be accessed");
        }
        return returnValue;
    }
}
