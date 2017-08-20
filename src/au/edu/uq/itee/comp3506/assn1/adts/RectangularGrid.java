package au.edu.uq.itee.comp3506.assn1.adts;


public class RectangularGrid<T> implements Grid<T> {

    // Initializer
    T[][] data;

    // Constructor
    public RectangularGrid(int a, int b) {

        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Pick a number greater than 0");
        }

        data = (T[][]) new Object[a][b];

    }

    // Place an element
    public void place(T item, int x, int y) {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                // insert T element in 2D array
                data[x][y] = item;
            }
        }
    }

    // Get an element
    public T get(int x, int y) {
//        if (a <= x && b <= y) {
//
//        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
            }
        }
        return null;
    }
}
