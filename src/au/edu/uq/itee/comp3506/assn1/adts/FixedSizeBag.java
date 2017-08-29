package au.edu.uq.itee.comp3506.assn1.adts;


public class FixedSizeBag<T> implements RemovableBag<T> {

    int cursor = 0;
    T[] bagArray;

    /**
     * Create a FixedSizeBag with contents set to null.
     *
     * @param size Maximum number of items that can be contained in the bag.
     */
    public FixedSizeBag(int size) {
        /*
         * Due to type erasure (https://docs.oracle.com/javase/tutorial/java/generics/erasure.html)
		 * the dynamically allocated array has to be created as an array of Object references.
		 * For type safety this array of Object references is then cast to be an array of references
		 * to the generic type <T> of the actual elements to be held in bagArray.
		 */
        bagArray = (T[]) new Object[size];
    }

    /**
     * @param item The item to be added.
     * @return boolean
     * True if successfully added
     *
     * Run-time efficiency: Constant time
     */
    @Override
    public boolean add(T item) {
        boolean return_value = false;
        for (int i = 0; i < bagArray.length; i++) {
            if (bagArray[i] == null) {
                try {
                    bagArray[cursor] = item;
                    return_value = true;
                    cursor = cursor + 1;
                } catch (IndexOutOfBoundsException e) {
                    return_value = false;
                }
                break;
            }
        }
        return return_value;
    }

    /**
     * Justification
     * Because the array contains fixed size, removing it would contain null elements.
     * Iterating the array until the first null element is found, and add the element. To shorten or increase
     * run-time efficiency, a break in the loop is added. Although it is better to append new elements,
     * in this case it was written to make sure no null elements are in between non-null elements.
     * This can eventually contribute to less number of iterations.
     */

    /**
     * @param item The item to be removed.
     * @return boolean
     * True if successfully removed
     *
     * Run-time efficiency: O(n) linear
     */
    @Override
    public boolean remove(T item) {
        boolean return_value = false;
        for (int i = 0; i < bagArray.length; i++) {
            if (bagArray[i].toString() == item.toString()) {
                bagArray[i] = null;
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * Justification
     * Remove function is expensive in this case as it can remove elements anywhere.
     * This leaves some inefficiencies for other methods like firstItem().
     */

    /**
     * @return T
     * first item in the bag
     *
     * Run-time efficiency: O(n) linear
     */
    @Override
    public T firstItem() {

        for (int i = 0; i < bagArray.length; i++) {
            if (bagArray[i] != null) {
                cursor = i;
                break;
            }
        }
        return bagArray[cursor];
    }

    /**
     * Same justification as add(T item)
     */

    /**
     * @return T
     * next item in the bag
     *
     * Run-time efficiency: Constant time
     */
    @Override
    public T nextItem() {
        try {
            if (bagArray != null && bagArray.length != 1) {
                cursor = cursor + 1;
                return bagArray[cursor];
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Same justification as add(T item)
     */

    /**
     * @return boolean
     * if the cursor points to the last element
     *
     * Run-time efficiency: O(n) linear
     */
    @Override
    public boolean isLast() {
        int last = 0;
        for (int i = 0; i < bagArray.length; i++) {
            if (bagArray != null) {
                last = i;
            }
        }
        if (cursor == last) {
            return true;
        }
        return false;
    }

    /**
     * Same justification as add(T item)
     */

    /**
     * @return int
     * total non-null elements
     *
     * Run-time efficiency: O(n) linear
     */
    @Override
    public int size() {
        int size_count = 0;
        for (T element : bagArray) {
            if (element != null) {
                size_count = size_count + 1;
            }
        }
        return size_count;
    }

    /**
     * Same justification as add(T item)
     */
}
