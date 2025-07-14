package linked_list;

import java.util.HashMap;
import java.util.Map;

class CacheNode {
    int key, val;
    CacheNode prev, next;

    public CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    /*
        LeetCode (67/150)
        https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(1)
        Auxiliary Space : O(capacity)

        Example 1:
        Input
        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        Output
        [null, null, null, 1, null, -1, null, -1, 3, 4]
        Explanation
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    */

    private int capacity;
    private CacheNode oldest, latest;
    private Map<Integer, CacheNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // initialize a doubly linked list (DLL)
        // for insertions & deletions in O(1) time
        // dummy head (oldest) & tail (latest) removes edge cases
        this.oldest = new CacheNode(-1, -1);
        this.latest = new CacheNode(-1, -1);
        this.oldest.next = this.latest;
        this.latest.prev = this.oldest;

        // map key with its DLL node
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            // mark as recently used
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        CacheNode newNode = new CacheNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // handle overflow
        if (cache.size() > capacity) {
            CacheNode lru = oldest.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(CacheNode node) {
        // remove by short-circuiting
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(CacheNode node) {
        // insert at tail (latest)
        CacheNode prev = latest.prev;
        CacheNode next = latest;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));  

        cache.put(3, 3); 
        System.out.println(cache.get(2));  

        cache.put(4, 4); 
        System.out.println(cache.get(1));  
        System.out.println(cache.get(3));  
        System.out.println(cache.get(4));  
    }
}