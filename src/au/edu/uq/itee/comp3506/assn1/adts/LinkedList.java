package au.edu.uq.itee.comp3506.assn1.adts;

import java.lang.*;

public class LinkedList<T> implements GameList<T> {


    private int cursor = 0;
    public T[] data;
    public T[] newData;
    public T[] cloned;


    /**
     * @param data      array
     * @param condition add/minus based on condition
     *
     * Reference:
     * Jinguy. (n.d.). Empty an array in Java / processing - Stack Overflow.
     * Retrieved from https://stackoverflow.com/questions/4208655/empty-an-array-in-java-processing
     *
     * Clone current array, destroy current array then
     * instantiate an element bigger than the previous one
     * Run-time efficiency: O(n) linear
     */
    private void copy(T[] data, boolean condition) {
        int size;
        size = newData.length;
        cloned = newData.clone();
        newData = null;

        if (condition == true) {
            newData = (T[]) new Object[size + 1];
        } else {
            newData = (T[]) new Object[size - 1];
        }

    }
    /**
     * Justification
     * The method allows reuse of the same array name by cloning current array
     * and destroying the current array.
     */

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
                newData[i] = cloned[i];
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
     * Justification
     * Instead of initialising the array with an arbitrary length,
     * the method increments the lenght of the re-instantiated array.
     *
     */

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
     * Jrad. (n.d.). java - How to add an element to Array and shift indexes?
     * - Stack Overflow. Retrieved from https://stackoverflow.com/questions/11638123/
     * how-to-add-an-element-to-array-and-shift-indexes
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
            // Jrad. (n.d.). Add an element to an array and shift indexes.
            for (int i = 0; i < cursor; i++) {
                newData[i] = cloned[i];
            }
            newData[cursor] = item;
            for (int i = cursor + 1; i < newData.length; i++) {
                newData[i] = cloned[i - 1];
            }
        }
    }

    /**
     * Justification
     * Run-time is inefficient as it uses copy function which is linear. This is to be multiplied
     * by the for-loop that reassigns all the elements from the cloned array.
     * This results to a quadratic (n^2) runtime complexity. The other option would be to
     * arbitrarily assign a big number for the length of the array however this would be
     * inefficient in terms of space. I chose space efficiency over time.
     * Game levels are created only as needed and would not hold a huge number of levels while the
     * game is running. This is a better design choice as each floor is randomly generated.
     */

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
            newData[i] = cloned[i];
        }
        for (int i = cursor + 1; i < newData.length; i++) {
            newData[i - 1] = cloned[i];
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
     * Justification
     * Removing and adding an element won't allow any null elements with copy(),
     * it would be safe to assume the first element in the array is always
     * in index zero.
     */

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
        // Initial assignment of Data, with no newData
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
     * There is time inefficiency to find() because it needs to
     * loop through all the elements of the array. An O(logn) Binary search
     * would have been an ideal implementation but that would mean a sorting
     * function would have to be implemented to allow binary search which
     * can be time inefficient as well. If sort were to be implemented, it
     * has to be called only before find(), otherwise it would be counter productive.
     *
     */

    /**
     * @return Boolean
     *
     * Run-time complexity: O(n) constant
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
