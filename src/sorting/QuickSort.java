package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 11, 0, 22, 3, 1, 2};
        System.out.println(" Input : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + ", "));
        sort(arr, 0, arr.length - 1);
        System.out.println("\nOutput : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + ", "));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int partion = partion(arr, left, right);
            sort(arr, left, partion - 1);
            sort(arr, partion + 1, right);
        }
    }

    public static int partion(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;

    }
}
