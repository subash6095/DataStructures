package problemSolving.heap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 1, 1, 2, 2, 3
        };
        int k = 2;
        KFrequentElements(arr, k);
    }

    public static void KFrequentElements(int[] input, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : input) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        System.out.println("Frequency Map : " + frequencyMap.toString());
        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(entry);
        }

        List<Integer> output = new ArrayList<>();
        while (k > 0) {
            output.add(priorityQueue.poll().getKey());
            k--;
        }

        System.out.println("Final Output : " + output.toString());
    }
}
