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

    @Override
    public boolean add(T item) {
        boolean return_value;
        try {
            bagArray[cursor] = item;
            return_value = true;
            cursor = cursor + 1;
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
        return return_value;
    }

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

    @Override
    public T firstItem() {
        return bagArray[0]; // not necessarily the first element
    }

    @Override
    public T nextItem() {
        if (bagArray != null && bagArray.length != 1) {
            return bagArray[cursor + 1];
        } else {
            throw new ArrayIndexOutOfBoundsException("No next element");
        }
    }

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
}
