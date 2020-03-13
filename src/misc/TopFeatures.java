package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFeatures {

    public static List<String> get(int k, List<String> features, List<String> requests) {
        Map<String, Integer> freq = new HashMap<>();
        for (String request : requests) {
            for (String feature : features) {
                if (request.toLowerCase().contains(feature.toLowerCase())) {
                    if (!freq.containsKey(feature)) {
                        freq.put(feature, 1);
                    } else {
                        Integer count = freq.get(feature);
                        freq.put(feature, count + 1);
                    }
                }
            }
        }

        PriorityQueue<String> heap =
                new PriorityQueue<>((String a, String b) -> {
                    int x = freq.get(a);
                    int y = freq.get(b);

                    if (x == y) {
                        return a.compareTo(b);
                    }

                    return Integer.compare(y, x);
                });

        heap.addAll(freq.keySet());

        List<String> top = new ArrayList<>();
        while (!heap.isEmpty() && k-- > 0) {
            top.add(heap.poll());
        }

        return top;
    }

    public static void main(String[] args) {
        List<String> features = Arrays.asList("waterproof", "storage", "battery"
                , "hover", "alexa", "solar");
        List<String> requests = Arrays.asList(" dsfisdjfkl storage dhfkjs", "dfsd battery",
                "jslkfdsklf waterproof", "battery mani Waterproof", "waterproof please Waterproof",
                "kindle", "dshfjs solar", "alexa", "alexa");

        List<String> list1 = get(2, features, requests);
        List<String> list2 = get(1, features, requests);
        List<String> list3 = get(3, features, requests);

        System.out.println("top 1 = " + list2);
        System.out.println("top 2 = " + list1);
        System.out.println("top 3 = " + list3);
    }
}
