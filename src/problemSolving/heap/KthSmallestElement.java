package problemSolving.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
        findKthSmallest(A, k);
    }

    public static void findKthSmallest(List<Integer> inputs, int k) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
        pq.addAll(inputs.subList(0, k));
        for (int i = k; i < inputs.size(); i++) {
            if (inputs.get(i) < pq.peek()) {
                pq.poll();
                pq.add(inputs.get(i));
            }
        }
        System.out.println("Output : " + pq.peek());
    }
}
