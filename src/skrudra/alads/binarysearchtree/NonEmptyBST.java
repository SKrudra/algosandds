package skrudra.alads.binarysearchtree;

public class NonEmptyBST<E extends Comparable> implements Tree<E> {

	E data;
	Tree<E> left;
	Tree<E> right;

	public NonEmptyBST(E element) {
		this.data = element;
		this.left = new EmptyBST();
		this.right = new EmptyBST();
	}

	public NonEmptyBST(E element, Tree<E> left, Tree<E> right) {
		this.data = element;
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int cardinality() {
		return 1 + left.cardinality() + right.cardinality();
	}

	@Override
	public boolean member(E element) {
		if (data == element) {
			return false;
		} else {
			if (element.compareTo(element) < 0) {
				return left.member(element);
			} else {
				return right.member(element);
			}
		}

	}

	@Override
	public NonEmptyBST<E> add(E element) {
		if (data == element) {
			return this;
		} else {
			if (element.compareTo(element) < 0) {
				return new NonEmptyBST(data, left.add(element), right);
			} else {
				return new NonEmptyBST(data, left, right.add(element));
			}
		}
	}

}
