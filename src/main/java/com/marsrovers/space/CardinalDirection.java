package com.marsrovers.space;

/**
 * Cardinal direction constants with their own rules (left and right references)
 * @author fab
 *
 */
public enum CardinalDirection {
	N,
	S,
	W,
	E;

	static {
		N.left = W;
		N.right = E;
		S.left = E;
		S.right = W;
		W.left = S;
		W.right = N;
		E.left = N;
		E.right = S;
	}
	
	private CardinalDirection left;
	private CardinalDirection right;
	
	public CardinalDirection getLeft() {
		return left;
	}
	public CardinalDirection getRight() {
		return right;
	}

}
