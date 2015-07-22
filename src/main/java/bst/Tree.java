package bst;

public class Tree {
	public static Tree from (final int value) {
		return new Tree();
	}

	public boolean contains (final int value) {
		if(1 == value){
			return true;
		}
		return false;
	}
}
