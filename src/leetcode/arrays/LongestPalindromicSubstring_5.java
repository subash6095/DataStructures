package leetcode.arrays;

import java.util.Arrays;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        //String input = "cbbd";
        //String input = "babad";
        String input = "abcda";

        System.out.println("->" + input.substring(0, 3));
        System.out.println("Result : " + longestPalindrome(input));
    }

    public static String longestPalindrome(String s) {

        if (s != null && s.length() == 0)
            return "";
        s = s.trim();
        char[] input = s.toCharArray();
        int n = input.length;
        int[][] LP = new int[n][n];

        for (int i = 0; i < n; i++) {
            LP[i][i] = 1;
        }

        for (int sublen = 2; sublen <= n; sublen++) {
            for (int i = 0; i <= LP.length - sublen; i++) {
                int j = i + sublen - 1;
                if (input[i] == input[j] && sublen == 2) {
                    LP[i][j] = 2;
                } else if (input[i] == input[j]) {
                    LP[i][j] = LP[i + 1][j - 1] + 2;
                } else
                    LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
            }
        }
        for (int i = 0; i < LP.length; i++)
            System.out.println("->" + Arrays.toString(LP[i]));

        int longest = LP[0][LP.length - 1];
        int index = 0;
        for (int i = 0; i < LP.length; i++) {
            if (LP[0][i] == longest) {
                index = i;
                break;
            }
        }
        System.out.println("Longest : " + longest + "  Index : " + index);
        return s.substring((index + 1) - longest, index + 1);
    }
}

