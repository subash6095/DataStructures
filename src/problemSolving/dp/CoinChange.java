package problemSolving.dp;

public class CoinChange {

    public static int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
                if (i >= coins[j]) {
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        return T[total];
    }

    public static void main(String[] args) {
        int [] coins = {1,2,5,10,20,50,100};
        int i = minimumCoinBottomUp(84, coins);

        System.out.println("i = " + i);
    }
}
