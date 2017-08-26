package au.edu.uq.itee.comp3506.assn1.adts;


public class LinkedList<T> implements GameList<T> {


    // cursor
    private int cursor = 0;
    // Constructor
    public T[] data;
    public T[] newData;
    public T[] backup;


    @Override
    public void addToEnd(T item) {
        int size;
        if (data == null) {
            data = (T[]) new Object[1];
            data[0] = item;
            cursor = 0;
        } else if (newData != null) {
            size = newData.length;
            backup = newData.clone();
            newData = null;
            newData = (T[]) new Object[size + 1];
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

    @Override
    public boolean isLast() {
        boolean return_value = false;
        if (cursor == data.length - 1 || cursor == newData.length - 1) {
            return true;
        } else if (data == null && newData == null) {
            return_value =  false;
        }
        return return_value;
    }

    @Override
    public void insert(T item) {
        if (data == null) {
            newData[0] = item;
        } else {
         //   cursor = cursor - 1;

        }
    }

    @Override
    public void remove() throws IndexOutOfBoundsException {

    }

    @Override
    public T getFirst() {
        if (newData == null) {
            return data[0];
        } else {
            return newData[0];
        }
    }

    @Override
    public T getNext() {
        return null;
    }

    @Override
    public T getLast() {
        int index;
        T last;
        if (newData == null) {
            index = data.length - 1;
            last = data[index];
        } else {
            index = newData.length - 1;
            last = newData[index];
        }
        return last;
    }

    @Override
    public T getPrevious() {
        return null;
    }

    @Override
    public boolean find(T item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (data == null) {
            return true;
        } else if (data.length == 0) {
            return true;
        } else {
            return false;
        }
    }


}
