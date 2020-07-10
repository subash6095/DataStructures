package test;

public class ContinueExample {
    public static void main(String[] args) {
        //int[] nums = {1, 3, 2, 4};
        int[] nums = {1, 2, 3, 4};
        System.out.println("Result :: " + find132pattern(nums));
        String a = "dddss";
        
    }

    public static boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; ++i) {
            System.out.println("i = " + i);
            if (nums[i] >= nums[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (nums[j] <= nums[j + 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[k] >= nums[j] || nums[k] <= nums[i]) {
                        continue;
                    }
                    return true;
                }
                i = j;
                break;
            }
        }

        return false;
    }
}
