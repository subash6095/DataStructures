package leetcode.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public FindMedianFromDataStream_295() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        min.add(num);
        max.add(min.poll());
        if(max.size() > min.size())
            min.add(max.poll());
    }

    public double findMedian() {
        if (max.size() > min.size())
            return max.peek();
        else if (min.size() > max.size())
            return min.peek();
        return (max.peek() + min.peek())/2;
    }
}
