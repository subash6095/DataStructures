package misc;

public class Q2 {

    public static int count (int[] num, int sum)
    {
        int nums[] = {2,3,1,0,-4,-1};
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 3; i++)
        {
            for (int j = i + 1; j < n - 2; j++)
            {
                for (int k = j + 1; k < n - 1; k++)
                {
                    for (int l = k + 1; l < n; l++)
                    {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == sum)
                            count = count + 1;
                    }
                }
            }
        }

        return count;
    }
}
