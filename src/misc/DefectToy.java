package misc;

class DefectToy {

    public static int position(int n, int sp, int t) {

        int c;

        if (t > n) {
             c = t - n + Math.abs(sp - 1);
        } else if (t < n) {
            c = sp + t - 1;
        } else {
            c = sp;
        }

        if (c == n) {
            return n;
        }

        return c % n;
    }

    public static void main(String[] args) {

        int p1 = position(5, 5, 1);
        System.out.println("p1 = " + p1);

    }
}
