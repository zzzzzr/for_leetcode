package Leetcode;

import java.util.*;
class MyHashSet {
	private static final int BASE = 769;
	private LinkedList[] data;

	/** Initialize your data structure here. */
	public MyHashSet() {
		data = new LinkedList[BASE];
		for (int i = 0; i < BASE; ++i) {
			data[i] = new LinkedList<Integer>();
		}
	}

	public void add(int key) {
		int h = hash(key);
		Iterator<Integer> iterator = data[h].iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (element == key) {
				return;
			}
		}
		data[h].offerLast(key);
	}

	public void remove(int key) {
		int h = hash(key);
		Iterator<Integer> iterator = data[h].iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (element == key) {
				data[h].remove(element);
				return;
			}
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int h = hash(key);
		Iterator<Integer> iterator = data[h].iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (element == key) {
				return true;
			}
		}
		return false;
	}

	private static int hash(int key) {
		return key % BASE;
	}
}

public class Leetcode705 {
	public static void main(String []args){
		MyHashSet mhs = new MyHashSet();
		MyHashSet obj = new MyHashSet();
		obj.add(1);
		obj.add(2);
		obj.add(1);
		obj.add(3);
		obj.add(9);
		obj.add(9);
		obj.remove(9);
		obj.remove(2);
		System.out.println(obj.contains(3));
	}
}
