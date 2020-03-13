package problemSolving.classicProblem;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Arrays;

public class TrappingRainWater extends Object {

    public static void main(String[] args) {
        int[] heights = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        int result = waterStored(heights);
        System.out.println("Maximum water trapped : " + result);
    }

    public static int waterStored(int[] heights) {
        int n = heights.length;
        int water = 0;

        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Integer.max(left[i - 1], heights[i - 1]);
        }
        print(left);

        int[] right = new int[n];
        right[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], heights[i + 1]);
        }
        print(right);

        for (int i = 1; i < n - 1; i++) {
            if (Integer.min(left[i], right[i]) > heights[i]) {
                water += Integer.min(left[i], right[i]) - heights[i];
            }
        }
        return water;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " -> " + array[i]);
        }
    }
}
