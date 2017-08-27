package au.edu.uq.itee.comp3506.assn1.adts;


public class LinkedList<T> implements GameList<T> {


    // Cursor
    private int cursor = 0;
    // Constructor
    public T[] data;
    public T[] newData;
    public T[] backup;


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

    @Override
    public void addToEnd(T item) {
        int size;
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
            // Taken from stackoverflow
            for (int i = 0; i < cursor; i++) {
                newData[i] = backup[i];
            }
            newData[cursor] = item;
            for (int i = cursor + 1; i < newData.length; i++) {
                newData[i] = backup[i - 1];
            }
        }
    }

    @Override
    public void remove() throws IndexOutOfBoundsException {
        copy(newData, false);
        if (isLast() == true) {
            cursor = cursor - 1;
        }

        for (int i = 0; i < cursor; i++) {
            newData[i] = backup[i];
        }
        for (int i = cursor + 1; i < newData.length; i++) {
            newData[i - 1] = backup[i];
        }
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
        cursor = cursor + 1;
        return newData[cursor];
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
        cursor = cursor - 1;
        return newData[cursor];
    }

    @Override
    public boolean find(T item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (data == null && newData == null) {
            return true;
        } else {
            return false;
        }
    }


}
