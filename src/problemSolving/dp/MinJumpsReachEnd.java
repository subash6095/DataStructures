package problemSolving.dp;

public class MinJumpsReachEnd {

    private int minJumpsToReachEnd(int [] arr, int[] result) {
        int[] jump = new int[arr.length];
        jump[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            jump[i] = Integer.MAX_VALUE - 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (jump[i] > jump[j] + 1) {
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        return jump[jump.length - 1];
    }
}
