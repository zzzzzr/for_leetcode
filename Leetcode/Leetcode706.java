package Leetcode;

import java.util.*;
class MyHashMap {
	private static final int BASE = 769;
	private LinkedList[][] data;

	/** Initialize your data structure here. */
	public MyHashMap() {
		data = new LinkedList[BASE][2];
		for (int i = 0; i < BASE; ++i) {
			data[i][0] = new LinkedList<Integer>();
			data[i][1] = new LinkedList<Integer>();
		}
	}

	public void put(int key, int value) {
		int h = hash(key);
		for (int i=0;i<data[h][0].size();i++){
			if (data[h][0].get(i).equals(key)){
				data[h][1].set(i,value);
			}
		}
		data[h][0].offerLast(key);
		data[h][1].offerLast(value);
	}

	public void remove(int key) {
		int h = hash(key);
		Iterator<Integer> itekey = data[h][0].iterator();
		Iterator<Integer> itevalue = data[h][1].iterator();
		while (itekey.hasNext()){
			Integer tempkey = itekey.next();
			itevalue.next();
			if (tempkey==key){
				itekey.remove();
				itevalue.remove();
			}
		}
	}

	public int get(int key) {
		int h = hash(key);
		Iterator<Integer> itekey = data[h][0].iterator();
		Iterator<Integer> itevalue = data[h][1].iterator();
		while (itekey.hasNext()){
			Integer tempkey = itekey.next();
			Integer tempval = itevalue.next();
			if (tempkey==key){
				return tempval;
			}
		}
		return -1;
	}

	private static int hash(int key) {
		return key % BASE;
	}
}
public class Leetcode706 {
	public static void main(String []args){
		MyHashMap mhm = new MyHashMap();
		mhm.put(1,1);
		mhm.put(2,2);
		System.out.println(mhm.get(1));
		System.out.println(mhm.get(3));
		mhm.put(2,3);
		System.out.println(mhm.get(2));
		mhm.remove(2);
		System.out.println(mhm.get(2));
	}
}
