package problemSolving.dp;

public class EggDropping {

    private int noOfAttempts(int floors, int eggs) {
        int[][] T = new int[eggs+1][floors+1];
        //Initialization
        for (int i = 0; i < floors; i++) {
            T[1][i] = i;
        }
        for (int e = 2; e <= eggs ; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f ; k++) {
                    int attempts = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if (attempts < T[e][f]) {
                        T[e][f] = attempts;
                    }
                }
            }
        }
        return T[eggs][floors];
    }
}
