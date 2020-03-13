package problemSolving.dp;

public class LIS {

    private static void lis(int[] arr) {
        int[] T = new int[arr.length];
        int[] sol = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            T[i] = 1;
            sol[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if ((T[j]+1) > T[i]) {
                        T[i] = T[j] + 1;
                        sol[i] = j;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        //lets print the actual solution
        int t;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = sol[t];
        }while(t != newT);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        lis(arr);
    }
}
