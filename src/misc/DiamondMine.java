package misc;

import java.util.Arrays;

public class DiamondMine {
    public int cherryPickup(int[][] input) {
        int n = input.length;
        int[][][] dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = input[0][0];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == -1)
                    continue;
                for (int k = 0; k < n; k++) {
                    int l = i + j - k;
                    if (l < 0 || l >= n || input[k][l] == -1)
                        continue;

                    int max = Integer.MIN_VALUE;
                    //x1, y1-1, x2, y2-1
                    if (checkValid(i, j - 1, k, n, input))
                        max = Math.max(max, dp[i][j - 1][k]);

                    //x1-1, y1, x2, y2-1
                    if (checkValid(i - 1, j, k, n, input))
                        max = Math.max(max, dp[i - 1][j][k]);

                    //x1, y1-1, x2-1, y2
                    if (checkValid(i, j - 1, k - 1, n, input))
                        max = Math.max(max, dp[i][j - 1][k - 1]);

                    //x1-1, y1, x2-1, y2
                    if (checkValid(i - 1, j, k - 1, n, input))
                        max = Math.max(max, dp[i - 1][j][k - 1]);

                    if (max == Integer.MIN_VALUE)
                        continue;

                    int v = input[i][j] + input[k][l];
                    if (i == k)
                        v /= 2;
                    dp[i][j][k] = max + v;
                }
            }
        }

        return dp[n - 1][n - 1][n - 1] == Integer.MIN_VALUE ? 0 : dp[n - 1][n - 1][n - 1];
    }

    boolean checkValid(int i, int j, int k, int n, int[][] input) {
        int l = i + j - k;
        return i >= 0 && i < n
                && j >= 0 && j < n
                && k >= 0 && k < n
                && l >= 0 && l < n
                && input[i][j] != -1
                && input[k][l] != -1;
    }

    public static void main(String[] args) {
        DiamondMine diamondMine = new DiamondMine();
        //int[][] input = {{0,1,1},{1,0,1},{1,1,1}};
        int[][] input = {{0, 1, 1}, {1, 0, -1}, {1, 1, -1}};
        diamondMine.cherryPickup(input);
        System.out.println("misc.DiamondMine.main : " + diamondMine.cherryPickup(input));
    }
}