package array_or_string;

import java.util.*;

/*
    Leetcode (12/150)
    https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150

    Time Complexity : O(1)
    Auxiliary Space : O(n)

    Example :
    Input
    ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    [[], [1], [2], [2], [], [1], [2], []]
    Output
    [null, true, false, true, 2, true, false, 2]
    Explanation
    RandomizedSet randomizedSet = new RandomizedSet();
    randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
    randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
    randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
    randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
    randomizedSet.insert(2); // 2 was already in the set, so return false.
    randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
*/

class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        // swap with last element to avoid rearranging after removal
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randSet = new RandomizedSet();
        
        System.out.println(randSet.insert(1));
        System.out.println(randSet.remove(2));
        System.out.println(randSet.insert(2));
        System.out.println(randSet.getRandom());

        System.out.println(randSet.remove(1));
        System.out.println(randSet.insert(2));
        System.out.println(randSet.getRandom());
    }
}
