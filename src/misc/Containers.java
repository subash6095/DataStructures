package misc;

public class Containers {

    /**
     *  6, 2, 2
     *
     *  b = 3
     *
     *  exc = 3/2 = 1
     *  rem = 3%2 = 1
     *
     *  newC = 1 + 1
     */

    private static int containers(int budget, int cost, int m) {

        int brought = budget / cost;

        int exchange = brought / m;

        int res = brought + exchange;

        int newC = brought % m + exchange;

        while (newC >= m) {
            res = res + 1;
            newC = newC - m;
        }
        System.out.println("budget = " + budget + ", cost = " + cost + ", m = " + m + ", containers = " + res);
        return res;
    }

    public static void main(String[] args) {
        containers(4, 1, 2);
        containers(10, 2, 5);
        containers(12, 4, 4);
        containers(6, 2, 2);
    }
}
