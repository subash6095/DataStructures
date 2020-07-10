package leetcode.arrays;

import java.util.*;

public class TopKFrequentWords_692 {
    public static void main(String[] args) {

    }

    public List<String> topKfrequentWords(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        /*PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s1.compareTo(s2);
                }
                return map.get(s2) - map.get(s1);
            }
        });*/

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                /*new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) { */
                (a, b) -> {
                    if (a.getValue() == b.getValue()) {
                        return b.getKey().compareTo(a.getKey());
                    }
                    return a.getValue() - b.getValue();
                }
        );

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }
        while(pq.isEmpty() == false){
            result.add(pq.poll().getKey());
        }

        return result;
    }
}
