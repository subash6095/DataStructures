package leetcode.arrays;

import java.util.*;

public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int newTarget = target - nums[i];
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    if (m > j + 1 && nums[m] == nums[m - 1]) {
                        m++;
                        continue;
                    }
                    if (n < nums.length - 1 && nums[n] == nums[n + 1]) {
                        n--;
                        continue;
                    }
                    int sum = nums[j] + nums[m] + nums[n];
                    if (sum == newTarget) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        res.add(list);
                        m++;
                        n--;
                    } else if (sum > newTarget) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return res;
    }
}
