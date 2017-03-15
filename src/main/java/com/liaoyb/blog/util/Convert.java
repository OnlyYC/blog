package com.liaoyb.blog.util;

/**
 * @author liaoyb
 */
public abstract class Convert<A,B> {
	protected abstract B doForward(A a);
	protected abstract A doBackward(B b);
}
