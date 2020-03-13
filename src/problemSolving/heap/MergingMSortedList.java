package problemSolving.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergingMSortedList {
    static class Node implements  Comparable{
        private int value;
        private int index;
        private int listNum;

        public Node(int value, int listNum, int index) {
            this.index = index;
            this.listNum = listNum;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getListNum() {
            return listNum;
        }

        public void setListNum(int listNum) {
            this.listNum = listNum;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            return value - node.value;
        }
    }

    public static void main(String[] args) {
        int[][] list =
                {
                        {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50},
                        {16, 18, 22, 28}
                };
        /*System.out.println("Size : " + list.length);
        System.out.println("Size : " + list[0].length);*/
        mergeMSortedList(list);
    }

    public static List<Integer> mergeMSortedList(int[][] input) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            pq.add(new Node(input[i][0], i, 0));
        }
        List<Integer> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            output.add(min.getValue());
            if (min.getIndex() + 1 < input[0].length) {
                min.setIndex(min.getIndex() + 1);
                min.setValue(input[min.getListNum()][min.getIndex()]);
                pq.add(min);
            }
        }
        System.out.println("Output : " + output.toString());
        return output;
    }
}

