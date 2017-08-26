package au.edu.uq.itee.comp3506.assn1.adts;


public class RectangularGrid<T> implements Grid<T> {

    // Initializer
    T[][] data;
    private T returnValue;
    private int rowSize;
    private int columnSize;

    // Constructor
    public RectangularGrid(int a, int b) {
        rowSize = a;
        columnSize = b;
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Pick a number greater than 0");
        } else {
            data = (T[][]) new Object[a][b];
        }
    }

    // Place an element
    public void place(T item, int x, int y) {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                data[y][x] = item;
            }
        }
    }

    // Get an element
    public T get(int x, int y) {
        if ((x == 0 && y == 0) || ( x <= rowSize && y <= columnSize)) {
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
