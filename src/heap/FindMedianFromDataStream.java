package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class MedianFinder {
    // store the largest k elements
    private PriorityQueue<Integer> minHeap;

    // store the smallest k or k+1 elements
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek())/2.0;
    }
}

public class FindMedianFromDataStream {
    /*
        LeetCode (124/150)
        https://leetcode.com/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n) for addNum(), O(1) for findMedian()
        Auxiliary Space : O(n)

        Example 1:
        Input
        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        [[], [1], [2], [], [3], []]
        Output
        [null, null, null, 1.5, null, 2.0]

        Explanation
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianFinder mf = new MedianFinder();

        while (true) {
            int num = sc.nextInt();
            if (num < 0) {
                break;
            }
            mf.addNum(num);
            System.out.println(mf.findMedian());
        }
        sc.close();
    }
}
