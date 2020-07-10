package leetcode.arrays;

import java.util.Arrays;

public class CoinChange_322 {
    public static void main(String[] args) {
        /*int[] coins = {1,2,3};
        int amount = 5;*/
        int[] coins = {2};
        int amount = 3;
        System.out.println("Result : " + coinChange1(coins, amount));
    }

    public static int coinChangeUsing1DArray(int[] coins, int amount) {
        int[] coinReq = new int[amount + 1];
        coinReq[0] = 0;

        for (int amt = 1; amt <= amount; amt++)
            coinReq[amt] = Integer.MAX_VALUE;

        for (int amt = 1; amt <= amount; amt++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) {
                    int sub_res = coinReq[amt - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < coinReq[amt])
                        coinReq[amt] = sub_res + 1;
                    //coinReq[amt] = Math.min(sub_res + 1, coinReq[amt]);
                }
            }
        }
        return coinReq[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;

        if (amount <= 0)
            return 0;

        int coinReq[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            coinReq[i] = Integer.MAX_VALUE;
        }

        for (int amt = 1; amt <= amount; amt++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= amt) {
                    int sub = coinReq[amt - coins[i]];
                    if (sub != Integer.MAX_VALUE)
                        coinReq[amt] = Math.min(sub + 1, coinReq[amt]);
                }
            }
        }
        return coinReq[amount] == Integer.MAX_VALUE ? -1 : coinReq[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int sol[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            //sol[i][0] = 1;
            sol[i][0] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            sol[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    //sol[i][j] = sol[i - 1][j] + sol[i][j - coins[i - 1]];
                    sol[i][j] = Math.min(sol[i - 1][j], 1 + sol[i][j - coins[i - 1]]);
                } else {
                    sol[i][j] = sol[i - 1][j];
                }
            }
        }

        for (int i = 0; i < sol.length; i++) {
            System.out.println(Arrays.toString(sol[i]));
        }
        return 0;
    }

}

