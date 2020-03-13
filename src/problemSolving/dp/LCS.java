package problemSolving.dp;

public class LCS {

    private static int lcs(char[] str1, char[] str2){
        int[][] res = new int[str1.length + 1][str2.length + 1];
        for(int i=1; i < res.length; i++){
            for(int j=1; j < res[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }
                else {
                    res[i][j] = Math.max(res[i][j-1],res[i-1][j]);
                }
            }
        }
        return res[str1.length][str2.length];
    }

    public static void main(String[] args) {
        int lcs = lcs("abcdaf".toCharArray(), "acbcf".toCharArray());
        System.out.println("lcs = " + lcs);
    }
}
