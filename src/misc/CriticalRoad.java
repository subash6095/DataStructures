package misc;

import java.util.*;

class CriticalRoad {

    static class PairInt {
        int first, second;

        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "PairInt{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    // a - b
    // b - c
    // c - a
    // c - d

    // a - b, c --
    // b - c, a --
    // c - a, d, b

    List<PairInt> list;
    Map<Integer, Boolean> visited;

    List<PairInt> criticalConnections(int numOfServers, int numOfConnections,
                                      List<PairInt> connections) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (PairInt connection : connections) {
            int a = connection.first;
            int b = connection.second;
            adj.computeIfAbsent(a, k -> new HashSet<>());
            adj.get(a).add(b);
            adj.computeIfAbsent(b, k -> new HashSet<>());
            adj.get(b).add(a);
        }

        list = new ArrayList<>();
        for (int i = 0; i < numOfConnections; i++) {
            visited = new HashMap<>();
            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj, 1);
            if (visited.size() != numOfServers) {
                list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }

    public void DFS(Map<Integer, HashSet<Integer>> adj, int u) {
        visited.put(u, true);
        if (adj.get(u).size() != 0) {
            for (int v : adj.get(u)) {
                if (!visited.getOrDefault(v, false)) {
                    DFS(adj, v);
                }
            }
        }
    }

    public static void main(String[] args) {
        CriticalRoad criticalRoad = new CriticalRoad();
        List<PairInt> inputList = new ArrayList<>();
        PairInt one = new PairInt(1,2);
        PairInt two = new PairInt(1,3);
        PairInt three = new PairInt(2,3);
        PairInt four = new PairInt(3,4);
        PairInt five = new PairInt(4,5);
        inputList.add(one);
        inputList.add(two);
        inputList.add(three);
        inputList.add(four);
        inputList.add(five);

        //criticalRoad.criticalConnections(5,5,inputList);
        System.out.println("dd : " +
                criticalRoad.criticalConnections(5,5,inputList));
    }
}
