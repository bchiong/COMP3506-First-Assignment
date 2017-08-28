package au.edu.uq.itee.comp3506.assn1.adts;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;

import java.lang.*;

public class LinkedList<T> implements GameList<T> {


    private int cursor = 0;
    public T[] data;
    public T[] newData;
    public T[] backup;


    /**
     * @param data      array
     * @param condition add/minus based on condition
     *
     * Clone current array, destroy current array then
     * instantiate an element bigger than the previous one
     * Run-time efficiency: O(n) linear
     */
    private void copy(T[] data, boolean condition) {
        int size;
        size = newData.length;
        backup = newData.clone();
        newData = null;

        if (condition == true) {
            newData = (T[]) new Object[size + 1];
        } else {
            newData = (T[]) new Object[size - 1];
        }

    }

    /**
     * @param item The item to be added to the list.
     * Run-time efficiency : O(n) linear
     */
    @Override
    public void addToEnd(T item) {
        int size;
        // TODO: Refactor
        if (data == null) {
            data = (T[]) new Object[1];
            data[0] = item;
            cursor = 0;
        } else if (newData != null) {
            size = newData.length;
            copy(newData, true);
            for (int i = 0; i < size; i++) {
                newData[i] = backup[i];
            }
            newData[size] = item;
            cursor = size;
        } else {
            size = data.length;
            newData = (T[]) new Object[size + 1];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            newData[size] = item;
            cursor = size;
        }

    }

    /**
     * @return boolean
     * Checks if the cursor points to the last element
     */
    @Override
    public boolean isLast() {
        boolean return_value = false;
        if ((data != null && newData == null) || cursor == newData.length - 1) {
            return true;
        } else if (data == null && newData == null) {
            return_value = false;
        }
        return return_value;
    }

    /**
     * @param item The item to be inserted into the list.
     *
     * Reference:
     * https://stackoverflow.com/questions/11638123/how-to-add-an-element-to-array-and-shift-indexes
     * Time complexity: O(n^2) Quadratic
     */
    @Override
    public void insert(T item) {
        if (data == null) {
            data = (T[]) new Object[1];
            newData = (T[]) new Object[1];
            newData[0] = item;
            cursor = 0;
        } else {
            cursor = (cursor == 0) ? cursor = 0 : cursor - 1;
            copy(newData, true);
            // Add an element to an array and shift indexes.
            for (int i = 0; i < cursor; i++) {
                newData[i] = backup[i];
            }
            newData[cursor] = item;
            for (int i = cursor + 1; i < newData.length; i++) {
                newData[i] = backup[i - 1];
            }
        }
    }

    /**
     * @throws IndexOutOfBoundsException
     * Run-time efficiency: O(n^2) Quadratic
     */
    @Override
    public void remove() throws IndexOutOfBoundsException {
        int pos = cursor;
        // Check if cursor is in the last instance, before copying
        if (isLast() == true) {
            cursor = cursor - 1;
        }
        copy(newData, false);
        for (int i = 0; i < pos; i++) {
            newData[i] = backup[i];
        }
        for (int i = cursor + 1; i < newData.length; i++) {
            newData[i - 1] = backup[i];
        }

    }

    /**
     * @return T
     * Retrieves the the element at index 0.
     * 
     */
    @Override
    public T getFirst() {
        if (newData == null) {
            return data[0];
        } else {
            cursor = 0;
            return newData[0];
        }
    }

    /**
     * @return T
     * Throws ArrayIndexOutOfBoundsException
     * Run-time complexity: O(1) Constant
     */
    @Override
    public T getNext() {
        if (newData != null && isLast() == false) {
            cursor = cursor + 1;
            return newData[cursor];
        } else {
            throw new ArrayIndexOutOfBoundsException("No next element");
        }
    }

    /**
     * @return T
     * Retrieves the element at size - 1 index.
     * Run-time complexity: O(1) Constant
     */
    @Override
    public T getLast() {
        int index;
        T last;
        if (newData == null) {
            cursor = 0;
            index = data.length - 1;
            last = data[index];
        } else {
            index = newData.length - 1;
            cursor = index;
            last = newData[index];
        }
        return last;
    }

    /**
     * @return T
     * Retrieves the element at cursor + 1.
     * Run-time complexity: O(1) Constant
     */
    @Override
    public T getPrevious() {
        if (cursor != 0) {
            cursor = cursor - 1;
            return newData[cursor];
        } else {
            throw new ArrayIndexOutOfBoundsException("No previous element");
        }
    }

    /**
     * @return Boolean
     * Iterates the array and compare strings
     * Run-time complexity: O(n) linear
     */
    @Override
    public boolean find(T item) {
        // TODO: rewrite for to foreach
        for (int i = 0; i < newData.length; i++) {
            String compare = newData[i].toString();
            if (compare.equals(item.toString())) {
                cursor = i;
                return true;
            }
        }
        cursor = newData.length;
        return false;
    }

    /**
     * @return Boolean
     *
     * Run-time complexit: O(n) constant
     */
    @Override
    public boolean isEmpty() {
        if (data == null && newData == null) {
            return true;
        } else {
            return false;
        }
    }

}
