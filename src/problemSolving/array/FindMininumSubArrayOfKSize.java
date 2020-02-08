package problemSolving.array;

public class FindMininumSubArrayOfKSize {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1};
        int k = 3;
        findMinSubArray(arr, k);
    }

    public static void findMinSubArray(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int startIndex = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            System.out.println(" i : " + i + " to " + (i + k) + " = " + windowSum);
            if (min > windowSum) {
                min = windowSum;
                startIndex = i;
            }
        }
        System.out.println("MIN : " + min + " startIndex : " + startIndex);
    }
}
