package au.edu.uq.itee.comp3506.assn1.adts;


public class FixedSizeBag<T> implements RemovableBag<T> {
	T[] bagArray;

	/**
	 * Create a FixedSizeBag with contents set to null.
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

}
