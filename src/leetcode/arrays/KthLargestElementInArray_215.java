package leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Result : " + findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums != null && nums.length == 0)
            return 0;
        if(k == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
            //System.out.println("PQ : " + pq + " SIZE : " + pq.size());
        }
        return pq.peek();
    }
}
