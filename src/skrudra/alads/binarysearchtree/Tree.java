package skrudra.alads.binarysearchtree;

public interface Tree<E extends Comparable> {

	public boolean isEmpty();

	public int cardinality();

	public boolean member(E element);

	public NonEmptyBST<E> add(E element);
}
