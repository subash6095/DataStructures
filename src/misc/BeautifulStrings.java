package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulStrings {

    static void printAllKLength(char[] set, List<String> list, int k) {
        int n = set.length;
        printAllKLengthRec(set, list, "", n, k);
    }

    static void printAllKLengthRec(char[] set, List<String> list, String prefix, int n, int k) {
        if (k == 0) {
            if (lexicographicallySorted(prefix)) {
                list.add(prefix);
            }
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, list, newPrefix, n, k - 1);
        }
    }

    static boolean lexicographicallySorted(String s)
    {
        int n = s.length();
        char[] c = s.toCharArray();

        Arrays.sort(c);

        for (int i = 0; i < n; i++)
            if (c[i] != s.charAt(i))
                return false;

        return true;
    }

    public static void main(String[] args) {
        char[] vowels = {'a', 'b'};
        List<String> list = new ArrayList<>();
        printAllKLength(vowels, list, 3);

        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());
    }
}
