package au.edu.uq.itee.comp3506.assn1.adts;


public class RectangularGrid<T> implements Grid<T> {

    // Initializer
    T[][] data;

    // Constructor
    public RectangularGrid(int a, int b) {
        data = (T[][]) new Object[a][b];
    }

    // Place an element
    public void place(T item, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // insert T element in 2D array
                data[x][y] = item;
            }
        }
    }

    // Get an element
    public T get(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
            }
        }
        return null;
    }
}
