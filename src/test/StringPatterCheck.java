package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPatterCheck {
    /*
    Input: pat: "xyz",   txt: "abxzyczyx"
    Output: xzy, zyx
     */
    public static Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        String text = "abxzyczyx";
        String pat = "xyz";
        //printPermutation(pat,"");
        permute(pat, 0, pat.length() - 1);
        search(text, pat);
    }

    public static void search(String input, String pattern) {
        System.out.println("Hash Set : " + hashSet);
        for (String str : hashSet) {
            if (input.contains(str)) {
                System.out.println("->" + str);
            }
        }
    }

    static void printPermutation(String str, String ans) {
        if (str.length() == 0) {
            //System.out.print(ans + " ");
            hashSet.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            System.out.println("::> " + ros);
            printPermutation(ros, ans + ch);
        }
    }

    public static void permute(String str, int l, int r) {
        if (l == r) {
            hashSet.add(str);
            return;
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, i, l);
            permute(str, l + 1, r);
            str = swap(str, i, l);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] tempArray = str.toCharArray();
        char temp = tempArray[i];
        tempArray[i] = tempArray[j];
        tempArray[j] = temp;
        String result = String.valueOf(tempArray);
        return result;
    }

    /*public static Set<String> permutateStrings(String pattern) {
        char[] pat = pattern.toCharArray();
        int size = pat.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                char temp = pat[i];
                pat[i] = pat[j];
                pat[j] = temp;
            }
        }
        return set;
    }*/


}
