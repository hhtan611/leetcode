package Leetcode;

import java.util.*;
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity  );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4


public class LRUCache {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */);
		cache.put(2, 1); // evicts key 2
		cache.put(1, 1); // evicts key 1
		cache.put(2, 3); 
		cache.put(4, 1);
		cache.get(1); // returns 3
		cache.get(2); // returns 4
	}

	int n;
	Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		n = capacity + 1;
		map = new LinkedHashMap<>(n);
	}

	public int get(int key) {
		Integer val = map.get(key);
		if (val == null)
			return -1;
		map.remove(key);
		map.put(key, val);
		return val;
	}

	public void put(int key, int value) {
		map.remove(key);
		map.put(key, value);
		if (map.size() > n-1) {
			map.remove(map.entrySet().iterator().next().getKey());
		}
	}
}

class LRUCache2 {
	private Map<Integer, Integer> map;
	private int capacity;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity + 1);
	}

	public int get(int key) {
		Integer val = map.get(key);
		if (val == null)
			return -1;
		map.remove(key);
		map.put(key, val);
		return val;
	}

	public void set(int key, int value) {
		map.remove(key);
		map.put(key, value);

		if (map.size() > capacity)
			map.remove(map.entrySet().iterator().next().getKey());
	}
}
