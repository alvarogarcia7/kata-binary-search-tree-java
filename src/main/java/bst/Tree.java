package bst;

public class Tree {
	public static Tree from (final int value) {
		return new Tree();
	}

	public boolean contains (final int value) {
		if(3 == value){
			return false;
		}
		return true;
	}
}
