package leetcode.arrays;

import java.util.*;

public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {
        int[] input = {1, 1, 1};
        int k = 2;
        System.out.println("Result : " + subarraySum(input, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("sum : " + sum);
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Map : " + preSum);
        return result;
    }
}
